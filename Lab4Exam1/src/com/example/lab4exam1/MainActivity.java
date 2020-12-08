package com.example.lab4exam1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends Activity {
	private static int maxNum;
	private static Handler handler = new Handler();
	private static TextView  result = null;
	private static Button compare = null;
	private static EditText one = null;
	private static EditText two = null;
	
	public static void UpdateGUI(int refreshDouble){
		maxNum = refreshDouble;
		handler.post(RefreshLable);
	}
	private static Runnable RefreshLable = new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			result.setText("较大的数是：" + maxNum);
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Bundle myBundle = new Bundle();
		final Intent intent = new Intent(MainActivity.this,CompareService.class);
		//intent.setPackage(getPackageName());
		result = (TextView) findViewById(R.id.result);
		compare = (Button) findViewById(R.id.compare);
		one = (EditText) findViewById(R.id.one);
		two = (EditText) findViewById(R.id.two);
		compare.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				myBundle.putString("one", one.getText().toString());
				myBundle.putString("two", two.getText().toString());
				intent.putExtras(myBundle);
				startService(intent);
			}
		});
	}
}
