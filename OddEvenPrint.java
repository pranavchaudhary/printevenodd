package src.com.thread.oddeven;

public class OddEvenPrint {
	public static void main(String[] args) {
		MonitorObj lock = new MonitorObj();
		lock.setOdd(false);
		Thread t1 = new Thread(new EvenThread(lock, 100));
		Thread t2 = new Thread(new OddThread(lock, 100));
		
		t1.start();
		t2.start();
	}
}
