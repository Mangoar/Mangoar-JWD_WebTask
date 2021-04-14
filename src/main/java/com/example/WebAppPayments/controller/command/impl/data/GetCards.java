package com.example.WebAppPayments.controller.command.impl.data;

import com.example.WebAppPayments.controller.command.Command;
import com.example.WebAppPayments.controller.command.CommandUrlPath;
import com.example.WebAppPayments.controller.command.Attribute;
import com.example.WebAppPayments.controller.command.impl.Login;
import com.example.WebAppPayments.entity.Card;
import com.example.WebAppPayments.exception.DaoException;
import com.example.WebAppPayments.exception.ServiceException;
import com.example.WebAppPayments.service.impl.CardServiceImpl;
import com.example.WebAppPayments.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetCards implements Command {

    private static final org.apache.log4j.Logger logger = Logger.getLogger(Login.class);

    private CardServiceImpl cardsService = CardServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        RequestDispatcher requestDispatcher;

        int id_account;
        double balance;

        HttpSession session = request.getSession();

        try {
            id_account = Integer.parseInt(request.getParameter("idaccount"));
        } catch (NumberFormatException e) {
            id_account = Integer.parseInt(session.getAttribute(Attribute.ID_ACCOUNT).toString());
        }

        try {
            balance = Double.parseDouble(session.getAttribute(Attribute.BALANCE).toString());
        }
        catch (NullPointerException e) {
            balance = Double.parseDouble(request.getParameter("balance"));
        }


        logger.info("ID ACCOUNT - " + id_account);

        List<Card> cardsList = new ArrayList<>();
        try {
            cardsList = cardsService.getCardsList(id_account);



            session.setAttribute(Attribute.ID_ACCOUNT, id_account);

            session.setAttribute(Attribute.BALANCE, balance);
            request.setAttribute(Attribute.CARDS, cardsList);
            requestDispatcher = request.getRequestDispatcher(CommandUrlPath.CARDS_PAGE);
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            logger.info("GET CARDS - SERVLET EXCEPTION");
        } catch (ServiceException e) {
            logger.info("GET CARDS - SERVICE EXCEPTION");
        }


    }
}