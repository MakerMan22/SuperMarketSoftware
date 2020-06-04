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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Connor
 */
public class FoodProduct extends Product{
 private int ShelfLife;    
 private Date ExpiryDate;
 private SimpleDateFormat formatter;
    
    public FoodProduct(){
    
    ShelfLife = 0 ;    
    ExpiryDate = new Date();
  //  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");   
    }
   
    public void edit(String Category, int id, String Name, String supplier, String deliveryCompany, double price, double unitCost, int quantity, int weight, String weightCategory, String dateOfLastOrderPlacement, String imageName, int minstock, int maxstock, int shelfLife) throws ParseException {

        super.edit(Category, id, Name, supplier, deliveryCompany, price, unitCost, quantity, weight, weightCategory, dateOfLastOrderPlacement, imageName, minstock, maxstock);

        this.setShelfLife(shelfLife);
        this.setExpiryDate(this.calculateExpiryDate(DateOfLastOrderPlacement, ShelfLife));
    }
    
public Date calculateExpiryDate(Date userinput, int shelfLife) throws ParseException{
   
    
    String date ;
    Calendar cal = Calendar.getInstance(); 
    cal.setTime(userinput);    
    SimpleDateFormat x  = new SimpleDateFormat("dd/MM/yy");
    cal.add(Calendar.DATE,shelfLife);    
    date = x.format(cal.getTime());    
    Date output  = new SimpleDateFormat("dd/MM/yy").parse(date);    
    return output;
}
public void display(Boolean TrueAllProductsFalseOneProduct,javax.swing.JTextArea src){

super.display(TrueAllProductsFalseOneProduct, src);

src.append("Shelf Life: "+ this.getShelfLife()+"\n");
src.append("Expiry Date: "+ simpledateformat.format(this.getExpiryDate()));
src.append("\n");
src.append("\n");

}  


public FoodProduct loadFromFile(FoodProduct fProduct, BufferedReader bin) throws IOException, ParseException{


// FoodProduct fProduct = new FoodProduct();

super.loadFromFile(fProduct,bin);

fProduct.setShelfLife(Integer.valueOf(bin.readLine()));
//fProduct.setExpiryDate((bin.readLine()));

return fProduct;

}


@Override
public void saveToFile(FileWriter aWriter) throws IOException, ParseException{

super.saveToFile(aWriter);

aWriter.write(String.valueOf(this.getShelfLife()));
//aWriter.write(System.getProperty("line.separator"));
//aWriter.write(System.getProperty("line.separator"));
//aWriter.write(this.dateToString(this.getExpiryDate()));
   
    }



    public int getShelfLife() {
        return ShelfLife;
    }

    public void setShelfLife(int ShelfLife) {
        this.ShelfLife = ShelfLife;
    }

    public Date getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(Date ExpiryDate) {
        this.ExpiryDate = ExpiryDate;
    }

   



}

