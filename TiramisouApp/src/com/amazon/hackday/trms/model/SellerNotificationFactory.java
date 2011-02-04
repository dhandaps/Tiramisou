package com.amazon.hackday.trms.model;

import java.util.Random;

import lombok.SneakyThrows;
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
	private static final int MAX_PERIOD = 800;
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
	
	@SneakyThrows
	public SellerNotification createNotification(SellerNotificationType notificationType, Object context)
	{
		String title = null;
		int imageId = R.drawable.message;
		int notificationTag = 1;		
   		Intent intent = defaultIntent;

		switch(notificationType)
		{
			case AMAZON_COMMUNICATION:
				title = String.format("New message from Amazon: %s", context);
				notificationTag = 1;
			break;		
			case BLOCKED:
				title = String.format("You have been blocked from the marketplace for %s", context);
				notificationTag = 2;
			break;
			case BUY_BOX_LOST:
				title = String.format("You have lost the buy box for '%s'", context);
				notificationTag = 3;
			break;
			case BUY_BOX_WON:
				title = String.format("You have won the buy box for '%s'", context);
				notificationTag = 4;
			break;
			case BUYER_COMMUNICATION:
				title = String.format("New message from buyer %s", context);
				notificationTag = 5;
			break;
			case CXM_WARNING:
				title = String.format("Metrics warning: %s", context);
				notificationTag = 6;
			break;
			case DISBURSEMENT_RECEIVED:
				title = String.format("You have received a disbursement for %s", context);
				notificationTag = 7;
			break;
			case FEEDBACK_RECEIVED:
				title = String.format("You have received new feedback from %s", context);
				notificationTag = 8;
			break;
			case ITEM_SOLD:
				title = String.format("You have a new sale for '%s'", context);
				notificationTag = 9;
			break;
			case OUT_OF_STOCK:
				title = String.format("You are out of stock of '%s'", context);
				notificationTag = 10;
			break;
			default:
				throw new IllegalArgumentException("Unknown NotificationType");
		}
		
		Log.i(TAG, String.format("Creating Notification of type %s with context %s", notificationType, context));
	    Thread.sleep(100 + random.nextInt(MAX_PERIOD));
	    
		SellerNotification notification = new SellerNotification(++LAST_ID, imageId, notificationTag, title, intent);
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
		notification.setLatestEventInfo(context, title, title, pendingIntent);
		notificationManager.notify(sellerNotification.getNotificationTag(), notification);
	}
	
	/***
Context context = getApplicationContext();
CharSequence contentTitle = "My notification";
CharSequence contentText = "Hello World!";
Intent notificationIntent = new Intent(this, MyClass.class);
PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

Context context = getApplicationContext();
CharSequence contentTitle = "My notification";
CharSequence contentText = "Hello World!";
Intent notificationIntent = new Intent(this, MyClass.class);
PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
Pass the Notification to the NotificationManager:
private static final int HELLO_ID = 1;

mNotificationManager.notify(HELLO_ID, notification);
	 */
}