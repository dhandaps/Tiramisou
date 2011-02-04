package com.amazon.hackday.trms.eventHandlers;

import java.util.List;

import android.view.View;
import android.view.View.OnClickListener;

public class CompoundClickHandler implements OnClickListener {
	private List<OnClickListener> actions;
	public CompoundClickHandler(List<OnClickListener> actions)
	{
		this.actions = actions;
	}
	
	public void onClick(View v) {
		for(OnClickListener action : actions)
			action.onClick(v);		
	}
}
