package problem;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P_25206 implements Problem {

    /*
    문제
    인하대학교 컴퓨터공학과를 졸업하기 위해서는, 전공평점이 3.3 이상이거나 졸업고사를 통과해야 한다.
    그런데 아뿔싸, 치훈이는 깜빡하고 졸업고사를 응시하지 않았다는 사실을 깨달았다!

    치훈이의 전공평점을 계산해주는 프로그램을 작성해보자.

    전공평점은 전공과목별 (학점 × 과목평점)의 합을 학점의 총합으로 나눈 값이다.

    인하대학교 컴퓨터공학과의 등급에 따른 과목평점은 다음 표와 같다.

    A+	4.5
    A0	4.0
    B+	3.5
    B0	3.0
    C+	2.5
    C0	2.0
    D+	1.5
    D0	1.0
    F	0.0
    P/F 과목의 경우 등급이 P또는 F로 표시되는데, 등급이 P인 과목은 계산에서 제외해야 한다.

    과연 치훈이는 무사히 졸업할 수 있을까?

    입력
    20줄에 걸쳐 치훈이가 수강한 전공과목의 과목명, 학점, 등급이 공백으로 구분되어 주어진다.

    출력
    치훈이의 전공평점을 출력한다.

    정답과의 절대오차 또는 상대오차가
    \(10^{-4}\) 이하이면 정답으로 인정한다.

    제한
    1 ≤ 과목명의 길이 ≤ 50
    과목명은 알파벳 대소문자 또는 숫자로만 이루어져 있으며, 띄어쓰기 없이 주어진다.
    입력으로 주어지는 모든 과목명은 서로 다르다.
    학점은 1.0,2.0,3.0,4.0중 하나이다.
    등급은 A+,A0,B+,B0,C+,C0,D+,D0,F,P중 하나이다.
    적어도 한 과목은 등급이 P가 아님이 보장된다.
     */

    @Override
    public void exec() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        double sumGrade = 0.0;
        double sumSection = 0.0;

        HashMap<String, Double> gradeDic = computerengineering();


        String inputString = "";
        while((inputString = bufferedReader.readLine()) != null && !inputString.isEmpty()) {

            StringTokenizer gradeReportTokenizer = new StringTokenizer(inputString);
            String major = gradeReportTokenizer.nextToken();
            Double dGrade = Double.valueOf(gradeReportTokenizer.nextToken());
            String sGrade = gradeReportTokenizer.nextToken();

            double computeGrade = dGrade * gradeDic.get(sGrade);

            if (sGrade.equals("P")) {
                continue;
            }

            if (!sGrade.equals("P")) {
                sumGrade += computeGrade;
                sumSection += dGrade;
            }

        }


        double majorScore = sumGrade/sumSection;
        System.out.println(String.format("%.6f", majorScore));

    }

    public static HashMap<String, Double> computerengineering(){
        HashMap<String, Double> grade = new HashMap<String, Double>();

        grade.put("A+", 4.5);
        grade.put("A0", 4.0);
        grade.put("B+", 3.5);
        grade.put("B0", 3.0);
        grade.put("C+", 2.5);
        grade.put("C0", 2.0);
        grade.put("D+", 1.5);
        grade.put("D0", 1.0);
        grade.put("F", 0.0);
        grade.put("P", 0.0);

        return grade;
    }
}
