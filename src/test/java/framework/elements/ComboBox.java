package framework.elements;

import org.openqa.selenium.By;

public class ComboBox extends BaseElement {

    private String type;

    public ComboBox(By locator) {
        super(locator);
        type="combobox";
    }

    public String getType(){
        return this.type;
    }

}
