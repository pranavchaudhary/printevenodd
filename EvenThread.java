package src.com.thread.oddeven;

public class EvenThread implements Runnable {
	private MonitorObj lock;
	private int limit;
	
	public EvenThread(MonitorObj lock, int limit) {
		this.lock = lock;
		this.limit = limit;
	}

	@Override
	public void run() {
		for(int i = 0; i <= limit; i = i+2) {
			synchronized (lock) {
				while(lock.isOdd()) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(i);
				lock.setOdd(true);
				lock.notify();
			}
		}
	}
}
