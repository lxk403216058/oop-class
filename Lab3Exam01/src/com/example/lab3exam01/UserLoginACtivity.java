package com.example.lab3exam01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserLoginACtivity extends Activity {
	private EditText ed1,ed2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_login);
		ed1 = (EditText) findViewById(R.id.ed1);
		ed2 = (EditText) findViewById(R.id.ed2);
		Button b1 = (Button) findViewById(R.id.bt1);

		b1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String account = ed1.getText().toString();
				String password = ed2.getText().toString();
				if (account.contains("@")) {
					 Toast ts = Toast.makeText(UserLoginACtivity.this,"�û����к���@", Toast.LENGTH_LONG);
					 ts.show();
				}else{
					Intent intent1 = new Intent();
					intent1.putExtra("account",account);
					intent1.putExtra("password", password);
					setResult(RESULT_OK, intent1);
					finish();
				}
				
			}
		});
	}
}
