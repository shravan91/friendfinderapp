package com.shravan.map;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Page2 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg2);
 
        Button b3=(Button)findViewById(R.id.noti1);
        b3.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Intent i=new Intent();
				 i.setClass(Page2.this, noti1.class);//accepted or rejected
			        startActivity(i);
			}
		});
        
        
        
        
        
        Button sub11=(Button)findViewById(R.id.lof);
        sub11.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Intent i=new Intent();
				 i.setClass(Page2.this, Page11.class);//Displaying Friends
			        startActivity(i);
			}
		});
        
        Button sub111=(Button)findViewById(R.id.noti);
        sub111.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Intent i=new Intent();
				 i.setClass(Page2.this, notification.class);//See Friend Request
			        startActivity(i);
			}
		});
        
        Button sub2=(Button)findViewById(R.id.mapview);
        sub2.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Intent i=new Intent();
				 i.setClass(Page2.this, Page8.class);//Mapview
			        startActivity(i);
			}
		});
        Button sub3=(Button)findViewById(R.id.editbutton1);
        sub3.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent();
				i.setClass(Page2.this,page9.class);//Edit Profile
				startActivity(i);
			}
		});
        Button sub4=(Button)findViewById(R.id.addfri);
        sub4.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent();
				i.setClass(Page2.this,Page10.class);//addfriends
				startActivity(i);
			}
		});
        
        
        Button b2=(Button) findViewById(R.id.exitall);
        b2.setOnClickListener(new View.OnClickListener() {
            
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent ix=new Intent();
                ix.setClass(Page2.this,Page1.class);
                startActivity(ix);
                Intent intent=new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                System.exit(0);
                }
        });
 }
}