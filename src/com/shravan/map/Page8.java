package com.shravan.map;



import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import com.google.android.maps.Overlay;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.google.android.maps.MapActivity;

import android.widget.Toast;

import com.google.android.maps.MapView;
import com.google.android.maps.MapController;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.OverlayItem;
//import com.shravan.maps.HelloItemizedOverlay;
//import com.google.android.maps.Overlay;
//import com.shravan.map.GPSLocatorActivity.GPSLocationListener;
//import com.shravan.mapr.GPSLocatorActivity.MapOverlay;
import com.shravan.map.R;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.Geocoder;
import android.location.Address;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;


public class Page8 extends MapActivity {
	SoapObject result;
	private MapView mapView;
	private MapController mapController;
	private LocationManager locationManager;
	private LocationListener locationListener;
	HelloItemizedOverlay itemizedoverlay;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg8);
        
        
        Button b2=(Button) findViewById(R.id.exit12);
        b2.setOnClickListener(new View.OnClickListener() {
            
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent ix=new Intent();
                ix.setClass(Page8.this,Page1.class);
                startActivity(ix);
                Intent intent=new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                System.exit(0);
                }
        });
        
        Button showdirection=(Button)findViewById(R.id.buttondire1);
        showdirection.setOnClickListener(new View.OnClickListener() {
        	 
        	 public void onClick(final View view) {
        	       final Intent intent = new Intent(Intent.ACTION_VIEW,
        	       /** Using the web based turn by turn directions url. */
        	       Uri.parse(
        	                "http://maps.google.com/maps?" +
        	              //  "saddr=43.0034446,-87.9678884" +
        	                "&daddr=22.380,72.330"));
        	       startActivity(intent);
        	 }
        	});
        
        mapView = (MapView) findViewById(R.id.mapView);
        
        
        
  	 //Overlay Item
        
  	  // enable Street view by default
  	  //mapView.setStreetView(true);
  	  
  	  // enable to show Satellite view
  	  //mapView.setSatellite(true);
  	  
  	  // enable to show Traffic on map
  	  // mapView.setTraffic(true);
  	  
  	  mapView.setBuiltInZoomControls(true);
  	  
  	  locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);  
  	//locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
  	  locationListener = new GPSLocationListener();
  	  
  	  locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60000, 2, locationListener);
  	  mapController = mapView.getController();
  	  mapController.setZoom(8); 
  	}

  	private class GPSLocationListener implements LocationListener 
  	{
  	  public void onLocationChanged(Location location) {
  	    if (location != null) {
  	      GeoPoint point = new GeoPoint(
  	          (int) (location.getLatitude() * 1E6), 
  	          (int) (location.getLongitude() * 1E6));
  	      
  	      
  	    //  Toast.makeText(getBaseContext(),"Latitude: " + location.getLatitude() + " Longitude: " + location.getLongitude(),shravan.LENGTH_LONG).show();
  	      
  	      
  	      
  	      
  	    String url1=IP.getIp();
		final String SOAP_ACTION =  "http://tempuri.org/LatLon";
		final String METHOD_NAME = "LatLon";
		final String NAMESPACE = "http://tempuri.org/"; 						
		//String url1="http://kpo.tmspl.com/map/";
					
		SoapObject request = new SoapObject(NAMESPACE,METHOD_NAME);
		request.addProperty("du",user.getUser() );
		request.addProperty("lat",location.getLatitude() +"");
		//request.addProperty("lat",location.getLatitude() * 1E6+"");
		request.addProperty("lon", location.getLongitude() +"");
		//request.addProperty("lon", location.getLongitude() * 1E6+"");
							
		SoapSerializationEnvelope soapEnvelop = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		
		soapEnvelop.dotNet=true;
		soapEnvelop.setOutputSoapObject(request);

		HttpTransportSE aht = new HttpTransportSE(url1);
		try
		{
			aht.call(SOAP_ACTION, soapEnvelop);
			
		}
		catch (Exception exception) 
		{
			Toast.makeText(Page8.this, "Error :" + exception.toString(), 1).show();
			
		}
  	      
  	    String address = ConvertPointToLocation(point);
  	    //  Toast.makeText(getBaseContext(), address, Toast.LENGTH_LONG).show();
  	      mapController.animateTo(point);
  	      mapController.setZoom(6);
  	   // add marker
  	      MapOverlay mapOverlay = new MapOverlay();
  	      mapOverlay.setPointToDraw(point);
  	      List<Overlay> listOfOverlays = mapView.getOverlays();
  	      listOfOverlays.clear();
  	      listOfOverlays.add(mapOverlay);
  	    // String address1 = ConvertPointToLocation(point);
  	   //   Toast.makeText(getBaseContext(), address1, Toast.LENGTH_SHORT).show();
  	      
  	      
  	      
  	    //OTHER PEOPLE
  	      
  	      Drawable drawable = Page8.this.getResources().getDrawable(R.drawable.bluedot);
          itemizedoverlay = new HelloItemizedOverlay(drawable, Page8.this);
          new HelloItemizedOverlay(drawable, Page8.this);
          
           String url11=IP.getIp();
  		final String SOAP_ACTION1 =  "http://tempuri.org/updatelatlon";
  		final String METHOD_NAME1 = "updatelatlon";
  		final String NAMESPACE1 = "http://tempuri.org/"; 						
  		//String url1="http://kpo.tmspl.com/map/";
  					
  		SoapObject request1 = new SoapObject(NAMESPACE1,METHOD_NAME1);
  		request1.addProperty("du", user.getUser());
  		
  							
  		SoapSerializationEnvelope soapEnvelop1 = new SoapSerializationEnvelope(SoapEnvelope.VER11);
  		
  		soapEnvelop1.dotNet=true;
  		soapEnvelop1.setOutputSoapObject(request1);

  		HttpTransportSE aht1 = new HttpTransportSE(url11);
  		try
  		{
  			
  			LinearLayout lin=(LinearLayout) findViewById(R.id.lin1);
  			aht1.call(SOAP_ACTION1, soapEnvelop1);
  			result = (SoapObject)soapEnvelop1.getResponse();
  			//Toast.makeText(getApplicationContext(), result.toString(), 1).show();
  			String s[]=new String[result.getPropertyCount()];
  			
  		//	Toast.makeText(getApplicationContext(),s.length+"", 1).show();
  			for (int i=0;i<s.length;i++)
  			{
  				s[i]=result.getProperty(i).toString();
  			}
  			int i=0;
  			while(i<s.length)
  			{
  			//	Toast.makeText(getApplicationContext(),s[i+1]+"", 1).show();
  				
  				// Integer IX=Integer.getInteger(s[i+1]);
  				Double IX=Double.parseDouble(s[i+1]);
  				//Toast.makeText(getApplicationContext(),IX+"", 1).show();
  				//Toast.makeText(getApplicationContext(),s[i+2]+"", 1).show();
  				//Integer IX1=Integer.getInteger(s[i+2]);
  				Double IX1=Double.parseDouble(s[i+2]);
  				//Toast.makeText(getApplicationContext(),IX1+"", 1).show();
  		      //   GeoPoint point3 = new GeoPoint(IX1,IX1);
  				GeoPoint point3 = new GeoPoint((int) (IX * 1E6),  (int) (IX1 * 1E6));
  		  //     Toast.makeText(getApplicationContext(),s[i]+"", 1).show();
  		 //  Toast.makeText(getApplicationContext(),IX+"", 1).show();
  		  //  Toast.makeText(getApplicationContext(),IX1+"", 1).show();
  		  //  Toast.makeText(getApplicationContext(), point3+"", 5).show();
  				//String address2 = ConvertPointToLocation(point3);
  				String address4 = ConvertPointToLocation1(point3);
  				Toast.makeText(getApplicationContext(), address4, 5);
  		         OverlayItem overlayitem3 = new OverlayItem(point3, s[i],address4.toString() ); 
  		         itemizedoverlay.addOverlay(overlayitem3);
  	        
  				i=i+3;
  			}
  			
  			
      }
  		
  	  
  		catch (Exception exception) 
  		{
  			Toast.makeText(Page8.this, "Error :" + exception.toString(), 1).show();
  		
  		}
  		  
          listOfOverlays.add(itemizedoverlay);
  	       mapView.invalidate();
  	    }
  	
  }

  	public void onProviderDisabled(String arg0) {
  		// TODO Auto-generated method stub
  		
  	}

  	public void onProviderEnabled(String arg0) {
  		// TODO Auto-generated method stub
  		
  	}

  	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
  		// TODO Auto-generated method stub
  		
  	}
  	    }

  	  public String ConvertPointToLocation(GeoPoint point) {   
  		    String address = "";
  		    Geocoder geoCoder = new Geocoder(
  		        getBaseContext(), Locale.getDefault());
  		    try {
  		      List<Address> addresses = geoCoder.getFromLocation(
  		        point.getLatitudeE6()  / 1E6, 
  		        point.getLongitudeE6() / 1E6, 1);
  		 
  		      if (addresses.size() > 0) {
  		        for (int index = 0; 
  			index < addresses.get(0).getMaxAddressLineIndex(); index++)
  		          address += addresses.get(0).getAddressLine(index) + " ";
  		      }
  		    }
  		    catch (IOException e) {        
  		      e.printStackTrace();
  		    }   
  		    
  		    return address;
  		  } 
  	  
  	 public String ConvertPointToLocation1(GeoPoint point3) {   
		    String address4 = "";
		    Geocoder geoCoder = new Geocoder(
		        getBaseContext(), Locale.getDefault());
		    try {
		      List<Address> addresses = geoCoder.getFromLocation(
		        point3.getLatitudeE6()  / 1E6, 
		        point3.getLongitudeE6() / 1E6, 1);
		 
		      if (addresses.size() > 0) {
		        for (int index = 0; 
			index < addresses.get(0).getMaxAddressLineIndex(); index++)
		          address4 += addresses.get(0).getAddressLine(index) + " ";
		      }
		    }
		    catch (IOException e) {        
		      e.printStackTrace();
		    }   
		    
		    return address4;
		  } 
  	 public void onProviderDisabled(String arg0) {
  	// TODO Auto-generated method stub
  	
  }

  public void onProviderEnabled(String provider) {
  	// TODO Auto-generated method stub
  	
  }

  public void onStatusChanged(String provider, int status, Bundle extras) {
  	// TODO Auto-generated method stub
  	
  }

  	@Override
  	protected boolean isRouteDisplayed() {
  		// TODO Auto-generated method stub
  		return false;
  	}
  	
  	class MapOverlay extends Overlay
  	{
  	  private GeoPoint pointToDraw;

  	  public void setPointToDraw(GeoPoint point) {
  	    pointToDraw = point;
  	    
  	  }

  	  public GeoPoint getPointToDraw() {
  	    return pointToDraw;
  	  }
  	  
  	  @Override
  	  public boolean draw(Canvas canvas, MapView mapView, boolean shadow, long when) {
  	    super.draw(canvas, mapView, shadow);           

  	    // convert point to pixels
  	    Point screenPts = new Point();
  	    mapView.getProjection().toPixels(pointToDraw, screenPts);

  	    // add marker
  	    Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.greendot);
  	    canvas.drawBitmap(bmp, screenPts.x, screenPts.y - 24, null);    
  	    return true;
  	  }
  	}
  }


