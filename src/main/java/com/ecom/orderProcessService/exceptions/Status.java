package com.ecom.orderProcessService.exceptions;

public enum Status {
	PROCESSED("PROCESSED"), DENIED("DENIED"), ORDERED("ORDERED");

	private final String status;

	private Status(String status) {
		this.status = status;
	}

	public String getDescription() {
		return status;
	}

}
