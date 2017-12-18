package Package2;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase3 {

    @Test
    @Parameters(("myName"))
    public void test3(String myName) {
        System.out.println("hello " + myName);
    }
}
