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

    public static String scan(String input){
        String result = null;
        String cleanInput = input.replaceAll("[^-0-9]", "");
        if(!cleanInput.isEmpty()){
            result  = cleanInput;
        }
        return result;
    }

    // Converting kelvin into celsius
    @GetMapping("/conversions/ktoc/{id}")
    public String celsius(
            @PathVariable("id") String id){

        String cleanInput = scan(id);

        if(cleanInput == null){
            String errorMsg =  "{\n" +
                    "   \"status\":400,\n" +
                    "   \"description\":\"Invalid data supplied\"\n" +
                    "}";
            logger.info("Convert Failed!\n" + errorMsg);
            return errorMsg;
        }

        double convert = Integer.parseInt(cleanInput) - 273.15;
        DecimalFormat df = new DecimalFormat("####0.00");

        String result = "{\n";
        result += " \"kelvin\" : " + cleanInput + ",\n";
        result += " \"celsius\" : " + df.format(convert) + "\n";
        result += "}";

        logger.info("Convert Successfully!\n" + result);

        return result;
    }

    // Converting celsius into kelvin
    @GetMapping("/conversions/ctok/{id}")
    public String kelvin(
            @PathVariable("id") String id){

        String cleanInput = scan(id);

        if(cleanInput == null){
            String errorMsg =  "{\n" +
                    "   \"status\":400,\n" +
                    "   \"description\":\"Invalid data supplied\"\n" +
                    "}";
            logger.info("Convert Failed!\n" + errorMsg);
            return errorMsg;
        }

        double convert = Integer.parseInt(cleanInput) + 273.15;
        DecimalFormat df = new DecimalFormat("####0.00");

        String result = "{\n";
        result += " \"celsius\" : " + cleanInput + ",\n";
        result += " \"kelvin\" : " + df.format(convert) + "\n";
        result += "}";

        logger.info("Convert Successfully!\n" + result);

        return result;
    }


    //Converting miles to kilometers.
    @GetMapping("/conversions/mtok/{id}")
    public String kilometers(
            @PathVariable("id") String id){

        String cleanInput = scan(id);

        if(cleanInput == null){
            String errorMsg =  "{\n" +
                    "   \"status\":400,\n" +
                    "   \"description\":\"Invalid data supplied\"\n" +
                    "}";
            logger.info("Convert Failed!\n" + errorMsg);
            return errorMsg;
        }

        double convert = Integer.parseInt(cleanInput) * 1.60934;
        DecimalFormat df = new DecimalFormat("####0.00");

        String result = "{\n";
        result += " \"miles\" : " + cleanInput + ",\n";
        result += " \"kilometers\" : " + df.format(convert) + "\n";
        result += "}";

        logger.info("Convert Successfully!\n" + result);

        return result;
    }

    //Converting kilometers to miles.
    @GetMapping("/conversions/ktom/{id}")
    public String miles(
            @PathVariable("id") String id){

        String cleanInput = scan(id);

        if(cleanInput == null){
            String errorMsg =  "{\n" +
                    "   \"status\":400,\n" +
                    "   \"description\":\"Invalid data supplied\"\n" +
                    "}";
            logger.info("Convert Failed!\n" + errorMsg);
            return errorMsg;
        }

        double convert = Integer.parseInt(cleanInput) / 1.60934;
        DecimalFormat df = new DecimalFormat("####0.00");

        String result = "{\n";
        result += " \"kilometers\" : " + cleanInput + ",\n";
        result += " \"miles\" : " + df.format(convert) + "\n";
        result += "}";

        logger.info("Convert Successfully!\n" + result);

        return result;
    }

}
