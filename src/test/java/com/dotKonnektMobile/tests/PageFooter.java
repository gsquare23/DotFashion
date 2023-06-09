package com.dotKonnektMobile.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.dotKonnektMobile.base.BaseClass;
import com.dotKonnektMobile.pages.BlogPage;
import com.dotKonnektMobile.pages.CategoryPage;
import com.dotKonnektMobile.pages.CommonPagedetails;
import com.dotKonnektMobile.pages.HomePage;
import com.dotKonnektMobile.pages.LoginPage;
import com.dotKonnektMobile.pages.RecipePageFinal;
import com.dotKonnektMobile.utility.Log;

public class PageFooter extends BaseClass {
	HomePage homePage;
	LoginPage loginPage;
	RecipePageFinal recipePage;
	CategoryPage categoryPage;
	CommonPagedetails commonPagedetails;
	
	@Test
	public void pageFooterLinks() throws InterruptedException {
		Log.startTestCase("-----------pageFooterLinks    Starts---------");
		commonPagedetails = new CommonPagedetails();
		homePage = new HomePage();
		launchApp_EB("Chrome", prop.getProperty("HomePageurl"));
		homePage.NewsletterPopup__Alert();
		commonPagedetails.PageFooterLinks();
		Log.endTestCase("-----------pageFooterLinks    Ends---------");
	}
	
	@AfterMethod(groups = {"LoggedIn","NotLoggedIn"})
	public void teardown() {
		getDriver().close();
	}

}
