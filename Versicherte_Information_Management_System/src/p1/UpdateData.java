package p1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateData {
	public static void updatePersonData(int id, String firstName, String lastName, String birthDate,
			String insuranceNumber) {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String updateQuery = "UPDATE insured_persons SET first_name = ?, last_name = ?, birth_date = ?, insurance_number = ? WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, birthDate);
			preparedStatement.setString(4, insuranceNumber);
			preparedStatement.setInt(5, id);

			int rowsUpdated = preparedStatement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Kişi bilgileri başarıyla güncellendi!");
			} else {
				System.out.println("Belirtilen ID'ye sahip bir kişi bulunamadı.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
