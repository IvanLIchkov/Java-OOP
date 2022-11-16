public interface Transaction {
    public int getId();
     TransactionStatus getStatus();
     String getFrom();
     String getTo();
     double getAmount();
     void setStatus(TransactionStatus transactionStatus);
}
