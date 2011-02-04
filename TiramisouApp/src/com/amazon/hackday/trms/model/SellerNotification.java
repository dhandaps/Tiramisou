package com.amazon.hackday.trms.model;

import android.content.Intent;

/**
 * A data-holder class for binding notifications with.
 */
public class SellerNotification {
	private long id;
	private String title;
	private String detail;
	private int imageId;
	private int notificationId;
	private Intent clickIntent;
	private boolean acknowledged;
	
	public SellerNotification(long id, int imageId, int notificationId, String title, String detail, Intent clickIntent)
	{
		this.id = id;
		this.imageId = imageId;
		this.title = title;
		this.detail = detail;
		this.clickIntent = clickIntent;
	}

	public long getId() {
		return id;
	}

	public int getImageId() {
		return imageId;
	}

	public String  getDetail() {
		return detail;
	}
	
	public String getTitle() {
		return title;
	}

	public int getNotificationId() {
		return notificationId;
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
