import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.ExpectedConditions;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyStepdefs {
    private String email;
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    @Given("I am at basketballengland")
    public void iAmAtBasketballengland() {
        driver = new ChromeDriver();
        driver.get("https://membership.basketballengland.co.uk/");
        driver.manage().window().maximize();

    }

    @When("I create an account")
    public void iCreateAnAccount() throws InterruptedException {

        driver.findElement(By.cssSelector("a[href='/join']")).click();
        driver.findElement(By.cssSelector("a[href='/NewSupporterAccount']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("dp")).sendKeys("01/01/2000");
        driver.findElement(By.id("member_firstname")).sendKeys("Kalle");
        driver.findElement(By.id("member_lastname")).sendKeys("Nilson");
        WebElement emailField = driver.findElement(By.id("member_emailaddress"));
        emailField.sendKeys("KalleNils7n@mailnesia.com");
        WebElement emailFieldConfrim = driver.findElement(By.id("member_confirmemailaddress"));
        emailFieldConfrim.sendKeys("KalleNils7n@mailnesia.com");
        driver.findElement(By.id("signupunlicenced_password"))
                .sendKeys("abc123456789");
        driver.findElement(By.id("signupunlicenced_confirmpassword"))
                .sendKeys("abc123456789");
        Thread.sleep(2000);
    }
    @When("I try to create an account without last name")
    public void iTryToCreateAnAccountWithoutLastName() {
        driver.findElement(By.cssSelector("a[href='/join']")).click();
        driver.findElement(By.cssSelector("a[href='/NewSupporterAccount']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("dp")).sendKeys("01/01/2000");
        driver.findElement(By.id("member_firstname")).sendKeys("Olle");

        WebElement emailField = driver.findElement(By.id("member_emailaddress"));
        emailField.sendKeys("KalleNils7n@mailnesia.com");
        WebElement emailFieldConfrim = driver.findElement(By.id("member_confirmemailaddress"));
        emailFieldConfrim.sendKeys("KalleNils7n@mailnesia.com");
        driver.findElement(By.id("signupunlicenced_password"))
                .sendKeys("abc123456789");
        driver.findElement(By.id("signupunlicenced_confirmpassword"))
                .sendKeys("abc123456789");

    }

    @And("The user select terms and conditions")
    public void theUserSelectTermsAndConditions() throws InterruptedException {
        driver.findElement(By.cssSelector("label[for='sign_up_25']")).click();
    }

    @And("I am aged over {int} or am a person with parental responsibility")
    public void iAmAgedOverOrAmAPersonWithParentalResponsibility(int arg0) {
        driver.findElement(By.cssSelector("label[for='sign_up_26']")).click();
    }

    @And("I have read, understood and agree to adhere to the Basketball England Code of Ethics and Conduct")
    public void iHaveReadUnderstoodAndAgreeToAdhereToTheBasketballEnglandCodeOfEthicsAndConduct() {
        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct']")).click();
    }

    @And("Confirm and submit btn")
    public void confrimAndSubmitBtn() {
        driver.findElement(By.cssSelector("input.btn.btn-big.red")).click();
    }


    @Then("The user see the Successful registration")
    public void theUserSeeTheSuccessfulRegistration() {

        WebElement message = driver.findElement(By.xpath("//h2[text()='THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND']"));

    }

    @Then("The user sees a message that last name is required")
    public void theUserSeesAMessageThatLastNameIsRequired(String PasswordNeeds) {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'" + PasswordNeeds + "')]")
        ));
        assertTrue(message.isDisplayed());
        driver.quit(); // Stäng webbläsaren efter testet

    }

    @When("I create an account without confrim pass")
    public void iCreateAnAccountWithoutConfrimPass() {
        driver.findElement(By.cssSelector("a[href='/join']")).click();
        driver.findElement(By.cssSelector("a[href='/NewSupporterAccount']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("dp")).sendKeys("01/01/2000");
        driver.findElement(By.id("member_firstname")).sendKeys("Olle");
        driver.findElement(By.id("member_lastname")).sendKeys("Nilson");
        WebElement emailField = driver.findElement(By.id("member_emailaddress"));
        emailField.sendKeys("KalleNils7n@mailnesia.com");
        WebElement emailFieldConfrim = driver.findElement(By.id("member_confirmemailaddress"));
        emailFieldConfrim.sendKeys("KalleNils7n@mailnesia.com");
        driver.findElement(By.id("signupunlicenced_password"))
                .sendKeys("abc123456789");
//        driver.findElement(By.id("signupunlicenced_confirmpassword"))
//                .sendKeys("abc123456789");
    }

    @Then("The user sees a message that password confirmation does not match")
    public void theUserSeesAMessageThatPasswordConfirmationDoesNotMatch() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Password confirmation does not match')]")
        ));
        assertTrue(message.isDisplayed());
        driver.quit();
    }

    @When("I create an account without accepting terms and conditions")
    public void iCreateAnAccountWithoutAcceptingTermsAndConditions() {
        driver.findElement(By.cssSelector("a[href='/join']")).click();
        driver.findElement(By.cssSelector("a[href='/NewSupporterAccount']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("dp")).sendKeys("01/01/2000");

        driver.findElement(By.id("member_firstname")).sendKeys("Kalle");
        driver.findElement(By.id("member_lastname")).sendKeys("Nilson");
        WebElement emailField = driver.findElement(By.id("member_emailaddress"));
        emailField.sendKeys("KalleNils7n@mailnesia.com");
        WebElement emailFieldConfrim = driver.findElement(By.id("member_confirmemailaddress"));
        emailFieldConfrim.sendKeys("KalleNils7n@mailnesia.com");
        driver.findElement(By.id("signupunlicenced_password"))
                .sendKeys("abc123456789");
        driver.findElement(By.id("signupunlicenced_confirmpassword"))
                .sendKeys("abc123456789");
    }

    @Then("The user sees a message that terms and conditions must be accepted")
    public void theUserSeesAMessageThatTermsAndConditionsMustBeAccepted() throws InterruptedException {
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(2) > div:nth-child(1) > span > span")));

        assertTrue(error.isDisplayed());
        System.out.println("Felmeddelande: " + error.getText());
    }
}



