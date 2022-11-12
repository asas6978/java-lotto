package lotto;

import java.util.List;

public class Validation {
    private static final int NUMBER_OF_WINNING_NUMBERS = 6;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;

    public static void isValidUnit(int amount) throws IllegalArgumentException {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.INVALID_AMOUNT_UNIT);
        }
    }

    public static void isValidInputRange(int winningNumber) throws IllegalArgumentException {
        if (winningNumber < LOTTO_START_NUMBER || winningNumber > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.LOTTO_OUT_OF_RANGE);
        }
    }

    public static void existOnlyNumber(String amount) throws IllegalArgumentException {
        try {
            Integer.parseInt(amount);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.CANNOT_CONVERT_NUMBER);
        }
    }

    public static void checkWinningNumbersDuplication(List<String> numbers) throws IllegalArgumentException {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.DUPLICATE_NUMBER);
        }
    }

    public static void checkBonusNumberDuplication(List<Integer> winningNumbers, String bonusNumberInput) throws IllegalArgumentException {
        if (winningNumbers.contains(Integer.parseInt(bonusNumberInput))) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.DUPLICATE_NUMBER);
        }
    }

    public static void checkNumberOfWinningNumber(List<String> numbers) {
        if (numbers.size() != NUMBER_OF_WINNING_NUMBERS) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.INVALID_WINNING_NUMBERS);
        }
    }
}
