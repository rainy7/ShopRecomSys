package edu.sjtu.shop.recomSys.main;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import edu.sjtu.shop.recomSys.dao.CategoryDAO;
import edu.sjtu.shop.recomSys.dao.PathDAO;
import edu.sjtu.shop.recomSys.dao.TipsAllDAO;
import edu.sjtu.shop.recomSys.dao.UsersAllDAO;
import edu.sjtu.shop.recomSys.pojo.Category;
import edu.sjtu.shop.recomSys.pojo.Path;
import edu.sjtu.shop.recomSys.pojo.Poi;
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
		UsersAllDAO usersAllDAO = new UsersAllDAO();
		TipsAllDAO tipsAllDAO = new TipsAllDAO();
		PathDAO pathDAO = new PathDAO();
		for(long i=53523; i<12000000l; i+=10000){
			List<UsersAll> users = usersAllDAO.findByRange(i, i+10000);
			if(users == null){
				continue;
			}
			for(UsersAll user : users){
				if(user != null){
					List<TipsAll> tipsAll = tipsAllDAO.findByUserId(user.getUserId());
					HashMap<String, ArrayList<TipsAll>> map = new HashMap<String, ArrayList<TipsAll>>();
					for(int j=0; j<tipsAll.size(); j++){
						Long tsLong = Long.parseLong(tipsAll.get(j).getCreatedTime());
						Date date = new Date(tsLong*1000);
//						System.out.println(date.toString());
						String key = date.toString();
						if(map.containsKey(key)){
							map.get(key).add(tipsAll.get(j));
						}else{
							ArrayList<TipsAll> tips = new ArrayList<TipsAll>();
							tips.add(tipsAll.get(j));
							map.put(key, tips);
						}
					}
//					System.out.println("---------------------------------");
					Set<String> keys = map.keySet();
					Iterator<String> iterator = keys.iterator();
					while(iterator.hasNext()){
						String key = iterator.next();
						Path path = new Path();
						path.setUsersAll(user);
						path.setLevelId(4);
						try {
							path.setDatetime(new SimpleDateFormat("yyyyMMdd").parse(key));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						Set<Poi> pois = new HashSet<Poi>();
						for(TipsAll tip : map.get(key)){
							Poi poi = new Poi();
							poi.setDatetime(tip.getCreatedTime());
//							System.out.println(poi.getDatetime());
							poi.setLevelId(4);
							poi.setPath(path);
							poi.setPointId(tip.getVenueId());
							pois.add(poi);
						}
						path.setPois(pois);
						pathDAO.save(path);
					}
					System.out.println(user.getUserId());
				}
			}
//			UsersAll user = usersAllDAO.findById(i);
		}
//		test();
	}
	
	public static void test() {
		try {
			UsersAllDAO usersAllDAO = new UsersAllDAO();
			PathDAO pathDAO = new PathDAO();
			Path path = new Path();
			Poi poi = new Poi(null, path, "aaaa", 4, "20140710");
			Set<Poi> pois = new HashSet<Poi>();
			pois.add(poi);
			path.setPathId(null);
			path.setLevelId(4);
			path.setDatetime(new SimpleDateFormat("yyyyMMdd").parse("20140710"));
			path.setUsersAll(usersAllDAO.findById(1l));
			path.setPois(pois);
			pathDAO.save(path);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
