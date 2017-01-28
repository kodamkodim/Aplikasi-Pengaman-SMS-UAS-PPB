package com.enkripsisms;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Sms extends Activity {
	Button tulispesan,bacasms,about;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    setContentView(R.layout.awal);
	    tulispesan=(Button)findViewById(R.id.TulisPesan);
	    bacasms=(Button)findViewById(R.id.bacasms);
	    about=(Button)findViewById(R.id.about);
	        
	    tulispesan.setOnClickListener(new Button.OnClickListener() {
	       	@Override
			public void onClick(View v) {
				tulispesan();
	       	}
	    });
	    
		bacasms.setOnClickListener(new Button.OnClickListener() {
	        @Override
			public void onClick(View v) {
				inbox();
	        }
	    });
        
		about.setOnClickListener(new Button.OnClickListener() {
	        @Override
			public void onClick(View v) {
	        	about();
	        }
	    });
	}
	
	public void tulispesan() {
		Intent i=new Intent(this,tulis_pesan.class);
		startActivity(i);
	}
	
	public void inbox() {
		Intent i=new Intent(this,Inbox.class);
		startActivity(i);
	}
	
	public void about() {
		Intent i=new Intent(this,About.class);
		startActivity(i);	
	}
}