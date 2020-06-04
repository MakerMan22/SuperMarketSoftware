/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketiteration2;

/**
 *
 * @author Connor
 */
public class Customer extends User{
private WishList theWishList;
private Basket theBasket;
private String SortCode;
private String AccountNumber;

public Customer(){
    String SortCode = "";
    String AccountNumber = "";
    theWishList = new WishList();
    theBasket = new Basket();

}

public void edit(String aName, String aPassword, String aRole){

super.edit(aName, aPassword, aRole);

}

    public WishList getTheWishList() {
        return theWishList;
    }

    public void setTheWishList(WishList theWishList) {
        this.theWishList = theWishList;
    }

    public Basket getlTheBasket() {
        return theBasket;
    }

    public void setTheBasket(Basket theBasket) {
        this.theBasket = theBasket;
    }

    public String getSortCode() {
        return SortCode;
    }

    public void setSortCode(String SortCode) {
        this.SortCode = SortCode;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    public Basket getTheBasket() {
          return theBasket;
    }

    void getf() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   


    
}
