package com.example.AirportTransfer.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Formatter;
import java.util.TimeZone;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.example.AirportTransfer.exception.BadRequestException;





@Component
public class StringToDateConverter {
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	
    
    public Date converter(String  dateInString) {
    	formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
	    try {
	    //	System.out.println(dateInString);
	        Date date = formatter.parse(dateInString);
	    //   System.out.println(date);
	    //    System.out.println(formatter.format(date));
	       return date;
	    } catch (ParseException e) {
	        throw new BadRequestException(400,"enter valid date format (yyyy-mm-dd)", HttpStatus.BAD_REQUEST);
	    }
    
	    
    }
    

}
