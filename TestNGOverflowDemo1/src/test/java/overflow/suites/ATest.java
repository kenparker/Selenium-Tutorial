package overflow.suites;

import org.testng.annotations.Test;

public class ATest extends Base {

    @Test
    public void test1() {
        System.out.println("test1 :" + driver.getClass());
    }
}
