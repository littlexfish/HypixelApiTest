package org.lf.bazaar;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class will store all of summary data from json.
 */
public class Summary {

    /**
     * Summary Type. BUY or SELL.
     */
    public enum Type {
        BUY, SELL
    }

    private final List<Data> content;
    private final Type T;

    /**
     * @param t - A summary type, BUY or SELL.
     * @param ja - {@link com.google.gson.JsonArray}
     */
    public Summary(Type t, JsonArray ja) {
        content = new ArrayList<>(ja.size());
        T = t;
        for(int i =0;i < ja.size();i++) {
            JsonObject jo = ja.get(i).getAsJsonObject();
            content.add(new Data(jo.get("amount").getAsInt(), jo.get("pricePerUnit").getAsDouble(), jo.get("orders").getAsInt()));
        }
    }

    /**
     * @return {@link org.lf.bazaar.Summary.Type}
     */
    public Type getSummaryType() {
        return T;
    }

    /**
     * @return {@link org.lf.bazaar.Summary.Data}
     */
    public Data getDataFromIndex(int index) {
        return content.get(index);
    }

    /**
     * Get all data.
     * @return {@link List}
     * @see #getDataFromIndex(int)
     */
    public List<Data> getContent() {
        return content;
    }

    /**
     * Get a list content all amount of data.
     * @return {@link java.util.List}
     */
    public List<Integer> getAllAmount() {
        List<Integer> list = new ArrayList<>(30);
        content.forEach(data -> list.add(data.amount));
        return list;
    }

    /**
     * Get a list content all pricePerUnit of data.
     * @return {@link java.util.List}
     */
    public List<Double> getAllPricePerUnit() {
        List<Double> list = new ArrayList<>(30);
        content.forEach(data -> list.add(data.pricePerUnit));
        return list;
    }

    /**
     * Get a list content all orders of data.
     * @return {@link java.util.List}
     */
    public List<Integer> getAllOrders() {
        List<Integer> list = new ArrayList<>(30);
        content.forEach(data -> list.add(data.orders));
        return list;
    }

    /**
     * Get an amount of data from index.
     * @param index - index of amount.
     * @return amount.
     */
    public int getAmount(int index) {
        return content.get(index).amount;
    }

    /**
     * @return amount of data.
     */
    public int size() {
        return content.size();
    }

    /**
     * Get an pricePerUnit of data from index.
     * @param index - index of pricePerUnit.
     * @return pricePerUnit.
     */
    public double getPricePerUnit(int index) {
        return content.get(index).pricePerUnit;
    }

    /**
     * Get an orders of data from index.
     * @param index - index of orders.
     * @return orders.
     */
    public int getOrders(int index) {
        return content.get(index).orders;
    }

    /**
     * Data of summary.
     */
    public class Data {
        public final int amount;
        public final double pricePerUnit;
        public final int orders;
        public Data(int a, double p, int o) {
            amount = a;
            pricePerUnit = p;
            orders = o;
        }
    }

}
