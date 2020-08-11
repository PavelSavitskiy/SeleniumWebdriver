package com.epam.cdp.kzta2020.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static com.epam.cdp.kzta2020.pages.Page.getDriver;

public class ElementWrapper implements WebElement {
    private final WebElement webElement;

    public ElementWrapper(WebElement webElement) {
        this.webElement = webElement;
    }

    public void click() {
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].style.border ='12px solid yellow'", webElement);
        webElement.click();
    }

    public void sendKeys(CharSequence... charSequences) {
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].style.border ='10px solid green'", webElement);
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].style.backgroundColor ='lightblue'", webElement);
        webElement.sendKeys(charSequences);
    }

    public void dragAndDrop(By locator, int x, int y) {
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].style.border ='10px solid pink'", webElement);
        new Actions(getDriver()).dragAndDropBy(getDriver().findElement(locator), x, y).build().perform();
    }

    @Override
    public WebElement findElement(By by) {
        return webElement.findElement(by);
    }

    public void submit() {
        webElement.submit();
    }

    @Override
    public void clear() {
        webElement.clear();
    }

    @Override
    public String getTagName() {
        return webElement.getTagName();
    }

    @Override
    public String getAttribute(String s) {
        return webElement.getAttribute(s);
    }

    @Override
    public boolean isSelected() {
        return webElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return webElement.isEnabled();
    }

    @Override
    public String getText() {
        return webElement.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return webElement.findElements(by);
    }

    @Override
    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return webElement.getLocation();
    }

    @Override
    public Dimension getSize() {
        return webElement.getSize();
    }

    @Override
    public Rectangle getRect() {
        return webElement.getRect();
    }

    @Override
    public String getCssValue(String s) {
        return webElement.getCssValue(s);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return webElement.getScreenshotAs(outputType);
    }
}
