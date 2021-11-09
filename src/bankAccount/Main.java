package bankAccount;

public class Main {

    public static void main(String[] args) {
        Account account = new Account(6000);
        AccountHolder accountHolder = new AccountHolder(account);
        Thread thread1 = new Thread(accountHolder, "Holder1");
        Thread thread2 = new Thread(accountHolder, "Holder2");
        /*thread1.setName("Holder1");
        thread2.setName("Holder2");*/

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Account final balance : " + account.getBalance());

    }
}
