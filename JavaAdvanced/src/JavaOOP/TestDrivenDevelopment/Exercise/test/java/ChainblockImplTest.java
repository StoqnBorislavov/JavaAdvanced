package JavaOOP.TestDrivenDevelopment.Exercise.test.java;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ChainblockImplTest {
    private Chainblock chainblock;
    private Transaction transaction;
    private List<Transaction> transactions;

    public ChainblockImplTest() {
        this.chainblock = new ChainblockImpl();
        this.transaction = new TransactionImpl(1, TransactionStatus.SUCCESSFUL,
                "from", "to", 14.78);
        this.createRandomTransactions();
    }

    private void createRandomTransactions() {
        this.transactions = new ArrayList<>();
        TransactionStatus[] statuses = TransactionStatus.values();
        Random random = new Random(48);
        for (int i = 2; i < 22; i++) {
            String from = Character.getName(random.nextInt(122));

            Transaction transaction =
                    new TransactionImpl(i,
                            statuses[i % statuses.length],
                            "From" + from, "To" + i,
                            new Random().nextDouble() * 99.123);

            this.transactions.add(transaction);
        }
    }

    @Test
    public void testAddShouldIncreaseCountOfTransaction() {
        chainblock.add(transaction);
        assertEquals(1, chainblock.getCount());

    }

    @Test
    public void testAddShouldNotIncreaseCountWhenTransactionIdIsPreviouslyAdd() {
        chainblock.add(transaction);
        chainblock.add(transaction);
        assertEquals(1, chainblock.getCount());
    }

    @Test
    public void testContainsByIdShouldReturnCorrectBooleanValue() {
        assertFalse(chainblock.contains(transaction.getId()));
        chainblock.add(transaction);
        assertTrue(chainblock.contains(transaction.getId()));
    }

    @Test
    public void testChangeTransactionStatusShouldChangeTheStatusOfTheCorrectTransaction() {
        chainblock.add(transaction);
        chainblock.changeTransactionStatus(transaction.getId(), TransactionStatus.FAILED);
        assertEquals(TransactionStatus.FAILED, transaction.getTransactionStatus());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusShouldThrowIfTransactionNotPresent() {
        chainblock.changeTransactionStatus(transaction.getId(), TransactionStatus.FAILED);
    }

    @Test
    public void testRemoveByIdShouldRemoveCorrectTransaction() {
        fillChainBlockWithTransactions();
        chainblock.removeTransactionById(transaction.getId());
        assertFalse(chainblock.contains(transaction.getId()));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveByIdShouldThrowIfTransactionIsNotPresent() {
        chainblock.add(transaction);
        chainblock.removeTransactionById(transaction.getId() + 1);
    }

    @Test
    public void testGetByIdShouldReturnTheCorrectTransaction() {
        fillChainBlockWithTransactions();

        Transaction expected = this.transactions.get(10);
        Transaction actual = chainblock.getById(expected.getId());

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdShouldThrowIfIdIsNotPresent() {
        fillChainBlockWithTransactions();
        chainblock.getById(transactions.get(transactions.size() - 1).getId() + 10);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetTransactionsByStatusShouldThrowWithStatusNotPresent() {
        int transactionsWithFailedStatus = 0;
        for (Transaction t : transactions) {
            if (t.getTransactionStatus() == TransactionStatus.FAILED) {
                transactionsWithFailedStatus++;
            }
        }
        List<Transaction> filteredTransactions = transactions.stream()
                .filter(t -> t.getTransactionStatus() != TransactionStatus.FAILED)
                .collect(Collectors.toList());

        assertFalse(filteredTransactions.stream()
                .anyMatch(t -> t.getTransactionStatus() == TransactionStatus.FAILED));
        for (Transaction t : filteredTransactions) {
            chainblock.add(t);
        }
        chainblock.getByTransactionStatus(TransactionStatus.FAILED);

    }

    @Test
    public void testGetTransactionsByStatusShouldReturnOnlyTransactionsWithCorrectStatus() {
        fillChainBlockWithTransactions();
        Iterable<Transaction> byTransactionStatus = chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);

        assertNotNull(byTransactionStatus);


        List<Transaction> expected = transactions.stream()
                .filter(t -> t.getTransactionStatus() == TransactionStatus.SUCCESSFUL)
                .collect(Collectors.toList());

        expected.add(0, transaction);

        List<Transaction> actual = new ArrayList<>();

        byTransactionStatus.forEach(actual::add);

        assertEquals(expected.size(), actual.size());

        for (Transaction t : actual) {
            assertEquals(TransactionStatus.SUCCESSFUL, t.getTransactionStatus());
        }

    }

    @Test
    public void testGetTransactionsByStatusShouldReturnTransactionsWithCorrectOrder() {
        fillChainBlockWithTransactions();
        Iterable<Transaction> byTransactionStatus = chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);

        assertNotNull(byTransactionStatus);

        List<Transaction> expected = transactions.stream()
                .filter(t -> t.getTransactionStatus() == TransactionStatus.SUCCESSFUL)
                .collect(Collectors.toList());
        expected.add(0, transaction);

        expected.sort(Comparator.comparing(Transaction::getAmount).reversed());

        List<Transaction> actual = new ArrayList<>();

        byTransactionStatus.forEach(actual::add);

        assertEquals(expected.size(), actual.size());

        assertEquals(expected, actual);


    }

    @Test
    public void testGetAllSendersByStatusShouldReturnTheCorrectSenders() {
        fillChainBlockWithTransactions();

        List<String> expected = transactions.stream().filter(t -> t.getTransactionStatus() == TransactionStatus.SUCCESSFUL)
                .map(t -> t.getFrom()).collect(Collectors.toList());
        expected.add(transaction.getFrom());

        Iterable<String> senders = chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);

        assertNotNull(senders);

        List<String> actual = new ArrayList<>();

        senders.forEach(actual::add);

        assertEquals(expected.size(), actual.size());


    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersByStatusShouldThrowWhenNoSuchStatusPresent() {
        List<Transaction> filteredTransactions = transactions.stream().filter(t -> t.getTransactionStatus() != TransactionStatus.SUCCESSFUL)
                .collect(Collectors.toList());

        for (Transaction t : filteredTransactions) {
            chainblock.add(t);
        }

        chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
    }

    @Test
    public void testGetSendersWithTransactionStatusShouldReturnSendersInCorrectOrder() {
        fillChainBlockWithTransactions();

        List<String> expected = transactions.stream().
                filter(t -> t.getTransactionStatus() == TransactionStatus.UNAUTHORIZED)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(t -> t.getFrom()).collect(Collectors.toList());

        List<String> actual = new ArrayList<>();

        Iterable<String> senders = chainblock.getAllSendersWithTransactionStatus(TransactionStatus.UNAUTHORIZED);

        assertNotNull(senders);

        senders.forEach(actual::add);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetSendersWithTransactionStatusShouldReturnMultipleDuplicateSenders() {
        fillChainBlockWithTransactions();

        List<Transaction> duplicatedSenders = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Transaction transaction = new TransactionImpl(100 + i,
                    TransactionStatus.UNAUTHORIZED,
                    "TEST_FROM",
                    "to",
                    10000000 + i);
            duplicatedSenders.add(transaction);
            chainblock.add(transaction);
        }

        transactions.addAll(duplicatedSenders);

        List<String> expected = transactions.stream().
                filter(t -> t.getTransactionStatus() == TransactionStatus.UNAUTHORIZED)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(t -> t.getFrom()).collect(Collectors.toList());

        List<String> actual = new ArrayList<>();

        Iterable<String> senders = chainblock.getAllSendersWithTransactionStatus(TransactionStatus.UNAUTHORIZED);

        assertNotNull(senders);

        senders.forEach(actual::add);

        assertEquals(expected, actual);

        duplicatedSenders.sort(Comparator.comparing(Transaction::getAmount).reversed());

        for (int i = 0; i < duplicatedSenders.size(); i++) {
            assertEquals(duplicatedSenders.get(i).getFrom(), actual.get(i));
        }
    }


    @Test
    public void testGetAllReceiversByStatusShouldReturnTheCorrectReceivers() {
        fillChainBlockWithTransactions();

        List<String> expected = transactions.stream()
                .filter(t -> t.getTransactionStatus() == TransactionStatus.SUCCESSFUL)
                .map(Transaction::getTo).collect(Collectors.toList());
        expected.add(transaction.getTo());

        Iterable<String> senders = chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);

        assertNotNull(senders);

        List<String> actual = new ArrayList<>();

        senders.forEach(actual::add);

        assertEquals(expected.size(), actual.size());


    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllReceiversByStatusShouldThrowWhenNoSuchStatusPresent() {
        List<Transaction> filteredTransactions = transactions.stream().filter(t -> t.getTransactionStatus() != TransactionStatus.SUCCESSFUL)
                .collect(Collectors.toList());

        for (Transaction t : filteredTransactions) {
            chainblock.add(t);
        }

        chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
    }

    @Test
    public void testGetReceiversWithTransactionStatusShouldReturnSendersInCorrectOrder() {
        fillChainBlockWithTransactions();

        List<String> expected = transactions.stream().
                filter(t -> t.getTransactionStatus() == TransactionStatus.UNAUTHORIZED)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(t -> t.getTo()).collect(Collectors.toList());

        List<String> actual = new ArrayList<>();

        Iterable<String> senders = chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.UNAUTHORIZED);

        assertNotNull(senders);

        senders.forEach(actual::add);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetReceiversWithTransactionStatusShouldReturnMultipleDuplicateSenders() {
        fillChainBlockWithTransactions();

        List<Transaction> duplicatedSenders = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Transaction transaction = new TransactionImpl(100 + i,
                    TransactionStatus.UNAUTHORIZED,
                    "from",
                    "TEST_TO",
                    10000000 + i);
            duplicatedSenders.add(transaction);
            chainblock.add(transaction);
        }

        transactions.addAll(duplicatedSenders);

        List<String> expected = transactions.stream().
                filter(t -> t.getTransactionStatus() == TransactionStatus.UNAUTHORIZED)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(t -> t.getTo()).collect(Collectors.toList());

        List<String> actual = new ArrayList<>();

        Iterable<String> senders = chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.UNAUTHORIZED);

        assertNotNull(senders);

        senders.forEach(actual::add);

        assertEquals(expected, actual);

        duplicatedSenders.sort(Comparator.comparing(Transaction::getAmount).reversed());

        for (int i = 0; i < duplicatedSenders.size(); i++) {
            assertEquals(duplicatedSenders.get(i).getTo(), actual.get(i));
        }
    }

    @Test
    public void testGetAllByAmountShouldReturnCorrectOrder() {
        fillChainBlockWithTransactions();

        Transaction t1 = new TransactionImpl(100, TransactionStatus.SUCCESSFUL, "From", "To", 10000);
        Transaction t2 = new TransactionImpl(200, TransactionStatus.SUCCESSFUL, "From", "To", 10000);
        chainblock.add(t1);
        chainblock.add(t2);

        this.transactions.add(transaction);
        this.transactions.add(t1);
        this.transactions.add(t2);


        List<Transaction> expected = transactions.stream().sorted(Comparator.comparing(Transaction::getAmount).reversed()
                .thenComparing(Transaction::getId)).collect(Collectors.toList());


        List<Transaction> actual = new ArrayList<>();

        Iterable<Transaction> all = chainblock.getAllOrderedByAmountDescendingThenById();

        assertNotNull(all);

        all.forEach(actual::add);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderOrderedByAmountDescendingShouldThrowWhenSenderIsNotPresent() {
        fillChainBlockWithTransactions();
        chainblock.getBySenderOrderedByAmountDescending("invalid_sender");
    }

    @Test
    public void testGetBySenderOrderedByAmountDescendingShouldReturnCorrectSender() {
        fillChainBlockWithTransactions();
        String sender = "Correct_Sender";
        for (int i = 0; i < 10; i++) {
            chainblock.add(new TransactionImpl(100 + i,
                    TransactionStatus.UNAUTHORIZED,
                    sender,
                    "to",
                    1000 + 13 * i));
        }
        Iterable<Transaction> t = chainblock.getBySenderOrderedByAmountDescending(sender);

        assertNotNull(t);

        List<Transaction> transactions = new ArrayList<>();

        t.forEach(transactions::add);

        assertEquals(10, transactions.size());

        for (Transaction transaction : transactions) {
            assertEquals(sender, transaction.getFrom());
        }

    }

    @Test
    public void testGetBySenderOrderedByAmountDescendingShouldReturnCorrectSenderWithCorrectOrder() {
        fillChainBlockWithTransactions();
        String sender = "Correct_Sender";
        for (int i = 0; i < 10; i++) {
            chainblock.add(new TransactionImpl(100 + i,
                    TransactionStatus.UNAUTHORIZED,
                    sender,
                    "to",
                    1000 + 10 * i));
        }
        Iterable<Transaction> t = chainblock.getBySenderOrderedByAmountDescending(sender);

        assertNotNull(t);

        List<Transaction> transactions = new ArrayList<>();

        t.forEach(transactions::add);

        assertEquals(10, transactions.size());


        double expectedAmount = 1090;

        for (Transaction transaction : transactions) {
            assertEquals(expectedAmount, transaction.getAmount(), 0.0);
            expectedAmount -= 10;
        }


    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverOrderedByAmountDescendingShouldThrowWhenReceiverIsNotPresent() {
        fillChainBlockWithTransactions();
        chainblock.getByReceiverOrderedByAmountThenById("invalid_sender");
    }

    @Test
    public void testGetByReceiverOrderedByAmountDescendingShouldReturnCorrectReceiver() {
        fillChainBlockWithTransactions();
        String receiver = "Correct_Receiver";
        for (int i = 0; i < 10; i++) {
            chainblock.add(new TransactionImpl(100 + i,
                    TransactionStatus.UNAUTHORIZED,
                    "from",
                    receiver,
                    1000 + 13 * i));
        }
        Iterable<Transaction> t = chainblock.getByReceiverOrderedByAmountThenById(receiver);

        assertNotNull(t);

        List<Transaction> transactions = new ArrayList<>();

        t.forEach(transactions::add);

        assertEquals(10, transactions.size());

        for (Transaction transaction : transactions) {
            assertEquals(receiver, transaction.getTo());
        }

    }

    @Test
    public void testGetByReceiverOrderedByAmountDescendingShouldReturnCorrectReceiverWithCorrectOrder() {
        fillChainBlockWithTransactions();
        String receiver = "Correct_Receiver";

        List<Transaction> expected = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            Transaction transaction = new TransactionImpl(100 + i,
                    TransactionStatus.UNAUTHORIZED,
                    "from",
                    receiver,
                    1000 + 13 * i);
            expected.add(transaction);
            chainblock.add(transaction);
        }

        for (int i = 0; i < 10; i++) {
            Transaction transaction = new TransactionImpl(200 + i,
                    TransactionStatus.UNAUTHORIZED,
                    "from",
                    receiver,
                    1000 + 13 * i);
            expected.add(transaction);
            chainblock.add(transaction);
        }
        Iterable<Transaction> t = chainblock.getByReceiverOrderedByAmountThenById(receiver);

        assertNotNull(t);

        List<Transaction> actual = new ArrayList<>();

        t.forEach(actual::add);

        expected.sort(Comparator.comparing(Transaction::getAmount).reversed().thenComparing(Transaction::getId));


        assertEquals(expected.size(), actual.size());


        assertEquals(expected, actual);
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountShouldReturnEmptyCollectionIfNoSuchTransaction(){
        fillChainBlockWithTransactions();
        Iterable<Transaction> result = chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.UNAUTHORIZED, -10000000);

        int counter = 0;
        for(Iterator<Transaction> iter = result.iterator(); iter.hasNext(); iter.next()){
            counter++;
        }
        assertEquals(0, counter);
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountShouldReturnCorrectTransactions(){
        fillChainBlockWithTransactions();

        transactions.add(transaction);

        List<Transaction> expected = transactions.stream()
                .filter(t -> t.getTransactionStatus() == TransactionStatus.UNAUTHORIZED
                        && t.getAmount() <= 100)
                .collect(Collectors.toList());
        Iterable<Transaction> result = chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.UNAUTHORIZED, 100);

        List<Transaction> actual = new ArrayList<>();

        for(Iterator<Transaction> iter = result.iterator(); iter.hasNext(); ){
            actual.add(iter.next());
        }
        assertEquals(expected.size(), actual.size());

        for (Transaction t : actual) {
            assertEquals(TransactionStatus.UNAUTHORIZED, t.getTransactionStatus());
            assertTrue(Double.compare(100, t.getAmount()) >= 0);
        }
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountShouldReturnCorrectTransactionsInCorrectOrder(){
        fillChainBlockWithTransactions();

        transactions.add(transaction);

        List<Transaction> expected = transactions.stream()
                .filter(t -> t.getTransactionStatus() == TransactionStatus.UNAUTHORIZED
                        && t.getAmount() <= 100)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
        Iterable<Transaction> result = chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.UNAUTHORIZED, 100);

        List<Transaction> actual = new ArrayList<>();

        for(Iterator<Transaction> iter = result.iterator(); iter.hasNext(); ){
            actual.add(iter.next());
        }
        assertEquals(expected, actual);
    }


    private void fillChainBlockWithTransactions() {
        for (Transaction t : transactions) {
            chainblock.add(t);
        }
        chainblock.add(transaction);
    }
}