package RingAutomations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class LaunchAffiliateSite {
    public LaunchAffiliateSite() {
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"start-maximized"});
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to("https://za-en.ring.com/");
        Thread.sleep(3000L);
        chromeDriver.findElement(By.xpath("//*[@class=\"mobile_menu mobile_menu--htx\"]")).click();
        chromeDriver.findElement(By.xpath("//a[text()='All Products']/@href")).click();
        Thread.sleep(2000L);

        ArrayList<WebElement> ringProductList = new ArrayList<>(chromeDriver.findElements(By.xpath("//*[@class=\"plp-product\"]")));

        for (int i = 0; i <= ringProductList.size(); i++) {
            System.out.println(ringProductList.get(i));
        };
        chromeDriver.quit();
    }
}
