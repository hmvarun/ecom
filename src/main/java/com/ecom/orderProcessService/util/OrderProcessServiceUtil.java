package com.ecom.orderProcessService.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import com.ecom.orderProcessService.exceptions.ErrorCode;
import com.ecom.orderProcessService.exceptions.OrderProcessServiceException;
import com.ecom.orderProcessService.model.AccountInfo;
import com.ecom.orderProcessService.request.OrderRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OrderProcessServiceUtil {

	private Properties properties = null;
	private static OrderProcessServiceUtil orderProcessServiceUtil = null;

	public String readProperty(String key) throws OrderProcessServiceException {
		try {
			if (properties == null) {
				properties = new Properties();
				InputStream inputStream = this.getClass().getClassLoader()
						.getResourceAsStream("application.properties");
				properties.load(inputStream);
				inputStream.close();
			}
			return (String) properties.get(key);
		} catch (IOException e) {
			e.printStackTrace();
			throw new OrderProcessServiceException(ErrorCode.UNABLE_TO_START_SERVICE);
		}

	}

	public static <E> String responseString(E Object) throws OrderProcessServiceException {
		ObjectMapper mapper = new ObjectMapper();
		String writeValueAsString;
		try {
			writeValueAsString = mapper.writeValueAsString(Object);
		} catch (IOException e) {
			e.printStackTrace();
			throw new OrderProcessServiceException(ErrorCode.BUSINESS_VALIDATION_ERROR);
		}
		return writeValueAsString;
	}

	public static <T> Object extractJsonObject(String jsonInput, Class<T> classType)
			throws OrderProcessServiceException {
		ObjectMapper mapper = new ObjectMapper();
		T readValue = null;
		try {
			readValue = mapper.readValue(jsonInput, classType);
		} catch (Exception e) {
			throw new OrderProcessServiceException(ErrorCode.VALIDATION_ERROR);
		}
		return readValue;

	}

	public static OrderProcessServiceUtil getUtil() {
		if (orderProcessServiceUtil == null) {
			orderProcessServiceUtil = new OrderProcessServiceUtil();
			return orderProcessServiceUtil;
		}
		return orderProcessServiceUtil;
	}

	public static void main(String[] args) throws OrderProcessServiceException {
		OrderProcessServiceUtil util = getUtil();
		String readProperty = util.readProperty("checkAccountExists");
		System.out.println(readProperty);
	}

	public static boolean validateRequest(AccountInfo acc) throws OrderProcessServiceException {
		if (checkStringHasText(acc.getBilling_info()) && checkStringHasText(acc.getEmail())
				&& checkStringHasText(acc.getPassword()) && checkStringHasText(acc.getPhone())
				&& checkStringHasText(acc.getShipping_info())) {
			return true;
		}
		throw new OrderProcessServiceException(ErrorCode.VALIDATION_ERROR);

	}

	public static boolean validateOrderRequest(OrderRequest ordReq) throws OrderProcessServiceException {
		if (checkStringHasText(ordReq.getAccountId()) && checkStringHasText(ordReq.getShipping_info())
				&& (ordReq.getBookIds().size()) > 0 && (ordReq.getTotal_price() > 0)) {
			return true;
		}
		throw new OrderProcessServiceException(ErrorCode.VALIDATION_ERROR);

	}

	private static boolean checkStringHasText(String val) {
		if (val == null || val.isEmpty()) {
			return false;
		} else {
			return true;
		}

	}
}
