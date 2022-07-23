package com.simplilearn.project.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.project.errors.PurchaseReportNotFoundException;
import com.simplilearn.project.model.PurchaseReport;
import com.simplilearn.project.service.AdminService;
import com.simplilearn.project.service.PurchaseReportService;

@RestController
public class PurchaseReportResource {
	@Autowired
	private PurchaseReportService purchaseReportService;

	@Autowired
	private AdminService adminService;

	@GetMapping(path = "/sportyshoes/{username}/{password}/purchasetbl/{purchase_date}/{shoe_category}")
	public List<PurchaseReport> getPurchaseReportRepositoryByDateAndCategory(@PathVariable String username,
			@PathVariable String password, @PathVariable String purchase_date, @PathVariable String shoe_category)
			throws ParseException {
				
		// Validating admin: Raises AdminNotFoundException if invalid
		this.adminService.findByUsernameAndPassword(username, password);

		List<PurchaseReport> thePurchaseReport = this.purchaseReportService.findByDateAndPurchasedShoe_Category(
				(Date) new SimpleDateFormat("yyyy-MM-dd").parse(purchase_date), shoe_category);

		if (thePurchaseReport.size() == 0) {
			throw new PurchaseReportNotFoundException("Purchase Report with date - " + purchase_date
					+ " and category - " + shoe_category + " not found!");

		}
		return thePurchaseReport;
	}

}
