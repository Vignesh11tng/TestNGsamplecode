package com.logoff;

import java.awt.AWTException
;
import java.awt.Robot;
import java.io.File;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	// BrowserLaunch
	public static void browserLaunch(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	// FindElement
	public static WebElement locateElement(String locatorType, String value) {
		if (locatorType.equals("id")) {
			WebElement findElement = driver.findElement(By.id(value));
			return findElement;
		} else if (locatorType.equals("name")) {
			WebElement findElement = driver.findElement(By.name(value));
			return findElement;
		} else if (locatorType.equals("class")) {
			WebElement findElement = driver.findElement(By.className(value));
			return findElement;
		} else if (locatorType.equals("tagName")) {
			WebElement findElement = driver.findElement(By.tagName(value));
			return findElement;
		} else if (locatorType.equals("linkText")) {
			WebElement findElement = driver.findElement(By.linkText(value));
			return findElement;
		} else if (locatorType.equals("partialLinkText")) {
			WebElement findElement = driver.findElement(By.partialLinkText(value));
			return findElement;
		} else if (locatorType.equals("cssSelector")) {
			WebElement findElement = driver.findElement(By.cssSelector(value));
			return findElement;
		} else {
			WebElement findElement = driver.findElement(By.xpath(value));
			return findElement;
		}
		}
	// BrowerClose
	public static void close(String value) {
		if (value.equals("close")) {
			driver.close();
		} else if (value.equals("quit")) {
			driver.quit();
		}
	}

	// SendKeys
	public static void enterText(WebElement Element, String stringValue) {
		Element.sendKeys(stringValue);
	}

	// Get
	public static String get(WebElement Element, String value) {
		if (value.equals("getText")) {
			String text = Element.getText();
			return text;
		} else if (value.equals("getTitle")) {
			String title = driver.getTitle();
			return title;
		} else {
			String currentUrl = driver.getCurrentUrl();
			return currentUrl;
		}
	}

	// Click
	public static void click(WebElement Element) {
		Element.click();
	}

	// Alerts
	public static Alert alert;

	public static Alert switchToAlert() {
		Alert alert = driver.switchTo().alert();
		return alert;
	}

	public static void aletmethod(String value) {
		if (value.equals("accept")) {
			alert.accept();
		} else if (value.equals("dismiss")) {
			alert.dismiss();
		}
	}

	// Actions
	public static Actions act;

	public static void select(String action, WebElement target) {
		Actions act = new Actions(driver);
		if (action.equals("moveToElement")) {
			act.moveToElement(target).perform();
		} else if (action.equals("doubleClick")) {
			act.doubleClick(target).perform();
		} else if (action.equals("contextClick")) {
			act.contextClick(target).perform();
		}
	}

	public static void mouseAction(String action, WebElement source, WebElement target) {
		if (action.equals("dragAndDrop")) {
			act.dragAndDrop(source, target).perform();
		}
	}

	// Robot
	public static void robotKey(String value, int keycode) throws AWTException {
		Robot r = new Robot();
		if (value.equals("keyPress")) {
			r.keyPress(keycode);
		} else if (value.equals("keyRelease")) {
			r.keyRelease(keycode);
		}
	}

	// Select
	public static Select s;

	public static void selectByMethod(String value, WebElement target, int index) {
		s = new Select(target);
		if (value.equals("selectByIndex")) {
			s.selectByIndex(index);
		} else if (value.equals("deselectByIndex")) {
			s.deselectByIndex(index);
		}
	}

	public static void selectByMethod(String value, WebElement target, String text) {
		s = new Select(target);
		if (value.equals("selectByValue")) {
			s.selectByValue(text);
		} else if (value.equals("selectByVsibleText")) {
			s.selectByVisibleText(text);
		} else if (value.equals("deselectByValue")) {
			s.deselectByValue(value);
		} else if (value.equals("deselectByVisibleText")) {
			s.deselectByVisibleText(text);
		}
	}

	public static List<WebElement> selectByMethod(String value, WebElement target) {
		s = new Select(target);
		if (value.equals("getAllSelectedOptions")) {
			List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
			return allSelectedOptions;
		} else {
			List<WebElement> options = s.getOptions();
			return options;
		}
	}

	public static void deselectAll(String text, WebElement target) {
		s = new Select(target);
		s.deselectAll();
	}

	public static boolean selectByIndex(int index, WebElement target) {
		s = new Select(target);
		boolean multiple = s.isMultiple();
		return multiple;
	}

	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public static void navigate(String value) {
		if (value.equals("back")) {
			driver.navigate().back();
		} else if (value.equals("forward")) {
			driver.navigate().forward();
		} else if (value.equals("refresh")) {
			driver.navigate().refresh();
		}
	}

	// Windows Handling
	public static void windowsMax() {
		driver.manage().window().maximize();
	}

	public static void windowsSet(String value, int x, int y) {
		if (value.equals("setSize")) {
			Dimension d = new Dimension(x, y);
			driver.manage().window().setSize(d);
		} else if (value.equals("setPosition")) {
			Point p = new Point(x, y);
			driver.manage().window().setPosition(p);
		}

	}

	// JavascriptExecutor
	public static JavascriptExecutor js;

	public static Object javaScriptExecuteByScroll(String value, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (value.equals("windowsScrollBy")) {
			Object executeScript = js.executeScript("window.scrollBy(" + x, y + ")");
			return executeScript;
		} else {
			return null;
		}
	}

	public static Object javaScriptExecutorByScrollIntoView(int i, boolean bool, WebElement w) {
		Object executeScript = js.executeScript("arguments[" + i + "].scrollIntoView(" + bool + ")", w);
		return executeScript;
	}

	public static Object javaScriptExecuteBySetAttribute(int i, String attributeName, String attributeValue) {
		Object executeScript = js
				.executeScript("arguments[" + i + "].SetAttribute('" + attributeName + ",'" + attributeValue + "')");
		return executeScript;
	}

	// TakesScreenshot
	public static TakesScreenshot ts;

	public static File TakeScreenShot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		return screenshotAs;
	}

	// Frames
	public static void switchToFrame(int i) {
		driver.switchTo().frame(i);
	}

	public static WebDriver switchToFrame(String name) {
		WebDriver frame = driver.switchTo().frame(name);
		return frame;
	}

	public static WebDriver switchToFrame(WebElement Element) {
		WebDriver frame = driver.switchTo().frame(Element);
		return frame;
	}

	public static void switchToParentFrame(WebElement Element) {
		driver.switchTo().parentFrame();
	}

	public static void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
		
}




