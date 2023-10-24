package com.opencart;
import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class TestRegistrationFlowWithJunit {
    WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;
   @BeforeAll
   public static void executeThisMethodBeforeAllTheTests() {
       System.out.println("The execution of the test suite has started");
   }
   @BeforeEach
   public void executeThisMethodBeforeEachTest() {
       System.out.println("The code is executed before each test case");
       driver = DriverManager.getInstance().getDriver();
       driver.get("https://andreisecuqa.host/");
       homePage = new HomePage(driver);
       registerPage = new RegisterPage(driver);
       homePage.navigateToRegisterPageFromHeader();
   }
   @Test
   @DisplayName("The registration of a new user with valid data redirects to the Account Page")
   public void registerWithValidCredentialsTest() throws InterruptedException {
       System.out.println("This is the test number 1");

       String randomEmail = RandomDataManager.generateRandomEmail();
       String password = RandomDataManager.generatePassword();

       System.out.println(randomEmail);
       System.out.println(password);

       registerPage.fillInTheRegisterForm(RandomDataManager.generateFirstName(),
               RandomDataManager.generateLastName(), randomEmail, password,true);

       registerPage.clickTheContinueButton();

       Thread.sleep(500);
       String currentUrl = driver.getCurrentUrl();
       boolean doesTheCorrectUrlContainSuccessAccountRoute = currentUrl.contains("route=account/success");
       Assertions.assertTrue(doesTheCorrectUrlContainSuccessAccountRoute, "The current Url:" + currentUrl + " contains: route=account/success");
   }
    @Test
    @DisplayName("The user is remaining on register page trying")
    public void registerWithInvalidPasswordTest() throws InterruptedException {
        System.out.println("This is the test number 2");

        String randomEmail = RandomDataManager.generateRandomEmail();

        System.out.println(randomEmail);

        registerPage.fillInTheRegisterForm(RandomDataManager.generateFirstName(),
                RandomDataManager.generateLastName(), randomEmail, "123",true);

        registerPage.clickTheContinueButton();
        Thread.sleep(500);

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://andreisecuqa.host/index.php?route=account/register&language=en-gb";
        Assertions.assertEquals(expectedUrl, actualUrl, "The Urls should be equal");
    }

    @Test
    @DisplayName("Error message is displayed on Register flow when password is less than 4 chars")
    public void errorMessageIsDisplayedWhenInvalidPasswordIsUsedForRegisterFlow() throws InterruptedException {
        System.out.println("This is the test number 3");

        String randomEmail = RandomDataManager.generateRandomEmail();

        System.out.println(randomEmail);

        registerPage.fillInTheRegisterForm(RandomDataManager.generateFirstName(),
                RandomDataManager.generateLastName(), randomEmail, "123",true);

        registerPage.clickTheContinueButton();
        Thread.sleep(500);

        String expectedErrorMessageForInvalidPassword = "Password must be between 4 and 20 characters!";
        String actualErrorMessage = driver.findElement(By.id("error-password")).getText();

        Assertions.assertEquals(expectedErrorMessageForInvalidPassword, actualErrorMessage);
    }
    @AfterEach
    public void afterEachTestCase() {
        DriverManager.getInstance().tearDown();
        System.out.println("The test case execution has been finished");
    }
    @AfterAll
    public static void afterAllMethod() {
        System.out.println("The test suite execution has been finished");
    }

}
