class ZeroEvenOdd {
    private int n;
    private boolean flag = true;
    private Semaphore zero = new Semaphore(1);
    private Semaphore odd = new Semaphore(0);
    private Semaphore even = new Semaphore(0);
    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        int rep = this.n;
        for(int i = 0; i < rep; i++){
            zero.acquire();
            printNumber.accept(0);
            if(flag){
                odd.release();
            }
            else{
                even.release();
            }
            flag = !flag;
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        int rep = this.n / 2;
        int num = 2;
        for(int i = 0; i < rep; i++){
            even.acquire();
            printNumber.accept(num);
            num += 2;
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int rep = (int)Math.ceil((double)this.n / 2);
        int num = 1;
        for(int i = 0; i < rep; i++){
            odd.acquire();
            printNumber.accept(num);
            num += 2;
            zero.release();
        }
    }
}
