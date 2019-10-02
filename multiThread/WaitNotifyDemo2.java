package multiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//5 producer & 5 consumer threads
public class WaitNotifyDemo2 {
	public static void main(String[] args) throws InterruptedException {
		MyList1 obj = new MyList1();
		Thread producerThread1 = new Thread(new Runnable() {
//producer: producing 100 items
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					obj.add();

				}

			}
		});
		Thread producerThread2 = new Thread(new Runnable() {
			// producer: producing 100 items
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					obj.add();

				}

			}
		});
		Thread producerThread3 = new Thread(new Runnable() {
			// producer: producing 100 items
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					obj.add();

				}

			}
		});
		Thread producerThread4 = new Thread(new Runnable() {
			// producer: producing 100 items
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					obj.add();

				}

			}
		});
		Thread producerThread5 = new Thread(new Runnable() {
			// producer: producing 100 items
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					obj.add();

				}

			}
		});
		Thread consumerThread1 = new Thread(new Runnable() {
//consumer is trying to consume 100 items
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					obj.remove();
				}
			}
		});
		Thread consumerThread2 = new Thread(new Runnable() {
			// consumer is trying to consume 100 items
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					obj.remove();
				}
			}
		});
		Thread consumerThread3 = new Thread(new Runnable() {
			// consumer is trying to consume 100 items
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					obj.remove();
				}
			}
		});
		Thread consumerThread4 = new Thread(new Runnable() {
			// consumer is trying to consume 100 items
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					obj.remove();
				}
			}
		});
		Thread consumerThread5 = new Thread(new Runnable() {
			// consumer is trying to consume 100 items
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					obj.remove();
				}
			}
		});
		producerThread1.start();
		producerThread2.start();
		producerThread3.start();
		producerThread4.start();
		producerThread5.start();
		consumerThread1.start();
		consumerThread2.start();
		consumerThread3.start();
		consumerThread4.start();
		consumerThread5.start();
		producerThread1.join();
		producerThread2.join();
		producerThread3.join();
		producerThread4.join();
		producerThread5.join();
		consumerThread1.join();
		consumerThread2.join();
		consumerThread3.join();
		consumerThread4.join();
		consumerThread5.join();
		System.out.println(obj.list.size());// 0
	}
}

class MyList1 {
	List<Integer> list = new ArrayList<>(5);
	/*
	 * final Object addLock = new Object(); final Object removeLock = new Object();
	 */
	Lock lock = new ReentrantLock();
	
	Condition add = lock.newCondition();
	Condition remove= lock.newCondition();
	public void add() {

		while (true) {
			try {
				if (lock.tryLock(2000, TimeUnit.MILLISECONDS)) {// lock was acquired on obj
					if (list.size() < 5) { // size=5
						list.add((int) (Math.random() * 1000));
						remove.signalAll();//notifyAll
						// if i don't unlock: it is waiting for releasing lock
						lock.unlock();
						break;
					}else {
						add.await();//wait
						lock.unlock();
					}
					
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void remove() {// Thread: acquire a lock on MyList object?
		while (true) {
			try {
				if (lock.tryLock(2000, TimeUnit.MILLISECONDS)) {
					if (list.size() > 0) {
						list.remove(0);
						add.signalAll();
						lock.unlock();
						break;
					} else {
						remove.await();
						lock.unlock();
					}
//removeLock would not be released if anytime size goes 0
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}// 0??
