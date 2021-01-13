package Program1;

public class Main {

    public static void main(String[] args){

        Thread thread = new Thread(() -> {
            System.out.println("Helo World!!");
        });

        thread.start();

        try {
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}
