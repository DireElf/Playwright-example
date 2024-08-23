package elf.dire.tests;

import elf.dire.models.Good;
import elf.dire.pages.HomePage;
import elf.dire.tests.base_test.BaseTest;
import elf.dire.utils.TestDataUtils;
import org.junit.jupiter.api.Test;

import static elf.dire.utils.constants.PropConst.TEST_APP_URL;

public class AddGoodTest extends BaseTest {
    private final Good fruitExotic = TestDataUtils.getGoodFromJsonFile("pineapple.json");
    private final Good vegetableNonExotic = TestDataUtils.getGoodFromJsonFile("carrot.json");

    @Test
    void testAddFruitExotic() {
        HomePage homePage = pageManager.getHomePage(page);
        page.navigate(propManager.getProperty(TEST_APP_URL));
        homePage
                .checkHomePageIsOpen()
                .clickSandBoxDropdown()
                .clickDropdownItemGoods(page)
                .checkFoodPageIsOpen()
                .checkTableColumnsNames()
                .clickButtonAdd(page)
                .checkModalWindowIsDisplayed()
                .checkModalWindowElementsPresence()
                .fillGoodName(fruitExotic.getName())
                .selectType(fruitExotic.getType().getValue())
                .selectCheckBoxExotic(true)
                .saveNewGood(page)
                .checkIfGoodAdded()
                .checkLastRowContent(
                        fruitExotic.getName(),
                        fruitExotic.getType().getValue(),
                        fruitExotic.isExotic());
    }
}
