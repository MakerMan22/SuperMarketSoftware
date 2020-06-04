/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketiteration2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Connor
 */
public class DeliveryCompany {
 private String BusinessName;   
 private String ContactNumber;   
 private IAddress Address;
 private Integer DeliveryTime;
    
    
public DeliveryCompany(){

    this.edit(BusinessName, ContactNumber,DeliveryTime, Address);
    
}


public void edit(String strbusinessname, String strcontactno,Integer intdeliverytime, IAddress srcaddress){
 
 BusinessName= strbusinessname;
 ContactNumber= strcontactno;
 DeliveryTime = intdeliverytime;
 Address= srcaddress;
 
 
 
 }

public void display(Boolean TrueShowAllFalseShowOne,javax.swing.JTextArea src){

 if(TrueShowAllFalseShowOne == true)  // will append all customers as it runs through the list  
    
    {src.append(this.toString(true));
     src.append("\n");
    
    }
 else//False
 
    {src.setText(this.toString(true)); // will clear text area and only show what has been selected 
     src.append("\n");

    }


}

public String toString(Boolean DisplayingtoGUI){
     
    
    if(DisplayingtoGUI == true)
    { 
      //  String customersAddress = Homeaddress.toString(true);
        
        return     
        "Business Name: "+ BusinessName+"\n"+
        "Contact No: "+ ContactNumber+"\n"+
        "Delivery Time: "+DeliveryTime+"\n"+
         Address.toString(true);
 
    }
    else //We are saving to file
    {
        return
        BusinessName+"\n"+
        ContactNumber+"\n"+
        DeliveryTime+"\n"+
        Address.toString(false); 
        
  
    }
             
}

public String calculateExpiryDate(String userinput, int shelfLife) throws ParseException{

    String date = userinput;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy"); 
    Calendar cal = Calendar.getInstance();
    cal.setTime(formatter.parse(date));
    cal.add(Calendar.DATE,shelfLife);
    date = formatter.format(cal.getTime());
    return date;
}



public String getBusinessName() {
    return BusinessName;
}

public void setBusinessName(String BusinessName) {
    this.BusinessName = BusinessName;
}

public String getContactNumber() {
    return ContactNumber;
}

public void setContactNumber(String ContactNumber) {
    this.ContactNumber = ContactNumber;
}

public IAddress getAddress() {
    return Address;
}

public void setAddress(IAddress Address) {
    this.Address = Address;
}

public Integer getDeliveryTime() {
    return DeliveryTime;
}

public void setDeliveryTime(Integer DeliveryTime) {
        this.DeliveryTime = DeliveryTime;
    }
}

