package com.amazon.hackday.trms.eventHandlers;

import android.view.View;
import android.view.View.OnClickListener;

import com.amazon.hackday.trms.adapters.SellerNotificationAdapter;
import com.amazon.hackday.trms.model.SellerNotification;

public class DismissNotificationHandler implements OnClickListener 
{
	private final SellerNotificationAdapter sellerNotificationAdapter;
	private final SellerNotification notification;
	public DismissNotificationHandler(SellerNotificationAdapter sellerNotificationAdapter, SellerNotification notification){
		this.sellerNotificationAdapter = sellerNotificationAdapter;
		this.notification = notification;
	}

	public void onClick(View v) {
		this.sellerNotificationAdapter.remove(notification);		
	}
}