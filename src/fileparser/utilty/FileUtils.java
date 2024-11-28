package fileparser.utilty;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUtils {
    public static boolean validatePath(String path) {
        File file = new File(path);
        return file.exists() && file.canRead();
    }

    public static void ensureDirectoryExists(String path) {
        File directory = new File(path);
        if (!directory.exists()) {
            boolean created = directory.mkdirs();
            if (!created) {
                throw new RuntimeException("디렉토리 생성 실패: " + path);
            }
        }
    }

    public static String extractValue(String content, String patternStr) {
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(content);
        return matcher.find() ? matcher.group(1) : "";
    }

    public static Long parseHexAddress(String hexStr) {
        try {
            return hexStr.startsWith("0x") ?
                    Long.parseLong(hexStr.substring(2), 16) :
                    Long.parseLong(hexStr, 16);
        } catch (NumberFormatException e) {
            return 0L;
        }
    }
}
