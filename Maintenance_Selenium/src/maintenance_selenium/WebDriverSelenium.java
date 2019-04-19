/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maintenance_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author minarafla
 */
public class WebDriverSelenium {
    
    public static void startAutomationTesting()throws Exception{
        
        JSONStudentReader j = new JSONStudentReader();
        j.readJson("automatedTestCases.json");
        
        System.setProperty("webdriver.mozilla.driver", "geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("file:///Users/minarafla/Documents/ASU/Senior2Semester2/Sw Maintenance/Maintenance_Selenium/SeleniumAssignment.html");
        fillForm(driver);
        
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.get("file:///Users/minarafla/Documents/ASU/Senior2Semester2/Sw Maintenance/Maintenance_Selenium/SeleniumAssignment.html");
        fillForm(driver);
        driver.quit();
//        
    }
    
    
    public static void fillForm(WebDriver driver)throws Exception{
        

        for (int i = 0; i < JSONStudentReader.students.size(); i++) {

            Student s = JSONStudentReader.students.get(i);

            WebElement element = driver.findElement(By.id("firstname"));
//            Thread.sleep(200);
            element.sendKeys(s.firstname);
            Thread.sleep(200);

            element = driver.findElement(By.id("secondname"));
//            Thread.sleep(200);
            element.sendKeys(s.lastname);
            Thread.sleep(200);

            element = driver.findElement(By.id("studentid"));
//            Thread.sleep(200);
            element.sendKeys(s.studentID);
            Thread.sleep(200);

            element = driver.findElement(By.id("email"));
//            Thread.sleep(200);
            element.sendKeys(s.studentEmail);
            Thread.sleep(200);

            if (s.gender.equals("male")) {
                element = driver.findElement(By.id("gender_male"));
//                Thread.sleep(200);
                element.sendKeys(s.gender);
                Thread.sleep(200);
            } else {
                element = driver.findElement(By.id("gender_female"));
//                Thread.sleep(200);
                element.sendKeys(s.gender);
                Thread.sleep(200);
            }

            Select department = new Select(driver.findElement(By.id("dep")));
            department.selectByVisibleText(s.department);

            element = driver.findElement(By.id("ta"));
            Thread.sleep(1000);
            element.sendKeys(s.reasons);
            Thread.sleep(1000);
            element.submit();
        }
        driver.close();
//        driver.quit();
    }
    
}
