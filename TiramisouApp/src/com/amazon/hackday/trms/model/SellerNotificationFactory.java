package com.amazon.hackday.trms.model;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.amazon.hackday.trms.CreateListingActivity;
import com.amazon.hackday.trms.R;
import com.amazon.hackday.trms.ShipConfirmActivity;
import com.amazon.hackday.trms.intents.EmailIntent;
import com.google.common.base.Preconditions;

public class SellerNotificationFactory 
{
	private static long LAST_ID = 0;
	
	private final NotificationManager notificationManager;
	private final Context context;
	
	public SellerNotificationFactory(NotificationManager notificationManager, Context context) {
		this.notificationManager = Preconditions.checkNotNull(notificationManager, "Notification Manager must not be null");
		this.context = Preconditions.checkNotNull(context, "Context must not be null");
	}
	
	public SellerNotification createNotification(SellerNotificationType notificationType, String args)
	{
		String title = null;
		String detail = null;
		int imageId = R.drawable.message;
		int notificationTag = 1;		
   		Intent intent = null;

		switch(notificationType)
		{
			case AMAZON_COMMUNICATION:
				title = "New Message from Amazon";
				detail = args;
				intent = EmailIntent.create("jeff@amazon.com", "Why Hello!", "AMZN Hack Day Test");
				notificationTag = 1;
			break;		
			case BLOCKED:
				title = "You Have Been Blocked";
				detail = String.format("You have been blocked from the marketplace for %s", args);
				intent = EmailIntent.create("jeff@amazon.com", "WTF U SUX!", "AMZN Hack Day Test");
				imageId = R.drawable.thumbsdown;
				notificationTag = 2;
			break;
			case BUY_BOX_LOST:
				title = "Buy Box Lost";
				detail = String.format("Lost the buy box for '%s'", args);
				intent = EmailIntent.create("jeff@amazon.com", "WTF GIMME!", "AMZN Hack Day Test");
				imageId = R.drawable.thumbsdown;
				notificationTag = 3;
			break;
			case BUY_BOX_WON:
				title = "Buy Box Won!";
				detail = String.format("You won the buy box for '%s'", args);
				intent = EmailIntent.create("jeff@amazon.com", "Why Thank You!", "AMZN Hack Day Test");
				imageId = R.drawable.thumbsup;
				notificationTag = 4;
			break;
			case BUYER_COMMUNICATION:
				title = "New Message from Customer";
				detail = String.format("New message from %s", args);
				intent = EmailIntent.create("dudeguy_threepwood@gmail.com", "Holla!", "AMZN Hack Day Test");
				notificationTag = 5;
			break;
			case CXM_WARNING:
				title = "Metrics Warning"; 
				detail = String.format("Metrics warning: %s", args);
				intent = EmailIntent.create("jeff@amazon.com", "OMGWTFBBQ...SRSLY!", "AMZN Hack Day Test");
				imageId = R.drawable.thumbsdown;
				notificationTag = 6;
			break;
			case DISBURSEMENT_RECEIVED:
				title = "Cash Moneys Received";
				detail = String.format("You have received a disbursement for %s", args);
				intent = EmailIntent.create("jeff@amazon.com", "w00t!", "AMZN Hack Day Test");
				imageId = R.drawable.thumbsup;
				notificationTag = 7;
			break;
			case FEEDBACK_RECEIVED:
				title = "Feedback Received";
				detail = String.format("New feedback from %s", args);
				intent = EmailIntent.create("dudeguy_threepwood@amazon.com", "[w00t|WTF]+", "AMZN Hack Day Test");
				notificationTag = 8;
			break;
			case ITEM_SOLD:
				title = "Item Sold";
				detail = String.format("You sold '%s'", args);
				imageId = R.drawable.thumbsup;
				intent = new Intent(context, ShipConfirmActivity.class);
				notificationTag = 9;
			break;
			case OUT_OF_STOCK:
				title = "Item out of Stock";
				detail = String.format("You are out of stock of '%s'", args);
				imageId = R.drawable.thumbsdown;
				intent = new Intent(context, CreateListingActivity.class);
				notificationTag = 10;
			break;
			default:
				throw new IllegalArgumentException("Unknown NotificationType");
		}

		SellerNotification notification = new SellerNotification(++LAST_ID, imageId, notificationTag, title, detail, intent);
		systemNotify(notification);
		return notification;
	}
	
	private void systemNotify(SellerNotification sellerNotification)
	{
		CharSequence text = sellerNotification.getTitle();
		long when = System.currentTimeMillis();
		Notification notification = new Notification(sellerNotification.getImageId(), text, when);

		Intent intent = sellerNotification.getClickIntent();
		PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

		CharSequence title = sellerNotification.getTitle();
		CharSequence detail = sellerNotification.getDetail();
		notification.setLatestEventInfo(context, title, detail, pendingIntent);
		notificationManager.notify(sellerNotification.getTitle(), sellerNotification.getNotificationId(), notification);
	}
}