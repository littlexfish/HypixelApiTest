package org.lf.bazaar;

import org.lf.JSONType;
@SuppressWarnings("unused")
public class ResponceKey {

    public enum Responce {
        SUCCESS(JSONType.VALUE),
        PRODUCT_INFO(JSONType.ELEMENT),
        ;

        private final JSONType Type;
        Responce(JSONType type) {
            Type = type;
        }
        public JSONType getType() {
            return Type;
        }
    }

    public enum ProductInfo {
        PRODUCT_ID(JSONType.VALUE),
        BUY_SUMMARY(JSONType.LIST),
        SELL_SUMMARY(JSONType.LIST),
        QUICK_STATUS(JSONType.ELEMENT),
        WEEK_HISTORIC(JSONType.LIST),
        ;

        private final JSONType Type;
        ProductInfo(JSONType type) {
            Type = type;
        }
        public JSONType getType() {
            return Type;
        }

    }

    public enum Summary {
        AMOUNT(JSONType.VALUE),
        PRICE_PER_UNIT(JSONType.VALUE),
        ORDERS(JSONType.VALUE),
        ;

        private final JSONType Type;
        Summary(JSONType type) {
            Type = type;
        }
        public JSONType getType() {
            return Type;
        }
    }

    public enum QuickStatus {
        PRODUCT_ID(JSONType.VALUE),
        BUY_PRICE(JSONType.VALUE),
        BUY_VOLUME(JSONType.VALUE),
        BUY_MOVING_WEEK(JSONType.VALUE),
        BUY_ORDERS(JSONType.VALUE),
        SELL_PRICE(JSONType.VALUE),
        SELL_VOLUME(JSONType.VALUE),
        SELL_MOVING_WEEK(JSONType.VALUE),
        SELL_ORDERS(JSONType.VALUE),
        ;

        private final JSONType Type;
        QuickStatus(JSONType type) {
            Type = type;
        }
        public JSONType getType() {
            return Type;
        }
    }

    public enum WeekHistoric {
        PRODUCT_ID(JSONType.VALUE),
        TIMESTAMP(JSONType.VALUE),
        NOW_BUY_VOLUME(JSONType.VALUE),
        NOW_SELL_VOLUME(JSONType.VALUE),
        BUY_COINS(JSONType.VALUE),
        BUY_VOLUME(JSONType.VALUE),
        BUYS(JSONType.VALUE),
        SELL_COINS(JSONType.VALUE),
        SELL_VOLUME(JSONType.VALUE),
        SELLS(JSONType.VALUE),
        ;

        private final JSONType Type;
        WeekHistoric(JSONType type) {
            Type = type;
        }
        public JSONType getType() {
            return Type;
        }
    }
}
