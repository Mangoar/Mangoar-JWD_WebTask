package com.example.WebAppPayments.controller.command.impl.data;

import com.example.WebAppPayments.controller.command.Command;
import com.example.WebAppPayments.controller.command.CommandUrlPath;
import com.example.WebAppPayments.controller.command.Attribute;
import com.example.WebAppPayments.controller.command.impl.Login;
import com.example.WebAppPayments.entity.User;
import com.example.WebAppPayments.exception.DaoException;
import com.example.WebAppPayments.exception.ServiceException;
import com.example.WebAppPayments.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GetProfileInfo implements Command {

    private static final org.apache.log4j.Logger logger = Logger.getLogger(Login.class);

    private UserServiceImpl userService = UserServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();

        String curr_user_id = session.getAttribute(Attribute.ID_USER).toString();

        User user = new User();
        try {
            user = userService.getUserById(curr_user_id);
        } catch (ServiceException e) {
            logger.info("GET PROFILE INFO - SERVICE EXCEPTION");
        }


        session.setAttribute(Attribute.USER, user);

        response.sendRedirect(CommandUrlPath.PROFILE_PAGE_COMMAND);

    }
}
