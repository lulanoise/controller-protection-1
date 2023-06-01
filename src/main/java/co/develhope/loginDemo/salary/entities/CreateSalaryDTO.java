package co.develhope.loginDemo.salary.entities;

public class CreateSalaryDTO {

    long amount;

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CreateSalaryDTO{" +
                "amount=" + amount +
                '}';
    }
}
