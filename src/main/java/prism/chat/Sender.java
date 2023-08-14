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

public class Sender {
    public static void send(Message message, String url) throws IOException, InterruptedException {
        var gson = new Gson();
        var client = HttpClient.newHttpClient();
        var d = new Request();
        d.status = NULL;
        var ac = new Action();
        ac.instruction = MESSAGE;
        ac.params.message = message;
        d.actions.set(0, ac);
        var req = HttpRequest.newBuilder(URI.create(url)).POST(HttpRequest.BodyPublishers.ofString(gson.toJson(d))).build();

        client.send(req, HttpResponse.BodyHandlers.ofString());
    }
}
