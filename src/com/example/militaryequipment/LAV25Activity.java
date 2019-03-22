package com.example.militaryequipment;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LAV25Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lav25);
		Button Booknow;
		final ImageView image;
		Booknow=(Button)findViewById(R.id.button1);
		image=(ImageView)findViewById(R.id.imageView1);
		
		
	Booknow.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
	 			// TODO Auto-generated method stub
				Intent ad= new Intent(LAV25Activity.this,LAV25Booking.class);
				startActivity(ad);
			}
        	 });
	image.setOnClickListener(new OnClickListener(){
		@Override
		public void onClick(View v) {
 			// TODO Auto-generated method stub
			image.setImageResource(R.drawable.lav25);
		}
    	 });
	
	
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lav25, menu);
		return true;
	}

}
