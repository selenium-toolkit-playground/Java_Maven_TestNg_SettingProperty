package com.seleniumToolkit.selenium.test;

import com.seleniumToolkit.selenium.framework.assertBase.ReportAssert;
import com.seleniumToolkit.selenium.helper.TestObject;
import com.seleniumToolkit.selenium.framework.tag.SeleniumTest;
import com.seleniumToolkit.selenium.framework.allure.AllureUtils;
import org.testng.annotations.Test;

public class AssertTest {

    @Test(groups = {"allTests"})
    public void sample() {
        AllureUtils.startStep("ReportAssert.assertEquals");
        ReportAssert.assertEquals(1, 1, "1==1 int");
        ReportAssert.assertEquals(1l, 1l, "1==1 long");
        ReportAssert.assertEquals(new Float(1.0).floatValue(), new Float(1.0).floatValue(), "1.0==1.0 float");
        ReportAssert.assertEquals(1.0,  1.0, "1.0==1.0 double");
        ReportAssert.assertEquals("1.0", "1.0", "\"1.0\"==\"1.0\" String");
        ReportAssert.assertEquals(new int[]{1,2}, new int[]{1,2}, "[1,2]==[1,2] int[]");
        ReportAssert.assertEquals(new long[]{1l,2l}, new long[]{1l,2l}, "[1,2]==[1,2] long[]");
        ReportAssert.assertEquals(new float[]{new Float(1.0).floatValue(),new Float(2.0).floatValue()}, new float[]{new Float(1.0).floatValue(),new Float(2.0).floatValue()}, "[1.0,2.0]==[1.0,2.0] float[]");
        ReportAssert.assertEquals(new double[]{1.0,2.0}, new double[]{1.0,2.0}, "[1.0,2.0]==[1.0,2.0] double[]");
        ReportAssert.assertEquals(new String[]{"1.0","2.0"}, new String[]{"1.0","2.0"}, "[1.0,2.0]==[1.0,2.0] String[]");
        ReportAssert.assertEquals(new TestObject("1.0"), new TestObject("1.0"), "new TestObject(\"1.0\") == new TestObject(\"1.0\")");
        AllureUtils.stopStepPassed();

        AllureUtils.startStep("ReportAssert.assertNotEquals");
        ReportAssert.assertNotEquals(1, 2, "1!=2 int");
        ReportAssert.assertNotEquals(1l, 2l, "1!=2 long");
        ReportAssert.assertNotEquals(new Float(1.0).floatValue(), new Float(2.0).floatValue(), "1.0!=2.0 float");
        ReportAssert.assertNotEquals(1.0,  2.0, "1.0!=2.0 double");
        ReportAssert.assertNotEquals("1.0", "2.0", "\"1.0\"!=\"2.0\" String");
        ReportAssert.assertNotEquals(new int[]{1,2}, new int[]{2,2}, "[1,2]!=[2,2] int[]");
        ReportAssert.assertNotEquals(new long[]{1l,2l}, new long[]{2l,2l}, "[1,2]!=[2,2] long[]");
        ReportAssert.assertNotEquals(new float[]{new Float(1.0).floatValue(),new Float(2.0).floatValue()}, new float[]{new Float(2.0).floatValue(),new Float(2.0).floatValue()}, "[1.0,2.0]!=[2.0,2.0] float[]");
        ReportAssert.assertNotEquals(new double[]{1.0,2.0}, new double[]{2.0,2.0}, "[1.0,2.0]!=[2.0,2.0] double[]");
        ReportAssert.assertNotEquals(new String[]{"1.0","2.0"}, new String[]{"2.0","2.0"}, "[1.0,2.0]!=[2.0,2.0] String[]");
        ReportAssert.assertNotEquals(new TestObject("1.0"), new TestObject("2.0"), "new TestObject(\"1.0\") != new TestObject(\"2.0\")");
        AllureUtils.stopStepPassed();

        AllureUtils.startStep("ReportAssert.assertTrue/assertFalse");
        ReportAssert.assertTrue(true, "ReportAssert.assertTrue");
        ReportAssert.assertFalse(false, "ReportAssert.assertFalse");
        AllureUtils.stopStepPassed();
        AllureUtils.startStep("ReportAssert.assertNull");
        ReportAssert.assertNull(null, "ReportAssert.assertNull null");
        AllureUtils.stopStepPassed();
        AllureUtils.startStep("ReportAssert.assertSame/assertNotSame");
        TestObject t = new TestObject("1.0");
        ReportAssert.assertSame(t, t, "t = new TestObject(\"1.0\"); t == t");
        ReportAssert.assertNotSame(t, new TestObject("1.0"), "t = new TestObject(\"1.0\"); t !=  new TestObject(\"1.0\");");
        AllureUtils.stopStepPassed();
    }

}
