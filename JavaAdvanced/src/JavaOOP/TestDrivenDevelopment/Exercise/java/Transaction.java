package JavaOOP.TestDrivenDevelopment.Exercise.java;

public interface Transaction {
    int getId();
    TransactionStatus getTransactionStatus();
    void setStatus(TransactionStatus newStatus);
    double getAmount();
    String getFrom();
    String getTo();
}
