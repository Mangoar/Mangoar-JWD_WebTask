package com.example.WebAppPayments.controller;

import com.example.WebAppPayments.controller.command.Attribute;
import com.example.WebAppPayments.dao.PaymentDAO;
import com.example.WebAppPayments.dao.impl.PaymentDAOImpl;
import com.example.WebAppPayments.entity.Payment;
import com.example.WebAppPayments.exception.DaoException;
import com.example.WebAppPayments.service.impl.AccountServiceImpl;
import com.example.WebAppPayments.utility.ReportCreator;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(DownloadServlet.class);

    private PaymentDAOImpl paymentDAO = PaymentDAOImpl.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String report_type = request.getParameter("report");
        HttpSession session = request.getSession();
        int user_id = Integer.parseInt(session.getAttribute(Attribute.ID_USER).toString());

        switch (report_type){
            case "year":{
                List<Payment> paymentList = new ArrayList<>();
                try {
                    paymentList = paymentDAO.getYearPaymentList(user_id);
                } catch (DaoException e) {
                    logger.info("DOWNLOAD_SERVLET - YEAR - DAO EXCEPTION",e);
                }
                ReportCreator.createDocument(paymentList,user_id,1);

                break;
            }
            case "month":{
                List<Payment> paymentList = new ArrayList<>();
                try {
                    paymentList = paymentDAO.getMonthPaymentList(user_id);
                } catch (DaoException e) {
                    logger.info("DOWNLOAD_SERVLET - MONTH - DAO EXCEPTION",e);
                }
                ReportCreator.createDocument(paymentList,user_id,2);
                break;
            }
            case "week":{
                List<Payment> paymentList = new ArrayList<>();
                try {
                    paymentList = paymentDAO.getWeekPaymentList(user_id);
                } catch (DaoException e) {
                    logger.info("DOWNLOAD_SERVLET - WEEK - DAO EXCEPTION",e);
                }
                ReportCreator.createDocument(paymentList,user_id,3);
                break;
            }
            case "now":{
                List<Payment> paymentList = new ArrayList<>();
                try {
                    paymentList = paymentDAO.getLastPaymentList(user_id);
                } catch (DaoException e) {
                    logger.info("DOWNLOAD_SERVLET - NOW - DAO EXCEPTION",e);
                }
                ReportCreator.createDocument(paymentList,user_id,4);
                break;
            }
        }
        response.reset();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String filename = "Doc_for_user_"+user_id+".pdf";
        String filepath = "E:\\Temp_payments\\";
        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");

        FileInputStream fileInputStream = new FileInputStream(filepath + filename);

        int i;
        while ((i=fileInputStream.read()) != -1) {
            out.write(i);
        }
        fileInputStream.close();
        out.close();

        File myFile = new File("E:/Temp_payments/Doc_for_user_"+user_id+".pdf");
        if (myFile.delete()) {
            logger.info("Deleted the file: " + myFile.getName());
        } else {
            logger.info("Failed to delete the file.");
        }
    }

}