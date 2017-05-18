package com.drc.smartcontainerdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;

public class AddItemActivity extends ListStockActivity {

    StringBuilder mInputString = new StringBuilder();
    private static final int MESSAGE_INPUT_ITEM = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void writeData() {
        mItemList.add(mInputString.toString());
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

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if(event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            return super.dispatchKeyEvent(event); //need clean input data before exit
        }

        if (event.getAction() == KeyEvent.ACTION_UP) {
            mInputString.append((char) event.getUnicodeChar());
            mHandler.removeMessages(MESSAGE_INPUT_ITEM);
            mHandler.sendEmptyMessageDelayed(MESSAGE_INPUT_ITEM, 200);
        }
        return true;
    }

    private Handler mHandler = new Handler () {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MESSAGE_INPUT_ITEM:
                    writeData();
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    };
}
