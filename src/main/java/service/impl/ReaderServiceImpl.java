package service.impl;

import service.ReaderService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {

        @Override
        public List<String> readFromFile(String filePath) {
            List<String> transactions;
            try {
                transactions = Files.readAllLines(Path.of(filePath));
            } catch (IOException e) {
                throw new RuntimeException("Can't get data from file " + filePath);
            }
            return transactions;
        }
}
