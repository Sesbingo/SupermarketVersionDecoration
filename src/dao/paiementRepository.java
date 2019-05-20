package dao;
import entity.Article;

public interface paiementRepository {

	int getStockArticle(Article a);

	boolean checkStockNoEmpty(Article a, int quantity);

	double buyOneGetOneFree(Article a) throws Exception;

	double threeForPriceOfTwo(Article a) throws Exception;

	void setStock(Article a, int quantity);

	boolean isEmptyStock(Article a);
}