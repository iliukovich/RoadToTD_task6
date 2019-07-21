package kinopoisk.forms;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchByFilmForm extends BaseForm {

    @FindBy(xpath = "//form[contains(@id, 'SearchMain')]")
    private WebElement formElement;

    @FindBy(id = "find_film")
    private WebElement findFilmInput;

    @FindBy(xpath = "//form[contains(@id, 'SearchMain')]//select[contains(@name, 'content_find')]")
    private WebElement findContentDropDown;

    @FindBy(xpath = "//select[contains(@id, 'from_year')]")
    private WebElement fromYearDropDown;

    @FindBy(xpath = "//select[contains(@id, 'to_year')]")
    private WebElement toYearDropDown;

    @FindBy(xpath = "//form[contains(@id, 'SearchMain')]//input[contains(@class, 'submit')]")
    private WebElement searchButton;

    public boolean isDisplayed() {
        log.info("Checking 'Search By Film' form is displayed");
        return formElement.isDisplayed();
    }

    public void fillFindFilmTextbox(String filmName) {
        log.info(String.format("Filling in the 'Find Film' field with \"%s\" value", filmName));
        findFilmInput.sendKeys(filmName);
    }

    public void selectFromYear(Integer fromYearValue) {
        log.info(String.format("Selecting \"%s\" year in 'from' drop-down", fromYearValue));
        new Select(fromYearDropDown).selectByValue(String.valueOf(fromYearValue));
    }

    public void selectToYear(Integer toYearValue) {
        log.info(String.format("Selecting \"%s\" year in 'to' drop-down", toYearValue));
        new Select(toYearDropDown).selectByValue(String.valueOf(toYearValue));
    }

    public void selectContentType(String contentTypeValue) {
        log.info(String.format("Selecting \"%s\" from 'content type' drop-down", contentTypeValue));
        new Select(findContentDropDown).selectByValue(contentTypeValue);
    }

    public void clickSearch() {
        log.info("Clicking search button on 'Search By Film' form");
        searchButton.click();
    }
}
