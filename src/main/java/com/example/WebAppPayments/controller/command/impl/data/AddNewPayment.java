package com.example.WebAppPayments.controller.command.impl.data;

import com.example.WebAppPayments.controller.command.Attribute;
import com.example.WebAppPayments.controller.command.Command;
import com.example.WebAppPayments.controller.command.CommandUrlPath;
import com.example.WebAppPayments.controller.command.Message;
import com.example.WebAppPayments.controller.command.impl.navigation.GoToLoginPage;
import com.example.WebAppPayments.dao.Transaction;
import com.example.WebAppPayments.entity.Payment;
import com.example.WebAppPayments.exception.ServiceException;
import com.example.WebAppPayments.exception.TransactionException;
import com.example.WebAppPayments.service.AccountService;
import com.example.WebAppPayments.service.impl.AccountServiceImpl;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddNewPayment implements Command {

    private static final Logger logger = Logger.getLogger(GoToLoginPage.class);
    Transaction transaction = Transaction.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id_account;
        double current_value;
        double payment_value;
        String destination;
        int id_card;
        int payment_type;
        try {


            id_account = Integer.parseInt(request.getParameter("id_account"));
            current_value = Double.parseDouble(request.getParameter("CurrentBalance"));
            payment_value = Double.parseDouble(request.getParameter("PaymentValue"));
            destination = request.getParameter("Destination");
            id_card = Integer.parseInt(request.getParameter("id_card"));
            payment_type = Integer.parseInt(request.getParameter("id_payment_type"));
            double newValue = 0;
            if (payment_type == 2) {
                if (current_value < payment_value) {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/newPaymentPage.jsp");
                    request.setAttribute(Attribute.NO_FUNDS, Message.NO_FUNDS);
                    requestDispatcher.forward(request, response);
                } else {
                    newValue = current_value - payment_value;
                }
            } else {
                newValue = current_value + payment_value;
            }

            Payment payment = new Payment();
            payment.setId_type(payment_type);
            payment.setDestination(destination);
            payment.setId_card(id_card);
            payment.setSum(payment_value);

            try {
                transaction.newPayment(id_account, newValue, payment);

                response.sendRedirect(CommandUrlPath.COMPLETED_PAYMENT_PAGE_COMMAND);

            } catch (TransactionException ex) {
                logger.info("TRANSACTION EXCEPTION",ex);
            }
        } catch (ServletException e) {
            logger.info("ADD NEW PAYMENT SERVLET EXCEPTION",e);
        }

    }
}
