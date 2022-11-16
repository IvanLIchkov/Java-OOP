import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock{

    private Map<Integer, Transaction> transactionMap;

    public ChainblockImpl() {
        this.transactionMap = new LinkedHashMap<>();
    }

    public int getCount() {
        return transactionMap.size();
    }

    public void add(Transaction transaction) {
        transactionMap.putIfAbsent(transaction.getId(), transaction);
    }

    public boolean contains(Transaction transaction) {
        return (transactionMap.containsKey(transaction.getId()));
    }

    public boolean contains(int id) {
        return transactionMap.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        checkForTransaction(id);
        Transaction transaction = transactionMap.get(id);
        transaction.setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        checkForTransaction(id);
        transactionMap.remove(id);
    }

    public Transaction getById(int id) {
        checkForTransaction(id);
        return transactionMap.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> transactions = transactionMap.values().stream()
                .filter(t -> t.getStatus().equals(status))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (transactions.size()==0){
            throw new IllegalArgumentException();
        }
        return transactions;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<Transaction> transactionsByStatus = convertIterableToListOfTransactions(getByTransactionStatus(status));

        return transactionsByStatus.stream()
                .map(Transaction::getFrom)
                .collect(Collectors.toList());
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<Transaction> transactionsByStatus = convertIterableToListOfTransactions(getByTransactionStatus(status));

        return transactionsByStatus.stream()
                .map(Transaction::getTo)
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return transactionMap.values().stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        Iterable<Transaction> expectedTransactions = transactionMap.values().stream()
                .filter(t->t.getFrom().equals(sender))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (!expectedTransactions.iterator().hasNext()){
            throw new IllegalArgumentException();
        }

        return expectedTransactions;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        Iterable<Transaction> receiverTransactionsOrderedByAmountAndId = transactionMap.values().stream()
                .filter(t->t.getTo().equals(receiver))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        if (!receiverTransactionsOrderedByAmountAndId.iterator().hasNext()){
            throw new IllegalArgumentException();
        }
        return receiverTransactionsOrderedByAmountAndId;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return transactionMap.values().stream()
                .filter(t->t.getStatus().equals(status))
                .filter(t->t.getAmount()<=amount)
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        Iterable<Transaction> transactions = transactionMap.values().stream()
                .filter(t->t.getFrom().equals(sender))
                .filter(t->t.getAmount()>=amount)
                .collect(Collectors.toList());

        if (!transactions.iterator().hasNext()){
            throw new IllegalArgumentException();
        }
        return transactions;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> transactionsByRange = convertIterableToListOfTransactions(getAllInAmountRange(lo,hi));
        List<Transaction> transactiosByRangeAndReciever = transactionsByRange.stream()
                .filter(t -> t.getTo().equals(receiver))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (transactiosByRangeAndReciever.size()==0){
            throw new IllegalArgumentException();
        }
        return transactiosByRangeAndReciever;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return transactionMap.values().stream()
                .filter(t -> t.getAmount() < hi && t.getAmount() > lo)
                .collect(Collectors.toList());
    }

    public Iterator<Transaction> iterator() {
        return null;
    }

    private List<Transaction> convertIterableToListOfTransactions(Iterable<Transaction> iterable){
        List<Transaction> list = new ArrayList<>();

        for (Transaction transaction : iterable) {
            list.add(transaction);
        }

        return list;

    }

    private void checkForTransaction(int id) {
        if (!transactionMap.containsKey(id)){
            throw new IllegalArgumentException();
        }
    }
}
