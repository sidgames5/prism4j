package prism.util.structs;

import prism.util.haxe.Bytes;

public class Account {
    public String username;
    public int userID;
    public Bytes password;
    public Profile profile;
    public static class Profile {
        public String displayName;
        public Bytes pfp;
        public String bio;

        public Profile setDisplayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public Profile setPfp(Bytes pfp) {
            this.pfp = pfp;
            return this;
        }

        public Profile setBio(String bio) {
            this.bio = bio;
            return this;
        }
    }

    public Account setUsername(String username) {
        this.username = username;
        return this;
    }

    public Account setUserID(int userID) {
        this.userID = userID;
        return this;
    }

    public Account setPassword(Bytes password) {
        this.password = password;
        return this;
    }

    public Account setProfile(Profile profile) {
        this.profile = profile;
        return this;
    }
}
