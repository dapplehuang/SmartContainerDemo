package com.drc.smartcontainerdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button listBtn;
    Button addBtn;
    Button removeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listBtn = (Button) findViewById(R.id.list_btn);
        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listActivity = new Intent();
                listActivity.setClassName("com.drc.smartcontainerdemo", "com.drc.smartcontainerdemo.ListStockActivity");
                startActivity(listActivity);
            }
        });
        addBtn = (Button) findViewById(R.id.add_btn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addActivity = new Intent();
                addActivity.setClassName("com.drc.smartcontainerdemo", "com.drc.smartcontainerdemo.AddItemActivity");
                startActivity(addActivity);
            }
        });
        removeBtn = (Button) findViewById(R.id.remove_btn);
        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addActivity = new Intent();
                addActivity.setClassName("com.drc.smartcontainerdemo", "com.drc.smartcontainerdemo.RemoveItemActivity");
                startActivity(addActivity);
            }
        });
    }
}
