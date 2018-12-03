package gmail.pageobject.forms;

import framework.BaseForm;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class LoginForm extends BaseForm {

    private static final String nextEmail = "//*[@id='identifierNext']/content/span";
    private Button btnNextEmail = new Button(By.xpath(nextEmail));
    private static final String emailField = "//*[@id='identifierId']";
    private Label labelEmail = new Label(By.xpath(emailField));
    private static final String passField = "//div[@id='password']//input";
    private Label labelPass = new Label(By.xpath(passField));
    private static final String nextPass = "//*[@id='passwordNext']/content/span";
    private Button btnNextPass = new Button(By.xpath(nextPass));

    public LoginForm() {
        super(By.xpath("//*[@id='headingText']/content"));
    }

    public void clickNextEmail() {
        btnNextEmail.clickAndWait();
    }

    public void clickNextPass() {
        btnNextPass.clickAndWait();
    }

    public void fillLogin(String type) {
        switch (type) {
            case "email":
                labelEmail.waitBeClickable();
                labelEmail.sendKeys(configFile.getConfigProperty("email"));
                break;
            case "pass":
                labelPass.waitBeClickable();
                labelPass.sendKeys(configFile.getConfigProperty("password"));
                break;
        }
    }

    public void logIn() {
        String emailField = configFile.getConfigProperty("emailField");
        String passField = configFile.getConfigProperty("passwordField");
        fillLogin(emailField);
        clickNextEmail();
        fillLogin(passField);
        clickNextPass();
    }

}
