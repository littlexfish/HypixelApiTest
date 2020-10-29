package org.lf;

import org.lf.api.reply.BazaarReply;
import org.lf.bazaar.BazaarDecode;
import org.lf.bazaar.ItemID;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BazaarDecode bd = new BazaarDecode(new BazaarReply("", ItemID.BLAZE_ROD));

    }

}
