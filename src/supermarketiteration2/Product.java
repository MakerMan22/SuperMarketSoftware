/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketiteration2;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Connor
 */
public abstract class Product implements Cloneable{
    

protected int ID;    
protected String Name;
protected String Category;
protected double Price;
protected double PriceWithVAT;
protected double UnitCost;
protected int Quantity;    
protected int Weight;    
protected String WeightCategory;    
//protected int ShelfLife;    
//protected String ExpiryDate;
protected int MinimumStockLevel;
protected int MaximumStockLevel;
protected String ImageName;
protected Date DateOfLastOrderPlacement;
protected String Supplier;
protected String DeliveryCompany;
protected SimpleDateFormat simpledateformat= new SimpleDateFormat("dd/MM/yy");
protected SimpleDateFormat simpledateformat2= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");



public Product(){

 ID = 0;    
 Name = "";
 Category = "";
 Price = 0;
 PriceWithVAT = 0;
 UnitCost = 0;
 Quantity = 0;    
 Weight = 0;    
 WeightCategory = "";    
 //ShelfLife = 0 ;    
 //ExpiryDate = "";
 MinimumStockLevel = 0;
 MaximumStockLevel = 0;
 ImageName = "";
 DateOfLastOrderPlacement = new Date();
 Supplier = "";
 DeliveryCompany ="";
 simpledateformat = new SimpleDateFormat("dd/MM/yy");
 simpledateformat2 = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
}


public Product( String Category, int id, String Name,String supplier, String deliveryCompany,double price, double unitCost,int quantity,int weight,String weightCategory,String dateOfLastOrderPlacement,String imageName, int minstock, int maxstock) throws ParseException{
this.edit(Category, id, Name, supplier, deliveryCompany,price, unitCost, quantity, weight,weightCategory,dateOfLastOrderPlacement , imageName, minstock, maxstock);
}


        
public void edit(String category, int id, String name, String supplier, String deliveryCompany, double price, double unitCost, int quantity, int weight, String weightCategory, String dateOfLastOrderPlacement, String imageName, int minstock, int maxstock) throws ParseException{
 Category = category;
 ID = id;    
 Name = name;
 Price = price;
 PriceWithVAT = this.calculatePriceWithVAT(price);
 UnitCost = unitCost;
 Quantity = quantity;    
 Weight = weight;    
 WeightCategory = weightCategory;    
 MinimumStockLevel = minstock;
 MaximumStockLevel = maxstock;
 ImageName = imageName;
 DateOfLastOrderPlacement = simpledateformat.parse(dateOfLastOrderPlacement);
 Supplier = supplier;
 DeliveryCompany = deliveryCompany;
}


public void display(Boolean TrueAllProductsFalseOneProduct,javax.swing.JTextArea src){

 if(TrueAllProductsFalseOneProduct == true){
     src.append(this.toString(true)); 
     //src.append("\n");
    }
 else{
     src.setText(this.toString(true)); 
     //src.append("\n");
    }
}

public String toString(Boolean DisplayingtoGUI){
     
    if(DisplayingtoGUI == true)
    { 
     return//Displaying to GUI     
        "Category: "+ Category+"\n"+
        "ID: "+ ID+"\n"+
        "Name: "+ Name+"\n"+
        "Supplier: "+ Supplier+"\n"+
        "Delivery Company: "+ DeliveryCompany+"\n"+       
        "Price: £"+ Price+"\n"+
        "Price with VAT: £"+ PriceWithVAT+"\n"+
        "Unit Cost: £"+ UnitCost+"/Unit"+"\n"+
        "Quantity: "+ Quantity+" Units"+"\n"+
        "Weight: "+ Weight+" "+WeightCategory+"\n"+
        "Last Order Date: "+ simpledateformat.format(DateOfLastOrderPlacement)+"\n"+
        "Max Stock Level: "+ MaximumStockLevel+"\n"+
        "Min Stock Level: "+ MinimumStockLevel+"\n";
    }
    else //Saving to file
    {        
        return
        Category+"\n"+
        ID +"\n"+        
        Name+"\n"+
        Supplier+"\n"+
        DeliveryCompany+"\n"+       
        Price+"\n"+
        UnitCost+"\n"+
        Quantity+"\n"+
        Weight+"\n"+
        WeightCategory+"\n"+
        simpledateformat.format(DateOfLastOrderPlacement)+"\n"+
        ImageName+"\n"+        
        MinimumStockLevel+"\n"+
        MaximumStockLevel+"\n";        
    }            
}

public Product loadFromFile(Product aProduct, BufferedReader bin) throws IOException, ParseException{
    
    
    aProduct.edit(
                    /*String caTEGORY*/bin.readLine(),
                    /*int ID*/Integer.valueOf(bin.readLine()),
                    /*String name*/bin.readLine(), 
                    /*String Supplier*/bin.readLine(), 
                    /*String deliverycomapyn*/bin.readLine(),                    
                    /*double price*/Double.valueOf(bin.readLine()),
                    /*double unit cosre*/Double.valueOf(bin.readLine()),
                    /*int quantity*/Integer.valueOf(bin.readLine()),
                    /*int weight*/Integer.valueOf(bin.readLine()),
                    /*int weight category*/bin.readLine(),
                 //  /*int shelf life*/Integer.valueOf(bin.readLine()),
                    /*string date of last order*/bin.readLine(),
                    /*string image name*/bin.readLine(),
                    /*String min stock*/Integer.valueOf(bin.readLine()),
                    /*string max stock */Integer.valueOf(bin.readLine()));
 
    return aProduct;
}

public void saveToFile(FileWriter aWriter) throws IOException,ParseException{
 aWriter.write(System.getProperty("line.separator"));
         aWriter.write(System.getProperty("line.separator"));
 aWriter.write(this.toString(false));


}


public double calculatePriceWithVAT(double price){

double priceWithVAT = price * 1.2;

return priceWithVAT;

}


public boolean convertTextToBoolean(String input){

    boolean result = false;
        if(input =="yes"){
        result=true;
    }
return result;
}

public String dateToString(Date dateInput){
//Converting Date >> Cal >> String

String output; 

Calendar cal = Calendar.getInstance(); 
cal.setTime(dateInput); 
output = simpledateformat.format(cal.getTime());

return output;
}

public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


public String getName() {
    return Name;
}

public void setName(String Name) {
    this.Name = Name;
}

public String getCategory() {
    return Category;
}

public void setCategory(String Category) {
    this.Category = Category;
}

public double getPrice() {
    return Price;
}

public void setPrice(double Price) {
    this.Price = Price;
}

public double getPriceWithVAT() {
    return PriceWithVAT;
}

public void setPriceWithVAT(double PriceWithVAT) {
    this.PriceWithVAT = PriceWithVAT;
}

public double getUnitCost() {
    return UnitCost;
}

public void setUnitCost(double UnitCost) {
    this.UnitCost = UnitCost;
}

public int getQuantity() {
    return Quantity;
}

public void setQuantity(int Quantity) {
    this.Quantity = Quantity;
}

public int getWeight() {
    return Weight;
}

public void setWeight(int Weight) {
    this.Weight = Weight;
}

public int getMinimumStockLevel() {
    return MinimumStockLevel;
}

public void setMinimumStockLevel(int MinimumStockLevel) {
    this.MinimumStockLevel = MinimumStockLevel;
}

public int getMaximumStockLevel() {
    return MaximumStockLevel;
}

public void setMaximumStockLevel(int MaximumStockLevel) {
    this.MaximumStockLevel = MaximumStockLevel;
}

public String getImageName() {
    return ImageName;
}

public void setImageName(String ImageName) {
    this.ImageName = ImageName;
}

public int getID() {
    return ID;
}

public void setID(int ID) {
    this.ID = ID;
}

public Date getDateOfLastOrderPlacement() {
    return DateOfLastOrderPlacement;
}

public void setDateOfLastOrderPlacement(Date DateOfLastOrderPlacement) {
    this.DateOfLastOrderPlacement = DateOfLastOrderPlacement;
}

public SimpleDateFormat getSimpledateformat() {
    return simpledateformat;
}

public void setSimpledateformat(SimpleDateFormat simpledateformat) {
    this.simpledateformat = simpledateformat;
}

public String getSupplier() {
    return Supplier;
}

public void setSupplier(String Supplier) {
    this.Supplier = Supplier;
}

public String getDeliveryCompany() {
    return DeliveryCompany;
}

public void setDeliveryCompany(String DeliveryCompany) {
    this.DeliveryCompany = DeliveryCompany;
}

    public String getWeightCategory() {
        return WeightCategory;
    }

    public void setWeightCategory(String WeightCategory) {
        this.WeightCategory = WeightCategory;
    }

}
