package org.lf.bazaar;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class ProductElement {

    private String Product_ID;
    private Summary buy;
    private Summary sell;
    /**
     * Data keyword in map below:<br>
     * "productID", "buyPrice", "buyVolume", "buyMovingWeek", "buyOrders",
     * "sellPrice", "sellVolume", "sellMovingWeek", "sellOrders"<br>
     * You can use these keyword to find value in map.
     */
    private QuickData Quick_Status;
    /**
     * Data keyword in map below:<br>
     * "productID", "timpstamp", "nowBuyVolume", "nowSellVolume", "buyCoins",
     * "buyVolume", "buys", "sellCoins", "sellVolume", "sells"<br>
     * You can use these keyword to find value in map.
     */
    private List<WeekData> Week_Historic;

    public ProductElement(JsonObject info) {
        Product_ID = info.get("product_id").getAsString();
        buy = new Summary(Summary.Type.BUY, info.get("buy_summary").getAsJsonArray());
        sell = new Summary(Summary.Type.SELL, info.get("buy_summary").getAsJsonArray());
        JsonObject qjo = info.get("quick_status").getAsJsonObject();
        Quick_Status = new QuickData(qjo.get("productId").getAsString(), qjo.get("buyPrice").getAsDouble(),
                qjo.get("buyVolume").getAsInt(), qjo.get("buyMovingWeek").getAsInt(), qjo.get("buyOrders").getAsInt(),
                qjo.get("sellPrice").getAsDouble(), qjo.get("sellVolume").getAsInt(), qjo.get("sellMovingWeek").getAsInt(),
                qjo.get("sellOrders").getAsInt());
        JsonArray ja = info.get("week_historic").getAsJsonArray();
        Week_Historic = new ArrayList<>(ja.size());
        for(int i = 0;i < ja.size();i++) {
            JsonObject jo = ja.get(i).getAsJsonObject();
            Week_Historic.add(new WeekData(jo.get("productId").getAsString(), jo.get("timestamp").getAsInt(),
                    jo.get("nowBuyVolume").getAsInt(), jo.get("nowSellVolume").getAsInt(),
                    jo.get("buyCoins").getAsDouble(), jo.get("buyVolume").getAsInt(), jo.get("buys").getAsInt(),
                    jo.get("sellCoins").getAsDouble(), jo.get("sellVolume").getAsInt(), jo.get("sells").getAsInt()));
        }
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

    public QuickData getQuickStatus() {
        return Quick_Status;
    }

    public WeekData getWeekHistoric(int index) {
        return Week_Historic.get(index);
    }

    public List<WeekData> getAllWeekHistoric() {
        return Week_Historic;
    }

    private class QuickData {
        public final String productId;
        public final double buyPrice;
        public final int buyVolume;
        public final int buyMovingWeek;
        public final int buyOrders;
        public final double sellPrice;
        public final int sellVolume;
        public final int sellMovingWeek;
        public final int sellOrders;
        public QuickData(String pid, double bp, int bv, int bmw, int bo, double sp, int sv, int smw, int so) {
            productId = pid;
            buyPrice = bp;
            buyVolume = bv;
            buyMovingWeek = bmw;
            buyOrders = bo;
            sellPrice = sp;
            sellVolume = sv;
            sellMovingWeek = smw;
            sellOrders = so;
        }
    }

    private class WeekData {
        public final String productId;
        public final int timestamp;
        public final int nowBuyVolume;
        public final int nowSellVolume;
        public final double buyCoins;
        public final int buyVolume;
        public final int buys;
        public final double sellCoins;
        public final int sellVolume;
        public final int sells;
        public WeekData(String pid, int t, int nbv, int nsv, double bc, int bv, int b, double sc, int sv, int s) {
            productId = pid;
            timestamp = t;
            nowBuyVolume = nbv;
            nowSellVolume = nsv;
            buyCoins = bc;
            buyVolume = bv;
            buys = b;
            sellCoins = sc;
            sellVolume = sv;
            sells = s;
        }

    }

}
