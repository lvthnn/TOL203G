import edu.princeton.cs.algs4.*;

public class GraphProperties {
  private int[] e;
  private int d;
  private int r;
  private int c;

  public GraphProperties(Graph G) {
    if (G.E() == 0) throw new IllegalArgumentException("Graph must be connected");
    int V = G.V();

    // initialize array of vertex eccentricies
    e = new int[V];
    for (int v = 0; v < V; v++) e[v] = 0;

    // compute eccentricities of vertices
    for (int v = 0; v < V; v++) {
      BreadthFirstPaths M = new BreadthFirstPaths(G, v);
      for (int w = 0; w < V; w++) {
        if (v == w) continue;
        else if (M.distTo(w) > e[v]) e[v] = M.distTo(w);
      }
    }

    // determine diameter
    d = Integer.MIN_VALUE;
    for (int v = 0; v < V; v++)
      if (e[v] > d) d = e[v];

    // determine radius
    r = Integer.MAX_VALUE;
    c = -1;
    for (int v = 0; v < V; v++) {
      if (e[v] < r) {
        r = e[v]; 
        c = v; 
      }
    }
  }

  public int eccentricity(int v) 
  { return e[v]; }
  
  public int diameter() 
  { return d; }

  public int radius() 
  { return r; }

  public int center() 
  { return c; }

}
