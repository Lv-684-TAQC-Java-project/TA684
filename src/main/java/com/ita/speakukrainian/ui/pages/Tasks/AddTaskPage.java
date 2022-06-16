package com.ita.speakukrainian.ui.pages.Tasks;

import com.ita.speakukrainian.ui.dropdowns.AddTaskPageDropDown;
import com.ita.speakukrainian.ui.pages.BaseObjectPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Base64;

public class AddTaskPage extends BaseObjectPage {

    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement nameField;
    @FindBy(xpath = "//*[@id=\"root\"]//div[4]/div[2]/div/div/div/div/div[2]/div[1]")
    private WebElement titleField;
    @FindBy(xpath = "//*[@id=\"root\"]//div[5]/div[2]/div/div/div/div/div[2]/div[1]")
    private WebElement descriptionField;
    @FindBy(xpath = "//*[@id=\"startDate\"]")
    private WebElement dateField;
    @FindBy(xpath = "//*[@class=\"ant-upload-list-picture-card-container\"]")
    private WebElement firstPhoto;
    @FindBy(xpath = "//*[@class=\"ant-select-selection-placeholder\"]")
    private WebElement challengeField;
    @FindBy(xpath="//*[@id='root']/section/section/main/div/form/div[2]/div[2]/div/div/span/div/div[1]")
    private WebElement image;
    @FindBy(id="picture")
     private WebElement inputImage;
    String formatName = "jpg";
    String pathName ="D:\\Projects\\TA684\\src\\test\\resources\\fotoScreen.jpg";
    @FindBy(xpath = "//*[@id=\"challengeId\"]")
    private WebElement challengeDropDown;
    @FindBy(xpath ="//*[text()=\"Зберегти\"]")
    private WebElement saveChanges;


    public AddTaskPage(WebDriver driver) {
        super(driver);
    }

    @Step("verify that date field is empty")
    public boolean dateFieldIsEmpty() {
        boolean isEmpty;
        if (dateField.getAttribute("value") == null) {

            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }

    @Step("verify that name field is empty")
    public boolean nameFieldIsEmpty() {
        boolean isEmpty;
        if (nameField.getAttribute("value").equals("")) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }

    @Step("verify that description field is empty")
    public boolean descriptionFieldIsEmpty() {
        boolean isEmpty;
        if (descriptionField.getAttribute("value") == null) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }

    @Step("verify that title field is empty")
    public boolean titleFieldIsEmpty() {
        boolean isEmpty;
        if (titleField.getAttribute("value") == null) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }

    @Step("verify that challenge popup is not selected ")
    public boolean challengeDropDownIsNotSelected() {
        boolean isEmpty;
        if (challengeDropDown.getAttribute("value") == null) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }

    @Step("verify that all field is empty")
    public boolean AllFieldIsEmpty() {
        boolean isEmpty;
        if (dateFieldIsEmpty()&&nameFieldIsEmpty()&&descriptionFieldIsEmpty()&& challengeDropDownIsNotSelected()&&titleFieldIsEmpty()) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }

    @Step("fill date field")
    public void fillDateField(String date){
        dateField.click();
        dateField.sendKeys(date);
    }

    @Step("Choose the date")
    public AddTaskPage chooseDateField(){
        dateField.click();
        return new AddTaskPage(driver);
    }


    @Step("fill name field")
    public void fillNameField(String name){
        nameField.sendKeys(name);
    }

    @Step("fill description field")
    public void fillDescriptionField(String description){
        descriptionField.sendKeys(description);
    }

    @Step("click challenge dropdown")
    public AddTaskPageDropDown clickSelectChallenge() {
        challengeDropDown.click();
        AddTaskPageDropDown addTaskPageDropDown = new AddTaskPageDropDown(driver);
        return new AddTaskPageDropDown(driver);
    }

    @Step("click save changes")
    public AddTaskPage clickSave() {
        saveChanges.click();
        sleep(10000);
        return this;
    }
    @Step("Add image")
    public void addImage(File img) {
        inputImage.sendKeys(img.getAbsolutePath());
        sleep(3000);
    }
    @Step ("Verify that image was added")
    public boolean checkIsImageAdded(){
        if (image.isDisplayed()) {
            return true;
        }
        else return false;
    }
    @Step("Take the image")
    public String takeSnapShot() throws Exception{
//        WebElement image = driver.findElement(By.xpath("//*[@id=\"root\"]/section/section/main/div/form/div[2]/div[2]/div/div/span/div/div[1]/div/div"));
//        WrapsDriver wrapsDriver = (WrapsDriver) image;
//        File screenshot = ((TakesScreenshot) wrapsDriver.getWrappedDriver()).getScreenshotAs(OutputType.FILE);
//        Rectangle rectangle = new Rectangle(image.getSize().width, image.getSize().height, image.getSize().height, image.getSize().width);
//        Point location =image.getLocation();
//        BufferedImage bufferedImage = ImageIO.read(screenshot);
//        BufferedImage destImage = bufferedImage.getSubimage(location.x, location.y, rectangle.width, rectangle.height);
//        ImageIO.write(destImage, formatName, screenshot);
//        File file = new File(pathName);
//        FileUtils.copyFile(screenshot, file);
        WebElement image = driver.findElement(By.xpath("//*[@id=\"root\"]/section/section/main/div/form/div[2]/div[2]/div/div/span/div/div[1]/div/div/span/a/img"));
        String s = image.getAttribute("src");
        BufferedImage img1 = ImageIO.read(new File("D:\\Projects\\TA684\\src\\test\\resources\\foto.jpg"));
        //Base64.getEncoder().encodeToString()
        img1.toString();
        return s;
//        System.out.println(s);
//        URL url = new URL(s);
//        System.out.println(url);
//        BufferedImage bufImgOne = ImageIO.read(url);
//        ImageIO.write(bufImgOne, formatName, new File(pathName));
    }
    @Step("Comparing images")
    public boolean compareImages() throws IOException {
        BufferedImage img1 = ImageIO.read(new File("D:\\Projects\\TA684\\src\\test\\resources\\foto.jpg"));
        BufferedImage img2 = ImageIO.read(new File("D:\\Projects\\TA684\\src\\test\\resources\\fotoScreen.jpg"));
        long data = 1;
        int w1 = img1.getWidth();
        int w2 = img2.getWidth();
        int h1 = img1.getHeight();
        int h2 = img2.getHeight();
        if ((w1 != w2) || (h1 != h2)) {
            return false;
        } else {
            for (int j = 0; j < h1; j++) {
                for (int i = 0; i < w1; i++) {
                    int pixel1 = img1.getRGB(i, j);
                    Color color1 = new Color(pixel1, true);
                    int r1 = color1.getRed();
                    int g1 = color1.getGreen();
                    int b1 = color1.getBlue();
                    int pixel2 = img2.getRGB(i, j);
                    Color color2 = new Color(pixel2, true);
                    int r2 = color2.getRed();
                    int g2 = color2.getGreen();
                    int b2 = color2.getBlue();
                    data = Math.abs(r1 - r2) + Math.abs(g1 - g2) + Math.abs(b1 - b2);
                }
            }
        }
        if (data==0){
            return true;
        }
        else return false;
    }
}
