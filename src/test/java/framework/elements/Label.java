package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Label extends BaseElement {

    private String type;

    public Label(By locator) {
        super(locator);
        type = "label";
    }

    public Label(WebElement element) {
        super(element);
    }

    public List<Label> getConvertedElements(String by) {
        List<WebElement> webElementList = getElements(By.xpath(by));
        List<Label> labelList = new ArrayList<>();
        for (WebElement webEl : webElementList) {
            labelList.add(new Label(webEl));
        }
        return labelList;
    }

    public String getType() {
        return this.type;
    }

}
