/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketiteration2;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 *
 * @author Connor
 */
public class ProductList {

protected ArrayList<Product>Products;
protected String Filename;    

public ProductList(){
    
Products = new ArrayList<>(); 
Filename = "ProductList";
}

public Product create(String Category) throws ParseException{

    switch(Category){
        
            case "Electronic":
              ElectronicProduct eProduct = new ElectronicProduct();                      
              return eProduct;
              
            case "Kitchen":
              KitchenProduct kProduct = new KitchenProduct();          
              return kProduct;
                          
            case "Food":
              FoodProduct fProduct = new FoodProduct();          
              return fProduct;           
              
            case "Book":
              BookProduct bProduct = new BookProduct();          
              return bProduct;
    }
return null;
}


public void add(Product src) throws IOException{
   
Products.add (src);          

}

public void remove(Product src){
Products.remove (src);
}

public Product find(String nameInput){
  
  Product selection = null;  
    for(Product product: this.Products){
        
        if(product.getName().equalsIgnoreCase(nameInput)){
        selection = product;
        break;
        }  
    }    
return selection;
}

public void display (javax.swing.JTextArea src){
    src.setText("");
    
     for(Product product: this.Products){
         
        product.display(true, src);
        
     }
}                                  

public void displayReorders(javax.swing.JTextArea src){
   
    src.setText(null);   

    for(Product product: this.Products){
       if(scanForLowStock(product)){
                src.append("Product: " + product.getName()+"\n");
                src.append("Quantity: " + product.getQuantity()+"\n");
                src.append("Min Restock amount: " + (product.getMinimumStockLevel()-product.getQuantity())+"\n");
            }
        
    }
}

public void displayImage(JLabel imageArea, String image) throws IOException{

       String noImageFound = "no-image-available.jpg";

    BufferedImage img = null;
    try {    
        img = (BufferedImage)ImageIO.read(new File(image));
        Image actualimage = img.getScaledInstance(imageArea.getWidth(), imageArea.getHeight(), 0);
        imageArea.setIcon(new ImageIcon(actualimage));
        } 
    catch (IOException e) {
        img = (BufferedImage)ImageIO.read(new File(noImageFound));
        Image actualimage = img.getScaledInstance(imageArea.getWidth(), imageArea.getHeight(), 0);
        imageArea.setIcon(new ImageIcon(actualimage));
        System.out.println(e.getMessage());
        }          
    }

public void loadFromFile(String fileName) throws FileNotFoundException, IOException, ParseException{
    Filename = fileName;
   String record;

FileReader reader;

    reader = new FileReader(Filename +".txt");
    BufferedReader bin = new BufferedReader(reader);
   //record = new String(); <<<This way creates many small objects and decreases JVM performance
   record = "";
    bin.readLine();//because there are 2 spaces above 1st product but 1 space above rest
    
    while ((record = bin.readLine())!=null)
    {     
        bin.mark(10);
        String category = bin.readLine();
        bin.reset();
         switch(category){
             
            case "Electronic":
              ElectronicProduct eProduct = new ElectronicProduct();          
              Products.add(eProduct.loadFromFile(eProduct,bin)); 
              break;
              
            case "Kitchen":
              KitchenProduct kProduct = new KitchenProduct();          
              Products.add(kProduct.loadFromFile(kProduct,bin)); 
              break;
              
            case "Food":
              FoodProduct fProduct = new FoodProduct();          
              Products.add(fProduct.loadFromFile(fProduct,bin)); 
              break;
              
            case "Book":
              BookProduct bProduct = new BookProduct();          
              Products.add(bProduct.loadFromFile(bProduct,bin)); 
              break;      
        }                        
}
bin.close();
bin =null; 
}

public void saveToFile(boolean append, String fileName) throws IOException, ParseException{

    Filename = fileName;

    try{//This simply overwrites the file with a blank file
    FileWriter aWriter = new FileWriter(Filename+".txt",false);
    }
    catch(IOException ioe){
    System.out.println("Failed to wipe file");
    }
    //Now file writing begins
      FileWriter aWriter = new FileWriter(Filename+".txt",true);
      //  aWriter.write(System.getProperty("line.separator"));
        
        this.Products.forEach((product) -> {
            
        try {
            
            product.saveToFile(aWriter);
            
        } catch (IOException ex) {
            Logger.getLogger(ProductList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ProductList.class.getName()).log(Level.SEVERE, null, ex);
        }
    });  
    
        try{
    
  

    aWriter.close();
    }

catch(IOException ioe){
System.out.println("Failed to save product list");
}
}


public int generateProductID(){
//This is superior to using ArrayList index as it, as that is dynamic and this is static once set. 
boolean NewIDFound = false;
boolean inUse = false;
int potentialID;


  for(potentialID=0;NewIDFound==false;potentialID++){
    inUse=false;
        for(Product productToCompare: this.Products){
            
            if (potentialID==productToCompare.getID()){
                inUse=true;
                }
            
        }
        if(inUse!=true){
            NewIDFound=true;
            return potentialID;
        }
    }
return potentialID;
}

public int calculateSuggestedQuantity(Product chosenProduct){   
       
    int suggestedQuantity = chosenProduct.getMaximumStockLevel()-chosenProduct.getQuantity();      
        
    return suggestedQuantity;
}

public String calculateAdvisedOrderDate(Product chosenProduct,int deliveryTime) throws ParseException{
        String date = "";
        //date = chosenProduct.getExpiryDate();
        date = "10/10/20";//<< This is a placeholder because the AOD needs to be redone in a way that doesnt use expiry date as thats only relevant to food
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy"); 
        Calendar cal = Calendar.getInstance();
        cal.setTime(formatter.parse(date));
        cal.add(Calendar.DATE,-deliveryTime);
        date = formatter.format(cal.getTime());        
        return date;

}

public double calculateOrderCost(Product chosenProduct, int orderQuantity){
    Double orderCost = 0.0;
    orderCost= orderQuantity * chosenProduct.getUnitCost();
    return orderCost;
}
 


public boolean checkIfNameInUse(String input){
    boolean alreadyInStock =false;
    for(Product product : this.Products){
        
        if(input.equals(product.getName())){
            alreadyInStock =true;
            break;
        }
    }
return alreadyInStock;
}

public void updateLastOrderDate(Product input){
 
  
            input.setDateOfLastOrderPlacement(new Date());      
        
        }

public int setStockDefaultValue(String userInput){      
        int output = 0;       
            if(!userInput.equalsIgnoreCase("")){            
                output=Integer.valueOf(userInput);                                   
            }                                                          
        return output;
    }

public boolean confirmStockLevelsSet(Product chosenProduct){
    boolean reOrderPossible =true;  
        if(chosenProduct.getMaximumStockLevel()==0||chosenProduct.getMinimumStockLevel()==0){
        reOrderPossible=false;    
        }
    return reOrderPossible;
    }

public boolean scanForLowStock(Product chosenProduct){
    boolean warningRequired = false;   
        if(chosenProduct.getQuantity()<chosenProduct.getMinimumStockLevel()){
        warningRequired=true;   
        } 
    return warningRequired;
    }

public String getFilename() {
        return Filename;
    }

public void setFilename(String Filename) {
        this.Filename = Filename;
    }

public boolean checkIfFileExists(String fileName){
  String filename = fileName;
  
File tempFile = new File(filename);
boolean exists = tempFile.exists();

return exists;
}

public void updateQuantity(Product src,Product rec){



 rec.setQuantity(rec.getQuantity()-src.getQuantity());

}



}
            









   
    



