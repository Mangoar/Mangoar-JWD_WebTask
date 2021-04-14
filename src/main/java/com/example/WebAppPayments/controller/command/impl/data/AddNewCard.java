package com.example.WebAppPayments.controller.command.impl.data;

import com.example.WebAppPayments.controller.command.Command;
import com.example.WebAppPayments.controller.command.CommandUrlPath;
import com.example.WebAppPayments.controller.command.Attribute;
import com.example.WebAppPayments.controller.command.impl.navigation.GoToLoginPage;
import com.example.WebAppPayments.entity.Card;
import com.example.WebAppPayments.exception.ServiceException;
import com.example.WebAppPayments.service.CardService;
import com.example.WebAppPayments.service.impl.CardServiceImpl;
import com.example.WebAppPayments.utility.CardCreator;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddNewCard implements Command {

    private static final Logger logger = Logger.getLogger(GoToLoginPage.class);

    private CardServiceImpl cardsService = CardServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();
        int id_account = Integer.parseInt(session.getAttribute(Attribute.ID_ACCOUNT).toString());

        logger.info("ADD NEW CARD ID ACCOUNT - " +id_account);

        Card newCard = CardCreator.createCard(id_account);

        try {
            cardsService.addNewCard(newCard);
        } catch (ServiceException e) {
            logger.info("ADD NEW CARD - SERVICE EXCEPTION",e);
        }

        response.sendRedirect(CommandUrlPath.GET_CARDS_COMMAND);

    }
}
