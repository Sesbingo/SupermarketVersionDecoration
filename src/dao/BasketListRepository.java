package dao;

import entity.Article;

public interface BasketListRepository {

    void addArticleToBasket(Article a, PaiementStrategy strategy);
    void displaybasketlistArticles() ;
    void payerAllArticles() ;
    void removeArticleToBasket(Article a);
    void clearBasketList();

    }
