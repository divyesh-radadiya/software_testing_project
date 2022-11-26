package com.example.SoftwareTestingProject;

import com.example.SoftwareTestingProject.controller.BankController;
import com.example.SoftwareTestingProject.controller.CalController;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class BankTest {
    private static final double DELTA = 1e-15;

    BankController bankController = new BankController();

    @Test
    public void EMI(){
        Map<String,String> body1 = new HashMap();
        body1.put("amount", "1000");
        body1.put("term", "-1");
        body1.put("interestRate", "10");
        double ans1=-1;

        Map<String,String> body2 = new HashMap();
        body2.put("amount", "1000");
        body2.put("term", "5");
        body2.put("interestRate", "10");
        double ans2=5;

        Assert.assertEquals("EMI of amount for True Positive", ans1, bankController.getEMI(body1), DELTA);
        Assert.assertEquals("EMI of amount for True Positive", ans2, bankController.getEMI(body2), DELTA);

    }

    @Test
    public void interest(){
        Map<String,String> body1 = new HashMap();
        body1.put("amount", "-600");
        body1.put("acType", "NRI");
        double ans1=-1;

        Map<String,String> body2 = new HashMap();
        body2.put("amount","1000");
        body2.put("acType", "SAVING");
        double ans2=1;

        Map<String,String> body3 = new HashMap();
        body3.put("amount","1000");
        body3.put("acType", "NRI");
        double ans3=2;

        Map<String,String> body4 = new HashMap();
        body4.put("amount","1000");
        body4.put("acType", "Normal");
        double ans4=2;

        Assert.assertEquals("interest of amount for True Positive", ans1, bankController.getInterest(body1), DELTA);
        Assert.assertEquals("interest of amount for True Positive", ans2, bankController.getInterest(body2), DELTA);
        Assert.assertEquals("interest of amount for True Positive", ans3, bankController.getInterest(body3), DELTA);
        Assert.assertEquals("interest of amount for True Positive", ans4, bankController.getInterest(body4), DELTA);
    }

    @Test
    public void CompoundInterest(){
        Map<String,String> body1 = new HashMap();
        body1.put("amount", "1000");
        body1.put("term", "-1");
        body1.put("interestRate", "10");
        body1.put("compound", "monthly");
        double ans1=-1;

        Map<String,String> body2 = new HashMap();
        body2.put("amount", "1000");
        body2.put("term", "5");
        body2.put("interestRate", "10");
        body2.put("compound", "q");
        double ans2=-1;

        Map<String,String> body3 = new HashMap();
        body3.put("amount", "1000");
        body3.put("term", "5");
        body3.put("interestRate", "10");
        body3.put("compound", "monthly");
        double ans3=3.912023005428146;

        Map<String,String> body4 = new HashMap();
        body4.put("amount", "1000");
        body4.put("term", "5");
        body4.put("interestRate", "10");
        body4.put("compound", "annually");
        double ans4=3.912023005428146;

        Assert.assertEquals("CompoundInterest of amount for True Positive", ans1, bankController.getCompoundInterest(body1), DELTA);
        Assert.assertEquals("CompoundInterest of amount for True Positive", ans2, bankController.getCompoundInterest(body2), DELTA);
        Assert.assertEquals("CompoundInterest of amount for True Positive", ans3, bankController.getCompoundInterest(body3), DELTA);
        Assert.assertEquals("CompoundInterest of amount for True Positive", ans4, bankController.getCompoundInterest(body4), DELTA);

    }


    @Test
    public void IncomeTax(){
        Map<String,String> body1 = new HashMap();
        body1.put("income", "-10000");
        double ans1=-1;

        Map<String,String> body2 = new HashMap();
        body2.put("income", "400000");
        double ans2=0;

        Map<String,String> body3 = new HashMap();
        body3.put("income", "700000");
        double ans3=-1;

        Map<String,String> body4 = new HashMap();
        body4.put("income", "900000");
        double ans4=0;

        Map<String,String> body5 = new HashMap();
        body5.put("income", "1100000");
        double ans5=-1;

        Map<String,String> body6 = new HashMap();
        body6.put("income", "1400000");
        double ans6=0;

        Map<String,String> body7 = new HashMap();
        body7.put("income", "1600000");
        double ans7=0;

        Assert.assertEquals("IncomeTax of income for True Positive", ans1, bankController.getIncomeTax(body1), DELTA);
        Assert.assertEquals("IncomeTax of income for True Positive", ans2, bankController.getIncomeTax(body2), DELTA);
        Assert.assertEquals("IncomeTax of income for True Positive", ans3, bankController.getIncomeTax(body3), DELTA);
        Assert.assertEquals("IncomeTax of income for True Positive", ans4, bankController.getIncomeTax(body4), DELTA);
        Assert.assertEquals("IncomeTax of income for True Positive", ans5, bankController.getIncomeTax(body5), DELTA);
        Assert.assertEquals("IncomeTax of income for True Positive", ans6, bankController.getIncomeTax(body6), DELTA);
        Assert.assertEquals("IncomeTax of income for True Positive", ans7, bankController.getIncomeTax(body7), DELTA);

    }

    @Test
    public void FDInterest(){
        Map<String,String> body1 = new HashMap();
        body1.put("amount", "1000");
        body1.put("term", "-1");
        body1.put("age", "10");
        double ans1=-1;

        Map<String,String> body2 = new HashMap();
        body2.put("amount", "1000");
        body2.put("term", "-1");
        body2.put("age", "10");
        double ans2=0;

        Map<String,String> body3 = new HashMap();
        body3.put("amount", "1000");
        body3.put("term", "-1");
        body3.put("age", "10");
        double ans3=-1;

        Map<String,String> body4 = new HashMap();
        body4.put("amount", "1000");
        body4.put("term", "-1");
        body4.put("age", "10");
        double ans4=0;

        Map<String,String> body5 = new HashMap();
        body5.put("amount", "1000");
        body5.put("term", "-1");
        body5.put("age", "10");
        double ans5=-1;

        Map<String,String> body6 = new HashMap();
        body6.put("amount", "1000");
        body6.put("term", "-1");
        body6.put("age", "10");
        double ans6=0;

        Map<String,String> body7 = new HashMap();
        body7.put("amount", "1000");
        body7.put("term", "-1");
        body7.put("age", "10");
        double ans7=0;

        Map<String,String> body8 = new HashMap();
        body8.put("amount", "1000000");
        body8.put("term", "12");
        body8.put("age", "60");
        double ans8=0;

        Map<String,String> body9 = new HashMap();
        body9.put("amount", "1000000");
        body9.put("term", "24");
        body9.put("age", "60");
        double ans9=-1;

        Map<String,String> body10 = new HashMap();
        body10.put("amount", "1000000");
        body10.put("term", "36");
        body10.put("age", "60");
        double ans10=0;

        Map<String,String> body11 = new HashMap();
        body11.put("amount", "1000000");
        body11.put("term", "48");
        body11.put("age", "60");
        double ans11=-1;

        Map<String,String> body12 = new HashMap();
        body12.put("amount", "1000000");
        body12.put("term", "120");
        body12.put("age", "60");
        double ans12=0;

        Map<String,String> body13 = new HashMap();
        body13.put("amount", "1000000");
        body13.put("term", "240");
        body13.put("age", "60");
        double ans13=0;

        Map<String,String> body14 = new HashMap();
        body14.put("amount", "10000000");
        body14.put("term", "12");
        body14.put("age", "60");
        double ans14=0;

        Map<String,String> body15 = new HashMap();
        body15.put("amount", "10000000");
        body15.put("term", "24");
        body15.put("age", "60");
        double ans15=-1;

        Map<String,String> body16 = new HashMap();
        body16.put("amount", "10000000");
        body16.put("term", "36");
        body16.put("age", "60");
        double ans16=0;

        Map<String,String> body17 = new HashMap();
        body17.put("amount", "10000000");
        body17.put("term", "48");
        body17.put("age", "60");
        double ans17=-1;

        Map<String,String> body18 = new HashMap();
        body18.put("amount", "10000000");
        body18.put("term", "120");
        body18.put("age", "60");
        double ans18=0;

        Map<String,String> body19 = new HashMap();
        body19.put("amount", "10000000");
        body19.put("term", "240");
        body19.put("age", "60");
        double ans19=0;

        Map<String,String> body20 = new HashMap();
        body20.put("amount", "1000000");
        body20.put("term", "480");
        body20.put("age", "10");
        double ans20=0;

        Map<String,String> body21 = new HashMap();
        body21.put("amount", "1000000");
        body21.put("term", "480");
        body21.put("age", "60");
        double ans21=0;

        Map<String,String> body22 = new HashMap();
        body22.put("amount", "10000000");
        body22.put("term", "480");
        body22.put("age", "50");
        double ans22=0;

        Assert.assertEquals("FDInterest of amount for True Positive", ans1, bankController.getIncomeTax(body1), DELTA);
        Assert.assertEquals("FDInterest of amount for True Positive", ans2, bankController.getIncomeTax(body2), DELTA);
        Assert.assertEquals("FDInterest of amount for True Positive", ans3, bankController.getIncomeTax(body3), DELTA);
        Assert.assertEquals("FDInterest of amount for True Positive", ans4, bankController.getIncomeTax(body4), DELTA);
        Assert.assertEquals("FDInterest of amount for True Positive", ans5, bankController.getIncomeTax(body5), DELTA);
        Assert.assertEquals("FDInterest of amount for True Positive", ans6, bankController.getIncomeTax(body6), DELTA);
        Assert.assertEquals("FDInterest of amount for True Positive", ans7, bankController.getIncomeTax(body7), DELTA);
        Assert.assertEquals("FDInterest of amount for True Positive", ans8, bankController.getIncomeTax(body8), DELTA);
        Assert.assertEquals("FDInterest of amount for True Positive", ans9, bankController.getIncomeTax(body9), DELTA);
        Assert.assertEquals("FDInterest of amount for True Positive", ans10, bankController.getIncomeTax(body10), DELTA);
        Assert.assertEquals("FDInterest of amount for True Positive", ans11, bankController.getIncomeTax(body11), DELTA);
        Assert.assertEquals("FDInterest of amount for True Positive", ans12, bankController.getIncomeTax(body12), DELTA);
        Assert.assertEquals("FDInterest of amount for True Positive", ans13, bankController.getIncomeTax(body13), DELTA);
        Assert.assertEquals("FDInterest of amount for True Positive", ans14, bankController.getIncomeTax(body14), DELTA);
        Assert.assertEquals("FDInterest of amount for True Positive", ans15, bankController.getIncomeTax(body15), DELTA);
        Assert.assertEquals("FDInterest of amount for True Positive", ans16, bankController.getIncomeTax(body16), DELTA);
        Assert.assertEquals("FDInterest of amount for True Positive", ans17, bankController.getIncomeTax(body17), DELTA);
        Assert.assertEquals("FDInterest of amount for True Positive", ans18, bankController.getIncomeTax(body18), DELTA);
        Assert.assertEquals("FDInterest of amount for True Positive", ans19, bankController.getIncomeTax(body19), DELTA);
        Assert.assertEquals("FDInterest of amount for True Positive", ans20, bankController.getIncomeTax(body20), DELTA);
        Assert.assertEquals("FDInterest of amount for True Positive", ans21, bankController.getIncomeTax(body21), DELTA);
        Assert.assertEquals("FDInterest of amount for True Positive", ans22, bankController.getIncomeTax(body22), DELTA);

    }

    @Test
    public void RDInterest(){
        Map<String,String> body1 = new HashMap();
        body1.put("amount", "1000000");
        body1.put("term", "-1");
        body1.put("age", "10");
        double ans1=-1;

        Map<String,String> body2 = new HashMap();
        body2.put("amount", "1000000");
        body2.put("term", "6");
        body2.put("age", "10");
        double ans2=0;

        Map<String,String> body3 = new HashMap();
        body3.put("amount", "1000000");
        body3.put("term", "9");
        body3.put("age", "10");
        double ans3=-1;

        Map<String,String> body4 = new HashMap();
        body4.put("amount", "1000000");
        body4.put("term", "12");
        body4.put("age", "10");
        double ans4=0;

        Map<String,String> body5 = new HashMap();
        body5.put("amount", "1000000");
        body5.put("term", "15");
        body5.put("age", "10");
        double ans5=-1;

        Map<String,String> body6 = new HashMap();
        body6.put("amount", "1000000");
        body6.put("term", "18");
        body6.put("age", "10");
        double ans6=0;

        Map<String,String> body7 = new HashMap();
        body7.put("amount", "1000000");
        body7.put("term", "21");
        body7.put("age", "10");
        double ans7=0;

        Map<String,String> body8 = new HashMap();
        body8.put("amount", "1000000");
        body8.put("term", "24");
        body8.put("age", "10");
        double ans8=0;

        Map<String,String> body9 = new HashMap();
        body9.put("amount", "1000000");
        body9.put("term", "6");
        body9.put("age", "60");
        double ans9=0;

        Map<String,String> body10 = new HashMap();
        body10.put("amount", "1000000");
        body10.put("term", "9");
        body10.put("age", "60");
        double ans10=-1;

        Map<String,String> body11 = new HashMap();
        body11.put("amount", "1000000");
        body11.put("term", "12");
        body11.put("age", "60");
        double ans11=0;

        Map<String,String> body12 = new HashMap();
        body12.put("amount", "1000000");
        body12.put("term", "15");
        body12.put("age", "60");
        double ans12=-1;

        Map<String,String> body13 = new HashMap();
        body13.put("amount", "1000000");
        body13.put("term", "18");
        body13.put("age", "60");
        double ans13=0;

        Map<String,String> body14 = new HashMap();
        body14.put("amount", "1000000");
        body14.put("term", "21");
        body14.put("age", "60");
        double ans14=0;

        Map<String,String> body15 = new HashMap();
        body15.put("amount", "1000000");
        body15.put("term", "24");
        body15.put("age", "60");
        double ans15=0;

        Assert.assertEquals("RDInterest of amount for True Positive", ans1, bankController.getIncomeTax(body1), DELTA);
        Assert.assertEquals("RDInterest of amount for True Positive", ans2, bankController.getIncomeTax(body2), DELTA);
        Assert.assertEquals("RDInterest of amount for True Positive", ans3, bankController.getIncomeTax(body3), DELTA);
        Assert.assertEquals("RDInterest of amount for True Positive", ans4, bankController.getIncomeTax(body4), DELTA);
        Assert.assertEquals("RDInterest of amount for True Positive", ans5, bankController.getIncomeTax(body5), DELTA);
        Assert.assertEquals("RDInterest of amount for True Positive", ans6, bankController.getIncomeTax(body6), DELTA);
        Assert.assertEquals("RDInterest of amount for True Positive", ans7, bankController.getIncomeTax(body7), DELTA);
        Assert.assertEquals("RDInterest of amount for True Positive", ans8, bankController.getIncomeTax(body8), DELTA);
        Assert.assertEquals("RDInterest of amount for True Positive", ans9, bankController.getIncomeTax(body9), DELTA);
        Assert.assertEquals("RDInterest of amount for True Positive", ans10, bankController.getIncomeTax(body10), DELTA);
        Assert.assertEquals("RDInterest of amount for True Positive", ans11, bankController.getIncomeTax(body11), DELTA);
        Assert.assertEquals("RDInterest of amount for True Positive", ans12, bankController.getIncomeTax(body12), DELTA);
        Assert.assertEquals("RDInterest of amount for True Positive", ans13, bankController.getIncomeTax(body13), DELTA);
        Assert.assertEquals("RDInterest of amount for True Positive", ans14, bankController.getIncomeTax(body14), DELTA);
        Assert.assertEquals("RDInterest of amount for True Positive", ans15, bankController.getIncomeTax(body15), DELTA);
    }

}