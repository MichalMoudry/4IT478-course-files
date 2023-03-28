package org.example.setupTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.*;

import java.time.Duration;

public class SetupTest {
    protected static WebDriver webDriver;

    @BeforeSuite
    protected void setupSuite()
    {
        System.setProperty("webdriver.edge.driver", "");
    }

    @BeforeMethod
    protected void setupTest()
    {
        var options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless");
        webDriver = new EdgeDriver(options);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
