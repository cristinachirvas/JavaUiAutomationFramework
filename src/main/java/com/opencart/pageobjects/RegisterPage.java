package com.opencart.pageobjects;

import com.opencart.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page{
    public RegisterPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//input[@id='input-firstname']")
    private WebElement firstNameInput;
    @FindBy(xpath = "//input[@id='input-lastname']")
    private WebElement lastNameInput;
    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@name='agree']")
    private WebElement privacyToggle;
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    private WebElement continueBtn;

    public void fillInTheRegisterForm(String firstname, String lastname, String email, String password, boolean toggle) {
        firstNameInput.sendKeys(firstname);
        lastNameInput.sendKeys(lastname);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);

        if (toggle){
            try {
                ScrollManager.scrollToTheElement(privacyToggle);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            privacyToggle.click();
        }
    }

    public void clickTheContinueButton(){
        continueBtn.click();
    }
}
