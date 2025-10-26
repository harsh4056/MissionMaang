class Bank {
    long[]balance;
    int n;
    public Bank(long[] balance) {
        this.balance=balance;
        n=balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if(account1-1<n && account2-1<n && balance[account1-1]>=money){
            balance[account1-1]=balance[account1-1]-money;
            balance[account2-1]=balance[account2-1]+money;
            return true;
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if(account-1<n ){
            balance[account-1]=balance[account-1]+money;
            return true;
        }
        return false;
    }

    public boolean withdraw(int account, long money) {
        if(account-1<n && balance[account-1]>=money){
            balance[account-1]=balance[account-1]-money;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        long[] balance = {10, 100, 20, 50, 30};
        Bank bank = new Bank(balance);

        System.out.println(bank.withdraw(3, 10));   // Expected: true
        System.out.println(bank.transfer(5, 1, 20)); // Expected: true
        System.out.println(bank.deposit(5, 20));    // Expected: true
        System.out.println(bank.transfer(3, 4, 15)); // Expected: false
        System.out.println(bank.withdraw(10, 50));   // Expected: false

        // Print final balances
        System.out.print("Final Balances: ");
        for (long b : balance) {
            System.out.print(b + " ");
        }
        // Expected final balances: [10, 120, 10, 10, 30]
    }

}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */