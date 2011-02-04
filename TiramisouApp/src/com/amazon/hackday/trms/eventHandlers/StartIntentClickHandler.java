package com.amazon.hackday.trms.eventHandlers;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class StartIntentClickHandler implements OnClickListener
{
	private final Context context;
	private Intent intent;
	public StartIntentClickHandler(Context context, Intent intent) {
		this.context = context;
		this.intent = intent;
	}
	
	public void onClick(View v)	{
		if(intent != null) {
			this.context.startActivity(intent);
		}
	}		
}