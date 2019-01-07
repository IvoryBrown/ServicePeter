package com.service.client.controller;

import com.service.client.database.ClientDataBase;
import com.service.client.pojo.Client;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class ClientController {

	private TextField clientNameTxt, clientAddressTxt, clientPhoneTxt, clientMailTxt, clientCommentTxt;
	private ClientDataBase clientDB = new ClientDataBase();
	private String info;
	private String infoStyle;

	private TableView<Client> clientTable;
	private TableColumn<Client, Integer> clientIdColumn;
	private TableColumn<Client, String> clientNameColumn, clientAddressColumn, clientPhoneColumn, clientMailColumn,
			clientCommentColumn;
	private final ObservableList<Client> dataClient = FXCollections.observableArrayList();
	private static String clientId, clientName;

	public ClientController() {
	}

	public void setClient(TextField clientNameTxt, TextField clientAddressTxt, TextField clientPhoneTxt,
			TextField clientMailTxt, TextField clientCommentTxt) {
		this.clientNameTxt = clientNameTxt;
		this.clientAddressTxt = clientAddressTxt;
		this.clientPhoneTxt = clientPhoneTxt;
		this.clientMailTxt = clientMailTxt;
		this.clientCommentTxt = clientCommentTxt;
		saveClient();

	}

	private boolean checkClient() {
		if (clientNameTxt.getText().trim().isEmpty() || clientAddressTxt.getText().trim().isEmpty()
				|| clientPhoneTxt.getText().trim().isEmpty()) {
			clientNameTxt.setPromptText("Kötelező");
			clientAddressTxt.setPromptText("Kötelező");
			clientPhoneTxt.setPromptText("Kötelező");
			return false;
		} else {
			clientNameTxt.setPromptText("Teszt Béla");
			clientAddressTxt.setPromptText("Aprajafalva Kálvária sgt. 65/b");
			clientPhoneTxt.setPromptText("+36 90 999 9999");
			return true;
		}
	}

	private void saveClient() {
		if (checkClient()) {
			clientDB.addNewClient(new Client(clientNameTxt.getText(), clientAddressTxt.getText(),
					clientPhoneTxt.getText(), clientMailTxt.getText(), clientCommentTxt.getText()));
			info = "Sikeres mentés!";
			infoStyle="-fx-text-fill: green;";
			clientTextClear();
			setTable();
		} else {
			info = "Sikertelen mentés!";
			infoStyle="-fx-text-fill: red;";
		}

	}

	public String setMessage() {
		return info;
	}
	public String setMessageStyle() {
		return infoStyle;
	}

	private void clientTextClear() {
		clientNameTxt.clear();
		clientAddressTxt.clear();
		clientPhoneTxt.clear();
		clientMailTxt.clear();
		clientCommentTxt.clear();
	}

	public void setClientTable(TableView<Client> clientTable) {
		this.clientTable = clientTable;
		getTable();
	}

	@SuppressWarnings("unchecked")
	private void getTable() {
		clientIdColumn = new TableColumn<>("ID");
		clientIdColumn.setMinWidth(50);
		clientIdColumn.setCellValueFactory(new PropertyValueFactory<Client, Integer>("clientId"));

		clientNameColumn = new TableColumn<>("Név");
		clientNameColumn.setMinWidth(150);
		clientNameColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("clientName"));

		clientAddressColumn = new TableColumn<>("Lakcím");
		clientAddressColumn.setMinWidth(450);
		clientAddressColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("clientAddress"));
		clientAddressColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		clientAddressColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Client, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<Client, String> d) {
				Client actualClient = (Client) d.getTableView().getItems().get(d.getTablePosition().getRow());
				actualClient.setClientAddress(d.getNewValue());
				clientDB.updateClient(actualClient);
			}
		});

		clientPhoneColumn = new TableColumn<>("Telefonszám");
		clientPhoneColumn.setMinWidth(150);
		clientPhoneColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("clientPhone"));
		clientPhoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		clientPhoneColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Client, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<Client, String> d) {
				Client actualClient = (Client) d.getTableView().getItems().get(d.getTablePosition().getRow());
				actualClient.setClientPhone(d.getNewValue());
				clientDB.updateClient(actualClient);
			}
		});

		clientMailColumn = new TableColumn<>("Email");
		clientMailColumn.setMinWidth(150);
		clientMailColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("clientMail"));
		clientMailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		clientMailColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Client, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<Client, String> d) {
				Client actualClient = (Client) d.getTableView().getItems().get(d.getTablePosition().getRow());
				actualClient.setClientMail(d.getNewValue());
				clientDB.updateClient(actualClient);
			}
		});

		clientCommentColumn = new TableColumn<>("Megjegyzés");
		clientCommentColumn.setMinWidth(450);
		clientCommentColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("clientComment"));
		clientCommentColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		clientCommentColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Client, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<Client, String> d) {
				Client actualClient = (Client) d.getTableView().getItems().get(d.getTablePosition().getRow());
				actualClient.setClientComment(d.getNewValue());
				clientDB.updateClient(actualClient);
			}
		});

		clientTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Client>() {
			@Override
			public void changed(ObservableValue<? extends Client> observable, Client oldValue, Client newValue) {
				if (oldValue == null || newValue != null) {
					clientId = newValue.getClientId();
					clientName = newValue.getClientName();

				}
			}
		});

		clientTable.setItems(dataClient);
		clientTable.getColumns().addAll(clientIdColumn, clientNameColumn, clientAddressColumn, clientPhoneColumn,
				clientMailColumn, clientCommentColumn);
		setTable();
	}

	private void setTable() {
		dataClient.clear();
		dataClient.addAll(clientDB.getAllClient());

	}

	public static String getClientId() {
		return clientId;
	}

	public static void setClientId(String clientId) {
		ClientController.clientId = clientId;
	}

	public static String getClientName() {
		return clientName;
	}

	public static void setClientName(String clientName) {
		ClientController.clientName = clientName;
	}

}
