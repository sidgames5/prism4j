package prism.chat;

import com.google.gson.Gson;
import prism.util.structs.Action;
import prism.util.structs.Message;
import prism.util.structs.Request;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import static prism.util.Instructions.*;

public class Receiver {
    public static List<Message> getAll(String url) throws IOException, InterruptedException {
        var gson = new Gson();
        var client = HttpClient.newHttpClient();
        var d = new Request();
        d.status = NULL;
        var ac = new Action();
        ac.instruction = READ;
        d.actions.set(0, ac);
        var req = HttpRequest.newBuilder(URI.create(url)).POST(HttpRequest.BodyPublishers.ofString(gson.toJson(d))).build();

        HttpResponse<String> res = client.send(req,
                HttpResponse.BodyHandlers.ofString());

        var data = gson.fromJson(res.body(), Request.class);
        List<Message> re = new ArrayList<>();
        if (data.status == SUCCESS) re = data.actions.get(0).messages;

        return re;
    }

    public static Message getLatest(String url) throws IOException, InterruptedException {
        var g = getAll(url);
        return g.get(g.size() - 1);
    }

    public static List<Message> getMultiple(String url, int count) throws IOException, InterruptedException {
        List<Message> x = new ArrayList<>();
        var g = getAll(url);
        var start = g.size() - count;
        for (int m = 0; m < g.size(); m++) if (m > start) x.add(g.get(m));
        return x;
    }
}
