package com.example.SoftwareTestingProject;

import com.example.SoftwareTestingProject.controller.CalController;
import com.example.SoftwareTestingProject.controller.HealthController;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HealthTest {
    private static final double DELTA = 1e-15;

    HealthController healthController = new HealthController();

    @Test
    public void BMI(){
        Map<String,String> body1 = new HashMap();
        body1.put("height", "180");
        body1.put("weight", "-1");
        String ans1="Invalid Input";

        Map<String,String> body2 = new HashMap();
        body2.put("height", "180");
        body2.put("weight", "40");
        String ans2="Severe Thinness";

        Map<String,String> body3 = new HashMap();
        body3.put("height", "180");
        body3.put("weight", "55");
        String ans3="Moderate Thinness";

        Map<String,String> body4 = new HashMap();
        body4.put("height", "180");
        body4.put("weight", "58");
        String ans4="Mild Thinness";

        Map<String,String> body5 = new HashMap();
        body5.put("height", "180");
        body5.put("weight", "65");
        String ans5="Normal";

        Map<String,String> body6 = new HashMap();
        body6.put("height", "180");
        body6.put("weight", "85");
        String ans6="Overweight Thinness";

        Map<String,String> body7 = new HashMap();
        body7.put("height", "180");
        body7.put("weight", "110");
        String ans7="Obesity";

        Assert.assertEquals("BMI for True Positive", ans1, healthController.getBMI(body1));
        Assert.assertEquals("BMI for True Positive", ans2, healthController.getBMI(body2));
        Assert.assertEquals("BMI for True Positive", ans3, healthController.getBMI(body3));
        Assert.assertEquals("BMI for True Positive", ans4, healthController.getBMI(body4));
        Assert.assertEquals("BMI for True Positive", ans5, healthController.getBMI(body5));
        Assert.assertEquals("BMI for True Positive", ans6, healthController.getBMI(body6));
        Assert.assertEquals("BMI for True Positive", ans7, healthController.getBMI(body7));
    }

    @Test
    public void BFP(){
        Map<String,String> body1 = new HashMap();
        body1.put("height", "180");
        body1.put("weight", "-1");
        body1.put("age", "18");
        body1.put("gender", "male");
        double ans1=-1;

        Map<String,String> body2 = new HashMap();
        body2.put("height", "180");
        body2.put("weight", "40");
        body2.put("age", "18");
        body2.put("gender", "ma");
        double ans2=-1;

        Map<String,String> body3 = new HashMap();
        body3.put("height", "180");
        body3.put("weight", "55");
        body3.put("age", "18");
        body3.put("gender", "male");
        double ans3=36.032716049382714;

        Map<String,String> body4 = new HashMap();
        body4.put("height", "180");
        body4.put("weight", "60");
        body4.put("age", "10");
        body4.put("gender", "male");
        double ans4=8.322222222222223;

        Map<String,String> body5 = new HashMap();
        body5.put("height", "180");
        body5.put("weight", "65");
        body5.put("age", "18");
        body5.put("gender", "female");
        double ans5=41.49320987654321;

        Map<String,String> body6 = new HashMap();
        body6.put("height", "180");
        body6.put("weight", "85");
        body6.put("age", "10");
        body6.put("gender", "female");
        double ans6=28.38148148148148;

        Assert.assertEquals("BFP for True Positive", ans1, healthController.getBFP(body1), DELTA);
        Assert.assertEquals("BFP for True Positive", ans2, healthController.getBFP(body2), DELTA);
        Assert.assertEquals("BFP for True Positive", ans3, healthController.getBFP(body3), DELTA);
        Assert.assertEquals("BFP for True Positive", ans4, healthController.getBFP(body4), DELTA);
        Assert.assertEquals("BFP for True Positive", ans5, healthController.getBFP(body5), DELTA);
        Assert.assertEquals("BFP for True Positive", ans6, healthController.getBFP(body6), DELTA);
    }

    @Test
    public void BMR(){
        Map<String,String> body1 = new HashMap();
        body1.put("height", "180");
        body1.put("weight", "-1");
        body1.put("age", "18");
        body1.put("gender", "male");
        double ans1=-1;

        Map<String,String> body2 = new HashMap();
        body2.put("height", "180");
        body2.put("weight", "40");
        body2.put("age", "18");
        body2.put("gender", "ma");
        double ans2=-1;

        Map<String,String> body3 = new HashMap();
        body3.put("height", "180");
        body3.put("weight", "55");
        body3.put("age", "18");
        body3.put("gender", "male");
        double ans3=1590.0;

        Map<String,String> body4 = new HashMap();
        body4.put("height", "160");
        body4.put("weight", "60");
        body4.put("age", "20");
        body4.put("gender", "female");
        double ans4=1339.0;


        Assert.assertEquals("BMR for True Positive", ans1, healthController.getBMR(body1), DELTA);
        Assert.assertEquals("BMR for True Positive", ans2, healthController.getBMR(body2), DELTA);
        Assert.assertEquals("BMR for True Positive", ans3, healthController.getBMR(body3), DELTA);
        Assert.assertEquals("BMR for True Positive", ans4, healthController.getBMR(body4), DELTA);
    }

    @Test
    public void IdealWeight(){
        Map<String,String> body1 = new HashMap();
        body1.put("height", "-180");
        body1.put("age", "18");
        body1.put("gender", "male");
        double ans1=-1;

        Map<String,String> body2 = new HashMap();
        body2.put("height", "180");
        body2.put("age", "18");
        body2.put("gender", "ma");
        double ans2=-1;

        Map<String,String> body3 = new HashMap();
        body3.put("height", "140");
        body3.put("age", "18");
        body3.put("gender", "male");
        double ans3=34.35999999999999;

        Map<String,String> body4 = new HashMap();
        body4.put("height", "180");
        body4.put("age", "10");
        body4.put("gender", "male");
        double ans4=78.36;

        Map<String,String> body5 = new HashMap();
        body5.put("height", "140");
        body5.put("age", "18");
        body5.put("gender", "female");
        double ans5=31.359999999999992;

        Map<String,String> body6 = new HashMap();
        body6.put("height", "180");
        body6.put("age", "10");
        body6.put("gender", "female");
        double ans6=75.36;

        Assert.assertEquals("IdealWeight for True Positive", ans1, healthController.getIdealWeight(body1), DELTA);
        Assert.assertEquals("IdealWeight for True Positive", ans2, healthController.getIdealWeight(body2), DELTA);
        Assert.assertEquals("IdealWeight for True Positive", ans3, healthController.getIdealWeight(body3), DELTA);
        Assert.assertEquals("IdealWeight for True Positive", ans4, healthController.getIdealWeight(body4), DELTA);
        Assert.assertEquals("IdealWeight for True Positive", ans5, healthController.getIdealWeight(body5), DELTA);
        Assert.assertEquals("IdealWeight for True Positive", ans6, healthController.getIdealWeight(body6), DELTA);
    }

    @Test
    public void LBM(){
        Map<String,String> body1 = new HashMap();
        body1.put("height", "180");
        body1.put("weight", "-1");
        body1.put("age", "18");
        body1.put("gender", "male");
        double ans1=-1;

        Map<String,String> body2 = new HashMap();
        body2.put("height", "180");
        body2.put("weight", "40");
        body2.put("age", "18");
        body2.put("gender", "ma");
        double ans2=-1;

        Map<String,String> body3 = new HashMap();
        body3.put("height", "180");
        body3.put("weight", "55");
        body3.put("age", "18");
        body3.put("gender", "male");
        double ans3=51.24499999999999;

        Map<String,String> body4 = new HashMap();
        body4.put("height", "160");
        body4.put("weight", "60");
        body4.put("age", "20");
        body4.put("gender", "female");
        double ans4=42.5;

        Assert.assertEquals("LBM for True Positive", ans1, healthController.getLBM(body1), DELTA);
        Assert.assertEquals("LBM for True Positive", ans2, healthController.getLBM(body2), DELTA);
        Assert.assertEquals("LBM for True Positive", ans3, healthController.getLBM(body3), DELTA);
        Assert.assertEquals("LBM for True Positive", ans4, healthController.getLBM(body4), DELTA);
    }

    @Test
    public void BSA(){
        Map<String,String> body1 = new HashMap();
        body1.put("height", "180");
        body1.put("weight", "-75");
        double ans1=-1;

        Map<String,String> body2 = new HashMap();
        body2.put("height", "180");
        body2.put("weight", "40");
        double ans2=1.4142418466443427;

        Assert.assertEquals("BSA for True Positive", ans1, healthController.getBSA(body1), DELTA);
        Assert.assertEquals("BSA for True Positive", ans2, healthController.getBSA(body2), DELTA);
    }

}