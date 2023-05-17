package com.dotKonnektMobile.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.dotKonnektMobile.base.BaseClass;
import com.dotKonnektMobile.dataProviders.DataProviders;
import com.dotKonnektMobile.pages.BlogPage;
import com.dotKonnektMobile.pages.CategoryPage;
import com.dotKonnektMobile.pages.CommonPagedetails;
import com.dotKonnektMobile.pages.HomePage;
import com.dotKonnektMobile.pages.LoginPage;
import com.dotKonnektMobile.pages.ProductPage;
import com.dotKonnektMobile.pages.RecipePageFinal;
import com.dotKonnektMobile.utility.Log;

public class BlogPageTest  extends BaseClass {
	ProductPage productPage;
	RecipePageFinal recipePage;
	CommonPagedetails commonPagedetails;
	BlogPage blogPage;
	CategoryPage categoryPage;	
	LoginPage loginPage;
	HomePage homePage;
	
	String welcomeTxt = "(//p[@class='MuiTypography-root MuiTypography-body1 css-k1juyd'])[1]";
	String accessTxt ="(//p[@class='MuiTypography-root MuiTypography-body1 css-1yt7wtf'])[1]";
	String loginTxt = "(//button[normalize-space()='LOGIN/SIGNUP'])[1]";
	String BlogPageElements = "//div[@class='MuiBox-root css-1y4n82h']/button";
	String Author = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-12 css-1r6qczh']";
	String P_Date = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-12 css-3odfiv']";
	String bd_Home = "(//li[@class='MuiBreadcrumbs-li'])/a";
	String loginPageTxt = "//input[@placeholder='Email']";
	String likeIcon = "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-fwkm60'])[1]";
	
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class,enabled = true, groups = "NotLoggedIn")
	public void BlogPage_PageLoadtime(String page, String title, String browser, String url, String blogTitle, String AuthorName, String PublishDate) throws InterruptedException, IOException {
		Log.startTestCase("BlogPage_PageLoadtime");
		launchApp_V1(browser, url); 
		Log.endTestCase("BlogPage_PageLoadtime");
	}

	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class,enabled = true, groups = "NotLoggedIn")
	public void BlogPage_TitleVerification_dotFashion(String page, String title, String browser, String url, String blogTitle, String AuthorName, String PublishDate) {
		Log.startTestCase("BlogPage_TitleVerification");
		commonPagedetails = new CommonPagedetails();
		launchApp_V1(browser, url);
		String actualTitle = commonPagedetails.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, title, "Title Not Verified");
		Log.endTestCase("BlogPage_TitleVerification");
	}
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class,enabled = true, groups = "NotLoggedIn")
	
	public void BlogPage_PageHeaderVerification_dotFashion(String page, String title, String browser, String url, String blogTitle, String AuthorName, String PublishDate) {
		Log.startTestCase("BlogPage_PageHeaderVerification");
		commonPagedetails = new CommonPagedetails();
		launchApp_V1(browser, url);
		Log.info("-----------Logo Verification Starts----------");
		boolean logoResult = commonPagedetails.valaidateLogo();
		Assert.assertTrue(logoResult);
		Log.info("-----------Logo Verification End successfully----------");
		Log.info("-----------SearchBox Verification Starts----------");
		boolean searchResult = commonPagedetails.validateSearchBox();
		Assert.assertTrue(searchResult);
		Log.info("-----------SearchBox Verification End Successfully----------");
		Log.info("-----------Cartbutton Verification Starts----------");
		boolean cartResult = commonPagedetails.validateCartButton();
		Assert.assertTrue(cartResult);
		Log.info("-----------Cartbutton Verification End Successfully----------");
		Log.info("-----------Userbutton Verification Starts----------");
		boolean userResult = commonPagedetails.validateUserButton();
		Assert.assertTrue(userResult);
		Log.info("-----------Userbutton Verification End Successfully----------");
		Log.info("-----------MenuButton Verification Starts----------");
		boolean menuResult = commonPagedetails.validateMenuButton();
		Assert.assertTrue(userResult);
		Log.info("-----------MenuButton Verification End Successfully----------");
		Log.endTestCase("HomePage_PageHeaderVerification");
	}
	
	
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void BlogPage_SearchFucntionalityVerification_dotFashion(String page, String title, String browser, String url, String blogTitle, String AuthorName, String PublishDate) throws InterruptedException {
		
		Log.startTestCase("-----------BlogPage_SearchFucntionalityVerification    Starts---------");
		
		recipePage = new RecipePageFinal();
		commonPagedetails = new CommonPagedetails();
		launchApp_V1(browser, url);
		commonPagedetails.validateSeachFunctionality("Black","mouse",title);
		
		Log.info("SearchFucntionality Works perfectly");
		Log.endTestCase("-----------BlogPage_SearchFucntionalityVerification    Ends---------");
	}
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void BlogPage_CartFucntionalityVerification_dotFashion(String page, String title, String browser, String url, String blogTitle, String AuthorName, String PublishDate) throws InterruptedException {
		Log.startTestCase("-----------BlogPage_CartFucntionalityVerification    Starts---------");
		commonPagedetails = new CommonPagedetails();
		launchApp_V1(browser, url);
		commonPagedetails.validateCartIconFunctionality();
		Log.info("CartFucntionality Works perfectly");
		Log.endTestCase("-----------BlogPage_CartFucntionalityVerification    Ends---------");
	}
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void BlogPage_UserFunctionalityVerification_dotFashion(String page, String title, String browser, String url, String blogTitle, String AuthorName, String PublishDate) throws InterruptedException {

		Log.startTestCase("-----------BlogPage_UserFunctionalityVerification    Starts---------");
		recipePage = new RecipePageFinal();
		commonPagedetails = new CommonPagedetails();
		launchApp_V1(browser, url);
		commonPagedetails.UserButtonFunctionality(title);
		Log.endTestCase("-----------BlogPage_UserFunctionalityVerification    Ends---------");
	}
	
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void BlogPage_LogoFunctionalityVerification_dotFashion(String page, String title, String browser, String url, String blogTitle, String AuthorName, String PublishDate) throws InterruptedException {

		Log.startTestCase("-----------BlogPage_LogoFunctionalityVerification    Starts---------");
		recipePage = new RecipePageFinal();
		commonPagedetails = new CommonPagedetails();
		launchApp_V1(browser, url);
		commonPagedetails.logoFunctionality(title);
		Log.info("LogoFunctionalityVerification Works perfectly");
		Log.endTestCase("-----------BlogPage_LogoFunctionalityVerification    Ends---------");
	}
	
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public  void BlogPage_CategoryHeaderElements_dotFashion(String page, String title, String browser, String url, String blogTitle, String AuthorName, String PublishDate) throws InterruptedException {
		Log.startTestCase("BlogPage_BlogPageElements");
		Log.info("Verfying the BlogPage List");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		recipePage.CategoryListVerification(browser);	
		Log.endTestCase("-----------BlogPage_BlogPageElements---------");
	}
	
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void BlogPage_addCommentVerification_dotFashion(String page, String title, String browser, String url, String blogTitle, String AuthorName, String PublishDate) throws InterruptedException {
		Log.startTestCase("-----------BlogPage_addCommentVerification    Starts---------");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		recipePage.addCommentVerification();
		Log.endTestCase("-----------BlogPage_addCommentVerification    Ends---------");
	}
	
	
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled =  true, groups = "NotLoggedIn")
	public void BlogPage_Image_dotFashion(String page, String title, String browser, String url, String blogTitle, String AuthorName, String PublishDate) throws InterruptedException {
		Log.startTestCase("-----------BlogPage_Image_dotFashion    Starts---------");
		blogPage = new BlogPage();
		launchApp_V1(browser, url);
		blogPage.imageVerification();

		Log.endTestCase("-----------BlogPage_Image_dotFashion    Ends---------");
	}
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled =  true, groups = "NotLoggedIn")
	public void BlogPage_authornameVerification_dotFashion(String page, String title, String browser, String url, String blogTitle, String AuthorName, String PublishDate){
		
		Log.startTestCase("-----------BlogPage_authornameVerification    Starts---------");
		Log.info("Author Name Verification");
		launchApp_V1(browser, url);
		recipePage = new RecipePageFinal();
		recipePage.authoreDetailsVerification(AuthorName, PublishDate);
		
		Log.endTestCase("-----------BlogPage_authornameVerification    Ends---------");
	}
	
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled =  true, groups = "NotLoggedIn")
	public void BlogPage_likeIconFunctionality1_dotFashion(String page, String title, String browser, String url, String blogTitle, String AuthorName, String PublishDate) throws InterruptedException {
		Log.startTestCase("-----------BlogPage_likeIconFunctionality1    Starts---------");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		recipePage.LikeIconfunctionality("Loggedout");
		Log.endTestCase("-----------BlogPage_likeIconFunctionality1    Ends---------");
	}
	

	
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled =  true, groups = "NotLoggedIn")
	public void BlogPage_bookMarkIconFunctionality_dotFashion(String page, String title, String browser, String url, String blogTitle, String AuthorName, String PublishDate) throws InterruptedException {
		Log.startTestCase("-----------BlogPage_bookMarkIconFunctionality    Starts---------");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		recipePage.BookMarkIconfunctionality("Loggedout");
		Log.endTestCase("-----------BlogPage_bookMarkIconFunctionality    Ends---------");
	}
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled =  true, groups = "NotLoggedIn")
	public void BlogPage_ShareIconFunctionality_dotFashion(String page, String title, String browser, String url, String blogTitle, String AuthorName, String PublishDate) throws InterruptedException {
		Log.startTestCase("-----------BlogPage_ShareIconFunctionality    Starts---------");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		recipePage.ShareIconfunctionality();
		Log.endTestCase("-----------BlogPage_ShareIconFunctionality    Ends---------");
	}
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled =  true, groups = "NotLoggedIn")
	public void BlogPage_blogTitleVerification_dotFashion(String page, String title, String browser, String url, String blogTitle, String AuthorName, String PublishDate){
		Log.startTestCase("-----------BlogPage_blogTitleVerification    Starts---------");
		blogPage = new BlogPage();
		launchApp_V1(browser, url);
		String actualBlogTitle = blogPage.blogTitleVerification();
		Assert.assertEquals(actualBlogTitle, blogTitle);
		Log.endTestCase("-----------BlogPage_blogTitleVerification    Ends---------");
	}
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled =  true, groups = "NotLoggedIn")
	public void BlogPage_tagsVerification_dotFashion(String page, String title, String browser, String url, String blogTitle, String AuthorName, String PublishDate) throws InterruptedException {
		Log.startTestCase("-----------BlogPage_tagsVerification    Starts---------");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		recipePage.tagList();
		Log.endTestCase("-----------BlogPage_tagsVerification    Ends---------");
	}
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled =  true, groups = "NotLoggedIn")
	public void BlogPage_ProductTilesVerification_dotFashion(String page, String title, String browser, String url, String blogTitle, String AuthorName, String PublishDate) {
		Log.startTestCase("-----------BlogPage_ProductImageVerification    Starts---------");
		blogPage = new BlogPage();
		launchApp_V1(browser, url);
		blogPage.productImageVerification();
		Log.endTestCase("-----------BlogPage_ProductImageVerification    Ends---------");
	}
	
	/*
	 * @Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class,
	 * enabled = true, groups = "NotLoggedIn") public void
	 * BlogPage_ProductQuickviewVerification_dotFashion(String page, String title,
	 * String browser, String url, String blogTitle, String AuthorName, String
	 * PublishDate) throws InterruptedException { Log.
	 * startTestCase("-----------BlogPage_ProductQuickviewVerification    Starts---------"
	 * ); blogPage = new BlogPage();
	 * 
	 * launchApp_V1(browser, url); blogPage.productQuickView();
	 * 
	 * Log.
	 * endTestCase("-----------BlogPage_ProductQuickviewVerification    Ends---------"
	 * ); }
	 */

	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled =  true, groups = "NotLoggedIn")
	public void BlogPage_ProductWishlistVerification_dotFashion(String page, String title, String browser, String url, String blogTitle, String AuthorName, String PublishDate) throws InterruptedException {
		Log.startTestCase("-----------BlogPage_ProductWishlistVerification    Starts---------");
		productPage = new ProductPage();
		launchApp_V1(browser, url);
		productPage.wishlistIconFunctionalityforNotLoggedIn();
		//blogPage.wishlistIconFunctionalityForLoggedIn();
		Log.endTestCase("-----------BlogPage_ProductWishlistVerification    Ends---------");
	}
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled =  true, groups = "NotLoggedIn")
	public void BlogPage_BlogVideoVerification_dotFashion(String page, String title, String browser, String url, String blogTitle, String AuthorName, String PublishDate) throws InterruptedException {
		Log.startTestCase("-----------BlogPage_BlogVideoVerification    Starts---------");
		blogPage = new BlogPage();
		launchApp_V1(browser, url);
		blogPage.blogVideoSection();
		Log.endTestCase("-----------BlogPage_BlogVideoVerification    Ends---------");
	}
	
	/*
	 * @Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class,
	 * enabled = true, groups = "NotLoggedIn") public void
	 * BlogPage_BreadCrumbVerification_dotFashion(String page, String title, String
	 * browser, String url, String blogTitle, String AuthorName, String PublishDate)
	 * throws InterruptedException { Log.
	 * startTestCase("-----------BlogPage_BreadCrumbVerification    Starts---------"
	 * ); recipePage = new RecipePageFinal(); launchApp_V1(browser, url);
	 * recipePage.breadCrumbFunctionality(title);
	 * Log.endTestCase("-----------BlogPage_BreadCrumbVerification    Ends---------"
	 * );
	 * 
	 * }
	 */
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void BlogPage_askOurExpertSection(String page, String title, String browser, String url, String blogTitle, String AuthorName, String PublishDate) throws InterruptedException {
		Log.startTestCase("-----------BlogPage_askOurExpert    Starts---------");
		blogPage = new BlogPage();
		homePage = new HomePage();
		launchApp_V1(browser, url);
		homePage.askOurExpert();
		Log.endTestCase("-----------BlogPage_askOurExpert    Ends---------");
	}
	
	@Test(dataProvider = "HomePage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void HomePage_SendAMessageFunctionalityGuestUser(String page, String title, String browser, String url) throws InterruptedException {
		Log.startTestCase("-----------HomePage_SendAMessageFunctionality    Starts---------");
		homePage = new HomePage();
		launchApp_EB(browser, url);
		homePage.NewsletterPopup__Alert();
		homePage.sendAMessage("Guest");   //enter type of User -  Logged, Guest
		Log.endTestCase("-----------HomePage_SendAMessageFunctionality    Ends---------");
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	

	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled = false, groups = "LoggedIn")
	public void BlogPage_AddCommentinCommentSeection_dotFashion(String page, String title, String browser, String url, String blogTitle, String AuthorName, String PublishDate) throws InterruptedException {
		Log.startTestCase("BlogPage_AddCommentinCommentSeection");

		launchApp_V1(browser, prop.getProperty("LoginUrl"));
		Log.startTestCase("Entering the data");
		loginPage = new LoginPage();
		loginPage.loginSetup(prop.getProperty("Username"), prop.getProperty("Password"));
		getDriver().get(url);
		recipePage = new RecipePageFinal();
		recipePage.LoggedInAddCommentsVerification("save");
		Log.endTestCase("-----------BlogPage_AddCommentinCommentSeection ---------");
	}
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled = true, groups = "LoggedIn")
	public void BlogPage_bookMarkIconFunctionalityLoggedIn_dotFashion(String page, String title, String browser, String url, String blogTitle, String AuthorName, String PublishDate) throws InterruptedException {
		Log.startTestCase("-----------BlogPage_bookMarkIconFunctionalityLoggedIn    Starts---------");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		recipePage.BookMarkIconfunctionality("LoggedIn");
		Log.endTestCase("-----------BlogPage_bookMarkIconFunctionalityLoggedIn    Ends---------");
	}
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled = false, groups = "LoggedIn")
	public void BlogPage_likeIconFunctionality_dotFashion(String page, String title, String browser, String url, String blogTitle, String AuthorName, String PublishDate) throws InterruptedException {
		Log.startTestCase("-----------BlogPage_likeIconFunctionality    Starts---------");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		recipePage.LikeIconfunctionality("Logged");
		Log.endTestCase("-----------BlogPage_likeIconFunctionality    Ends---------");
	}
	
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled = false, groups = "LoggedIn")
	public void BlogPage_reportAbuseFunctionality_dotFashion(String page, String title, String browser, String url, String blogTitle, String AuthorName, String PublishDate) throws InterruptedException {
		Log.startTestCase("-----------BlogPage_reportAbuseFunctionality_dotFashion    Starts---------");
		launchApp_V1(browser, prop.getProperty("LoginUrl"));
		Log.startTestCase("Entering the data");
		loginPage = new LoginPage();
		loginPage.loginSetup(prop.getProperty("Username"), prop.getProperty("Password"));
		getDriver().get(url);
		recipePage = new RecipePageFinal();
		recipePage.reportAbuseFunctionality();
		Log.endTestCase("-----------BlogPage_reportAbuseFunctionality_dotFashion    Ends---------");
	}
	
	
	@AfterMethod(groups = {"LoggedIn","NotLoggedIn"})
	public void teardown() {
		getDriver().close();
	}
}