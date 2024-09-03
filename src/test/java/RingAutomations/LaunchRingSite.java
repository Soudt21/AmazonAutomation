package RingAutomations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class LaunchRingSite {
    public LaunchRingSite() {
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"start-maximized"});
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to("https://www.ring.com/");
        Thread.sleep(3000L);
        chromeDriver.findElement(By.xpath("//*[@class=\"icon-container-e9a\"]")).click(); //click search icon
        Thread.sleep(2000L);
        chromeDriver.findElement(By.xpath("//*[@class=\"search-box--input\"]")).sendKeys(new CharSequence[]{"indoor camera"});
        chromeDriver.findElement(By.xpath("//*[@class=\"icon icon--search\"]")).click();
        Thread.sleep(5000L);
        //Displays the number of results on this page
        String result = chromeDriver.findElement(By.xpath("//*[@class=\"results-amount\"]")).getText();
        String[] splitMessage = result.split(" ");
        System.out.println("The number of results for this page is " + splitMessage[0]);
        var resultNumber = splitMessage[0];

        //Lists out all the products on the result page
        ArrayList<WebElement> ringProductList = new ArrayList<>(chromeDriver.findElements(By.xpath("//*[@data-testid=\"product-card-title\"]")));

        for (int i = 0; i <= ringProductList.size(); i++) {
            System.out.println(ringProductList.get(i));
        };

        chromeDriver.quit();
    }
}
