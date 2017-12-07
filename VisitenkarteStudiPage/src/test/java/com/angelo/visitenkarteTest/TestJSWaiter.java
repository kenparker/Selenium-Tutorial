package com.angelo.visitenkarteTest;

import com.angelo.commonNew.JSWaiter;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestJSWaiter extends TestBase{

    private JSWaiter jsWaiter;

    @Test
    public void testJSReady() {
        jsWaiter = new JSWaiter(loginController.getDriver());
        Boolean result = jsWaiter.waitUntilJSReady();
        assertTrue(result);
    }
}
