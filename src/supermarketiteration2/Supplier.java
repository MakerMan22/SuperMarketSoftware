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
public class Supplier {
 String BusinessName;   
 String ContactNumber;   
 IAddress Address;   
    
    
public Supplier(){
  //  BusinessName = "";
    //ContactNumber = "";
    //Address = new IAddress();
    this.Edit(BusinessName, ContactNumber, Address);
    
}

public void Edit(String strbusinessname, String strcontactno, IAddress srcaddress){
 
 BusinessName= strbusinessname;
 ContactNumber= strcontactno;
 Address= srcaddress;
 
 }

public void Display(Boolean TrueAllSuppliersFalseOneSupplier,javax.swing.JTextArea src){

 if(TrueAllSuppliersFalseOneSupplier == true)  // will append all customers as it runs through the list  
    
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
         Address.toString(true);
 
    }
    else //We are saving to file
    {
        
        return
        BusinessName+"\n"+
        ContactNumber+"\n"+
        Address.toString(false);
    }
             
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
}
