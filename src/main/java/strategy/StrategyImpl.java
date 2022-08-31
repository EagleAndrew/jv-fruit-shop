package strategy;

import model.Transaction;
import strategy.operations.OperationHandler;

import java.util.Map;

public class StrategyImpl implements Strategy {
    private Map<Transaction.Operation, OperationHandler> map;

    public StrategyImpl(Map<Transaction.Operation, OperationHandler> map) {
        this.map = map;
    }

    @Override
    public OperationHandler getByOperation(Transaction.Operation operation) {
        return map.get(operation);
    }
}
