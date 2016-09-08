import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaiduPage {

    private WebDriver driver;

    @FindBy(css = "#kw")
    private WebElement inputTextField;

    @FindBy(css = "#su")
    private WebElement searchButton;

    @FindBy(css = "#content_left")
    private WebElement theFristDiv;

    public BaiduPage(WebDriver driver) {
        this.driver = driver;
        new WebDriverWait(driver, 15).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (Boolean) ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        });
        PageFactory.initElements(driver, this);
    }

    public void search(String content) {
        inputTextField = waitForElement(driver, this.inputTextField);
        inputTextField.clear();
        inputTextField.sendKeys(content);
        this.searchButton.click();
        waitForElement(driver, theFristDiv);

    }

    public WebElement waitForElement(WebDriver driver, final WebElement element) {
        return new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(element));
    }

}
