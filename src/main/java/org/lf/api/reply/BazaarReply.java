package org.lf.api.reply;

import org.lf.bazaar.ItemID;

import java.io.IOException;

/**
 * A class link to Hypixel skyblock Bazaar api.
 */
@SuppressWarnings("unused")
public class BazaarReply extends AbstractReply {

    private final boolean hasProduct;
    private ItemID ProductID;

    /**
     * @deprecated
     * If you still use this constructor, you may deal with json from api by yourselves(yourself).
     * @param apiKey - Using /api in hypixel to use this class.
     * @throws IOException if error occured.
     */
    @Deprecated
    public BazaarReply(String apiKey) throws IOException {
        super(" https://api.hypixel.net/skyblock/bazaar/product?key=" + apiKey, ReplyType.BAZAAR);
        hasProduct = false;
    }

    /**
     * Use {@link sun.net.www.http.HttpClient} to link to hypixel api.
     * @param apiKey - Using /api in hypixel to use this class.
     * @param productID - The product id in skyblock Bazaar.
     * @throws IOException if error occured.
     * @see {@link org.lf.bazaar.ItemID}
     */
    public BazaarReply(String apiKey, ItemID productID) throws IOException {
        super(" https://api.hypixel.net/skyblock/bazaar/product?key=" + apiKey + "&productId=" + productID.getID(), ReplyType.BAZAAR);
        hasProduct = true;
        ProductID = productID;
    }

    /**
     * If use {@link #BazaarReply(String)} it will be false, or will be true.
     * @return false when use {@link #BazaarReply(String)} link to hypixel api.
     */
    public boolean hasProduct() {
        return hasProduct;
    }

    /**
     * Get {@link org.lf.bazaar.ItemID} what you put when you initiallize the instance.
     * @return {@link org.lf.bazaar.ItemID}
     */
    public ItemID getProductID() {
        if(hasProduct) {
            return ProductID;
        }
        else {
            throw new IllegalStateException("No product.");
        }
    }
}
