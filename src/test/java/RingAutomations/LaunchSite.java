package RingAutomations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchSite {
    public LaunchSite() {
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to("https://wwww.amazon.com");
        Thread.sleep(5000L);
        chromeDriver.findElement(By.xpath("//*[@name='field-keywords']")).sendKeys(new CharSequence[]{"ring"});
        chromeDriver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
        Thread.sleep(5000L);
        String result = chromeDriver.findElement(By.xpath("//*[@class=\"sg-col-14-of-20 sg-col-18-of-24 sg-col s-breadcrumb sg-col-10-of-16 sg-col-6-of-12\"]")).getText();
        System.out.println("The result is " + result);
        String[] splitMessage = result.split(" ");
        System.out.println("The number of results for this page is " + splitMessage[1]);
        chromeDriver.quit();
    }
}
