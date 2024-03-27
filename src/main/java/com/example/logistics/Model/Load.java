package com.example.logistics.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "load")
public class Load {

    @Id
    @GeneratedValue
    private long loadId;
    private String loadingPoint;
    private String unloadingPoint;
    private String productType;
    private String truckType;
    private String noOfTrucks;
    private String weight;
    private String comment;
    private String shipperId;
@JsonFormat(pattern = "dd-MM-yyyy",shape = JsonFormat.Shape.STRING)
    private LocalDate date;

    public long getLoadId(){
        return loadId;
    }
    public void setLoadId(long loadId){
        this.loadId=loadId;
    }
    public String getLoadingPoint(){
        return loadingPoint;
    }
    public void setLoadingPoint(String loadingPoint){
        this.loadingPoint=loadingPoint;
    }
    public String getUnloadingPoint(){
        return unloadingPoint;
    }
    public void setUnloadingPoint(String unloadingPoint){
        this.unloadingPoint=unloadingPoint;
    }
    public String getProductType(){
        return productType;
    }
    public void setProductType(String productType){
        this.productType=productType;
    }
    public String getTruckType(){
        return truckType;
    }
    public void setTruckType(String truckType){
        this.truckType=truckType;
    }
    public String getNoOfTrucks(){
        return noOfTrucks;
    }
    public void setNoOfTrucks(String noOfTrucks){
        this.noOfTrucks=noOfTrucks;
    }
    public String getWeight(){
        return weight;
    }
    public void setWeight(String weight){
        this.weight=weight;
    }
    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment=comment;
    }
    public String getShipperId(){
        return shipperId;
    }
    public void setShipperId(String shipperId){
        this.shipperId=shipperId;
    }
    public LocalDate getDate(){
        return date;
    }
    public void setDate(LocalDate date){
        this.date=date;
    }

}
