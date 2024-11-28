package fileparser.controller;

import fileparser.model.InputStreamModel;
import fileparser.service.LogFileParserService;
import fileparser.utilty.FileUtils;
import fileparser.view.LogView;

import java.util.List;

public class LogController {
    private final LogFileParserService parserService;
    private final LogView view;

    public LogController() {
        this.parserService = new LogFileParserService();
        this.view = new LogView();
    }

    public void processLogFile(String filePath) {
        try {
            view.displayMessage("로그 파일 분석 시작: " + filePath);

            // 파일 유효성 검사
            if (!FileUtils.validatePath(filePath)) {
                view.displayError("파일을 찾을 수 없습니다: " + filePath);
                return;
            }

            // 로그 파일 파싱
            parserService.parseLogFile(filePath);

            // 데이터 수집
            List<InputStreamModel> inputStreams = parserService.getInputStreams();

        } catch (Exception e) {
            view.displayError("파일 처리 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

