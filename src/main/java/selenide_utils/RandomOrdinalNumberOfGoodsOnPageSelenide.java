package selenide_utils;

import com.codeborne.selenide.ElementsCollection;
import java.util.Random;

public class RandomOrdinalNumberOfGoodsOnPageSelenide {
    private int quantityOfGoodsOnPage;
    private int ordinalNumber;

    public int getNumber() {
        return ordinalNumber;
    }

    public RandomOrdinalNumberOfGoodsOnPageSelenide(ElementsCollection list) {
        this.quantityOfGoodsOnPage = list.size();
        this.ordinalNumber = new Random().nextInt(quantityOfGoodsOnPage) + 1;
    }
}
