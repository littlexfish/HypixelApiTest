package org.lf.api.reply;

import java.io.IOException;
import java.lang.annotation.Documented;

public class BazaarReply extends AbstractReply {

    private boolean hasProduct;
    private String ProductID;

    /**
     * @deprecated
     * If you still use this constructor, you may deal with json from api by yourselves(yourself).
     * @param apiKey
     * @throws IOException
     */
    @Deprecated
    public BazaarReply(String apiKey) throws IOException {
        super(" https://api.hypixel.net/skyblock/bazaar/product?key=" + apiKey, ReplyType.BAZAAR);
        hasProduct = false;
    }

    public BazaarReply(String apiKey, String productID) throws IOException {
        super(" https://api.hypixel.net/skyblock/bazaar/product?key=" + apiKey + "&productId=" + productID, ReplyType.BAZAAR);
        hasProduct = true;
        ProductID = productID;
    }

    public boolean hasProduct() {
        return hasProduct;
    }

    public String getProductID() {
        if(hasProduct) {
            return ProductID;
        }
        else {
            throw new IllegalStateException("No product.");
        }
    }
}
