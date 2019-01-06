package com.service.client.pojo;

import javafx.beans.property.SimpleStringProperty;

public class Client {

	private final SimpleStringProperty clientId;
	private final SimpleStringProperty clientName;
	private final SimpleStringProperty clientAddress;
	private final SimpleStringProperty clientPhone;
	private final SimpleStringProperty clientMail;
	private final SimpleStringProperty clientComment;

	public Client(String clientName, String clientAddress, String clientPhone, String clientMail,
			String clientComment) {
		this.clientName = new SimpleStringProperty(clientName);
		this.clientAddress = new SimpleStringProperty(clientAddress);
		this.clientPhone = new SimpleStringProperty(clientPhone);
		this.clientMail = new SimpleStringProperty(clientMail);
		this.clientComment = new SimpleStringProperty(clientComment);
		this.clientId = new SimpleStringProperty("");
	}

	public Client(Integer clientId, String clientName, String clientAddress, String clientPhone, String clientMail,
			String clientComment) {
		this.clientName = new SimpleStringProperty(clientName);
		this.clientAddress = new SimpleStringProperty(clientAddress);
		this.clientPhone = new SimpleStringProperty(clientPhone);
		this.clientMail = new SimpleStringProperty(clientMail);
		this.clientComment = new SimpleStringProperty(clientComment);
		this.clientId = new SimpleStringProperty(Integer.toString(clientId));
	}

	public String getClientId() {
		return this.clientId.get();
	}

	public void setClientId(String ClientId) {
		this.clientId.set(ClientId);
	}

	public String getClientName() {
		return this.clientName.get();
	}

	public void setClientName(String ClientName) {
		this.clientName.set(ClientName);
	}

	public String getClientAddress() {
		return this.clientAddress.get();
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress.set(clientAddress);
	}

	public String getClientPhone() {
		return this.clientPhone.get();
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone.set(clientPhone);
	}

	public String getClientMail() {
		return this.clientMail.get();
	}

	public void setClientMail(String clientMail) {
		this.clientMail.set(clientMail);
	}

	public String getClientComment() {
		return this.clientComment.get();
	}

	public void setClientComment(String clientComment) {
		this.clientComment.set(clientComment);
	}
}
