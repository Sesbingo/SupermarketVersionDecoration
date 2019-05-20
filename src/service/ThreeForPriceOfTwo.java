package service;

import dao.PaiementStrategy;
import entity.Article;

public class ThreeForPriceOfTwo extends PaiementStrategy {

    private Article article;
    private int quantity;
    private int totaleproduct;


    public ThreeForPriceOfTwo(Article article, int quantity) {

        super();
        this.article = article;
        this.quantity = quantity;
        this.totaleproduct = quantity;
    }
    @Override
    public void payer(double montant) throws Exception {

        montant=threeForPriceOfTwo(this.article);
        displayBucket(this.article, montant, this.getTotaleproduct());

    }




    public boolean isEmptyStock(Article a) {
        return a.getStock() == 0;
    }

    public void setStock(Article a, int quantity) {

        a.setStock(a.getStock() - quantity);
    }

    public void setTotaleproduct(int totaleproduct) {
        this.totaleproduct = totaleproduct;
    }

    public int getTotaleproduct() {
        return totaleproduct;
    }


    public double threeForPriceOfTwo(Article a) throws Exception {

        double totale = 0.0;
        if (isEmptyStock(a)) {
            throw new Exception("Stock Empty article name= "+a.getName());
        }

        if (a.getStock() >= 3) {
            if (this.quantity >= 3 && this.quantity <= a.getStock()) {

                int quotion = this.quantity / 3;

                totale = totale + (quotion * a.getPrice() * 2) + (this.quantity % 3) * a.getPrice();
                setStock(a, a.getStock() - this.quantity);
                return totale;

            } else if (this.quantity >= 3 && this.quantity > a.getStock()) {


                int quotion = a.getStock() / 3;

                totale = totale + (quotion * a.getPrice() * 2) + (a.getStock() % 3) * a.getPrice();

                a.setStock(0);
                return totale;

            } else {

                totale = totale + this.quantity * a.getPrice();
                a.setStock(a.getStock() - this.quantity);
                return totale;
            }

        } else {

            if (this.quantity >= 3) {

                totale = totale + a.getStock() * a.getPrice();
                setStock(a, 0);

                return totale;
            } else {
                if (a.getStock() > this.quantity) {

                    totale = totale + this.quantity * a.getPrice();
                    setStock(a, a.getStock() - this.quantity);
                    return totale;
                } else {

                    totale = totale + a.getStock() * a.getPrice();
                    setStock(a, this.quantity);
                    return totale;
                }

            }

        }

    }


}


