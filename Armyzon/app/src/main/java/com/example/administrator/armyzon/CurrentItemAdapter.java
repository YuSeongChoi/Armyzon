package com.example.administrator.armyzon;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017-10-19.
 */

public class CurrentItemAdapter extends ArrayAdapter<Item> {
    private Context context;
    private int layoutResourceId;
    private ArrayList<Item> listData;


    public CurrentItemAdapter(Context context, int layoutResourceId, ArrayList<Item> listData) {
        super(context, layoutResourceId, listData);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.listData = listData;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
        }

        // row.findViewById로 row안의 레이아웃 구성
        TextView tvItemName = (TextView) row.findViewById(R.id.current_ItemName);
        TextView tvItemStock = (TextView) row.findViewById(R.id.current_ItemStock);

        // position은 ListData의 순서값(index)
        // listData(어레이리스트)에서 ListData(객체)를 가져와 get으로 순서값을 불러온 후 setText하기
        tvItemName.setText(listData.get(position).getItemName());
        tvItemStock.setText(listData.get(position).getItemStock());

        ImageView imageView = (ImageView) row.findViewById(R.id.current_ImgView);

        //Assets 폴더의 이미지파일 불러오기
        try {
            //이미지 파일의 이름 불러오기
            InputStream is = context.getAssets().open(listData.get(position).getImgName());
            //이미지를 Drawable로 만들기
            Drawable d = Drawable.createFromStream(is, null);
            //이미지뷰에 표시
            imageView.setImageDrawable(d);
        } catch (Exception e){
            Log.e("ERROR", "ERROR : " + e);
        }
        return row;
    }
}
