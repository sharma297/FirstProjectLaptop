package Hello;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunch {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hemant\\git\\FirstProjectLaptop\\FirstProject\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(23, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/sql/default.asp");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		driver.findElement(By.xpath("//*[@href='trysql.asp?filename=trysql_select_all']")).click();


		Set<String> windows =driver.getWindowHandles();

		System.out.println(windows.toString());
		Iterator<String> loop=windows.iterator();
		String cur =loop.next();
		String sec =loop.next();
		driver.switchTo().window(sec);

		driver.findElement(By.xpath("(//*[contains(text(),'Run SQL')])[2]")).click();


		List<WebElement> row =driver.findElements(By.xpath("//*[@id=\"divResultSQL\"]/div/table/tbody/tr"));
		int rowsize =row.size();
		List<WebElement> col =driver.findElements(By.xpath("//*[@id=\"divResultSQL\"]/div/table/tbody/tr[1]/td"));
		int colsize =col.size();

		for(int i=0;i<rowsize;i++) {
			for(int j=0;j<colsize;j++) {
				System.out.print(
						driver.findElement(By.xpath("//*[@id=\"divResultSQL\"]/div/table/tbody/tr["+i+"]/th["+j+"]")).getText()+" ");
			}
			System.out.println();
		}
	}

}
