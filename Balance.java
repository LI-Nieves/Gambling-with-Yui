public class Balance {
    private int balance = 0;
    private int proxyBalance = 0;
    private int startBalance = 0;
    private int count = 0;

    public Balance(int balance, int count) {
        this.balance = new Integer(balance);
        this.count = new Integer(count);
    }
    public Balance (Balance copy) {
        this.balance = new Integer(copy.balance);
        this.count = new Integer(copy.count);
    }

    public int getBalance() {
        return new Integer(this.balance);
    }
    public int getProxyBalance() {
        return new Integer(this.proxyBalance);
    }
    public int getStartBalance() {
        return new Integer(this.startBalance);
    }    
    public int getNet() {
        return new Integer(this.balance - this.startBalance);
    }
    
    public void gain(int amount) {
        if (amount > 0) {
            this.balance = new Integer(this.balance + amount);
        }
    }
    public void loss(int amount) {
        if (amount > 0) {
            this.balance = new Integer(this.balance - amount);
        }
    }
    public void predict(int amount) {
        if (amount > 0) {
            this.proxyBalance = new Integer(this.balance);
            this.proxyBalance = new Integer(this.proxyBalance - amount);
        }
    }
    public void setStartBalance(int amount) {
        if (amount > 0 && this.count == 0) {
            this.startBalance = new Integer(amount);
            this.balance = new Integer(amount);
        }
    }
    public void setCount() {
        this.count++;
    }
}