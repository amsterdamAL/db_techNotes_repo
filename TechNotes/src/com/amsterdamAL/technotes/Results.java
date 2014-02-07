package com.amsterdamAL.technotes;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Results extends Activity {

	public static TextView dateBox, addyView, orderView, nameView, cbrView, trblTnView,
			f1View, f2View, f3View, f4View, f2TermLeft, f2TermView, rtView,
			rtLeft, addyLeft, orderLeft, nameLeft, cbrLeft, trblTnLeft, memoView, theCount;
		
	
	TechDatabaseAdapter techhelper;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.records_layout);
		
		techhelper = new TechDatabaseAdapter(this);
		
		theCount = (TextView) findViewById(R.id.theCount);
		dateBox = (TextView) findViewById(R.id.dateBox);
		addyLeft = (TextView) findViewById(R.id.addyLeft);
		addyView = (TextView) findViewById(R.id.addyView);
		orderLeft = (TextView) findViewById(R.id.orderLeft);
		orderView = (TextView) findViewById(R.id.orderView);
		nameLeft = (TextView) findViewById(R.id.nameLeft);
		nameView = (TextView) findViewById(R.id.nameView);
		cbrLeft = (TextView) findViewById(R.id.cbrLeft);
		cbrView = (TextView) findViewById(R.id.cbrView);
		trblTnLeft = (TextView) findViewById(R.id.trblTnLeft);
		trblTnView = (TextView) findViewById(R.id.trblTnView);
		f1View = (TextView) findViewById(R.id.f1View);
		f2View = (TextView) findViewById(R.id.f2View);
		f3View = (TextView) findViewById(R.id.f3View);
		f4View = (TextView) findViewById(R.id.f4View);
		f2TermLeft = (TextView) findViewById(R.id.f2TermLeft);
		f2TermView = (TextView) findViewById(R.id.f2TermView);
		rtLeft = (TextView) findViewById(R.id.rtLeft);
		rtView = (TextView) findViewById(R.id.rtView);
		memoView = (TextView) findViewById(R.id.memoView);
		
		
		//gets all records, displays the last record
		//techhelper.getAllRecords();
		techhelper.searchRecords();
		
		
		
	}
	
		
		
	public void Back(View view) {
		techhelper.backRecords();
	}
	
	
	public void Forward(View view) {
		techhelper.forwardRecords();
	}

		
	public void DeleteRow(View view){
		
		techhelper.deleteRow();
		
	}
	

	public void EditAll(View view) {
			
			
			Intent i = new Intent(this, EditRecords.class);
			startActivity(i);
			finish();
		}
	
	
	public void MapIt(View view){
		
		Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW,
Uri.parse("http://maps.google.com/maps?q=" + addyView.getText().toString()));
		mapIntent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");		
		startActivity(mapIntent);
	}
	
	
	
	
	
}
