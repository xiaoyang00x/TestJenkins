import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Test01 {

    @Test
    public void tesJenkins() throws InterruptedException {
        System.out.println("Test begin!!!");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.baidu.com");
        Thread.sleep(10000);
        driver.get("http://www.google.com");
        Thread.sleep(10000);
        System.out.println("Test over!!!");
    }
}
