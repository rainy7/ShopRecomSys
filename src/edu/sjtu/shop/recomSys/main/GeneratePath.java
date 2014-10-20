package edu.sjtu.shop.recomSys.main;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import edu.sjtu.shop.recomSys.dao.CategoryDAO;
import edu.sjtu.shop.recomSys.dao.PathDAO;
import edu.sjtu.shop.recomSys.dao.PathMonthDAO;
import edu.sjtu.shop.recomSys.dao.TipsAllDAO;
import edu.sjtu.shop.recomSys.dao.UsersAllDAO;
import edu.sjtu.shop.recomSys.pojo.Category;
import edu.sjtu.shop.recomSys.pojo.Path;
import edu.sjtu.shop.recomSys.pojo.PathMonth;
import edu.sjtu.shop.recomSys.pojo.Poi;
import edu.sjtu.shop.recomSys.pojo.PoiMonth;
import edu.sjtu.shop.recomSys.pojo.TipsAll;
import edu.sjtu.shop.recomSys.pojo.UsersAll;

public class GeneratePath {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
////		CategoryDAO categoryDAO = new CategoryDAO();
////		List<Category> categories = categoryDAO.findAll();
//		UsersAllDAO usersAllDAO = new UsersAllDAO();
//		TipsAllDAO tipsAllDAO = new TipsAllDAO();
//		PathDAO pathDAO = new PathDAO();
//		for(long i=53523; i<12000000l; i+=10000){
//			List<UsersAll> users = usersAllDAO.findByRange(i, i+10000);
//			if(users == null){
//				continue;
//			}
//			for(UsersAll user : users){
//				if(user != null){
//					List<TipsAll> tipsAll = tipsAllDAO.findByUserId(user.getUserId());
//					HashMap<String, ArrayList<TipsAll>> map = new HashMap<String, ArrayList<TipsAll>>();
//					for(int j=0; j<tipsAll.size(); j++){
//						Long tsLong = Long.parseLong(tipsAll.get(j).getCreatedTime());
//						Date date = new Date(tsLong*1000);
////						System.out.println(date.toString());
//						String key = date.toString();
//						if(map.containsKey(key)){
//							map.get(key).add(tipsAll.get(j));
//						}else{
//							ArrayList<TipsAll> tips = new ArrayList<TipsAll>();
//							tips.add(tipsAll.get(j));
//							map.put(key, tips);
//						}
//					}
////					System.out.println("---------------------------------");
//					Set<String> keys = map.keySet();
//					Iterator<String> iterator = keys.iterator();
//					while(iterator.hasNext()){
//						String key = iterator.next();
//						Path path = new Path();
//						path.setUsersAll(user);
//						path.setLevelId(4);
//						try {
//							path.setDatetime(new SimpleDateFormat("yyyyMMdd").parse(key));
//						} catch (ParseException e) {
//							e.printStackTrace();
//						}
//						Set<Poi> pois = new HashSet<Poi>();
//						for(TipsAll tip : map.get(key)){
//							Poi poi = new Poi();
//							poi.setDatetime(tip.getCreatedTime());
////							System.out.println(poi.getDatetime());
//							poi.setLevelId(4);
//							poi.setPath(path);
//							poi.setPointId(tip.getVenueId());
//							pois.add(poi);
//						}
//						path.setPois(pois);
//						pathDAO.save(path);
//					}
//					System.out.println(user.getUserId());
//				}
//			}
////			UsersAll user = usersAllDAO.findById(i);
//		}
//		test();
		generateMonthPath();
	}
	
	public static void test() {
		try {
			UsersAllDAO usersAllDAO = new UsersAllDAO();
			PathMonthDAO pathMonthDAO = new PathMonthDAO();
			PathMonth pathMonth = new PathMonth();
			PoiMonth poiMonth = new PoiMonth(null, pathMonth, "aaaa", 4, "20140710");
			Set<PoiMonth> pois = new HashSet<PoiMonth>();
			pois.add(poiMonth);
			pathMonth.setPathId(null);
			pathMonth.setLevelId(4);
			pathMonth.setDatetime(new SimpleDateFormat("yyyyMMdd").parse("20140710"));
			pathMonth.setUsersAll(usersAllDAO.findById(1l));
			pathMonth.setPoiMonths(pois);
			pathMonthDAO.save(pathMonth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void generateMonthPath(){
		UsersAllDAO usersAllDAO = new UsersAllDAO();
		PathDAO pathDAO = new PathDAO();
		PathMonthDAO pathMonthDAO = new PathMonthDAO();
		for(long i=319069; i<12000000; i+=10000){
			List<UsersAll> users = usersAllDAO.findByRange(i, i+10000);
			if(users == null){
				continue;
			}
			for(UsersAll user : users){
				if(user != null){
					List<Path> paths = pathDAO.findByUserId(user.getUserId());
					if(paths == null || paths.isEmpty()){
						continue;
					}
					HashMap<String, ArrayList<Path>> map = new HashMap<String, ArrayList<Path>>();
					for(int j=0; j<paths.size(); j++){
						
						//set PoiNumber of path
//						paths.get(j).setPoiNumber(paths.get(j).getPois().size());
//						pathDAO.attachDirty(paths.get(j));
						
						
						String key = new SimpleDateFormat("yyyyMM").format(paths.get(j).getDatetime());
//						String key = date.toString();
						if(map.containsKey(key)){
							map.get(key).add(paths.get(j));
						}else{
							ArrayList<Path> pathList = new ArrayList<Path>();
							pathList.add(paths.get(j));
							map.put(key, pathList);
						}
					}
//					System.out.println("---------------------------------");
					Set<String> keys = map.keySet();
					Iterator<String> iterator = keys.iterator();
					int k=0;
					while(iterator.hasNext()){
						String key = iterator.next();
						PathMonth pathMonth = new PathMonth();
						pathMonth.setUsersAll(user);
						pathMonth.setLevelId(4);
						try {
							pathMonth.setDatetime(new SimpleDateFormat("yyyyMM").parse(key));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						Set<PoiMonth> poiMonths = new HashSet<PoiMonth>();
						for(Path path : map.get(key)){
							for(Poi poi : (Set<Poi>) path.getPois()){
								PoiMonth poiMonth = new PoiMonth(null, pathMonth, poi.getPointId(), poi.getLevelId(), poi.getDatetime());
								poiMonths.add(poiMonth);
							}
						}
						pathMonth.setPoiMonths(poiMonths);
						pathMonth.setPoiNumber(poiMonths.size());
//						System.out.println(++k);
						pathMonthDAO.save(pathMonth);
					}
					System.out.println(user.getUserId());
				}
			}
		}
	}
	
	public static void setPoiNumber(){
		UsersAllDAO usersAllDAO = new UsersAllDAO();
		PathDAO pathDAO = new PathDAO();
		PathMonthDAO pathMonthDAO = new PathMonthDAO();
		for(long i=1; i<120; i+=10000){
			List<UsersAll> users = usersAllDAO.findByRange(i, i+100);
			if(users == null){
				continue;
			}
			for(UsersAll user : users){
				if(user != null){
					List<Path> paths = pathDAO.findByUserId(user.getUserId());
					List<PathMonth> pathMonths = pathMonthDAO.findByUserId(user.getUserId());
					if(paths == null || paths.isEmpty()){
						continue;
					}
//					for(Path path : paths){
//						path.setPoiNumber(path.getPois().size());
//						pathDAO.attachDirty(path);
//					}
					for(PathMonth pathMonth : pathMonths){
						HashSet<PoiMonth> poiSet = new HashSet<PoiMonth>( pathMonth.getPoiMonths());
						if(poiSet.size()> 10){
							System.out.println(String.valueOf(poiSet.size())+" : " + pathMonth.getPathId());
						}
//						pathMonth.setPoiNumber(poiSet.size());
//						pathMonthDAO.attachDirty(pathMonth);
					}
				}
			}
		}
	}
}
