/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketiteration2;

/**
 *
 * @author Connor
 */
public class IAddress {
 
private int    BuildingNo;
private String Street;
private String Town;
private String Area;
private String Country;
private String Postcode;

public IAddress(){


this.edit(BuildingNo, Street, Town, Area, Country, Postcode );

}

public IAddress (Integer intbuildingno, String strstreet,String strtown,String strarea, String strcountry, String strpostcode){

this.edit(intbuildingno, strstreet, strtown, strarea, strcountry, strpostcode);
}

public void edit(Integer intbuildingno,String strstreet,String strtown, String strarea,String strcountry,String strpostcode){

Street = strstreet;
BuildingNo = intbuildingno;
Town = strtown;
Area =strarea;
Country = strcountry;
Postcode = strpostcode;

}

public void Display(javax.swing.JTextArea src){

    src.append(this.toString(true));

}

public String toString(Boolean DisplayingtoGUI){
     
    
    if(DisplayingtoGUI == true)
    {    
        return
        
        "Building Number: "+ BuildingNo +"\n"+
        "Street: "+ Street +"\n"+
        "City: "+ Town +"\n"+        
        "Area: "+ Area +"\n"+
        "Country: "+ Country +"\n"+
        "Postcode: "+ Postcode +"\n";
        
    }    
    else // We are saving to file. 
    {
        return
      
        BuildingNo +"\n"+
        Street +"\n"+
        Town +"\n"+
        Postcode +"\n"+
        Area +"\n"+
        Country+"\n";
    }
}



    public String getStreet() {
        return Street;
    }
    
    public void setStreet(String Street) {
        this.Street = Street;
    }
    
    public int getBuildingNo() {
        return BuildingNo;
    }
    
    public void setBuildingNo(int BuildingNo) {
        this.BuildingNo = BuildingNo;
    }
    
    public String getTown() {
        return Town;
    }
    
    public void setTown(String Town) {
        this.Town = Town;
    }
    
    public String getArea() {
        return Area;
    }
    
    public void setArea(String Area) {
        this.Area = Area;
    }
    
    public String getCountry() {
        return Country;
    }
    
    public void setCountry(String Country) {
        this.Country = Country;
    }
    
    public String getPostcode() {
        return Postcode;
    }
    
    public void setPostcode(String Postcode) {
        this.Postcode = Postcode;
    }
}
