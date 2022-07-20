package com.ita.speakukrainian.cucumber.steps_definitions;

import com.ita.speakukrainian.cucumber.cucumberTestRunner.BaseDefinition;
import com.ita.speakukrainian.cucumber.cucumberTestRunner.PageContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class RestorePasswordEmailFieldValidation {
    private BaseDefinition baseDef;
    private PageContext pageContext;
    private final SoftAssert softAssert;

    public RestorePasswordEmailFieldValidation(BaseDefinition baseDef) {
        this.baseDef = baseDef;
        pageContext = new PageContext(baseDef.getDriver());
        softAssert = new SoftAssert();
    }

    @Given("Click on Guest DropDown icon")
    public void clickOnGuestDropDownIcon() {
        pageContext.getAllPages()
                .getHeaderMenuComponent()
                .clickUserProFileButton()
                .clickSingInButton().sendKeysEmail(baseDef.getValueProvider().getAdminEmail())
                .sendKeysPassword(baseDef.getValueProvider().getAdminPassword())
                .clickLoginButton();


    }

    @When("enterExtendedSearchButton")
    public void clickExtendedSearchButton() {
        pageContext.getAllPages().getHeaderMenuComponent().clickExtendedSearchButton();
    }

    @And("Fill data in field {ages} check if the {expected} is shown")
    public void fillInvalidDataInFieldFieldPhoneCheckIfTheMessageIsShown(String[] ages, String[] expected) {
        System.out.println("fillInvalidDataInFieldFieldPhoneCheckIfTheMessageIsShown");
        for (int i = 0; i < ages.length; i++) {
            System.out.println(ages[i] + "  " + expected[i]);
            softAssert.assertEquals(pageContext.getAllPages().getClubsPage().fillInAgeInput(ages[i]).readAgeInput(), expected[i]);
            pageContext.getAllPages().getClubsPage().deleteText(pageContext.getAllPages().getClubsPage().getAgeInput());
            softAssert.assertAll();
        }


    }

}

