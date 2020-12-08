package com.example.lab4exam01;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;

public class CompareService extends Service {
	private final IBinder mBinder = new LocalBinder();
	public class LocalBinder extends Binder{
		CompareService getService(){
			return CompareService.this;
		}
	}
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return mBinder;
	}
	
	public int compare(int a,int b){
		if (a >= b) {
			return a;
		} else {
			return b;
		}
		
	}
	

}
