package Controllers;

import Database.Database;
import Models.User;
import Services.UserService;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/users")
public class UsersServlet extends HttpServlet{

    @Override
    public void init() throws ServletException {
        super.init();
        if(!Database.didInit()) {
            try {
                Database.init();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = UserService.getUsers();
        req.setAttribute("users", users);
        req.getRequestDispatcher("users.jsp").forward(req, resp);
    }
}
