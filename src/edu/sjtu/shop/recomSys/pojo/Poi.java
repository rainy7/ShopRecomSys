package edu.sjtu.shop.recomSys.pojo;

import java.math.BigDecimal;
import java.util.Date;


/**
 * Poi entity. @author MyEclipse Persistence Tools
 */

public class Poi  implements java.io.Serializable {


    // Fields    

     private Long id;
     private Path path;
     private String pointId;
     private Integer levelId;
     private String datetime;


    // Constructors

    /** default constructor */
    public Poi() {
    }

    
    /** full constructor */
    public Poi(Long id, Path path, String pointId, Integer levelId, String datetime) {
        this.id = id;
        this.path = path;
        this.pointId = pointId;
        this.levelId = levelId;
        this.datetime = datetime;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Path getPath() {
        return this.path;
    }
    
    public void setPath(Path path) {
        this.path = path;
    }

    public String getPointId() {
        return this.pointId;
    }
    
    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public Integer getLevelId() {
        return this.levelId;
    }
    
    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getDatetime() {
        return this.datetime;
    }
    
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
   








}