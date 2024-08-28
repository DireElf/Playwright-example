package elf.dire.pages;

import com.microsoft.playwright.Locator;
import elf.dire.pages.base_page.BasePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FoodPage extends BasePage {
    private final Locator tableHeader = page.locator("//h5[1]");
    private final Locator table = page.locator("table");
    private final Locator goodName = page.locator("//tr/th[text()='Наименование']");
    private final Locator goodType = page.locator("//tr/th[text()='Тип']");
    private final Locator isGoodExotic = page.locator("//tr/th[text()='Экзотический']");
    private final Locator buttonAdd = page.locator("//button[text()='Добавить']");
    private final Locator tableRowsNumber = page.locator("//th[@scope='row']");
    private int tableRowsCount;


    /**
     * Checks if the Food page is open by verifying the table header.
     *
     * @return the current FoodPage instance
     */
    public FoodPage checkFoodPageIsOpen() {
        assertThat(tableHeader.nth(0)).hasText("Список товаров");
        return this;
    }

    /**
     * Validates the presence and correctness of the table columns on the Food page.
     *
     * @return the current FoodPage instance
     */
    public FoodPage checkTableColumnsNames() {
        assertThat(table).isVisible();
        assertThat(goodName).hasText("Наименование");
        assertThat(goodType).hasText("Тип");
        assertThat(isGoodExotic).hasText("Экзотический");
        return this;
    }

    /**
     * Clicks the "Add" button to open a modal window for adding a new item.
     *
     * @return the ModalWindow instance representing the modal dialog
     */
    public ModalWindow clickButtonAdd() {
        tableRowsCount = tableRowsNumber.count();
        assertThat(buttonAdd).isVisible();
        buttonAdd.click();
        return pageManager.getModalWindow();
    }

    /**
     * Checks if a new item has been added to the table by comparing the row count before and after refresh.
     *
     * @return the current FoodPage instance
     */
    public FoodPage checkIfGoodAdded() {
        assertThat(tableRowsNumber).hasCount(++tableRowsCount);
        return this;
    }

    /**
     * Verifies the content of the last row in a table based on the provided parameters.
     *
     * @param goodName the expected name of the good in the last row.
     * @param goodType the expected type of the good in the last row.
     * @param isExotic the expected exotic status of the good in the last row.
     * @return the current instance of the FoodPage.
     * @throws AssertionError if the content of the last row does not match the provided parameters.
     */
    public FoodPage checkLastRowContent(String goodName, String goodType, boolean isExotic) {
        Locator lastAddedRowXpath = page.locator(
                "//th[@scope='row' and text()='" + tableRowsCount + "']/following-sibling::td");

        assertThat(lastAddedRowXpath.nth(0)).hasText(goodName);
        assertThat(lastAddedRowXpath.nth(1)).hasText(goodType);
        assertThat(lastAddedRowXpath.nth(2)).hasText(String.valueOf(isExotic));
        return this;
    }
}
