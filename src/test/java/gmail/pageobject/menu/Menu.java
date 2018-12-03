package gmail.pageobject.menu;

import framework.elements.Label;
import org.openqa.selenium.By;

public class Menu {

    private static final String tabsLocator = "//div[@class='gmail-nav__nav-links-wrap']//a[contains(text(), '%s')]";

    public enum MenuItem {
        BUSINESS("Для бизнеса"),
        LOGIN("Войти"),
        NEWACCOUNT("Создать аккаунт");

        private String name;

        MenuItem(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public Menu() {
    }

    public void navigateMenu(MenuItem concreteItem){
        new Label(By.xpath(String.format(tabsLocator,concreteItem.getName()))).click();
    }

}
