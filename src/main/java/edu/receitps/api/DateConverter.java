package edu.receitps.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

    public static Date convertStringToDate(String dateString) throws ParseException {
        return new SimpleDateFormat("MM/dd/yyyy").parse(dateString);
    }
}
