package strategy;

import model.Transaction;
import strategy.operations.OperationHandler;

public interface Strategy {
    OperationHandler getByOperation(Transaction.Operation operation);
}
