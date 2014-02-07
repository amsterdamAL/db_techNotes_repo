package com.amsterdamAL.technotes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Search extends Activity {

	
	public static EditText searchByJobId, searchByAddress, searchByApt, 
				searchByTn, searchByCbr, searchByDate, searchByMonth, searchByYear;
	
	public static int point;
	
	public static long uidResult;
	
	public static SimpleCursorAdapter Sca;
	
	TechDatabaseAdapter techhelper;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_layout);
		
		techhelper = new TechDatabaseAdapter(this);
		
		searchByJobId = (EditText) findViewById(R.id.searchByJobId);
		searchByAddress = (EditText) findViewById(R.id.searchByAddress);
		searchByApt = (EditText) findViewById(R.id.searchByApt);
		searchByTn = (EditText) findViewById(R.id.searchByTn);
		searchByCbr = (EditText) findViewById(R.id.searchByCbr);
		searchByDate = (EditText) findViewById(R.id.searchByDate);
		searchByMonth = (EditText) findViewById(R.id.searchByMonth);
		searchByYear = (EditText) findViewById(R.id.searchByYear);
	}		
		
	
	// gets userinput and searches db with it
	public void searchAll(View view){
	
		//sets flag so Records goes to search result instead of last result
		Technotes.recordsOrResultsFlag = true;		
			
			//checks if jobId is empty, else do nothing xcept toast for more info below...
			if (searchByJobId.getText().toString() != null && !searchByJobId.getText().toString().isEmpty() ){
			
				//search db with user input
				long uid = techhelper.searchRecords();
				
					//if match is found, uid is record#
					if (uid>0){	
						
						uidResult = uid;
						Intent i = new Intent(this, Records.class);
						startActivity(i);
						finish();
						
					//if no match is found uid was less than 0
					}else{
						
						Toast.makeText(getApplicationContext(), "uid was 0 or less, aka nada found", Toast.LENGTH_SHORT).show();;
					}
			
			}else if (searchByMonth.getText().toString() != null && !searchByMonth.getText().toString().isEmpty() ) {
				
				
				Sca = techhelper.getAdapterBack();
				Intent i = new Intent(this, MultipleResults.class);
				startActivity(i);
				Toast.makeText(getApplicationContext(), "search.java >> multipleResults.java", Toast.LENGTH_SHORT).show();
				
			}else{
				Toast.makeText(getApplicationContext(), "fill out one of the boxes", Toast.LENGTH_SHORT).show();
			}
		
	
	}
	
	

		

		
		
		
		
		
		
		
	
}
