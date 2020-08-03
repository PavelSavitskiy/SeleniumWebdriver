package utils;

import com.epam.cdp.kzta2020.pages.SearchPage;


import java.util.Random;

public class RandomOrdinalNumberOfGoodsOnPage extends SearchPage {
    private int ordinalNumber;

    public int getNumber() {
        return ordinalNumber;
    }

    private RandomOrdinalNumberOfGoodsOnPage(){
        int quantityOfGoodsOnPage =  getResults().size();
        ordinalNumber=new Random().nextInt(quantityOfGoodsOnPage)+1;
    }
    public static RandomOrdinalNumberOfGoodsOnPage getRandomNumber(){
        return new RandomOrdinalNumberOfGoodsOnPage();
    }
}
