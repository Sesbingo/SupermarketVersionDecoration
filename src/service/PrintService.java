package service;

import dao.PaiementStrategy;
import entity.Article;
import entity.Offers;

import java.util.Scanner;

public class PrintService {


    public PrintService() {

    }

    public Article AddNewArticleInformation() {


        Scanner sc = new Scanner(System.in);
        System.out.println("--------------Ajouter un nouveau Article------------");


        try {
            System.out.println("Ajouter article:");

            String name = sc.nextLine();

            System.out.println("Enter  prix:");
            double price = Double.parseDouble(sc.nextLine());

            System.out.println("entrer la quantité du stock souhaiter :");
            int stock = sc.nextInt();

            return new Article(name, price, stock);

        } catch (Exception e) {
            System.out.println("Merci de vérifier types et formats des données");
            return null;
        }


    }


    public void addArticleToBusket(BasketListService basketListservice, Article a) {
        int choicestrategy;
        try  {
            Scanner sc = new Scanner(System.in);
            System.out.println("------------: Aticles : " + a.getName() + " ------------");

            System.out.println("Choisir paiement avec offer 0 sans offer 1:");

            choicestrategy = sc.nextInt();

            if (choicestrategy == 0) {
                basketListservice.addArticleToBasket(a, choiceStrategyDiscount(a));

            } else {
                basketListservice.addArticleToBasket(a, choiceStrategyNoDiscount(a));

            }
        }catch(Exception e){
            System.out.print("Problème au niveau de paiement");
        }



    }


    public PaiementStrategy choiceStrategyDiscount(Article a) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Entrer quantite :");
            int quantity = sc.nextInt();

            System.out.println("Entrer code:  0 :sans offer 1: buyonegetone  :2:ThreeforpriceOtwo  :");
            int numOffer = sc.nextInt();




            if(numOffer == 0){
                return new Unitprice(a, quantity);

            }else  if(numOffer == 1){
                return new BuyOneGetOneFree(a, quantity);


            }else if(numOffer == 2){

                return new ThreeForPriceOfTwo(a, quantity);

            }else {
                System.out.println("Merci de chosir un autre code offer");


                return  choiceStrategyDiscount(new Article());

            }



        } catch (Exception e) {
            System.out.println("Merci de vérifier types et formats des données");
            return null;

        }


    }

    public PaiementStrategy choiceStrategyNoDiscount(Article a) {


        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Choisir quantite :");
            int quantity = sc.nextInt();

            return new Unitprice(a, quantity);
        } catch (Exception e) {

            System.out.println("Merci de vérifier types et formats des données");
            return null;
        }

    }

    public BasketListService newBasketListservice() {

        System.out.println("new BasketList");

        return new BasketListService();
    }


}
