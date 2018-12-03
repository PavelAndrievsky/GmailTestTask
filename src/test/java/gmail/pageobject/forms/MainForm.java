package gmail.pageobject.forms;

import framework.BaseForm;
import org.openqa.selenium.By;

public class MainForm extends BaseForm {

    public MainForm() {
        super(By.xpath("//div[contains(text(),'Gmail')]"));
    }

}
