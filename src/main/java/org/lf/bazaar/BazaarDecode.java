package org.lf.bazaar;

import com.google.gson.JsonElement;
import org.lf.api.reply.BazaarReply;
import org.lf.api.reply.ReplyType;

public class BazaarDecode {

    private JsonElement ReplyResult;
    private boolean hasProduct;
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

    }
    public ProductElement getProduct() {
        if(hasProduct) {
            return pe;
        }
        else {
            throw new IllegalStateException("No product get");
        }
    }
    public JsonElement getReplyResult() {
        return ReplyResult;
    }

}
