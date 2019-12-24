package algorithms;

import java.util.List;
import java.util.Iterator;
import dataStructure.DGraph;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node;
import dataStructure.node_data;
/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 *
 */
public class Graph_Algo implements graph_algorithms{
graph D=new DGraph();
	@Override
	public void init(graph g) {
		// TODO Auto-generated method stub
		Iterator<node_data> itr=g.getV().iterator();
		node_data x=new node();
		while(itr.hasNext()) {
			x=itr.next();
			D.addNode(x);
			if(g.getE(x.getKey())!=null) {
				
				Iterator<edge_data> etr=g.getE(x.getKey()).iterator();
				
				while(etr.hasNext()) {
					edge_data r=etr.next();
					D.connect(r.getSrc(), r.getDest(), r.getWeight());
				}
				
				
			}
		}

	}

	@Override
	public void init(String file_name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(String file_name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double shortestPathDist(int src, int dest) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public graph copy() {
		// TODO Auto-generated method stub
		return null;
	}

}
