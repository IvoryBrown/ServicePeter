package com.service.newdevice.controller;

import com.service.client.controller.ClientController;
import com.service.newdevice.database.DeviceDataBase;
import com.service.newdevice.pojo.Device;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DeviceController {
	private TextField deviceClientNameTxt, deviceManufacturerTxt, deviceSnTxt, deviceAdministratorTxt,
			devicePasswordTxt;
	private TextArea deviceAccesssoryTxt, deviceInjuryTxt, deviceErrorDescriptionTxt, deviceCommentTxt;
	private ComboBox<String> deviceNameCmb;
	private DatePicker deviceAddDate, deviceEndDate;
	private String clientId;
	DeviceDataBase deviceDB = new DeviceDataBase();
	private String info;
	private String infoStyle;

	public DeviceController() {

	}

	public void setDevice(String clientId, TextField deviceManufacturerTxt, TextField deviceSnTxt,
			TextField deviceAdministratorTxt, TextField devicePasswordTxt, TextArea deviceAccesssoryTxt,
			TextArea deviceInjuryTxt, TextArea deviceErrorDescriptionTxt, TextArea deviceCommentTxt,
			ComboBox<String> deviceNameCmb, TextField deviceClientNameTxt, DatePicker deviceAddDate,
			DatePicker deviceEndDate) {
		this.clientId = clientId;
		this.deviceManufacturerTxt = deviceManufacturerTxt;
		this.deviceSnTxt = deviceSnTxt;
		this.deviceAdministratorTxt = deviceAdministratorTxt;
		this.devicePasswordTxt = devicePasswordTxt;
		this.deviceAccesssoryTxt = deviceAccesssoryTxt;
		this.deviceInjuryTxt = deviceInjuryTxt;
		this.deviceErrorDescriptionTxt = deviceErrorDescriptionTxt;
		this.deviceCommentTxt = deviceCommentTxt;
		this.deviceNameCmb = deviceNameCmb;
		this.deviceClientNameTxt = deviceClientNameTxt;
		this.deviceAddDate = deviceAddDate;
		this.deviceEndDate = deviceEndDate;
		saveDevice();
	}

	public String setMessage() {
		return info;
	}

	public String setMessageStyle() {
		return infoStyle;
	}

	private boolean checkDevice() {
		if (deviceManufacturerTxt.getText().trim().isEmpty() || deviceSnTxt.getText().trim().isEmpty()
				|| deviceAdministratorTxt.getText().trim().isEmpty() || deviceAddDate.getValue() == null
				|| deviceEndDate.getValue() == null || deviceErrorDescriptionTxt.getText().trim().isEmpty()
				|| deviceClientNameTxt.getText().trim().isEmpty()) {
			deviceClientNameTxt.setPromptText("Kötelező");
			deviceManufacturerTxt.setPromptText("Kötelező");
			deviceSnTxt.setPromptText("Kötelező");
			deviceAdministratorTxt.setPromptText("Kötelező");
			deviceAddDate.setPromptText("Kötelező");
			deviceEndDate.setPromptText("Kötelező");
			deviceErrorDescriptionTxt.setPromptText("Kötelező");
			return false;
		} else {
			deviceClientNameTxt.setPromptText("");
			deviceManufacturerTxt.setPromptText("");
			deviceSnTxt.setPromptText("");
			deviceAdministratorTxt.setPromptText("");
			deviceAddDate.setPromptText("");
			deviceEndDate.setPromptText("");
			deviceErrorDescriptionTxt.setPromptText("");
			return true;
		}
	}

	private void saveDevice() {
		if (clientId != null) {
			if (checkDevice()) {
				deviceDB.addNewDevice(new Device(deviceNameCmb.getSelectionModel().getSelectedItem(),
						deviceManufacturerTxt.getText(), deviceSnTxt.getText(), deviceAdministratorTxt.getText(),
						devicePasswordTxt.getText(), deviceAddDate.getValue().toString(),
						deviceEndDate.getValue().toString(), deviceAccesssoryTxt.getText(), deviceInjuryTxt.getText(),
						deviceErrorDescriptionTxt.getText(), deviceCommentTxt.getText(), clientId));
				info = "Sikeres mentés!";
				infoStyle = "-fx-text-fill: green;";
				deviceTextClear();
			} else {
				info = "Sikertelen mentés!";
				infoStyle = "-fx-text-fill: red;";
			}
		} else {
			info = "Sikertelen mentés! Válasz Ügyfelet!";
			infoStyle = "-fx-text-fill: red;";
		}
	}

	private void deviceTextClear() {
		deviceNameCmb.setValue(null);
		deviceClientNameTxt.clear();
		ClientController.setClientName("");
		deviceManufacturerTxt.clear();
		deviceSnTxt.clear();
		deviceAdministratorTxt.clear();
		devicePasswordTxt.clear();
		deviceAddDate.setValue(null);
		deviceEndDate.setValue(null);
		deviceAccesssoryTxt.clear();
		deviceInjuryTxt.clear();
		deviceErrorDescriptionTxt.clear();
		deviceCommentTxt.clear();
		clientId = null;
	}
}
