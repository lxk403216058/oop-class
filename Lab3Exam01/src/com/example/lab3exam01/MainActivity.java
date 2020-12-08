package com.example.lab3exam01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button button = (Button) findViewById(R.id.b1);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction("MY_ACTION");
				startActivityForResult(intent, 1);
			}
		});
	}
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case 1:	
			String account = data.getStringExtra("account");
			String password = data.getStringExtra("password");
			Log.i("MainActivity", account);
			Log.i("MainActivity", password);
			Toast ts = Toast.makeText(MainActivity.this,"’ ∫≈£∫" + account + "√‹¬Î£∫" + password, Toast.LENGTH_LONG);
			ts.show();
			break;
		default:
		}
	}
}
