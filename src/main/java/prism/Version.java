package prism;

public class Version {
    public static final Version CURRENT = new Version();

    private final String name;
    private final int level;

    private Version() {
        this.name = "0.1.1";
        this.level = 1;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }
}
