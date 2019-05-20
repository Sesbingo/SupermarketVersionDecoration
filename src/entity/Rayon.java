package entity;

import java.util.ArrayList;
import java.util.List;

public class Rayon {


    private String name;
    private  List<Article> articles;


    public Rayon(String name) {
        this.name = name;
        this.articles = new ArrayList<Article>();

    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public String getName() {
        return name;
    }

    public void add(Article e) {
        articles.add(e);
    }

    public void remove(Article e) {
        articles.remove(e);
    }


    public List<Article> getArticles() {
        return articles;
    }


}
