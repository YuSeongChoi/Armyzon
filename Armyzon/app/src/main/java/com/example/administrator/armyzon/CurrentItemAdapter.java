package com.example.administrator.armyzon;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017-10-19.
 */

public class CurrentItemAdapter extends ArrayAdapter<Item> {
    private Context context;
    private int layoutResourceId;
    private ArrayList<Item> itemData;


    public CurrentItemAdapter(Context context, int layoutResourceId, ArrayList<Item> itemData) {
        super(context, layoutResourceId, itemData);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.itemData = itemData;
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
        tvItemName.setText(itemData.get(position).getItemName());
        tvItemStock.setText(itemData.get(position).getItemStock());

        ImageView imageView = (ImageView) row.findViewById(R.id.current_ImgView);

        String img_path = context.getFilesDir().getPath() + "/" + itemData.get(position).getImgName();
        File img_load_path = new File(img_path);

        if(img_load_path.exists()){
            Bitmap bitmap = BitmapFactory.decodeFile(img_path);
            imageView.setImageBitmap(bitmap);
        }
        return row;
    }
}
