// For week 3
// sestoft@itu.dk * 2014-09-04
import javax.annotation.concurrent.GuardedBy; 
class SimpleHistogram {
    public static void main(String[] args) {
    final int range = 5000;
    final Histogram histogram = new Histogram2(30);
    int count = 0;
    for (int p=0; p<range; p++)
        histogram.increment(countFactors(p));
        
    }

    public static int countFactors(int p) {
        if (p < 2) 
            return 0;
        int factorCount = 1, k = 2;
        while (p >= k * k) {
            if ((p % k == 0) && isPrime(k)) {
                factorCount++;
                p /= k;
            } else 
            k++;
        }
        return factorCount;
    }
    private static boolean isPrime(int n) {
        int k = 2;
        while (k * k <= n && n % k != 0)
            k++;
        return n >= 2 && k * k > n;
    }
    
  public static void dump(Histogram histogram) {
    int totalCount = 0;
    for (int item=0; item<histogram.getSpan(); item++) {
      System.out.printf("%4d: %9d%n", item, histogram.getCount(item));
      totalCount += histogram.getCount(item);
    }
    System.out.printf("      %9d%n", totalCount);
  }
}

interface Histogram {
  public void increment(int item);
  public int getCount(int item);
  public int getSpan();
  //public void addAll(Histogram hist);
}

class Histogram1 implements Histogram {
  private int[] counts;
  public Histogram1(int span) {
    this.counts = new int[span];
  }
  public void increment(int item) {
    counts[item] = counts[item] + 1;
  }
  public int getCount(int item) {
    return counts[item];
  }
  public int getSpan() {
    return counts.length;
  }
  public void addAll(Histogram h ){

  }
}



class Histogram2 implements Histogram{
  @GuardedBy("this")
  final int[] counts;
  public Histogram2(int span) {
    this.counts = new int[span];
  }
  public synchronized void increment(int item) {
    counts[item] = counts[item] + 1;
  }
  public synchronized int getCount(int item) {
    return counts[item];
  }
  public synchronized int getSpan() {
    return counts.length;
  }
  public synchronized void addAll(Histogram2 hist){
    if (counts.length == hist.getSpan()){
      for(int i = 0; i < counts.length; i++){
          counts[i] += hist.counts[i];
      }
    }
    else {
      new RuntimeException();
    }
  }
}