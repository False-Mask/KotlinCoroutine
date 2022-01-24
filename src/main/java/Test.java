public class Test {
    public static void main(String[] args) throws InterruptedException {
        ThreadTest test = new ThreadTest();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
            test.notified();
        }).start();
        test.await();

    }
}

class ThreadTest {
    void await(){
        synchronized (this){
            System.out.println("爷睡一会");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("爷醒了");
        }
    }

    void notified(){
        synchronized (this){
            this.notifyAll();
        }
    }


}
