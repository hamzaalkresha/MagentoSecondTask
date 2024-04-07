import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Tasks extends Parameters {

	@BeforeTest()

	public void MySetup() {

		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	@Test(priority = 1 )
	public void SignupProcess() throws InterruptedException {
		Thread.sleep(2000);
		WebElement SignupClick = driver.findElement(By.cssSelector("header[class='page-header'] li:nth-child(3) a:nth-child(1)"));
		SignupClick.click();
		WebElement FirstName = driver.findElement(By.id("firstname"));
		WebElement LastName = driver.findElement(By.id("lastname"));
		WebElement Email = driver.findElement(By.id("email_address"));
		WebElement Pass = driver.findElement(By.id("password"));
		WebElement ConfirmPass = driver.findElement(By.id("password-confirmation"));
		WebElement CreateAnAccount = driver.findElement(By.cssSelector(".action.submit.primary"));
		FirstName.sendKeys("hamza");
		LastName.sendKeys("alkresha");
		Email.sendKeys("hamzaqwer@gmail.com");
		Pass.sendKeys("Hamza_1234");
		ConfirmPass.sendKeys("Hamza_1234");
		CreateAnAccount.click();
		

	}
	@Test(priority = 2)
	public void SignInProcess() {
		WebElement SignInClick = driver.findElement(By.cssSelector("div[class='panel header'] li[data-label='or'] a"));
		SignInClick.click();
		WebElement Email = driver.findElement(By.id("email"));
		WebElement Password = driver.findElement(By.id("pass"));
		WebElement LoginCaps = driver.findElement(By.cssSelector(".action.login.primary"));
		Email.sendKeys("hamzaqwer@gmail.com");
		Password.sendKeys("Hamza_1234");
		LoginCaps.click();
		
	}
	
	@Test(priority = 3)
	public void AddTheFirstThreeItems() throws InterruptedException {
		
	WebElement WomenSection = driver.findElement(By.id("ui-id-4"));
	WomenSection.click();
    WebElement teesOption = driver.findElement(By.xpath("//a[contains(text(), 'Tees')]"));
		teesOption.click();
		
		
		
		
		// This ForLoop To add The First Three Item 
		
		for(int i=0 ; i<3; i++) {
			
			WebElement ContinarItems = driver.findElement(By.cssSelector(".products.wrapper.grid.products-grid"));
			List<WebElement> Items = ContinarItems.findElements(By.tagName("li"));
			Items.get(i).click();
			Thread.sleep(3000);
			WebElement AddToCartButton = driver.findElement(By.id("product-addtocart-button"));
			WebElement ContinarColors = driver.findElement(By.cssSelector("div[class='swatch-attribute color'] div[role='listbox']"));
			List<WebElement> Colors = ContinarColors.findElements(By.tagName("div"));
			WebElement ContinarSizes = driver.findElement(By.cssSelector("div[class='swatch-attribute size'] div[role='listbox']"));
			List<WebElement> Sizes = ContinarSizes.findElements(By.tagName("div"));
			int RandomSizes = rand.nextInt(Sizes.size());
			int RandomColors = rand.nextInt(Colors.size());
			
			
			Sizes.get(RandomSizes).click();
			Colors.get(RandomColors).click();
			AddToCartButton.click();
			Thread.sleep(3000);
			driver.navigate().back();
			Thread.sleep(3000);
		}
		//Assertion for TotalItem
				WebElement CartIcon = driver.findElement(By.cssSelector(".action.showcart"));
				CartIcon.click();

				Thread.sleep(5000);
				WebElement itemsCount = driver.findElement(By.className("items-total"));
				String TotalItems = itemsCount.getText();
				
					Myassert.assertEquals( TotalItems , "3 Items in Cart" );
					
				//Assertion for Price	
					String totalExpectedPrice =	"$70.00" ;
					
					WebElement FinalPrice = driver.findElement(By.cssSelector("span[data-bind='html: cart().subtotal_excl_tax'] span[class='price']"));
					String ActualFinalPrice = FinalPrice.getText();
					Myassert.assertEquals(totalExpectedPrice , ActualFinalPrice );

		}
		
		
	 
		@Test(priority = 4)
		
			public void AddRandomItemFormMenSection() throws InterruptedException {
			WebElement MenSectionCaps = driver.findElement(By.id("ui-id-5"));
			MenSectionCaps.click();
			Thread.sleep(3000);
			WebElement ItemsContinar = driver.findElement(By.cssSelector(".product-items.widget-product-grid"));
			List<WebElement> Items = ItemsContinar.findElements(By.tagName("li"));
			int randomItems = rand.nextInt(Items.size());
			Items.get(randomItems).click();
			Thread.sleep(3000);
			WebElement ContinarSizes = driver.findElement(By.cssSelector("div[class='swatch-attribute size'] div[role='listbox']"));
			List<WebElement> Sizes = ContinarSizes.findElements(By.tagName("div"));
			WebElement ContinarColors = driver.findElement(By.cssSelector("div[class='swatch-attribute color'] div[role='listbox']"));
			List<WebElement> Colors = ContinarColors.findElements(By.tagName("div"));
			WebElement AddToCartButton = driver.findElement(By.id("product-addtocart-button"));
			int RandomSizes = rand.nextInt(Sizes.size());
			int RandomColors = rand.nextInt(Colors.size());
			Sizes.get(RandomSizes).click();
			Colors.get(RandomColors).click();
			AddToCartButton.click();
			Thread.sleep(3000);
			String price = driver.findElement(By.cssSelector(".price-container.price-final_price.tax.weee[itemprop='offers']")).getText();
			System.out.println("This price is to check the price of item  "+""+price);
			
		
			
	}
		@AfterTest()
		public void ToDoAfterTest() {
			
			driver.quit();
			
			
		}
		
}
