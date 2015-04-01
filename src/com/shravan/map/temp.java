package com.shravan.map;



import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class temp extends Activity {
	SoapObject result;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp);
        String url1=IP.getIp();
		final String SOAP_ACTION =  "http://tempuri.org/updatelatlon";
		final String METHOD_NAME = "updatelatlon";
		final String NAMESPACE = "http://tempuri.org/"; 						
		//String url1="http://kpo.tmspl.com/map/";
					
		SoapObject request = new SoapObject(NAMESPACE,METHOD_NAME);
		request.addProperty("du", user.getUser());
		
							
		SoapSerializationEnvelope soapEnvelop = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		
		soapEnvelop.dotNet=true;
		soapEnvelop.setOutputSoapObject(request);

		HttpTransportSE aht = new HttpTransportSE(url1);
		try
		{
			LinearLayout lin=(LinearLayout) findViewById(R.id.lin1);
			aht.call(SOAP_ACTION, soapEnvelop);
			result = (SoapObject)soapEnvelop.getResponse();
			//Toast.makeText(getApplicationContext(), result.toString(), 1).show();
			String s[]=new String[result.getPropertyCount()];
			//Toast.makeText(getApplicationContext(),s.length+"", 1).show();
			for(int i=0;i<s.length;i++)
			{
				s[i]=result.getProperty(i).toString();
				TextView t=new TextView(this);
				t.setText(s[i].toString());
				t.setTextSize(20);
				t.setClickable(true);
				t.setOnClickListener(new View.OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i=new Intent();
						i.setClass(temp.this,Page8.class);
						startActivity(i);
					}
				});
				t.setTextColor(Color.WHITE);
				lin.addView(t);
				TextView t1=new TextView(this);
				t1.setText("");
				t1.setTextSize(20);
				t1.setTextColor(Color.WHITE);
				lin.addView(t1);
			}
			
			
    }
		
	  
		catch (Exception exception) 
		{
			Toast.makeText(temp.this, "Error :" + exception.toString(), 1).show();
		
		}
		
		
		
		
        
 }
}