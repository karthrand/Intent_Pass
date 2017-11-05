package com.oudedemo.passarg;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.content.*;

public class MainActivity extends Activity 
{
    private Button button;
    private EditText et1,et2;
    private String name,test;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setContentView(R.layout.main);
        //对象绑定
        button=(Button) findViewById(R.id.mainButton1);
        et1=(EditText) findViewById(R.id.mainEditText1);
        et2=(EditText) findViewById(R.id.mainEditText2);
        
        //button实现点击事件
        button.setOnClickListener(new View.OnClickListener(){

                private int number;

                @Override
                public void onClick(View p1)
                {
                    /*  步骤三:实现参数获取及传递 */
                    //1.创建对象
                    Intent intent=new Intent();
                    
                    //2.获取EditText的值
                    name=et1.getText().toString();
                    
                    test=et2.getText().toString();
                    try{
                        //当EditText为空时转化为int会报错
                        number=Integer.parseInt(test);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    
                    /* 直接intent方式：
                     intent.putExtra("name", name);
                     intent.putExtra("numbers", number);
                    */
                    
                    //bundle+intent方式
                    Bundle bundle = new Bundle();
                    bundle.putString("name", name);
                    bundle.putInt("numbers",number);
                    intent.putExtras(bundle);
                    
                    //跳转
                    intent.setClass(MainActivity.this,TargetActivity.class);
                    startActivity(intent);
                    MainActivity.this.finish();
                    
                }
            });
                     
    }
}
