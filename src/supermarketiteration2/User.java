/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketiteration2;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 *
 * @author Connor
 */
public class User {
    protected String name;
    protected String role;
    protected String password;
    protected String filename;
    
    
public User(){
    name = "";
    role = "";
    password = "";
    filename = "UserDetails.txt";     
   
    }

public User(String strname, String strrole, String strpassword, String strfilename){
    name = strname;
    role = strrole;
    password = strpassword;
    filename = strfilename; 
}

public void edit(String strname, String strpassword, String strrole){

name = strname;
password = strpassword;
role = strrole;


}

public boolean roleSelected(String strEmployeeInput){
boolean hasEmployeeSelectedRole;

String EmployeeInput = strEmployeeInput;

if(EmployeeInput!="Please select an option")
    
hasEmployeeSelectedRole = true;
    else
    hasEmployeeSelectedRole =false;

return hasEmployeeSelectedRole;
    }
             
public boolean isRegistered(String newName, String newPassword, String newRole) throws IOException{
    
    boolean isRegistered;
    name =newName;
    password = newPassword;
    role = newRole;
    
    
    FileWriter writer;
    try{
    writer = new FileWriter(filename,true);
    writer.write(name+System.getProperty("line.separator"));
    writer.write(password+System.getProperty("line.separator"));
    writer.write(role+System.getProperty("line.separator"));
    writer.write("##"+System.getProperty("line.separator"));
    isRegistered = true;
    writer.flush();
    writer.close();
    writer = null;
    }catch(IOException ioe){   
    isRegistered = false;}
    
    return isRegistered;
    
    
}

public boolean isEmployee(String newName, String newPassword, String newRole){
name = newName;
password = newPassword;
role = newRole;
boolean isFound = false;
String record;
FileReader reader;
try{
    reader = new FileReader(filename);
    BufferedReader bin = new BufferedReader(reader);
    record = new String();
    while ((record = bin.readLine())!=null){
        if(name.contentEquals(record))
            record = bin.readLine();
            if(password.contentEquals(record))
                record = bin.readLine();
                if(role.contentEquals(record))
                    isFound=true;
    }
    bin.close();
    bin =null;
    }
catch(IOException ioe){
      isFound = false;
}
return isFound;
}

public boolean isShopOwner(String newName, String newPassword, String newRole){
name = newName;
password = newPassword;
role = newRole;
boolean isFound = false;
String record;
FileReader reader;
try{
    reader = new FileReader(filename);
    BufferedReader bin = new BufferedReader(reader);
    record = new String();
    while ((record = bin.readLine())!=null){
        if(name.contentEquals(record))
            record = bin.readLine();
            if(password.contentEquals(record))
                record = bin.readLine();
                if(role.contentEquals(record))
                    isFound=true;
    }
    bin.close();
    bin =null;
    }

catch(IOException ioe){
isFound = false;
}

    return isFound;
}

public String toString(Boolean DisplayingtoGUI){
     
    if(DisplayingtoGUI == true)
    { 
     return//Displaying to GUI     
       
        "Name: "+ name+"\n"+
        "Password: "+ password+"\n"+
        "Role: "+ role;
    }
    else //Saving to file
    {        
        return
             
        name+"\n"+
        password+"\n"+
        role+"\n";
    }

    }



public void setName(String name){

this.name = name;

}

public String getName(){

return name;

}

public void setRole(String role){

this.role = role;

}

public String getRole(){

return role;

}

public void setPassword(String password){

this.password = password;

}

public String getPassword(){

return password;

}

   
}


