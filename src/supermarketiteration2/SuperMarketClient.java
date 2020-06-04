/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketiteration2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Connor
 */
public class SuperMarketClient {
    
    private Socket clientSocket = new Socket("localhost",2222);
    private PrintWriter output;
    private BufferedReader input;

    public SuperMarketClient() throws IOException {
       
    }
    
    public void sendToServer(String sortcode, String accountnumber, String cost) throws IOException{
    
    PrintWriter output = new PrintWriter(clientSocket.getOutputStream(),true);
    output.println(sortcode);
    output.println(accountnumber);
    output.println(cost);
    }
    
    
    public String readInputData() throws IOException{
        input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputData  = input.readLine();
        return inputData;
        }
    
}
/*     input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String Result = input.readLine();
    
        switch(Result){
    
    case"Transaction Approved":
        System.out.print("Communication success - transaction went through");
        break;
        case"Transaction Declined":
        System.out.print("Communication success - transaction did not go through");
    
    }*/
    
    
    
    
     








    
    
    
    
    

