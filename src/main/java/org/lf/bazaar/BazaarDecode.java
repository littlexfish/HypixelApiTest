package org.lf.bazaar;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.lf.api.reply.BazaarReply;
import org.lf.api.reply.ReplyType;

public class BazaarDecode {

    private JsonObject ReplyResult;
    private boolean hasProduct;
    private boolean success;
    private ProductElement pe;

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

    public JsonObject getReplyResult() {
        return ReplyResult;
    }

    @Override
    public String toString() {
        return ReplyResult.toString();
    }
}
