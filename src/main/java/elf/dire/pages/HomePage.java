package elf.dire.pages;

import com.microsoft.playwright.Locator;
import elf.dire.pages.base_page.BasePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePage extends BasePage {
    private final Locator homePageTitle = page.locator("//a[@class='navbar-brand']");
    private final Locator sandBoxDropdown = page.locator("//a[@id='navbarDropdown']");
    private final Locator dropdownGoods = page.locator("//a[@class='dropdown-item' and @href='/food']");

    /**
     * Checks if the Home page is open by verifying the visibility of the title.
     * @return the current HomePage instance
     */
    public HomePage checkHomePageIsOpen() {
        assertThat(homePageTitle).isVisible();
        return this;
    }

    /**
     * Clicks on the sandbox dropdown to reveal its items.
     * @return the current HomePage instance
     */
    public HomePage clickSandBoxDropdown() {
        assertThat(sandBoxDropdown).isVisible();
        sandBoxDropdown.click();
        return this;
    }

    /**
     * Clicks on the 'Товары' item in the dropdown menu to navigate to the Food page.
     * @return the FoodPage instance representing the Food page
     */
    public FoodPage clickDropdownItemGoods() {
        assertThat(dropdownGoods).isVisible();
        dropdownGoods.click();
        return pageManager.getFoodPage();
    }
}
