package prism.util.structs;

import java.util.List;

public class Request {
    public int status;
    public List<Action> actions;
    public List<?> response;
    public List<Message> messages;

    public Request setStatus(int status) {
        this.status = status;
        return this;
    }

    public Request setActions(List<Action> actions) {
        this.actions = actions;
        return this;
    }

    public Request setResponse(List<?> response) {
        this.response = response;
        return this;
    }

    public Request setMessages(List<Message> messages) {
        this.messages = messages;
        return this;
    }
}
