/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketiteration2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Connor
 */
public class UserList {
           
private ArrayList<User>Users;    
private String filename;


public UserList(){

Users=new ArrayList<>();
filename = "UserDetails.txt";

}

public Boolean saveToFile(boolean append, String fileName) throws IOException{
Boolean fileSaved = false;

    filename = fileName;

    try{
    FileWriter aWriter = new FileWriter(filename,false);
    }
    catch(IOException ioe){
    System.out.println("Failed to wipe file");
    }
   
    for(User user: Users)

    {try{
    
    FileWriter aWriter = new FileWriter(filename,true);
    aWriter.write(System.getProperty("line.separator"));
    aWriter.write(user.toString(false));
    
    fileSaved=true;
    aWriter.close();
    }

catch(IOException ioe){
System.out.println("Failed to save product list");
}}
return fileSaved;
}

public void loadFromFile() throws FileNotFoundException, IOException{
    
//All customers employees and the shop owner are saved in the same file and read into the program as objects of type user

FileReader reader;

    reader = new FileReader(filename);
    BufferedReader bin = new BufferedReader(reader);
    String record = new String();
    
    while ((record = bin.readLine())!=null)
       {    
                String Name = bin.readLine();
                String Password = bin.readLine();
                String Role = bin.readLine();
                      
                switch (Role){
               
                    case "Customer":
                        
              //  Customer acustomer = (Customer) this.logIn("A","B","C");
                //System.out.println(acustomer.Name);
                        
                        
                       Customer customer = new Customer();
                       customer.edit(Name, Password, Role);
                       add(customer);
                       break;
                       
                    case "Employee":
                       Employee employee = new Employee();
                       employee.edit(Name, Password, Role);
                       add(employee);                    
                       break;  
                    
                    case "Shop Owner":
                       ShopOwner shopOwner = new ShopOwner();
                       shopOwner.edit(Name, Password, Role);
                       add(shopOwner);                      
                       break;             
               }  
       }
    
    bin.close();
    bin =null;
    
    }

public void add(User src) throws IOException{

    Users.add (src);
}

public User logIn(String strname, String strpassword, String strrole){   
    User currentUser = null;
    for( User aUser:this.Users)
        
        if(strname.equalsIgnoreCase(aUser.getName())&&
           strpassword.equalsIgnoreCase(aUser.getPassword())&&
           strrole.equalsIgnoreCase(aUser.getRole())){       
        
           currentUser=aUser;
        }    
    return currentUser;
    
    
}

public User find(String nameInput){
  
  User selection = null;  
    for(User user: this.Users){
        
        if(user.getName().equalsIgnoreCase(nameInput)){
        selection = user;
        break;
        }  
    }  
    return selection;
}

public String getFilename() {
        return filename;
    }

    public ArrayList<User> getUsers() {
        return Users;
    }

    public void setUsers(ArrayList<User> Users) {
        this.Users = Users;
    }


}
   