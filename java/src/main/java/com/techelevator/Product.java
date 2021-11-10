package com.techelevator;

public class Product {

    private String name;
    private int price;
    private String productType;

    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public String getProductType() {
        return productType;
    }

    public Product(){}

    public Product(String name, String price, String productType){
        this.name = name;
        this.productType = productType;
        double priceDbl = Double.parseDouble(price);
        this.price = (int)(priceDbl*100);
    }
}
