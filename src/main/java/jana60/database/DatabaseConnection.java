package jana60.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatabaseConnection {

  public static void main(String[] args) {
    String url = "jdbc:mysql://localhost:3306/db_nations";
    String user = "root";
    String password = "rootpassword";

    List<Continent> continenti = new ArrayList<Continent>();


    Scanner scan = new Scanner(System.in);
    System.out.println("Quale continente vuoi vedere?");
    String nomeContinente = scan.nextLine();

    try (Connection conn = DriverManager.getConnection(url, user, password)) {
      // qui posso usare Connection conn
      if (!conn.isClosed()) {
        System.out.println("Sono connesso al database");



        String sql = "SELECT name FROM continents WHERE name = ? ORDER BY name";

        System.out.println("Query: " + sql);

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
          ps.setString(1, nomeContinente);

          try (ResultSet rs = ps.executeQuery()) {
            // itero sul resultset
            while (rs.next()) {
              // System.out.println(rs.getString("name"));
              Continent c = new Continent(rs.getString("name"));

              continenti.add(c);
            }
          }
        }
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    for (Continent cont : continenti) {
      System.out.println(cont.getName());
    }

    // Continent fake = new Continent("Fake");
    // continenti.add(fake);
    // for (Continent cont : continenti) {
    // System.out.println(cont.getName());
    // }

  }

}
