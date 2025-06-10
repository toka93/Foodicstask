package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage  extends BasePage {
        private final By emailInput = By.id("ap_email_login");
        private final By continueBtn = By.id("continue");
        private final By passwordInput = By.id("ap_password");
        private final By signInSubmit = By.id("signInSubmit");
        private final By signInBtn = By.id("nav-link-accountList-nav-line-1");


        public LoginPage(WebDriver driver) {
            super(driver);
        }

        public void login(String email, String password) {
           click(signInBtn);
            type(emailInput, email);
            click(continueBtn);
            type(passwordInput, password);
            click(signInSubmit);
        }
    }
