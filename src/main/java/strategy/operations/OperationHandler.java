package strategy.operations;

import model.Transaction;

public interface OperationHandler {
    void apply(Transaction transaction);
}
