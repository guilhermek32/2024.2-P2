package A2025_03_09_Atividade4;

public class WithdrawLimitExceededException extends RuntimeException {
    public WithdrawLimitExceededException(String message) {
        super(message);
    }
}