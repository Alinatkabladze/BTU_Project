import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

public class ExampleTests {

    @Test
    public void firstTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        WebElement button=driver.findElement(By.xpath("//ul/li/a"));
        button.click();
        WebElement text = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
        Assert.assertEquals(text.getText(),"A/B Test Control");

        driver.navigate().back();
        /*Select drpList = new Select(driver.findElement(By.id("Dropdown List")));
        drpList.selectByVisibleText("Option 1");*/

        WebElement dropdownMenu = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[11]/a"));
        dropdownMenu.click();

        WebElement dropOption = driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[2]"));
        dropOption.click();

        /*Select dropdown = new Select(dropdownMenu);
        dropdown.selectByIndex(1);*/
    }
}
