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
public class BookProduct extends Product{
    
private String ISBN;
private String Author;

public BookProduct(){


ISBN = "";
Author = "";
}  


public void edit(String category, int id, String name, String supplier,String deliveryCompany,   double price,double unitCost, int quantity,int weight,String weightCategory,String dateOfLastOrderPlacement, String imageName, int minstock, int maxstock,String isbn, String author) throws ParseException{

super.edit(category,id, name, supplier, deliveryCompany,  price, unitCost, quantity, weight,weightCategory, dateOfLastOrderPlacement, imageName, minstock, maxstock);
this.setISBN(isbn);
this.setAuthor(author);

}


public void display(Boolean s,javax.swing.JTextArea x){

super.display(s, x);


x.append("ISBN : "+ ISBN +"\n");
x.append("Author : "+ Author +"\n");
x.append("\n");
}  




public BookProduct loadFromFile(BookProduct bProduct, BufferedReader bin) throws IOException, ParseException{


//BookProduct bProduct = new BookProduct();

super.loadFromFile(bProduct,bin);

this.setISBN(bin.readLine());
this.setAuthor(bin.readLine());

return bProduct;

}

@Override
public void saveToFile(FileWriter aWriter) throws IOException, ParseException{

super.saveToFile(aWriter);

aWriter.write(getISBN()+"\n");
aWriter.write(getAuthor());
//aWriter.write(System.getProperty("line.separator"));
//aWriter.write(System.getProperty("line.separator"));

}

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }




}
