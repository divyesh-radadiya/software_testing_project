package com.example.SoftwareTestingProject;

import com.example.SoftwareTestingProject.controller.CalController;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class CalTest {
    private static final double DELTA = 1e-15;

    CalController calculator = new CalController();

    @Test
    public void squareRoot(){
        Map<String,String> body1 = new HashMap();
        body1.put("input1", "-1");
        double ans1=-1;

        Map<String,String> body2 = new HashMap();
        body2.put("input1","25");
        double ans2=5;

        Assert.assertEquals("Square root of number for True Positive", ans1, calculator.getSqrt(body1), DELTA);
        Assert.assertEquals("Square root of number for True Positive", ans2, calculator.getSqrt(body2), DELTA);

    }

    @Test
    public void factorial(){
        Map<String,String> body1 = new HashMap();
        body1.put("input1", "-6");
        double ans1=-1;

        Map<String,String> body2 = new HashMap();
        body2.put("input1","1");
        double ans2=1;

        Map<String,String> body3 = new HashMap();
        body3.put("input1","2");
        double ans3=2;

        Assert.assertEquals("Factorial of number for True Positive", ans1, calculator.getFact(body1), DELTA);
        Assert.assertEquals("Factorial of number for True Positive", ans2, calculator.getFact(body2), DELTA);
        Assert.assertEquals("Factorial of number for True Positive", ans3, calculator.getFact(body3), DELTA);

    }

    @Test
    public void log(){
        Map<String,String> body1 = new HashMap();
        body1.put("input1", "-1");
        double ans1=-1;

        Map<String,String> body2 = new HashMap();
        body2.put("input1","50");
        double ans2=3.912023005428146;

        Assert.assertEquals("Natural Log of number for True Positive", ans1, calculator.getLog(body1), DELTA);
        Assert.assertEquals("Natural Log of number for True Positive", ans2, calculator.getLog(body2), DELTA);

    }


    @Test
    public void power(){
        Map<String,String> body1 = new HashMap();
        body1.put("input1", "10");
        body1.put("input2", "2");
        double ans1=100;

        Assert.assertEquals("Power of number for True Positive", ans1, calculator.getPower(body1), DELTA);
    }


}