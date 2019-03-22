package com.example.militaryequipment;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CustomerHome extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customer_home);
		Button MJ,LWT,Cougar,LAV25,M109,Logout;
		MJ=(Button)findViewById(R.id.button1);
		LWT=(Button)findViewById(R.id.button2);
		LAV25=(Button)findViewById(R.id.button4);
		M109=(Button)findViewById(R.id.button5);
		Logout=(Button)findViewById(R.id.button3);
		
		Logout.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
	 			// TODO Auto-generated method stub
				Intent ad= new Intent(CustomerHome.this,LoginActivity.class);
				startActivity(ad);
			}
        	 });
		
		
		MJ.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
	 			// TODO Auto-generated method stub
				Intent ad= new Intent(CustomerHome.this,MJActivity.class);
				startActivity(ad);
			}
        	 });
		
		LWT.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
	 			// TODO Auto-generated method stub
				Intent ad= new Intent(CustomerHome.this,LWTActivity.class);
				startActivity(ad);
			}
        	 });
		
		LAV25.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
	 			// TODO Auto-generated method stub
				Intent ad= new Intent(CustomerHome.this,LAV25Activity.class);
				startActivity(ad);
			}
        	 });
		M109.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
	 			// TODO Auto-generated method stub
				Intent ad= new Intent(CustomerHome.this,M109Activity.class);
				startActivity(ad);
			}
        	 });
		
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.customer_home, menu);
		return true;
	}

}
