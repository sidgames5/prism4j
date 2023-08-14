package prism.util.structs;

public class Message {
    public String content;
    public Author author;
    public int timestamp;
    public int id;
    public int crc32;

    public Message setContent(String content) {
        this.content = content;
        return this;
    }

    public Message setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public Message setTimestamp(int timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public Message setId(int id) {
        this.id = id;
        return this;
    }

    public Message setCrc32(int crc32) {
        this.crc32 = crc32;
        return this;
    }
}
