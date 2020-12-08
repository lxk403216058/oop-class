package com.example.lab2exam04;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NumberAdapter extends BaseAdapter {

	Context mcontext;
	List<NumberInfo> minfos;
	
	public NumberAdapter(Context context, List<NumberInfo> infos) {        
		this.mcontext = context;
		this.minfos = infos;
	}
	@Override
	public int getCount() {
		//在此适配器中所代表的数据集中的条目数
		return minfos.size();
	}
	@Override
	public Object getItem(int i) {
		//获取数据集中与指定索引对应的数据项
		return minfos.get(i);
	}
	
	@Override
	public long getItemId(int i) {
		// TODO Auto-generated method stub
		return minfos.get(i).getId();
	}
	
	@Override
	public View getView(int position,View convertView,ViewGroup partent){
		convertView = LayoutInflater.from(mcontext).inflate(R.layout.item_number, null);
		ImageView mImageView = (ImageView) convertView.findViewById(R.id.iv_num);
		TextView mTextView = (TextView) convertView.findViewById(R.id.tv_num);
		TextView mTextView1 = (TextView) convertView.findViewById(R.id.tv_num1);
		mImageView.setImageResource(minfos.get(position).getImageId());
		mTextView.setText(minfos.get(position).getNum());
		mTextView1.setText(minfos.get(position).getNum1());
		
		return convertView;
	}

}
