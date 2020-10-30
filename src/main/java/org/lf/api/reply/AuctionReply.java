package org.lf.api.reply;

import java.io.IOException;

/**
 * This reply will get something json from auction of Hypixel skyblock.
 */
public class AuctionReply extends AbstractReply {

    /**
     * You need to use one of these type to get auction info.
     */
    public enum Type {
        player,
        profile,
        uuid
    }

    /**
     * Remember use {@link #execute()} before put into {@link org.lf.auction.AuctionDecode}
     * @param apiKey - Using /api in Hypixel to use this class.
     * @param t - {@link org.lf.api.reply.AuctionReply.Type}
     * @param value - value after type.
     * @throws IOException if get json error.
     */
    public AuctionReply(String apiKey, Type t, String value) throws IOException {
        super("https://api.hypixel.net/skyblock/auction?key=" + apiKey + "&" + t.toString() + "=" + value, ReplyType.AUCTION);
    }
}
