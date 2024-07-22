package org.example.entity;

public class Products {
    private int serialNo;
    private String ProductName;

    public Products(int serialNo, String productName) {
        this.serialNo = serialNo;
        ProductName = productName;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    @Override
    public String toString() {
        return "Products{" +
                "serialNo=" + serialNo +
                ", ProductName='" + ProductName + '\'' +
                '}';
    }
}
