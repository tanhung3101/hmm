package com.nop.services;

import java.util.List;

import com.nop.entity.Bill;

public interface BillService {
	public List<Bill> getBills() throws Exception;
	public List<Bill> getBillsByMonth(String month) throws Exception;
	public Bill addBill(Bill b) throws Exception;
	public Bill updateBill(Bill b) throws Exception;
	public void  deleteBill(long b) throws Exception;

	Bill getBillByID(long id) throws Exception;
}
