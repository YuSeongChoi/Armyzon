package com.example.administrator.armyzon;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.json.JSONArray;
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
            String sql1 = "CREATE TABLE IF NOT EXISTS ItemList (ItemName text not null,"
                    + "                                          ItemStock text not null,"
                    + "                                          ImgName text not null);";
            database.execSQL(sql1);
        } catch (Exception e) {
            Log.e("test", "CREATE TABLE FAILED! -" + e);
            e.printStackTrace();
        }
    }

    public void insertJsonData(String jsonData) {
        //JSON 데이터를 인자로 받아올 때 사용할 임시 변수
        String itemName;
        String itemStock;
        String imgName;

        try {
            JSONArray jArr = new JSONArray(jsonData);

            for (int i = 0; i < jArr.length(); ++i) {
                JSONObject jObj = jArr.getJSONObject(i);

                itemName = jObj.getString("ItemName");
                itemStock = jObj.getString("ItemStock");
                imgName = jObj.getString("ImgName");

                Log.i("test", "ItemName: " + itemName + "ItemStock: " + itemStock);

                String sql1 = "INSERT INTO ItemList(ItemName, ItemStock, ImgName)"
                        + " VALUES(" + itemName + ",'" + itemStock + ".'" + imgName + ".);";

                try {
                    database.execSQL(sql1);
                } catch (Exception e) {
                    Log.e("test", "DB ERROR ! - " + e);
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            Log.e("test", "JSON ERROR! -" + e);
            e.printStackTrace();
        }

    }

    public ArrayList<Item> getItemList(){

        String itemName;
        String itemStock;
        String imgName;

        String sql1 = "SELECT * FROM ItemList;";
        Cursor cursor = database.rawQuery(sql1, null);

        while (cursor.moveToNext()){
            itemName = cursor.getString(0);
            itemStock = cursor.getString(1);
            imgName = cursor.getString(2);
        }
        return null;
    }


    /**
     * JSON파싱을 위한 테스트 문자열입니다.
     */
    public String getJsonTestData() {

        StringBuilder sb = new StringBuilder();
        sb.append("");

        sb.append("[");

        sb.append("      {");
        sb.append("         'ItemName':'Cola',");
        sb.append("         'ItemStock':'3개',");
        sb.append("         'ImgName':'img01.jpg'");
        sb.append("      },");
        sb.append("      {");
        sb.append("         'ItemName':'Chicken',");
        sb.append("         'ItemStock':'5개',");
        sb.append("         'ImgName':'img02.jpg'");
        sb.append("      },");
        sb.append("      {");
        sb.append("         'ItemName':'Sprite',");
        sb.append("         'ItemStock':'10개',");
        sb.append("         'ImgName':'img03.jpg'");
        sb.append("      }");

        sb.append("]");

        return sb.toString();
    }
}
