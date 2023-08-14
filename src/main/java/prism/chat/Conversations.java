package prism.chat;

import com.google.gson.Gson;
import prism.util.structs.Account;
import prism.util.structs.Action;
import prism.util.structs.Conversation;
import prism.util.structs.Request;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static prism.util.Instructions.*;

public class Conversations {
    public static int register(Conversation c, String url) throws IOException, InterruptedException {
        var gson = new Gson();
        var client = HttpClient.newHttpClient();
        var d = new Request();
        d.status = NULL;
        var ac = new Action();
        ac.instruction = CREATE_CONVERSATION;
        ac.params.data = c;
        d.actions.set(0, ac);
        var req = HttpRequest.newBuilder(URI.create(url)).POST(HttpRequest.BodyPublishers.ofString(gson.toJson(d))).build();

        HttpResponse<String> res = client.send(req,
                HttpResponse.BodyHandlers.ofString());

        var data = gson.fromJson(res.body(), Request.class);
        var id = -1;
        if (data.status == SUCCESS) id = (int) data.response.get(0);

        return id;
    }

    public static void addParticipant(Account user, String url) throws IOException, InterruptedException {
        var gson = new Gson();
        var client = HttpClient.newHttpClient();
        var d = new Request();
        d.status = NULL;
        var ac = new Action();
        ac.instruction = ADD_PARTICIPANT;
        ac.params.data = user;
        d.actions.set(0, ac);
        var req = HttpRequest.newBuilder(URI.create(url)).POST(HttpRequest.BodyPublishers.ofString(gson.toJson(d))).build();

        client.send(req, HttpResponse.BodyHandlers.ofString());
    }

    public static void removeParticipant(Account user, String url) throws IOException, InterruptedException {
        var gson = new Gson();
        var client = HttpClient.newHttpClient();
        var d = new Request();
        d.status = NULL;
        var ac = new Action();
        ac.instruction = REMOVE_PARTICIPANT;
        ac.params.data = user;
        d.actions.set(0, ac);
        var req = HttpRequest.newBuilder(URI.create(url)).POST(HttpRequest.BodyPublishers.ofString(gson.toJson(d))).build();

        client.send(req, HttpResponse.BodyHandlers.ofString());
    }
}
