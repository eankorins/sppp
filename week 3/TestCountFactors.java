// For week 2
// sestoft@itu.dk * 2014-08-29

class TestCountFactors {


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
}

interface Histogram {
  public void increment(int item);
  public int getCount(int item);
  public int getSpan();
}

class Histogram2 implements Histogram{
  final int[] counts;
  public Histogram2(int span) {
    this.counts = new int[span];
  }
  public synchronized void increment(int item) {
    counts[item] = counts[item] + 1;
  }
  public int getCount(int item) {
    return counts[item];
  }
  public int getSpan() {
    return counts.length;
  }
}