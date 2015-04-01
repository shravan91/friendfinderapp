package com.shravan.map;



import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.ksoap2.serialization.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Page1 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg1);
        
        
        
        final EditText e1=(EditText) findViewById(R.id.Usernamemain);
        final EditText e2=(EditText) findViewById(R.id.passwordmain);
        
        
        
        Button sub=(Button)findViewById(R.id. button1);
        sub.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				/*	if(e1.getText().length()==0 || e2.getText().length()==0)
					{
					
						Toast.makeText(getApplicationContext(), "Give Proper Value...!!", Toast.LENGTH_LONG).show();
						
					}
				else*/
					{ 
						
						String url1=IP.getIp();
						final String SOAP_ACTION =  "http://tempuri.org/login";
						final String METHOD_NAME = "login";
						final String NAMESPACE = "http://tempuri.org/"; 						
						//String url1="http://kpo.tmspl.com/map/";
									
						SoapObject request = new SoapObject(NAMESPACE,METHOD_NAME);
						request.addProperty("u", e1.getText().toString());
						request.addProperty("p", e2.getText().toString());
											
						SoapSerializationEnvelope soapEnvelop = new SoapSerializationEnvelope(SoapEnvelope.VER11);
						
						soapEnvelop.dotNet=true;
						soapEnvelop.setOutputSoapObject(request);

						HttpTransportSE aht = new HttpTransportSE(url1);
						try
						{
							aht.call(SOAP_ACTION, soapEnvelop);
							SoapPrimitive resultString = (SoapPrimitive)soapEnvelop.getResponse();
							
							Toast.makeText(Page1.this, "Hello " + " " + resultString.toString(), 1).show();
							if(e1.getText().toString().equalsIgnoreCase(resultString.toString()))
	                        {
	                        	Intent i=new Intent();
	                				 i.setClass(Page1.this, Page2.class);
	                				 user.setUser(e1.getText().toString());
	                			        startActivity(i);
	                        }
	                        else
	                        {
	                        	Toast.makeText(getApplicationContext(), "Your Username and Password is not right!", 1).show();
	                        	
	                        }
	                }
						
					  
						catch (Exception exception) 
						{
							Toast.makeText(Page1.this, "Error :" + exception.toString(), 1).show();
							Toast.makeText(Page1.this, "Error :" + exception.getMessage(), 1).show();
						}
		
						
						
						
						
			
					}
			 
			}
		});
        Button sub1=(Button)findViewById(R.id.button2);
        sub1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Intent i=new Intent();
				 i.setClass(Page1.this, Page3.class);
			        startActivity(i);
			}
		});
   /*     Button sub3=(Button)findViewById(R.id.editbutton);
        sub3.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Intent i=new Intent();
				 i.setClass(Page1.this, page9.class);
			        startActivity(i);
			}
		});*/
        Button sub2=(Button)findViewById(R.id.button3);
        sub2.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Intent i=new Intent();
				 i.setClass(Page1.this, Page4.class);
			        startActivity(i);
			}
		});
    
 }
}