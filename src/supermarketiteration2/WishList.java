/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketiteration2;

import java.io.IOException;

/**
 *
 * @author Connor
 */
public class WishList extends ProductList{
    

public WishList(){

}

       
    public void display (javax.swing.JTextArea src){
    //THIS OVERRIDES THE PARENT CLASS DISPLAY METHOD AS IT ONLY DISPLAYS CERTAIN VALUES, 
    src.setText(null);    
    for(Product product: this.Products){
        src.append("Name: "+product.getName()+"\n");
        src.append("Category: "+product.getCategory()+"\n");
        src.append("Price: "+String.valueOf(product.getPriceWithVAT())+"\n");
        src.append("Quantity :"+String.valueOf(product.getQuantity())+"\n");       
        src.append("\n");
    }
}

}
