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
public class KitchenProduct extends Product{
    

     private int guarunteeDuration;
    
    
    public KitchenProduct(){
   
    guarunteeDuration =0;
    
    }
    
    
 public void edit(String category,int id, String name, String supplier,String deliveryCompany,   double price,double unitCost, int quantity,int weight,String weightCategory,String dateOfLastOrderPlacement, String imageName, int minstock, int maxstock,int guarunteeduration) throws ParseException{

 super.edit(category, id, name, supplier, deliveryCompany,  price, unitCost, quantity, weight,weightCategory, dateOfLastOrderPlacement, imageName, minstock, maxstock);
 this.setGuarunteeDuration(guarunteeduration);
 }

 public void display(Boolean TrueAllProductsFalseOneProduct,javax.swing.JTextArea src){

super.display(TrueAllProductsFalseOneProduct, src);

src.append("Guaruntee Duration: "+ guarunteeDuration );
src.append("\n");
src.append("\n");
}  


public KitchenProduct loadFromFile(KitchenProduct kProduct, BufferedReader bin) throws IOException, ParseException{


super.loadFromFile(kProduct,bin);

kProduct.setGuarunteeDuration(Integer.valueOf(bin.readLine()));

return kProduct;

}

@Override
public void saveToFile(FileWriter aWriter) throws IOException, ParseException{

super.saveToFile(aWriter);

aWriter.write(String.valueOf(this.getGuarunteeDuration()));




}


     public int getGuarunteeDuration() {
        return guarunteeDuration;
    }

    public void setGuarunteeDuration(int guarunteeDuration) {
        this.guarunteeDuration = guarunteeDuration;
    }
    
    
    
}
