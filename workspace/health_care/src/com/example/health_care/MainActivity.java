package com.example.health_care;

import com.example.health_care.R;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.telephony.SmsManager;
import java.util.Timer;  
import java.util.TimerTask;  


public class MainActivity extends Activity {
	private SensorManager sensorManager1;
	private Sensor sensor1;
	private TextView tv1,tv2,tv3;
	private float gravity[]=new float[3];
	private boolean bRegSuccess=false;
	private int state =0; 
	private static final float MAX_ACCELEROMETER = 9.81f;
	private int count_times = 0;
	Button sendBtn;
	EditText txtphoneNo;
	EditText txtMSG;

	
	final Handler myHandler = new Handler()  
    {  
      @Override  
      //重写handleMessage方法,根据msg中what的值判断是否执行后续操作  
      public void handleMessage(Message msg) {  
    	  if(state ==1){
    		  count_times++;
    		  if(count_times>3){
    			  count_times = 0;
    			  Toast.makeText(getApplicationContext(), "发送短信",Toast.LENGTH_SHORT).show();
    			  sendSMSMessage();
    		   }
    	  }
   	 
//    		  sendSMSMessage();
   	  }
    	  
    };  
    
    
	TimerTask task = new TimerTask(){    
		     public void run(){    
		     //execute the task     
		     }    
		 };    
		 Timer timer = new Timer();  


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.textView1);
		tv2=(TextView)findViewById(R.id.textView2);
		tv3=(TextView)findViewById(R.id.textView3);
		sensorManager1=(SensorManager)getSystemService(SENSOR_SERVICE);
		sensor1=sensorManager1.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		bRegSuccess=sensorManager1.registerListener(listener1, sensor1, SensorManager.SENSOR_DELAY_GAME);

		txtphoneNo = (EditText) findViewById(R.id.editText1);
		new Timer().schedule(new TimerTask() {            
            @Override  
            public void run() {  
                myHandler.sendEmptyMessage(0x123);  
                  
            }  
        }, 0,500);  
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    private SensorEventListener listener1= new SensorEventListener(){
		
		@Override
		public void onSensorChanged(SensorEvent event) {
			gravity[0]=event.values[0];
			gravity[1]=event.values[1];
			gravity[2]=event.values[2];
			if((gravity[2]>10)|(gravity[1]>10)|(gravity[0]>10))
			{
				state = 1;				
			}
			if((gravity[2]<10)&(gravity[1]<10)&(gravity[0]<10))
			{
				state = 0;
			}
			tv1.setText("x="+ gravity[0]);
			tv2.setText("y="+ gravity[1]);
			tv3.setText("z="+ gravity[2]);
			
			//Toast.makeText(getApplicationContext(), "Moved!", Toast.LENGTH_SHORT).show();
		
		}
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {	
			
		}
		
	};
	
	
	protected void sendSMSMessage() {
		
	      String phoneNo = txtphoneNo.getText().toString();;//15626028940
//	      String message = "猪爸爸摔倒了，请去营救\n"+"经度"+location.getLongitude()+" 纬度"+location.getLatitude();
	      String message = "猪爸爸摔倒了，请去营救\n";	
	      try {
	         SmsManager smsManager = SmsManager.getDefault();
	         smsManager.sendTextMessage(phoneNo, null, message, null, null);
	         Toast.makeText(getApplicationContext(), "SMS sent.",
	         Toast.LENGTH_LONG).show();
	      } catch (Exception e) {
	         Toast.makeText(getApplicationContext(),
	         "SMS faild, please try again.",
	         Toast.LENGTH_LONG).show();
	         e.printStackTrace();
	      }
	   }		
    
}
