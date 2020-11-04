package org.lf.bazaar;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.util.ArrayList;
import java.util.List;

/**
 * This class will be link to a product.
 */
public class ProductElement {

    /**
     * Product id.
     */
    public final String Product_ID;
    /**
     * Buy summary.
     * @see {@link org.lf.bazaar.Summary}
     */
    public final Summary buy;
    /**
     * Sell summary.
     * @see {@link org.lf.bazaar.Summary}
     */
    public final Summary sell;
    /**
     * Quick status.
     * @see {@link org.lf.bazaar.ProductElement.QuickData}
     */
    public final QuickData Quick_Status;
    /**
     * Week historic.<br>
     * If you use {@link org.lf.api.reply.BazaarReply#BazaarReply(String)}, will return <code>null</code>
     * @see {@link org.lf.bazaar.ProductElement.WeekData}
     */
    public final List<WeekData> Week_Historic;

    /**
     * @param info - {@link com.google.gson.JsonObject}
     */
    public ProductElement(JsonObject info) {
        Product_ID = info.get("product_id").getAsString();
        buy = new Summary(Summary.Type.BUY, info.get("buy_summary").getAsJsonArray());
        sell = new Summary(Summary.Type.SELL, info.get("buy_summary").getAsJsonArray());
        JsonObject qjo = info.get("quick_status").getAsJsonObject();
        Quick_Status = new QuickData(qjo.get("productId").getAsString(), qjo.get("buyPrice").getAsDouble(),
                qjo.get("buyVolume").getAsInt(), qjo.get("buyMovingWeek").getAsInt(), qjo.get("buyOrders").getAsInt(),
                qjo.get("sellPrice").getAsDouble(), qjo.get("sellVolume").getAsInt(), qjo.get("sellMovingWeek").getAsInt(),
                qjo.get("sellOrders").getAsInt());
        if(info.has("week_historic")) {
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
        else {
            Week_Historic = null;
        }
    }

    /**
     * Quick_Status
     */
    public class QuickData {
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

    /**
     * Week_Historic
     */
    public class WeekData {
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
