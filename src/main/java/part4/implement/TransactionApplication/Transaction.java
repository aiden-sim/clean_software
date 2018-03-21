package part4.implement.TransactionApplication;

/**
 * 커맨드 패턴
 */
public interface Transaction {
    void execute() throws Exception;
}
