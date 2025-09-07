package _17_ObserverDesignPattern;

public class NewsChannel implements Channel {
    private String news;

    @Override
    public void update(Object newsObject) {
        this.setNews((String) newsObject);
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

}
