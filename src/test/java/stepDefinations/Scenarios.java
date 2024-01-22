package stepDefinations;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public final class Scenarios {
    private WebDriver driver = null;

    //Launching the browser and website
    @Given("^User navigated to the OrangeHRM URL \\\"([^\\\"]*)\\\"$")
    public void user_navigated_to_the_OrangeHRM_URL(String arg1) {
        System.setProperty("webdriver.chrome.driver",
                "D:/OrangeHRM/orangeHRM/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(arg1);
    }

    //Entering User name nad password
    @When("^User specify Username as \\\"([^\\\"]*)\\\" and Password as \\\"([^\\\"]*)\\\"$")
    public void i_specify_Username_as_xxxxxxxxxxxxxxxxxxxx_and_Password_as_xxx(String arg1, String arg2) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("((//div[@class='oxd-form-row'])[1])/div/div/input[@name='username']")).sendKeys(arg1);
        driver.findElement(By.xpath("((//div[@class='oxd-form-row'])[2])/div/div/input")).sendKeys(arg2);
    }

    // Click on login Button
    @When("^Click on login  button$")
    public void click_on_login_button() {

        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

    //Clicks on Recruitement button after scrolling to it
    @Given("^User Clicks on the Recruitment button$")
    public void user_Clicks_on_the_Recruitment_button() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement recruitment =
                driver.findElement(By.xpath("(//ul[@class='oxd-main-menu']/li)[5]/a/span"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", recruitment);
        recruitment.click();
    }

    // Clicks on the vacancies
    @When("^User Clicks on Vacancies$")
    public void user_Clicks_on_Vacancies() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(text(),'Vacancies')]")).click();

    }

    // Search with data and record matching with data string
    @When("^Search with \\\"([^\\\"]*)\\\" and records should be displayed$")
    public void search_with_Associate_IT_Manager_and_records_should_be_displayed(String arg1) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement sendInDropDown = driver.findElement(By.xpath("(((//div[@class='oxd-select-wrapper'])[2])/div/div)[1]"));
        executor.executeScript("arguments[0].click();", sendInDropDown);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        sendInDropDown.sendKeys("a");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        sendInDropDown.sendKeys(Keys.ENTER);

        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit' and @class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
        Actions act = new Actions(driver);
        act.doubleClick(searchButton).perform();
        String value = driver.findElement(By.xpath("(//div[@class='oxd-table-cell oxd-padding-cell'])[2]/div")).getText();
        System.out.println("Fetched vacancy"+value);
        Assert.assertEquals(arg1, value);
    }

    @Then("^Logout$")
    public void logout() {
        WebElement logoutButton = driver.findElement(By.xpath("//div[@id=\"welcome-menu\"]/ul/li[2]/a"));
        logoutButton.click();
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }


}
