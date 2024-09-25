package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

public class MenuDrivenProgram {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        Scanner scanner = new Scanner(System.in);
        WebDriver driver = null;

        while (true) {
            System.out.println("Menu:");
            System.out.println("a. Opening The Browser");
            System.out.println("b. Opening The Given Url");
            System.out.println("c. Open the Browser if the Credentials are Correct");
            System.out.println("d. Open the url and give Responses of the invalid credentials");
            System.out.println("e. Open Browser Using Locators");
            System.out.println("f. Open Checkbox Test");
            System.out.println("g. Open Simple Alert Test");
            System.out.println("h. Open Dropdown Test");
            System.out.println("i. Uploading to GitHub and Taking Screen Short");
            System.out.println("j. Exit");

            System.out.print("Enter your choice (a/b/c/d/e/f/g/h/i/j): ");
            String choice = scanner.nextLine().trim().toLowerCase();

            try {
                switch (choice) {
                    case "a":
                        if (driver != null) driver.quit();
                        driver = new ChromeDriver();
                        driver.get("https://www.google.com");
                        driver.manage().window().maximize();
                        break;

                    case "b":
                        if (driver != null) driver.quit();
                        driver = new ChromeDriver();
                        driver.get("https://www.kluniversity.in");
                        driver.manage().window().maximize();
                        break;

                    case "c":
                        if (driver != null) driver.quit();
                        driver = new ChromeDriver();
                        driver.get("https://github.com/login");

                        WebElement usernameFieldC = driver.findElement(By.id("login_field"));
                        WebElement passwordFieldC = driver.findElement(By.id("password"));

                        usernameFieldC.sendKeys("annepuuday111@gmail.com");
                        passwordFieldC.sendKeys("Uday@2215302");

                        highlight(driver, usernameFieldC);
                        highlight(driver, passwordFieldC);

                        WebElement signInButtonC = driver.findElement(By.name("commit"));
                        signInButtonC.click();

                        Thread.sleep(2000);

                        if (driver.getCurrentUrl().equals("https://github.com/")) {
                            System.out.println("Login successful, navigating to the requested page.");
                        } else {
                            System.out.println("Login failed.");
                        }
                        break;

                    case "d":
                        if (driver != null) driver.quit();
                        driver = new ChromeDriver();
                        driver.get("https://github.com/login");

                        WebElement usernameFieldD = driver.findElement(By.id("login_field"));
                        WebElement passwordFieldD = driver.findElement(By.id("password"));

                        usernameFieldD.sendKeys("annepuuday111@gmail.com");
                        passwordFieldD.sendKeys("Uday@2215301");

                        highlight(driver, usernameFieldD);
                        highlight(driver, passwordFieldD);

                        WebElement signInButtonD = driver.findElement(By.name("commit"));
                        signInButtonD.click();

                        Thread.sleep(2000);

                        try {
                            WebElement errorMessage = driver.findElement(By.xpath("//div[contains(@class, 'flash-error')]"));
                            System.out.println("Login failed: " + errorMessage.getText());
                        } catch (NoSuchElementException e) {
                            System.out.println("Error message not found. Login attempt failed.");
                        }
                        break;

                    case "e":
                        if (driver != null) driver.quit();
                        driver = new ChromeDriver();
                        driver.get("https://www.amazon.com");
                        driver.manage().window().maximize();
                        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
                        searchBox.sendKeys("Books");
                        searchBox.submit();
                        break;

                    case "f":
                        if (driver != null) driver.quit();
                        driver = new ChromeDriver();
                        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                        String checkboxUrl = "file:///Users/annepuudaykumar/Downloads/checkbox_test.html";
                        driver.get(checkboxUrl);
                        driver.manage().window().maximize();

                        WebElement checkbox1 = driver.findElement(By.id("checkbox1"));
                        WebElement checkbox2 = driver.findElement(By.id("checkbox2"));
                        WebElement checkbox3 = driver.findElement(By.id("checkbox3"));

                        if (!checkbox1.isSelected()) checkbox1.click();
                        if (!checkbox2.isSelected()) checkbox2.click();
                        if (!checkbox3.isSelected()) checkbox3.click();

                        System.out.println("Checkbox 1 selected: " + checkbox1.isSelected());
                        System.out.println("Checkbox 2 selected: " + checkbox2.isSelected());
                        System.out.println("Checkbox 3 selected: " + checkbox3.isSelected());
                        break;

                    case "g":
                        if (driver != null) driver.quit();
                        driver = new ChromeDriver();
                        driver.manage().window().maximize();
                        driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
                        pause();

                        System.out.println(driver.findElement(By.id("output")).getText());
                        driver.findElement(By.id("alertBox")).click();
                        pause();

                        System.out.println(driver.switchTo().alert().getText());
                        pause();
                        driver.switchTo().alert().accept();
                        pause();
                        System.out.println(driver.findElement(By.id("output")).getText());
                        driver.quit();
                        break;

                    case "h":
                        if (driver != null) driver.quit();
                        driver = new ChromeDriver();
                        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                        String dropdownUrl = "file:///Users/annepuudaykumar/Documents/F Drive/KL University/3RD YEAR/Odd Sem/Software Testing/HtmlDropDown.html"; // Update the path as needed
                        driver.get(dropdownUrl);
                        driver.manage().window().maximize();

                        WebElement singleDropdownBtn = driver.findElement(By.className("single-btn"));
                        singleDropdownBtn.click();

                        WebElement singleDropdown = driver.findElement(By.id("single-select"));
                        Select singleSelect = new Select(singleDropdown);
                        singleSelect.selectByVisibleText("Option 2");
                        System.out.println("Single Selection: Option 2 selected");

                        WebElement multiDropdownBtn = driver.findElement(By.className("multi-btn"));
                        multiDropdownBtn.click();

                        WebElement multiDropdown = driver.findElement(By.id("multi-select"));
                        Select multiSelect = new Select(multiDropdown);
                        multiSelect.selectByVisibleText("Option 1");
                        multiSelect.selectByVisibleText("Option 3");
                        multiSelect.selectByVisibleText("Option 5");
                        System.out.println("Multi Selection: Option 1, Option 3, and Option 5 selected");

                        System.out.println("Is Option 1 selected in multi-select: " + multiSelect.getOptions().get(0).isSelected());
                        System.out.println("Is Option 3 selected in multi-select: " + multiSelect.getOptions().get(2).isSelected());
                        System.out.println("Is Option 5 selected in multi-select: " + multiSelect.getOptions().get(4).isSelected());
                        driver.quit();
                        break;

                    case "i":
                        if (driver != null) driver.quit();
                        driver = new ChromeDriver();
                        driver.get("https://github.com/login");
                        driver.manage().window().maximize();

                        WebElement usernameField = driver.findElement(By.id("login_field"));
                        usernameField.sendKeys("annepuuday111");

                        WebElement passwordField = driver.findElement(By.id("password"));
                        passwordField.sendKeys("uday@2215302");

                        WebElement loginButton = driver.findElement(By.name("commit"));
                        loginButton.click();

                        driver.get("https://github.com/Annepuuday111/Demo-22CS2242F/upload/main");

                        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
                        fileInput.sendKeys("/path/to/your/project.zip");

                        WebElement commitMessage = driver.findElement(By.xpath("//textarea[@name='commit_message']"));
                        commitMessage.sendKeys("Uploading project via Selenium");

                        WebElement commitButton = driver.findElement(By.xpath("//button[contains(text(), 'Commit changes')]"));
                        commitButton.click();

                        try {
                            Thread.sleep(5000);

                            TakesScreenshot ts = (TakesScreenshot) driver;
                            File screenshot = ts.getScreenshotAs(OutputType.FILE);

                            File screenshotLocation = new File("./ScreenShot/UploadedSuccessfullyToGit.png");
                            screenshotLocation.getParentFile().mkdirs();

                            FileUtils.copyFile(screenshot, screenshotLocation);
                            System.out.println("Screenshot taken and saved at: " + screenshotLocation.getAbsolutePath());

                        } catch (Exception e) {
                            System.out.println("An error occurred while taking the screenshot: " + e.getMessage());
                        }

                        break;


                    case "j":
                        System.out.println("Exiting the program.");
                        if (driver != null) driver.quit();
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private static void highlight(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    private static void takeScreenshot(WebDriver driver, String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("./ScreenShot/" + fileName));
        } catch (IOException e) {
            System.out.println("Error saving screenshot: " + e.getMessage());
        }
    }

    private static void pause() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
