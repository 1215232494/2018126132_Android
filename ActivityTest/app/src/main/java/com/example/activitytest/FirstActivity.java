package com.example.activitytest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        /*按钮1事件*/
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FirstActivity.this, "You clicked Button1", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FirstActivity.this, FirstActivity.class);//隐式Intent失败，指向系统其他软件
                startActivity(intent);
            }
        });
        /*按钮2事件*/
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FirstActivity.this, "You clicked Button2", Toast.LENGTH_SHORT).show();
//                显式 Intent
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                隐式Intent
                Intent intent = new Intent("com.example.activitytest.SecondActivity");
                intent.addCategory("com.exampl.activitytest.MY_CATEGORY");
                startActivity(intent);
            }
        });
        /*按钮3事件*/
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FirstActivity.this, "You clicked Button3", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent("com.example.activitytest.ThirdActivity");
                startActivity(intent);
            }
        });
    }

    /*点击菜单事件*/
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.call_item:
                Toast.makeText(this, "即将联系作者", Toast.LENGTH_SHORT).show();
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:88888888"));
                startActivity(intent);
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            case R.id.baidu_item:
                Toast.makeText(this, "即将访问\"百度\"", Toast.LENGTH_SHORT).show();
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));/*http://www.baidu.com 出错？*/
                startActivity(intent);
                break;
            case R.id.exit_item:
                Toast.makeText(this, "Exit Succeed", Toast.LENGTH_SHORT).show();
                finish();
                break;
            default:
        }
        return true;
    }

    /*添加菜单*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.first_menu, menu);
        return true;
    }
}