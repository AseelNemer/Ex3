package dataStructure;
import java.util.HashMap;

import java.util.Iterator;

import java.util.Collection;

public class DGraph implements graph{
	
HashMap<Integer ,node_data> nodes=new HashMap<Integer,node_data>();
HashMap<Integer ,HashMap<Integer,edge_data>> edges=new HashMap<Integer, HashMap<Integer,edge_data>>();
/*
public DGraph(HashMap<Integer ,node_data> node,HashMap<Integer ,HashMap<Integer,edge_data>> edge) {
	this.nodes=new HashMap(node);
	this.edges=new HashMap(edge);
}
*/
	@Override
	public node_data getNode(int key) {
		
		return nodes.get(key);
	}

	@Override
	public edge_data getEdge(int src, int dest) {
		
		return edges.get(src).get(dest);
	}

	@Override
	public void addNode(node_data n) {
		nodes.put(n.getKey(), n);
		
	}

	@Override
	public void connect(int src, int dest, double w) {

		if(edges.containsKey(src)) {
			HashMap<Integer,edge_data> f=new HashMap(edges.get(src));
			f.put(dest,(edge_data) new EdgeData(this.getNode(src),this.getNode(dest),w,0));
		edges.put(src, f);
		}else {
			HashMap<Integer,edge_data> f=new HashMap<Integer,edge_data>();
			f.put(dest,(edge_data) new EdgeData(this.getNode(src),this.getNode(dest),w,0));
			edges.put(src, f);
			
		}
	}

	@Override
	public Collection<node_data> getV() {
		// TODO Auto-generated method stub
		
		return nodes.values();
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		// TODO Auto-generated method stub
		return edges.get(node_id).values();
	}

	@Override
	public node_data removeNode(int key) {
		// TODO Auto-generated method stub
		if(nodes.containsKey(key)){
			return nodes.remove(key);
			
		}
		return null;
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		// TODO Auto-generated method stub
		return edges.get(src).remove(dest);
	}

	@Override
	public int nodeSize() {
		// TODO Auto-generated method stub
		return nodes.size();
	}

	@Override
	public int edgeSize() {
		// TODO Auto-generated method stub
		Iterator<Integer> itr=edges.keySet().iterator();
		int V=0;
		int i;
		while(itr.hasNext()) {
			i=itr.next();
			V+=edges.get(i).size();
		}
		return V;
	}

	@Override
	public int getMC() {
		// TODO Auto-generated method stub
		return 0;
	}

}
