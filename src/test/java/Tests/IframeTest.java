package Tests;

import TestBase.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class IframeTest extends TestBase {
    @Test
    public void shouldFillForm() {
        Random random = new Random();

        getDriver().get("https://seleniumui.moderntester.pl/iframes.php");
        getDriver().switchTo().frame("iframe1");
        getDriver().findElement(By.id("inputFirstName3")).sendKeys("John");
        getDriver().findElement(By.id("inputSurname3")).sendKeys("Travolta");
        getDriver().findElement(By.cssSelector(".btn.btn-primary")).click();

        assertThat(getDriver().findElement(By.id("inputFirstName3")).getText(), equalTo(""));

        getDriver().switchTo().defaultContent();

        getDriver().switchTo().frame("iframe2");
        getDriver().findElement(By.id("inputLogin")).sendKeys("login1");
        getDriver().findElement(By.id("inputPassword")).sendKeys("password1");

        Select select = new Select(getDriver().findElement(By.id("inlineFormCustomSelectPref")));
        select.selectByVisibleText("Asia");

        List<WebElement> yearsOfExperience = getDriver().findElements(By.cssSelector(".form-check"));
        yearsOfExperience.get(random.nextInt(yearsOfExperience.size())).click();
        getDriver().findElement(By.cssSelector(".btn.btn-primary")).click();

        assertThat(getDriver().findElement(By.id("inputLogin")).getText(), equalTo(""));

        getDriver().switchTo().defaultContent();

        getDriver().findElement(By.xpath("//a[contains(text(),'Basic')]")).click();

        assertThat(getDriver().findElement(By.id("alerts-item")).getText(), equalTo("Alerts"));
    }
}
