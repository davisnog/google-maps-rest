package com.davisnog.geocode;

import java.util.List;


public class Result {

	private String formattedAddress;
	private List<AddressComponents> addressComponents;
	private Geometry geometry;

	public String getFormattedAddress() {
		return formattedAddress;
	}

	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}

	public List<AddressComponents> getAddressComponents() {
		return addressComponents;
	}

	public void setAddressComponents(List<AddressComponents> addressComponents) {
		this.addressComponents = addressComponents;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

}
