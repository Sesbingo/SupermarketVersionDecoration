package test.serviceTest;

import entity.Article;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ThreeForPriceOfTwo;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsThreeForPriceOfTwoTest {




    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void ThreeForPriceOfTwo1() throws Exception{

        Article watermelon = new Article("Watermelon", 0.8, 8);

        ThreeForPriceOfTwo paiementDiscount = new ThreeForPriceOfTwo(watermelon, 3);

        double montant = paiementDiscount.threeForPriceOfTwo(watermelon);

        BigDecimal bd = new BigDecimal(montant);

        bd = bd.setScale(4, BigDecimal.ROUND_DOWN);
        montant = bd.doubleValue();

        assertEquals(3.2000, montant);


    }


    @Test
    public void ThreeForPriceOfTwo2() throws Exception{
        Article watermelon = new Article("Watermelon", 0.8, 8);

        ThreeForPriceOfTwo paiementDiscount = new ThreeForPriceOfTwo(watermelon, 10);

        double montant = paiementDiscount.threeForPriceOfTwo(watermelon);

        BigDecimal bd = new BigDecimal(montant);

        bd = bd.setScale(4, BigDecimal.ROUND_DOWN);
        montant = bd.doubleValue();

        assertEquals(4.8000, montant);

    }


    @Test
    public void ThreeForPriceOfTwo3() throws Exception {
        Article watermelon = new Article("Watermelon", 0.8, 2);

        ThreeForPriceOfTwo paiementDiscount = new ThreeForPriceOfTwo(watermelon, 10);

        double montant = paiementDiscount.threeForPriceOfTwo(watermelon);

        BigDecimal bd = new BigDecimal(montant);

        bd = bd.setScale(4, BigDecimal.ROUND_DOWN);
        montant = bd.doubleValue();

        assertEquals(1.6000, montant);

    }


}
