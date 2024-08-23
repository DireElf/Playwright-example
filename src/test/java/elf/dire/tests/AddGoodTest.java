package elf.dire.tests;

import elf.dire.models.Good;
import elf.dire.pages.base_page.BasePage;
import elf.dire.tests.base_test.BaseTest;
import elf.dire.utils.TestDataUtils;
import org.junit.jupiter.api.Test;

import static elf.dire.utils.constants.PropConst.TEST_APP_URL;

public class AddGoodTest extends BaseTest {
    private final Good fruitExotic = TestDataUtils.getGoodFromJsonFile("pineapple.json");
    private final Good vegetableNonExotic = TestDataUtils.getGoodFromJsonFile("carrot.json");

    @Test
    void testAddVegetableNonExotic() {
        BasePage.setPage(page);
        page.navigate(propManager.getProperty(TEST_APP_URL));
        pageManager.getHomePage()
                .checkHomePageIsOpen()
                .clickSandBoxDropdown()
                .clickDropdownItemGoods()
                .checkFoodPageIsOpen()
                .checkTableColumnsNames()
                .clickButtonAdd()
                .checkModalWindowIsDisplayed()
                .checkModalWindowElementsPresence()
                .fillGoodName(vegetableNonExotic.getName())
//                .selectType(fruitExotic.getType().getValue())
                .selectCheckBoxExotic(false)
                .saveNewGood()
                .checkIfGoodAdded()
                .checkLastRowContent(
                        vegetableNonExotic.getName(),
                        vegetableNonExotic.getType().getValue(),
                        vegetableNonExotic.isExotic());
    }
}
