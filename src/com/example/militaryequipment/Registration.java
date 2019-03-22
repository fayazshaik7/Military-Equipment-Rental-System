package com.example.militaryequipment;




import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class Registration extends Activity implements OnClickListener{
	EditText Name,EmailId,Password,Mobile;
	Button SUBMIT;
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
        Name=(EditText)findViewById(R.id.editText1);
        EmailId=(EditText)findViewById(R.id.editText2);
        Password=(EditText)findViewById(R.id.editText3);
        Mobile=(EditText)findViewById(R.id.editText4);
        //Br=(EditText)findViewById(R.id.editText5);
        SUBMIT=(Button)findViewById(R.id.button1);
        SUBMIT.setOnClickListener(this);
        db=openOrCreateDatabase("MILITARYEQUIPMENT", Context.MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXISTS Military(Name VARCHAR ,EmailId VARCHAR PRIMARY KEY,Password VARCHAR, Mobile NUMBER);");
	}
	public void onClick(View ad)
    {
    	if(ad==SUBMIT)
    	{
    		if(Name.getText().toString().trim().length()==0||
    		   EmailId.getText().toString().trim().length()==0||
    		   Password.getText().toString().trim().length()==0||
    		   Mobile.getText().toString().trim().length()==0)
    		{
    			showMessage("Error", "Please enter all values");
    			return;
    		}
    		else if(Mobile.getText().toString().length()!=10){
				  Toast.makeText(Registration.this, "Enter 10 digits",Toast.LENGTH_LONG).show();
			  }else{
    		db.execSQL("INSERT INTO Military VALUES('"+Name.getText().toString()+"','"+EmailId.getText().toString()+
    				   "','"+Password.getText().toString()+"','"+Mobile.getText()+"');");
    		showMessage("Success", "Customer Registered Successfully");
    		clearText();
			  }
    	}
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registration, menu);
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
    	Name.setText("");
    	EmailId.setText("");
    	Password.setText("");
    	Mobile.setText("");
    	//Br.setText("");
    	EmailId.requestFocus();
    	
    }

}
