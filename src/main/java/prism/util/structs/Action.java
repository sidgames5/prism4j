package prism.util.structs;

import java.util.List;

public class Action {
    public int instruction;
    public int status;
    public Params params;
    public static class Params {
        public String username;
        public String password;
        public Object data;
        public Message message;
        public int index;
        public int startIndex;
        public int endIndex;
        public int type;
        public byte[] token;
        public String details;

        public Params setUsername(String username) {
            this.username = username;
            return this;
        }

        public Params setPassword(String password) {
            this.password = password;
            return this;
        }

        public Params setData(Object data) {
            this.data = data;
            return this;
        }

        public Params setMessage(Message message) {
            this.message = message;
            return this;
        }

        public Params setIndex(int index) {
            this.index = index;
            return this;
        }

        public Params setStartIndex(int startIndex) {
            this.startIndex = startIndex;
            return this;
        }

        public Params setEndIndex(int endIndex) {
            this.endIndex = endIndex;
            return this;
        }

        public Params setType(int type) {
            this.type = type;
            return this;
        }

        public Params setToken(byte[] token) {
            this.token = token;
            return this;
        }

        public Params setDetails(String details) {
            this.details = details;
            return this;
        }
    }
    public List<Message> messages;

    public Action setInstruction(int instruction) {
        this.instruction = instruction;
        return this;
    }

    public Action setStatus(int status) {
        this.status = status;
        return this;
    }

    public Action setParams(Params params) {
        this.params = params;
        return this;
    }

    public Action setMessages(List<Message> messages) {
        this.messages = messages;
        return this;
    }
}
