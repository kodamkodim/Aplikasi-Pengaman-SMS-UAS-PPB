package com.enkripsisms;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Inbox extends ListActivity {
	public static final String nosms="no";
	public static final String isisms="isi";
	String sms2no[];
	String sms2isi[];
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
				
		Uri uriSMSURI = Uri.parse("content://sms/inbox");
		Cursor cur = getContentResolver().query(uriSMSURI, new String[] { "_id", "thread_id", "address", "person", "date", "body" }, null, null,null);
		String smsno = "";
	    String smsisi="";
		while (cur.moveToNext()) {
			
			smsno +=cur.getString(2)+"@";
			
			smsisi+=cur.getString(5)+"@";
		}
		sms2no=smsno.split("\\@");
	    sms2isi=smsisi.split("\\@");
	     
	     
	    String[] listsms=new String[sms2no.length];
	    for(int i=0;i<sms2no.length;i++){
	    	if(sms2isi[i].length()>=20){
	    		
	    	listsms[i]=sms2no[i]+"\n"+sms2isi[i].substring(0,20)+" ...";
	    }
	    	else if(sms2isi[i].length()<20 &&sms2isi.length>=0){
	    		
	    		listsms[i]=sms2no[i]+"\n"+sms2isi[i];
	    	}
	    }
	    	    

	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	    			android.R.layout.simple_list_item_1, listsms);
		setListAdapter(adapter);
	}
		@Override
		protected void onListItemClick(ListView l, View v, int position, long id) {
			Intent i=new Intent(this,baca_sms.class);
			
			i.putExtra(nosms, sms2no[position]);
			
			i.putExtra(isisms, sms2isi[position]);
			startActivity(i);
		}
}