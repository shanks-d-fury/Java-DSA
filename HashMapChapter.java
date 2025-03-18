import java.util.HashMap;

public class HashMapChapter {
    public static String findStart(HashMap<String, String> hm) {
        HashMap<String, String> rhm = new HashMap<>();
        for (String key : hm.keySet()) {
            rhm.put(hm.get(key), key);
        }
        for (String key : hm.keySet()) {
            if (!rhm.containsKey(key)) {
                return key;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // question statement is that find the ticket itenary which is the path from
        // start to end
        HashMap<String, String> hm = new HashMap<>();
        hm.put("blg", "bwt");
        hm.put("bwt", "klr");
        hm.put("klr", "hkt");
        hm.put("hkt", "wft");
        hm.put("wft", "cmrit");

        String Start = findStart(hm);
        System.out.print(Start);
        while (hm.containsKey(Start)) {
            System.out.print("->" + hm.get(Start));
            Start = hm.get(Start);
        }
    }
}