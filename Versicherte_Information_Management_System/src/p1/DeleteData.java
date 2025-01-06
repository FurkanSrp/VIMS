package p1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteData {
	public static void deletePerson(int id) {
		try (Connection conn = DatabaseConnection.getConnection()) {
			String deleteQuery = "DELETE FROM insured_persons WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
			pstmt.setInt(1, id);

			int rowsDeleted = pstmt.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Kayıt başarıyla silindi!");
			} else {
				System.out.println("ID bulunamadı, silme işlemi başarısız!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
