import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Alert;

public class Quiz {

  @Test
  public void quiz_1() {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://demoqa.com/login");
    driver.manage().window().maximize();

    // first
    WebElement username = driver.findElement(By.id("userName"));
    WebElement password = driver.findElement(By.id("password"));
    username.sendKeys("test123");
    password.sendKeys("Automation@123");
    WebElement login = driver.findElement(By.id("login"));
    login.click();

    // second
    new WebDriverWait(driver, Duration.ofSeconds(30))
        .until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));
    WebElement store = driver.findElement(By.id("gotoStore"));
    new WebDriverWait(driver, Duration.ofSeconds(30))
        .until(ExpectedConditions.elementToBeClickable(store))
        .click();
    new WebDriverWait(driver, Duration.ofSeconds(30))
        .until(ExpectedConditions.presenceOfElementLocated(By.className("rt-tbody")));
    WebElement books = driver.findElement(By.className("rt-tbody"));
    List<WebElement> amount = books.findElements(By.className("action-buttons"));
    Assert.assertEquals(8, amount.size());

    // third
    WebElement bookTitle = driver.findElement(By.xpath("//*[@id='see-book-Git Pocket Guide']/a"));
    bookTitle.click();

    // fourth
    WebElement detailsTitle = driver
        .findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/label"));
    Assert.assertEquals(detailsTitle.getText(), "Git Pocket Guide");
    WebElement addButton = driver
        .findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]/button"));
    addButton.click();
    new WebDriverWait(driver,
        Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
    Alert bookAlert = driver.switchTo().alert();
    Assert.assertEquals(bookAlert.getText(), "Book already present in the your collection!");
    bookAlert.dismiss();

    // fifth
    driver.navigate().back();
    Assert.assertEquals(8, amount.size());

    // sixth
    WebElement logOut = driver.findElement(By.id("submit"));
    logOut.click();
    WebElement welcomeText = driver.findElement(By.xpath("//*[@id=\"userForm\"]/div[1]/h2"));
    Assert.assertEquals(welcomeText.getText(), "Welcome,");
    WebElement loginText = driver.findElement(By.xpath("//*[@id=\"userForm\"]/div[1]/h5"));
    Assert.assertEquals(loginText.getText(), "Login in Book Store");
    driver.close();
  }
}
