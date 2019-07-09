package com.example.new_project1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class myDrawView1 extends View {
	
	public static final float MAX_BACKGROUND_RADIUS = 150f;
	public static final float BALL_RADIUS = 10f;
	public float cx=10f,cy=10f;

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		Paint mPaint=new Paint();
		mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
		
		//���������״�
		mPaint.setColor(Color.YELLOW);
		mPaint.setStyle(Paint.Style.FILL_AND_STROKE);//������ʽ��stroke������fill���
		mPaint.setFlags(5);//����������ϸ
		
		SweepGradient sgl=new SweepGradient(getWidth()/2f,getHeight()/2f,Color.YELLOW,Color.GREEN);//���ý���ɫ
		mPaint.setShader(sgl);//����ͼ����ӰЧ��
		
		canvas.drawCircle(getWidth()/2, getHeight()/2, MAX_BACKGROUND_RADIUS, mPaint);
		
		
		mPaint.setColor(Color.BLUE);
		mPaint.setShader(null);//ȡ��shader
		canvas.drawCircle(cx, cy, BALL_RADIUS, mPaint);
		
	}

	public myDrawView1(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public myDrawView1(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public myDrawView1(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}
	

}
