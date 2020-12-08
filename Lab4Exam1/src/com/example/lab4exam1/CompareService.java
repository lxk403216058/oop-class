package com.example.lab4exam1;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.TextView.OnEditorActionListener;

public class CompareService extends Service {
	private Thread workThread;
	Bundle bundle = null;
	int one=0,two=0;
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public void onCreate() {
		super.onCreate();
		workThread = new Thread(null,backgroundWork,"WorkThread");
	}
	@Override
	public void onStart(Intent intent,int startId){
		super.onStart(intent, startId);
		bundle = intent.getExtras();
		String c1 = bundle.getString("one");
		String c2 = bundle.getString("two");
		if (!c1.toString().equals("")&&!c2.toString().equals("")) {
			one = Integer.parseInt(c1);
			two = Integer.parseInt(c2);
		}
		
		if (!workThread.isAlive()) {
			workThread.start();
		}
		
	}
	private Runnable backgroundWork = new Runnable() {
		
		@Override
		public void run() {
			try {
				while (!Thread.interrupted()) {
					int randomDouble = IntCompare(one,two);
					MainActivity.UpdateGUI(randomDouble);
					Thread.sleep(1000);
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	};
	public int IntCompare(int a,int b) {
		if(a>=b)
			return a;
		else
			return b;
	}
}
