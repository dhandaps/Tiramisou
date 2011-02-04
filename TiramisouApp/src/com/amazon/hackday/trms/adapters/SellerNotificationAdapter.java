package com.amazon.hackday.trms.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amazon.hackday.trms.R;
import com.amazon.hackday.trms.model.SellerNotification;

public class SellerNotificationAdapter extends ArrayAdapter<SellerNotification> {
	private final List<SellerNotification> notifications;
	
	public SellerNotificationAdapter(Context context, int textViewResourceId, List<SellerNotification> notifications) {
		super(context, textViewResourceId);
		this.notifications = notifications;
	}
	
	public View getView(int index, View view, ViewGroup parent) {
		SellerNotification notification = notifications.get(index);
		
		if (view == null) {
            LayoutInflater inflator = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflator.inflate(R.layout.notification_view, null);
        }
		
        if (notification != null) {
                TextView text = (TextView) view.findViewById(R.id.notificationText);
                ImageView image = (ImageView) view.findViewById(R.id.notificationImage);
                
                text.setText(notification.getTitle());
                image.setImageResource(notification.getImageId());
        }
        
        return view;
	}
}
