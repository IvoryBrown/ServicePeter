package com.service.client.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.service.client.pojo.Client;
import com.service.setting.DataBaseConnect;


public class ClientDataBase {

	public ArrayList<Client> getAllClient() {
		String sql = "SELECT * FROM `ugyfel`";
		Connection con = DataBaseConnect.getConnection();
		ArrayList<Client> client = null;
		Statement createStatement = null;
		ResultSet rs = null;
		try {
			createStatement = con.createStatement();
			rs = createStatement.executeQuery(sql);
			client = new ArrayList<>();

			while (rs.next()) {
				Client actualClient = new Client(rs.getInt("ugyfel_id"), rs.getString("nev"), rs.getString("lakcim"),
						rs.getString("telefon"), rs.getString("email"), rs.getString("megjegyzes"));
				client.add(actualClient);
			}
		} catch (SQLException ex) {
			System.out.println("Valami baj van a userek kiolvasásakor");
			System.out.println("" + ex);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (createStatement != null) {
					createStatement.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("Valami baj van a userek kiolvasásakor");
				System.out.println("" + e);
			}
		}
		return client;
	}

	public void addNewClient(Client client) {
		Connection con = DataBaseConnect.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO `ugyfel` ( nev, lakcim, telefon, email, megjegyzes) VALUES (?,?,?,?,?)";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, client.getClientName());
			preparedStatement.setString(2, client.getClientAddress());
			preparedStatement.setString(3, client.getClientPhone());
			preparedStatement.setString(4, client.getClientMail());
			preparedStatement.setString(5, client.getClientComment());
			preparedStatement.execute();
		} catch (SQLException ex) {
			System.out.println("Valami baj van a contact hozzáadásakor");
			System.out.println("" + ex);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("Valami baj van a contact hozzáadásakor");
				System.out.println("" + e);
			}
		}
	}

	public void updateClient(Client client) {
		Connection con = DataBaseConnect.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "UPDATE `ugyfel` SET lakcim = ?, telefon = ? , email = ?, megjegyzes = ? WHERE ugyfel_id = ?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, client.getClientAddress());
			preparedStatement.setString(2, client.getClientPhone());
			preparedStatement.setString(3, client.getClientMail());
			preparedStatement.setString(4, client.getClientComment());
			preparedStatement.setInt(5, Integer.parseInt(client.getClientId()));
			preparedStatement.execute();
		} catch (SQLException ex) {
			System.out.println("Valami baj van a contact hozzáadásakor");
			System.out.println("" + ex);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				System.out.println("Valami baj van a contact hozzáadásakor");
				System.out.println("" + ex);
			}
		}
	}
}
