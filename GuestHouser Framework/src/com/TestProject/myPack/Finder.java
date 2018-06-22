package com.TestProject.myPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.TestProject.myPack.Browser.GlobalVars;

public class Finder {

	public static WebElement findWebElement(String xpath) {
		try {
			WebElement element = GlobalVars.Web_Driver.findElement(By.xpath(xpath));
			return element;
		} catch (Exception  e) {
			System.out.println("Nothing found..." + e.getClass());
			return null;
		}

	}

	public static List<WebElement> findWebElements(String xpath) {
		try {
			List<WebElement> list = GlobalVars.Web_Driver.findElements(By.xpath(xpath));
			return list;
		} catch (Exception e) {
			System.out.println("Nothing found in findElements..." + e.getClass());
			return null;
		}

	}
	public static WebElement findWebElementById(String id)
	{
		try {
			WebElement element = GlobalVars.Web_Driver.findElement(By.id(id));
			return element;
		} catch (NoSuchElementException e) {
			System.out.println("Nothing found..." + e.getClass());
			return null;
		}
	}
}
