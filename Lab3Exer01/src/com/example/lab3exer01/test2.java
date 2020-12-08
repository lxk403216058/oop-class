package com.example.lab3exer01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class test2 extends Activity {
	private TextView tv2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test2);
		tv2 = (TextView) findViewById(R.id.editText2);
		
		Intent intent = getIntent();
		Bundle b= intent.getExtras();
		
		String name = b.getString("name");
		tv2.setText(name);
	}

}
