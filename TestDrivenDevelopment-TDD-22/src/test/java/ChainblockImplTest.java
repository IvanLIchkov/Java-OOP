import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ChainblockImplTest {

    private Chainblock chainblock;
    private List<Transaction> transactions;

    @Before
    public void startUp() {
        this.chainblock = new ChainblockImpl();
        this.transactions = new ArrayList<>();
        this.prepareTransactions();
    }

    private void fillChainBlockWithTransactions() {
        transactions.forEach(t -> chainblock.add(t));
    }

    private void prepareTransactions() {
        Transaction transaction = new TransactionImpl(0, TransactionStatus.SUCCESSFUL, "Pesho", "Sasho", 10.20);
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Pesho", "Toshko", 10);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.UNAUTHORIZED, "Sasho", "Pesho", 11.0);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.FAILED, "Toshko", "Sasho", 12.20);
        Transaction transaction4 = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "Sasho", "Pesho", 10.50);
        Transaction transaction5 = new TransactionImpl(5, TransactionStatus.SUCCESSFUL, "Pesho", "Sasho", 14.00);
        Transaction transaction6 = new TransactionImpl(6, TransactionStatus.SUCCESSFUL, "Tosho", "Sasho", 9.00);

        transactions.add(transaction);
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction4);
    }

    @Test
    public void testShouldAdd_Transaction() {
        chainblock.add(transactions.get(0));
        assertEquals(1, chainblock.getCount());
        chainblock.add(transactions.get(1));
        assertEquals(2, chainblock.getCount());
    }

    @Test
    public void testShouldNotAdd_DuplicateTransaction() {
        chainblock.add(transactions.get(0));
        chainblock.add(transactions.get(0));
        assertEquals(1, chainblock.getCount());
    }

    @Test
    public void testContainsWithTransaction_ShouldReturnFalse() {
        this.chainblock.add(transactions.get(0));
        boolean chainBlockContainsTransaction = chainblock.contains(transactions.get(1));
        assertFalse(chainBlockContainsTransaction);
    }

    @Test
    public void testContainsWithTransaction_ShouldReturnTrue() {
        chainblock.add(transactions.get(0));
        boolean chainBlockContainsTransaction = chainblock.contains(transactions.get(0));
        assertTrue(chainBlockContainsTransaction);
    }

    @Test
    public void testContainsWithId_ShouldReturnFalse() {
        chainblock.add(transactions.get(0));
        boolean chainBlockContainsTransaction = chainblock.contains(transactions.get(1).getId());
        assertFalse(chainBlockContainsTransaction);
    }

    @Test
    public void testContainsWithId_ShouldReturnTrue() {
        chainblock.add(transactions.get(0));
        boolean chainBlockContainsTransaction = chainblock.contains(transactions.get(0).getId());
        assertTrue(chainBlockContainsTransaction);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatus_ShouldThrowForMissingTransaction() {
        chainblock.changeTransactionStatus(100, TransactionStatus.FAILED);

    }

    @Test
    public void testChangeTransactionStatus_ShouldChangeStatus() {
        chainblock.add(transactions.get(0));

        chainblock.changeTransactionStatus(transactions.get(0).getId(), TransactionStatus.FAILED);

        TransactionStatus newTransactionStatus = chainblock.getById(transactions.get(0).getId()).getStatus();

        assertEquals(TransactionStatus.FAILED, newTransactionStatus);
    }

    @Test
    public void testGetById_ShouldReturnTransaction() {
        chainblock.add(transactions.get(0));

        Transaction actual = chainblock.getById(transactions.get(0).getId());

        assertEquals(transactions.get(0), actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetById_ShouldThrowExceptionForMissingTransaction() {
        fillChainBlockWithTransactions();
        chainblock.getById(1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionById_ShouldThrowForMissingTransaction() {
        fillChainBlockWithTransactions();
        chainblock.removeTransactionById(200);
    }

    @Test
    public void testRemoveTransactionById_ShouldRemoveIt() {
        fillChainBlockWithTransactions();
        chainblock.removeTransactionById(1);

        assertFalse(chainblock.contains(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatus_ShouldThrowIfNoSuchTransaction() {
        fillChainBlockWithTransactions();
        chainblock.getByTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testGetByTransactionStatus_ShouldReturnTransactions() {
        fillChainBlockWithTransactions();
        Iterable<Transaction> expectedTransactions = transactions.stream()
                .filter(t -> t.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
        Iterable<Transaction> actualTransactions = chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);

        assertEquals(expectedTransactions, actualTransactions);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithTransactionStatus() {
        fillChainBlockWithTransactions();

        chainblock.getAllSendersWithTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testGetAllSendersWithTransactionStatus_ShouldReturnSortedNames() {
        fillChainBlockWithTransactions();
        List<String> expectedTransactionSenders = transactions.stream()
                .filter(t -> t.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getFrom)//Взимаме само човека който е пратил транзакцията МАПВАМЕ
                .collect(Collectors.toList());

        Iterable<String> actualTransactionSenders = chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);

        assertEquals(expectedTransactionSenders, actualTransactionSenders);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllReceiversWithTransactionStatus() {
        fillChainBlockWithTransactions();

        chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testGetAllReceiversWithTransactionStatus_ShouldReturnSortedNames() {
        fillChainBlockWithTransactions();
        List<String> expectedTransactionSenders = transactions.stream()
                .filter(t -> t.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getTo)//Взимаме само човека който е пратил транзакцията МАПВАМЕ
                .collect(Collectors.toList());

        Iterable<String> actualTransactionRecievers = chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);

        assertEquals(expectedTransactionSenders, actualTransactionRecievers);
    }

    @Test
    public void testGetAllInAmountRange_ShouldReturnTransactions() {
        fillChainBlockWithTransactions();
        Iterable<Transaction> expectedTransaction = transactions.stream()
                .filter(t -> t.getAmount() < 12 && t.getAmount() > 10)
                .collect(Collectors.toList());
        Iterable<Transaction> actualTransactions = chainblock.getAllInAmountRange(10, 12);

        assertEquals(expectedTransaction, actualTransactions);
    }

    @Test
    public void testGetAllInAmountRange_ShouldReturnEmptyCollectionIfNoSuchTransactions() {
        fillChainBlockWithTransactions();
        Iterable<Transaction> expectedTransaction = transactions.stream()
                .filter(t -> t.getAmount() < 1100 && t.getAmount() > 1000)
                .collect(Collectors.toList());
        Iterable<Transaction> actualTransactions = chainblock.getAllInAmountRange(1000, 1100);

        assertEquals(new ArrayList<>(), actualTransactions);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverAndAmountRange_ShouldThrowForNoSuchReceiver() {
        fillChainBlockWithTransactions();
        chainblock.getByReceiverAndAmountRange("Ivan", 10, 12);
    }

    @Test
    public void testGetByReceiverAndAmountRange_ShouldReturnTransactionBeReceiverSortedByAmountReceiver() {
        fillChainBlockWithTransactions();
        List<Transaction> expectedTransactions = transactions.stream()
                .filter(t -> t.getAmount() < 13 && t.getAmount() > 10)
                .filter(t -> t.getTo().equals("Sasho"))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
        Iterable<Transaction> actualTransactions = chainblock.getByReceiverAndAmountRange("Sasho", 10, 13);
        assertEquals(expectedTransactions, actualTransactions);
    }

    @Test
    public void testGetAllOrderByAmountDescendingThenById_ShouldReturnTransaction() {
        fillChainBlockWithTransactions();

        List<Transaction> expectedTransactions = transactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        Iterable<Transaction> actualTransactions = chainblock.getAllOrderedByAmountDescendingThenById();

        assertEquals(expectedTransactions, actualTransactions);
    }

    @Test
    public void testGetByReceiverOrderedByAmountThenById_ShouldReturnTransaction() {
        fillChainBlockWithTransactions();
        Iterable<Transaction> expectedTransactions = transactions.stream()
                .filter(t -> t.getTo().equals("Sasho"))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        Iterable<Transaction> actualTransactions = chainblock.getByReceiverOrderedByAmountThenById("Sasho");

        assertEquals(expectedTransactions, actualTransactions);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverOrderedByAmountThenById_ShouldThrowForNoSuchTransactions() {
        fillChainBlockWithTransactions();
        chainblock.getByReceiverOrderedByAmountThenById("Ivan");
    }

    @Test
    public void testGetBySenderOrderedByAmountDescending_shouldReturnTransactions() {
        fillChainBlockWithTransactions();
        Iterable<Transaction> expectedTransactions = transactions.stream()
                .filter(t -> t.getFrom().equals("Sasho"))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        Iterable<Transaction> actualTransaction = chainblock.getBySenderOrderedByAmountDescending("Sasho");

        assertEquals(expectedTransactions, actualTransaction);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderOrderedByAmountDescending_shouldThrowNoSuchTransactions() {
        chainblock.getBySenderOrderedByAmountDescending("Ivan");
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmount_ShouldReturnTransactions(){
        fillChainBlockWithTransactions();
        Iterable<Transaction> expectedTransactions = transactions.stream()
                .filter(t->t.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .filter(t->t.getAmount()<=11)
                .collect(Collectors.toList());

        Iterable<Transaction> actualTransaction = chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL,11);

        assertEquals(expectedTransactions,actualTransaction);
    }
    @Test
    public void testGetByTransactionStatusAndMaximumAmount_ShouldReturnEmptyCollection(){
        fillChainBlockWithTransactions();

        Iterable<Transaction> expectedTransactions = transactions.stream()
                .filter(t->t.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .filter(t->t.getAmount()<=11)
                .collect(Collectors.toList());

        Iterable<Transaction> actualTransaction = chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL,0);
        assertEquals(new ArrayList<>(),actualTransaction);
    }

    @Test
    public void getBySenderAndMinimumAmountDescending_ShouldReturnTransactions(){
        fillChainBlockWithTransactions();

        Iterable<Transaction> expectedTransactions = transactions.stream()
                .filter(t->t.getFrom().equals("Sasho"))
                .filter(t->t.getAmount()>=10)
                .collect(Collectors.toList());

        Iterable<Transaction> actualTransaction = chainblock.getBySenderAndMinimumAmountDescending("Sasho",10);
        assertEquals(expectedTransactions,actualTransaction);
    }
    @Test(expected = IllegalArgumentException.class)
    public void getBySenderAndMinimumAmountDescending_ShouldThrowNoSuchTransaction(){
        chainblock.getBySenderAndMinimumAmountDescending("Ivan",1);
    }

    @Test
    public void testIterator(){

    }
}