package bankAccount;

public class AccountHolder implements Runnable {

    private Account account;

    public AccountHolder(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        depositToAccount(2000);
        for (int i = 0; i < 4; i++) {
            withdrawFromAccount(2000);
            if (account.getBalance() < 0) {
                System.out.println("Account has reduced too much");
            }
        }
    }

    private void depositToAccount(int amount) {
        System.out.println(Thread.currentThread().getName() + " is going to deposit " + amount);
        account.deposit(amount);
        System.out.println(Thread.currentThread().getName() + " completed deposit " + amount);
    }

    private synchronized void withdrawFromAccount(int amount) {
        if (account.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " is going to withdraw " + amount);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " completed withdraw " + amount);
        } else {
            System.out.println("Not enough in account for " + Thread.currentThread().getName() + " to withdraw," +
                    " Balance : " + account.getBalance());
        }
    }

}
