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
        // ����û�����
        Staff userData = new Staff("����", '1',"soft", 7346.1f);
        new StaffDao(MainActivity.this).insert(userData); 
    }
	 
	 private void initView() {
	       	// ����ȡ�����û�id��ѯ�û���Ϣ
	        Staff userBean = new StaffDao(MainActivity.this).queryById(1);
	        // ����TextView���ı�
	        tv.setText(userBean.toString());
	 }

}
