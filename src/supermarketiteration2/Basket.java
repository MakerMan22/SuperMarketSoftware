/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketiteration2;

import java.io.IOException;
import java.text.ParseException;

/**
 *
 * @author Connor
 */
public class Basket extends ProductList{
 private Double totalOrderCost = 0.0;
    
public Basket(){   
}

    
public void add(Product src) throws IOException{
    super.add (src);

}  

public void remove(Product src){
Products.remove (src);

}

public void saveToFile(Boolean append, String Filename) throws IOException, ParseException{

    super.saveToFile (append, Filename);

}  

public void updateTotalOrderCost(){
  
        totalOrderCost = 0.0;
    for(Product product: this.Products){
        totalOrderCost = totalOrderCost + (product.getPriceWithVAT()*product.getQuantity());
  }


}

public void displayTotalOrderCost(javax.swing.JTextField textField){

    this.updateTotalOrderCost();
    textField.setText(String.valueOf(totalOrderCost));
}




public void display (javax.swing.JTextArea src){
    //THIS OVERRIDES THE PARENT CLASS DISPLAY METHOD AS IT ONLY DISPLAYS CERTAIN VALUES, 
    src.setText(null);    
    for(Product product: this.Products){
        src.append("Name: "+product.getName()+"\n");
        src.append("Category: "+product.getCategory()+"\n");
        src.append("Price: "+String.valueOf(product.getPriceWithVAT())+"\n");
        src.append("Quantity :"+String.valueOf(product.getQuantity())+"\n");       
        src.append("Total cost :"+String.valueOf(product.getQuantity()*product.getPriceWithVAT())+"\n");       
        src.append("\n");
    }
}



}
