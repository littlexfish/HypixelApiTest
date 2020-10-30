package org.lf;

import org.lf.api.reply.AuctionReply;
import org.lf.api.reply.BazaarReply;
import org.lf.auction.AuctionDecode;
import org.lf.bazaar.BazaarDecode;
import org.lf.bazaar.ItemID;
import org.lf.exception.GetFailureException;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static final String api = "7e5e0042-f61b-42bc-a680-b14c98e20397";

    public static void main(String[] args) throws IOException, GetFailureException, URISyntaxException {
        AuctionDecode ad = new AuctionDecode((AuctionReply) new AuctionReply(api, AuctionReply.Type.player, "c87f79fb4bae4327a72362925d9dce60").execute());
        System.out.println(ad.getAuction(0).item_name);

    }

}
