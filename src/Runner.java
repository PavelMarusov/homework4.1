public class Runner extends Thread {
Runner nextRunner;

    public Runner(String name) {
        this.setName(name);
        this.nextRunner = nextRunner;
    }
    public Runner(String name, Runner nextRunner){
        this.setName(name);
        this.nextRunner = nextRunner;

    }
    public void run(){
        try {
            this.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(nextRunner != null){
            nextRunner.start();
            System.out.println(this.getName() + " берет палочку ");
            System.out.println(this.getName() + " бежит к " + nextRunner.getName());
        }
        if (nextRunner!=null){
//            System.out.println(nextRunner.getName());
            try {
                nextRunner.join();
                this.sleep(5000);
                System.out.println(nextRunner.getName() + "берет палочку");
                System.out.println(nextRunner.getName()  + " бежит к " + this.getName());
                System.out.println(this.getName()+" бежит к " +nextRunner.getName());
            }catch (InterruptedException e){}
        } else {
            System.out.println(this.getName() +" бежит к финишу ");
        }
        if (this.getName().equals("Runner 1")){
            System.out.println(this.getName() + " берет палочку ");
        }

    }
}
