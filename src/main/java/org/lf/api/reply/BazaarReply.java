package org.lf.api.reply;

import org.lf.bazaar.ItemID;

import java.io.IOException;

/**
 * A class link to Hypixel skyblock Bazaar api.
 */
public class BazaarReply extends AbstractReply {

    private final boolean hasProduct;
    private ItemID ProductID;

    /**
     * Hypixel recommended use this way to get data.<br>
     * Use {@link sun.net.www.http.HttpClient} to link to hypixel api.
     * @param apiKey - Using /api in Hypixel to use this class.
     * @throws IOException if get json error.
     */
    public BazaarReply(String apiKey) throws IOException {
        super(" https://api.hypixel.net/skyblock/bazaar?key=" + apiKey, ReplyType.BAZAAR);
        hasProduct = false;
    }

    /**
     * @deprecated This way to get data will soon be remove by Hypixel.
     * @param apiKey - Using /api in Hypixel to use this class.
     * @param productID - The product id in skyblock Bazaar.
     * @throws IOException if get json error.
     * @see {@link org.lf.bazaar.ItemID}
     */
    @Deprecated
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
