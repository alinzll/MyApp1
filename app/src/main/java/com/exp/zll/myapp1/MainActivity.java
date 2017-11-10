package com.exp.zll.myapp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button btn1;
    private Button btn2;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.main_title);     //获取文本对象
        textView.setText("张琳琳，你好！");                       //设置成员变量的值
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        ButtonListener btnListener1 = new ButtonListener();      //创建监听器实例
        btn1.setOnClickListener(btnListener1);                    //为控件绑定监听器
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                i.putExtra("name","张琳琳");
                startActivity(i);
            }
        });
    }
    //实现监听器的接口
    class ButtonListener implements View.OnClickListener {
        @Override
        //重写方法
        public void onClick(View v) {
            count++;
            if (count == 1) {
                textView.setText("这是第一次尝试！");
            } else if (count == 2) {
                textView.setText("虽然还是懵懂无知");
            } else if (count == 0) {
                textView.setText("张琳琳，你好！");
            } else {
                textView.setText("希望你能坚持下去");
                count = -1;
            }
        }
    }
}
