package com.example.lab4exam01;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Button b;
	private EditText ed1,ed2;
	private static TextView tv3;
	private boolean isBound;
	private CompareService compareService;
	private Task task;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b = (Button) findViewById(R.id.bt1);
		ed1 = (EditText) findViewById(R.id.et1);
		ed2 = (EditText) findViewById(R.id.et2);
		tv3 = (TextView) findViewById(R.id.tv3);
		if (!isBound){
			final Intent intent = new Intent("android.compare");
			intent.setPackage(getPackageName());
			bindService(intent, conn, Context.BIND_AUTO_CREATE);
			isBound = true;
		}
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (compareService == null) {
					tv3.setText("未绑定服务");
				}
				int first = Integer.parseInt(ed1.getText().toString());
				int second = Integer.parseInt(ed2.getText().toString());
				task = new Task(first, second);
				task.execute("");
				
			}
		});
	}
	private ServiceConnection conn = new ServiceConnection(){

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			compareService=((CompareService.LocalBinder)service).getService();
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			compareService = null;
		}
		
	};
	
	public class Task extends AsyncTask<String, Object, Long>{
		private int first,second;
		public Task(int first,int second) {
			this.first = first;
			this.second = second;
		}
		
		@Override
		protected Long doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			try{
        		Thread.sleep(500);
        		}catch (InterruptedException e) {
        			
        		e.printStackTrace();
        		}

			return null;
		}
		@Override
		protected void  onPostExecute(Long l){
			tv3.setText("较大的数："+String.valueOf(compareService.compare(first, second)));
		}
		
	}
} 
