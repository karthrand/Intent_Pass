package com.oudedemo.passarg;

import android.app.*;
import android.os.*;
import android.content.*;
import android.widget.*;
import android.view.*;

public class TargetActivity extends Activity
{
    private TextView tx;
    private EditText et;
    private Button bn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //此处为指定对应的布局yaml
        setContentView(R.layout.target);
        tx=(TextView) findViewById(R.id.targetTextView1);
        et=(EditText) findViewById(R.id.targetEditText1);
        bn=(Button) findViewById(R.id.targetButton1);
        
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
        
        /* 步骤5 点击按钮后返回输入框内的信息   */
        bn.setOnClickListener(new View.OnClickListener(){
                private String result;

                @Override
                public void onClick(View p1)
                {
                    
                }
            });
    }
    /*  也是步骤五：防止用户使用回退键返回  */
    @Override
    public void onBackPressed()
    {
        String result = et.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("result",result);
        setResult(RESULT_OK,intent);
        finish();
    }
}
