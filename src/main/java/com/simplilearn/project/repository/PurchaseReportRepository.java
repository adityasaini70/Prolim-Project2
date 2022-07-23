package com.simplilearn.project.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.project.model.PurchaseReport;

public interface PurchaseReportRepository extends JpaRepository<PurchaseReport, Long> {

	public List<PurchaseReport> findByDateAndPurchasedShoe_Category(Date theDate, String theShoeCategory);

}
