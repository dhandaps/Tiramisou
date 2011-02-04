package com.amazon.hackday.trms.eventHandlers;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

public class DialogFinishClickHandler implements OnClickListener{
	private final Activity activity;
	
	public DialogFinishClickHandler(Activity activity) {
		this.activity = activity;
	}
	
	public void onClick(DialogInterface dialog, int which) {
		activity.finish();
	}
}
