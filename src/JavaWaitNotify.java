
public class JavaWaitNotify implements Runnable {

	private final Object obj = new Object();
	boolean bStop = false;
	
	JavaWaitNotify() {
		System.out.println("开始运行");
		new Thread(this, "thread1").start();
		new Thread(this, "thread2").start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!bStop) {
			doSomeThing();
			
			synchronized (obj) {
				try {
					System.out.println(Thread.currentThread().getName() + " 卡住了");
					obj.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}

	public void doNotWait() {
		synchronized (obj) {
			System.out.println(Thread.currentThread().getName() + " 释放锁");
			obj.notifyAll();
		}
	}
	
	private void doSomeThing() {
		System.out.println(Thread.currentThread().getName() + " doSomeThing处理业务");
	}
}
