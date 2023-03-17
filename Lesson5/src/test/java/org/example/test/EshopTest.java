package org.example.test;

import org.example.setupTest.SetupTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.annotation.Nullable;

public class EshopTest extends SetupTest {
    private final String _baseUrl = "https://automationteststore.com/";

    @Test
    void testSearch()
    {
        webDriver.get(_baseUrl);
        webDriver.findElement(By.id("filter_keyword")).sendKeys("paper");
        webDriver.findElement(By.className("button-in-search")).click();
        var title = webDriver.findElement(By.xpath("//h1/span")).getText();
        var expected = "Paper Towns by John Green";
        Assert.assertEquals(title, expected);
    }

    @Test
    void testCurrencyChange()
    {
        webDriver.get(_baseUrl);
    }
}
