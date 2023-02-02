import java.util.Arrays;

public class HotelRoom {
  
  public static int find_room(boolean[] B) {
    int N = B.length;
    int lo = 0, hi = N-1;

    while (lo <= hi) {
      int mid = (lo + hi) >>> 1;
      boolean occupied = B[mid];

      if (occupied) lo = mid + 1;
      else if (lo == mid) return mid;
      else hi = mid;
    }
    return -1;
  } 

  public static void main(String[] args) {
    int N = Integer.parseInt(args[0]); // num. hotel rooms
    int F = Integer.parseInt(args[1]); // loc. of first available room
    if (F >= N) throw new IllegalArgumentException("F must be less than N");
   
    boolean[] B = new boolean[N];
    for (int i = 0; i < F; i++)
      B[i] = true;

    int res = find_room(B);
    System.out.println("The first available room is: " + res);
  }

}
