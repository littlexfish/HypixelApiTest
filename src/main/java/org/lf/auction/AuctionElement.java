package org.lf.auction;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.rmi.CORBA.Tie;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AuctionElement {
    public enum Category {
        CONSUMABLES,
        MISC,

        ;
        @Override
        public String toString() {
            return name().toLowerCase();
        }

    }
    public enum Tier {
        COMMON,
        RARE,

        ;


    }
    //https://api.mojang.com/users/profiles/minecraft/playername
    private UUID _id;
    private UUID uuid;
    private UUID auctioneer;
    private UUID profile_id;
    private List<UUID> coop;
    private long start;
    private long end;
    private String item_name;
    private String item_lore;
    private String extra;
    private Category category;
    private Tier tier;
    private int starting_bid;
    private Item_Bytes item_bytes;
    private boolean claim;
    private List<UUID> claimed_bidders;
    private int highest_bid_amount;
    private List<Bid> bids;

    public AuctionElement(JsonObject jo) {
        _id = UUID.fromString(jo.get("_id").getAsString());
        uuid = UUID.fromString(jo.get("uuid").getAsString());
        auctioneer = UUID.fromString(jo.get("auctioneer").getAsString());
        profile_id = UUID.fromString(jo.get("profile_id").getAsString());
        JsonArray coja = jo.get("coop").getAsJsonArray();
        coop = new ArrayList<>(coja.size());
        for (int i = 0;i < coja.size();i++) {
            coop.add(UUID.fromString(coja.get(i).getAsString()));
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
            claimed_bidders.add(UUID.fromString(cbja.get(i).getAsString()));
        }
        highest_bid_amount = jo.get("highest_bid_amount").getAsInt();
        JsonArray bja = jo.get("bids").getAsJsonArray();
        bids = new ArrayList<>(bja.size());
        for (int i = 0; i < bja.size(); i++) {
            JsonObject bjo = bja.get(i).getAsJsonObject();
            bids.add(new Bid(UUID.fromString(bjo.get("auction_id").getAsString()), UUID.fromString(bjo.get("bidder").getAsString()), UUID.fromString(bjo.get("profile_id").getAsString()), bjo.get("amount").getAsInt(), bjo.get("timestamp").getAsLong()));
        }
    }

    private class Item_Bytes {
        private int type;
        private String data;
        public Item_Bytes(int t, String d) {
            type = t;
            data = d;
        }
        public int getType() {
            return type;
        }
        public String getData() {
            return data;
        }
    }
    private class Bid {
        private UUID auction_id;
        private UUID bidder;
        private UUID profile_id;
        private int amount;
        private long timestamp;
        public Bid(UUID au, UUID b, UUID p, int am, long t) {
            auction_id = au;
            bidder = b;
            profile_id = p;
            amount = am;
            timestamp = t;
        }
        public UUID getAuction_id() {
            return auction_id;
        }
        public UUID getBidder() {
            return bidder;
        }
        public UUID getProfile_id() {
            return profile_id;
        }
        public int getAmount() {
            return amount;
        }
        public long getTimestamp() {
            return timestamp;
        }
    }
}
