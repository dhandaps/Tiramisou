package com.amazon.hackday.trms.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class NotificationClickHandler implements OnClickListener
{
	private final Context context;
	private Intent intent;
	public NotificationClickHandler(Context context, Intent intent) {
		this.context = context;
		this.intent = intent;
	}
	
	public void onClick(View v)	{
		if(intent != null) {
			this.context.startActivity(intent);
		}
	}		
}