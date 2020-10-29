package org.lf.bazaar;


import java.util.List;
import java.util.Map;

public class ProductElement {

    private String Product_ID;
    private Summary buy;
    private Summary sell;
    private Map<String, String> Quick_Status;
    private List<Map<String, String>> Week_Historic;

    public ProductElement() {


    }

    public String getProduct_ID() {
        return Product_ID;
    }

    public Summary getBuy() {
        return buy;
    }

    public Summary getSell() {
        return sell;
    }

    public Map<String, String> getQuick_Status() {
        return Quick_Status;
    }

    public List<Map<String, String>> getWeek_Historic() {
        return Week_Historic;
    }
}
