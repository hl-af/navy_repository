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
	//BDAbstractLocationListenerΪ7.2�汾������Abstract���͵ļ����ӿ�
	//ԭ��BDLocationListener�ӿ���ʱͬ�����������������ο������е�˵��
	
	final Handler myHandler = new Handler()  
    {  
      @Override  
      //��дhandleMessage����,����msg��what��ֵ�ж��Ƿ�ִ�к�������  
      public void handleMessage(Message msg) {  
    	  if(state ==1){
    		  count_times++;
    		  if(count_times>3){
    			  count_times = 0;
    			  Toast.makeText(getApplicationContext(), "���Ͷ���",Toast.LENGTH_SHORT).show();
    			  sendSMSMessage();
    		   }
    	  }
   	 
//    		  sendSMSMessage();
   	  }
    	  
    };  
    public class MyLocationListener implements BDAbstractLocationListener{
        @Override
        public void onReceiveLocation(BDLocation location){
            //�˴���BDLocationΪ��λ�����Ϣ�࣬ͨ�����ĸ���get�����ɻ�ȡ��λ��ص�ȫ�����
            //����ֻ�оٲ��ֻ�ȡ��ַ��صĽ����Ϣ
            //��������Ϣ��ȡ˵�����������ο���BDLocation���е�˵��
    			
            String addr = location.getAddrStr();    //��ȡ��ϸ��ַ��Ϣ
            String country = location.getCountry();    //��ȡ����
            String province = location.getProvince();    //��ȡʡ��
            String city = location.getCity();    //��ȡ����
            String district = location.getDistrict();    //��ȡ����
            String street = location.getStreet();    //��ȡ�ֵ���Ϣ
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
	    //����LocationClient��
	    mLocationClient.registerLocationListener(myListener);    
	    //ע���������
	    LocationClientOption option = new LocationClientOption();

		option.setIsNeedAddress(true);
		//��ѡ���Ƿ���Ҫ��ַ��Ϣ��Ĭ��Ϊ����Ҫ��������Ϊfalse
		//�����������Ҫ��õ�ǰ��ĵ�ַ��Ϣ���˴�����Ϊtrue

		mLocationClient.setLocOption(option);
		//mLocationClientΪ�ڶ�����ʼ������LocationClient����
		//�轫���úõ�LocationClientOption����ͨ��setLocOption�������ݸ�LocationClient����ʹ��
		//����LocationClientOption�����ã��������ο���LocationClientOption�����ϸ˵��

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
			float max_x=myDrawView1.MAX_BACKGROUND_RADIUS-myDrawView1.BALL_RADIUS;//x������ƶ���������
			float max_y=myDrawView1.MAX_BACKGROUND_RADIUS-myDrawView1.BALL_RADIUS;//y������ƶ���������
			
			float percentageX= x/MAX_ACCELEROMETER;//x�������������������x������λ��
			float percentageY= y/MAX_ACCELEROMETER;//y�������������������y������λ��
			
			int pixel_x=(int) (max_x * percentageX); //x��ľ���
			int pixel_y=(int) (max_y * percentageY); //y��ľ���
			
			myView1.cx= myView1.getWidth()/2 + pixel_x; //�����Բ�Ľ���ƫ�ƣ����С��Ӧ�û��Ƶ���������
			myView1.cy= myView1.getHeight()/2 +pixel_y; //
			
			myView1.postInvalidate();
			
		}	
		
		protected void sendSMSMessage() {
			
		      String phoneNo = txtphoneNo.getText().toString();;//15626028940
		      String message = "��ְ�ˤ���ˣ���ȥӪ��\n"+"����"+location.getLongitude()+" γ��"+location.getLatitude();

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
