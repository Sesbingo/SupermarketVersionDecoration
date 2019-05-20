package test.serviceTest;



import entity.Article;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.BuyOneGetOneFree;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsBuyOneGetOneFreeTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }







    @Test
    public void BuyOneGetOneFreeTestOne() throws Exception {
        Article apple = new Article("Apple", 0.2, 10);

        BuyOneGetOneFree paiementDiscount = new BuyOneGetOneFree(apple, 3);


        double montant = paiementDiscount.buyOneGetOneFree(apple);
        System.out.println(montant);
        BigDecimal bd = new BigDecimal(montant);

        bd = bd.setScale(4, BigDecimal.ROUND_DOWN);
        montant = bd.doubleValue();

        assertEquals(0.6000, montant);

    }


    @Test
    public void BuyOneGetOneFreeTestTwo() throws Exception {
        Article apple = new Article("Apple", 0.2, 4);

        BuyOneGetOneFree paiementDiscount = new BuyOneGetOneFree(apple, 5);


        double montant = paiementDiscount.buyOneGetOneFree(apple);
        System.out.println(montant);
        BigDecimal bd = new BigDecimal(montant);

        bd = bd.setScale(4, BigDecimal.ROUND_DOWN);
        montant = bd.doubleValue();

        assertEquals(0.4000, montant);

    }


    @Test
    public void BuyOneGetOneFreeTestTree() throws Exception{
        Article apple = new Article("Apple", 0.2, 4);

        BuyOneGetOneFree paiementDiscount = new BuyOneGetOneFree(apple, 3);


        double montant = paiementDiscount.buyOneGetOneFree(apple);
        BigDecimal bd = new BigDecimal(montant);

        bd = bd.setScale(4, BigDecimal.ROUND_DOWN);
        montant = bd.doubleValue();

        assertEquals(0.4000, montant);

    }




}
