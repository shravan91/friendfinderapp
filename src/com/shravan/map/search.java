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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class search extends Activity {
	// public CheckBox c1=new CheckBox(this);
//	 public String x1;
	// public String nofrnd;
 	    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        
       
     /* 
        Intent x=getIntent();
        Bundle b=x.getExtras();
        String du=b.getString("du");
        
               
        String url=IP.getIp();
        String Action="http://tempuri.org/search";
        String nameSpace="http://tempuri.org/";
        String Method="search";
      
         SoapObject req=new SoapObject(nameSpace, Method);
         req.addProperty("du",du);
         
         SoapSerializationEnvelope en=new SoapSerializationEnvelope(SoapEnvelope.VER11);

         en.dotNet=true;
         en.setOutputSoapObject(req);
         HttpTransportSE aht=new HttpTransportSE(url);
        
     	
       //  Toast.makeText(getApplicationContext(), "Try", 1).show();
         try
         {
        	 LinearLayout l=(LinearLayout) findViewById(R.id.lin);
                aht.call(Action, en);
            	 SoapPrimitive re = (SoapPrimitive)en.getResponse();
            	
            	
            	 
            	 	
                	x1=re.toString();
                	
                	c1.setText(x1);
         
                	l.addView(c1);
               		          

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
				
				
				
					if(c1.isChecked())
					{
						nofrnd = nofrnd + x1+",";
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
		});*/
        
       
        
 }
}