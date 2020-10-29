package org.lf.api.reply;

import org.lf.bazaar.ItemID;

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

    public BazaarReply(String apiKey, ItemID productID) throws IOException {
        super(" https://api.hypixel.net/skyblock/bazaar/product?key=" + apiKey + "&productId=" + productID.getID(), ReplyType.BAZAAR);
        hasProduct = true;
        ProductID = productID.getID();
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
