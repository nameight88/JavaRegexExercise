package fileparser.service;

import fileparser.contants.EncoderConstants;
import fileparser.model.InputStreamModel;
import fileparser.utilty.FileUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogFileParserService {
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern(EncoderConstants.DATE_FORMAT_PATTERN);

    private final List<InputStreamModel> inputStreams = new ArrayList<>();

    public void parseLogFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder section = new StringBuilder();
            String currentTimestamp = "";

            while ((line = reader.readLine()) != null) {
                if (isNewSection(line)) {
                    if (section.length() > 0) {
                        processSection(currentTimestamp, section.toString());
                    }
                    currentTimestamp = extractTimestamp(line);
                    section = new StringBuilder();
                }
                section.append(line).append("\n");
            }
            if (section.length() > 0) {
                processSection(currentTimestamp, section.toString());
            }
        }
    }

    private boolean isNewSection(String line) {
        return line.matches("\\[\\d{4}-\\d{2}-\\d{2}.*?\\].*");
    }

    private String extractTimestamp(String line) {
        Matcher matcher = Pattern.compile("\\[(.*?)\\]").matcher(line);
        return matcher.find() ? matcher.group(1) : "";
    }

    private void processSection(String timestamp, String content) {
        if (content.contains("INPUT_STREAM")) {
            parseInputStream(timestamp, content);
        }
    }

    private void parseInputStream(String timestamp, String content) {
        String file = FileUtils.extractValue(content, "file:\\s*(.*?)\\s*\\n");
        String width = FileUtils.extractValue(content, "width:\\s*(\\d+)");
        String height = FileUtils.extractValue(content, "height:\\s*(\\d+)");
        String format = FileUtils.extractValue(content, "format:\\s*(\\w+)");
        String fps = FileUtils.extractValue(content, "fps:\\s*(\\d+)");

        if (!width.isEmpty() && !height.isEmpty() && !format.isEmpty() && !fps.isEmpty()) {
            inputStreams.add(new InputStreamModel(
                    file,
                    Integer.parseInt(width),
                    Integer.parseInt(height),
                    format,
                    Integer.parseInt(fps),
                    LocalDate.parse(timestamp, formatter)
            ));
        }
    }

    public List<InputStreamModel> getInputStreams() {
        return inputStreams;
    }
}
