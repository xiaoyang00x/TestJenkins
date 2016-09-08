import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDemo {
    WebDriver driver;

    @BeforeMethod
    public void initDriver() {
        driver = new FirefoxDriver();
        driver.get("http://www.baidu.com");
    }

    @Test
    public void testPageObj1() throws InterruptedException {
        System.out.println("*******testPageObj1********");
        new WebDriverWait(driver, 15).until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.cssSelector("#kw"));
            }
        });
        driver.findElement(By.cssSelector("#kw")).sendKeys("借贷宝");

        new WebDriverWait(driver, 15).until(new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.cssSelector("#su"));
            }
        });

        driver.findElement(By.cssSelector("#su")).click();

        new WebDriverWait(driver, 15).until(new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.cssSelector("#content_left"));
            }
        });

    }

    @Test
    public void testPageObj2() {
        System.out.println("*******testPageObj2********");
        BaiduPage baiduPage = new BaiduPage(driver);
        baiduPage.search("借贷宝");
    }

    @AfterMethod
    public void destoryDriver() {
        driver.close();
    }
}
