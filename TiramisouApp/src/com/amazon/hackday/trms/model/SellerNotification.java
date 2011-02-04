package com.amazon.hackday.trms.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import android.content.Intent;

/**
 * A data-holder class for binding notifications with.
 */
@ToString(of={"id", "title"})
public class SellerNotification {
	@Getter private long id;
	@Getter private String title;
	@Getter private int imageId;
	@Getter private Intent clickIntent;
	@Setter @Getter private boolean acknowledged;
	
	public SellerNotification(long id, int imageId, String title, Intent clickIntent)
	{
		this.id = id;
		this.imageId = imageId;
		this.title = title;
		this.clickIntent = clickIntent;
	}
}
