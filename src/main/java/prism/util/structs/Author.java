package prism.util.structs;

public class Author {
    public String username;
    public String displayName;
    public byte[] pfp;
    public int userID;

    public Author setUsername(String username) {
        this.username = username;
        return this;
    }

    public Author setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public Author setPfp(byte[] pfp) {
        this.pfp = pfp;
        return this;
    }

    public Author setUserID(int userID) {
        this.userID = userID;
        return this;
    }
}
