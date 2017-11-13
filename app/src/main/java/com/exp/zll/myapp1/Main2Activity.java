package com.exp.zll.myapp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = (TextView) findViewById(R.id.textView);
        //接收上一个页面的数据
        Intent i = getIntent();
        //接收数据包
        //Bundle data = i.getExtras();
        //textView.setText(i.getStringExtra("data")+"，再见！");
        //textView.setText(String.format("name=%s,age=%d,name1=%s",data.getString("name"),
                //data.getInt("age"),data.getString("name1","leo")));

        //接收值对象的值，Serializable
        //User user = (User) i.getSerializableExtra("user");
        //接收值对象的值，Parcelable
        User user = (User) i.getParcelableExtra("user");

        textView.setText(String.format("User info(name=%s,age=%d)",user.getName(),user.getAge()));

        //底部的邮件按钮效果
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "可以给我发邮件哦~~", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
