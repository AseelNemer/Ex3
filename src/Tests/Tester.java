

package Tests;
import javax.swing.JFrame;

import algorithms.Graph_Algo;
import algorithms.graph_algorithms;
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
	
		graph g=new DGraph();
		
		/**d.addNode(new node(1,new Point3D(50,250)));
		d.addNode(new node(2,new Point3D(250,100)));
		d.addNode(new node(3,new Point3D(255,280)));
		d.addNode(new node(4,new Point3D(500,500)));
		//d.addNode(new node(5,new Point3D(700,450)));
		 /**d.connect(1, 2, 5);
		 d.connect(1, 3, 4);
		 d.connect(1, 4, 7);
		 d.connect(2, 5, 2);
		 d.connect(4, 5, 3);
		 d.connect(3, 4, 1.5);
		d.connect(1, 3, 8);
		d.connect(3, 2, 1);
		d.connect(3, 4, 5);
		d.connect(4, 2, 8);
		d.connect(1, 2, 4); 
		d.connect(1, 4, 7);*/
		g.addNode(new node(new Point3D(250,250)));
		g.addNode(new node(new Point3D(340,250)));
		g.addNode(new node(new Point3D(378,650)));
		g.addNode(new node(new Point3D(300,172)));
		g.addNode(new node(new Point3D(547,450)));
		g.addNode(new node(new Point3D(710,198)));
		g.connect(1, 2, 5);
		g.connect(2, 5, 8);
		g.connect(3, 1, 9);
		g.connect(3, 2, 10);
		g.connect(3, 4, 5);
		g.connect(4, 2, 2);
		g.connect(5, 4, 6);
		g.connect(5, 6, 7);
		g.connect(6, 4,12);
	

		graph_algorithms g1=new Graph_Algo();
		g1.init(g);
		Graph_GUI Monster =new Graph_GUI(g);

		Monster.setVisible(true);
		//graph copy_graph=g1.copy();

	}	
}

