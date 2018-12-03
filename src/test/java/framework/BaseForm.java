package framework;

import gmail.pageobject.menu.Menu;
import framework.elements.Label;
import org.openqa.selenium.By;

public class BaseForm extends BaseEntity {

    private By titleLocator;
    private Label labelElement;

    public static Menu menu = new Menu();

    public BaseForm(By titleLocator) {
        this.titleLocator = titleLocator;
        assertIsOpen();
    }

    private void assertIsOpen() {
        labelElement = new Label(titleLocator);
        assertTrue(labelElement.assertIsVisible());
    }
}
