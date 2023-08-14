package prism.util.structs;

import java.util.List;

public class Conversation {
    public String name;
    public List<Account> participants;
    public List<Message> messages;
    public int id;

    public Conversation setName(String name) {
        this.name = name;
        return this;
    }

    public Conversation setParticipants(List<Account> participants) {
        this.participants = participants;
        return this;
    }

    public Conversation setMessages(List<Message> messages) {
        this.messages = messages;
        return this;
    }

    public Conversation setId(int id) {
        this.id = id;
        return this;
    }
}
