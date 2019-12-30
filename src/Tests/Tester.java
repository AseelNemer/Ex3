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
	
		graph d=new DGraph();
		
		d.addNode(new node(1,new Point3D(50,250)));
		d.addNode(new node(2,new Point3D(250,100)));
		d.addNode(new node(3,new Point3D(255,280)));
		d.addNode(new node(4,new Point3D(500,500)));
		d.addNode(new node(5,new Point3D(700,450)));
		 d.connect(1, 2, 5);
		 d.connect(1, 3, 4);
		 d.connect(1, 4, 7);
		 d.connect(2, 5, 2);
		 d.connect(4, 5, 3);
		 d.connect(3, 4, 1.5);
		 
		graph_algorithms g=new Graph_Algo();
		g.init(d);
		Graph_GUI Monster =new Graph_GUI(d);

		Monster.setVisible(true);
	}

	
	}

