import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Task2Tests {
    WebDriver driver;

    public Task2Tests() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void Task2Tests() {
        driver.get("https://demoqa.com/progress-bar");
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"startStopButton\"]"));
        submitButton.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement text = driver.findElement(By.xpath("//*[contains(text(), '100%')]"));
        System.out.println(text.getText());
    }

    @Test
    public void Task2Tests2() {
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"dropdowm-menu-2\"]/option[2]"));
        submitButton.click();
        Boolean Select = driver.findElement(By.xpath("//*[@id=\"dropdowm-menu-2\"]/option[2]")).isSelected();
        System.out.println("Maven is Selected :"+Select);
        WebElement Button_Radio_Button = driver.findElement(By.xpath("//*[@id=\"radio-buttons\"]/input[5]"));
        Button_Radio_Button.click();

        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/label[1]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/label[2]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/label[4]/input")).click();

        Boolean Enable = driver.findElement(By.xpath("//*[@id=\"fruit-selects\"]/option[2]")).isEnabled();
        System.out.println("'Orange' option in dropdown is disabled :"+Enable);
    }
}