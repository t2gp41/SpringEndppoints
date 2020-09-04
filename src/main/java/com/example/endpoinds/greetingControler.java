package com.example.endpoinds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;

@RestController
public class greetingControler {

    Logger logger = LoggerFactory.getLogger(greetingControler.class);

    @GetMapping("/conversions/ktoc/{id}")
    public String getFoosBySimplePathWithPathVariable(
            @PathVariable("id") String id){

        String cleanInput = id.replaceAll("[^0-9]", "");
        if(cleanInput.isEmpty()){
            return "{" +
                    "   \"status\":400," +
                    "   \"description\":\"Invalid data supplied\"" +
                    "}";
        }

        String result = "{\n";
        result += " \"Kelvin\" : " + cleanInput + ",";

        double Celsius = Integer.parseInt(cleanInput) - 273.15;

        DecimalFormat df = new DecimalFormat("####0.00");

        result += " \"Celsius\" : " + df.format(Celsius);
        result += "}\n";
        logger.info("An INFO Message");
        return result;
    }



    @GetMapping("/conversions/ctok/{id}")
    public String e(
            @PathVariable("id") String id){

        String cleanInput = id.replaceAll("[^0-9]", "");
        if(cleanInput.isEmpty()){
            return "{" +
                    "   \"status\":400," +
                    "   \"description\":\"Invalid data supplied\"" +
                    "}";
        }

        String result = "{\n";
        result += " \"Kelvin\" : " + cleanInput + ",";

        double Celsius = Integer.parseInt(cleanInput) - 273.15;

        DecimalFormat df = new DecimalFormat("####0.00");

        result += " \"Celsius\" : " + df.format(Celsius);
        result += "}\n";
        logger.info("An INFO Message");
        return result;
    }


}
