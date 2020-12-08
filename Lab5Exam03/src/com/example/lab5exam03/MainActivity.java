package com.example.lab5exam03;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {
	 private StringBuffer contentBuffer;
	 private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initData();
		initView();
		
	}
	
	private void initData() {
        // 添加用户数据
        Staff userData = new Staff("张三", '1',"soft", 7346.1f);
        new StaffDao(MainActivity.this).insert(userData); 
    }
	 
	 private void initView() {
	       	// 根据取出的用户id查询用户信息
	        Staff userBean = new StaffDao(MainActivity.this).queryById(1);
	        // 设置TextView的文本
	        tv.setText(userBean.toString());
	 }

}
