package com.simplilearn.project.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.project.model.PurchaseReport;
import com.simplilearn.project.repository.PurchaseReportRepository;

@Service(value = "purchaseReportService")
public class PurchaseReportServiceImpl implements PurchaseReportService {

	@Autowired
	private PurchaseReportRepository purchaseReportRepository;

	public PurchaseReportServiceImpl() {
		super();
	}

	public PurchaseReportServiceImpl(PurchaseReportRepository purchaseReportRepository) {
		super();
		this.purchaseReportRepository = purchaseReportRepository;
	}

	@Override
	public List<PurchaseReport> findByDateAndPurchasedShoe_Category(Date theDate, String theShoeCategory){
		// TODO Auto-generated method stub
		return this.purchaseReportRepository.findByDateAndPurchasedShoe_Category(theDate, theShoeCategory);
	}

}
