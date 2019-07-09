package com.example.new_project1;

import com.example.new_project1.R;
import android.content.Context;
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


//import com.baidu.location.LocationClient;
//import com.baidu.location.LocationClientOption;
import com.baidu.location.*;





public class MainActivity extends Activity {
	

	private SensorManager sensorManager1;
	private Sensor sensor1;
	private LocationManager locationManager;
	private TextView tv1,tv2,tv3;
	private float gravity[]=new float[3];
	private boolean bRegSuccess=false;
	private int count=0;
	myDrawView1 myView1;
	private int state =0; 
	private static final float MAX_ACCELEROMETER = 9.81f;
	private int count_times = 0;
	Button sendBtn;
	EditText txtphoneNo;
	EditText txtMSG;

	
	LayoutParams para;
	public LocationClient mLocationClient = null;
	private MyLocationListener myListener = new MyLocationListener();
	//BDAbstractLocationListener为7.2版本新增的Abstract类型的监听接口
	//原有BDLocationListener接口暂时同步保留。具体介绍请参考后文中的说明
	
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
    public class MyLocationListener implements BDAbstractLocationListener{
        @Override
        public void onReceiveLocation(BDLocation location){
            //此处的BDLocation为定位结果信息类，通过它的各种get方法可获取定位相关的全部结果
            //以下只列举部分获取地址相关的结果信息
            //更多结果信息获取说明，请参照类参考中BDLocation类中的说明
    			
            String addr = location.getAddrStr();    //获取详细地址信息
            String country = location.getCountry();    //获取国家
            String province = location.getProvince();    //获取省份
            String city = location.getCity();    //获取城市
            String district = location.getDistrict();    //获取区县
            String street = location.getStreet();    //获取街道信息
        }
    }
    
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
		
		mLocationClient = new LocationClient(getApplicationContext());     
	    //声明LocationClient类
	    mLocationClient.registerLocationListener(myListener);    
	    //注册监听函数
	    LocationClientOption option = new LocationClientOption();

		option.setIsNeedAddress(true);
		//可选，是否需要地址信息，默认为不需要，即参数为false
		//如果开发者需要获得当前点的地址信息，此处必须为true

		mLocationClient.setLocOption(option);
		//mLocationClient为第二步初始化过的LocationClient对象
		//需将配置好的LocationClientOption对象，通过setLocOption方法传递给LocationClient对象使用
		//更多LocationClientOption的配置，请参照类参考中LocationClientOption类的详细说明

		myView1=(myDrawView1)findViewById(R.id.myDrawView1);

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
	
	//private SensorEventListener listener = new SensorEventListener() {	
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
				
				DrawBall(-gravity[0],gravity[1]);
				//Toast.makeText(getApplicationContext(), "Moved!", Toast.LENGTH_SHORT).show();
			
			}
			@Override
			public void onAccuracyChanged(Sensor sensor, int accuracy) {	
				
			}
			
		};
		private void DrawBall(float x,float y)
		{
			float max_x=myDrawView1.MAX_BACKGROUND_RADIUS-myDrawView1.BALL_RADIUS;//x方向可移动的最大距离
			float max_y=myDrawView1.MAX_BACKGROUND_RADIUS-myDrawView1.BALL_RADIUS;//y方向可移动的最大距离
			
			float percentageX= x/MAX_ACCELEROMETER;//x方向的受力，决定其在x轴的相对位置
			float percentageY= y/MAX_ACCELEROMETER;//y方向的受力，决定其在y轴的相对位置
			
			int pixel_x=(int) (max_x * percentageX); //x轴的距离
			int pixel_y=(int) (max_y * percentageY); //y轴的距离
			
			myView1.cx= myView1.getWidth()/2 + pixel_x; //相对于圆心进行偏移，获得小球应该绘制的中心坐标
			myView1.cy= myView1.getHeight()/2 +pixel_y; //
			
			myView1.postInvalidate();
			
		}	
		
		protected void sendSMSMessage() {
			
		      String phoneNo = txtphoneNo.getText().toString();;//15626028940
		      String message = "猪爸爸摔倒了，请去营救\n"+"经度"+location.getLongitude()+" 纬度"+location.getLatitude();

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
