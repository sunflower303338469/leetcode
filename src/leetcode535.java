import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2020/11/23.
 */
public class leetcode535 {
    public class Codec {

        Map<String, String> codeMap = new HashMap<>();
        Integer count = 0;

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            String shortUrl = count.toString();
            codeMap.put(shortUrl, longUrl);
            count++;
            return shortUrl;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return codeMap.get(shortUrl);
        }
    }
}
