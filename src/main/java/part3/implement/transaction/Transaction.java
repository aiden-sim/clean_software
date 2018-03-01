package part3.implement.transaction;

/**
 * 커맨드 패턴
 */
public interface Transaction {
    void execute() throws Exception;
}
