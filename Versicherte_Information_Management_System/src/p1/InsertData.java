package p1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertData {
	public static void insertData(String firstName, String lastName, String birthDate, String insuranceNumber) {
		try (Connection connection = DatabaseConnection.getConnection()) {
			if (connection == null) {
				System.out.println("Bağlantı kurulamadı!");
				return;
			}

			String insertQuery = "INSERT INTO insured_persons (first_name, last_name, birth_date, insurance_number) VALUES (?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, birthDate);
			preparedStatement.setString(4, insuranceNumber);

			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Yeni sigortalı başarıyla eklendi!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
