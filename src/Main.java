import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author uniquelry
 * @create 2019/3/26 20:47
 * @version v1.0
 */
public class Main {
	public static String str;
	private final Lock lock = new ReentrantLock();
	private Condition lockA = lock.newCondition();
	private Condition lockB = lock.newCondition();
	private Condition lockC = lock.newCondition();
	int flag = 0;

	public static void main(String [] args){
		Scanner scanner = new Scanner(System.in);
		str = scanner.nextLine();
		Main append = new Main();
		scanner.close();
		new Thread(new Runnable() {
			@Override
			public void run() {
				append.appendA();
			}
		}).start();
		new Thread(() -> append.appendB()).start();
		new Thread(() -> append.appendC()).start();


		System.out.println(str);
	}

	public void appendA(){
		lock.lock();
		try {
			while (flag!=0) {
				lockA.await();
			}
			str += "_A";
			flag =1;
			lockB.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

	public void appendB() {
		lock.lock();
		try {
			while (flag!=1) {
				lockB.await();
			}
			str += "_B";
			flag =2;
			lockC.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

	public void appendC() {
		lock.lock();
		try {
			while (flag!=2) {
				lockC.await();
			}
			str += "_C";
			flag =0;
			lockA.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}
