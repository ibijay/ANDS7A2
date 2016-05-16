package com.example.bijay.myapp_autocomplete;

/**
 * Created by Bijay on 14-05-2016.
 */
public class Product {

    private int pId;
    private String pName;

    public Product(){}

    public Product(String pname){
        super();
        this.pName = pname;
    }

    public int getpId(){return pId;}
    public void setpId(int pid){this.pId=pid;}
    public String getpName(){return pName;}
    public void setpName(String pname){this.pName=pname;}

    public String toString(){
        return pName;
    }
}
