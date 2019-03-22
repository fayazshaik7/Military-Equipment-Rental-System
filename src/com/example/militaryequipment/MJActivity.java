package com.example.militaryequipment;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MJActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mj);
		Button Booknow;
		final ImageView image;
		Booknow=(Button)findViewById(R.id.button1);
		image=(ImageView)findViewById(R.id.imageView1);
		
		
	Booknow.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
	 			// TODO Auto-generated method stub
				Intent ad= new Intent(MJActivity.this,MJBooking.class);
				startActivity(ad);
			}
        	 });
	image.setOnClickListener(new OnClickListener(){
		@Override
		public void onClick(View v) {
 			// TODO Auto-generated method stub
			image.setImageResource(R.drawable.jeep);
		}
    	 });
	
	
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mj, menu);
		return true;
	}

}
