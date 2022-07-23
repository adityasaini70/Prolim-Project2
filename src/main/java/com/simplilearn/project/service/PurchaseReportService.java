package com.simplilearn.project.service;

import java.util.Date;
import java.util.List;

import com.simplilearn.project.model.PurchaseReport;

public interface PurchaseReportService {

	public List<PurchaseReport> findByDateAndPurchasedShoe_Category(Date theDate, String theShoeCategory);
}
