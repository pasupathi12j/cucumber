package com.qa.pages.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='username']")
    protected WebElement txtUserName;
    @FindBy(xpath = "//input[@id='password']")
    protected WebElement txtPassword;
    @FindBy(xpath = "//button[@type='submit']")
    protected WebElement btnLogin;
    @FindBy(xpath = "//div[text()='Logged in as Data Entry Operator']")
    protected WebElement txtUserVerification;

    public LoginPage userName(String value) {
        click(txtUserName);
        sendKeys(txtUserName, value);
        return this;
    }

    public LoginPage passWord(String value) {
        sendKeys(txtPassword, value);
        return this;
    }

    public void login() {

        click(btnLogin);
    }

    public String getDetails() {

        return txtUserVerification.getText();
    }

}
