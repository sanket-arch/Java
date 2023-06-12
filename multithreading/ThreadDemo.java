class ThreadDemo {
    public static void main(String[] args) {
        Thread t=Thread.currentThread();
        System.out.println("current Threa"+t);
        t.setName("main Thread");
        System.out.println("After name change: " + t);
        try{
            for(int i=9;i>0;i--) {
                System.out.println(i);
                Thread.sleep(1000);
            }        
        }
        catch(InterruptedException e){
            System.out.println("main Thread interrupted");
        }
    }
}