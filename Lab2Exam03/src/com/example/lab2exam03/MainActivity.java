package com.example.lab2exam03;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final TextView textView = (TextView)findViewById(R.id.TextView01);
        ListView listView = (ListView)findViewById(R.id.ListView01);
        
        List<String> list  = new ArrayList<String>();
        list .add("ListView����1");
        list .add("ListView����2");
        list .add("ListView����3");
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
        		android.R.layout.simple_list_item_1, list );
        listView.setAdapter(adapter);
		
		AdapterView.OnItemClickListener listViewListener = new AdapterView.OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) { 
				String msg = "��View��"+arg0.toString()+"\n"+
				"��View��"+arg1.toString()+"\n"+
				"λ�ã�"+String.valueOf(arg2)+"��ID��"+String.valueOf(arg3);
				textView.setText(msg);
			}};
			
		listView.setOnItemClickListener(listViewListener);
}

}
