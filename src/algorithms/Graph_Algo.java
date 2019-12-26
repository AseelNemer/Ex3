package algorithms;

import java.util.*;
import java.util.Stack;
import java.util.concurrent.TimeoutException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import dataStructure.DGraph;
import dataStructure.EdgeData;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node;
import dataStructure.node_data;
import utils.Point3D;
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
		/**try 
		{
			FileInputStream file =new FileInputStream(file_name);
			ObjectInputStream object=new ObjectInputStream(file);
		}
		catch (Exception e)
		{}*/
	}

	@Override
	public boolean isConnected() {
		boolean flag=true;
		int nodesize =0;
		setTag(D);
		Iterator<node_data> nodes=D.getV().iterator();
		while(nodes.hasNext())
		{
			node_data node=nodes.next();
			Iterator<edge_data> edges=D.getE(node.getKey()).iterator();
		
			while(edges.hasNext())
			{
				edge_data edge=edges.next();
				node_data src=D.getNode(edge.getSrc());
				node_data dest=D.getNode(edge.getDest());
				if(src.getTag()==0)
				{
					nodesize++;
					src.setTag(1);
				}
				if(dest.getTag()==0)
				{
					nodesize++;
					dest.setTag(1);
				}
				
			}
		
		
		}
		if(nodesize!=D.nodeSize())
			flag=false;
		return flag;
	}

	@Override
	public double shortestPathDist(int src, int dest) {

		// TODO Auto-generated method stub

		//check if this src and this dest is in the graph
		if(D.getNode(src)==null)  throw new IllegalArgumentException("the src you entered doesn't exist in this graph ");
		if(D.getNode(dest)==null) throw new IllegalArgumentException("the dest you entered doesn't exist in this graph");
		//set all the nodes tag to 0
		setTag(D);
		//set all the node weight to infinity
		set_weight_inf(D);
		//set the src tag to 0
		D.getNode(src).setWeight(0);

		Iterator<node_data> nodes=D.getV().iterator();
		node_data node;
		edge_data edge=new EdgeData();
		
		
		try 
		{
			while(nodes.hasNext())
			{
				node=nodes.next();
				Iterator<edge_data> edges=D.getE(node.getKey()).iterator();
			
				while(edges.hasNext())
				{
					edge=edges.next();
					int d=edge.getDest();
					double tmp_w=node.getWeight()+edge.getWeight();
					if(D.getNode(d).getWeight()>tmp_w)
					{
						D.getNode(d).setWeight(tmp_w);
						D.getNode(d).setInfo(""+node.getKey());
					}
					D.getNode(d).setTag(1);
				}
				
			
			}
		}
		catch (Exception e) {}
		
		return D.getNode(dest).getKey();
/**=======

		RecursiveShortPath(src);
		return D.getNode(dest).getWeight();*/
	}

	
	
	@Override
	public List<node_data> shortestPath(int src, int dest) {

		Stack<node_data> stack=new Stack<node_data>();
		node_data node=new node();
		if(shortestPathDist( src, dest)>=0)
		{
			node=D.getNode(dest);
			int temp;
			while (node!=D.getNode(src))
			{
				stack.add(node);
				temp= Integer.parseInt(node.getInfo());
				node=D.getNode(temp);
			}
		}
		stack.add(D.getNode(src));
		
		return stack;
/**=======
		// TODO Auto-generated method stub
this.RecursiveShortPath(src);
	LinkedList<node_data> ans=new LinkedList<node_data>();
	while(Integer.parseInt(D.getNode(src).getInfo())!=dest) {
		ans.add(D.getNode(src));
	}
	ans.add(D.getNode(dest));
	
	return ans;
>>>>>>> d08184186dbbda3c57ea194952a2ad0339771dae*/
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public graph copy() {
		graph g=new DGraph();
		Iterator<node_data> nodes=D.getV().iterator();
		while(nodes.hasNext())
		{
			node_data node=nodes.next();
			Collection<edge_data> edges=D.getE(node.getKey());
			Iterator<edge_data> edgeitr=edges.iterator();
			g.addNode(node);
			while(edgeitr.hasNext())
			{
				edge_data e=edgeitr.next();
				g.connect(node.getKey(), e.getDest(),e.getWeight() );
			}
			
		}
		return g;
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
	private void RecursiveShortPath(int src) {
		Iterator<edge_data> itr=D.getE(src).iterator();
		
		while(itr.hasNext()) {
			edge_data ed=itr.next();
			double v=D.getNode(src).getWeight()+ed.getWeight();
		if(D.getNode(ed.getDest()).getTag()==0) {
			D.getNode(ed.getDest()).setWeight(v);
			D.getNode(ed.getDest()).setTag(1);
			RecursiveShortPath(ed.getDest());
			D.getNode(ed.getSrc()).setInfo(Integer.toString(ed.getDest()));
		}else {
			if(v<D.getNode(ed.getDest()).getWeight()) {
				D.getNode(ed.getDest()).setWeight(v);
				RecursiveShortPath(ed.getDest());
				D.getNode(ed.getSrc()).setInfo(Integer.toString(ed.getDest()));
			}
		}
		
		
		}
		
	}
}