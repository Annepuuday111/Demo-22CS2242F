package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLocatorsByHilightTheChanges {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.kluniversity.in");
        System.out.println("Working with Locators");
        driver.findElement(By.xpath("/html/body/div[1]/b/font/div/footer/div/div/div[3]/section/ul/li[6]/a")).submit();
    }
}
