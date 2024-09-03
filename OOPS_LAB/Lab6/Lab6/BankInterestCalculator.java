class Bank {
    public double getInterestRate() {
        return 0.0; // Default interest rate, to be overridden by subclasses
    }
}

class SBI extends Bank {
    @Override
    public double getInterestRate() {
        return 8.0; // SBI's interest rate
    }
}

class ICICI extends Bank {
    @Override
    public double getInterestRate() {
        return 7.0; // ICICI's interest rate
    }
}

class AXIS extends Bank {
    @Override
    public double getInterestRate() {
        return 9.0; // AXIS's interest rate
    }
}

public class BankInterestCalculator {
    public static void main(String[] args) {
        Bank sbiBank = new SBI();
        Bank iciciBank = new ICICI();
        Bank axisBank = new AXIS();

        // Dynamic method dispatch
        System.out.println("Interest rate from SBI bank: " + sbiBank.getInterestRate() + "%");
        System.out.println("Interest rate from ICICI bank: " + iciciBank.getInterestRate() + "%");
        System.out.println("Interest rate from AXIS bank: " + axisBank.getInterestRate() + "%");
    }
}
