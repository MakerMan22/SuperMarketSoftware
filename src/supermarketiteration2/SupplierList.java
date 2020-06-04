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
import java.util.ArrayList;

/**
 *
 * @author Connor
 */
public class SupplierList {
    
//ArrayList<SupplyChainMember>SupplyChainMembers;    
ArrayList<Supplier>Suppliers;    
String Filename;


public SupplierList(){

Suppliers=new ArrayList<>();
Filename = "SupplierList.txt";

}

public void display (javax.swing.JTextArea src){

src.setText(null);    
for(int i = 0; i <Suppliers.size();i++)
{
 //src.append("Branch number: " + i + "\n");
 Suppliers.get(i).Display(true,src);  
 src.append("\n");
 
}
System.out.print(Suppliers.toString());
}

public void add(Supplier src) throws IOException{

    //do not combine methods in the same action 
    Suppliers.add (src);
}

public void remove(Supplier src){
    
    Suppliers.remove (src);
}

public Supplier Find(String supplierName){

    
    Supplier AssociatedSupplier = null;
    
    for( int i=0; i<Suppliers.size();i++)
        
       
        if(supplierName.equalsIgnoreCase(Suppliers.get(i).BusinessName)){
        
        AssociatedSupplier=Suppliers.get(i);
        break;
        }
      
    return AssociatedSupplier;
    
    
}

public void saveToFile(boolean append) throws IOException{

  

    try{
    FileWriter aWriter = new FileWriter(Filename,false);
    }
    catch(IOException ioe){
    System.out.println("Failed to wipe file");
    }
   
    for(int i = 0; i <Suppliers.size();i++)

    {try{
    
    FileWriter aWriter = new FileWriter(Filename,true);
    aWriter.write(System.getProperty("line.separator"));
    aWriter.write(Suppliers.get(i).toString(false));
    

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
           
           Supplier aSupplier = new Supplier();
              
      aSupplier.Edit(
                     /*String Business name*/bin.readLine(),
                     /*String Contact number*/bin.readLine(),
                      new IAddress(
                              Integer.valueOf(bin.readLine()),
                              bin.readLine(),
                              bin.readLine(),
                              bin.readLine(),
                              bin.readLine(),
                              bin.readLine()));
       
       add(aSupplier);
       }
    
    bin.close();
    bin =null;
    
    }

catch(IOException ioe){
        System.out.print("Failed to read file - error occured in class branch");
   
}


} 
}
