package Package1;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase1 {

    @Test
    @Parameters("myName")
    public void test1(String myName) {
        System.out.println("I'm from 1, Hallo " +  myName);
    }
}
