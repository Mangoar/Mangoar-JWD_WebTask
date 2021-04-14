package com.example.WebAppPayments.tag;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        getJspContext().getOut().print("Today is "+formatter.format(date));
    }
}
