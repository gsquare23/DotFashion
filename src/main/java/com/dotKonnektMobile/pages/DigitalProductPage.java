package com.dotKonnektMobile.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.dotKonnektMobile.actionDrivers.Action;
import com.dotKonnektMobile.base.BaseClass;
import com.dotKonnektMobile.utility.Log;

public class DigitalProductPage extends BaseClass {

	SoftAssert softAssert = new SoftAssert();
	public DigitalProductPage() {
		PageFactory.initElements(getDriver(), this);
	}

	String productName = "//div[@id='sg-productDetailsCardProductTitle']";
	String Bigimage = "(//img[@id='sg-imageMagnifierImage'])";
	String smallImage = "(//img[@id='sg-imageStackImage2'])";
	String video = "//div[@id='sg-componentSelectedImageContainer']//video//source";

	// SoftAssert softAssert = new SoftAssert();
	public void productDetailVerification() throws InterruptedException {
		WebElement smallProductImage = getDriver().findElement(By.xpath(smallImage));
		String value2 = smallProductImage.getAttribute("alt");
		System.out.println(value2);
		String pagesource = getDriver().getPageSource();
		// System.out.println(pagesource);
		Log.info("Successfully get the pagesource");
		if (pagesource.contains("video")) {
			WebElement ProductVideo = getDriver().findElement(By.xpath(video));
			String value1 = ProductVideo.getAttribute("src");
			// System.out.println(value1);

			if (value1.contains("shopify.com")) {

				Action.mouseOverElement(getDriver(), ProductVideo);
				Thread.sleep(500);
				Log.info("Successfully verified the presence of the video");
			}
		} else {
			WebElement ProductImages = getDriver().findElement(By.xpath(Bigimage));
			String value1 = ProductImages.getAttribute("alt");
			System.out.println(value1);

			if (value1.equals(value2)) {
				boolean result = Action.isDisplayed(getDriver(), ProductImages);
				if (result) {
					Action.mouseOverElement(getDriver(), ProductImages);
					Thread.sleep(400);
				} else {
					Assert.assertTrue(result, "Product is not visible or present");
				}
			} else {
				Assert.assertTrue(false, "The zommed image and side image are not same");
			}

		}

		String ProductName = getDriver().findElement(By.xpath(productName)).getText();
		System.out.println(ProductName);
		String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
		for (int i = 0; i < ProductName.length(); i++) {
			char ch = ProductName.charAt(i);
			String s = String.valueOf(new char[] { ch });
			// System.out.println(s);
			if (specialCharactersString.contains(Character.toString(ch))) {
				System.out.println(s + " contains special character");

				if (ProductName.contains(s)) {
					String splits1[] = ProductName.split(s);
					System.out.println(splits1[0]);
					String actualName = splits1[0];
					if (value2.contains(actualName)) {
						System.out.println("Product name verified");
					} else {
						Assert.assertTrue(false, "Product Name are not correct");
					}
				}
				break;
			}
		}
	}

	String cartButton = "//button[@id='sg-addToCartButton']";

	public void availabiltyStock() {

		Log.info("AddToCart of Product Page verification");
		WebElement addToCartIcon = getDriver().findElement(By.xpath(cartButton));
		boolean result = Action.isDisplayed(getDriver(), addToCartIcon);
		String elementTxt = addToCartIcon.getText();
		if (elementTxt.equalsIgnoreCase("ADD TO CART") && result) {
			Assert.assertTrue(addToCartIcon.isEnabled(), "Out of Stock button is not enabled");
			System.out.println("AddTOCart is enabled");
			Log.info("Successfully verified AddToCart Message");
		} else if (elementTxt.equalsIgnoreCase("OUT OF STOCK") && result) {
			Assert.assertTrue(!addToCartIcon.isEnabled(), "Out of Stock button is enabled");
			Log.info("Product is Out of Stock");
		}

		else {
			System.out.println("Cart Icon is not present");
			Assert.assertTrue(result, "Cart Icon is not present");
		}
		Log.info("Successfully ends the availabiltyStock");
	}

	String allProducts ="(//div[@id='sg-productCardWrapper' and @type ='Products'])";
	String carticon = "//*[name()='svg' and @data-testid='ShoppingCartOutlinedIcon']";
	String wishlist = "//*[name()='svg' and @data-testid='FavoriteBorderOutlinedIcon']";
	String quickview = "//p[@id='sg-quickViewButton']";
	String discountedPrice = "//div[@class='MuiBox-root css-70qvj9']/p";
	String actualPrice = "//div[@id='productCardContentPriceTile']";
	String productsName = "(//div[@id='sg-productCardWrapper' and @type ='Products'])/div[1]/div[1]";
	String images = "(//div[@id='sg-productCardWrapper' and @type ='Products'])/span/img";
	

	public void wefoundOtherSections() throws InterruptedException {
		
		WebElement bodyTag = getDriver().findElement(By.tagName("body"));
		Thread.sleep(1000);
		//System.out.println(bodyTag.getText());
		if(bodyTag.getText().contains("WE FOUND OTHER COURSES YOU MIGHT LIKE")) {
			
		String productYouMightLikeSection = "//div[normalize-space()='We found other courses you might like']";
		WebElement products = getDriver().findElement(By.xpath(productYouMightLikeSection));
		Action.scrollByVisibilityOfElement(getDriver(), products);

		List<WebElement> products1 = getDriver().findElements(By.xpath(allProducts));
		int n = products1.size();
		System.out.println(n);

		List<WebElement> image = getDriver().findElements(By.xpath(images));
		int x = image.size();
		int count4 = 0;
		if (x == n) {
			for(WebElement i : image) {
				Action.mouseOverElement(getDriver(), i);
				if(i.getAttribute("srcset").contains("shopify.com")) {
					count4++;
				}
			}
			if(count4 ==n ) {
			System.out.println("All " + count4 + " images are present");}
			else {
				softAssert.assertTrue(false, n-count4+ " Images are not present  ");
			}
		} else {
			System.out.println(n - x + " Images are not present ");
			softAssert.assertTrue(false, +n - x + " Images are not present ");
		}

		List<WebElement> productName1 = getDriver().findElements(By.xpath(productsName));
		int j = productName1.size();
		if (j == n) {
			System.out.println("All Products name are present");
		} else {
			System.out.println(n - j + " Products name are not present ");
			softAssert.assertTrue(false, +n - j + " Products name are not present ");
		}

		List<WebElement> productActPrice = getDriver().findElements(By.xpath(actualPrice));
		int z = productActPrice.size();
		if (z == n) {
			System.out.println("All Actual Prices are present");
		} else {
			System.out.println(n - z + " Actual Prices are not present ");
			softAssert.assertTrue(false, n - z + " Actual Prices are not present ");
		}

		List<WebElement> quickviewlink = getDriver().findElements(By.xpath(quickview));
		int i = quickviewlink.size();
		if (i == n) {
			System.out.println("All Quick View links are present");
		} else {
			System.out.println(n - i + " Quick View links are not present ");
			softAssert.assertTrue(false, n - i + " Quick View links are not present ");
		}

		List<WebElement> carticon1 = getDriver().findElements(By.xpath(carticon));
		int c = carticon1.size();
		if (c == n) {
			System.out.println("All carticon are present");
		} else {
			System.out.println(n - c + " carticon are not present ");
			softAssert.assertTrue(false, +n - c + " carticon are not present ");
		}

		List<WebElement> wishlist1 = getDriver().findElements(By.xpath(wishlist));

		int d = carticon1.size();
		if (d == n) {
			System.out.println("All Wishlist icon are present");
		} else {
			System.out.println(n - d + " Wishlist icon are not present ");
			softAssert.assertTrue(false, +n - c + " Wishlist icon are not present ");
		}

		softAssert.assertAll();
		}
		else {
			System.out.println("WE FOUND OTHER COURSES YOU MIGHT LIKE section is not present");
			Assert.assertTrue(false, "WE FOUND OTHER COURSES YOU MIGHT LIKE section is not present");
			
		}
	}
	
	
	String highlightContent = "(//div[@class='MuiBox-root css-1umfg2p'])/div";
	String highlightImages = "//div[@class='MuiBox-root css-12hir4b']/span/img";
	String courses = "//div[@class='MuiBox-root css-12hir4b']";
	String courseHighlight = "(//div[contains(@class,'css-bp10qf')])[1]";

	public void CourseHighlightSections() {
		WebElement CourseHighlight = getDriver().findElement(By.xpath(courseHighlight));
		softAssert.assertEquals(CourseHighlight.getText(), "COURSE HIGHLIGHTS",
				"Course Highlights text is not present on the UI");
		Log.info("Course Highlights is successfully present on the UI");

		List<WebElement> Courses = getDriver().findElements(By.xpath(courses));
		int c = Courses.size();
		System.out.println(c);
		List<WebElement> HighlightImages = getDriver().findElements(By.xpath(highlightImages));
		int d = HighlightImages.size();
		System.out.println(d);
		if (d == c) {
			int count5 = 0;
			Log.info("sdfghjkl");
			for (WebElement i : HighlightImages) {
				Action.mouseOverElement(getDriver(), i);
				if (i.getAttribute("srcset").contains("amazonaws.com")) {
					count5++;
				}
			}
			if (count5 == d) {
				System.out.println("All " + count5 + " highlight images are present");
			} else {
				softAssert.assertTrue(false, d - count5 + " Highlight Images are not present  ");
			}
		} else {
			System.out.println(c - d + " Highlight images are not present ");
			softAssert.assertTrue(false, +c - d + " Highlight Images are not present ");
		}

		List<WebElement> HighlightContent = getDriver().findElements(By.xpath(highlightContent));
		int e = HighlightContent.size();
		System.out.println(e);
		if (d == e) {
			for (WebElement i : HighlightContent) {
				Action.mouseOverElement(getDriver(), i);
				if (!i.getText().equals(null)) {
					Assert.assertTrue(i.isDisplayed());
					System.out.println(i.getText());
					Log.info("Successfully verified the content of the highlights");
				} else {
					softAssert.assertTrue(i.getText().equals(null));
					Log.info("Content is not present in the highlight images");
				}
			}
		}

		softAssert.assertAll();
	}

}
