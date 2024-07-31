import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger logger = Logger.getLogger(loginServlet.class.getName());
        String url = "jdbc:mysql://192.168.7.44:3306/dnd"; // Replace mydatabase with your database name
        String dbuser = "dnd"; // Replace your-username with your MySQL username
        String dbpass = "password"; // Replace your-password with your MySQL password
        
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String sqlLoginInfo = "SELECT * FROM user WHERE userName = ? and password = ?";
        logger.info("Received request for login: " + userName + " and password " + password);
        
        try (Connection conn = DriverManager.getConnection(url, dbuser, dbpass)) {
            logger.finest("Executing SQL query: " + sqlLoginInfo);
            PreparedStatement selLoginInfo = conn.prepareStatement(sqlLoginInfo);
            selLoginInfo.setString(1, userName);
            selLoginInfo.setString(2, password);
            ResultSet rsLoginInfo = selLoginInfo.executeQuery();
            if (!rsLoginInfo.next()) { // Check if ResultSet is empty
                throw new SQLException("Invalid username or password.");
            }
            logger.info("SQL query executed successfully " + selLoginInfo);
	    rsLoginInfo.close();
	    selLoginInfo.close();
	    conn.close();
            
            response.sendRedirect("/dnd/welcome.html");
        } catch (SQLException e) {
            logger.severe("Error executing SQL query: " + sqlLoginInfo + ". Error message: " + e.getMessage());
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}

