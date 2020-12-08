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
					Toast.makeText(MainActivity.this,"用户名或密码错误",Toast.LENGTH_SHORT    ).show();
				}
				
			}
		});
		//contentBuffer = new StringBuffer();
        //initData();
        //initView();
	}
	// 初始化数据
	/*
    private void initData() {
        // 添加用户数据
        User userData = new User("12345","12345");
        new UserDao(MainActivity.this).insert(userData);
        // 添加文章数据
        Schedule articleData = new Schedule("行程","行程内容",new Date(),userData);
        new ScheduleDao(MainActivity.this).insert(articleData);
        Schedule articleData1 = new Schedule("行程1","行程内容1",new Date(),userData);
        new ScheduleDao(MainActivity.this).insert(articleData1);
        Schedule articleData2 = new Schedule("行程2","行程内容2",new Date(),userData);
        new ScheduleDao(MainActivity.this).insert(articleData2);
    }

    // 初始化视图
    private void initView() {
        // 从数据库中根据ID取出文章信息
    	Schedule schedule = new ScheduleDao(MainActivity.this).queryById(2);
        contentBuffer.append(schedule.toString());
        // 根据取出的用户id查询用户信息
        User user = new UserDao(MainActivity.this).queryById(schedule.getUser_id().getId());
        contentBuffer.append("\n\n" + user.toString());
        // 从用户信息中取出关联的文章列表信息
        ForeignCollection<Schedule> articles = user.getSchedules();
        Iterator<Schedule> iterator = articles.iterator();
        contentBuffer.append("\n\n");
        while (iterator.hasNext()) {
        	Schedule article = iterator.next();
            contentBuffer.append(article.toString() + "\n");
        }
        // 设置TextView的文本
        tv.setText(contentBuffer.toString());
    }*/
}
