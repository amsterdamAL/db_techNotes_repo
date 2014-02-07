package com.amsterdamAL.technotes;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;


public class MultipleResults extends Activity {

	//TechDatabaseAdapter techHelper;
	ListView l;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.multiple_results_layout);
		
		Toast.makeText(getApplicationContext(), TechDatabaseAdapter.test, Toast.LENGTH_SHORT).show();
		
		l = (ListView) findViewById(R.id.listView1);
		l.setAdapter(Search.Sca);
	}
	
}
