package fileparser;

import fileparser.contants.EncoderConstants;
import fileparser.controller.LogController;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        LogController controller = new LogController();

        try {
            // 로그 파일 경로 확인
            File logFile = new File(EncoderConstants.LOG_FILE_PATH);
            String absolutePath = logFile.getAbsolutePath();

            System.out.println("로그 파일 분석을 시작합니다.");
            System.out.println("파일 경로: " + absolutePath);

            if (!logFile.exists()) {
                System.err.println("로그 파일을 찾을 수 없습니다: " + absolutePath);
                return;
            }

            // 로그 파일 처리
            controller.processLogFile(absolutePath);

        } catch (Exception e) {
            System.err.println("프로그램 실행 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
