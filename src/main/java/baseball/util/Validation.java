package baseball.util;

import baseball.constant.NumberConstant;
import baseball.constant.ValidateException;

public class Validation {

    private static final String NUMBER_REGEX = "^[1-9]+$";
    private static final String RESTART_NUMBER_REGEX = "^[1-2]+$";


    public String validateNumber(String number) {
        checkRightNumber(number);
        return number;
    }


    public void validateRestart(String number) {
        checkRightRestartNumber(number);
        validateRestartNumberLength(number);
    }

    private static void checkRightRestartNumber(String number) {
        if (!number.matches(RESTART_NUMBER_REGEX)) {
            throw new IllegalArgumentException(ValidateException.RESTART_INPUT_NUMBER_EXCEPTION.getMsg());
        }
    }

    private static void validateRestartNumberLength(String number) {
        if (number.length() != NumberConstant.RESTART_INPUT_LENGTH.getNumber()) {
            throw new IllegalArgumentException(ValidateException.RESTART_INPUT_NUMBER_LENGTH_EXCEPTION.getMsg());
        }
    }

    private void checkRightNumber(String number) {
        validateIsNumber(number);
        validateIsRightLength(number);
        validateInSameNumber(number);
    }

    private void validateInSameNumber(String number) {
        for (int i = 0; i < NumberConstant.INPUT_LENGTH.getNumber(); i++) {
            for (int j = 0; j < NumberConstant.INPUT_LENGTH.getNumber(); j++) {
                findDuplicateNumber(number, i, j);
            }
        }
    }

    private static void findDuplicateNumber(String number, int i, int j) {
        if (i != j) {
            if (number.charAt(i) == number.charAt(j)) {
                throw new IllegalArgumentException(ValidateException.DUPLICATE_NUMBER_EXCEPTION.getMsg());
            }
        }
    }

    private void validateIsNumber(String number) {
        if (!number.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(ValidateException.INPUT_NUMBER_EXCEPTION.getMsg());
        }
    }

    private void validateIsRightLength(String number) {
        if (number.length() != NumberConstant.INPUT_LENGTH.getNumber()) {
            throw new IllegalArgumentException(ValidateException.INPUT_NUMBER_LENGTH_EXCEPTION.getMsg());
        }
    }


}
