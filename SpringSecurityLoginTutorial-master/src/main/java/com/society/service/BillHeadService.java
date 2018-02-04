package com.society.service;

import java.util.List;

import com.society.model.BillHead;

public interface BillHeadService {
	
	public void saveBillHead(BillHead billHead);

	public BillHead findBillHead(String billHead);

	public List<BillHead> listAllBillHeads();

}
