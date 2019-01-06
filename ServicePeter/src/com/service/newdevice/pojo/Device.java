package com.service.newdevice.pojo;

import javafx.beans.property.SimpleStringProperty;

public class Device {
	private final SimpleStringProperty deviceID;
	private final SimpleStringProperty deviceClientID;
	private final SimpleStringProperty deviceClientName;
	private final SimpleStringProperty deviceName;
	private final SimpleStringProperty deviceManufacturer;
	private final SimpleStringProperty deviceSerialNumber;
	private final SimpleStringProperty deviceAdministrator;
	private final SimpleStringProperty devicePassword;
	private final SimpleStringProperty deviceAddDate;
	private final SimpleStringProperty deviceEndDate;
	private final SimpleStringProperty deviceAccesssory;
	private final SimpleStringProperty deviceInjury;
	private final SimpleStringProperty deviceErrorDescription;
	private final SimpleStringProperty deviceErrorReal;
	private final SimpleStringProperty deviceStatus;
	private final SimpleStringProperty deviceComment;

	public Device(String deviceName, String deviceManufacturer, String deviceSerialNumber, String deviceAdministrator,
			String devicePassword, String deviceAddDate, String deviceEndDate, String deviceAccesssory,
			String deviceInjury, String deviceErrorDescription, String deviceComment, String deviceClientID) {
		this.deviceID = new SimpleStringProperty("");
		this.deviceClientID = new SimpleStringProperty(deviceClientID);
		this.deviceClientName = new SimpleStringProperty("");
		this.deviceName = new SimpleStringProperty(deviceName);
		this.deviceManufacturer = new SimpleStringProperty(deviceManufacturer);
		this.deviceSerialNumber = new SimpleStringProperty(deviceSerialNumber);
		this.deviceAdministrator = new SimpleStringProperty(deviceAdministrator);
		this.devicePassword = new SimpleStringProperty(devicePassword);
		this.deviceAccesssory = new SimpleStringProperty(deviceAccesssory);
		this.deviceInjury = new SimpleStringProperty(deviceInjury);
		this.deviceErrorDescription = new SimpleStringProperty(deviceErrorDescription);
		this.deviceStatus = new SimpleStringProperty("");
		this.deviceErrorReal = new SimpleStringProperty("");
		this.deviceComment = new SimpleStringProperty(deviceComment);
		this.deviceAddDate = new SimpleStringProperty(deviceAddDate);
		this.deviceEndDate = new SimpleStringProperty(deviceEndDate);

	}

	public Device(String deviceClientName, Integer deviceID, String deviceName, String deviceManufacturer,
			String deviceSerialNumber, String deviceAdministrator, String devicePassword, String deviceAddDate,
			String deviceEndDate, String deviceAccesssory, String deviceInjury, String deviceErrorDescription,
			String deviceErrorReal, String deviceStatus, String deviceComment, String deviceClientID) {
		this.deviceClientName = new SimpleStringProperty(deviceClientName);
		this.deviceID = new SimpleStringProperty(Integer.toString(deviceID));
		this.deviceClientID = new SimpleStringProperty(deviceClientID);
		this.deviceName = new SimpleStringProperty(deviceName);
		this.deviceManufacturer = new SimpleStringProperty(deviceManufacturer);
		this.deviceSerialNumber = new SimpleStringProperty(deviceSerialNumber);
		this.deviceAdministrator = new SimpleStringProperty(deviceAdministrator);
		this.devicePassword = new SimpleStringProperty(devicePassword);
		this.deviceAccesssory = new SimpleStringProperty(deviceAccesssory);
		this.deviceInjury = new SimpleStringProperty(deviceInjury);
		this.deviceErrorDescription = new SimpleStringProperty(deviceErrorDescription);
		this.deviceErrorReal = new SimpleStringProperty(deviceErrorReal);
		this.deviceStatus = new SimpleStringProperty(deviceStatus);
		this.deviceComment = new SimpleStringProperty(deviceComment);
		this.deviceAddDate = new SimpleStringProperty(deviceAddDate);
		this.deviceEndDate = new SimpleStringProperty(deviceEndDate);

	}

	public String getDeviceID() {
		return this.deviceID.get();
	}

	public void setDeviceID(String deviceID) {
		this.deviceID.set(deviceID);
	}

	public String getDeviceClientID() {
		return this.deviceClientID.get();
	}

	public void setDeviceClientID(String deviceClientID) {
		this.deviceClientID.set(deviceClientID);
	}

	public String getDeviceClientName() {
		return this.deviceClientName.get();
	}

	public void setDeviceClientName(String deviceClientName) {
		this.deviceClientName.set(deviceClientName);
	}

	public String getDeviceName() {
		return this.deviceName.get();
	}

	public void setDeviceName(String deviceName) {
		this.deviceName.set(deviceName);
	}

	public String getDeviceManufacturer() {
		return this.deviceManufacturer.get();
	}

	public void setDeviceManufacturer(String deviceManufacturer) {
		this.deviceManufacturer.set(deviceManufacturer);
	}

	public String getDeviceSerialNumber() {
		return this.deviceSerialNumber.get();
	}

	public void setDeviceSerialNumber(String deviceSerialNumber) {
		this.deviceSerialNumber.set(deviceSerialNumber);
	}

	public String getDeviceAdministrator() {
		return this.deviceAdministrator.get();
	}

	public void setDeviceAdministrator(String deviceAdministrator) {
		this.deviceAdministrator.set(deviceAdministrator);
	}

	public String getDevicePassword() {
		return this.devicePassword.get();
	}

	public void setDevicePassword(String devicePassword) {
		this.devicePassword.set(devicePassword);
	}

	public String getDeviceAccesssory() {
		return this.deviceAccesssory.get();
	}

	public void setDeviceAccesssory(String deviceAccesssory) {
		this.deviceAccesssory.set(deviceAccesssory);
	}

	public String getDeviceInjury() {
		return this.deviceInjury.get();
	}

	public void setDeviceInjury(String deviceInjury) {
		this.deviceInjury.set(deviceInjury);
	}

	public String getDeviceErrorDescription() {
		return this.deviceErrorDescription.get();
	}

	public void setDeviceErrorDescription(String deviceErrorDescription) {
		this.deviceErrorDescription.set(deviceErrorDescription);
	}
	
	public String getDeviceErrorReal() {
		return this.deviceErrorReal.get();
	}
	
	public void setDeviceErrorReal(String deviceErrorReal) {
		this.deviceErrorReal.set(deviceErrorReal);
	}
	public String getDeviceStatus() {
		return this.deviceStatus.get();
	}
	
	public void setDeviceStatus(String deviceStatus) {
		this.deviceStatus.set(deviceStatus);
	}

	public String getDeviceAddDate() {
		return this.deviceAddDate.get();
	}

	public void setDeviceAddDate(String deviceAddDate) {
		this.deviceAddDate.set(deviceAddDate);
	}

	public String getDeviceEndDate() {
		return this.deviceEndDate.get();
	}

	public void setDeviceEndDate(String deviceEndDate) {
		this.deviceEndDate.set(deviceEndDate);
	}

	public String getDeviceComment() {
		return this.deviceComment.get();
	}

	public void setDeviceComment(String deviceComment) {
		this.deviceComment.set(deviceComment);
	}

}
