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

        driver.navigate().refresh();
        driver.navigate().to("http://the-internet.herokuapp.com/");
        WebElement dropdown=driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[11]/a"));
        dropdown.click();

        //WebElement dropdownComponentText = driver.findElement(By.xpath(("//*[@id=\"dropdown\"]")));

        WebElement selectedOptionText= driver.findElement(By.xpath(("//*[@id=\"dropdown\"]/option[2]")));
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText(selectedOptionText.getText());
        select.selectByIndex(1);



    }
}
