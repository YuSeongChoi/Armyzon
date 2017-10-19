package com.example.administrator.armyzon;

/**
 * Created by Administrator on 2017-10-19.
 */

public class Item {
    String itemName;
    String itemStock;
    String imgName;

    public Item(String itemName, String itemStock, String imgName){
        this.itemName = itemName;
        this.itemStock = itemStock;
        this.imgName = imgName;
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
