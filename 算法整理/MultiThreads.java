package 字节;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.xml.stream.events.StartDocument;

public class MultiThreads
{
	/**
	 * 实现两个线程交替打印从1到100
	 * @param args
	 */

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
        //test1();
        test3();
	}
	
	public static int i = 1;
	public volatile static int j = 1;
	public volatile static boolean flag = false;
	public static int count = 0;
	 
	public static Lock lock = new ReentrantLock();
	public static Condition conditionA = lock.newCondition();
	public static Condition conditionB = lock.newCondition();
	 
	private static CountDownLatch latch = new CountDownLatch(2);
	private static AtomicInteger numA = new AtomicInteger();
	private static AtomicInteger numB = new AtomicInteger();
	 
	private static byte[] block = new byte[0];

	//使用信号判断
	public static void test1() {
		new Thread(() -> {
			while (i < 10) {
				if (!flag) {
					System.out.println(Thread.currentThread().getName()
							+ "----" + (i++));
					flag = true;
				}
			}
		}).start();
 
		new Thread(() -> {
			while (j < 10) {
				if (flag) {
					System.out.println(Thread.currentThread().getName()
							+ "----" + (-j++));
					flag = false;
				}
			}
		}).start();
	}
	
	//lock
	public static void test2() {
		new Thread(() -> {
			while (i < 10) {
				try {
					lock.lock();
					while (!flag) {
						System.out.println(Thread.currentThread().getName()
								+ "----" + (i++));
						flag = true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		}).start();
 
		new Thread(() -> {
			while (j < 10) { 
				try {
					lock.lock();
					while (flag) {
						System.out.println(Thread.currentThread().getName()
								+ "----" + (j++));
						flag = false;
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		}).start();
	}
	
	public static void test3() {
		new Thread(()->{
			while(i<10) {
				try
				{
					lock.lock();
					while(!flag) {
						System.out.println(Thread.currentThread().getName()+(i++));
						flag = true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
			}
		}).start();
		
		new Thread(()->{
		    while(j<10) {
		    	try
				{
		    		lock.lock();
		    		while(flag) {
			    		System.out.println(Thread.currentThread().getName()+(j++));
			    		flag = false;
			    	}
				} catch (Exception e2)
				{
				   e2.printStackTrace();
				}finally {
					lock.unlock();
				}
		    	
		    }
		}).start();
	}
}
