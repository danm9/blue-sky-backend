package com.blueskyapp.BlueSkyProject.model;

import javax.persistence.*;

@Entity
@Table(name = "serviceCategories")
public class ServiceCategories {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serviceId;
	private String serviceType;
	private String serviceDescription;
	
	public ServiceCategories() {
	}

	/**
	 * @param serviceId
	 * @param serviceType
	 * @param serviceDescription
	 */
	public ServiceCategories(int serviceId, String serviceType, String serviceDescription) {
		this.serviceId = serviceId;
		this.serviceType = serviceType;
		this.serviceDescription = serviceDescription;
	}

	/**
	 * @return the serviceId
	 */
	public int getServiceId() {
		return serviceId;
	}

	/**
	 * @param serviceId the serviceId to set
	 */
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	/**
	 * @return the serviceType
	 */
	public String getServiceType() {
		return serviceType;
	}

	/**
	 * @param serviceType the serviceType to set
	 */
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	/**
	 * @return the serviceDescription
	 */
	public String getServiceDescription() {
		return serviceDescription;
	}

	/**
	 * @param serviceDescription the serviceDescription to set
	 */
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}
	
}
