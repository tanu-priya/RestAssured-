package asserts;

import org.testng.Assert;

public class AssertActions {

    public void verifyResponseBody(String actual, String expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    public void verifyStatusCode(int actual, int expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    public void verifyNotNull(Object object, String message) {
        Assert.assertNotNull(object, message);
    }

}
