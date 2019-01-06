package com.service.newdevice.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.service.client.pojo.Client;
import com.service.newdevice.pojo.Device;
import com.service.setting.DataBaseConnect;

public class DeviceDataBase {

	public ArrayList<Device> getAllDevice() {
		String sql = "SELECT * FROM `ugyfel` JOIN `eszkoz` ON ugyfel_id = ugyfel_ugyfel_id ";
		Connection con = DataBaseConnect.getConnection();
		ArrayList<Device> device = null;
		Statement createStatement = null;
		ResultSet rs = null;
		try {
			createStatement = con.createStatement();
			rs = createStatement.executeQuery(sql);
			device = new ArrayList<>();

			while (rs.next()) {
				Device actualDevice = new Device(rs.getString("nev"), rs.getInt("eszkoz_id"), rs.getString("eszkoz"),
						rs.getString("gyarto"), rs.getString("serial_no"), rs.getString("ugyintezo"),
						rs.getString("jelszo"), rs.getString("bejelentes"), rs.getString("hatarido"),
						rs.getString("tartozek"), rs.getString("serules"), rs.getString("hiba_leiras"),
						rs.getString("valos_hiba"), rs.getString("statusz"), rs.getString("eszkoz_megjegyzes"),
						rs.getString("ugyfel_ugyfel_id"));
				device.add(actualDevice);
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
		return device;
	}

	public void addNewDevice(Device device) {
		Connection con = DataBaseConnect.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO `eszkoz` ( eszkoz, gyarto, serial_no, ugyintezo, jelszo, bejelentes, hatarido,"
					+ " tartozek, serules, hiba_leiras, eszkoz_megjegyzes,ugyfel_ugyfel_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, device.getDeviceName());
			preparedStatement.setString(2, device.getDeviceManufacturer());
			preparedStatement.setString(3, device.getDeviceSerialNumber());
			preparedStatement.setString(4, device.getDeviceAdministrator());
			preparedStatement.setString(5, device.getDevicePassword());
			preparedStatement.setString(6, device.getDeviceAddDate());
			preparedStatement.setString(7, device.getDeviceEndDate());
			preparedStatement.setString(8, device.getDeviceAccesssory());
			preparedStatement.setString(9, device.getDeviceInjury());
			preparedStatement.setString(10, device.getDeviceErrorDescription());
			preparedStatement.setString(11, device.getDeviceComment());
			preparedStatement.setString(12, device.getDeviceClientID());
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

	public void updateDevice(Device device) {
		Connection con = DataBaseConnect.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "UPDATE `eszkoz` SET statusz = ?, valos_hiba = ?  WHERE eszkoz_id = ?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, device.getDeviceStatus());
			preparedStatement.setString(2, device.getDeviceErrorReal());
			preparedStatement.setInt(3, Integer.parseInt(device.getDeviceID()));
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
