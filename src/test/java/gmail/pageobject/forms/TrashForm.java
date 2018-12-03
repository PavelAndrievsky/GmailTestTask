package gmail.pageobject.forms;

import framework.BaseForm;
import framework.elements.Label;
import gmail.entities.Message;
import gmail.functions.CommonFunctions;
import org.openqa.selenium.By;

import java.util.List;

public class TrashForm extends BaseForm {

    private static final String trashEmail = "//div[@class='ya']/parent::div/following::div//tbody/tr//div[@class='yW']//span[@email]";
    private Label lblTrashEmail = new Label(By.xpath(trashEmail));
    private static final String trashTopic = "//div[@class='ya']/parent::div/following::div//tbody/tr//td[@class='xY a4W']//span[@data-thread-id]";
    private Label lblTrashTopic = new Label(By.xpath(trashTopic));
    private static final String trashText = "//div[@class='ya']/parent::div/following::div//tbody/tr//span[@class='Zt']/parent::span";
    private Label lblTrashText = new Label(By.xpath(trashText));
    private static final String trashDate = "//div[@class='ya']/parent::div/following::div//tbody/tr//td[@class='xW xY ']/span";
    private Label lblTrashDate = new Label(By.xpath(trashDate));

    private CommonFunctions commonFunctions = new CommonFunctions();

    public TrashForm() {
        super(By.xpath("//span[text()='Очистить корзину']"));
    }

    public Boolean checkSuccessfulDelete(Message mess) {
        lblTrashEmail.waitBeClickable();
        List<String> emails;
        List<String> topics;
        List<String> texts;
        List<String> dates;

        emails = lblTrashEmail.getListOfAttribute("email");
        topics = lblTrashTopic.getListOfContent();
        texts = commonFunctions.getListOfTexts(lblTrashText);
        dates = commonFunctions.getListOfDates(lblTrashDate);

        boolean result = false;

        for (int i = 0; i < emails.size(); i++) {
            if ((emails.get(i).equals(mess.getRecipient()) && (topics.get(i).equals(mess.getTopic())) &&
                    (texts.get(i).equals(mess.getText())) && (dates.get(i).equals(mess.getDate())))) {
                result = true;
                break;
            }
        }
        return result;
    }
}
