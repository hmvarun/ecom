package com.ecom.orderProcessService.util;

public class OrderProcessServiceConstant {

	public static String CHECK_EMAIL_EXISTS_QUERY = "checkEmailExists";
	public static String CHECK_ACCOUNT_EXISTS_QUERY = "checkAccountExists";
	public static String EMAIL = "email";
	public static String PASSWORD = "password";
	public static String INTERNAL_ERROR = "{\"message\": \"Some error occured during the transaction please try later\"}";
	public static String BAD_REQUEST = "{\"ErrorMessage\":\"Bad Request\"}";
	public static String USER_EXISTS = "user_exists";
	public static String USER_NOT_FOUND = "user_not_found";
	public static String ORDER_AUTHORIZED_RESPONSE = "order_authorized";
	public static String ORDER_DENIED= "{\"message\": \"ORDER DENIED\"}";

}
