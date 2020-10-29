package org.lf.api.reply;

import java.io.IOException;

public class AuctionReply extends AbstractReply {

    public AuctionReply(String apiKey) throws IOException {
        super("https://api.hypixel.net/skyblock/auction?key=" + apiKey + "&player=Player UUID", ReplyType.AUCTION);
    }
}
