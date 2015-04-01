/*package com.shravan.map;

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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
//
 * 
 * 
 * 
 
public class pg11copyuseafter extends Activity {
	 SoapObject result;
	 String nofrnd = "";
	 String s[]=new String[1000];
 	CheckBox c[]=new CheckBox[1000];
 	    /** Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg10);
        
        
       
        
        
               
        String url=IP.getIp();
        String Action="http://tempuri.org/addfriends";
        String nameSpace="http://tempuri.org/";
        String Method="addfriends";

         SoapObject req=new SoapObject(nameSpace, Method);
         req.addProperty("du",user.getUser());
         
         SoapSerializationEnvelope en=new SoapSerializationEnvelope(SoapEnvelope.VER11);

         en.dotNet=true;
         en.setOutputSoapObject(req);
         HttpTransportSE aht=new HttpTransportSE(url);
        
     	
       //  Toast.makeText(getApplicationContext(), "Try", 1).show();
         try
         {
        	 LinearLayout l=(LinearLayout) findViewById(R.id.lin);
                aht.call(Action, en);
            	 result = (SoapObject)en.getResponse();
            	
                for (int i=0;i<result.getPropertyCount();i++)
                {
                	s[i]=result.getProperty(i).toString();
                	c[i]=new CheckBox(this);
                	c[i].setText(s[i]);
         
                	l.addView(c[i]);
                }
          

//                Toast.makeText(getApplicationContext(), result.toString(),1).show();
       //  Toast.makeText(getApplicationContext(),result.getPropertyCount()+"",1).show();
          
        
        


         }
        catch(Exception e)
        {
           Toast.makeText(getApplicationContext(), e.getMessage().toString(), 0).show();
        }
        
         
         Button addf=(Button)findViewById(R.id.addf);
         addf.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				for(int i=0;i<result.getPropertyCount();i++)
				{
					if(c[i].isChecked())
					{
						nofrnd = nofrnd + s[i]+",";
					}
				}
				nofrnd=nofrnd.substring(0, nofrnd.length()-1);
				
		        
		        String url=IP.getIp();
		        String Action="http://tempuri.org/frnd";
		        String nameSpace="http://tempuri.org/";
		        String Method="frnd";

		         SoapObject req=new SoapObject(nameSpace, Method);
		         req.addProperty("str",user.getUser());
		         req.addProperty("fnd",nofrnd);
		         
		         SoapSerializationEnvelope en=new SoapSerializationEnvelope(SoapEnvelope.VER11);

		         en.dotNet=true;
		         en.setOutputSoapObject(req);
		         HttpTransportSE aht=new HttpTransportSE(url);
		        
		     	
		       //  Toast.makeText(getApplicationContext(), "Try", 1).show();
		         try
		         {
		        	  aht.call(Action, en);
		            SoapPrimitive result1 = (SoapPrimitive)en.getResponse();
		            Toast.makeText(getApplicationContext(),  result1.toString() , 0).show();

		         }
		        catch(Exception e)
		        {
		           Toast.makeText(getApplicationContext(), e.getMessage().toString(), 0).show();
		        }
				
				
			}
		});
        
        Button src=(Button)findViewById(R.id.src);
        src.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent x=new Intent();
				  EditText e1=(EditText)findViewById(R.id.src1);
				  x.setClass(pg11copyuseafter.this, search.class);
				x.putExtra("du", e1.getText().toString());
			//	Toast.makeText(getApplicationContext(), e1.getText().toString(), 1).show();
		        startActivity(x);
				
				
			}
		});
        
 }
}*/