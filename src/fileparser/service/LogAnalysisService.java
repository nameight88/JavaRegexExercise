package fileparser.service;

import fileparser.model.InputStreamModel;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LogAnalysisService {
    public Map<String, Double> calculateStatistics(
          List<InputStreamModel> inputs) {

        Map<String, Double> stats = new HashMap<>();

        return stats;
    }




    public void exportToFile(String outputPath,
                             List<InputStreamModel> inputs,
                             Map<String, Double> statistics) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {
            writer.println("=== 인코딩 로그 분석 결과 ===");
            writer.println("\n1. 입력 스트림 정보:");
            inputs.forEach(writer::println);

            writer.println("\n2. 통계:");
            statistics.forEach((key, value) ->
                    writer.printf("%s: %.2f\n", key, value));

        }
    }
}
