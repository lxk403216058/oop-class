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
        // ����û�����
        Hello userData = new Hello("����", "��", "soft",7525.1f);
        new HelloDao(MainActivity.this).add(userData); 
    }
	 
	 private void initView() {
	       	// ����ȡ�����û�id��ѯ�û���Ϣ
		 	Hello userBean = new HelloDao(MainActivity.this).queryForId(1);
	        // ����TextView���ı�
	        tv.setText(userBean.toString());
	 }
}
