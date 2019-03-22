package com.example.militaryequipment;




import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class LAV25Booking extends Activity implements OnClickListener{
	EditText FullName,Address,SetDate;
	TextView Rent,Vehicle;
	Button PAY;
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lav25_booking);
        FullName=(EditText)findViewById(R.id.editText3);
        Address=(EditText)findViewById(R.id.editText4);
        SetDate=(EditText)findViewById(R.id.editText5);
        Rent=(TextView)findViewById(R.id.textView8);
        Vehicle=(TextView)findViewById(R.id.textView9);
        //Br=(EditText)findViewById(R.id.editText5);
        PAY=(Button)findViewById(R.id.button1);
        PAY.setOnClickListener(this);
        db=openOrCreateDatabase("MILITARYEQUIPMENT", Context.MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXISTS buy(FullName VARCHAR ,Address VARCHAR ,SetDate VARCHAR,Rent VARCHAR,Vehicle VARCHAR);");
	}
	public void onRadioButtonClicked(View view){
	  boolean checked =((RadioButton)view).isChecked();
	switch (view.getId()) {
	case R.id.radioButton1:
	if(checked)
		//Debit Card Booked
		break;
	case R.id.radioButton2:
		if(checked)
			//Credit Card Booked
			break;
	case R.id.radioButton3:
		if(checked)
			//Cash on Delivery
			break;}
	}
	public void onClick(View ad)
    {
    	if(ad==PAY)
    	{
    		if(FullName.getText().toString().trim().length()==0||
    		   Address.getText().toString().trim().length()==0||
    		   SetDate.getText().toString().trim().length()==0)
    		{
    			showMessage("Error", "Please enter all values");
    			return;
    		}
    		else{
    		db.execSQL("INSERT INTO buy VALUES('"+FullName.getText()+"','"+Address.getText()+
    				   "','"+SetDate.getText().toString()+"','"+Rent.getText()+"','"+Vehicle.getText()+"');");
    		showMessage("Success", "Payment Successfully");
    		clearText();
			  }
    	}
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lav25_booking, menu);
		return true;
	}
	public void showMessage(String title,String message)
    {
    	Builder builder=new Builder(this);
    	builder.setCancelable(true);
    	builder.setTitle(title);
    	builder.setMessage(message);
    	builder.show();
	}
    public void clearText()
    {
    	FullName.setText("");
    	Address.setText("");
    	SetDate.setText("");
    	//Br.setText("");
    	
    	
    }

}
