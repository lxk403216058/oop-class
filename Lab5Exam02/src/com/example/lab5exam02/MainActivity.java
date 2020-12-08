package com.example.lab5exam02;

import android.R.layout;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Spinner sp1,sp2,sp3;
	private RelativeLayout layout;
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sp1 = (Spinner) findViewById(R.id.spinner1);
		sp2 = (Spinner) findViewById(R.id.spinner2);
		sp3 = (Spinner) findViewById(R.id.spinner3);
		tv = (TextView) findViewById(R.id.text1);
		layout = (RelativeLayout) findViewById(R.id.layout);
		Button button = (Button) findViewById(R.id.button1);
		SharedPreferences sh = getSharedPreferences("data.ini", Activity.MODE_PRIVATE);
		if (!sh.getString("background_color", "").equals("")) {
			layout.setBackgroundColor(select(sh.getString("background_color", "")));
			tv.setTextSize(Float.parseFloat(sh.getString("font_size", "").substring(0, 2)));
			tv.setTextColor(select(sh.getString("font_color", "")));
		}
		
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SharedPreferences sharedPreferences = getSharedPreferences("data.ini", Activity.MODE_PRIVATE);
				SharedPreferences.Editor editor = sharedPreferences.edit();
				editor.putString("background_color", sp1.getSelectedItem().toString());
				editor.putString("font_size", sp2.getSelectedItem().toString());
				editor.putString("font_color", sp3.getSelectedItem().toString());
				editor.commit();
				layout.setBackgroundColor(select(sp1.getSelectedItem().toString()));
				tv.setTextSize(Float.parseFloat(sp2.getSelectedItem().toString().substring(0, 2)));
				tv.setTextColor(select(sp3.getSelectedItem().toString()));
				
				Toast.makeText(MainActivity.this, "����ɹ�", Toast.LENGTH_LONG).show();
			}
		});
		
	}
	
	public int select(String str) {
		if (str.equals("GREEN")) {
			return Color.GREEN;
		}else if (str.equals("BLUE")) {
			return Color.BLUE;
		}else if (str.equals("RED")) {
			return Color.RED;
		}else if (str.equals("BLACK")) {
			return Color.BLACK;
		}else{
			return Color.WHITE;
		}
		
	}
	private boolean isFristRun() {
		//ʵ����SharedPreferences���󣨵�һ����
		SharedPreferences sharedPreferences = this.getSharedPreferences(
				"data", MODE_PRIVATE);
		//ʵ����SharedPreferences.Editor���󣨵ڶ����� 
		boolean isFirstRun = sharedPreferences.getBoolean("isFirstRun", true);
		Editor editor = sharedPreferences.edit();
		if (!isFirstRun) {
			return false;
		} else {
			return true;
		}
	}
}
