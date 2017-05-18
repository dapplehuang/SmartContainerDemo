package com.drc.smartcontainerdemo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ListStockActivity extends Activity {

    ListView mList;
    SharedPreferences mPreference;
    ArrayList<String> mItemList;
    ArrayAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_list);
        readStockData();
        mList = (ListView) findViewById(R.id.list);
        mAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mItemList);
        mList.setAdapter(mAdapter);
    }

    private void readStockData() {
        mPreference = getSharedPreferences(Constants.PREF_DB_DATA,0);
        String data = mPreference.getString(Constants.PREF_KEY_STOCK_DATA, null);
        Log.i("dapple", "mPreference read = " + data);
        String[] arrayData = null;
        if (data != null) {
            arrayData = data.split(";");
        }
        if(arrayData != null) {
            mItemList = new ArrayList<String>(Arrays.asList(arrayData));
        } else {
            mItemList = new ArrayList<String>();
        }
    }
}
