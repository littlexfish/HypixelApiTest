package org.lf.bazaar;

import com.google.gson.JsonObject;
import org.lf.api.reply.BazaarReply;
import org.lf.api.reply.ReplyType;
@SuppressWarnings("unused")
public class BazaarDecode {

    private final JsonObject ReplyResult;
    private final boolean hasProduct;
    private final boolean success;
    private final ProductElement pe;

    public BazaarDecode(BazaarReply br) {
        ReplyResult = br.getResult();
        if(ReplyResult == null) {
            throw new IllegalStateException("Not yet execute.");
        }
        else if(br.getReplytype() != ReplyType.BAZAAR) {
            throw new IllegalArgumentException("Not type of bazaar.");
        }
        hasProduct = br.hasProduct();
        success = ReplyResult.get("success").getAsBoolean();
        pe = new ProductElement(ReplyResult.get("product_info").getAsJsonObject());
    }
    public ProductElement getProduct() {
        if(hasProduct) {
            return pe;
        }
        else {
            throw new IllegalStateException("No product get");
        }
    }
    public boolean getSuccess() {
        return success;
    }
    public JsonObject getReplyResult() {
        return ReplyResult;
    }

    @Override
    public String toString() {
        return ReplyResult.toString();
    }
}
