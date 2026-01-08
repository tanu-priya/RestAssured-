package asserts;

import org.testng.Assert;

public class AssertActions {

    public static void verifyResponseBody(String actual, String expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    public static void verifyStatusCode(int actual, int expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    public static void verifyNotNull(Object object, String message) {
        Assert.assertNotNull(object, message);
    }

}
