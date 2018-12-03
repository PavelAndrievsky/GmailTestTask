package framework.elements;

import org.openqa.selenium.By;

public class CheckBox extends BaseElement {

    private String type;

    public CheckBox(By locator) {
        super(locator);
        type="checkbox";
    }

    public String getType(){
        return this.type;
    }

}
