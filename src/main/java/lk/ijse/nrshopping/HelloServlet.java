package lk.ijse.nrshopping;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lk.ijse.nrshopping.DAO.custom.UserDAO;
import lk.ijse.nrshopping.DAO.custom.impl.UserDAOImpl;
import lk.ijse.nrshopping.Entity.User;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserDAO userDAO = new UserDAOImpl();

        try {

            User user = new User();
            user.setUsername("johndoe");
            user.setPassword("password123");
            user.setEmail("johndoe@example.com");
            user.setRole(User.Role.CUSTOMER);
            user.setActive(true);

            userDAO.save(user);

            // Find a user by ID
            User foundUser = userDAO.findById("1");
            if (foundUser != null) {
                response.getWriter().println("Found User: " + foundUser.getUsername());
            } else {
                response.getWriter().println("User not found.");
            }

            // Update the user
            foundUser.setPassword("newpassword123");
            userDAO.update(foundUser);

            response.getWriter().println("Updated User Password: " + foundUser.getPassword());

            // Delete the user
            //userDAO.delete("1");
            //response.getWriter().println("User deleted.");

        } catch (Exception e) {
            e.printStackTrace(response.getWriter());
        }
    }

    public void destroy() {
    }
}