package com.amazon.hackday.trms.adapters;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.amazon.hackday.trms.model.SellerNotification;

public class NotificationListAdapter extends ArrayAdapter {
	@Getter @Setter private List<SellerNotification> notifications;
	
	public NotificationListAdapter(Context context, int textViewResourceId) {
		super(context, textViewResourceId);
	}
	
	public View getView(int index, View arg1, ViewGroup arg2) {
		return null;
	}
}
