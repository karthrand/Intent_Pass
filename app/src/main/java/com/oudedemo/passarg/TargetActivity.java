package com.oudedemo.passarg;

import android.app.*;
import android.os.*;
import android.content.*;
import android.widget.*;

public class TargetActivity extends Activity
{
    private TextView tx;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //此处为指定对应的布局yaml
        setContentView(R.layout.target);
        tx=(TextView) findViewById(R.id.targetTextView1);
        
        /*  步骤四：接收参数并在TextView中显示  */
        /* 直接intent方式
         Intent  intent = getIntent();
         String  name   = intent.getStringExtra("name");
         Integer number = intent.getIntExtra("numbers",0);
        
        */
        
        
        //bundle+intent方式
        Intent  intent = getIntent();
        Bundle  bundle = intent.getExtras();
        String  name   = bundle.getString("name");
        Integer number = bundle.getInt("numbers");
        
        //TextView显示
        tx.setText("name:"+name+","+"number:"+number);
        
        /*  步骤四结束  */
    }
}
