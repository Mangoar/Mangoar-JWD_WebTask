package com.example.WebAppPayments.controller.command.impl.data;

import com.example.WebAppPayments.controller.command.Command;
import com.example.WebAppPayments.controller.command.CommandUrlPath;
import com.example.WebAppPayments.controller.command.Attribute;
import com.example.WebAppPayments.controller.command.impl.Login;
import com.example.WebAppPayments.entity.Payment;
import com.example.WebAppPayments.exception.DaoException;
import com.example.WebAppPayments.exception.ServiceException;
import com.example.WebAppPayments.service.impl.AccountServiceImpl;
import com.example.WebAppPayments.service.impl.PaymentServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetPayments implements Command {

    private static final org.apache.log4j.Logger logger = Logger.getLogger(Login.class);

    private PaymentServiceImpl paymentService = PaymentServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{

        RequestDispatcher requestDispatcher;

        HttpSession session = request.getSession();

        int curr_user_id = Integer.parseInt(session.getAttribute(Attribute.ID_USER).toString());

        logger.info("ID ACCOUNT - " + curr_user_id);

        List<Payment> paymentsList = new ArrayList<>();
        try {
            paymentsList = paymentService.getPaymentsList(curr_user_id);


            request.setAttribute(Attribute.PAYMENTS, paymentsList);
            requestDispatcher = request.getRequestDispatcher(CommandUrlPath.PAYMENT_PAGE);
            requestDispatcher.forward(request, response);
        } catch (ServiceException e) {
            logger.info("GET PAYMENTS - SERVICE EXCEPTION");
        } catch (ServletException e) {
            logger.info("GET PAYMENTS - SERVLET EXCEPTION");
        }


    }
}