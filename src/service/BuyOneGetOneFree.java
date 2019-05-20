package service;

import dao.PaiementStrategy;
import entity.Article;
import entity.Offers;

public class BuyOneGetOneFree extends PaiementStrategy {

    private Article article;
    private int quantity;
    private int totaleproduct;



    public BuyOneGetOneFree(Article article, int quantity) {


        super();
        this.article = article;
        this.quantity = quantity;
        this.totaleproduct = quantity;

    }

    @Override
    public void payer(double montant) throws Exception {

        montant=buyOneGetOneFree(this.article);
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

    public double buyOneGetOneFree(Article a) throws Exception {

        double totale = 0.0;

        if (isEmptyStock(a)) {



            throw new Exception("Stock Empty article name= "+a.getName());
        } else {
            int rest = a.getStock() - this.quantity;

            if (rest < 0) {

                int quotion = a.getStock() / 2;

                totale = totale + (a.getStock() % 2) * a.getPrice() + quotion * a.getPrice();
                setTotaleproduct(this.quantity);
                setStock(a, 0);
                return totale;
            } else {

                if (rest > this.quantity * 2) {

                    totale = totale + a.getPrice() * this.quantity;
                    setTotaleproduct(this.quantity * 2);
                    a.setStock(a.getStock() - this.quantity * 2);
                    return totale;

                } else {

                    if (this.quantity % 2 == 0)
                        totale = totale + a.getPrice() * this.quantity / 2;
                    else
                        totale = totale + a.getPrice() * ((this.quantity + 1) / 2) + a.getPrice() * this.quantity;

                    setTotaleproduct(this.quantity);
                    setStock(a, a.getStock() - this.quantity + a.getStock() % this.quantity);
                    return totale;

                }
            }
        }

    }

}
