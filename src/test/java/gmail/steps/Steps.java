package gmail.steps;

import cucumber.api.java.en.Then;
import gmail.entities.Message;
import gmail.pageobject.forms.*;
import gmail.pageobject.menu.Menu;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import framework.BaseForm;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class Steps {

    private MainForm mainForm;
    private LoginForm loginForm;
    private AccountForm accountForm;
    private MessageForm messageForm;
    private TrashForm trashForm;
    private static List<Message> messages = new ArrayList<>();
    private Message message;

    static SoftAssert softAssert = new SoftAssert();

    @Given("^Open https://www.google.com/intl/ru/gmail/about/#$")
    public void openMainPage() {
        mainForm = new MainForm();
    }

    @When("^Select Login tab$")
    public void navigateMenu() {
        BaseForm.menu.navigateMenu(Menu.MenuItem.LOGIN);
    }

    @Then("^The LoginEmail page opens$")
    public void researchOpens(){
        loginForm = new LoginForm();
    }

    @When("^Fill email field and click next$")
    public void clickOnTheLogin() {
        loginForm.logIn();
    }

    @Then("^The Account page opens$")
    public void theAccountPageOpens() {
        accountForm = new AccountForm();
    }

    @When("^Click on the Account$")
    public void clickOnTheAccount() {
        accountForm.clickAccount();
    }

    @Then("^Check the email$")
    public void checkTheEmail() {
        Assert.assertTrue(accountForm.getEmail());
    }

    @When("^Click on the Write button and write message$")
    public void clickOnTheWriteAndWrite() {
        accountForm.clickOnTheWrite();
        message = accountForm.writeMessage();
        messages.add(message);
    }

    @Then("^Opening a sent message and verify it$")
    public void verifySendingMail() {
        messageForm = new MessageForm();
        Message checkMessage;
        checkMessage = messageForm.verifySending();
        messages.add(checkMessage);
        Assert.assertTrue(messages.get(0).equals(messages.get(1)));
    }

    @When("^Remove from the list of incoming mail$")
    public void removeFromTheListOfIncomingMail() {
        accountForm.deleteMail(messages.get(1));
        accountForm.goToTheTrash();
    }

    @Then("^Open the Trash and check the successful removal$")
    public void checkTheSuccessfulRemoval() {
        trashForm = new TrashForm();
        Assert.assertTrue(trashForm.checkSuccessfulDelete(messages.get(1)));
    }
}