package com.enkripsisms;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class baca_sms extends Activity {
	private EditText kunci,pesan,hasil2,noPengirim;
	private Button dekripsi;
	private byte[] dekrip,bpesan;
	private String Skunci,Spesan,hasildekrip;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.baca_sms);
	    
	    Bundle extras=getIntent().getExtras();
	    String no=extras.getString(Inbox.nosms);
	    String isi=extras.getString(Inbox.isisms);
	    
	    kunci=(EditText) findViewById(R.id.kunci2);
	    pesan=(EditText) findViewById(R.id.pesan2);
	    hasil2=(EditText) findViewById(R.id.hasil2);
	    noPengirim=(EditText)findViewById(R.id.noPengirim);
	    dekripsi=(Button)findViewById(R.id.dekrip);
	    pesan.setFocusable(false);
	    hasil2.setFocusable(false);
	    
	    noPengirim.setText(no);
	    pesan.setText(isi);
	    
	    dekripsi.setOnClickListener(new Button.OnClickListener() {
	    	@Override
	    	public void onClick(View v) {
	    		dekrip();
	    	}
	    });
	}
	
	private void dekrip() {
		try{
		
		RC6 rc6=new RC6();
		Skunci=kunci.getText().toString();
		Spesan=pesan.getText().toString();
		
		   	if(Skunci.length()>0) {
	    		
		   		bpesan=hex2Byte(Spesan);
		   		
	    		dekrip=rc6.decrypt(bpesan, Skunci.getBytes());
	    		
	    		hasildekrip=new String(dekrip);
	    		
	    		hasil2.setText(hasildekrip);
	        }
	        else {
	        	Toast.makeText(getBaseContext(),"kunci tidak boleh kosong", Toast.LENGTH_SHORT).show();
	        }
		}  	
		   	catch(Exception e){
		   		Toast.makeText(getBaseContext(), "Bukan SMS Terenkripsi",Toast.LENGTH_LONG).show();
		   	}
	}
	
	
    private byte[] hex2Byte(String str) {
       byte[] bytes = new byte[str.length() / 2];
       for (int i = 0; i < bytes.length; i++)
       {
          bytes[i] = (byte) Integer
                .parseInt(str.substring(2 * i, 2 * i + 2), 16);
       }
       return bytes;
    }
}
