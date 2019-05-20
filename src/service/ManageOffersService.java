package service;

import dao.offersRepository;
import entity.Offers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ManageOffersService implements offersRepository {

    private Offers offer = new Offers();
    private List<Offers> listoffers = new ArrayList<Offers>();

    public ManageOffersService() {

    }

    public ManageOffersService(List<Offers> listoffers, Offers offer) {

        this.listoffers = listoffers;
        this.offer = offer;

    }

    public ManageOffersService(List<Offers> listoffers) {

        this.listoffers = listoffers;

    }







    @Override
    public Offers saveOffer(Offers offers) {

        if (!isOfferExist(offers.getCodeoffer())) {
            listoffers.add(offers);
            return offers;
        }
        return null;

    }
    @Override
    public boolean isOfferExist(int codeOffer) {


        return IntStream.range(0, listoffers.size())
                .anyMatch(i -> listoffers.get(i).getCodeoffer() == codeOffer);

    }

    public boolean isOfferExistByNmae(String nameoffer) {


        return IntStream.range(0, listoffers.size())
                .anyMatch(i -> listoffers.get(i).getNameOffer() == nameoffer);

    }

    @Override
    public void deleteOffer(int codeOffer) {
        if (isOfferExist(codeOffer)) {

            listoffers.remove(codeOffer);
            System.out.println("Offer delete succes");
        } else {

            System.out.println("Offer doesn't exist");
        }
    }


    @Override
    public Offers findByCodecoffer(int codeoffer) {


        if (isOfferExist(codeoffer))
            return offer;
        return null;
    }


    @Override
    public Offers findByNmeOffers(String nameoffers) {
        if (isOfferExistByNmae(nameoffers))
            return offer;
             return null;


    }

}