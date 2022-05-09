package com.ita.speakukrainian.ui.tests;

import com.ita.speakukrainian.ui.SpeakUkrainianRunner;
import com.ita.speakukrainian.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestVerifiesThatErrorMessage177 extends SpeakUkrainianRunner {

    @DataProvider(name = "data1500Symbols")
    public Object[][] dataProvider1500Symbols() {
        Object[][] data = new Object[][]{
                {"лдлстєащтоащлптєдлаьтдлаєдрл5єщо6щощоаотдарощкорщаопщоалє" +
                        "тєлдтєщлрртєщаьтєщрртєщзашщтшвьєщльаркшзщ45лз4щзщщозщ" +
                        "окзщотзщпащізщрєіщорєзщірзщізщоізщнозщнезощзщнонфФокерзщозквп" +
                        "ропіривжпіржшптжітпржіштржщтапщкещкщешрощор9рорщшкорщшщаптьпщлат" +
                        "єдлатєдлаптєлрєдл5646457457длІВВАПРдрлощорщкшорщшкорщшкощершокщш" +
                        "оерщкшоерщшкоерщшокщшреощкшорееищьщапщшркоещршокщшерощкшеорщшо" +
                        "кешрщокщшоерщшкеорщшкоещшрощешорщшкеорщшокешщрощкеорщшкеорщшоке" +
                        "ршокешщшкоерзкеорзкеоз59нш59095нщошреошщрешорешощрешорешощекшщер" +
                        "шоешркшщоркешощкеррешщершщоершощрешреошощшкеорщкшощшорщалпощашо" +
                        "рщшаощршокщшорщшовщшоищшщтдлояжопщшворзщворзщоерзщощшорзуорзуорз" +
                        "оукзщорузщорущорзуозроузорзурооиадлоиавовщаорзщкеорзеуокрзоезрщоз" +
                        "ещорзщокерзщозщеорзщрщоорорщозещзоекщозерщозрщзщозрещзощзврщорв" +
                        "щозращощзорващоркзерщощкшощощрозкщерозкщоерзщокерзщокзерощзкщеорзщкое" +
                        "рзщокерзщокзерозщкоерзщокерощзщкеорзщокерзщоазпщрозкщеоизщкеоотооз" +
                        "щорзещуоизщозщтоезощтзкеозщтоезщкотзктоотокозщеккщезщкщзозтщко" +
                        "зщтпооапщопащщоащоапщзщпзощзтпщозтщотпщощтпощозптщозптщопатщозще" +
                        "орзщкоезщокотозщозщвозщозщзщоиозщуорузщокрзщокрзщоекрзщозкщероз" +
                        "щоерзщкозрщокерощзкщеорзщкозщрокощзщкозщкозщізщкоізщоіезщо" +
                        "ізщеорзщорезщорезщозещорзщокзеорзщкеорзщкоерзщокзеощрзщкоезрщокз" +
                        "еощрзщкеорзщкеорзщокещозщкеозщкеорзщозккоокрозщзкщеозщкеозрщокер" +
                        "зщозещкорзщоекрощзщеозщорзщоекрзщозщкеорзщокеозкеорзщкеозщозщко" +
                        "езрщкорзокщезкзщорзщкорзщкозщерозкщерокзщеорзщкоерзщокзщероощзщк" +
                        "еорзщототокзщоркрщеорзщозщокреощзкщерозщзщокерорзщекорзщокзеорзщк" +
                        "еорзщкоерзщокзеощзщкеозщрокзеорзщкерзщокозщреозкще*)*??"},
        };
        return data;
    }

    @Test(dataProvider = "data1500Symbols")
    public void TestVerifiesTheErrorMessageWhenEnter1500Symbols(String testCaseValue) {
        boolean isDisplayederrorMassage = new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickSingInButton()
                .sendKeysEmail(valueProvider.getAdminEmail())
                .sendKeysPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .header()
                .clickUserProFileButton()
                .clickMyProfileButton()
                .clickAddButton()
                .clickAddClubButton()
                .fillInClubNameInput("Юність")
                .clickOptionCheckboxes(0)
                .fillInAgeFromInput("18")
                .fillInAgeToInput("50")
                .clickNextStepButton()
                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
                .clickNextStepButton()
                .fillInBasicDescriptionInput(testCaseValue)
                .isDisplayedExplainErrorAlotSymbols();

        Assert.assertFalse(isDisplayederrorMassage);

    }

    @DataProvider(name = "dataLess1500Symbols")
    public Object[][] dataProviderLess1500Symbols() {
        Object[][] data = new Object[][]{
                {"лдлстєащтоащлптєдлаьтдлаєдрл5єщо6щощоаотдарощкорщаопщоалє" +
                        "тєлдтєщлрртєщаьтєщрртєщзашщтшвьєщльаркшзщ45лз4щзщщозщ" +
                        "окзщотзщпащізщрєіщорєзщірзщізщоізщнозщнезощзщнонфФокерзщозквп" +
                        "ропіривжпіржшптжітпржіштржщтапщкещкщешрощор9рорщшкорщшщаптьпщлат" +
                        "єдлатєдлаптєлрєдл5646457457длІВВАПРдрлощорщкшорщшкорщшкощершокщш" +
                        "оерщкшоерщшкоерщшокщшреощкшорееищьщапщшркоещршокщшерощкшеорщшо" +
                        "кешрщокщшоерщшкеорщшкоещшрощешорщшкеорщшокешщрощкеорщшкеорщшоке" +
                        "ршокешщшкоерзкеорзкеоз59нш59095нщошреошщрешорешощрешорешощекшщер" +
                        "шоешркшщоркешощкеррешщершщоершощрешреошощшкеорщкшощшорщалпощашо" +
                        "рщшаощршокщшорщшовщшоищшщтдлояжопщшворзщворзщоерзщощшорзуорзуорз" +
                        "оукзщорузщорущорзуозроузорзурооиадлоиавовщаорзщкеорзеуокрзоезрщоз" +
                        "ещорзщокерзщозщеорзщрщоорорщозещзоекщозерщозрщзщозрещзощзврщорв" +
                        "щозращощзорващоркзерщощкшощощрозкщерозкщоерзщокерзщокзерощзкщеорзщкое" +
                        "рзщокерзщокзерозщкоерзщокерощзщкеорзщокерзщоазпщрозкщеоизщкеоотооз" +
                        "щорзещуоизщозщтоезощтзкеозщтоезщкотзктоотокозщеккщезщкщзозтщко" +
                        "зщтпооапщопащщоащоапщзщпзощзтпщозтщотпщощтпощозптщозптщопатщозще" +
                        "орзщкоезщокотозщозщвозщозщзщоиозщуорузщокрзщокрзщоекрзщозкщероз" +
                        "щоерзщкозрщокерощзкщеорзщкозщрокощзщкозщкозщізщкоізщоіезщо" +
                        "ізщеорзщорезщорезщозещорзщокзеорзщкеорзщкоерзщокзеощрзщкоезрщокз" +
                        "еощрзщкеорзщкеорзщокещозщкеозщкеорзщозккоокрозщзкщеозщкеозрщокер" +
                        "зщозещкорзщоекрощзщеозщорзщоекрзщозщкеорзщокеозкеорзщкеозщозщко" +
                        "езрщкорзокщезкзщорзщкорзщкозщерозкщерокзщеорзщкоерзщокзщероощзщк" +
                        "еорзщототокзщоркрщеорзщозщокреощзкщерозщзщокерорзщекорзщокзеорзщк" +
                        "еорзщкоерзщокзеощзщкео"},
        };
        return data;
    }

    @Test(dataProvider = "dataLess1500Symbols")
    public void TestVerifiesTheErrorMessageWhenEnterLess1500Symbols(String testCaseValue) {
        boolean isDisplayederrorMassage = new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickSingInButton()
                .sendKeysEmail(valueProvider.getAdminEmail())
                .sendKeysPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .header()
                .clickUserProFileButton()
                .clickMyProfileButton()
                .clickAddButton()
                .clickAddClubButton()
                .fillInClubNameInput("Юність")
                .clickOptionCheckboxes(0)
                .fillInAgeFromInput("18")
                .fillInAgeToInput("50")
                .clickNextStepButton()
                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
                .clickNextStepButton()
                .fillInBasicDescriptionInput(testCaseValue)
                .isDisplayedExplainErrorAlotSymbols();

        Assert.assertFalse(isDisplayederrorMassage);

    }

    @DataProvider(name = "data1501symbols")
    public Object[][] dataProvider1501symbols() {
        Object[][] data = new Object[][]{
                {"лдлстєащтоащлптєдлаьтдлаєдрл5єщо6щощоаотдарощкорщаопщоалє" +
                        "тєлдтєщлрртєщаьтєщрртєщзашщтшвьєщльаркшзщ45лз4щзщщозщ" +
                        "окзщотзщпащізщрєіщорєзщірзщізщоізщнозщнезощзщнонфФокерзщозквп" +
                        "ропіривжпіржшптжітпржіштржщтапщкещкщешрощор9рорщшкорщшщаптьпщлат" +
                        "єдлатєдлаптєлрєдл5646457457длІВВАПРдрлощорщкшорщшкорщшкощершокщш" +
                        "оерщкшоерщшкоерщшокщшреощкшорееищьщапщшркоещршокщшерощкшеорщшо" +
                        "кешрщокщшоерщшкеорщшкоещшрощешорщшкеорщшокешщрощкеорщшкеорщшоке" +
                        "ршокешщшкоерзкеорзкеоз59нш59095нщошреошщрешорешощрешорешощекшщер" +
                        "шоешркшщоркешощкеррешщершщоершощрешреошощшкеорщкшощшорщалпощашо" +
                        "рщшаощршокщшорщшовщшоищшщтдлояжопщшворзщворзщоерзщощшорзуорзуорз" +
                        "оукзщорузщорущорзуозроузорзурооиадлоиавовщаорзщкеорзеуокрзоезрщоз" +
                        "ещорзщокерзщозщеорзщрщоорорщозещзоекщозерщозрщзщозрещзощзврщорв" +
                        "щозращощзорващоркзерщощкшощощрозкщерозкщоерзщокерзщокзерощзкщеорзщкое" +
                        "рзщокерзщокзерозщкоерзщокерощзщкеорзщокерзщоазпщрозкщеоизщкеоотооз" +
                        "щорзещуоизщозщтоезощтзкеозщтоезщкотзктоотокозщеккщезщкщзозтщко" +
                        "зщтпооапщопащщоащоапщзщпзощзтпщозтщотпщощтпощозптщозптщопатщозще" +
                        "орзщкоезщокотозщозщвозщозщзщоиозщуорузщокрзщокрзщоекрзщозкщероз" +
                        "щоерзщкозрщокерощзкщеорзщкозщрокощзщкозщкозщізщкоізщоіезщо" +
                        "ізщеорзщорезщорезщозещорзщокзеорзщкеорзщкоерзщокзеощрзщкоезрщокз" +
                        "еощрзщкеорзщкеорзщокещозщкеозщкеорзщозккоокрозщзкщеозщкеозрщокер" +
                        "зщозещкорзщоекрощзщеозщорзщоекрзщозщкеорзщокеозкеорзщкеозщозщко" +
                        "езрщкорзокщезкзщорзщкорзщкозщерозкщерокзщеорзщкоерзщокзщероощзщк" +
                        "еорзщототокзщоркрщеорзщозщокреощзкщерозщзщокерорзщекорзщокзеорзщк" +
                        "еорзщкоерзщокзеощзщкеозщрокзеорзщкерзщокозщреозкще*)*??g", "Опис гуртка може містити від 40 до 1500 символів."},


        };
        return data;
    }

    @Test(dataProvider = "data1501symbols")
    public void TestVerifiesTheErrorMessageWhenEnter1501Symbols(String testCaseValue, String expected) {
        String errorMassage = new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickSingInButton()
                .sendKeysEmail(valueProvider.getAdminEmail())
                .sendKeysPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .header()
                .clickUserProFileButton()
                .clickMyProfileButton()
                .clickAddButton()
                .clickAddClubButton()
                .fillInClubNameInput("Юність")
                .clickOptionCheckboxes(0)
                .fillInAgeFromInput("18")
                .fillInAgeToInput("50")
                .clickNextStepButton()
                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
                .clickNextStepButton()
                .fillInBasicDescriptionInput(testCaseValue)
                .getTextExplainErrorAlotSymbols();
        Assert.assertEquals(errorMassage, expected);


    }

    @DataProvider(name = "dataMore1500symbols")
    public Object[][] dataProviderMore1500symbols() {
        Object[][] data = new Object[][]{
                {"лдлстєащтоащлптєдлаьтдлаєдрл5єщо6щощоаотдарощкорщаопщоалє" +
                        "тєлдтєщлрртєщаьтєщрртєщзашщтшвьєщльаркшзщ45лз4щзщщозщ" +
                        "окзщотзщпащізщрєіщорєзщірзщізщоізщнозщнезощзщнонфФокерзщозквп" +
                        "ропіривжпіржшптжітпржіштржщтапщкещкщешрощор9рорщшкорщшщаптьпщлат" +
                        "єдлатєдлаптєлрєдл5646457457длІВВАПРдрлощорщкшорщшкорщшкощершокщш" +
                        "оерщкшоерщшкоерщшокщшреощкшорееищьщапщшркоещршокщшерощкшеорщшо" +
                        "кешрщокщшоерщшкеорщшкоещшрощешорщшкеорщшокешщрощкеорщшкеорщшоке" +
                        "ршокешщшкоерзкеорзкеоз59нш59095нщошреошщрешорешощрешорешощекшщер" +
                        "шоешркшщоркешощкеррешщершщоершощрешреошощшкеорщкшощшорщалпощашо" +
                        "рщшаощршокщшорщшовщшоищшщтдлояжопщшворзщворзщоерзщощшорзуорзуорз" +
                        "оукзщорузщорущорзуозроузорзурооиадлоиавовщаорзщкеорзеуокрзоезрщоз" +
                        "ещорзщокерзщозщеорзщрщоорорщозещзоекщозерщозрщзщозрещзощзврщорв" +
                        "щозращощзорващоркзерщощкшощощрозкщерозкщоерзщокерзщокзерощзкщеорзщкое" +
                        "рзщокерзщокзерозщкоерзщокерощзщкеорзщокерзщоазпщрозкщеоизщкеоотооз" +
                        "щорзещуоизщозщтоезощтзкеозщтоезщкотзктоотокозщеккщезщкщзозтщко" +
                        "зщтпооапщопащщоащоапщзщпзощзтпщозтщотпщощтпощозптщозптщопатщозще" +
                        "орзщкоезщокотозщозщвозщозщзщоиозщуорузщокрзщокрзщоекрзщозкщероз" +
                        "щоерзщкозрщокерощзкщеорзщкозщрокощзщкозщкозщізщкоізщоіезщо" +
                        "ізщеорзщорезщорезщозещорзщокзеорзщкеорзщкоерзщокзеощрзщкоезрщокз" +
                        "еощрзщкеорзщкеорзщокещозщкеозщкеорзщозккоокрозщзкщеозщкеозрщокер" +
                        "зщозещкорзщоекрощзщеозщорзщоекрзщозщкеорзщокеозкеорзщкеозщозщко" +
                        "езрщкорзокщезкзщорзщкорзщкозщерозкщерокзщеорзщкоерзrteщокзщероощзщк" +
                        "еорзщототокзщоркрщеорзщозщокреощзкщерозщзщокерорзщекорзщокзеорзщк" +
                        "еорзщкоерзщокзеощзщкеозщрокзеорзщкерзщокозщреозкще*)*??ggrtertrer",
                        "Опис гуртка може містити від 40 до 1500 символів."},


        };
        return data;
    }

    @Test(dataProvider = "data1501symbols")
    public void TestVerifiesTheErrorMessageWhenEnterMore1500Symbols(String testCaseValue, String expected) {
        String errorMassage = new HomePage(driver)
                .header()
                .clickUserProFileButton()
                .clickSingInButton()
                .sendKeysEmail(valueProvider.getAdminEmail())
                .sendKeysPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .header()
                .clickUserProFileButton()
                .clickMyProfileButton()
                .clickAddButton()
                .clickAddClubButton()
                .fillInClubNameInput("Юність")
                .clickOptionCheckboxes(0)
                .fillInAgeFromInput("18")
                .fillInAgeToInput("50")
                .clickNextStepButton()
                .fillInContactPhoneInput(valueProvider.getContactPhoneNumber())
                .clickNextStepButton()
                .fillInBasicDescriptionInput(testCaseValue)
                .getTextExplainErrorAlotSymbols();
        Assert.assertEquals(errorMassage, expected);
    }
}
