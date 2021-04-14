package com.example.WebAppPayments.controller.command.impl.data;

import com.example.WebAppPayments.controller.command.Command;
import com.example.WebAppPayments.controller.command.CommandUrlPath;
import com.example.WebAppPayments.controller.command.impl.navigation.GoToLoginPage;
import com.example.WebAppPayments.exception.ServiceException;
import com.example.WebAppPayments.service.CardService;
import com.example.WebAppPayments.service.UserService;
import com.example.WebAppPayments.service.impl.CardServiceImpl;
import com.example.WebAppPayments.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExtendCardValidDate implements Command {

    private static final Logger logger = Logger.getLogger(GoToLoginPage.class);

    private CardServiceImpl cardsService = CardServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String newDate = request.getParameter("new_valid_date");
        String idCardString = request.getParameter("idcard");
        int idCard = Integer.parseInt(idCardString);
        try {
            cardsService.extendCardValidDate(newDate, idCard);
        }
        catch (ServiceException e) {
            logger.info("EXTEND CARD VALID DATE - SERVICE EXCEPTION");
        }

        response.sendRedirect(CommandUrlPath.GET_CARDS_COMMAND);

    }
}
