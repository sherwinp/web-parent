package org.techlyric;

public class PlaceDTO {
    String indx;
    
    public PlaceDTO(){}
    
    public PlaceDTO(String indx){
	this.indx = indx;
    }
    public String getIndx(){
	return indx;
    }
    public void setIndx(String indx){
	this.indx = indx;	
    }
}
