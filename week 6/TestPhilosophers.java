// For week 6
// sestoft@itu.dk * 2014-09-29

// The Dining Philosophers problem, due to E.W. Dijkstra 1965.  Five
// philosophers (threads) sit at a round table on which there are five
// forks (shared resources), placed between the philosophers.  A
// philosopher alternatingly thinks and eats spaghetti.  To eat, the
// philosopher needs exclusive use of the two forks placed to his left
// and right, so he tries to lock them.  

// Both the places and the forks are numbered 0 to 5.  The fork to the
// left of place p has number p, and the fork to the right has number
// (p+1)%5.

// This solution is wrong; it will deadlock after a while.
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.atomic.AtomicInteger;
public class TestPhilosophers {
  

  public static void main(String[] args) {
    final AtomicInteger[] counters = { new AtomicInteger(), new AtomicInteger(), new AtomicInteger(), new AtomicInteger(), new AtomicInteger() };
    Fork[] forks = { new Fork(), new Fork(), new Fork(), new Fork(), new Fork() };
    for (int place=0; place<forks.length; place++) {
      Thread phil = new Thread(new Philosopher(forks, place, counters[place]));
      phil.start();
    }

    while (true){

      for(int i = 0; i < counters.length; i++){
        System.out.println(i + " ate: " + counters[i].get() + " times");
      }
      try { Thread.sleep(10000); }
      catch (InterruptedException exn) { }
    }
  }
}

class Philosopher implements Runnable {
  private final Fork[] forks;
  private final int place;
  public final AtomicInteger counter;
  public Philosopher(Fork[] forks, int place, AtomicInteger counter) {
    this.forks = forks;
    this.place = place;
    this.counter = counter;
  }

  public void run() {
    while (true) {
      // Take the two forks to the left and the right
      int left = place, right = (place+1) % forks.length;
      
      if(forks[left].tryLock()){
        try {
          if (forks[right].tryLock()) {
            try{ 
              counter.incrementAndGet();
            } 
            finally { forks[right].unlock(); }
          }
        } finally { forks[left].unlock(); }
      }
      // Think
      try { Thread.sleep(10); }
      catch (InterruptedException exn) { }
    }
  }
}

class Fork extends ReentrantLock {
  public static int sequenceNumber;

  public Fork(){
    sequenceNumber += 1;
  }
}

