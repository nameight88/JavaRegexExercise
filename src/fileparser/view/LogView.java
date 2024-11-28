package fileparser.view;

import fileparser.contants.EncoderConstants;
import fileparser.model.InputStreamModel;

import java.time.format.DateTimeFormatter;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LogView {
    private static final DateTimeFormatter dateFormatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    public void displayResults(List<InputStreamModel> inputs,
                               Map<String, Double> statistics) {
        displayHeader("인코딩 로그 분석 결과");

        // 입력 스트림 정보 표시
        displayInputStreams(inputs);

        // 통계 정보 표시
        displayStatistics(statistics);
    }

    private void displayHeader(String header) {
        System.out.println("\n=== " + header + " ===");
    }

    private void displayInputStreams(List<InputStreamModel> inputs) {
        System.out.println("\n입력 스트림 정보:");
        inputs.forEach(input -> {
            System.out.printf("파일: %s\n", input.getFile());
            System.out.printf("해상도: %dx%d\n", input.getWidth(), input.getHeight());
            System.out.printf("포맷: %s, FPS: %d\n",
                    input.getFormat(), input.getFps());
            System.out.println();
        });
    }

    private void displayStatistics(Map<String, Double> statistics) {
        System.out.println("\n인코딩 통계:");
        statistics.forEach((key, value) -> {
            String formattedKey = formatStatisticKey(key);
            System.out.printf("%s: %.2f\n", formattedKey, value);
        });
    }

    private String formatStatisticKey(String key) {
        return key.replace("_", " ")
                .replace("average", "평균")
                .replace("total", "총")
                .replace("frameType", "프레임 타입");
    }

    public void displayError(String message) {
        System.err.println("오류: " + message);
    }

    public void displayWarning(String message) {
        System.out.println("경고: " + message);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
