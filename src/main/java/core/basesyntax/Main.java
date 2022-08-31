package core.basesyntax;

import model.Transaction;
import service.impl.*;
import strategy.StrategyImpl;
import strategy.operations.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/java/resources/database.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/java/resources/report.csv";
    public static void main(String[] args) {
        Map<Transaction.Operation, OperationHandler> handlersMap = new HashMap<>();
        handlersMap.put(Transaction.Operation.BALANCE, new BalanceOperationHandler());
        handlersMap.put(Transaction.Operation.SUPPLY, new SupplyOperationHandler());
        handlersMap.put(Transaction.Operation.RETURN, new ReturnOperationHandler());
        handlersMap.put(Transaction.Operation.PURCHASE, new PurchaseOperationHandler());

        StrategyImpl operationStrategy = new StrategyImpl(handlersMap);

        List<String> datas = new ReaderServiceImpl().readFromFile(INPUT_FILE_NAME);
        List<Transaction> transactions = new ParserServiceImpl().parse(datas);

            for (Transaction transaction : transactions) {
                OperationHandler handler = operationStrategy.getByOperation(transaction.getOperation());
                handler.apply(transaction);
            }

        String report = new ReportServiceImpl().getReport();
        new WriterServiceImpl().writeToFile(report, OUTPUT_FILE_NAME);
    }
}
