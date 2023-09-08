public class Main5 {

    private static double correctCount = 0;

    private static final String[][] TESTCASES = new String[][] {
            {"123", "123", "246"},
            {"1000", "1", "2"},
            {"456", "789", "1461"},
            {"5", "5", "1"},
            {"11112", "54321", "65433"},
            {"3829", "1300", "4139"}
    };

    public static void main(String[] args) {
        for (int i = 0; i < TESTCASES.length; i++)
            System.out.println("Testcase " + i + " = " + test(TESTCASES[i][0], TESTCASES[i][1], TESTCASES[i][2]));

        System.out.println("정답률 = " + (int) (correctCount / TESTCASES.length * 100) + "%");
    }

    private static boolean test(String input, String input2, String answer) {
        int first = Integer.parseInt(input);
        int second = Integer.parseInt(input2);

        boolean res = String.valueOf(solution(first, second)).equals(answer);
        if (res)
            correctCount++;
        return res;
    }

    private static int solution(int first, int second) {
        int result = 0;
        int reversedFirst = 0;
        int reversedSecond = 0;
        int reversedResult = 0;

        // 자리수 맞추기
        while (String.valueOf(first).length() != String.valueOf(second).length()) {
            if (String.valueOf(first).length() > String.valueOf(second).length()){
                second = second * 10;
            } else {
                first *= 10;
            }
        }

        // 자리수끼리 덧셈
        while (first > 0 && second > 0){
            reversedFirst = first % 10;
            reversedSecond = second % 10;
            reversedResult = reversedResult * 10 + reversedFirst + reversedSecond;
            first /= 10;
            second /= 10;
        }
        
        // 결과값 뒤집기
        while (reversedResult > 0) {
            result = result * 10 + reversedResult % 10;
            reversedResult /= 10;
        }
        
        // while (second > 0) {
        //     reversedSecond += second % 10;
        //     second /= 10;
        // }

        // result = first + second;


        return result;
    }
    
    
    // solution
    /* String[] rot1 = Integer.toString(first).split("");
    String[] rot2 = Integer.toString(second).split("");
    
    String one = "";
    String two = "";
    
    for (int i=0; i< Integer.toString(first).length(); i++){
        one = rot1[i] + one;
    }
    
    for (int i=0; i<rot2.length; i++) {
        two = rot2[i] + two;
    }
    
    int result = Integer.parseInt(one) + Integer.parseInt(two);
    String[] results = Integer.toString(result).split("");
    String solution = "";
    
    for (int i=0; i<results.length; i++) {
        solution = results[i] + solution;
    }
    return Integer.parseInt(solution); */
}