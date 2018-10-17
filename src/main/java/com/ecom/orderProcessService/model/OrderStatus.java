package com.ecom.orderProcessService.model;

public enum OrderStatus {
	PROCESSED("PROCESSED"), DENIED("DENIED"), ORDERED("ORDERED");

	private final String status;

	private OrderStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return status;
	}

}
