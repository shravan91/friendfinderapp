package com.shravan.map;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.ksoap2.serialization.*;
import org.w3c.dom.UserDataHandler;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class notification extends Activity {
	SoapObject result;
	 int i;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);
        
        String url1=IP.getIp();
		final String SOAP_ACTION =  "http://tempuri.org/clientSide";
		final String METHOD_NAME = "clientSide";
		final String NAMESPACE = "http://tempuri.org/"; 						
		//String url1="http://kpo.tmspl.com/map/";
					
		SoapObject request = new SoapObject(NAMESPACE,METHOD_NAME);
		request.addProperty("str", user.getUser());
		
							
		SoapSerializationEnvelope soapEnvelop = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		
		soapEnvelop.dotNet=true;
		soapEnvelop.setOutputSoapObject(request);

		HttpTransportSE aht = new HttpTransportSE(url1);
		try
		{
			LinearLayout lin=(LinearLayout) findViewById(R.id.lin);
			aht.call(SOAP_ACTION, soapEnvelop);
			result = (SoapObject)soapEnvelop.getResponse();
			String s[]=new String[result.getPropertyCount()/3];
		//	Toast.makeText(getApplicationContext(), result.getPropertyCount()+"",1).show();
			//Toast.makeText(getApplicationContext(), s.length+"",1).show();
			TextView t[]=new TextView[s.length];
			int f=0; 
			for( i=0;i<result.getPropertyCount();i++)
			{
				//Toast.makeText(getApplicationContext(),i+"",1).show();
				s[f]=result.getProperty(i).toString() +result.getProperty(i+1).toString()+result.getProperty(i+2).toString();
				t[f]=new TextView(this);
				t[f].setText(s[i].toString());
				t[f].setTextSize(20);
				t[f].setTextColor(Color.WHITE);
				lin.addView(t[f]);
				
				f=f+1;
				
				Button acc=new Button(this);
				acc.setClickable(true);
				acc.setText("Accept >>");
				final int z=i;
				acc.setOnClickListener(new View.OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						kaa(z,"a");
					}
				});
				lin.addView(acc);
				
				Button rej=new Button(this);
				rej.setText("Reject >>");
				rej.setClickable(true);
				rej.setOnClickListener(new View.OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						kaa(z,"r");
					}
				});
				lin.addView(rej);
				
				i=i+2;
							
						
			}
				
			
			
    }
		
		
	  
		catch (Exception exception) 
		{
		//	Toast.makeText(notification.this, "Error :" + exception.toString(), 1).show();
		
		}
		
		
		
        
    }
    public void kaa(int i11,String sx)
    {
    	 String url11=IP.getIp();
    	final String SOAP_ACTION1 =  "http://tempuri.org/clientSideDone";
		final String METHOD_NAME1 = "clientSideDone";
		final String NAMESPACE1 = "http://tempuri.org/"; 						
		//String url1="http://kpo.tmspl.com/map/";
					
		SoapObject request1 = new SoapObject(NAMESPACE1,METHOD_NAME1);
		request1.addProperty("str", result.getProperty(i11).toString());
		request1.addProperty("substr",user.getUser());
		request1.addProperty("st",sx);
		
							
		SoapSerializationEnvelope soapEnvelop1 = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		
		soapEnvelop1.dotNet=true;
		soapEnvelop1.setOutputSoapObject(request1);
	//	Toast.makeText(getApplicationContext(), "try", 1).show();
		HttpTransportSE aht1 = new HttpTransportSE(url11);
		try
		{
			SoapPrimitive result1;
			aht1.call(SOAP_ACTION1, soapEnvelop1);
			result1 = (SoapPrimitive)soapEnvelop1.getResponse();
			Toast.makeText(getApplicationContext(), result1.toString(), 1).show();
			
			Intent sa=new Intent();
			sa.setClass(notification.this, notification.class);
			startActivity(sa);
		}
		catch(Exception e)
		{
			Toast.makeText(notification.this, "Error :" + e.toString(), 1).show();
		}
		
    }
}