package service;

import dao.PaiementStrategy;
import entity.Article;

public class Unitprice extends PaiementStrategy {

    private Article article;
    private int quantity;


    public Unitprice() {

    }

    public Unitprice(Article article, int quantity) {
        super();
        this.article = article;
        this.quantity = quantity;


    }

    @Override

    public void payer(double montant) {

        montant = getMontantNodiscount();

        displayBucket(this.article, montant, this.quantity);

        this.article.setStock(this.article.getStock() - this.quantity);

    }


    public double getMontantNodiscount() {


        if (this.quantity > this.article.getStock())
            return this.article.getPrice() * this.article.getStock();
        return this.article.getPrice() * this.quantity;


    }


}


