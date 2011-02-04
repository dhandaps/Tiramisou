package com.amazon.hackday.trms.model;

import android.content.Intent;

/**
 * A data-holder class for binding notifications with.
 */
public class SellerNotification {
	private long id;
	private String title;
	private int imageId;
	private int notificationTag;
	private Intent clickIntent;
	private boolean acknowledged;
	
	public SellerNotification(long id, int imageId, int notificationTag, String title, Intent clickIntent)
	{
		this.id = id;
		this.imageId = imageId;
		this.title = title;
		this.clickIntent = clickIntent;
	}

	public long getId() {
		return id;
	}

	public int getImageId() {
		return imageId;
	}

	public String getTitle() {
		return title;
	}

	public int getNotificationTag() {
		return notificationTag;
	}

	public Intent getClickIntent() {
		return clickIntent;
	}

	public void setAcknowledged(boolean acknowledged) {
		this.acknowledged = acknowledged;
	}

	public boolean isAcknowledged() {
		return acknowledged;
	}
}
