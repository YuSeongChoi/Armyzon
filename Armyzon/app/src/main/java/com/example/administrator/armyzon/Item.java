package com.example.administrator.armyzon;

/**
 * Created by Administrator on 2017-10-19.
 */

public class Item {
    private int itemNumber;
    private String itemName;
    private String itemStock;
    private String imgName;


    public Item(int itemNumber, String itemName, String itemStock, String imgName){
        this.itemNumber = itemNumber;

        this.itemName = itemName;
        this.itemStock = itemStock;
        this.imgName = imgName;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemStock() {
        return itemStock;
    }

    public String getImgName() {
        return imgName;
    }
}
