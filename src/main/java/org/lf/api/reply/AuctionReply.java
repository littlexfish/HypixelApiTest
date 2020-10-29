package org.lf.api.reply;

import java.io.IOException;

public class AuctionReply extends AbstractReply {

    public enum Type {
        player,
        profile,
        uuid
    }

    public AuctionReply(String apiKey, Type t, String value) throws IOException {
        super("https://api.hypixel.net/skyblock/auction?key=" + apiKey + "&" + t.toString() + "=" + value, ReplyType.AUCTION);
    }
}
