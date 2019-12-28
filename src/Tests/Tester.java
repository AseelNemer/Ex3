package Tests;
import javax.swing.JFrame;

import algorithms.Graph_Algo;
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
		graph g =new DGraph();
		g.addNode(new node(new Point3D(20,15)));
		g.addNode(new node(new Point3D(60,80)));
		g.addNode(new node(new Point3D(55,27)));
		g.addNode(new node(new Point3D(350,250)));
		g.addNode(new node(new Point3D(450,55)));
		g.connect(1, 2, 10);
		g.connect(2, 3, 20);
		g.connect(3, 4, 2);
		g.connect(0, 1, 5);
		Graph_Algo g1=new Graph_Algo();
		
		
		
		
		Graph_GUI Monster =new Graph_GUI(g);
		Monster.setVisible(true);
	}

	
	}

