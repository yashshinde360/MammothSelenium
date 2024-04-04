package com.testSteps;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverFactory.InitDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class Hooks {
	public static InitDriver initDriver;
	public static ConfigReader configReader;
	public static Properties prop;
	public static WebDriver driver;

	public static void deleteDirectory(File file) {
		try {
			for (File subfile : file.listFiles()) {
				if (subfile.isDirectory()) {
					deleteDirectory(subfile);
				}
				subfile.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeAll(order = 0)
	public static void deleteTestResults() {
		File file = new File("./testResults");
		deleteDirectory(file);
		file.delete();
	}

	@BeforeAll(order = 1)
	public static void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	@BeforeAll(order = 2)
	public static void launchBrowser() {
		String browserName = prop.getProperty("browser");
		initDriver = new InitDriver();
		driver = initDriver.launchBrowser(browserName);
	}

	@AfterAll
	public static void quitBrowser() {
		driver.quit();
	}

	@After
	public void takeScenarioScreenshot(Scenario scenario) throws IOException {
		String pattern = "[\\s\"]";
		String screenshotName = scenario.getName().replaceAll(pattern, "_");
		String fileWithPath = null;
		if (scenario.isFailed()) {
			fileWithPath = "./testResults/" + "FAIL_" + screenshotName + ".png";
		} else if(scenario.getStatus().toString().equalsIgnoreCase("PASSED")) {
			System.out.println();
			fileWithPath = "./testResults/" + "PASS_" + screenshotName + ".png";
		}
		else {
			fileWithPath = "./testResults/" + "UNDEFINED_SKIPPED_AMBIGUOUS_" + screenshotName + ".png";
		}
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);
	}

	@AfterStep
	public void attachEachStepScreenshot(Scenario scenario) {
		String pattern = "[\\s\"]";
		String screenshotName = scenario.getName().replaceAll(pattern, "_");
		byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(sourcePath, "image/png", screenshotName);
	}

}
