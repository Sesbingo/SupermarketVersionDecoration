package service;

import dao.BasketListRepository;
import dao.PaiementStrategy;
import entity.Article;
import entity.BasketList;


public class BasketListService implements BasketListRepository {

    private BasketList basketList;

    double sum=0.0;
    public BasketListService() {


        this.basketList = new BasketList();


    }

    @Override
    public void addArticleToBasket(Article a, PaiementStrategy strategy) {


        try {

            this.basketList.getArticlestrategy().put(a, strategy);


        } catch (Exception e) {
            System.out.println("Article " + a.getName() + " existe ");

        }

    }

    @Override
    public void displaybasketlistArticles() {
        this.basketList.getArticlestrategy().forEach((k, v) -> System.out.println("Article : " + k.getName()));

    }

    @Override
    public void payerAllArticles() {

        this.basketList.getArticlestrategy().forEach((k, v) -> {
            try {
                sum=k.getTotale();
                v.payer(k.getTotale());
            } catch (Exception e) {
                e.printStackTrace();
            }

        });


    }

    @Override
    public void removeArticleToBasket(Article a) {

        try {
            this.basketList.getArticlestrategy().remove(a);

        } catch (Exception e) {
            System.out.println("Article: " + a.getName() + " n'existe pas ");

        }

    }

    @Override
    public void clearBasketList() {
        this.basketList.getArticlestrategy().clear();
    }
}
