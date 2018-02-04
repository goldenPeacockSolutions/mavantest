package com.society.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.society.model.BillHead;
import com.society.repository.BillHeadRepository;

@Service("billHeadService")
public class BillHeadServiceImpl implements BillHeadService{

	@Autowired
	BillHeadRepository billHeadRepository;
	
	@Override
	public void saveBillHead(BillHead billHead) {
		billHead.setName(billHead.getName());
		billHeadRepository.save(billHead);
	}

	@Override
	public BillHead findBillHead(String name) {
		return billHeadRepository.findByName(name);
	}

	@Override
	public List<BillHead> listAllBillHeads() {
		return billHeadRepository.findByNameNotNull();
	}

}