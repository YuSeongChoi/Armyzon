package com.example.administrator.armyzon;

/**
 * Created by Administrator on 2017-10-19.
 */

public class ListData {
    private String itemName; //물품 이름
    private String itemStock; //물품 개수
    private String imgName; //사진의 경로

    ListData(String itemName, String itemStock, String imgName){
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
