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

public class noti1 extends Activity {
	SoapObject result;
	 int i;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noti1);
        
        String url1=IP.getIp();
		final String SOAP_ACTION =  "http://tempuri.org/noti1";
		final String METHOD_NAME = "noti1";
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
			String s[]=new String[result.getPropertyCount()];
		//	Toast.makeText(getApplicationContext(), result.getPropertyCount()+"",1).show();
			//Toast.makeText(getApplicationContext(), s.length+"",1).show();
			TextView t[]=new TextView[result.getPropertyCount()];
			for(int f=0;f<result.getPropertyCount();f++)
			{
				//Toast.makeText(getApplicationContext(),i+"",1).show();
				
				s[f]=result.getProperty(f).toString();
				t[f]=new TextView(this);
				t[f].setText(s[f].toString());
				t[f].setTextSize(20);
				t[f].setTextColor(Color.WHITE);
				lin.addView(t[f]);
				
				
				
				
							
						
			}
				
			
			
    }
		
		
	  
		catch (Exception exception) 
		{
		//	Toast.makeText(notification.this, "Error :" + exception.toString(), 1).show();
		
		}
		
		
		
        
    		
    }
}