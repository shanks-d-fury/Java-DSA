
public class LeetCodeTestBench {

    public static String findLargestString(String[] s) {
        String largestString = "";
        for (String sx : s) {
            largestString = largestString.compareToIgnoreCase(sx) >= 0 ? largestString : sx;
        }
        return largestString;
    }

    public static void main(String[] args) {
        String[] s = {"zebra",
            "zinc",
            "zone",
            "zero",
            "zombie",
            "zipper",
            "zephyr",
            "zigzag",
            "zucchini",
            "zeppelin",
            "zenith",
            "zest",
            "zodiac",
            "zombie",
            "zoology",
            "zoom",
            "zesty",
            "zen",
            "zookeeper",
            "ziggurat"};
        System.out.println(findLargestString(s));
    }
}
