package prism.accounts;

import com.google.gson.Gson;
import prism.util.haxe.Bytes;
import prism.util.structs.Action;
import prism.util.structs.Request;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static prism.util.Instructions.*;
import static prism.util.Instructions.USERS;

public class Authenticator {
    public static int login(String username, Bytes password, String url) throws IOException, InterruptedException {
        var code = FAILURE;

        var gson = new Gson();
        var client = HttpClient.newHttpClient();
        Request d = new Request();
        d.status = NULL;
        var ac = new Action();
        ac.instruction = LOGIN;
        ac.params.username = username;
        ac.params.password = password.toHex();
        d.actions.set(0, ac);
        var req = HttpRequest.newBuilder(URI.create(url)).POST(HttpRequest.BodyPublishers.ofString(gson.toJson(d))).build();

        HttpResponse<String> res = client.send(req,
                HttpResponse.BodyHandlers.ofString());

        var data = gson.fromJson(res.body(), Request.class);

        code = data.status;

        return code;
    }
}
