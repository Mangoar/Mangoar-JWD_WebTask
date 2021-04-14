package com.example.WebAppPayments.controller.command.impl.data;

import com.example.WebAppPayments.controller.command.Command;
import com.example.WebAppPayments.controller.command.CommandUrlPath;
import com.example.WebAppPayments.controller.command.Attribute;
import com.example.WebAppPayments.controller.command.impl.Login;
import com.example.WebAppPayments.entity.Account;
import com.example.WebAppPayments.exception.DaoException;
import com.example.WebAppPayments.exception.ServiceException;
import com.example.WebAppPayments.service.impl.AccountServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetAccounts implements Command {

    private static final org.apache.log4j.Logger logger = Logger.getLogger(Login.class);

    private AccountServiceImpl accountService = AccountServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        RequestDispatcher requestDispatcher;

        HttpSession session = request.getSession();

        int curr_user_id = Integer.parseInt(session.getAttribute(Attribute.ID_USER).toString());

        logger.info("ID User " + curr_user_id);

        List<Account> accountList = new ArrayList<>();

        try {
            accountList = accountService.getAccountList(curr_user_id);

            request.setAttribute(Attribute.ACCOUNTS, accountList);

            requestDispatcher = request.getRequestDispatcher(CommandUrlPath.ACCOUNT_PAGE);
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            logger.info("GET ACCOUNTS - SERVLET EXCEPTION");
        } catch (ServiceException e) {
            logger.info("GET ACCOUNTS - SERVICE EXCEPTION");
        }

    }
}