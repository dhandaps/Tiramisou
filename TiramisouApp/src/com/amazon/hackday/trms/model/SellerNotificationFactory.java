package com.amazon.hackday.trms.model;

import com.amazon.hackday.trms.R;

import android.content.Intent;

public class SellerNotificationFactory 
{
	private static long LAST_ID = 0;
	
	public static SellerNotification createNotification(SellerNotificationType notificationType, Object context)
	{
		String title = null;
		Intent intent = null;
		int imageId = R.drawable.message;
		
		switch(notificationType)
		{
			case AMAZON_COMMUNICATION:
				title = String.format("New message from Amazon: %s", context);
			break;		
			case BLOCKED:
				title = String.format("You have been blocked from the marketplace for %s", context);
			break;
			case BUY_BOX_LOST:
				title = String.format("You have lost the buy box for '%s'", context);
			break;
			case BUY_BOX_WON:
				title = String.format("You have won the buy box for '%s'", context);
			break;
			case BUYER_COMMUNICATION:
				title = String.format("New message from buyer %s", context);
			break;
			case CXM_WARNING:
				title = String.format("Metrics warning: %s", context);
			break;
			case DISBURSEMENT_RECEIVED:
				title = String.format("You have received a disbursement for %s", context);
			break;
			case FEEDBACK_RECEIVED:
				title = String.format("You have received new feedback from %s", context);
			break;
			case ITEM_SOLD:
				title = String.format("You have a new sale for '%s'", context);
			break;
			case OUT_OF_STOCK:
				title = String.format("You are out of stock of '%s'", context);
			break;
			default:
				throw new IllegalArgumentException("Unknown NotificationType");
		}
		
		return new SellerNotification(++LAST_ID, imageId, title, intent);
	}
}