package com.example.calculatordevops.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

@RestController
public class CalController {
    private static final Logger logger = LogManager.getLogger("CalController");

    @RequestMapping(value = "/getSqrt", method = RequestMethod.POST)
    public double getSqrt(@RequestBody Map<String,String> body){

        double input1 = Double.parseDouble(body.get("input1"));

        if (input1 < 0 ) {
            logger.info("[SQRT] - INPUT:" + input1 + " , OUTPUT:" + "Invalid Input");

            return -1;
        }

        double res = Math.sqrt(input1) ;

        logger.info("[SQRT] - INPUT:" + input1 + " , OUTPUT:" + res);

        return res  ;
    }

    @RequestMapping(value = "/getFact",method = RequestMethod.POST)
    public double getFact(@RequestBody Map<String,String> body){

        double input1 = Double.parseDouble( body.get("input1"));

        if (input1 < 0 ) {
            logger.info("[FACT] - INPUT:" + input1 + " , OUTPUT:" + "Invalid Input");

            return -1;
        }

        double res= 1;

        for(double i=1;i<=input1;i++)
            res *= i;

        logger.info("[FACT] - INPUT:" + input1 + " , OUTPUT:" + res);

        return res;
    }

    @RequestMapping(value = "/getLog",method = RequestMethod.POST)
    public double getLog(@RequestBody Map<String,String> body){

        double input1 = Double.parseDouble(body.get("input1"));

        if (input1 < 0 ) {
            logger.info("[LOG] - INPUT:" + input1 + " , OUTPUT:" + "Invalid Input");

            return -1;
        }

        double res = Math.log(input1);

        logger.info("[LOG] - INPUT:" + input1 + " , OUTPUT:" + res);

        return res  ;
    }

    @RequestMapping(value = "/getPower",method = RequestMethod.POST)
    public double getPower(@RequestBody Map<String,String> body){

        double input1 = Double.parseDouble(body.get("input1"));

        double input2 = Double.parseDouble( body.get("input2"));

        double res = Math.pow(input1,input2);

        logger.info("[POWER] - INPUT:" + input1+"^"+input2+" , OUTPUT:" + res);

        return res  ;
    }
}
