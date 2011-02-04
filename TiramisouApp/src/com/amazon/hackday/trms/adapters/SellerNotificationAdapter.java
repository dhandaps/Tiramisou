package com.amazon.hackday.trms.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amazon.hackday.trms.R;
import com.amazon.hackday.trms.eventHandlers.DismissNotificationHandler;
import com.amazon.hackday.trms.eventHandlers.StartIntentClickHandler;
import com.amazon.hackday.trms.model.SellerNotification;

public class SellerNotificationAdapter extends ArrayAdapter<SellerNotification> {
	private final String TAG = "NotificationAdapter";
	
	public SellerNotificationAdapter(Context context, int textViewResourceId)
	{
		super(context, textViewResourceId);
		this.setNotifyOnChange(true);
	}
	
	public View getView(int index, View view, ViewGroup parent) {
		Log.i(TAG, "Getting view for item at index " + index);
		SellerNotification notification = getItem(index);
		
		if (view == null) {
			Log.i(TAG, "View is null");
            LayoutInflater inflator = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflator.inflate(R.layout.notification_view, null);
        }

		Log.i(TAG, "Notification is not null, packing control");
		TextView text = (TextView) view.findViewById(R.id.notificationText);
		TextView detail = (TextView) view.findViewById(R.id.notificationDetail);
		ImageView image = (ImageView) view.findViewById(R.id.notificationImage);
		ImageView checkedImage = (ImageView)view.findViewById(R.id.notificationDismissedImage);
		text.setText(notification.getTitle());
		detail.setText(notification.getDetail());		
		image.setImageResource(notification.getImageId());
		checkedImage.setOnClickListener(new DismissNotificationHandler(this, notification));
		view.setOnClickListener(new StartIntentClickHandler(getContext(), notification.getClickIntent()));
        return view;
	}
}
