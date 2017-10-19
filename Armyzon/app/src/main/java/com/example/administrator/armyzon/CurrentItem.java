package com.example.administrator.armyzon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class CurrentItem extends AppCompatActivity  {

    private ArrayList<ListData> listDataArray = new ArrayList<ListData>();

    private ListView itemListView;
    private ArrayList<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_item);

        itemListView = (ListView) findViewById(R.id.current_Itemlist);

        refreshData();

    }


    private void listView(){
        // DB로부터 게시글 리스트 받아옴
        Dao dao = new Dao(getApplicationContext());
        itemList = dao.getItemList();

        // Current Item Adapter적용
        CurrentItemAdapter currentItemAdapter = new CurrentItemAdapter(this, R.layout.current_itemlist, itemList);
        itemListView.setAdapter(currentItemAdapter);
    }

    private static AsyncHttpClient client = new AsyncHttpClient();

    private void refreshData(){

        client.get("http://10.53.128.152:5050/loadData/?itemNumber=0", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                //DB에 JSON을 저장
                String jsonData = new String(responseBody);
                Log.i("test", "jsonData: " + jsonData);

                Dao dao = new Dao(getApplicationContext());
                dao.insertJsonData(jsonData);

                listView();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            }
        });
    }

}

