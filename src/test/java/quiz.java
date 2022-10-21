import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;


public class quiz {

    @Test
    public void quiz_1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/login");
        driver.manage().window().maximize();
        driver.findElement(By.id("UserName"));
        WebElement username=driver.findElement(By.id("UserName"));
        driver.findElement(By.id("password"));
        WebElement password=driver.findElement(By.id("password"));
        username.sendKeys("test123");
        password.sendKeys("Automation@123");
        login.click();

       
        WebElement store = driver.findElement(By.id("gotoStore"));
        store.click();
        List<WebElement> books = driver.findElements(By.className("action-buttons"));
        Assert.assertEquals(books.size() , 8);
      
        WebElement bookTitle = driver.findElement(By.xpath("//*[@id=\"see-book-Git Pocket Guide\"]/a"));
        Assert.assertEquals(bookTitle.getText(),"Git Pocket Guide");
        bookTitle.click();        
      
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]/button"))).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        Assert.assertEquals(text, "Book already present in the your collection!");
        alert.accept();
       
        WebElement logOut = driver.findElement(By.id("submit"));
        logOut.click();
        WebElement welcomeText = driver.findElement(By.xpath("//*[@id=\"userForm\"]/div[1]/h2"));
        Assert.assertEquals(welcomeText.getText(), "Welcome,");
        WebElement loginText = driver.findElement(By.xpath("//*[@id=\"userForm\"]/div[1]/h5"));
        Assert.assertEquals(welcomeText.getText(), "Login in Book Store");
        driver.close();
           
    }
}
