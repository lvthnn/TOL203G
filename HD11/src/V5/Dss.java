import edu.princeton.cs.algs4.*;

// Source-sink shortest paths. Develop an API and implementation that uses
// a version of Dijkstra’s algorithm to solve the source-sink shortest path
// problem on edge- weighted digraphs.

public class Dss {

  private DijkstraSP DSP;
  private double distSink;

	public Dss(EdgeWeightedDigraph G, int src, int sink) { 
    DSP = new DijkstraSP(G, src);
    if (DSP.hasPathTo(sink)) distSink = DSP.distTo(sink);
  }

  public double distToSink() {
    return distSink; 
  }

}
