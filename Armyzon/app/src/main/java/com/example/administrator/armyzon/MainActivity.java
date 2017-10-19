package com.example.administrator.armyzon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button current_Item = (Button) findViewById(R.id.main_currentItem);
        Button order_Item = (Button) findViewById(R.id.main_orderItem);
        Button check_Item = (Button) findViewById(R.id.main_checkItem);
        Button notice = (Button) findViewById(R.id.main_notice);

        current_Item.setOnClickListener(this);
        order_Item.setOnClickListener(this);
        check_Item.setOnClickListener(this);
        notice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_currentItem :
                Intent intentCurrentItem = new Intent(this, CurrentItem.class);
                startActivity(intentCurrentItem);
                break;
            case R.id.main_orderItem :
                Intent intentOrderItem = new Intent(this, OrderItem.class);
                startActivity(intentOrderItem);
                break;
            case R.id.main_checkItem :
                Intent intentCheckItem = new Intent(this, CheckItem.class);
                startActivity(intentCheckItem);
                break;
            case R.id.main_notice :
                Intent intentNotice = new Intent(this, Notice.class);
                startActivity(intentNotice);
                break;
        }
    }
}
