public class MyRunnable implements Runnable {

    private int var;

    public MyRunnable(int var) {
        this.var = var;
    }

    public void run() {
    	
    	while (DrawPane.playerKill == 0){
    		
    		
    		for (float i = 0; i < 1; i = (float) (i + 0.01)){
    			
    			try {
    			    Thread.sleep(5); //old value of 5    
    			} catch(InterruptedException ex) {
    			    Thread.currentThread().interrupt();
    			}
    			
    			DrawPane.transparency = i;
    			
    		}
    		
    		try {
			    Thread.sleep(1000); //old value of 1500    
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
    		
    		DrawPane.transparency = 1;
    	
    	}
    }
}