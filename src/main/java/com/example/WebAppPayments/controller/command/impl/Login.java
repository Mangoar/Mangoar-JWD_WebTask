package com.example.WebAppPayments.controller.command.impl;

import com.example.WebAppPayments.controller.command.Command;
import com.example.WebAppPayments.controller.command.CommandUrlPath;
import com.example.WebAppPayments.controller.command.Attribute;
import com.example.WebAppPayments.controller.command.Message;
import com.example.WebAppPayments.entity.User;
import com.example.WebAppPayments.exception.DaoException;
import com.example.WebAppPayments.exception.ServiceException;
import com.example.WebAppPayments.service.impl.UserServiceImpl;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login implements Command {

    private static final org.apache.log4j.Logger logger = Logger.getLogger(Login.class);

    private UserServiceImpl userService = UserServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login;
        String password;

        login = request.getParameter("UserLogin");
        password = request.getParameter("UserPassword");

        try {
            User user = userService.authorization(login, password);


            if (user == null) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/loginPage.jsp");
                request.setAttribute(Attribute.MESSAGE_FAIL_LOG_IN, Message.FAIL_LOG_IN);
                requestDispatcher.forward(request, response);
            }
            else {
                HttpSession session = request.getSession();
                session.setAttribute(Attribute.ID_USER, user.getId());
                session.setAttribute(Attribute.LOGIN, user.getLogin());
                session.setAttribute(Attribute.ID_USER_ROLE, user.getId_role());
                response.sendRedirect(CommandUrlPath.MAIN_PAGE_COMMAND);
            }

        } catch (ServletException e) {
            logger.info("LOGIN - SERVLET EXCEPTION");
        } catch (ServiceException e) {
            logger.info("LOGIN - SERVICE EXCEPTION");
        }
    }
}
