public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		map map1 = new map();
		
		 MyRunnable runnable = new MyRunnable(10);
	        Thread t = new Thread(runnable);
	        t.start();
	}
}