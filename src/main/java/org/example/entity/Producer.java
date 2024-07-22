package org.example.entity;

public class Producer {
    private int pId;
    private String itemName;

    public Producer(int pId, String itemName) {
        this.pId = pId;
        this.itemName = itemName;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "pId=" + pId +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
