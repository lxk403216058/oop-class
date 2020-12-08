package com.example.lab6exam01;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button btn;
    private TextView city_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);

        city_result=(TextView) findViewById(R.id.city_result);

    }


    private final static String PATH="http://api.seniverse.com/v3/weather/daily.json?key=l57oxruu6tlsxnw4&location=nanchang&language=zh-Hans&unit=c&start=0&days=3";
    protected static final int SUCCESS = 0;
    protected static final int INVALID_CITY = 1;
    protected static final int ERROR = 2;

    private String city;
    String ul;


    private Handler mhandler=new Handler(){
        public void handleMessage(android.os.Message msg) {
            dialog.dismiss();
            switch (msg.what) {
                case SUCCESS:

                    JSONArray data=(JSONArray) msg.obj;
                    try {
                        //String day01= data.getString(0);
                        String str = "";
                        JSONObject data_results = data.getJSONObject(0);
                        JSONObject data_location = data_results.getJSONObject("location");
                        str += data_location.getString("name");

                        JSONArray data_daily = data_results.getJSONArray("daily");
                        JSONObject[] data_daily_dates = {data_daily.getJSONObject(0),data_daily.getJSONObject(1),data_daily.getJSONObject(2),};
                        for (int i = 0; i < data_daily_dates.length; i++) {
                            str += "\n\n日期： " + data_daily_dates[i].getString("date") +
                                    " 白天： " + data_daily_dates[i].getString("text_day") + " " +data_daily_dates[i].getString("code_day") + "℃" +
                                    " 夜晚： " + data_daily_dates[i].getString("text_night") + " " +data_daily_dates[i].getString("code_night") + "℃" +
                                    " 最高气温： " + data_daily_dates[i].getString("high") + "℃ 最低气温： " +data_daily_dates[i].getString("low") + "℃";
                        }

                        city_result.setText(str);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;



                case INVALID_CITY:
                    Toast.makeText(MainActivity.this, "城市无效", Toast.LENGTH_SHORT).show();
                    break;
                case ERROR:
                    Toast.makeText(MainActivity.this, "网络无效", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        };
    };
    ProgressDialog dialog=null;

    public void onClick(View v) {
        // TODO Auto-generated method stub
        dialog=new ProgressDialog(this);
        dialog.setMessage("正在玩命加载中");
        dialog.show();
        //发起请求给那个网站
        new Thread(){
            public void run() {
                try {
                    ul=PATH;

                    URL url=new URL(ul);

                    //设置必要的参数信息
                    HttpURLConnection conn=(HttpURLConnection) url.openConnection();
                    conn.setConnectTimeout(5000);
                    conn.setRequestMethod("GET");

                    //判断响应码
                    int code = conn.getResponseCode();
                    if(code==200){
                        //连接网络成功
                        InputStream in = conn.getInputStream();
                        String data = StreamTool.decodeStream(in);


                        //解析json格式的数据
                        JSONObject jsonObj=new JSONObject(data);
                        //遍历数组
                        JSONArray results = jsonObj.getJSONArray("results");
                        if(results.length()>0){
                            //返回了需要的数据
                            JSONArray jsonArray = jsonObj.getJSONArray("results");
                            //通知更新ui
                            Message msg = Message.obtain();
                            msg.obj=jsonArray;
                            msg.what=SUCCESS;
                            mhandler.sendMessage(msg);
                        }else{
                            //城市无效
                            Message msg=Message.obtain();
                            msg.what=INVALID_CITY;
                            mhandler.sendMessage(msg);
                        }
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    Message msg = Message.obtain();
                    msg.what=ERROR;
                    mhandler.sendMessage(msg);
                }
            };
        }.start();
    }

}
