package com.shravan.map;



import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class page9 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg9);
        Button sub=(Button)findViewById(R.id. button1);
        sub.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// final EditText e1=(EditText) findViewById(R.id.fname);
			      //  final EditText e2=(EditText) findViewById(R.id.lname);
			        final EditText e3=(EditText) findViewById(R.id.email);
			     //   final EditText e4=(EditText) findViewById(R.id.pass);
			     //   final EditText e5=(EditText) findViewById(R.id.cpass);
			        //final EditText e6=(EditText) findViewById(R.id.duname);
			      //  final EditText e7=(EditText) findViewById(R.id.dob1);
			      //  final EditText e8=(EditText) findViewById(R.id.radio1);
			     //   final EditText e9=(EditText) findViewById(R.id.radio1);
			        final EditText e10=(EditText) findViewById(R.id.ph);
			       // final EditText e11=(EditText) findViewById(R.id.ad);
			        
			        

				final String SOAP_ACTION =  "http://tempuri.org/update";
				final String METHOD_NAME = "update";
				final String NAMESPACE = "http://tempuri.org/"; 						
				String url1=IP.getIp();
							
				SoapObject request = new SoapObject(NAMESPACE,METHOD_NAME);
				//request.addProperty("f", e1.getText().toString());
			//	request.addProperty("l", e2.getText().toString());
				request.addProperty("e", e3.getText().toString());
			//	request.addProperty("p", e4.getText().toString());
			//	request.addProperty("cp", e5.getText().toString());
				request.addProperty("du", user.getUser());
			//	request.addProperty("dob", e7.getText().toString());
				//request.addProperty("g", e8.getText().toString());
			//	request.addProperty("g1", e9.getText().toString());
				request.addProperty("ph", e10.getText().toString());
			//	request.addProperty("ad", e11.getText().toString());
				
				
				
				SoapSerializationEnvelope soapEnvelop = new SoapSerializationEnvelope(SoapEnvelope.VER11);
				
				soapEnvelop.dotNet=true;
				soapEnvelop.setOutputSoapObject(request);

				HttpTransportSE aht = new HttpTransportSE(url1);
				try
				{
					aht.call(SOAP_ACTION, soapEnvelop);
					SoapPrimitive resultString = (SoapPrimitive)soapEnvelop.getResponse();
					Toast.makeText(getApplicationContext(), resultString.toString(), 0).show();
		        }
				
			  
				catch (Exception exception) 
				{
					Toast.makeText(page9.this, "Error :" + exception.toString(), 1).show();
					Toast.makeText(page9.this, "Error :" + exception.getMessage(), 1).show();
				}

							
				
				 Intent i=new Intent();
				 i.setClass(page9.this, Page1.class);
			        startActivity(i);
			}
		});
 }
}