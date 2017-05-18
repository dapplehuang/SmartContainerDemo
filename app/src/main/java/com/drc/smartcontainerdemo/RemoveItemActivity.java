package com.drc.smartcontainerdemo;

import android.os.Bundle;
import android.util.Log;

public class RemoveItemActivity extends AddItemActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    protected void writeData() {
        int index = mItemList.indexOf(mInputString.toString());
        if (index != -1) {
            mItemList.remove(index);
        }
        mInputString.setLength(0);
        mAdapter.notifyDataSetChanged();
        if (mItemList.size() > 0) {
            String saveData = "";
            for (String a : mItemList) {
                saveData = saveData + a + ";";
            }
            mPreference = getSharedPreferences(Constants.PREF_DB_DATA,0);
            if (mPreference != null) {
                Log.i("dapple", "mPreference write = " + saveData);
                mPreference.edit().putString(Constants.PREF_KEY_STOCK_DATA, saveData).apply();
            }
        }
    }
}
