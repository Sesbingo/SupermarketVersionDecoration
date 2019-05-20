package entity;

import dao.PaiementStrategy;

import java.util.HashMap;
import java.util.Map;

public class BasketList extends Article {


    private PaiementStrategy strategy;

    public Map<Article, PaiementStrategy> articlestrategy;// chaque article avec sa methode de paiement
    double montantTotale;

    private Article article;

    public BasketList() {

        this.articlestrategy = new HashMap<Article, PaiementStrategy>();
        this.montantTotale=0.0;
    }

    public PaiementStrategy getStrategy() {
        return strategy;
    }

    public Map<Article, PaiementStrategy> getArticlestrategy() {
        return articlestrategy;
    }

    public void setArticlestrategy(Map<Article, PaiementStrategy> articlestrategy) {
        this.articlestrategy = articlestrategy;
    }

    public void setMontantTotale(double montantTotale) {
        this.montantTotale = montantTotale;
    }

    public double getMontantTotale() {
        return montantTotale;
    }
}
