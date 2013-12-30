package com.amsterdamAL.technotes;

import android.content.Context;
import android.widget.Toast;

public class Message {
	
	public static void message(Context context, String message)
	
	{
		Toast.makeText(context, message, Toast.LENGTH_LONG).show();	
		
	}
	
	
	public static void message(Context context, StringBuilder sb)
	
	{
		Toast.makeText(context, sb, Toast.LENGTH_LONG).show();	
		
	}
	
public static void message(Context context, int date)
	
	{
		Toast.makeText(context, date, Toast.LENGTH_LONG).show();	
		
	}

}
