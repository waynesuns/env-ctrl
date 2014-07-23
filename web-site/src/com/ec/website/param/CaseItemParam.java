package com.ec.website.param;

public class CaseItemParam {
	private String firstName;
	private String lastName;
	private String productName;
	private String itemName;
	
	public CaseItemParam(String firstName,String lastName,String productName,String itemName){
		this.firstName = firstName;
		this.lastName = lastName;
		this.productName = productName;
		this.itemName = itemName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	
}
