package com.service.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.service.client.controller.ClientController;
import com.service.client.pojo.Client;
import com.service.device.controller.DeviceControllerTable;
import com.service.newdevice.controller.DeviceController;
import com.service.newdevice.pojo.Device;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class ServiceController implements Initializable {

	@FXML
	private StackPane menuPane;
	@FXML
	private AnchorPane homePane, clientPane, newDevicePane, devicePane;
	@FXML
	private TreeView<String> menuListView;
	@FXML
	private SplitPane splitPane;
	@FXML
	private TextField clientNameTxt, clientAddressTxt, clientPhoneTxt, clientMailTxt, clientCommentTxt;
	@FXML
	private Label clientLabel;
	@FXML
	private TableView<Client> clientTable;
	private ClientController clientController = new ClientController();

	@FXML
	private TextField deviceClientNameTxt, deviceManufacturerTxt, deviceSnTxt, deviceAdministratorTxt,
			devicePasswordTxt;
	@FXML
	private TextArea deviceAccesssoryTxt, deviceInjuryTxt, deviceErrorDescriptionTxt, deviceCommentTxt;
	@FXML
	private ComboBox<String> deviceNameCmb;
	@FXML
	private Label newDeviceMessage;
	@FXML
	private DatePicker deviceAddDate, deviceEndDate;
	private DeviceController deviceNewController = new DeviceController();
	@FXML
	private TableView<Device> deviceTable;
	private DeviceControllerTable device = new DeviceControllerTable();

	private final String MENU_HOME = "Kezdőlap";
	private final String CLIENT = "Ügyfél";
	private final String MENU_DEVICE = "Eszköz";
	private final String MENU_DEVICE_NEWDEVICE = "Új eszköz";
	private final String MENU_DEVICE_DEVICE = "Eszköz tábla";
	private final String MENU_EXIT = "Kilépés";

	@SuppressWarnings("unchecked")
	private void setMenuData() {
		TreeItem<String> treeItemRoot1 = new TreeItem<>("Menü");
		menuListView = new TreeView<String>(treeItemRoot1);
		menuListView.setShowRoot(false);

		TreeItem<String> nodeItemA = new TreeItem<String>(MENU_HOME);
		TreeItem<String> nodeItemB2 = new TreeItem<String>(CLIENT);

		TreeItem<String> nodeItemD = new TreeItem<String>(MENU_DEVICE);
		nodeItemD.setExpanded(false);
		TreeItem<String> nodeItemD1 = new TreeItem<String>(MENU_DEVICE_NEWDEVICE);
		TreeItem<String> nodeItemD2 = new TreeItem<String>(MENU_DEVICE_DEVICE);
		TreeItem<String> nodeItemC = new TreeItem<String>(MENU_EXIT);

		nodeItemD.getChildren().addAll(nodeItemD1, nodeItemD2);
		treeItemRoot1.getChildren().addAll(nodeItemA, nodeItemB2, nodeItemD, nodeItemC);
		menuPane.getChildren().add(menuListView);

		menuListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
			public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
				TreeItem<String> selectedItem = (TreeItem<String>) newValue;
				String selectedMenu;
				selectedMenu = selectedItem.getValue();
				if (null != selectedMenu) {
					switch (selectedMenu) {
					case MENU_HOME:
						homePane.setVisible(true);
						clientPane.setVisible(false);
						newDevicePane.setVisible(false);
						devicePane.setVisible(false);
						break;
					case CLIENT:
						homePane.setVisible(false);
						clientPane.setVisible(true);
						newDevicePane.setVisible(false);
						devicePane.setVisible(false);
						break;
					case MENU_DEVICE_NEWDEVICE:
						homePane.setVisible(false);
						clientPane.setVisible(false);
						newDevicePane.setVisible(true);
						devicePane.setVisible(false);
						deviceClientNameTxt.setText(ClientController.getClientName());
						break;
					case MENU_DEVICE_DEVICE:
						homePane.setVisible(false);
						clientPane.setVisible(false);
						newDevicePane.setVisible(false);
						devicePane.setVisible(true);
						deviceTable.getItems().clear();
						deviceTable.getColumns().clear();
						device.setDeviceTable(deviceTable);
						break;
					case MENU_EXIT:
						System.exit(0);
					}
				}
			}
		});
	}

	@FXML
	private void clientSave() {
		clientController.setClient(clientNameTxt, clientAddressTxt, clientPhoneTxt, clientMailTxt, clientCommentTxt);
		clientLabel.setText(clientController.setMessage());
		clientLabel.setStyle(clientController.setMessageStyle());
	}

	@FXML
	private void deviceSave() {
			deviceNewController.setDevice(ClientController.getClientId(), deviceManufacturerTxt, deviceSnTxt,
					deviceAdministratorTxt, devicePasswordTxt, deviceAccesssoryTxt, deviceInjuryTxt,
					deviceErrorDescriptionTxt, deviceCommentTxt, deviceNameCmb, deviceClientNameTxt, deviceAddDate,
					deviceEndDate);
		
		newDeviceMessage.setText(deviceNewController.setMessage());
		newDeviceMessage.setStyle(deviceNewController.setMessageStyle());
	}

	private void getHomeController() {
		setMenuData();
		splitPane.setDividerPositions(0.10);
		clientController.setClientTable(clientTable);
		deviceNameCmb.getItems().addAll(setDeviceNameCombobox());
		device.setDeviceTable(deviceTable);
	}

	private String[] setDeviceNameCombobox() {
		final String CMBDEVICENAME[] = { "Asztali PC", "Notebook", "Nyomtató", "Monitor", "Projektor", "Pendrive",
				"Szünetmentes tápegység", "Egyéb" };
		return CMBDEVICENAME;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		getHomeController();
	}

}
