/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketiteration2;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

/**
 *
 * @author Connor
 */
public class ElectronicProduct extends KitchenProduct {
    
    
    private double Voltage ;
    
    
    public ElectronicProduct(){
        
        Voltage = 0.0;
           
    }
  
public void edit(String category, int id, String name, String supplier,String deliveryCompany, double price,double unitCost, int quantity,int weight,String weightCategory,String dateOfLastOrderPlacement, String imageName, Integer minstock, Integer maxstock, Integer guarunteeduration, Double voltage) throws ParseException{ 

 super.edit(category,id, name, supplier, deliveryCompany,  price, unitCost, quantity, weight,weightCategory, dateOfLastOrderPlacement, imageName, minstock, maxstock, guarunteeduration);
 this.setVoltage(voltage);
 }
    
 
public void display(Boolean TrueAllProductsFalseOneProduct,javax.swing.JTextArea src){

super.display(TrueAllProductsFalseOneProduct, src);

src.append("Voltage: "+ this.getVoltage() );
src.append("\n");
src.append("\n");
}    


public ElectronicProduct loadFromFile(ElectronicProduct eProduct, BufferedReader bin) throws IOException, ParseException{


super.loadFromFile(eProduct,bin);

eProduct.setVoltage(Double.valueOf(bin.readLine()));

return eProduct;

}

@Override
public void saveToFile(FileWriter aWriter) throws IOException, ParseException{


super.saveToFile(aWriter);
aWriter.write(System.getProperty("line.separator"));
aWriter.write(String.valueOf(this.getVoltage()));

}


    public double getVoltage() {
        return Voltage;
    }

    public void setVoltage(double Voltage) {
        this.Voltage = Voltage;
    }

  



    
}
