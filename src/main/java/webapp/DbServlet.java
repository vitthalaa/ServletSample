package webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by vitthalawate on 26/8/16.
 */
@WebServlet(name = "DbServlet", urlPatterns = "/db-test")
public class DbServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {






    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM wsAdvancedChat limit 5");
            while(rs.next()) {
                System.out.println(rs.getInt(1) + ". " + rs.getString(2) + " :" + rs.getString(3));
            }

        } catch (ClassNotFoundException e) {
            out.println("Can't load database driver");
        } catch (SQLException e) {
            out.println("Sql exception: " + e.getMessage());
        }
    }
}
