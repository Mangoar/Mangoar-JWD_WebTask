package com.example.WebAppPayments.controller.command.impl;

import com.example.WebAppPayments.controller.command.Command;
import com.example.WebAppPayments.controller.command.CommandUrlPath;
import com.example.WebAppPayments.controller.command.Message;
import com.example.WebAppPayments.controller.command.Attribute;
import com.example.WebAppPayments.controller.command.impl.navigation.GoToLoginPage;
import com.example.WebAppPayments.entity.User;
import com.example.WebAppPayments.exception.ServiceException;
import com.example.WebAppPayments.service.UserService;
import com.example.WebAppPayments.service.impl.UserServiceImpl;
import com.example.WebAppPayments.validator.UserValidator;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterNewUser implements Command {

    private static final org.apache.log4j.Logger logger = Logger.getLogger(RegisterNewUser.class);

    private UserServiceImpl userService = UserServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login;
        String password;
        String fullname;
        String birthdate;
        String passport;
        String email;
        login = request.getParameter("UserLogin");
        password = request.getParameter("UserPassword");
        fullname = request.getParameter("UserFullname");
        birthdate = request.getParameter("UserBirthdate");
        passport = request.getParameter("UserPassport");
        email = request.getParameter("UserEmail");
        boolean hasErrors = false;
        try {
            if (!UserValidator.isPasswordValid(password)) {
                request.setAttribute(Attribute.MESSAGE_PASSWORD, Message.INCORRECT_PASSWORD);
                hasErrors = true;
            }
            if (!UserValidator.isLoginValid(login)) {
                request.setAttribute(Attribute.MESSAGE_LOGIN, Message.INCORRECT_LOGIN);
                hasErrors = true;
            }
            if (!UserValidator.isEmailValid(email)) {
                request.setAttribute(Attribute.MESSAGE_EMAIL, Message.INCORRECT_EMAIL);
                hasErrors = true;
            }
            if (!UserValidator.isFullnameValid(fullname)) {
                request.setAttribute(Attribute.MESSAGE_FULLNAME, Message.INCORRECT_FULLNAME);
                hasErrors = true;
            }
            if (!UserValidator.isBirthDateValid(birthdate)) {
                request.setAttribute(Attribute.MESSAGE_BIRTHDATE, Message.INCORRECT_BIRTHDATE);
                hasErrors = true;
            }
            if (hasErrors) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/registrationPage.jsp");
                requestDispatcher.forward(request, response);
            } else {
                User user = new User();
                user.setLogin(login);
                user.setPassword(password);
                user.setFullname(fullname);
                user.setBirthdate(birthdate);
                user.setPassport(passport);
                user.setEmail(email);


                userService.registration(user);

                request.setAttribute(Attribute.MESSAGE, Message.REGISTER_SUCCESS);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/loginPage.jsp");
                requestDispatcher.forward(request, response);
            }
        } catch (
                ServiceException e) {
            logger.info("REGISTER NEW USER - SERVICE EXCEPTION");
        } catch (ServletException e) {
            logger.info("REGISTER NEW USER - SERVLET EXCEPTION");
        }
    }
}
