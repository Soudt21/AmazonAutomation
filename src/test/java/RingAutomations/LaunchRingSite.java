package RingAutomations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.PrintStream;
import java.util.ArrayList;

public class LaunchRingSite {
    public LaunchRingSite() {
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"incognito","start-maximized", "--headless"});
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to("https://www.ring.com/");
        Thread.sleep(3000L);
        chromeDriver.findElement(By.xpath("//*[@class=\"icon-container-e9a\"]")).click(); //click search icon
        Thread.sleep(2000L);
        chromeDriver.findElement(By.xpath("//*[@class=\"search-box--input _ar_hide_\"]")).sendKeys(new CharSequence[]{"Alarms" + "\n"});
        //chromeDriver.findElement(By.xpath("//*[@class=\"icon icon--search\"]")).click(); -- the search icon disappears when entering text so we're inputting a enter command into the send keys action.
        Thread.sleep(5000L);
        //Displays the number of results on this page
        String result = chromeDriver.findElement(By.xpath("//*[@class=\"results-amount\"]")).getText();
        String[] splitMessage = result.split(" ");
        System.out.println("The number of results on this page is " + splitMessage[0]);
        int resultNumber = Integer.parseInt(splitMessage[0]);

        //Lists out all the product names and their regular price on the result page
        ArrayList<WebElement> ringProductName = new ArrayList<>(chromeDriver.findElements(By.xpath("//*[@data-testid=\"product-card-title\"]")));
        ArrayList<WebElement> ringProductPrice = new ArrayList<>(chromeDriver.findElements(By.xpath("//*[@class=\"regular-price\"]")));

        for (int i = 0; i <= resultNumber; i++) {
            Object var10001 = ringProductName.get(i);
            Object var10002 = ringProductPrice.get(i);
            System.out.println("Product name: " + ((WebElement)var10001).getText() + ", " + ((WebElement)var10002).getText());
        };

        chromeDriver.quit();
    }
}
