 package com.example.militaryequipment;

import com.example.militaryequipment.R;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AdminHome extends Activity implements OnClickListener{
	Button ddr;
	Button car;
	SQLiteDatabase db;
	EditText FullName,BookingDate,Vehicle,Rent;
	Button Logout;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin_home);
		ddr=(Button)findViewById(R.id.button1);
		ddr.setOnClickListener(this);
		car=(Button)findViewById(R.id.button3);
		car.setOnClickListener(this);
		Logout=(Button)findViewById(R.id.button2);
		
		
		Logout.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
	 			// TODO Auto-generated method stub
				Intent ad= new Intent(AdminHome.this,MainActivity.class);
				startActivity(ad);
			}
        	 });
		

		 db=openOrCreateDatabase("MILITARYEQUIPMENT", Context.MODE_PRIVATE, null);

    	
}
	
	
	public void showMessage(String title,String message)
    {
    	Builder builder=new Builder(this);
    	builder.setCancelable(true);
    	builder.setTitle(title);
    	builder.setMessage(message);
    	builder.show();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==ddr)
    	{
    		Cursor c=db.rawQuery("SELECT * FROM buy", null);
    		if(c.getCount()==0)
    		{
    			showMessage("Error", "No records found");
    			return;
    		}
    		StringBuffer buffer=new StringBuffer();
    		while(c.moveToNext())
    		{
    			buffer.append("FullName: "+c.getString(0)+"\n");
    			buffer.append("BookingDate: "+c.getString(2)+"\n");
    			buffer.append("Vehicle: "+c.getString(3)+"\n");
    			buffer.append("Rent: "+c.getString(4)+"\n\n");
    			
    		}
    		showMessage("Daily Deposit Report", buffer.toString());
    	}
		if(v==car)
    	{
    		Cursor c=db.rawQuery("SELECT * FROM buy", null);
    		if(c.getCount()==0){
    			
    			showMessage("Error", "No records found");
    			return;
    		}
    		
    		
    		
    		StringBuffer buffer=new StringBuffer();
    		while(c.moveToNext())
    		{
    			buffer.append("Vehicle: "+c.getString(3)+"\n\n");
    			buffer.append("Rent: "+c.getString(4)+"\n\n");
    			buffer.append("FullName: "+c.getString(0)+"\n");
    			buffer.append("Address: "+c.getString(1)+"\n");
    			buffer.append("BookingDate: "+c.getString(2)+"\n\n\n");
    
    		}
    		
    		showMessage("Cashier Accountability Report", buffer.toString());
    	}
		
	}
	
	
	}
		
	

