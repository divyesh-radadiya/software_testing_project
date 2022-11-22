package com.example.SoftwareTestingProject.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController

public class ConversionController {

    private static final Logger logger = LogManager.getLogger("ConversionController");

    @RequestMapping(value = "/getLength", method = RequestMethod.POST)
    public double getLength(@RequestBody Map<String,String> body){

        double length = Double.parseDouble( body.get("length"));

        String from = body.get("from"); // km,m,cm,mm,mile,yard,foot,inch

        String to = body.get("to"); // km,m,cm,mm,mile,yard,foot,inch

        double ans=0.0;

        if (length < 0 ) {
            logger.info("[Length] - INPUT:" +length+"^"+from+"^"+to+ " , OUTPUT:" + "Invalid Input");

            return 0.0;
        }

        switch(from) {
            case "m":
                switch(to) {
                    case "m":
                        ans=length;
                        break;
                    case "km":
                        ans=length * 0.001 ;
                        break;
                    case "cm":
                        ans=length * 100;
                        break;
                    case "mm":
                        ans=length * 1000;
                        break;
                    case "mile":
                        ans=length * 0.0006213689;
                        break;
                    case "yard":
                        ans=length * 1.0936132983;
                        break;
                    case "foot":
                        ans=length * 3.280839895;
                        break;
                    case "inch":
                        ans=length * 39.37007874;
                        break;
                    default:
                        logger.info("[Length] - INPUT:" +length+"^"+from+"^"+to+ " , OUTPUT:" + "Invalid Input");

                        return -1;
                }
                break;
            case "km":
                switch(to) {
                    case "m":
                        ans=length * 1000;
                        break;
                    case "km":
                        ans=length * 1 ;
                        break;
                    case "cm":
                        ans=length * 100000;
                        break;
                    case "mm":
                        ans=length * 1000000;
                        break;
                    case "mile":
                        ans=length * 0.6213688756;
                        break;
                    case "yard":
                        ans=length * 1093.6132983;
                        break;
                    case "foot":
                        ans=length * 3280.839895;
                        break;
                    case "inch":
                        ans=length * 39370.07874;
                        break;
                    default:
                        logger.info("[Length] - INPUT:" +length+"^"+from+"^"+to+ " , OUTPUT:" + "Invalid Input");

                        return -1;
                }
                break;
            case "cm":
                switch(to) {
                    case "m":
                        ans=length * 0.01;
                        break;
                    case "km":
                        ans=length * 0.00001 ;
                        break;
                    case "cm":
                        ans=length * 1;
                        break;
                    case "mm":
                        ans=length * 10;
                        break;
                    case "mile":
                        ans=length * 0.0000062137;
                        break;
                    case "yard":
                        ans=length * 0.010936133;
                        break;
                    case "foot":
                        ans=length * 0.032808399;
                        break;
                    case "inch":
                        ans=length * 0.3937007874;
                        break;
                    default:
                        logger.info("[Length] - INPUT:" +length+"^"+from+"^"+to+ " , OUTPUT:" + "Invalid Input");

                        return -1;
                }
                break;
            case "mm":
                switch(to) {
                    case "m":
                        ans=length * 0.001;
                        break;
                    case "km":
                        ans=length * 0.000001 ;
                        break;
                    case "cm":
                        ans=length * 0.1;
                        break;
                    case "mm":
                        ans=length * 1;
                        break;
                    case "mile":
                        ans=length * 0.6213688756*0.0000001;
                        break;
                    case "yard":
                        ans=length * 0.0010936133;
                        break;
                    case "foot":
                        ans=length * 0.0032808399;
                        break;
                    case "inch":
                        ans=length * 0.0393700787;
                        break;
                    default:
                        logger.info("[Length] - INPUT:" +length+"^"+from+"^"+to+ " , OUTPUT:" + "Invalid Input");

                        return -1;
                }
                break;
            case "mile":
                switch(to) {
                    case "m":
                        ans=length * 1609.35;
                        break;
                    case "km":
                        ans=length * 1.60935 ;
                        break;
                    case "cm":
                        ans=length * 160935;
                        break;
                    case "mm":
                        ans=length * 1609350;
                        break;
                    case "mile":
                        ans=length * 1;
                        break;
                    case "yard":
                        ans=length * 1760.0065617;
                        break;
                    case "foot":
                        ans=length * 5280.019685;
                        break;
                    case "inch":
                        ans=length * 63360.23622;
                        break;
                    default:
                        logger.info("[Length] - INPUT:" +length+"^"+from+"^"+to+ " , OUTPUT:" + "Invalid Input");

                        return -1;
                }
                break;
            case "yard":
                switch(to) {
                    case "m":
                        ans=length * 0.9144;
                        break;
                    case "km":
                        ans=length * 0.0009144 ;
                        break;
                    case "cm":
                        ans=length * 91.44;
                        break;
                    case "mm":
                        ans=length * 914.4;
                        break;
                    case "mile":
                        ans=length * 0.0005681797;
                        break;
                    case "yard":
                        ans=length * 1;
                        break;
                    case "foot":
                        ans=length * 3;
                        break;
                    case "inch":
                        ans=length * 36;
                        break;
                    default:
                        logger.info("[Length] - INPUT:" +length+"^"+from+"^"+to+ " , OUTPUT:" + "Invalid Input");

                        return -1;
                }
                break;
            case "foot":
                switch(to) {
                    case "m":
                        ans=length * 0.3048;
                        break;
                    case "km":
                        ans=length * 0.0003048 ;
                        break;
                    case "cm":
                        ans=length * 30.48;
                        break;
                    case "mm":
                        ans=length * 304.8;
                        break;
                    case "mile":
                        ans=length * 0.0001893932;
                        break;
                    case "yard":
                        ans=length * 0.3333333333;
                        break;
                    case "foot":
                        ans=length * 1;
                        break;
                    case "inch":
                        ans=length * 12;
                        break;
                    default:
                        logger.info("[Length] - INPUT:" +length+"^"+from+"^"+to+ " , OUTPUT:" + "Invalid Input");

                        return -1;
                }
                break;
            case "inch":
                switch(to) {
                    case "m":
                        ans=length * 0.0254;
                        break;
                    case "km":
                        ans=length * 0.0000254;
                        break;
                    case "cm":
                        ans=length * 2.54;
                        break;
                    case "mm":
                        ans=length * 25.4;
                        break;
                    case "mile":
                        ans=length * 0.0000157828;
                        break;
                    case "yard":
                        ans=length * 0.0277777778;
                        break;
                    case "foot":
                        ans=length * 0.0833333333;
                        break;
                    case "inch":
                        ans=length * 1;
                        break;
                    default:
                        logger.info("[Length] - INPUT:" +length+"^"+from+"^"+to+ " , OUTPUT:" + "Invalid Input");

                        return -1;
                }
                break;
            default:
                logger.info("[Length] - INPUT:" +length+"^"+from+"^"+to+ " , OUTPUT:" + "Invalid Input");

                return -1;
        }


        logger.info("[Length] - INPUT:" +length+"^"+from+"^"+to+ " , OUTPUT:" + ans);

        return ans  ;
    }

    @RequestMapping(value = "/getTemperature", method = RequestMethod.POST)
    public double getTemperature(@RequestBody Map<String,String> body){

        double temperature = Double.parseDouble( body.get("temperature"));

        String from = body.get("from"); // C,F,K

        String to = body.get("to"); // C,F,K

        double ans=0.0;

        switch(from) {
                    case "C":
                        switch(to) {
                            case "C":
                                ans = temperature;
                                break;
                            case "K":
                                ans = temperature + 273.15 ;
                                break;
                            case "F":
                                ans= (temperature*9.0/5.0) + 32 ;
                                break;
                            default:
                                logger.info("[Temperature] - INPUT:" +temperature+"^"+from+"^"+to+ " , OUTPUT:" + "Invalid Input");

                                return -1;
                        }
                        break;
                    case "K":
                        switch(to) {
                            case "C":
                                ans= temperature - 273.15;
                                break;
                            case "K":
                                ans= temperature ;
                                break;
                            case "F":
                                ans= ((temperature - 273.15) * 9.0/5.0) + 32;
                                break;
                            default:
                                logger.info("[Temperature] - INPUT:" +temperature+"^"+from+"^"+to+ " , OUTPUT:" + "Invalid Input");

                                return -1;
                        }
                        break;
                    case "F":
                        switch(to) {
                            case "C":
                                ans = (temperature - 32.0) * 5.0/9.0;
                                break;
                            case "K":
                                ans = (temperature - 32.0) * 5.0/9.0 + 273.15;
                                break;
                            case "F":
                                ans = temperature;
                                break;
                            default:
                                logger.info("[Temperature] - INPUT:" +temperature+"^"+from+"^"+to+ " , OUTPUT:" + "Invalid Input");

                                return -1;
                        }
                        break;
                    default:
                        logger.info("[Temperature] - INPUT:" +temperature+"^"+from+"^"+to+ " , OUTPUT:" + "Invalid Input");

                        return -1;
                }

        logger.info("[Temperature] - INPUT:" +temperature+"^"+from+"^"+to+ " , OUTPUT:" + ans);

        return ans  ;
    }

    @RequestMapping(value = "/getWeight", method = RequestMethod.POST)
    public double getWeight(@RequestBody Map<String,String> body){

        double weight = Double.parseDouble( body.get("weight"));

        String from = body.get("from"); // kg,g,lbs

        String to = body.get("to"); // kg,g,lbs

        double ans=0.0;

        switch(from) {
            case "kg":
                switch(to) {
                    case "kg":
                        ans = weight;
                        break;
                    case "g":
                        ans = weight * 1000;
                        break;
                    case "lbs":
                        ans = weight * 2.2046244202;
                        break;
                    default:
                        logger.info("[Weight] - INPUT:" +weight+"^"+from+"^"+to+ " , OUTPUT:" + "Invalid Input");

                        return -1;
                }
                break;
            case "g":
                switch(to) {
                    case "kg":
                        ans = weight * 0.001;
                        break;
                    case "g":
                        ans = weight ;
                        break;
                    case "lbs":
                        ans = weight * 0.0022046244202;
                        break;
                    default:
                        logger.info("[Weight] - INPUT:" +weight+"^"+from+"^"+to+ " , OUTPUT:" + "Invalid Input");

                        return -1;
                }
                break;
            case "lbs":
                switch(to) {
                    case "kg":
                        ans = weight * 0.453592;
                        break;
                    case "g":
                        ans = weight * 453.592;
                        break;
                    case "lbs":
                        ans = weight ;
                        break;
                    default:
                        logger.info("[Weight] - INPUT:" +weight+"^"+from+"^"+to+ " , OUTPUT:" + "Invalid Input");

                        return -1;
                }
                break;
            default:
                logger.info("[Weight] - INPUT:" +weight+"^"+from+"^"+to+ " , OUTPUT:" + "Invalid Input");

                return -1;
        }

        logger.info("[Weight] - INPUT:" +weight+"^"+from+"^"+to+ " , OUTPUT:" + ans);

        return ans  ;
    }
}
