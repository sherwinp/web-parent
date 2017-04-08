package org.techlyric.dto;

public class PlaceDTO {
    String indx;
    String tselector;
    
    public PlaceDTO(){}
    
    public PlaceDTO(String indx){
	this.indx = indx;
    }
    public PlaceDTO(String indx, String selector){
	this.indx = indx;
	this.tselector = selector;
    }
    public String getIndx(){
	return indx;
    }
    public void setIndx(String indx){
	this.indx = indx;	
    }
    public String getTselector(){
	return tselector;
    }
    public void setTselector(String selector){
	this.tselector = selector;	
    }
}
