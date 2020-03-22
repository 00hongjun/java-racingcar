package racinggame.util;

import racinggame.exception.ImpossibaleConstructionException;

import java.util.Random;

/**
 * 1. 0~9 사이의 random 값을 구하는 기능
 * 1. 값이 정수 인지 체크
 * 1. String을 int로 변환, 반환, 검증
 * 1. 값이 1 이상인치 체크
 * 1. 값이 4 이상인치 체크
 */
final public class NumberUtil {

    private NumberUtil() {
        throw new ImpossibaleConstructionException("Util 객체 생성 금지");
    }

    /**
     * 0~9 사이의 random 값을 구하는 기능
     */
    public static int createRandomIntIn0to9() {
        return new Random().nextInt(10);
    }

    /**
     * 값이 4 이상인치 체크
     */
    public static boolean isGreaterThan4(int num) {
        if (num >= 4) {
            return true;
        }
        return false;
    }

    /**
     * 값이 1 이상인치 체크
     */
    public static boolean isGreaterThan1(int num) {
        if (num >= 1) {
            return true;
        }
        return false;
    }

    /**
     * 값이 정수 인지 체크
     * <p>
     * 이 메서드는 indent를 어떻게 1로 줄일수 있을까요?
     */
    public static boolean isIntPrimitive(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * String을 int로 변환, 반환, 검증
     */
    public static int validateIntegerAndReturn(String s) {
        if (!isIntPrimitive(s)) {
            throw new IllegalArgumentException("정수가 아닌 값이 입력 되었습니다.");
        }

        return Integer.parseInt(s);
    }
}
