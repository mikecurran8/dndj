import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class characterRolls extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "jdbc:mysql://192.168.7.44:3306/dnd"; // Replace mydatabase with your database name
        String dbuser = "dnd"; // Replace your-username with your MySQL username
        String dbpass = "password"; // Replace your-password with your MySQL password

	int strength = Integer.parseInt(request.getParameter("strength"));
	int dexterity = Integer.parseInt(request.getParameter("dexterity"));
	int constitution = Integer.parseInt(request.getParameter("constitution"));
	int wisdom = Integer.parseInt(request.getParameter("wisdom"));
	int intelligence = Integer.parseInt(request.getParameter("intelligence"));
        int charisma = Integer.parseInt(request.getParameter("charisma"));

        try (Connection conn = DriverManager.getConnection(url, dbuser, dbpass)) {
            String sqlCharacterRolls = "INSERT INTO characterRolls (strength, dexterity, constitution, wisdom, intelligence, charisma) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmtCharacterRolls = conn.prepareStatement(sqlCharacterRolls);
            stmtCharacterRolls.setInt(1, strength);
            stmtCharacterRolls.setInt(2, dexterity);
            stmtCharacterRolls.setInt(3, constitution);
	    stmtCharacterRolls.setInt(4, wisdom);
	    stmtCharacterRolls.setInt(5, intelligence);
	    stmtCharacterRolls.setInt(6, charisma);
            int RowsAffected = stmtCharacterRolls.executeUpdate();
	    stmtCharacterRolls.close();
	    conn.close();

            response.sendRedirect("/dnd/index.jsp");

        } catch (SQLException e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
