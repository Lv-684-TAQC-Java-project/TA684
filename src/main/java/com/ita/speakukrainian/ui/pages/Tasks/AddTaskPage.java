package com.ita.speakukrainian.ui.pages.Tasks;

import com.ita.speakukrainian.ui.pages.BaseObjectPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;
import org.stringtemplate.v4.ST;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class AddTaskPage extends BaseObjectPage {

    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement nameField;
    @FindBy(xpath = "//*[@id=\"root\"]//div[4]/div[2]/div/div/div/div/div[2]/div[1]")
    private WebElement titleField;
    @FindBy(xpath = "//*[@id=\"root\"]//div[5]/div[2]/div/div/div/div/div[2]/div[1]")
    private WebElement descriptionField;
    @FindBy(xpath = "//*[@class=\"ant-picker-input\"]")
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
    public AddTaskPage(WebDriver driver) {
        super(driver);
    }

    public boolean dateFieldIsEmpty() {
        boolean isEmpty;
        if (nameField.getAttribute("value").equals(null)) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }

    public void addImage() {
            inputImage.sendKeys("D:\\Projects\\TA684\\src\\test\\resources\\foto.jpg");
            sleep(3000);
    }

    public boolean checkIsImageAdded(){
        if (image.isDisplayed()) {
            return true;
        }
        else return false;
    }
    public void takeSnapShot() throws Exception{
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
        System.out.println(s);
        URL url = new URL(s);
        System.out.println(url);
        BufferedImage bufImgOne = ImageIO.read(url);
        ImageIO.write(bufImgOne, formatName, new File(pathName));
    }

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
