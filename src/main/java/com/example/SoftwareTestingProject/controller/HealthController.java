package com.example.SoftwareTestingProject.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthController {

    private static final Logger logger = LogManager.getLogger("HealthController");

    @RequestMapping(value = "/getBMI", method = RequestMethod.POST)
    public String getBMI(@RequestBody Map<String,String> body){

        double height = Double.parseDouble( body.get("height")); //cms

        double weight = Double.parseDouble( body.get("weight")); //kgs

        if (height < 0 || weight < 0) {
            logger.info("[BMI] - INPUT:" +height+"^"+weight+ " , OUTPUT:" + "Invalid Input");

            return "Invalid Input";
        }

        height = height / 100;

        double bmi = weight / (height * height);

        String bmiIndex;

        if (bmi < 16) {
            bmiIndex="Severe Thinness";
        }
        else if (bmi < 16.99999999 && bmi >= 16) {
            bmiIndex="Moderate Thinness";
        }
        else if (bmi < 18.4 && bmi >= 17) {
            bmiIndex="Mild Thinness";
        }
        else if (bmi < 25 && bmi >= 18.4) {
            bmiIndex="Normal";
        }
        else if (bmi < 29.4 && bmi >= 25) {
            bmiIndex="Overweight Thinness";
        }
        else{
            bmiIndex="Obesity";
        }

        logger.info("[BMI] - INPUT:" +height+"^"+weight+ " , OUTPUT:" + bmi+"^"+bmiIndex);

        return bmiIndex  ;
    }

    @RequestMapping(value = "/getBFP", method = RequestMethod.POST)
    public double getBFP(@RequestBody Map<String,String> body){

        double height = Double.parseDouble( body.get("height")); //cms

        double weight = Double.parseDouble( body.get("weight")); //kgs

        int age = Integer.parseInt(body.get("age"));// years

        String gender = body.get("gender"); // male , female

        if (height < 0 || weight < 0 || age<0 ) {
            logger.info("[BFP] - INPUT:" +height+"^"+weight+ "^"+age+"^"+gender+ ", OUTPUT:" + "Invalid Input");

            return -1;
        }

        height = height / 100;

        double bmi = weight / (height * height);

        double bfp=0.0;

        if(gender=="male")
        {
            if(age<=14)
            {
                bfp = (1.2*bmi) + (0.23*age)- 16.2;
            }
            else
            {
                bfp = (1.51*bmi) + (0.70*age)- 2.2;
            }
        }
        else if(gender=="female")
        {
            if(age<=14)
            {
                bfp = (1.2*bmi) + (0.23*age)- 5.4;
            }
            else
            {
                bfp = (1.51*bmi) + (0.70*age)- 1.4;
            }
        }
        else
        {
            logger.info("[BFP] - INPUT:" +height+"^"+weight+ "^"+age+"^"+gender+ ", OUTPUT:" + "Invalid Input");

            return -1;
        }

        logger.info("[BFP] - INPUT:" +height+"^"+weight+ "^"+age+"^"+gender+ ", OUTPUT:" +bfp);

        return bfp  ;
    }

    @RequestMapping(value = "/getBMR", method = RequestMethod.POST)
    public double getBMR(@RequestBody Map<String,String> body){

        double height = Double.parseDouble( body.get("height")); //cms

        double weight = Double.parseDouble( body.get("weight")); //kgs

        int age = Integer.parseInt(body.get("age"));// years

        String gender = body.get("gender"); // male , female

        if (height < 0 || weight < 0 || age<0 ) {
            logger.info("[BMR] - INPUT:" +height+"^"+weight+ "^"+age+"^"+gender+ ", OUTPUT:" + "Invalid Input");

            return -1;
        }

        double bmr=0.0;

        if(gender=="male")
        {

                bmr = (10*weight) + (6.25*height) - (5*age) + 5;
        }
        else if(gender=="female")
        {
            bmr = (10*weight) + (6.25*height) - (5*age) - 161;

        }
        else
        {
            logger.info("[BMR] - INPUT:" +height+"^"+weight+ "^"+age+"^"+gender+ ", OUTPUT:" + "Invalid Input");

            return -1;
        }

        logger.info("[BMR] - INPUT:" +height+"^"+weight+ "^"+age+"^"+gender+ ", OUTPUT:" +bmr);

        return bmr  ;
    }

    @RequestMapping(value = "/getIdealWeight", method = RequestMethod.POST)
    public double getIdealWeight(@RequestBody Map<String,String> body){

        double height = Double.parseDouble( body.get("height")); //cms

        int age = Integer.parseInt(body.get("age"));// years

        String gender = body.get("gender"); // male , female

        if (height < 0 ||  age<0 ) {
            logger.info("[IdealWeight] - INPUT:" +height+ "^"+age+"^"+gender+ ", OUTPUT:" + "Invalid Input");

            return -1;
        }

        double weight = 0.0; //kgs

        if(gender=="male")
        {
            if (height<152.4)
            {
                weight = 48.0 - (152.4 - height) * 1.1;
            }
            else
            {
                weight = 48.0 + (height - 152.4) * 1.1;
            }
        }
        else if(gender=="female")
        {
            if (height<152.4)
            {
                weight = 45 - (152.4 - height) * 1.1;
            }
            else
            {
                weight = 45 + (height - 152.4) * 1.1;
            }
        }
        else
        {
            logger.info("[IdealWeight] - INPUT:" +height+ "^"+age+"^"+gender+ ", OUTPUT:" + "Invalid Input");

            return -1;
        }

        logger.info("[IdealWeight] - INPUT:" +height+ "^"+age+"^"+gender+ ", OUTPUT:" +weight);

        return weight  ;
    }

    @RequestMapping(value = "/getLBM", method = RequestMethod.POST)
    public double getLBM(@RequestBody Map<String,String> body){

        double height = Double.parseDouble( body.get("height")); //cms

        double weight = Double.parseDouble( body.get("weight")); //kgs

        int age = Integer.parseInt(body.get("age"));// years

        String gender = body.get("gender"); // male , female

        if (height < 0 || weight < 0 || age<0 ) {
            logger.info("[LBM] - INPUT:" +height+"^"+weight+ "^"+age+"^"+gender+ ", OUTPUT:" + "Invalid Input");

            return -1;
        }

        double lbm=0.0;

        if(gender=="male")
        {
            lbm = (0.407*weight) + (0.267*height) - 19.2;
        }
        else if(gender=="female")
        {
            lbm = (0.252*weight) + (0.473*height) - 48.3;

        }
        else
        {
            logger.info("[LBM] - INPUT:" +height+"^"+weight+ "^"+age+"^"+gender+ ", OUTPUT:" + "Invalid Input");

            return -1;
        }

        logger.info("[LBM] - INPUT:" +height+"^"+weight+ "^"+age+"^"+gender+ ", OUTPUT:" +lbm);

        return lbm  ;
    }

    @RequestMapping(value = "/getBSA", method = RequestMethod.POST)
    public double getBSA(@RequestBody Map<String,String> body){

        double height = Double.parseDouble( body.get("height")); //cms

        double weight = Double.parseDouble( body.get("weight")); //kgs

        if (height < 0 || weight < 0 ) {
            logger.info("[BSA] - INPUT:" +height+"^"+weight+ ", OUTPUT:" + "Invalid Input");

            return -1;
        }

        double bsa= 0.016667 * Math.sqrt(weight) * Math.sqrt(height);

        logger.info("[BSA] - INPUT:" +height+"^"+weight+ ", OUTPUT:" +bsa);

        return bsa  ;
    }

}
