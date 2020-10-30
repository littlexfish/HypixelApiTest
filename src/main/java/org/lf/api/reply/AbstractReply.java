package org.lf.api.reply;

import com.google.gson.JsonObject;
import com.google.gson.JsonStreamParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * A abstract class that extents by other reply class,
 * and get json from Hypixel api.
 */
public abstract class AbstractReply {

    private final ReplyType rt;
    private JsonObject result;
    private final URL APISite;
    private final CloseableHttpClient web;
    private HttpResponse hr;
    private final Object lock;

    public AbstractReply(String apiAddress, ReplyType rt) throws IOException {
        this.rt = rt;
        APISite = new URL(apiAddress);
        web = HttpClientBuilder.create().build();
        lock = new Object();

    }

    /**
     * Get json from Hypixel api.
     * @return {@link org.lf.api.reply.AbstractReply} that can put into decode class directly.
     * @throws URISyntaxException if uri syntax error, but usually won't occurred.
     * @throws IOException if get json error.
     */
    public AbstractReply execute() throws URISyntaxException, IOException {
        synchronized(lock) {
            hr = web.execute(new HttpGet((APISite.toURI())));
            result = new JsonStreamParser(new InputStreamReader(hr.getEntity().getContent())).next().getAsJsonObject();
            return this;
        }
    }

    /**
     * Get json object that get from Hypixel api.
     * @return {@link com.google.gson.JsonObject}
     */
    public JsonObject getResult() {
        synchronized(lock) {
            return result;
        }
    }

    /**
     * @return {@link org.lf.api.reply.ReplyType}
     */
    public ReplyType getReplytype() {
        return rt;
    }
}
