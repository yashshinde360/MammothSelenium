package com.testSteps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.HomePage;
import com.pages.ProjectPage;

import driverFactory.InitDriver;
import utils.Helper;

public class HomeTestSteps {
	public WebDriver driver= InitDriver.getDriver();
	HomePage homePage = new HomePage(driver);
	ProjectPage projectPage= new ProjectPage(driver);
	Helper helper = new Helper();
	
	public void clickOnPlusIconForCreatingProject() {
		homePage.getPlusIconForCreatingProject().click();
	}
	
	public void enterProjectName(String projectName) {
		homePage.getNewProjectNameField().sendKeys(projectName);;
	}
	
	public void clickOnCreateProjectOnModal() {
		homePage.getCreateProjectButtonOnModal().click();
	}
	
	public void verifyProjectCreated(String projectName) {
		helper.waitForElementToLoad();
		Assert.assertTrue(homePage.getCreatedProject(projectName).isDisplayed());
	}
	
	public void clickOnFetchFromURL() {
		homePage.getFetchFromURLLink().click();
	}
	
	public void enterIntoURLField(String fileUrl) {
		homePage.getURLField().sendKeys(fileUrl);
	}
	
	public void clickOnButton(String buttonText) {
		helper.waitForElementToLoad();
		homePage.getButton(buttonText).click();
	}
	
	public void clickOnOpenButton() {
		helper.waitForElementToLoad();
		homePage.getOpenButton().click();
	}
	
	public void verifyFileInProject(String fileName) {
		helper.waitForElementToLoad();
		helper.waitForElementToBeClickable(homePage.getFileProcessedImage());
		Assert.assertTrue(homePage.getFileInProject(fileName).isDisplayed());
	}
	
	public void cickOnFileInProject(String fileName) {
		helper.waitForElementToLoad();
		homePage.getFileInProject(fileName).click();
	}
	
	public void deleteAllProjects() throws InterruptedException {
		helper.waitForElementToLoad();
		while(homePage.getOptionsButtons().size()>0) {
		homePage.getOptionsButtons().get(0).click();
		projectPage.getOption("Delete Project").click();
		homePage.getDeleteTextBox().sendKeys("DELETE");
		homePage.getButton("Delete").click();
		Thread.sleep(10000);
		}
	}
	
	public void verifyProjectDeleted(String projectName) {
		Assert.assertTrue(homePage.getCreatedProjectList(projectName).isEmpty());
	}
	
	public void clickOnMyDesktopLink() {
		homePage.getMyDesktopLink().click();
	}
	
	public void uploadFile(String fileName) {
		helper.uploadFile(homePage.getUploadModal(), fileName);
	}
}
