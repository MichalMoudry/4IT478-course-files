package org.example.setupTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class SetupTest {
    protected static WebDriver webDriver;

    @BeforeSuite
    @Parameters({"browser"})
    protected void setupSuite(String browser)
    {
        switch (browser) {
            case "chrome" -> WebDriverManager.chromedriver().setup();
            case "edge" -> WebDriverManager.edgedriver().setup();
            default -> throw new IllegalArgumentException("Invalid browser: " + browser);
        }
    }

    @BeforeMethod
    @Parameters({"browser"})
    protected void setupTest(String browser)
    {
        if (browser.equals("chrome"))
        {
            var chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            webDriver = new ChromeDriver(chromeOptions);
        } else if (browser.equals("edge")) {
            webDriver = new EdgeDriver();
        }
    }

    @AfterSuite
    protected void teardownAfterSuite()
    {
        if (webDriver != null)
            webDriver.quit();
    }

    @AfterMethod
    protected void teardownAfterTest()
    {
        if (webDriver != null)
            webDriver.close();
    }
}
