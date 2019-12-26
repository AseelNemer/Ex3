package Tests;
import javax.swing.JFrame;
import dataStructure.graph;
import dataStructure.node;
import dataStructure.DGraph;
import dataStructure.EdgeData;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import gui.Graph_GUI;
import utils.Point3D;
public class Tester {
	
	public static void main(String[] args){
graph g = new DGraph();
nodesFactory(g);
		Graph_GUI Monster =new Graph_GUI(g);
		Monster.setVisible(true);
	}
	public static void nodesFactory(graph d) {
		for(int i=1;i<=5;i++){
			Point3D p=new Point3D(i*10,i*10,0);
	node_data node=new node(i,p);
	d.addNode(node);
	
}
	
	}
}
