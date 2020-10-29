package org.lf.bazaar;

public enum ItemID {

    SNOW("snow"),

    ;

    private String ID;

    ItemID(String id) {
        ID = id;
    }

    public String getID() {
        return ID;
    }

}
