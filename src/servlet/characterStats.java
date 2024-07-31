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

public class characterStats extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "jdbc:mysql://192.168.7.44:3306/dnd"; // Replace mydatabase with your database name
        String dbuser = "dnd"; // Replace your-username with your MySQL username
        String dbpass = "password"; // Replace your-password with your MySQL password

	int level = Integer.parseInt(request.getParameter("level"));
	int proficiencyBonus = Integer.parseInt(request.getParameter("proficiencyBonus"));
	int walkingSpeed = Integer.parseInt(request.getParameter("walkingSpeed"));
	int initiative = Integer.parseInt(request.getParameter("initiative"));
	int armorClass = Integer.parseInt(request.getParameter("armorClass"));

        try (Connection conn = DriverManager.getConnection(url, dbuser, dbpass)) {
            String sqlCharacterStats = "INSERT INTO characterInfo (level, proficiencyBonus, walkingSpeed, initiative, armorClass) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmtCharacterStats = conn.prepareStatement(sqlCharacterStats);
            stmtCharacterStats.setInt(1, level);
            stmtCharacterStats.setInt(2, proficiencyBonus);
            stmtCharacterStats.setInt(3, walkingSpeed);
	    stmtCharacterStats.setInt(4, initiative);
	    stmtCharacterStats.setInt(5, armorClass);
            int RowsAffected = stmtCharacterStats.executeUpdate();
	    stmtCharacterStats.close();
	    conn.close();

            response.sendRedirect("/dnd/index.jsp");

        } catch (SQLException e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
