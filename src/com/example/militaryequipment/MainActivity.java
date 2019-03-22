package com.example.militaryequipment;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;


public class MainActivity extends Activity 
{


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		    Button Reg,Cus;
	        Reg=(Button)findViewById(R.id.button1);
	        Cus=(Button)findViewById(R.id.button2);
	        
	        
	        Reg.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
		 			// TODO Auto-generated method stub
					Intent ad= new Intent(MainActivity.this,Registration.class);
					startActivity(ad);
				}
	        	 });
	        
	        Cus.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
		 			// TODO Auto-generated method stub
					Intent ad= new Intent(MainActivity.this,LoginActivity.class);
					startActivity(ad);
				}
	        	 });	
	}
	
     @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		
	}



}
