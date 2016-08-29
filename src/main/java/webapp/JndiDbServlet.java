package webapp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by vitthalawate on 26/8/16.
 */
@WebServlet(name = "JndiDbServlet", urlPatterns = "/db-jndi")
public class JndiDbServlet extends HttpServlet {

    private DataSource dataSource;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        try {
            InitialContext initContext = new InitialContext();
            Context env = (Context) initContext.lookup("java:comp/env");
            dataSource = (DataSource) env.lookup("jdbc/test");
            System.out.println("Initialized context");

        } catch (NamingException e) {
            throw new ServletException();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Statement statement;
        ResultSet resultSet;
        try {
            Connection connection = dataSource.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM wsAdvancedChat limit 5");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + ". " + resultSet.getString(2) + " :" + resultSet.getString(3));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
