package com.example.administrator.armyzon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.widget.EditText;

public class OrderItem extends AppCompatActivity implements  OnClickListener {

    private InputMethodManager inputMethodManager;
    private EditText order_ItemName;
    private EditText order_ItemStock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_item);
        inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

        Button buttonOrder = (Button) findViewById(R.id.order_OrderItem);
        buttonOrder.setOnClickListener(this);

        order_ItemName = (EditText) findViewById(R.id.order_ItemName);
        order_ItemStock = (EditText) findViewById(R.id.order_ItemStock);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.order_OrderItem :
                Toast.makeText(getApplicationContext(), order_ItemName.getText().toString() + "상품이\n" + order_ItemStock.getText().toString() + "개\n" + "주문이 완료되었습니다.",Toast.LENGTH_SHORT).show();
                order_ItemName.setText(" ");
                order_ItemStock.setText(" ");

                break;
        }
    }
}
