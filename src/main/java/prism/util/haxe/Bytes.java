package prism.util.haxe;

public class Bytes {
    private byte[] bytes;

    private Bytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String toString() {
        var sb = new StringBuilder();
        for (byte b : bytes) sb.append(b);
        return sb.toString();
    }

    public String toHex() {
        var sb = new StringBuilder();
        for (byte b : bytes)
        {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString();
    }

    public static Bytes ofString(String s) {
        return new Bytes(s.getBytes());
    }

    public static Bytes ofHex(String s) {
        byte[] ans = new byte[s.length() / 2];

        for (int i = 0; i < ans.length; i++) {
            int index = i * 2;

            // Using parseInt() method of Integer class
            int val = Integer.parseInt(s.substring(index, index + 2), 16);
            ans[i] = (byte)val;
        }

        return new Bytes(ans);
    }

    public static Bytes ofByteArray(byte[] b) {
        return new Bytes(b);
    }
}
