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
        WebElement username=driver.findElement(By.id("userName"));
        WebElement password=driver.findElement(By.id("password"));
        username.sendKeys("test123");
        password.sendKeys("Automation@123");
        WebElement login= driver.findElement(By.id("login" ));
        login.click();

       
        WebElement store = driver.findElement(By.id("gotoStore"));
        store.click();
        List<WebElement> books = driver.findElements(By.className("action-buttons"));
        Assert.assertEquals(books.size() , 8);
      
        WebElement bookTitle = driver.findElement(By.xpath("//*[@id=\"see-book-Git Pocket Guide\"]/a"));
        Assert.assertEquals(bookTitle.getText(),"Git Pocket Guide");
        bookTitle.click();        
        
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
        Alert bookAlert = driver.switchTo().alert();
        Assert.assertEquals(bookAlert.getText(), "Book already present in the your collection!");

             
        WebElement logOut = driver.findElement(By.id("submit"));
        logOut.click();
        WebElement welcomeText = driver.findElement(By.xpath("//*[@id=\"userForm\"]/div[1]/h2"));
        Assert.assertEquals(welcomeText.getText(), "Welcome,");
        WebElement loginText = driver.findElement(By.xpath("//*[@id=\"userForm\"]/div[1]/h5"));
        Assert.assertEquals(welcomeText.getText(), "Login in Book Store");
        driver.close();
           
    }
}
