package Tests;

import TestBase.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ProgressbarTest extends TestBase {

    @Test
    public void shouldWaitUntilProgressbarIsCompleted(){
        getDriver().get("https://seleniumui.moderntester.pl/progressbar.php");

        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(ExpectedConditions.textToBePresentInElement(getDriver().findElement(By.xpath("//div[@class='progress-label']")), "Complete!"));

        assertThat(getDriver().findElement(By.xpath("//div[@class='progress-label']")).getText(), equalTo("Complete!"));
    }
}
