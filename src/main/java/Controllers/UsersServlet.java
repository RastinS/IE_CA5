package Controllers;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = UserService.getUsers();
        req.setAttribute("users", users);
        req.getRequestDispatcher("users.jsp").forward(req, resp);
    }
}
