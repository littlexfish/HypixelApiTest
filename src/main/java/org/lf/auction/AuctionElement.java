package org.lf.auction;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class will link to a auction.
 */
public class AuctionElement {
    /**
     * Category in auction of Hypixel skyblok.
     */
    public enum Category {
        CONSUMABLES,
        MISC,
        WEAPON,
        BLOCKS,
        ACCESSORIES,
        ARMOR,
        ;
        @Override
        public String toString() {
            return name().toLowerCase();
        }
    }
    /**
     * Rarity of item.
     */
    public enum Tier {
        COMMON,
        UNCOMMON,
        RARE,
        EPIC,
        LEGENDARY,
        MYTHIC,
        SPECIAL,
        ;


    }
    /**
     * DOCUMENT ME
     * I don't know what is this, but it have.
     */
    public final String _id;
    /**
     * Auction uuid.
     */
    public final String uuid;
    /**
     * Auctioneer uuid
     */
    public final String auctioneer;
    /**
     * Profile id.
     */
    public final String profile_id;
    /**
     * All of co-operation player uuid.
     */
    public final List<String> coop;
    /**
     * Start time.
     */
    public final long start;
    /**
     * End time.
     */
    public final long end;
    /**
     * Item name.
     */
    public final String item_name;
    /**
     * Item lore. Just plain text.
     */
    public final String item_lore;
    /**
     * DOCUMENT ME.
     */
    public final String extra;
    /**
     * Item of category.
     */
    public final Category category;
    /**
     * Item of tier.
     */
    public final Tier tier;
    /**
     * How much bid starting.
     */
    public final int starting_bid;
    /**
     * DOCUMENT ME.
     * @see {@link org.lf.auction.AuctionElement.Item_Bytes}
     */
    public final Item_Bytes item_bytes;
    /**
     * <code>true</code> if item is claimed.
     */
    public final boolean claim;
    /**
     * UUID of bidders who claim.
     */
    public final List<String> claimed_bidders;
    /**
     * The highest bid amount of this auction.
     */
    public final int highest_bid_amount;
    /**
     * All of info of bids.
     */
    public final List<Bid> bids;

    /**
     * @param jo - {@link com.google.gson.JsonObject}
     */
    public AuctionElement(JsonObject jo) {
        _id = jo.get("_id").getAsString();
        uuid = jo.get("uuid").getAsString();
        auctioneer = jo.get("auctioneer").getAsString();
        profile_id = jo.get("profile_id").getAsString();
        JsonArray coja = jo.get("coop").getAsJsonArray();
        coop = new ArrayList<>(coja.size());
        for (int i = 0;i < coja.size();i++) {
            coop.add(coja.get(i).getAsString());
        }
        start = jo.get("start").getAsLong();
        end = jo.get("end").getAsLong();
        item_name = jo.get("item_name").getAsString();
        item_lore = jo.get("item_lore").getAsString();
        extra = jo.get("extra").getAsString();
        category = Category.valueOf(jo.get("category").getAsString().toUpperCase());
        tier = Tier.valueOf(jo.get("tier").getAsString());
        starting_bid = jo.get("starting_bid").getAsInt();
        JsonObject ijo = jo.get("item_bytes").getAsJsonObject();
        item_bytes = new Item_Bytes(ijo.get("type").getAsInt(), ijo.get("data").getAsString());
        claim = jo.get("claimed").getAsBoolean();
        JsonArray cbja = jo.get("claimed_bidders").getAsJsonArray();
        claimed_bidders = new ArrayList<>(cbja.size());
        for (int i = 0;i < cbja.size();i++) {
            claimed_bidders.add(cbja.get(i).getAsString());
        }
        highest_bid_amount = jo.get("highest_bid_amount").getAsInt();
        JsonArray bja = jo.get("bids").getAsJsonArray();
        bids = new ArrayList<>(bja.size());
        for (int i = 0; i < bja.size(); i++) {
            JsonObject bjo = bja.get(i).getAsJsonObject();
            bids.add(new Bid(bjo.get("auction_id").getAsString(), bjo.get("bidder").getAsString(), bjo.get("profile_id").getAsString(), bjo.get("amount").getAsInt(), bjo.get("timestamp").getAsLong()));
        }
    }

    /**
     * A key called item_byte in json of auction.
     */
    public class Item_Bytes {
        public final int type;
        public final String data;
        public Item_Bytes(int t, String d) {
            type = t;
            data = d;
        }
    }

    /**
     * A data of info of bid.
     */
    public class Bid {
        public final String auction_id;
        public final String bidder;
        public final String profile_id;
        public final int amount;
        public final long timestamp;
        public Bid(String au, String b, String p, int am, long t) {
            auction_id = au;
            bidder = b;
            profile_id = p;
            amount = am;
            timestamp = t;
        }
    }
}
