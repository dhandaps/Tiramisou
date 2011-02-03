package com.amazon.hackday.trms.model;

import lombok.Data;

/**
 * A data-holder class for binding notifications with
 */
@Data public class Notification {
	public long id;
	public boolean acknowledged;
	public String title;
	public String detail;
	int imageId;
}
