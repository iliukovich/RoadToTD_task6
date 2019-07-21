package kinopoisk.pages;

import driver.DriverHolder;
import kinopoisk.forms.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends BaseForm {

    public boolean isFilmDisplayed(String filmName) {
        log.info(String.format("Checking \"%s\" film is displayed on search result page", filmName));
        return getSearchResultsByName(filmName).isDisplayed();
    }

    private WebElement getSearchResultsByName(String filmName) {
        return DriverHolder.getInstance().findElement(By.xpath(String.format("//p[@class = 'name']//a[contains(., '%s')]", filmName)));
    }
}
