package co.za.rateservice.service;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.DAYS;

@Service
public class InterestService {

    public Double calculateInterest(double amount, int agreementType, String startDate,
                                    String endDate, float reporate) {
        int noOfDays = 0;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); //dd-MM-yyyy
            Date sDate = formatter.parse(startDate);
            Date eDate = formatter.parse(endDate);
            long diff = eDate.getTime() - sDate.getTime();
            noOfDays = (int) DAYS.convert(diff, TimeUnit.MILLISECONDS);
            if ( noOfDays <= 0 && amount == 0.0d ) return 0.00d;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Double calculatedInterest = 0.0d;

        switch (agreementType) {
            case 1:
                calculatedInterest = amount * ((reporate * 2.2) + 0.05) / 100 * (noOfDays / 365);
                return calculatedInterest;
            case 2:
                calculatedInterest = amount * ((reporate * 2.2) + 0.1) / 100 * (noOfDays / 365);
                return calculatedInterest;
            case 3:
                calculatedInterest = amount * ((reporate * 2.2) + 0.2) / 100 * (noOfDays / 365);
                return calculatedInterest;
            case 4:
                calculatedInterest = amount * ((reporate * 2.2) + 0.2) / 100 * (noOfDays / 365);
                return calculatedInterest;
            case 5:
                calculatedInterest = amount * ((reporate * 2.2) + 0.2) / 100 * (noOfDays / 365);
                return calculatedInterest;
            case 6:
                calculatedInterest = amount * ((reporate * 2.2) + 0.05) / 100 * (noOfDays / 365) * 12;
                return calculatedInterest;
            case 7:
                calculatedInterest = amount * ((reporate * 2.2) + 0.1) / 100 * (noOfDays / 365);
                return calculatedInterest;
            case 8:
                calculatedInterest = amount * ((reporate * 2.2) + 0.02) / 100 * (noOfDays / 365) * 12;
                return calculatedInterest;
            default:
                return 0.0d;
        }
    }


}
//Return Interest amount = (Amount passed in * Interest percentage from formula / 100)  * (days between start and end date passed in)  / 365