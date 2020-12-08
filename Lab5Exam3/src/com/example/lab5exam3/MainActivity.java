package com.example.lab5exam3;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView) findViewById(R.id.tv);
		initData();
		initView();
	}
	
	private void initData() {
        // 添加用户数据
        Hello userData = new Hello("张三", "男", "soft",7525.1f);
        new HelloDao(MainActivity.this).add(userData); 
    }
	 
	 private void initView() {
	       	// 根据取出的用户id查询用户信息
		 	Hello userBean = new HelloDao(MainActivity.this).queryForId(1);
	        // 设置TextView的文本
	        tv.setText(userBean.toString());
	 }
}
