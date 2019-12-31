package algorithms;

import java.util.*;
import java.util.Stack;
import java.util.concurrent.TimeoutException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import dataStructure.DGraph;
import dataStructure.EdgeData;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node;
import dataStructure.node_data;
import gui.Graph_GUI;
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
		 D=new DGraph();
		Iterator<node_data> itr=g.getV().iterator();
		node_data x=new node();
		while(itr.hasNext()) 
		{
			x=itr.next();
			D.addNode(x);
			
		}
		 itr=g.getV().iterator();
		 x=new node();
		while(itr.hasNext()) 
		{
			x=itr.next();
			
				Iterator<edge_data> etr=g.getE(x.getKey()).iterator();
				
				while(etr.hasNext())
				{
					edge_data r=etr.next();
					D.connect(r.getSrc(), r.getDest(), r.getWeight());
				}
		}
	}
	
	@Override
	public void init(String file_name) {
		
		try 
		{
			FileInputStream file =new FileInputStream(file_name);
			ObjectInputStream object=new ObjectInputStream(file);
			this.D= (graph) object.readObject();
			
			object.close();
			file.close();
		}
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
          
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        } 
	}

	@Override
	public void save(String file_name) {
		// TODO Auto-generated method stub
		try 
		{
			FileOutputStream file =new FileOutputStream(file_name);
			ObjectOutputStream object=new ObjectOutputStream(file);
			object.writeObject(D);
			object.close();
			file.close();
			System.out.println("Graph has been serialized"); 
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
  
	}

	@Override
	public boolean isConnected() {
		if(this.D==null)
			return false;
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

		//check if this src and this dest is in the graph
		if(D.getNode(src)==null)  throw new IllegalArgumentException("the src you entered doesn't exist in this graph ");
		if(D.getNode(dest)==null) throw new IllegalArgumentException("the dest you entered doesn't exist in this graph");
		
		//set all the nodes tag to 0
		setTag(D);
		
		//set all the node weight to infinity
		set_weight_inf(D,src);
	
		RecursiveShortPath(src);
		return D.getNode(dest).getWeight();

	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {

		LinkedList<node_data> list=new LinkedList<node_data>();
		node_data node=new node();
		if(shortestPathDist( src, dest)>=0)
		{
			node=D.getNode(dest);
			int temp;
			while (node!=D.getNode(src))
			{
				list.addFirst(node);
				temp= Integer.parseInt(node.getInfo());
				node=D.getNode(temp);
			}
		}
		list.addFirst(D.getNode(src));
		
		return list;
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
		List<node_data> ans=new LinkedList<node_data>();
        List<Integer> target =new ArrayList<Integer>(targets);
        for(int i: target) {
        	if(shortestPath(i, i+1)==null) throw new RuntimeException ("The Graph isnotconnected there is two targets without road");
        	ans.addAll(shortestPath(i,i+1));
        	Iterator<node_data> itr=ans.iterator();
        	while(itr.hasNext()) {
        		node_data node=itr.next();
        		if(target.contains(node.getKey())) {
        			target.remove(node.getKey());
        		};
        	}
        }
		return ans;
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
			if(!g.getV().contains(node))
				g.addNode(node);
			while(edgeitr.hasNext())
			{
				edge_data e=edgeitr.next();
				if(!g.getV().contains(D.getNode(e.getDest())))
					g.addNode(D.getNode(e.getDest()));
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
			
			g.getNode(n.getKey()).setTag(0);
		}
	}
	private void set_weight_inf(graph g,int src)
	{
		node_data n=new node();
		Iterator<node_data> itr=g.getV().iterator();
		
		while(itr.hasNext())
		{
			n=itr.next();
			g.getNode(n.getKey()).setWeight(Double.MAX_VALUE);
			g.getNode(n.getKey()).setInfo("");
		}
		g.getNode(src).setWeight(0);
	}
	
	
private void RecursiveShortPath(int src) {
		Iterator<edge_data> itr=D.getE(src).iterator();
		
		while(itr.hasNext())
		{
				edge_data ed=itr.next();
				double v=D.getNode(src).getWeight()+ed.getWeight();
			
				if(D.getNode(ed.getDest()).getTag()==0) 
				{
					D.getNode(ed.getDest()).setWeight(v);
					D.getNode(ed.getDest()).setTag(1);
					RecursiveShortPath(ed.getDest());
					D.getNode(ed.getDest()).setInfo(Integer.toString(ed.getSrc()));
			
				}
				else 
				{
					if(v<D.getNode(ed.getDest()).getWeight()) {
						D.getNode(ed.getDest()).setWeight(v);
						RecursiveShortPath(ed.getDest());
						D.getNode(ed.getDest()).setInfo(Integer.toString(ed.getSrc()));
				
					}
		
				}
			}
		}
	
	
	public static void main(String[] args) {
	/**	graph_algorithms g=new Graph_Algo();
		graph D=Graph_GUI.nodesFactory();
		g.init(D);
		System.out.println(g.isConnected());
	    double x=g.shortestPathDist(1,4);
	    System.out.println(x);
		graph F=(graph) g.copy();
		Collection<node_data> b=F.getV();
		Iterator<node_data> iter=b.iterator();
		while(iter.hasNext()) {
			node_data no=iter.next();
		Collection<edge_data> a=F.getE(no.getKey());
		Iterator<edge_data> itr=a.iterator();
	System.out.println(a.size());
		while(itr.hasNext()) {
			edge_data n=itr.next();
			System.out.println(n.getSrc()+","+n.getDest()+","+n.getWeight());
		}
<<<<<<< HEAD
<<<<<<< HEAD
		}
=======
		}
		System.out.println(F.getMC());
>>>>>>> 9acd3493fd39d1d4dacb90970d8eb4f378372abc*/


	

	
		


}
	
}