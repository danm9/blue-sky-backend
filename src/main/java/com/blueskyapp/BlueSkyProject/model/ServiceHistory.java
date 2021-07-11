package com.blueskyapp.BlueSkyProject.model;

import javax.persistence.*;

@Entity
@Table(name = "service_history")
public class ServiceHistory {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int historyId;
    private int invoiceId;
    private int serviceId;
    
	public ServiceHistory() {
	}

	public ServiceHistory(int historyId, int serviceId, int invoiceId) {
		this.historyId = historyId;
		this.invoiceId = invoiceId;
		this.serviceId = serviceId;
	}
	
	public int getHistoryId() {
		return historyId;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}
	
	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
}
