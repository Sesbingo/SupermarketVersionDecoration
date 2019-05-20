import entity.Article;
import entity.Offers;
import service.*;


public class Main {

    public static void main(String[] args) {

        //test avec interaction system au niveau console
        PrintService print = new PrintService();


        System.out.println("Partie Agent supermarche");

        //creation des articles
        Article apple = print.AddNewArticleInformation();
        Article watermelon = print.AddNewArticleInformation();
        Article orange = print.AddNewArticleInformation();


        System.out.println("Partie caissier");
        // Ajouter un Produit dans une panier
        BasketListService basketListeservice = print.newBasketListservice();
        print.addArticleToBusket(basketListeservice, apple);
        print.addArticleToBusket(basketListeservice, watermelon);
        print.addArticleToBusket(basketListeservice, orange);
        //paiement et affichage du panier
       basketListeservice.payerAllArticles();



        /*Test sans interaction*/
/*



        Article apple = new Article("Apple", 0.2, 10);
        Article watermelon = new Article("Watermelon", 0.8, 8);
        Article orange = new Article("Orange", 0.5, 7);

        BasketListService basketListe = new BasketListService();

        basketListe.addArticleToBasket(apple, new BuyOneGetOneFree(apple, 2));


        basketListe.addArticleToBasket(watermelon, new ThreeForPriceOfTwo(watermelon, 2));


        basketListe.addArticleToBasket(orange, new Unitprice(orange, 2));

        basketListe.payerAllArticles();






*/
    }
}