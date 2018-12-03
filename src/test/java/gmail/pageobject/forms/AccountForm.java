package gmail.pageobject.forms;

import framework.BaseForm;
import framework.elements.Button;
import framework.elements.CheckBox;
import framework.elements.Label;
import gmail.entities.Message;
import gmail.functions.CommonFunctions;
import org.openqa.selenium.By;

import java.util.List;

public class AccountForm extends BaseForm {

    private static final String account = "//span[@class='gb_ab gbii']/parent::a";
    private Button btnAccount = new Button(By.xpath(account));
    private static final String email = "//div[@class='gb_Fb']";
    private Label labelEmail = new Label(By.xpath(email));

    private static final String recipient = "//textarea[@aria-label='Кому']";
    private Label labelRecipient = new Label(By.xpath(recipient));

    private static final String topic = "//input[@placeholder='Тема']";
    private Label labelTopic = new Label(By.xpath(topic));

    private static final String messageArea = "//div[@aria-label='Тело письма']";
    private Label labelMessage = new Label(By.xpath(messageArea));

    private static final String write = "//div[contains(text(),'Написать') and @role='button']";
    private Button btnWrite = new Button(By.xpath(write));

    private static final String send = "//div[contains(text(),'Отправить')]";
    private Button btnSend = new Button(By.xpath(send));

    private static final String newMess = "//*[@id='link_vsm']";
    private Label lblNewMess = new Label(By.xpath(newMess));

    private static final String checkBox = "(//div[@class='BltHke nH oy8Mbf aE3']//div[@role='checkbox'])[%d]";

    private static final String deleteBtn = "//div[@class='aeH']/div[1]/div/div[1]/div/div/div[2]/div[3]/div/div";
    private Button btnDelete = new Button(By.xpath(deleteBtn));


    private static final String lastEmail = "//div[@class='ae4 aDM']//tbody/tr//div[@class='yW']//span[@email]";
    private Label lblLastEmail = new Label(By.xpath(lastEmail));
    private static final String lastTopic = "//div[@class='ae4 aDM']//tbody/tr//td[@class='xY a4W']//span[@data-thread-id]";
    private Label lblLastTopic = new Label(By.xpath(lastTopic));
    private static final String lastText = "//div[@class='ae4 aDM']//tbody/tr//span[@class='Zt']/parent::span";
    private Label lblLastText = new Label(By.xpath(lastText));
    private static final String lastDate = "//div[@class='ae4 aDM']//tbody/tr//td[@class='xW xY ']/span";
    private Label lblLastDate = new Label(By.xpath(lastDate));

    private static final String incomingMess = "//div[@class='ae4 aDM']//tr";
    private Label allMess = new Label(By.xpath(incomingMess));

    private static final String fullList = "//span[@class='ait']/div";
    private Label lblFullList = new Label(By.xpath(fullList));
    private static final String trash = "//a[text()='Корзина']";
    private Label lblTrash = new Label(By.xpath(trash));

    private CommonFunctions commonFunctions = new CommonFunctions();

    /**
     * Переменная, которая запоминает количество сообщений после успешного появления отправленного сообщения
     */
    private int kol;


    public AccountForm() {
        super(By.xpath("//input[@aria-label='Поиск в почте']"));
    }

    public void clickAccount() {
        btnAccount.waitBeClickable();
        btnAccount.click();
    }

    public boolean getEmail() {
        boolean result;
        String expectedEmail = configFile.getConfigProperty("email");
        String email;
        email = labelEmail.getText();
        result = expectedEmail.equals(email);
        return result;
    }

    public void clickOnTheWrite() {
        btnWrite.clickAndWait();
    }

    public Message writeMessage() {
        labelRecipient.waitBeClickable();
        String email = configFile.getConfigProperty("email");
        String topic = configFile.getConfigProperty("topic");
        String message = configFile.getConfigProperty("message");
        labelRecipient.sendKeys(email);
        labelTopic.sendKeys(topic);
        labelMessage.sendKeys(message);
        Message mess = new Message(email, topic, message);
        btnSend.clickAndWait();

        lblNewMess.waitBeClickable();
        List<Label> labelList = allMess.getConvertedElements(incomingMess);
        kol = labelList.size();

        lblNewMess.clickViaAction();

        return mess;
    }

    public void deleteMail(Message mess) {

        lblLastEmail.waitBeClickable();
        lblLastTopic.waitBeClickable();
        lblLastText.waitBeClickable();
        lblLastDate.waitBeClickable();
        List<String> emails;
        List<String> topics;
        List<String> texts;
        List<String> dates;

        emails = lblLastEmail.getListOfAttribute("email");
        topics = lblLastTopic.getListOfContent();
        texts = commonFunctions.getListOfTexts(lblLastText);
        dates = commonFunctions.getListOfDates(lblLastDate);

        int begin;
        if (emails.size() == kol) {
            begin = 0;
        } else begin = emails.size() - kol;

        for (int i = begin; i < emails.size(); i++) {
            if ((emails.get(i).equals(mess.getRecipient()) && (topics.get(i).equals(mess.getTopic())) &&
                    (texts.get(i).equals(mess.getText())) && (dates.get(i).equals(mess.getDate())))) {
                String box = String.format(checkBox, i + 1);
                CheckBox checkBox = new CheckBox(By.xpath(box));
                checkBox.waitBeClickable();
                checkBox.click();
                btnDelete.waitBeClickable();
                btnDelete.clickViaAction();
                break;
            }
        }

    }

    public void goToTheTrash() {
        lblFullList.click();
        lblTrash.click();
    }

}
