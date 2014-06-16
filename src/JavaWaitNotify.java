
public class JavaWaitNotify implements Runnable {

	private final Object obj = new Object();
	boolean bStop = false;
	
	JavaWaitNotify() {
		System.out.println("��ʼ����");
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
					System.out.println(Thread.currentThread().getName() + " ��ס��");
					obj.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}

	public void doNotWait() {
		synchronized (obj) {
			System.out.println(Thread.currentThread().getName() + " �ͷ���");
			obj.notifyAll();
		}
	}
	
	private void doSomeThing() {
		System.out.println(Thread.currentThread().getName() + " doSomeThing����ҵ��");
	}
}
