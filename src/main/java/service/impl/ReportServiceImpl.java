package service.impl;

import service.ReportService;
import model.Fruit;
import storage.Storage;

import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_TITLE = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(REPORT_TITLE).append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> row : Storage.storage.entrySet()) {
            StringBuilder reportLine = new StringBuilder(row.getKey().getName()
                    + COMMA + row.getValue()
                    + System.lineSeparator());
            builder.append(reportLine);
        }
        return builder.toString();
    }
}
