package elf.dire.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.SelectOption;
import elf.dire.pages.base_page.BasePage;
import elf.dire.utils.TestDataUtils;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ModalWindow extends BasePage {
    private final Locator modalWindowTitle = page.locator("//h5[@class='modal-title']");
    private final Locator nameInputField = page.locator("//input[@id='name']");
    private final Locator goodTypeDropdown = page.locator("//select[@id='type']");
    private final Locator checkBoxIsExotic = page.locator("//input[@id='exotic']");
    private final Locator buttonSave = page.locator("//button[@id='save']");

    /**
     * Checks if the modal window is displayed by verifying the visibility of its title.
     *
     * @return the current ModalWindow instance
     */
    public ModalWindow checkModalWindowIsDisplayed() {
        assertThat(modalWindowTitle).isVisible();
        return this;
    }

    /**
     * Validates the presence of all essential elements within the modal window.
     *
     * @return the current ModalWindow instance
     */
    public ModalWindow checkModalWindowElementsPresence() {
        assertThat(nameInputField).isVisible();
        assertThat(goodTypeDropdown).isVisible();
        assertThat(checkBoxIsExotic).isVisible();
        assertThat(checkBoxIsExotic).isVisible();
        return this;
    }

    /**
     * Fills in the name of the good in the modal window's input field.
     *
     * @param name the name to be entered
     * @return the current ModalWindow instance
     */
    public ModalWindow fillGoodName(String name) {
        nameInputField.fill(name);
        return this;
    }

    /**
     * Selects the type of good from the dropdown menu in the modal window.
     *
     * @param type the type to be selected
     * @return the current ModalWindow instance
     */
    public ModalWindow selectType(String type) {
        goodTypeDropdown.selectOption(type);
        return this;
    }

    /**
     * Selects the "Exotic" checkbox if the good is exotic, ensuring it's selected correctly.
     *
     * @param shouldBeExotic the exotic status
     * @return the current ModalWindow instance
     */
    public ModalWindow selectCheckBoxExotic(Boolean shouldBeExotic) {
        assertFalse(checkBoxIsExotic.isChecked());
        if (shouldBeExotic) {
            checkBoxIsExotic.click();
            assertThat(checkBoxIsExotic).isChecked();
        }
        return this;
    }

    /**
     * Saves the new good by clicking the "Save" button and waits for the modal window to close.
     *
     * @return the FoodPage instance representing the Food page
     */
    public FoodPage saveNewGood() {
        buttonSave.click();
        return pageManager.getFoodPage();
    }
}
