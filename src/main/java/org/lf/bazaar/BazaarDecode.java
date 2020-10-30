package org.lf.bazaar;

import com.google.gson.JsonObject;
import org.lf.api.reply.BazaarReply;
import org.lf.api.reply.ReplyType;
import org.lf.exception.GetFailureException;

/**
 * You can use this class to connect to Hypixel skyblock with api,
 * just use {@link #getProduct()} to get product what you want to get.
 */
public class BazaarDecode {

    private final JsonObject ReplyResult;
    private final boolean hasProduct;
    private final boolean success;
    private final String cause;
    private final ProductElement pe;

    /**
     * @param br - {@link org.lf.api.reply.BazaarReply}
     * @throws GetFailureException if success is false;
     */
    public BazaarDecode(BazaarReply br) throws GetFailureException {
        ReplyResult = br.getResult();
        if(ReplyResult == null) {
            throw new IllegalStateException("Not yet execute.");
        }
        else if(br.getReplytype() != ReplyType.BAZAAR) {
            throw new IllegalArgumentException("Not type of bazaar.");
        }
        hasProduct = br.hasProduct();
        success = ReplyResult.get("success").getAsBoolean();
        if(!success) {
            cause = ReplyResult.get("cause").getAsString();
            throw new GetFailureException("API get error. Cause: " + cause);
        }
        else {
            cause = null;
        }
        pe = new ProductElement(ReplyResult.get("product_info").getAsJsonObject());
    }

    /**
     * Get product element to get information of the product.
     * @return {@link org.lf.bazaar.ProductElement}
     */
    public ProductElement getProduct() {
        if(hasProduct) {
            return pe;
        }
        else {
            throw new IllegalStateException("No product get");
        }
    }

    /**
     * @return a boolean called success in json of result.
     */
    public boolean getSuccess() {
        return success;
    }

    /**
     * @return all result as {@link com.google.gson.JsonObject}
     */
    public JsonObject getReplyResult() {
        return ReplyResult;
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
