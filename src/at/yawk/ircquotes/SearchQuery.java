package at.yawk.ircquotes;

public class SearchQuery {
    private final Order order;
    
    public SearchQuery(Order order) {
        this.order = order;
    }
    
    public Order getOrder() {
        return order;
    }
    
    public static enum Order {
        RANDOM,
        BEST,
        NEWEST,
    }
}
