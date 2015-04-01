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

public class Page4 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg4);
        
        final EditText e1=(EditText) findViewById(R.id.p1);
        Button sub=(Button)findViewById(R.id.recover);
        sub.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
			
					{ 
						
						String url1=IP.getIp();
						final String SOAP_ACTION =  "http://tempuri.org/passwordrecovery";
						final String METHOD_NAME = "passwordrecovery";
						final String NAMESPACE = "http://tempuri.org/"; 						
						//String url1="http://kpo.tmspl.com/map/";
									
						SoapObject request = new SoapObject(NAMESPACE,METHOD_NAME);
						//request.addProperty(", e1.getText().toString());
						request.addProperty("e", e1.getText().toString());
											
						SoapSerializationEnvelope soapEnvelop = new SoapSerializationEnvelope(SoapEnvelope.VER11);
						
						soapEnvelop.dotNet=true;
						soapEnvelop.setOutputSoapObject(request);

						HttpTransportSE aht = new HttpTransportSE(url1);
						try
						{
							aht.call(SOAP_ACTION, soapEnvelop);
							SoapPrimitive resultString = (SoapPrimitive)soapEnvelop.getResponse();
							
							//Toast.makeText(Page1.this, "Hello " + " " + resultString.toString(), 1).show();
							Toast.makeText(Page4.this, "Your password has been sent to your email id  " + resultString.toString(), 1).show();
							//Toast.makeText(Page4.this, resultString.toString() + resultString.toString(), 1).show();
							if(e1.getText().toString().equalsIgnoreCase(resultString.toString()))
	                        {
	                        	Intent i=new Intent();
	                        	i.setClass(Page4.this, Page1.class);
	                        	//i.setClass(Page4.this, Page2.class);
	                				 user.setUser(e1.getText().toString());
	                			        startActivity(i);
	                        }
	                        else
	                        {
	                        	Toast.makeText(getApplicationContext(), "Give Proper Username!", 1).show();
	                        	
	                        }
	                }
						
					  
						catch (Exception exception) 
						{
							//Toast.makeText(Page4.this, "Error :" + exception.toString(), 1).show();
							//Toast.makeText(Page4.this, "Give Proper Username " + exception.getMessage(), 1).show();
							Toast.makeText(Page4.this, "Enter Proper email id! " + "", 1).show();
						}
		
					}
			 
			}
		});

        }
}