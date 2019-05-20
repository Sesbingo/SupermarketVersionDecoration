package exception;

public class MarketException extends Exception {

    public MarketException() {
    }

    public MarketException(int stock ) {
        System.out.print("Article avec stock négatif"+stock);
    }


}
