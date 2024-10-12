package lotto.exception;

public enum ErrorMessage {

    ERROR_SIGNATURE("[ERROR] "),
    AMOUNT_POSITIVE("구입금액은 1000원부터 가능합니다."),
    AMOUNT_NUMBERIC("구입금액은 숫자로 입력해야합니다."),
    AMOUNT_INVALID_UNIT("구입금액은 1000원 단위여야 합니다."),
    WINNING_NUMBERS_AS_INTEGERS_SEPARATE("당첨번호는 쉼표로 구분된 정수들로 입력해야 합니다."),
    WINNING_NUMBERS_OUT_OF_SIZE("당첨번호는 6자리여야 합니다"),
    WINNING_NUMBERS_OUT_OF_RANGE("당첨번호의 범위는 1부터 45까지의 숫자 입니다."),
    WINNING_NUMBERS_DUPLICATE("당첨번호는 중복되어서는 안됩니다."),
    BONUS_NUMBER_AS_INTEGER("보너스 번호는 정수로 입력해야 합니다."),
    BONUS_NUMBER_OUT_OF_RANGE("보너스 번호의 범위는 1부터 45까지 입니다."),
    BONUS_NUMBER_DUPLICATE_WINNING_NUMBER("보너스 번호는 당첨번호와 중복되어서는 안됩니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return ERROR_SIGNATURE.message + this.message;
    }
}
