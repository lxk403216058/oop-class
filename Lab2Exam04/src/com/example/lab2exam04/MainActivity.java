package com.example.lab2exam04;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	List<NumberInfo> minfos = new ArrayList<NumberInfo>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initData();
		NumberAdapter mAdapter = new NumberAdapter(this, minfos);
		ListView mlv = (ListView) findViewById(R.id.lv_test);
		mlv.setAdapter(mAdapter);
	}
	
	private void initData() {
		NumberInfo info = new NumberInfo();
		info.setId(1);
		info.setImageId(R.drawable.ic_lanuncher1);
		info.setNum("Tom");
		info.setNum1("中午一起去二食堂吃饭");
		minfos.add(info);
		info = new NumberInfo();
		info.setId(2);
		info.setImageId(R.drawable.ic_lanuncher2);
		info.setNum("Jerry");
		info.setNum1("中午一起去三食堂吃饭");
		minfos.add(info);
		info = new NumberInfo();
		info.setId(3);
		info.setImageId(R.drawable.ic_lanuncher3);
		info.setNum("小李");
		info.setNum1("请参加运动会的同学下午两点在操场集合");
		minfos.add(info);
		info = new NumberInfo();
		info.setId(4);
		info.setImageId(R.drawable.ic_lanuncher4);
		info.setNum("班级通知群");
		info.setNum1("今天下午两点开班会，请相互通知");
		minfos.add(info);
	}
}
