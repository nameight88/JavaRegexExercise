package RegexBasic;

public class Basic {
    // 기본 문자 클래스
    private static final String [] PATTERN = {
        "\\d", // 숫자 [0-9]
        "\\w", // 단어 문자[a-zA-z0-9_]
        "\\s", // 공백 문자
        ".", // 모든 문자
        "^", // 문자열 시작
        "$", // 문자열 끝
    };
    // 수량자
    private static final String [] QUANTIFIERS = {
        "*", // 0회 이상
        "+", // 1회 이상
        "?", // 0회 또는 1회
        "{n}", // 정확히 n회
        "{n,m}", // n회 이상 m회 이하
        "{n,}" //n회 이상
    };
    public static void main(String[] args) {
        String testText = "123456";
        boolean testResult =testText.matches("[0-9]+");
        /*
       matches class -> 일치하는지 확인을 하고
       일치 할 경우 true 값으로 반환을 한다.
         */
//        System.out.println(testResult);

        String testText2 = "power987";
        String testResult2 = testText2.replaceAll("^[a-zA-Z0-9]","0");
        System.out.println(testResult2);
    }
}
