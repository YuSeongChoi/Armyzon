package com.example.administrator.armyzon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CurrentItem extends AppCompatActivity {

    private ArrayList<ListData> listDataArray = new ArrayList<ListData>();

    private ListView itemListView;
    private ArrayList<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_item);

        itemListView = (ListView) findViewById(R.id.current_Itemlist);
        // DB에 JSON데이터를 저장함
        Dao dao = new Dao(getApplicationContext());
        String testJsonData = dao.getJsonTestData();
        dao.insertJsonData(testJsonData);

        // DB로부터 게시글 리스트 받아옴
        itemList = dao.getItemList();

        // Current Item Adapter적용
        CurrentItemAdapter currentItemAdapter = new CurrentItemAdapter(this, R.layout.current_itemlist, itemList);
        itemListView.setAdapter(currentItemAdapter);

/*
        ListData data1 = new ListData("첫번째 줄1","두번째 줄1","img01.jpg");
        listDataArray.add(data1);

        ListData data2 = new ListData("첫번째 줄2","두번째 줄2","img02.jpg");
        listDataArray.add(data2);

        ListData data3 = new ListData("첫번째 줄3","두번째 줄3","img03.jpg");
        listDataArray.add(data3);

        ListData data4 = new ListData("첫번째 줄4","두번째 줄4","img04.jpg");
        listDataArray.add(data4);

        ListData data5 = new ListData("첫번째 줄5","두번째 줄5","img05.jpg");
        listDataArray.add(data5);

        ListView listView = (ListView) findViewById(R.id.current_Itemlist);
        CurrentItemAdapter customAdapter = new CurrentItemAdapter(this, R.layout.current_itemlist, listDataArray);
        listView.setAdapter(customAdapter);
        */
    }
}
