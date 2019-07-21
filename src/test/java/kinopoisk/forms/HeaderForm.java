package kinopoisk.forms;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderForm extends BaseForm {

    @FindBy(xpath = "//a[contains(@class, 'advanced-search')]")
    private WebElement advancedSearchButton;

    public void clickAdvancedSearch() {
        log.info("Clicking advanced search button in Header");
        advancedSearchButton.click();
    }
}
