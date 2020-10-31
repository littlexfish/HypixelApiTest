package org.lf.auction;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.lf.api.reply.AuctionReply;
import org.lf.api.reply.ReplyType;
import org.lf.exception.GetFailureException;

import java.util.ArrayList;
import java.util.List;

/**
 * A class can deal with json from {@link org.lf.api.reply.AuctionReply}.
 */
public class AuctionDecode {

    private JsonObject ReplyResult;
    private boolean success;
    private String cause;
    private List<AuctionElement> auctions;

    /**
     * Don't forget run {@link org.lf.api.reply.AuctionReply#execute()} before input.
     * @param ar - {@link org.lf.api.reply.AuctionReply}
     * @throws GetFailureException if success is false.
     */
    public AuctionDecode(AuctionReply ar) throws GetFailureException {
        ReplyResult = ar.getResult();
        if(ReplyResult == null) {
            throw new IllegalStateException("Not yet execute.");
        }
        else if(ar.getReplytype() != ReplyType.AUCTION) {
            throw new IllegalArgumentException("Not type of auction.");
        }
        success = ReplyResult.get("success").getAsBoolean();
        if(!success) {
            cause = ReplyResult.get("cause").getAsString();
            throw new GetFailureException("API get error. Cause: " + cause);
        }
        else {
            cause = null;
        }
        JsonArray ja = ReplyResult.get("auctions").getAsJsonArray();
        auctions = new ArrayList<>(ja.size());
        for (int i = 0; i < ja.size(); i++) {
            auctions.add(new AuctionElement(ja.get(i).getAsJsonObject()));
        }
    }
    /**
     * Get auction element to get information of the auction.
     * @return {@link org.lf.bazaar.ProductElement}
     */
    public List<AuctionElement> getAuctions() {
        return auctions;
    }
    /**
     * Get auction element to get information of the auction.
     * @param index - index.
     * @return {@link org.lf.bazaar.ProductElement}
     */
    public AuctionElement getAuction(int index) {
        return auctions.get(index);
    }
    /**
     * @return a boolean called success in json of result.
     */
    public boolean getSuccess() {
        return success;
    }
    /**
     * @return cause if get error, or null if nothing happened.
     */
    public String getCause() {
        return cause;
    }
    /**
     * @return all json content as {@link java.lang.String}
     */
    @Override
    public String toString() {
        return ReplyResult.toString();
    }
}
