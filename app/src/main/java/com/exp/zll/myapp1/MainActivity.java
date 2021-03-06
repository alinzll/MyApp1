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
    private TextView txt1;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = (TextView) findViewById(R.id.text);



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
                //i.putExtra("name","张琳琳");                     //传递单个参数
                //传递数据包
                /*Bundle b = new Bundle();
                b.putString("name","aliy");
                b.putInt("age",14);
                i.putExtras(b);*/

                //传递一个值对象，两种序列化对象的接口，1是Serializable，2是
                //i.putExtra("user",new User("aliff",2));
                //startActivity(i);
                startActivityForResult(i,0);        //获取另一个页面的返回数据
            }
        });

    }
    //重写返回数据后的方法
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        txt1.setText("另一个activity返回的数据是："+data.getStringExtra("data"));
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
