package org.lf;

import org.lf.api.reply.BazaarReply;
import org.lf.bazaar.BazaarDecode;
import org.lf.bazaar.ItemID;
import org.lf.exception.GetFailureException;

import java.io.IOException;

public class Main {

    public static final String api = "7e5e0042-f61b-42bc-a680-b14c98e20397";

    public static void main(String[] args) throws IOException, GetFailureException {
        BazaarDecode bd = new BazaarDecode(new BazaarReply(api, ItemID.BLAZE_ROD));


    }

}
