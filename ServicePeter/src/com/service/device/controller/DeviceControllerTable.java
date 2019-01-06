package com.service.device.controller;

import java.util.Date;

import com.service.newdevice.database.DeviceDataBase;
import com.service.newdevice.pojo.Device;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class DeviceControllerTable {
	private TableView<Device> deviceTable;
	private TableColumn<Device, Integer> deviceTableId;

	private TableColumn<Device, String> deviceTableClientName, deviceTableName, deviceTabelManufacturer,
			deviceTabelSerialNumber, deviceTableAdministrator, deviceTablePassword, deviceTableAccesssory,
			deviceTableInjury, deviceTableErrorDescription, deviceTableComment, deviceTableErrorReal, deviceTableStatus;
	private TableColumn<Device, Date> addTableDate, endTableDate;
	private static final ObservableList<Device> dataDevice = FXCollections.observableArrayList();
	private DeviceDataBase deviceDB = new DeviceDataBase();

	public void setDeviceTable(TableView<Device> deviceTable) {
		this.deviceTable = deviceTable;
		getTable();
	}

	@SuppressWarnings("unchecked")
	private void getTable() {
		deviceTableId = new TableColumn<>("ID");
		deviceTableId.setMinWidth(50);
		deviceTableId.setCellValueFactory(new PropertyValueFactory<Device, Integer>("deviceID"));

		deviceTableClientName = new TableColumn<>("Ügyfél név");
		deviceTableClientName.setMinWidth(150);
		deviceTableClientName.setCellValueFactory(new PropertyValueFactory<Device, String>("deviceClientName"));

		deviceTableName = new TableColumn<>("Eszköz név");
		deviceTableName.setMinWidth(50);
		deviceTableName.setCellValueFactory(new PropertyValueFactory<Device, String>("deviceName"));

		deviceTabelManufacturer = new TableColumn<>("Gyártó");
		deviceTabelManufacturer.setMinWidth(100);
		deviceTabelManufacturer.setCellValueFactory(new PropertyValueFactory<Device, String>("deviceManufacturer"));

		deviceTabelSerialNumber = new TableColumn<>("Serial No.");
		deviceTabelSerialNumber.setMinWidth(100);
		deviceTabelSerialNumber.setCellValueFactory(new PropertyValueFactory<Device, String>("deviceSerialNumber"));

		deviceTableAdministrator = new TableColumn<>("Ügyintéző");
		deviceTableAdministrator.setMinWidth(150);
		deviceTableAdministrator.setCellValueFactory(new PropertyValueFactory<Device, String>("deviceAdministrator"));

		deviceTablePassword = new TableColumn<>("Eszköz jelszó");
		deviceTablePassword.setMinWidth(100);
		deviceTablePassword.setCellValueFactory(new PropertyValueFactory<Device, String>("devicePassword"));

		deviceTableStatus = new TableColumn<>("Státusz");
		deviceTableStatus.setMinWidth(100);
		deviceTableStatus.setCellValueFactory(i -> {
			final String value = i.getValue().getDeviceStatus();
			return Bindings.createObjectBinding(() -> value);
		});
		deviceTableStatus.setCellFactory(ComboBoxTableCell.forTableColumn(setDeviceStatus()));
		deviceTableStatus.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Device, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<Device, String> d) {
				Device device = (Device) d.getTableView().getItems().get(d.getTablePosition().getRow());
				device.setDeviceStatus(d.getNewValue());
				deviceDB.updateDevice(device);
			}
		});

		addTableDate = new TableColumn<>("Bejelentés dátuma");
		addTableDate.setMinWidth(50);
		addTableDate.setCellValueFactory(new PropertyValueFactory<Device, Date>("deviceAddDate"));

		endTableDate = new TableColumn<>("Határidő dátuma");
		endTableDate.setMinWidth(50);
		endTableDate.setCellValueFactory(new PropertyValueFactory<Device, Date>("deviceEndDate"));

		deviceTableAccesssory = new TableColumn<>("Tartozék");
		deviceTableAccesssory.setMinWidth(150);
		deviceTableAccesssory.setCellValueFactory(new PropertyValueFactory<Device, String>("deviceAccesssory"));

		deviceTableInjury = new TableColumn<>("Sérülés");
		deviceTableInjury.setMinWidth(250);
		deviceTableInjury.setCellValueFactory(new PropertyValueFactory<Device, String>("deviceInjury"));

		deviceTableErrorDescription = new TableColumn<>("Hiba Leírás");
		deviceTableErrorDescription.setMinWidth(450);
		deviceTableErrorDescription
				.setCellValueFactory(new PropertyValueFactory<Device, String>("deviceErrorDescription"));

		deviceTableErrorReal = new TableColumn<>("Valos hiba");
		deviceTableErrorReal.setMinWidth(450);
		deviceTableErrorReal.setCellValueFactory(new PropertyValueFactory<Device, String>("deviceErrorReal"));
		deviceTableErrorReal.setCellFactory(TextFieldTableCell.forTableColumn());
		deviceTableErrorReal.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Device, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<Device, String> d) {
				Device device = (Device) d.getTableView().getItems().get(d.getTablePosition().getRow());
				device.setDeviceErrorReal(d.getNewValue());
				deviceDB.updateDevice(device);

			}
		});

		deviceTableComment = new TableColumn<>("Megjegyzés");
		deviceTableComment.setMinWidth(450);
		deviceTableComment.setCellValueFactory(new PropertyValueFactory<Device, String>("deviceComment"));

		deviceTable.setItems(dataDevice);

		deviceTable.getColumns().addAll(deviceTableId, deviceTableClientName, deviceTableName, deviceTabelManufacturer,
				deviceTabelSerialNumber, deviceTableAdministrator, deviceTablePassword, deviceTableStatus, addTableDate,
				endTableDate, deviceTableAccesssory, deviceTableInjury, deviceTableErrorDescription,
				deviceTableErrorReal, deviceTableComment);
		setTable();
	}

	private void setTable() {
		dataDevice.clear();
		dataDevice.addAll(deviceDB.getAllDevice());

	}

	public static ObservableList<Device> getDatadevice() {
		return dataDevice;
	}

	private String[] setDeviceStatus() {
		final String CMBDEVICENAME[] = { "Bevizsgálás alatt", "Továbbküldve", "Bevizsgálva", };
		return CMBDEVICENAME;
	}

}
