import java.sql.*;
import java.util.Scanner;

public class HospitalManagement {
private static final String URL =
    "jdbc:mysql://localhost:3306/hospitaldb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
private static final String USER = "root";
private static final String PASSWORD = "Ranaghat123@";

public static void main(String[] args) {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // load driver
    } catch (ClassNotFoundException e) {
        System.out.println("❌ JDBC Driver not found. Add mysql-connector-j.jar to classpath.");
        return;
    }
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Hospital Management System =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Delete Patient");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addPatient(sc);
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    deletePatient(sc);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addPatient(Scanner sc) {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter disease: ");
        String disease = sc.nextLine();

        String sql = "INSERT INTO patients (name, age, gender, disease) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, gender);
            stmt.setString(4, disease);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Patient added successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void viewPatients() {
        String sql = "SELECT * FROM patients";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\nID\tName\t\tAge\tGender\t\tDisease");
            System.out.println("----------------------------------------------------");
            while (rs.next()) {
                System.out.printf("%d\t%s\t\t%d\t%s\t\t%s\n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("disease"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deletePatient(Scanner sc) {
        System.out.print("Enter patient ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM patients WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Patient deleted successfully!");
            } else {
                System.out.println("No patient found with that ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
