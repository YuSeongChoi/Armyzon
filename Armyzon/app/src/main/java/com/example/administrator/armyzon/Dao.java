package com.example.administrator.armyzon;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-10-19.
 */

public class Dao {
    private Context context;
    private SQLiteDatabase database;

    public Dao(Context context) {
        this.context = context;

        //SQLite 초기화
        database = context.openOrCreateDatabase("LocalDATA.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);

        //TABLE 생성
        try {
            String sql1 = "CREATE TABLE IF NOT EXISTS ItemList (ItemNumber integer UNIQUE not null,"
                    + "                                         ItemName text not null,"
                    + "                                         ItemStock text not null,"
                    + "                                         ImgName text not null);";
            database.execSQL(sql1);
        } catch (Exception e) {
            Log.e("test", "CREATE TABLE FAILED! -" + e);
            e.printStackTrace();
        }
    }

    public void insertJsonData(String jsonData) {
        //JSON 데이터를 인자로 받아올 때 사용할 임시 변수
        int itemNumber;
        String itemName;
        String itemStock;
        String imgName;

        FileDownloader fileDownloader = new FileDownloader(context);

        try {
            JSONArray jArr = new JSONArray(jsonData);

            for (int i = 0; i < jArr.length(); ++i) {
                JSONObject jObj = jArr.getJSONObject(i);

                itemNumber = jObj.getInt("ItemNumber");
                itemName = jObj.getString("ItemName");
                itemStock = jObj.getString("ItemStock");
                imgName = jObj.getString("ImgName");

                Log.i("test", "ItemName: " + itemName + "ItemStock: " + itemStock);

                String sql1 = "INSERT INTO ItemList(ItemNumber, ItemName, ItemStock, ImgName)"
                        + " VALUES("+ itemNumber + ",'" + itemName + "','" + itemStock + "','" + imgName + "');";

                try {
                    database.execSQL(sql1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                fileDownloader.downFile("http://10.53.128.152:5050/image/" + imgName, imgName);
            }

        } catch (JSONException e) {
            Log.e("test", "JSON ERROR! -" + e);
            e.printStackTrace();
        }

    }

    public ArrayList<Item> getItemList(){

        ArrayList<Item> itemList = new ArrayList<>();

        int itemNumber;
        String itemName;
        String itemStock;
        String imgName;

        String sql1 = "SELECT * FROM ItemList;";
        Cursor cursor = database.rawQuery(sql1, null);

        while (cursor.moveToNext()){
            itemNumber = cursor.getInt(0);
            itemName = cursor.getString(1);
            itemStock = cursor.getString(2);
            imgName = cursor.getString(3);
            itemList.add(new Item(itemNumber, itemName,itemStock,imgName));
        }
        cursor.close();
        return itemList;
    }
}
