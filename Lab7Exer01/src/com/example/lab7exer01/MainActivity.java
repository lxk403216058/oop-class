package com.example.lab7exer01;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.j256.ormlite.dao.ForeignCollection;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText username,password;
	private Button login;
	//private StringBuffer contentBuffer;
	//private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		username = (EditText) findViewById(R.id.ed1);
		password = (EditText) findViewById(R.id.ed2);
		//tv = (TextView) findViewById(R.id.tv1);
		login = (Button) findViewById(R.id.bt1);
		login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int flag = 0;
				String name = username.getText().toString();
				String pass = password.getText().toString();
				int id = 0;
				List<User> list = new UserDao(MainActivity.this).selectAll();
				for (User user:list){
					if (user.getName().equals(name)&&user.getPassword().equals(pass)) {
						flag = 1;
						id = user.getId();
						break;
					}
				}
				if (flag == 1) {
					Intent intent = new Intent(MainActivity.this, Stroke.class);
					intent.putExtra("name", name);
					intent.putExtra("pass", pass);
					intent.putExtra("id", id);
					
					
					startActivityForResult(intent, 1);
				}else {
					Toast.makeText(MainActivity.this,"�û������������",Toast.LENGTH_SHORT    ).show();
				}
				
			}
		});
		//contentBuffer = new StringBuffer();
        //initData();
        //initView();
	}
	// ��ʼ������
	/*
    private void initData() {
        // ����û�����
        User userData = new User("12345","12345");
        new UserDao(MainActivity.this).insert(userData);
        // �����������
        Schedule articleData = new Schedule("�г�","�г�����",new Date(),userData);
        new ScheduleDao(MainActivity.this).insert(articleData);
        Schedule articleData1 = new Schedule("�г�1","�г�����1",new Date(),userData);
        new ScheduleDao(MainActivity.this).insert(articleData1);
        Schedule articleData2 = new Schedule("�г�2","�г�����2",new Date(),userData);
        new ScheduleDao(MainActivity.this).insert(articleData2);
    }

    // ��ʼ����ͼ
    private void initView() {
        // �����ݿ��и���IDȡ��������Ϣ
    	Schedule schedule = new ScheduleDao(MainActivity.this).queryById(2);
        contentBuffer.append(schedule.toString());
        // ����ȡ�����û�id��ѯ�û���Ϣ
        User user = new UserDao(MainActivity.this).queryById(schedule.getUser_id().getId());
        contentBuffer.append("\n\n" + user.toString());
        // ���û���Ϣ��ȡ�������������б���Ϣ
        ForeignCollection<Schedule> articles = user.getSchedules();
        Iterator<Schedule> iterator = articles.iterator();
        contentBuffer.append("\n\n");
        while (iterator.hasNext()) {
        	Schedule article = iterator.next();
            contentBuffer.append(article.toString() + "\n");
        }
        // ����TextView���ı�
        tv.setText(contentBuffer.toString());
    }*/
}
