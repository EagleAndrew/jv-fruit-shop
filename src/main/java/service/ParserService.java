package service;

import model.Transaction;

import java.util.List;

public interface ParserService {
    List<Transaction> parse(List<String> data);
}
