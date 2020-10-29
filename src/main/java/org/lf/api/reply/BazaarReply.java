package org.lf.api.reply;

import java.io.IOException;

public class BazaarReply extends AbstractReply {

    private boolean hasProduct;
    private String ProductID;

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
