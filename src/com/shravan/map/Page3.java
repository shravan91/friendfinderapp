package com.shravan.map;



import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class Page3 extends Activity {
	String gen="Male";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg3);
        
        
            Button sub=(Button)findViewById(R.id. button1);
        sub.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 final EditText e1=(EditText) findViewById(R.id.editText1);
			        final EditText e2=(EditText) findViewById(R.id.EditText01);
			        final EditText e3=(EditText) findViewById(R.id.editText2);
			        final EditText e4=(EditText) findViewById(R.id.editText3);
			        final EditText e5=(EditText) findViewById(R.id.EditText02);
			        final EditText e6=(EditText) findViewById(R.id.editText4);
			        final EditText e7=(EditText) findViewById(R.id.editText7);
			      //  final EditText e8=(EditText) findViewById(R.id.radio1);
			     //   final EditText e9=(EditText) findViewById(R.id.radio1);
			        final EditText e10=(EditText) findViewById(R.id.editText6);
			        final EditText e11=(EditText) findViewById(R.id.editText8);
			        
			         
			         
			        RadioGroup rg=(RadioGroup)findViewById(R.id.radioGroup2);

			        rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			                        public void onCheckedChanged(RadioGroup group, int checkedId) {
			                                // TODO Auto-generated method stub
			                                RadioButton rb=(RadioButton)findViewById(R.id.radio0);
			                                if(rb.isChecked())
			                                {
			                                	gen="Male";
			                                }
			                                else
			                                {
			                                	gen="Female";
			                                }
			                        }
			                });

				final String SOAP_ACTION =  "http://tempuri.org/reg";
				final String METHOD_NAME = "reg";
				final String NAMESPACE = "http://tempuri.org/"; 						
				String url1=IP.getIp();
							
				SoapObject request = new SoapObject(NAMESPACE,METHOD_NAME);

				request.addProperty("f", e1.getText().toString());
				request.addProperty("l", e2.getText().toString());
				request.addProperty("e", e3.getText().toString());
				request.addProperty("p", e4.getText().toString());
				request.addProperty("cp", e5.getText().toString());
				request.addProperty("du", e6.getText().toString());
				request.addProperty("dob", e7.getText().toString());
				request.addProperty("g",gen);
				request.addProperty("ph", e10.getText().toString());
				//request.addProperty("ph",Integer.parseInt(e10.getText().toString()));
				request.addProperty("ad", e11.getText().toString());
				request.addProperty("lat", "NULL");
				request.addProperty("lat", "NULL");
				
				
				
				
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
					Toast.makeText(Page3.this, "Error :" + exception.toString(), 1).show();
					Toast.makeText(Page3.this, "Error :" + exception.getMessage(), 1).show();
				}

							
				
				 Intent i=new Intent();
				 i.setClass(Page3.this, Page1.class);
			        startActivity(i);
			}
		});
 }
}