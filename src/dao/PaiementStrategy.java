package dao;

import entity.Article;

public abstract class PaiementStrategy {

    public abstract void payer(double montant) throws Exception;
    private static double  sum=0.0;
    public void displayBucket(Article a, double montant, int quantity) {

        this.sum=this.sum+montant;
        System.out.println(
                " ---Aticle  :  " + a.getName() + "---quantity" + quantity+
                " ---montantSansOffer : " + montant +"----Montant reel :"+quantity*a.getPrice()+"   Panier:--- Totale="+this.sum);
    }


}
