package com.nop.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nop.entity.Bill;
import com.nop.entity.Person;
import com.nop.repository.BillRepository;
import com.nop.services.BillService;
import com.nop.services.CommonService;
import com.nop.ultilities.Utilities;

@Service
public class BillServiceImpl implements BillService{
	
	public static final Logger logger = LoggerFactory.getLogger(BillServiceImpl.class);
	
	@Autowired
	private BillRepository billDAO;
	
	@Autowired
	private CommonService comService;
	
	@Override
	public List<Bill> getBills() throws Exception {
		// TODO Auto-generated method stub
			return billDAO.findAll();
	}

	@Override
	public Bill addBill(Bill b) throws Exception {
		logger.info("addBill");
		// TODO Auto-generated method stub
			return billDAO.save(b);
	}

	@Override
	public Bill updateBill(Bill bill) throws Exception {
		logger.info("updateBill");
		// TODO Auto-generated method stub
		if(bill.getPayer()==null){
			bill.setPayer(null);
		}else if(Utilities.isNumeric(bill.getPayer().getPersonName())){
			int personId=Utilities.parseInt(bill.getPayer().getPersonName());
			Person payer=this.comService.getPersonByID(personId);
			if (payer!=null)
				bill.setPayer(payer);
		}
		return	billDAO.saveAndFlush(bill);
	}

	@Override
	public void deleteBill(long id) throws Exception {
		// TODO Auto-generated method stub
		 Bill bill = billDAO.findOne(id);
		 bill.setPayer(null);
		 billDAO.delete(bill);
	}

	@Override
	public Bill getBillByID(long id) throws Exception {
			return  billDAO.findOne(id);
	}

	@Override
	public List<Bill> getBillsByMonth(String month) throws Exception {
		// TODO Auto-generated method stub
			return billDAO.findBillByMonth(month);
	}
	
	
	
}
