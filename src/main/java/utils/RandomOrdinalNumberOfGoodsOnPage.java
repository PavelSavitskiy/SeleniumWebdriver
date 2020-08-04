package utils;

import java.util.List;
import java.util.Random;

public class RandomOrdinalNumberOfGoodsOnPage {
    private int quantityOfGoodsOnPage;
    private int ordinalNumber;

    public int getNumber() {
        return ordinalNumber;
    }

    public RandomOrdinalNumberOfGoodsOnPage(List list) {
        this.quantityOfGoodsOnPage = list.size();
        this.ordinalNumber = new Random().nextInt(quantityOfGoodsOnPage) + 1;
    }
}
