package org.example.stream06;

import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupingTransactions {

    public static List<Transaction> transactions = Arrays.asList(
            new Transaction(Currency.EUR, 1500.0),
            new Transaction(Currency.USD, 2300.0),
            new Transaction(Currency.GBP, 9900.0),
            new Transaction(Currency.EUR, 1100.0),
            new Transaction(Currency.JPY, 7800.0),
            new Transaction(Currency.CHF, 6700.0),
            new Transaction(Currency.EUR, 5600.0),
            new Transaction(Currency.USD, 4500.0),
            new Transaction(Currency.CHF, 3400.0),
            new Transaction(Currency.GBP, 3200.0),
            new Transaction(Currency.USD, 4600.0),
            new Transaction(Currency.JPY, 5700.0),
            new Transaction(Currency.EUR, 6800.0)
    );

    public static void main(String... args) {
        groupImperatively();
//        groupFunctionally();
    }

    public enum Currency {
      EUR, USD, JPY, GBP, CHF
    }

    public static class Transaction {

      private final Currency currency;
      private final double value;

      public Transaction(Currency currency, double value) {
        this.currency = currency;
        this.value = value;
      }

      public Currency getCurrency() {
        return currency;
      }

      public double getValue() {
        return value;
      }

      @Override
      public String toString() {
        return currency + " " + value;
      }

    }

    private static void groupImperatively() {
        Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>();
        for (Transaction transaction : transactions) { // new Transaction(Currency.EUR, 1500.0)
            Currency currency = transaction.getCurrency(); // EUR
            List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);
            if (transactionsForCurrency == null) {
                transactionsForCurrency = new ArrayList<>();
                transactionsByCurrencies.put(currency, transactionsForCurrency);
            }
            transactionsForCurrency.add(transaction); // new Transaction(Currency.EUR, 1500.0)
        }

        transactionsByCurrencies.forEach((a, b) -> {System.out.println(a + " : " + b);});

        // 스트림 단순화
        Map<Currency, List<Transaction>> transcationByCurrencies =
                transactions.stream().collect(groupingBy(Transaction::getCurrency));
    }

    private static void groupFunctionally() {
        Map<Currency, List<Transaction>> transactionsByCurrencies = transactions.stream()
                .collect(groupingBy(Transaction::getCurrency));
        System.out.println(transactionsByCurrencies);
    }

}
