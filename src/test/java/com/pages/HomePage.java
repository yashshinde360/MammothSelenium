package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver= driver;
	}
	
	public WebElement getPlusIconForCreatingProject() {
		return driver.findElement(By.xpath("//*[contains(@class,'mm-tooltip--slot-wrapper')] //*[@data-name='plus']"));
	}
	
	public WebElement getNewProjectNameField() {
		return driver.findElement(By.cssSelector("[placeholder='Type Project name']"));
	}
	
	public WebElement getCreateProjectButtonOnModal() {
		return driver.findElement(By.xpath("//*[contains(@class, 'v-dialog')]//span[(text()='Create Project')]"));
	}
	
	public WebElement getFetchFromURLLink() {
		return driver.findElement(By.xpath("//a[@class='by-url']"));
	}
	
	public WebElement getCreatedProject(String projectName) {
		return driver.findElement(By.xpath("//span[contains(text(),'"+projectName+"')]"));
	}
	
	public WebElement getURLField() {
		return driver.findElement(By.cssSelector("[placeholder='http://your-url.com']"));
	}
	
	public WebElement getButton(String buttonText) {
		return driver.findElement(By.xpath("//span[text()='"+buttonText+"']"));
	}
	
	public WebElement getOpenButton() {
		return driver.findElement(By.xpath("//span[contains(text(),'OPEN')]"));
	}
	
	public WebElement getFileInProject(String fileName) {
		return driver.findElement(By.xpath("//*[@title='"+fileName+"']"));
	}
	
	public WebElement getFileProcessedImage() {
		return driver.findElement(By.xpath("//div[contains(@class,'ds-title ready')]"));
	}
	
	public List<WebElement> getOptionsButtons() {
		return driver.findElements(By.cssSelector("[data-name='menu_3_dots_vertical']"));
	}
	
	public WebElement getDeleteTextBox() {
		return driver.findElement(By.cssSelector("[placeholder='DELETE']"));
	}
	
	public List<WebElement> getCreatedProjectList(String projectName) {
		return driver.findElements(By.xpath("//span[contains(text(),'"+projectName+"')]"));
	}
	
	public WebElement getMyDesktopLink() {
		return driver.findElement(By.xpath("//a[@class='by-file']"));
	}
	
	public WebElement getUploadModal() {
		return driver.findElement(By.cssSelector("[type='file']"));
	}
}
