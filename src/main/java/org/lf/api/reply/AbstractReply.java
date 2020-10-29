package org.lf.api.reply;

import com.google.gson.JsonElement;
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

public abstract class AbstractReply {

    private ReplyType rt;
    private JsonObject result;
    private URL APISite;
    private CloseableHttpClient web;
    private HttpResponse hr;
    private Object lock;

    public AbstractReply(String apiAddress, ReplyType rt) throws IOException {
        this.rt = rt;
        APISite = new URL(apiAddress);
        web = HttpClientBuilder.create().build();
        lock = new Object();

    }
    public AbstractReply execute() throws URISyntaxException, IOException {
        if(hr != null) {
            synchronized(lock) {
                hr = web.execute(new HttpGet((APISite.toURI())));
                result = new JsonStreamParser(new InputStreamReader(hr.getEntity().getContent())).next().getAsJsonObject();
            }
        }
        else {
            throw new IllegalStateException("Execute already. If need to re-execute, please use \"reExecute()\" method.");
        }
        return this;
    }
    public void reExecute() throws URISyntaxException, IOException {
        synchronized(lock) {
            hr = web.execute(new HttpGet((APISite.toURI())));
            result = new JsonStreamParser(new InputStreamReader(hr.getEntity().getContent())).next().getAsJsonObject();
        }
    }
    public JsonObject getResult() {
        synchronized(lock) {
            return result;
        }
    }
    public ReplyType getReplytype() {
        return rt;
    }
    //https://hypixel-skyblock.fandom.com/wiki/SkyBlock_API


}
