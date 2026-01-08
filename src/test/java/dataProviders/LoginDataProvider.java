package dataProviders;

import org.testng.annotations.DataProvider;

import utils.ConfigReader;

public class LoginDataProvider {

    @DataProvider(name = "loginDataProvider")
    public Object[][] loginDataProvider() {
        return new Object[][] {
            { ConfigReader.get("email"), ConfigReader.get("password"), 200 },
            {"test26@gmail.com","11111111",401}
        };
    }
    
}
    
