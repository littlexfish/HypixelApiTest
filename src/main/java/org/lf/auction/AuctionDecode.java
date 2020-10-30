package org.lf.auction;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.lf.api.reply.AuctionReply;
import org.lf.api.reply.ReplyType;
import org.lf.exception.GetFailureException;

import java.util.ArrayList;
import java.util.List;

public class AuctionDecode {

    private JsonObject ReplyResult;
    private boolean success;
    private String cause;
    private List<AuctionElement> auctions;

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

    public List<AuctionElement> getAuctions() {
        return auctions;
    }

    public AuctionElement getAuction(int index) {
        return auctions.get(index);
    }

    public boolean getSuccess() {
        return success;
    }

    public String getCause() {
        return cause;
    }

}
