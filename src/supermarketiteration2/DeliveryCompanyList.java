/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketiteration2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Connor
 */
public class DeliveryCompanyList {
    
ArrayList<DeliveryCompany>DeliveryCompanies;    
String Filename;


public DeliveryCompanyList(){

DeliveryCompanies=new ArrayList<>();
Filename = "DeliveryCompanyList.txt";

}

public void display (javax.swing.JTextArea src){

src.setText(null);    
for(DeliveryCompany deliverycomp: DeliveryCompanies)
{
 deliverycomp.display(true,src);  
 src.append("\n");
 
}
System.out.print(DeliveryCompanies.toString());
}

public void add(DeliveryCompany src) throws IOException{

    //do not combine methods in the same action 
    DeliveryCompanies.add (src);
}

public void remove(DeliveryCompany src){
    
    DeliveryCompanies.remove (src);
}

public DeliveryCompany Find(String deliveryCompanyName){   
    
    DeliveryCompany AssociatedDeliveryCompany = null;
    
    for( DeliveryCompany Company:this.DeliveryCompanies)
        if(deliveryCompanyName.equalsIgnoreCase(Company.getBusinessName())){       
        AssociatedDeliveryCompany=Company;
        }    
    return AssociatedDeliveryCompany;
    
    
}

public void saveToFile(boolean append) throws IOException{

  

    try{
    FileWriter aWriter = new FileWriter(Filename,false);
    }
    catch(IOException ioe){
    System.out.println("Failed to wipe file");
    }
   
    for(DeliveryCompany deliverycomp: DeliveryCompanies)

    {try{
    
    FileWriter aWriter = new FileWriter(Filename,true);
    aWriter.write(System.getProperty("line.separator"));
    aWriter.write(deliverycomp.toString(false));
    

    aWriter.close();
    }

catch(IOException ioe){
System.out.println("Failed to save product list");
}}
}

public void loadFromFile(){

String record;

FileReader reader;
try{
    reader = new FileReader(Filename);
    BufferedReader bin = new BufferedReader(reader);
    record = new String();
    
    while ((record = bin.readLine())!=null)
       {    
           
           DeliveryCompany aDeliveryCompany = new DeliveryCompany();
              
      aDeliveryCompany.edit(
                     /*String Business name*/bin.readLine(),
                     /*String Contact number*/bin.readLine(),
                     /*Int Deliverytime*/Integer.valueOf(bin.readLine()),
            new IAddress(Integer.valueOf(bin.readLine()),bin.readLine(),bin.readLine(),bin.readLine(),bin.readLine(),bin.readLine()));
                 
       this.add(aDeliveryCompany);
       }
    
    bin.close();
    bin =null;
    
    }

catch(IOException ioe){
        System.out.print("Failed to read file - error occured in class branch");
   
}


}
 
public String calculateETA(int deliveryTime) throws ParseException{

SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
	//Getting current date
	Calendar cal = Calendar.getInstance();
	//Displaying current date in the desired format
	System.out.println("Current Date: "+sdf.format(cal.getTime()));
	//Number of Days to add
         cal.add(Calendar.DAY_OF_MONTH, deliveryTime);  
	//Date after adding the days to the current date
	String ETA = sdf.format(cal.getTime());  
        return ETA;        
}

}