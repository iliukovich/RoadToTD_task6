package kinopoisk.pages;

import kinopoisk.forms.BaseForm;
import kinopoisk.forms.SearchByFilmForm;

public class AdvancedSearchPage extends BaseForm {

    public SearchByFilmForm getSearchByFilmForm() {
        return new SearchByFilmForm();
    }
}
