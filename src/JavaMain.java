import java.util.Timer;
import java.util.TimerTask;


public class JavaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final JavaWaitNotify wait = new JavaWaitNotify();
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				wait.doNotWait();
			}
			
		}, 3000, 3000);   //3���ִ��run, �Ժ�ÿ��3��ִ��һ��
	}

}
