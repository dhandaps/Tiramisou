package com.amazon.hackday.trms.model;

import lombok.Data;

/**
 * A data-holder class for binding notifications with
 */
@Data public class SellerNotification {
	private long id;
	private boolean acknowledged;
	private String title;
	private int imageId;
}
