package com.ecom.orderProcessService.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.ecom.orderProcessService.dao.DaoInterface;
import com.ecom.orderProcessService.daoImpl.DaoImpl;
import com.ecom.orderProcessService.exceptions.ErrorCode;
import com.ecom.orderProcessService.exceptions.OrderProcessServiceException;
import com.ecom.orderProcessService.model.AccountInfo;
import com.ecom.orderProcessService.model.Book;
import com.ecom.orderProcessService.model.OrderStatus;
import com.ecom.orderProcessService.model.POItem;
import com.ecom.orderProcessService.model.PurchaseOrder;
import com.ecom.orderProcessService.request.OrderRequest;
import com.ecom.orderProcessService.request.UserInfo;
import com.ecom.orderProcessService.util.OrderProcessServiceConstant;
import com.ecom.orderProcessService.util.OrderProcessServiceUtil;

public class OrderProcessService {
	private DaoInterface dao;

	public OrderProcessService() {
		this.dao = new DaoImpl();
	}

	public boolean isNewAccount(AccountInfo accountInfo) throws OrderProcessServiceException {
		dao.openCurrentSessionwithTransaction();
		Map<String, String> paramValue = new HashMap<String, String>();
		paramValue.put(OrderProcessServiceConstant.EMAIL, accountInfo.getEmail());
		List<AccountInfo> findAll = dao.findAllWithCondition(
				OrderProcessServiceUtil.getUtil().readProperty(OrderProcessServiceConstant.CHECK_EMAIL_EXISTS_QUERY), paramValue);
		if (findAll.size() > 0) {
			return false;
		}
		accountInfo.setAccountId(UUID.randomUUID().toString());
		dao.persist(accountInfo);
		dao.closeCurrentSessionwithTransaction();
		return true;
	}

	public boolean checkIfAccountExists(UserInfo userInfo) throws OrderProcessServiceException {
		dao.openCurrentSession();
		Map<String, String> paramValue = new HashMap<String, String>();
		paramValue.put(OrderProcessServiceConstant.EMAIL, userInfo.getUsername());
		paramValue.put(OrderProcessServiceConstant.PASSWORD, userInfo.getPassword());
		List<AccountInfo> findAll = dao.findAllWithCondition(
				OrderProcessServiceUtil.getUtil().readProperty(OrderProcessServiceConstant.CHECK_ACCOUNT_EXISTS_QUERY), paramValue);
		if (findAll.size() > 0) {
			return true;
		}
		dao.closeCurrentSession();
		return false;
	}

	public void authorizeOrder(OrderRequest orderRequest) throws OrderProcessServiceException {
		PurchaseOrder purchase = new PurchaseOrder();

		AccountInfo accountInfo = new AccountInfo();
		Book book = new Book();
		try {
			dao.openCurrentSessionwithTransaction();
			accountInfo.setAccountId(orderRequest.getAccountId());
			purchase.setAccount(accountInfo);
			purchase.setPurchase_id(UUID.randomUUID().toString());
			purchase.setShipping_info(orderRequest.getShipping_info());
			purchase.setStatus(orderRequest.getStatus());
			purchase.setTotal_price(orderRequest.getTotal_price());
			dao.persist(purchase);
			for (String bookid : orderRequest.getBookIds()) {
				POItem poitem = new POItem();
				book.setBookid(bookid);
				poitem.setBookid(book);
				poitem.setPurchase_id(purchase);
				poitem.setId(UUID.randomUUID().toString());
				dao.persist(poitem);
			}

			dao.closeCurrentSessionwithTransaction();
		} catch (Exception e) {
			throw new OrderProcessServiceException(ErrorCode.ORDER_AUTH_ERROR);
		}

	}

	public static void main(String[] args) {
		AccountInfo acc = new AccountInfo();
		acc.setAccountId("19d6650e-5f01-4d05-adeb-eba2c3653aab");
		Book book = new Book();
		book.setBookid("0132350882");
		POItem poitem = new POItem();
		PurchaseOrder purchase = new PurchaseOrder();
		purchase.setAccount(acc);
		purchase.setPurchase_id("909090903355");
		purchase.setShipping_info("myhouse");
		purchase.setStatus("ORDERED");
		purchase.setTotal_price(90898);
		DaoImpl dao = new DaoImpl();
		// poitem.setBook(book);
		poitem.setId(UUID.randomUUID().toString());
		poitem.setPurchase_id(purchase);
		dao.openCurrentSessionwithTransaction();

		OrderProcessService ord = new OrderProcessService();
		try {
			dao.persist(purchase);
			dao.persist(poitem);
			dao.closeCurrentSessionwithTransaction();
		} catch (Exception e) {
			System.out.println("here");
			e.printStackTrace();

		}
		// System.out.println("closing");

		// System.out.println(ord.checkIfAccountExists("varun222", "varun"));

	}
}
