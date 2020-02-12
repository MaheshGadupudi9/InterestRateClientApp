package co.za.rateservice.resource;

import co.za.rateservice.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/calculate")
public class InterestCalculatorResource {

    @Autowired
    InterestService interestRateService;

    @GetMapping(value = "/ping", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Hello> ping() {
        System.out.println("ping..");
        return new ResponseEntity<Hello>(new Hello("Hello Angular"), HttpStatus.OK);
    }

    @GetMapping(value = "/calcInterest", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> calculateInterest(@RequestParam(value = "agreementType", defaultValue = "1") String agreementType,
                                    @RequestParam(value = "startDate", defaultValue = "2020-01-01") String startDate,
                                    @RequestParam(value = "endDate", defaultValue = "2020-01-01") String endDate,
                                    @RequestParam(value = "amount", defaultValue = "10000") String amount) {


        String op= String.format("%.2f", interestRateService.calculateInterest(Double.valueOf(amount), Integer.valueOf(agreementType), startDate, endDate, 9.5f));
    return new ResponseEntity<String>(op,HttpStatus.OK);
    }

    static class Hello {
        private String value;

        public Hello() {
        }

        public Hello(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
