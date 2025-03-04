package a2025_02_26_Atividade4;

public class WithdrawLimitExceededException extends RuntimeException {
    public WithdrawLimitExceededException(String message) {
        super(message);
    }
}