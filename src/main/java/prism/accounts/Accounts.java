package prism.accounts;

import com.google.gson.Gson;
import prism.util.structs.Account;
import prism.util.structs.Action;
import prism.util.structs.Request;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static prism.util.Instructions.*;

public class Accounts {
    public static Account getFromID(int id, String url) throws IOException, InterruptedException {
        Account a = null;
        var gson = new Gson();
        var client = HttpClient.newHttpClient();
        Request d = new Request();
        d.status = NULL;
        var ac = new Action();
        ac.instruction = GET;
        ac.params.type = USERS;
        d.actions.set(0, ac);
        var req = HttpRequest.newBuilder(URI.create(url)).POST(HttpRequest.BodyPublishers.ofString(gson.toJson(d))).build();

        HttpResponse<String> res = client.send(req,
                HttpResponse.BodyHandlers.ofString());

        var data = gson.fromJson(res.body(), Request.class);
        if (data.status == SUCCESS) a = (Account) data.response.get(0);

        return a;
    }
}
