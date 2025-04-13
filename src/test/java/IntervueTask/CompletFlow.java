package IntervueTask;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CompletFlow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.intervue.io/");
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Login
		WebElement loginBtn = driver.findElement(By.cssSelector("[class*='loginBtn']"));
		loginBtn.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		
		//store all windows ids using getWindowHandles in a Set of strings
		Set<String> windows = driver.getWindowHandles();
		//Now iterate through each of the windows using Iterator
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		
		//now switch to the child window from parent window to change the driver context
		driver.switchTo().window(childId);
		
		//Locating and clicking on LoginButton
		driver.findElement(By.xpath("//a/div[contains(@class, 'ColoredButton-Text')]")).click();
		
		//Entering Login Credentials in input fields
		driver.findElement(By.id("login_email")).sendKeys("neha@intervue.io");
		driver.findElement(By.id("login_password")).sendKeys("Ps@neha@123");
		driver.findElement(By.cssSelector("[class*='LoginDarkButton']")).click();
		
		//wait until the dash-board is loaded
		Thread.sleep(5000);
		
		//clicking on search bar
		WebElement searchBar = driver.findElement(By.xpath("//div[contains(@class, 'HeaderSearch__Wrapper')]"));
		wait.until(ExpectedConditions.elementToBeClickable(searchBar));
		searchBar.click();
		
		//Switch to pop-up search bar and enter a text
		driver.switchTo().activeElement();
		driver.findElement(By.xpath("//div[contains(@class,'SearchBox')]/input")).sendKeys("Hello");
		driver.findElement(By.xpath("//div[contains(@class, 'style__Wrapper')]")).click();
		Thread.sleep(4000);
		
		//LoggingOut
		driver.findElement(By.cssSelector(".ant-dropdown-link")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".igPDXJ"))));
		driver.findElement(By.xpath("//a[contains(@class,'hHnuKn')][5]")).click();
		
		Thread.sleep(5000);
		driver.quit();
		
		
		
		
	}

}
