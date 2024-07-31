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

public class createLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "jdbc:mysql://192.168.7.44:3306/dnd"; // Replace mydatabase with your database name
        String dbuser = "dnd"; // Replace your-username with your MySQL username
        String dbpass = "password"; // Replace your-password with your MySQL password

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String userName = request.getParameter("userName");
	String password = request.getParameter("password");

        try (Connection conn = DriverManager.getConnection(url, dbuser, dbpass)) {
            String sqlCreateLogin = "INSERT INTO user (name, email, username, password) VALUES (?, ?, ?, ?)";
            PreparedStatement stmtCreateLogin = conn.prepareStatement(sqlCreateLogin);
            stmtCreateLogin.setString(1, name);
            stmtCreateLogin.setString(2, email);
            stmtCreateLogin.setString(3, userName);
	    stmtCreateLogin.setString(4, password);
            int RowsAffected = stmtCreateLogin.executeUpdate();
	    stmtCreateLogin.close();
	    conn.close();

            response.sendRedirect("/dnd/index.jsp");

        } catch (SQLException e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
