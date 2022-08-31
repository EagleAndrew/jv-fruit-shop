package model;

public class Transaction {
    Operation operation;
    Fruit fruit;
    Integer sum;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "operation='" + operation + '\'' +
                ", fruit=" + fruit +
                ", quanity=" + sum +
                '}';
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String operation;

        Operation(String operation) {
            this.operation = operation;
        }
        public String getOperation() {
            return operation;
        }

    }
}
