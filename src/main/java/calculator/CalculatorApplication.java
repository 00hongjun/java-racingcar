package calculator;

import java.util.Scanner;

/**
 * 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
 * <p>
 * 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다.
 * 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
 * <p>
 * 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
 */
public class CalculatorApplication {
    public static void main(String[] args) {
        System.out.println("사칙연산 계산기 : 입력값을 공백으로 구분해주세요");

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        InputVo inputVo = new InputVo(input);
        Calculator calculator = new Calculator(inputVo.getInputSplit());

        System.out.println("결과 : " + calculator.calculateUserInput());
    }
}
