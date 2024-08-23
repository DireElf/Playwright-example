package elf.dire.pages;

import com.ibs.ui.base_page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;

public class HomePage extends BasePage {
//    @FindBy(xpath = "//a[@class='navbar-brand']")
//    private WebElement homePageTitle;
//    @FindBy(xpath = "//a[@id='navbarDropdown']")
//    private WebElement sandboxDropdown;
//    @FindBy(xpath = "//a[@class='dropdown-item' and @href='/food']")
//    private WebElement dropdownItemGoods;

    /**
     * Checks if the Home page is open by verifying the visibility of the title.
     * @return the current HomePage instance
     */

    public HomePage checkHomePageIsOpen() {
        assertTrue("Home page isn't open", homePageTitle.isDisplayed());
        return this;
    }

    /**
     * Clicks on the sandbox dropdown to reveal its items.
     * @return the current HomePage instance
     */

    public HomePage clickSandBoxDropdown() {
        assertTrue("Dropdown 'Песочница' isn't available", sandboxDropdown.isDisplayed());
        sandboxDropdown.click();
        return this;
    }

    /**
     * Clicks on the 'Goods' item in the dropdown menu to navigate to the Food page.
     * @return the FoodPage instance representing the Food page
     */

    public FoodPage clickDropdownItemGoods() {
        assertTrue("Dropdown item 'Товары' isn't available", dropdownItemGoods.isDisplayed());
        dropdownItemGoods.click();
        return pageManager.getFoodPage();
    }
}
