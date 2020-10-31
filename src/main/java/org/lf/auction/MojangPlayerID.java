package org.lf.auction;

import com.google.gson.JsonObject;
import com.google.gson.JsonStreamParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This just a non-constructor class,
 * and only provide a static method that
 * you can get player uuid from player name.
 */
public class MojangPlayerID {

    private MojangPlayerID() {}

    /**
     * @param name - Player name in Mojang.
     * @return player uuid as {@link java.lang.String}
     * @throws IOException if get uuid error.
     */
    public static String getUUIDFromName(String name) throws IOException {
        HttpResponse hr = HttpClientBuilder.create().build().execute(new HttpGet("https://api.mojang.com/users/profiles/minecraft/" + name));
        JsonObject jo = new JsonStreamParser(new InputStreamReader(hr.getEntity().getContent())).next().getAsJsonObject();
        return jo.get("id").getAsString();
    }

}
