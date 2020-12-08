package com.example.lab3exer01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Button b;
	private TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		b = (Button) findViewById(R.id.button1);
		tv = (TextView) findViewById(R.id.name);
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String str = tv.getText().toString();
				Bundle data = new Bundle();
				data.putString("name", str);
				Intent intent = new Intent(MainActivity.this,test2.class);
				intent.putExtra("name", str);
				startActivity(intent);
			}
		});
	}
}
