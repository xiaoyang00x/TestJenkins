import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Test01 {

    @Test
    public void tesJenkins() throws InterruptedException {
        System.out.println("Test begin!!!");
        DesiredCapabilities dc = DesiredCapabilities.firefox();
        WebDriver driver = new RemoteWebDriver(dc);
        driver.get("http://www.baidu.com");
        Thread.sleep(10000);
        driver.get("http://www.google.com");
        Thread.sleep(10000);
        System.out.println("Test over!!!");
        driver.close();
    }
}
