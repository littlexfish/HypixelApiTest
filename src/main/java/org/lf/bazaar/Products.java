package org.lf.bazaar;

import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

/**
 * A class includes all Bazaar data.
 */
public class Products {

    private Map<ItemID, ProductElement> products;

    /**
     *
     * @param product - {@link com.google.gson.JsonObject}
     */
    public Products(JsonObject product) {
        products = new HashMap<>(ItemID.values().length);
        for(int i = 0;i < ItemID.values().length;i++) {
            ItemID id = ItemID.values()[i];
            products.put(id, new ProductElement(product.get(id.getID()).getAsJsonObject()));
        }
    }

    /**
     * Get {@link org.lf.bazaar.ProductElement} using {@link org.lf.bazaar.ItemID}
     * @param id - {@link org.lf.bazaar.ItemID}
     * @return {@link org.lf.bazaar.ProductElement}
     */
    public ProductElement getProduct(ItemID id) {
        return products.get(id);
    }

    /**
     * Get all ProductElements as Map, using {@link org.lf.bazaar.ItemID} as key to get ProductElement by yourselves(yourself).
     * @return {@link java.util.Map<org.lf.bazaar.ItemID, org.lf.bazaar.ProductElement>}
     */
    public Map getAllProducts() {
        return products;
    }

}
