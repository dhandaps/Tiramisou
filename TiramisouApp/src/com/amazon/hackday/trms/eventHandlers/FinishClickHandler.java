package com.amazon.hackday.trms.eventHandlers;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

public class FinishClickHandler implements OnClickListener {
	private final Activity activity;
	
	public FinishClickHandler(Activity activity) {
		this.activity = activity;
	}
	
	public void onClick(View v) {
		activity.finish();
	}
}
