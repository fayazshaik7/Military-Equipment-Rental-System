package com.example.militaryequipment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	EditText Email, Pwd;
	Button Log;
	 String u;
	 String p;
	 SQLiteDatabase db;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final GlobalClass globalvariabel = (GlobalClass)getApplicationContext();
		setContentView(R.layout.activity_login);
		Email = (EditText) findViewById(R.id.editText1);
		Pwd= (EditText) findViewById(R.id.editText2);
		Log=(Button) findViewById(R.id.button1);
		Log.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub			
				if(Email.getText().toString().equals("")||Pwd.getText().toString().equals("")){
					
					Toast.makeText(LoginActivity.this, "Please enter the fields..!", Toast.LENGTH_LONG).show();
				}else{	 
					 u = Email.getText().toString();
					 p = Pwd.getText().toString();
					 try{
					          db=openOrCreateDatabase("MILITARYEQUIPMENT",SQLiteDatabase.CREATE_IF_NECESSARY,null);					    
					        }catch(Exception exception){
					            exception.printStackTrace();
					        }try{
					        	 Cursor cc = db.rawQuery("select * from Military where EmailId = '"+u+"' and Password= '"+p+"' ", null);
					        	 					        	 if(Email.getText().toString().equals("admin")&& Pwd.getText().toString().equals("admin")){
					        		 Toast.makeText(LoginActivity.this, "Welcome To Admin Home Page "  + u , Toast.LENGTH_LONG).show();
					            		globalvariabel.SetUserName(Email.getText().toString().trim());
					    				globalvariabel.SetPassword(Pwd.getText().toString().trim());	
					        		 Intent i = new Intent(LoginActivity.this,AdminHome.class);
					            		startActivity(i);
									}
					        	 // Student Login
					        	 else if(cc.moveToFirst())
					        		 {String temp="";					       
						            if (cc != null) {
						            	if(cc.getCount() > 0)
						            	{
						            	//return true;
						            scan g=new scan();
						            g.execute();
						            
						            		Toast.makeText(LoginActivity.this, "Welcome To Military equipments home "  + u , Toast.LENGTH_LONG).show();
						            		globalvariabel.SetUserName(Email.getText().toString().trim());
						    				globalvariabel.SetPassword(Pwd.getText().toString().trim());	
						            		Intent i = new Intent(LoginActivity.this,CustomerHome.class);
						            		startActivity(i);
						            	}
						            	else
						            	{
						            		 Toast.makeText(LoginActivity.this, "Login Fails..!", Toast.LENGTH_LONG).show();
						            	}
						            	}
					        		 }
					        	
					        }catch(Exception exception){
					            exception.printStackTrace();
					        }
						}	 	
				}
		});
		
	
		
		
	}
	public class scan extends AsyncTask<String, String, String>{

		private ProgressDialog pd;

		protected void onPreExecute() {
			super.onPreExecute();
		 pd = new ProgressDialog(LoginActivity.this);
		 pd.setTitle("Please Wait");
		 pd.setMessage("Logging....");
		 pd.setMax(200);
		 pd.show();
		}
		
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	

	

}
