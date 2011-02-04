package com.amazon.hackday.trms.model;

import java.util.Random;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

import com.amazon.hackday.trms.R;
import com.google.common.base.Preconditions;

public class SellerNotificationFactory 
{
	private static final String TAG = "SellerNotificationFactory";
	private static final int MAX_PERIOD = 10000;
	private static final int MIN_PERIOD = 2000;
	private static final Random random = new Random();	
	private static long LAST_ID = 0;
	
	private final NotificationManager notificationManager;
	private final Context context;
	private final Intent defaultIntent;
	
	public SellerNotificationFactory(NotificationManager notificationManager, Context context, Intent defaultIntent){
		this.defaultIntent = defaultIntent;
		this.notificationManager = Preconditions.checkNotNull(notificationManager);
		this.context = Preconditions.checkNotNull(context);
	}
	
	public SellerNotification createNotification(SellerNotificationType notificationType, String context)
	{
		String title = null;
		String detail = null;
		int imageId = R.drawable.message;
		int notificationTag = 1;		
   		Intent intent = defaultIntent;

		switch(notificationType)
		{
			case AMAZON_COMMUNICATION:
				title = "New Message from Amazon";
				detail = context;
				notificationTag = 1;
			break;		
			case BLOCKED:
				title = "You Have Been Blocked";
				detail = String.format("You have been blocked from the marketplace for %s", context);
				notificationTag = 2;
			break;
			case BUY_BOX_LOST:
				title = "Buy Box Lost";
				detail = String.format("Lost the buy box for '%s'", context);
				notificationTag = 3;
			break;
			case BUY_BOX_WON:
				title = "Buy Box Won!";
				detail = String.format("You have won the buy box for '%s'", context);
				notificationTag = 4;
			break;
			case BUYER_COMMUNICATION:
				title = "New Message from Customer";
				detail = String.format("New message from buyer %s", context);
				notificationTag = 5;
			break;
			case CXM_WARNING:
				title = "Metrics Warning"; 
				detail = String.format("Metrics warning: %s", context);
				notificationTag = 6;
			break;
			case DISBURSEMENT_RECEIVED:
				title = "Cash Moneys Received";
				detail = String.format("You have received a disbursement for %s", context);
				notificationTag = 7;
			break;
			case FEEDBACK_RECEIVED:
				title = "Feedback Received";
				detail = String.format("New feedback from %s", context);
				notificationTag = 8;
			break;
			case ITEM_SOLD:
				title = String.format("You have a new sale for '%s'", context);
				notificationTag = 9;
			break;
			case OUT_OF_STOCK:
				title = "Item out of Stock";
				detail = String.format("You are out of stock of '%s'", context);
				notificationTag = 10;
			break;
			default:
				throw new IllegalArgumentException("Unknown NotificationType");
		}
		
		Log.i(TAG, String.format("Creating Notification of type %s with context %s", notificationType, context));
		try{
			Thread.sleep(MIN_PERIOD + random.nextInt(MAX_PERIOD - MIN_PERIOD));
		}
		catch(InterruptedException ex){
			throw new RuntimeException(ex);
		}
	    
		SellerNotification notification = new SellerNotification(++LAST_ID, imageId, notificationTag, title, detail, intent);
		systemNotify(notification);
		return notification;
	}
	
	private void systemNotify(SellerNotification sellerNotification)
	{
		int icon = R.drawable.message;
		CharSequence text = sellerNotification.getTitle();
		long when = System.currentTimeMillis();
		Notification notification = new Notification(icon, text, when);

		Intent intent = sellerNotification.getClickIntent();
		PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

		CharSequence title = sellerNotification.getTitle();
		CharSequence detail = sellerNotification.getDetail();
		notification.setLatestEventInfo(context, title, detail, pendingIntent);
		notificationManager.notify(sellerNotification.getTitle(), sellerNotification.getNotificationId(), notification);
	}
}