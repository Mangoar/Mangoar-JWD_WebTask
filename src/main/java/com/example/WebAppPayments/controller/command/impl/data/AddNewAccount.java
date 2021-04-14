package com.example.WebAppPayments.controller.command.impl.data;

import com.example.WebAppPayments.controller.command.Command;
import com.example.WebAppPayments.controller.command.CommandUrlPath;
import com.example.WebAppPayments.controller.command.Attribute;
import com.example.WebAppPayments.controller.command.impl.navigation.GoToLoginPage;
import com.example.WebAppPayments.entity.Account;
import com.example.WebAppPayments.entity.Card;
import com.example.WebAppPayments.exception.ServiceException;
import com.example.WebAppPayments.service.AccountService;
import com.example.WebAppPayments.service.impl.AccountServiceImpl;
import com.example.WebAppPayments.service.impl.CardServiceImpl;
import com.example.WebAppPayments.utility.AccountCreator;
import com.example.WebAppPayments.utility.CardCreator;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddNewAccount implements Command {

    private static final Logger logger = Logger.getLogger(GoToLoginPage.class);

    private AccountServiceImpl accountService = AccountServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id_user;
        int id_currency;

        HttpSession session = request.getSession();
        id_user = Integer.parseInt(session.getAttribute(Attribute.ID_USER).toString());

        id_currency = Integer.parseInt(request.getParameter("IdCurrency"));

        Account newAccount = AccountCreator.createAccount(id_user,id_currency);

        try {
            accountService.addNewAccount(newAccount);
        } catch (ServiceException e) {
            logger.info("ADD NEW ACCOUNT - SERVICE EXCEPTION",e);
        }

        response.sendRedirect(CommandUrlPath.GET_ACCOUNTS_COMMAND);
    }
}
