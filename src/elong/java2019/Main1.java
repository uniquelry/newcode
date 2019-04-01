package elong.java2019;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 同城艺龙Java校招试卷（2）
 * 设计三个线程，三个线程并行执行，需求分别在控制台输入数据后面拼接“_A”，“_B”，“_C”。
 * 并且需要保证线程1、线程2、线程3按顺序执行，即线程1执行完后再执行线程2，线程2执行完后再执行线程3。
 * @author uniquelry
 * @version v1.0
 * @create 2019/3/27 12:53
 */
public class Main1 {
	// 公平锁
	private static ReentrantLock lock = new ReentrantLock(true);
	private static String str;
	public static void main(String[] args) throws InterruptedException {
		Scanner cin = new Scanner(System.in);
		str = cin.next();

		Thread thread1 = new Thread(() -> {
			try {
				lock.lock();
				str += "_A";
			} finally {
				lock.unlock();
			}
		});
		Thread thread2 = new Thread(() -> {
			try {
				lock.lock();
				str += "_B";
			} finally {
				lock.unlock();
			}
		});
		Thread thread3 = new Thread(() -> {
			try {
				lock.lock();
				str += "_C";
			} finally {
				lock.unlock();
			}
		});
		thread1.start();
		Thread.sleep(1000);
		thread2.start();
		Thread.sleep(1000);
		thread3.start();

		while (thread1.isAlive() || thread2.isAlive() || thread3.isAlive()) {

		}
		System.out.println(str);
	}

}
