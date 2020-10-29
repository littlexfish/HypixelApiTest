package org.lf.api.reply;

import org.lf.bazaar.ItemID;

import java.io.IOException;
@SuppressWarnings("unused")
public class BazaarReply extends AbstractReply {

    private final boolean hasProduct;
    private String ProductID;

    /**
     * @deprecated
     * If you still use this constructor, you may deal with json from api by yourselves(yourself).
     * @param apiKey - Using /api in hypixel to use this class.
     * @throws IOException if error occured
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
