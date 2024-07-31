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

public class characterInfo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "jdbc:mysql://192.168.7.44:3306/dnd"; // Replace mydatabase with your database name
        String dbuser = "dnd"; // Replace your-username with your MySQL username
        String dbpass = "password"; // Replace your-password with your MySQL password

        String name = request.getParameter("name");
        String race = request.getParameter("race");
	String characterClass = request.getParameter("characterClass");
        String height = request.getParameter("height");
	String weight = request.getParameter("weight");
	String hair = request.getParameter("hair");
	String eyes = request.getParameter("eyes");

        try (Connection conn = DriverManager.getConnection(url, dbuser, dbpass)) {
            String sqlCharacterInfo = "INSERT INTO characterInfo (name, race, characterClass, height, weight, hair, eyes) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmtCharacterInfo = conn.prepareStatement(sqlCharacterInfo);
            stmtCharacterInfo.setString(1, name);
            stmtCharacterInfo.setString(2, race);
            stmtCharacterInfo.setString(3, characterClass);
	    stmtCharacterInfo.setString(4, height);
	    stmtCharacterInfo.setString(5, weight);
	    stmtCharacterInfo.setString(6, hair);
	    stmtCharacterInfo.setString(7, eyes);
            int RowsAffected = stmtCharacterInfo.executeUpdate();
	    stmtCharacterInfo.close();
	    conn.close();

            response.sendRedirect("/dnd/index.jsp");

        } catch (SQLException e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
