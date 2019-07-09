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
		
		//画出背景雷达
		mPaint.setColor(Color.YELLOW);
		mPaint.setStyle(Paint.Style.FILL_AND_STROKE);//画笔样式，stroke线条，fill填充
		mPaint.setFlags(5);//设置线条粗细
		
		SweepGradient sgl=new SweepGradient(getWidth()/2f,getHeight()/2f,Color.YELLOW,Color.GREEN);//设置渐变色
		mPaint.setShader(sgl);//设置图形阴影效果
		
		canvas.drawCircle(getWidth()/2, getHeight()/2, MAX_BACKGROUND_RADIUS, mPaint);
		
		
		mPaint.setColor(Color.BLUE);
		mPaint.setShader(null);//取消shader
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
