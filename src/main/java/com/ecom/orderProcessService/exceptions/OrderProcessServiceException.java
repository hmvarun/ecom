package com.ecom.orderProcessService.exceptions;

public class OrderProcessServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ErrorCode code;

	public OrderProcessServiceException() {
		super();
	}

	public OrderProcessServiceException(ErrorCode code) {
		// TODO Auto-generated constructor stub
		this.code = code;
	}

	public ErrorCode getErrorCode() {
		return this.code;
	}

}
