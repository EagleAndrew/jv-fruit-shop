package strategy.operations;

import model.Fruit;
import model.Transaction;
import storage.Storage;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        if (!Storage.storage.containsKey(fruit)) {
            Storage.storage.put(fruit, transaction.getSum());
        } else {
            Integer currentQuantity = Storage.storage.get(fruit) + transaction.getSum();
            Storage.storage.put(fruit, currentQuantity);
        }
    }
}
