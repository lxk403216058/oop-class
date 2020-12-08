package com.example.lab7exer01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.j256.ormlite.dao.ForeignCollection;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Stroke extends Activity {
	private EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7;
	private Button b1,b2,b3;
	private User user;
	private ListView listView;
	private int id;
	private List<Schedule> list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.schedule);
		Intent intent = getIntent();
		String name = intent.getStringExtra("name");
		String pass = intent.getStringExtra("pass");
		id = intent.getIntExtra("id", 0);
		ed1 = (EditText) findViewById(R.id.et1);
		ed2 = (EditText) findViewById(R.id.et2);
		ed3 = (EditText) findViewById(R.id.et3);
		ed4 = (EditText) findViewById(R.id.et4);
		ed5 = (EditText) findViewById(R.id.et5);
		ed6 = (EditText) findViewById(R.id.et6);
		ed7 = (EditText) findViewById(R.id.et7);
		b1 = ( Button) findViewById(R.id.bt1);
		b2 = ( Button) findViewById(R.id.bt2);
		b3 = ( Button) findViewById(R.id.bt3);
		listView = (ListView)findViewById(R.id.lv1);
		//ed1.setText(id+"");
		updateListView(id);
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String strokeName = ed1.getText().toString();
				String strokeContent = ed2.getText().toString();
				String strokeDate = ed3.getText().toString();
				if (strokeContent.equals("")||strokeContent.equals("")||strokeDate.equals("")) {
					Toast.makeText(Stroke.this,"名称、内容或日期为空",Toast.LENGTH_SHORT    ).show();
				}else {
					Schedule articleData2 = new Schedule(strokeName,strokeContent,strokeDate,user);
					new ScheduleDao(Stroke.this).insert(articleData2);
					updateListView(id);
					Toast.makeText(Stroke.this,"添加成功！",Toast.LENGTH_SHORT    ).show();
				}
				
			}
		});
        b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String strokeName = ed4.getText().toString();
				String strokeContent = ed5.getText().toString();
				String strokeDate = ed6.getText().toString();
				int id1 = 1;
				if (!ed7.getText().toString().equals("")) {
					id1 = Integer.parseInt(ed7.getText().toString()+"");
				} 
				if (strokeContent.equals("")||strokeContent.equals("")||strokeDate.equals("")||ed7.getText().toString().equals("")) {
					Toast.makeText(Stroke.this,"名称、内容、日期或id为空",Toast.LENGTH_SHORT    ).show();
				}else {
					Schedule articleData2 = new Schedule(id1,strokeName,strokeContent,strokeDate,user);
					new ScheduleDao(Stroke.this).update(articleData2);
					updateListView(id);
					Toast.makeText(Stroke.this,"修改成功！",Toast.LENGTH_SHORT    ).show();
				}
			}
		});
        b3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String strokeName = ed4.getText().toString();
				String strokeContent = ed5.getText().toString();
				String strokeDate = ed6.getText().toString();
				int id1 = 1;
				if (!ed7.getText().toString().equals("")) {
					id1 = Integer.parseInt(ed7.getText().toString()+"");
				} 
				if (strokeContent.equals("")||strokeContent.equals("")||strokeDate.equals("")||ed7.getText().toString().equals("")) {
					Toast.makeText(Stroke.this,"名称、内容、日期或id为空",Toast.LENGTH_SHORT    ).show();
				}else {
					Schedule articleData2 = new Schedule(id1,strokeName,strokeContent,strokeDate,user);
					new ScheduleDao(Stroke.this).delete(articleData2);
					updateListView(id);
					Toast.makeText(Stroke.this,"删除成功！",Toast.LENGTH_SHORT    ).show();
				}
			}
		});
        listView.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				ed4.setText(list.get(position).getStrokeName());
				ed5.setText(list.get(position).getStrokeContent());
				ed6.setText(list.get(position).getStrokeDate());
				ed7.setText(list.get(position).getId()+"");
			}
		});
	}
	public void updateListView(int id) {
		user = new UserDao(Stroke.this).queryById(id);
		ForeignCollection<Schedule> stroke = user.getSchedules();
		Iterator<Schedule> iterator = stroke.iterator();
		list  = new ArrayList<Schedule>();
        while (iterator.hasNext()) {
        	Schedule article = iterator.next();
            list.add(article);
        }
        
        
        ArrayAdapter<Schedule> adapter = new ArrayAdapter<Schedule>(this, 
        		android.R.layout.simple_list_item_1, list );
        listView.setAdapter(adapter);
	}
	
}
