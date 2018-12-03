package gmail.pageobject.forms;

import framework.BaseForm;
import framework.elements.Button;
import framework.elements.Label;
import gmail.entities.Message;
import org.openqa.selenium.By;

public class MessageForm extends BaseForm {

    private static final String messEmail = "//div[@class='gE iv gt']//span[@class='qu']/span";
    private Label lblNewMessEmail = new Label(By.xpath(messEmail));
    private static final String messTopic = "//span[@class='J-J5-Ji']/preceding-sibling::*";
    private Label lblNewMessTopic = new Label(By.xpath(messTopic));
    private static final String messText= "//div[@class='a3s aXjCH ']/div[@dir]";
    private Label lblNewMessText = new Label(By.xpath(messText));
    private static final String messDate = "//div[@class='gK']/span[@id]";
    private Label lblNewMessDate = new Label(By.xpath(messDate));

    private static final String incoming = "a[title^='Входящие']";
    private Button btnIncoming = new Button(By.cssSelector(incoming));

    public MessageForm() {
        super(By.xpath("//img[@alt='Печатать все']"));
    }

    public Message verifySending() {
        String checkEmail, checkTopic, checkText, date;
        checkEmail = lblNewMessEmail.getAttribute("email");
        lblNewMessTopic.waitBeClickable();
        checkTopic = lblNewMessTopic.getAttribute("innerHTML");
        lblNewMessText.waitBeClickable();
        checkText = lblNewMessText.getText();
        date = lblNewMessDate.getAttribute("title");
        Message checkMess = new Message(checkEmail, checkTopic, checkText, date);
        btnIncoming.waitBeClickable();
        btnIncoming.click();
        return checkMess;
    }

}
