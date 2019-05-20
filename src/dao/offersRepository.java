package dao;

import entity.Offers;

public interface offersRepository {

    Offers findByCodecoffer(int codeoffer);
    Offers findByNmeOffers(String nameoffers);
    Offers saveOffer(Offers offers);
    boolean isOfferExist(int codeOffer);
    void deleteOffer(int codeOffer);

}
