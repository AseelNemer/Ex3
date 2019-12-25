package algorithms;

import java.util.List;
import java.util.concurrent.TimeoutException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
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
private graph D=new DGraph();

	
	public Graph_Algo() 
	{
		D=new DGraph();
	}
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
		
		try 
		{
			FileInputStream file =new FileInputStream(file_name);
			ObjectInputStream object=new ObjectInputStream(file);
			graph g = (graph) object.readObject();
			init(g);
		}
		catch (Exception e)
		{}
	}

	@Override
	public void save(String file_name) {
		// TODO Auto-generated method stub
		try 
		{
			FileInputStream file =new FileInputStream(file_name);
			ObjectInputStream object=new ObjectInputStream(file);
		}
		catch (Exception e)
		{}
	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double shortestPathDist(int src, int dest) {
		//check if this src and this dest is in the graph
		if(D.getNode(src)==null)  throw new IllegalArgumentException("the src you entered doesn't exist in this graph ");
		if(D.getNode(dest)==null) throw new IllegalArgumentException("the dest you entered doesn't exist in this graph");
		//set all the nodes tag to 0
		setTag(D);
		//set all the node weight to infinity
		set_weight_inf(D);
		//set the src tag to 0
		D.getNode(src).setWeight(0);
		
		return 0;
	}

	private Exception TimeException(String string) {
		// TODO Auto-generated method stub
		return null;
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
	private void setTag(graph g)
	{
		node_data n=new node();
		Iterator<node_data> itr=g.getV().iterator();
		while(itr.hasNext())
		{
			n=itr.next();
			n.setTag(0);
		}
	}
	private void set_weight_inf(graph g)
	{
		node_data n=new node();
		Iterator<node_data> itr=g.getV().iterator();
		while(itr.hasNext())
		{
			n=itr.next();
			n.setWeight(Double.MAX_VALUE);
			n.setInfo("");
		}
	}
	
}
