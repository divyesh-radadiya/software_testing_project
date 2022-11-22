package com.example.SoftwareTestingProject.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BankController {
    private static final Logger logger = LogManager.getLogger("BankController");

    @RequestMapping(value = "/getEMI", method = RequestMethod.POST)
    public double getEMI(@RequestBody Map<String,String> body){

        int amount = Integer.parseInt(body.get("amount"));

        int term = Integer.parseInt(body.get("term"));// month

        double interestRate = Double.parseDouble( body.get("interestRate"));

        if (amount < 0 || term < 0 || interestRate < 0) {
            logger.info("[EMI] - INPUT:" +amount+"^"+term+"^"+interestRate+ " , OUTPUT:" + "Invalid Input");

            return -1;
        }

        double convertedRateOfInterest = interestRate / (12 * 100);

        double exponent = Math.pow((1 + convertedRateOfInterest), term);

        double emi = amount * convertedRateOfInterest * exponent / (exponent -1);

        logger.info("[EMI] - INPUT:" +amount+"^"+term+"^"+interestRate+ " , OUTPUT:" + emi);

        return emi  ;
    }

    @RequestMapping(value = "/getInterest", method = RequestMethod.POST)
    public double getInterest(@RequestBody Map<String,String> body){

        int amount = Integer.parseInt(body.get("amount"));

        String acType = body.get("acType");// "NRI" or "Normal"

        if (amount < 0) {
            logger.info("[Interest] - INPUT:" +amount+"^"+acType+ " , OUTPUT:" + "Invalid Input");

            return -1;
        }

        double interest = 0;

        if(acType=="NRI") {
            interest=amount * 0.06;
        }
        else if(acType=="Normal") {
            interest=amount * 0.04;
        }
        else {
            logger.info("[Interest] - INPUT:" +amount+"^"+acType+ " , OUTPUT:" + "Invalid Input");

            return -1;
        }

        logger.info("[Interest] - INPUT:" +amount+"^"+acType+ " , OUTPUT:" + interest);

        return interest  ;
    }

    @RequestMapping(value = "/getCompoundInterest", method = RequestMethod.POST)
    public double getCompoundInterest(@RequestBody Map<String,String> body){

        int amount = Integer.parseInt(body.get("amount"));

        int term = Integer.parseInt(body.get("term"));// month

        double interestRate = Double.parseDouble( body.get("interestRate"));

        String compound = body.get("compound");// "monthly" or "annually"

        if (amount < 0 || term < 0 || interestRate < 0) {
            logger.info("[CompoundInterest] - INPUT:" +amount+"^"+term+"^"+interestRate+ "^"+compound+ " , OUTPUT:" + "Invalid Input");

            return -1;
        }

        double convertedRateOfInterest = interestRate / (12 * 100);

        double interest = 0;

        if(compound=="monthly") {
            interest=amount * (Math.pow((1 + convertedRateOfInterest / 100), term)) - amount;
        }
        else  if(compound=="annually") {
            interest=amount * (Math.pow((1 + interestRate / 100), term/12)) - amount;
        }
        else {
            logger.info("[CompoundInterest] - INPUT:" +amount+"^"+term+"^"+interestRate+ "^"+compound+ " , OUTPUT:" + "Invalid Input");

            return -1;
        }

        logger.info("[CompoundInterest] - INPUT:" +amount+"^"+term+"^"+interestRate+ "^"+compound+ " , OUTPUT:" + interest);

        return interest  ;
    }


    @RequestMapping(value = "/getIncomeTax", method = RequestMethod.POST)
    public double getIncomeTax(@RequestBody Map<String,String> body){

        double income = Double.parseDouble(body.get("income"));

        if (income < 0) {
            logger.info("[IncomeTax] - INPUT:" + income + " , OUTPUT:" + "Invalid Input");

            return -1;
        }

        double incomeTax=0;

        if (income <= 500000) {
            incomeTax = 0;
        }
        else if (income <= 750000) {
            incomeTax = (10.0/100 * (income - 500000)) ;
        }
        else if (income <= 1000000) {
            incomeTax = (15.0/100 * (income - 750000)) + ((750000 - 500000) * 10.0/100) ;
        }
        else if (income <= 1250000) {
            incomeTax = ((income - 1000000) * 20/100) + (15.0/100 * (1000000 - 750000)) + ((750000 - 500000) * 10.0/100) ;
        }
        else if (income <= 1500000) {
        incomeTax = ((income - 1250000) * 25/100) + (20.0/100 * (1250000 - 1000000)) + (15.0/100 * (1000000 - 750000)) + ((750000 - 500000) * 10.0/100) ;
        }
        else {
            incomeTax = ((income - 2000000) * 30/100) + (25.0/100 * (2000000 - 1250000)) +(20.0/100 * (1250000 - 1000000))  + (15.0/100 * (1000000 - 750000)) +  ((750000 - 500000) * 10.0/100) ;
        }

        logger.info("[IncomeTax] - INPUT:" + income + " , OUTPUT:" + incomeTax);

        return incomeTax  ;
    }

    @RequestMapping(value = "/getFDInterest", method = RequestMethod.POST)
    public double getFDInterest(@RequestBody Map<String,String> body){

        int amount = Integer.parseInt(body.get("amount"));

        int term = Integer.parseInt(body.get("term"));// days

        int age = Integer.parseInt(body.get("age"));// years

        if (amount < 0 || term < 0 || age < 0) {
            logger.info("[FDInterest] - INPUT:" +amount+"^"+term+"^"+age+ " , OUTPUT:" + "Invalid Input");

            return -1;
        }

        double interestRate=0.0;

        double interest = 0.0;

        double interestRate1=0.0, interestRate2=0.0;

        if (amount < 10000000) {
            if (term >= 7 && term <= 14) {
                interestRate1 = 0.0450;
                interestRate2 = 0.0500;
            }
            else if (term >= 15 && term <= 29) {
                interestRate1 = 0.0470;
                interestRate2 = 0.0525;
            }
            else if (term >= 30 && term <= 45) {
                interestRate1 = 0.0550;
                interestRate2 = 0.0600;
            }
            else if (term >= 45 && term <= 60) {
                interestRate1 = 0.0700;
                interestRate2 = 0.0750;
            }
            else if (term >= 61 && term <= 184) {
                interestRate1 = 0.0750;
                interestRate2 = 0.0800;
            }
            else if (term >= 185 && term <= 365) {
                interestRate1 = 0.0800;
                interestRate2 = 0.0850;
            }

            if(age < 50) {
                interestRate=interestRate1;
            }
            else{
                interestRate=interestRate2;
            }
        }
        else {
            if (term >= 7 && term <= 14) {
                interestRate = 0.065;
            }
            else if (term >= 15 && term <= 29) {
                interestRate = 0.0675;
            }
            else if (term >= 30 && term <= 45) {
                interestRate = 0.00675;
            }
            else if (term >= 45 && term <= 60) {
                interestRate = 0.080;
            }
            else if (term >= 61 && term <= 184) {
                interestRate = 0.0850;
            }
            else if (term >= 185 && term <= 365) {
                interestRate = 0.10;
            }
        }

        interest= interestRate * amount ;

        logger.info("[FDInterest] - INPUT:" +amount+"^"+term+"^"+age+ " , OUTPUT:" + interest);

        return interest  ;
    }

    @RequestMapping(value = "/getRDInterest", method = RequestMethod.POST)
    public double getRDInterest(@RequestBody Map<String,String> body){

        int amount = Integer.parseInt(body.get("amount"));

        int term = Integer.parseInt(body.get("term"));// months

        int age = Integer.parseInt(body.get("age"));// years

        if (amount < 0 || term < 0 || age < 0) {
            logger.info("[FDInterest] - INPUT:" +amount+"^"+term+"^"+age+ " , OUTPUT:" + "Invalid Input");

            return -1;
        }

        double interestRate=0.0;

        double interest = 0.0;

        double interestRate1=0.0, interestRate2=0.0;


        if (term >= 0 && term <= 6) {
            interestRate1 = .0750;
            interestRate2 = 0.080;
        }
        else if (term >= 7 && term <= 9) {
            interestRate1 = .0775;
            interestRate2 = 0.0825;
        }
        else if (term >= 10 && term <= 12) {
            interestRate1 = .0800;
            interestRate2 = 0.0850;
        }
        else if (term >= 13 && term <= 15) {
            interestRate1 = .0825;
            interestRate2 = 0.0875;
        }
        else if (term >= 16 && term <= 18) {
            interestRate1 = .0850;
            interestRate2 = 0.0900;
        }
        else if (term >= 22) {
            interestRate1 = .0875;
            interestRate2 = 0.0925;
        }

        if(age < 50) {
            interestRate=interestRate1;
        }
        else{
            interestRate=interestRate2;
        }

        interest= interestRate * amount ;

        logger.info("[EMI] - INPUT:" +amount+"^"+term+"^"+age+ " , OUTPUT:" + interest);

        return interest  ;
    }
}
