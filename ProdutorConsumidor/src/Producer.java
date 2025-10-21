
import java.util.List;
import java.util.Random;

public class Producer implements Runnable {

   List<Integer> list;
   final Random random = new Random();

   public Producer (List<Integer> list){
    this.list = list;
   }

   @Override
   public void run () {

        for (int i = 0; i < 5; i++){
            this.list.add(random.nextInt());

            try {

                Thread.sleep(random.nextLong(10, 200));

            } catch(InterruptedException e) {}
        
        }


   }



}
