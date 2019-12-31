package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dataStructure.DGraph;
import dataStructure.EdgeData;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node;
import dataStructure.node_data;
import utils.Point3D;

class DGraphTest {
graph D=new DGraph();
@BeforeEach
void init() {
	D=new DGraph();
}
	@Test
	void testGetNode(){
		Point3D p=new Point3D(2,2);
		node node=new node(1,p);
		int KEY=1;
		D.addNode(node);
	assertSame(node ,	D.getNode(KEY));
	}

	@Test
	void testGetEdge() {
		Point3D p=new Point3D(3,4);
		Point3D p2=new Point3D(6,7);
		node src =new node(1,p);
		node dest=new node(2,p2);
		D.addNode(src);
		D.addNode(dest);
		D.connect(src.getKey(), dest.getKey(), 4);
		edge_data edge=new EdgeData(src,dest,4,0);
		assertEquals(edge.toString(),D.getEdge(src.getKey(), dest.getKey()).toString());
				
		
	}

	@Test
	void testAddNode() {
		Point3D p=new Point3D(3,4);
		node src =new node(1,p);
		D.addNode(src);
		assertEquals(src,D.getNode(1));
	}

	@Test
	void testConnect() {
		Point3D p=new Point3D(5,8);
		Point3D p2=new Point3D(6,20);
		node src =new node(1,p);
		node dest=new node(2,p2);
		D.addNode(src);
		D.addNode(dest);
		D.connect(src.getKey(), dest.getKey(), 6);
		D.connect(src.getKey(), dest.getKey(), 6);
		edge_data edge=new EdgeData(src,dest,6,0);
		assertEquals(edge.toString(),D.getEdge(src.getKey(), dest.getKey()).toString());
		
	}

	@Test
	void testGetV() {
		D=nodesFactory();
		Collection<node_data> nodes=D.getV();
		int sizeV=nodes.size();
		assertEquals(5,sizeV);
		
	}

	@Test
	void testGetE() {
		D=nodesFactory();
		Collection<edge_data> edge=D.getE(1);
		int sizeE=edge.size();
		assertEquals(3,sizeE);
		Collection<edge_data> edges=D.getE(2);
		int sizeE2=edges.size();
		assertEquals(1,sizeE2);
		}

	@Test
	void testRemoveNode() {
		D=nodesFactory();
	node_data removed=D.removeNode(1);
		assertNull(D.getNode(removed.getKey()));
	}

	@Test
	void testRemoveEdge() {
		D=nodesFactory();
		int x=D.edgeSize();
		edge_data removedg=D.removeEdge(1, 2);
		assertNotEquals(D.edgeSize(),x);
	}

	@Test
	void testNodeSize() {
		D=nodesFactory();
		int x=D.nodeSize();
		assertEquals(5,x);
		
	}

	@Test
	void testEdgeSize() {
		
		D=nodesFactory();
		int e=D.edgeSize();
		assertEquals(6,e);
	}

	@Test
	void testGetMC() {
		D=nodesFactory();
		assertNotEquals(0,D.getMC());
	}
	
	public static graph nodesFactory() {
		graph d=new DGraph();
		d.addNode(new node(2,new Point3D(250,100)));
		d.addNode(new node(1,new Point3D(50,250)));
		d.addNode(new node(3,new Point3D(255,280)));
		d.addNode(new node(4,new Point3D(500,500)));
		d.addNode(new node(5,new Point3D(700,450)));
		 d.connect(1, 2, 5);
		 d.connect(1, 3, 4);
		 d.connect(1, 4, 7);
		 d.connect(2, 5, 2);
		 d.connect(4, 5, 3);
		 d.connect(3, 4, 1.5);
		 
		 return d;
	}

}
