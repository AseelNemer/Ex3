package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dataStructure.EdgeData;
import dataStructure.node;
import utils.Point3D;

class EdgeDataTest {

node src,dest;
EdgeData edge;
@BeforeEach
void init(){
	src=new node();
	dest =new node();
	edge=new EdgeData();
}
	@Test
	void testGetSrc() {
		Point3D p=new Point3D(3,3);
		Point3D p2=new Point3D(4,4);
		src=new node(3,p);
		dest=new node(4,p2);
		edge=new EdgeData(src,dest,3,0);
		int x=3;
		assertEquals(edge.getSrc(),x);
		
	}

	@Test
	void testGetDest() {
		Point3D p=new Point3D(3,3);
		Point3D p2=new Point3D(4,4);
		src=new node(3,p);
		dest=new node(4,p2);
		edge=new EdgeData(src,dest,3,0);
		int x=4;
		assertEquals(edge.getDest(),x);
	}

	@Test
	void testGetWeight() {
		Point3D p=new Point3D(3,3);
		Point3D p2=new Point3D(4,4);
		src=new node(3,p);
		dest=new node(4,p2);
		edge=new EdgeData(src,dest,3,0);
		double w=3.0;
		assertEquals(edge.getWeight(),w);
	}

	@Test
	void testGetInfo() {
		String s="new Edge has been created";
		edge.setInfo(s);
		assertEquals(edge.getInfo(),s);
	}



	@Test
	void testGetTag() {
		int x=2;
		edge.setTag(x);
		assertEquals(x, edge.getTag());
	}

   @Test
   void TesttoString() {
		Point3D p=new Point3D(3,3);
		Point3D p2=new Point3D(4,4);
		src=new node(3,p);
		dest=new node(4,p2);
		edge=new EdgeData(src,dest,3,0);
		assertEquals("([Key: 3, Location: (3.0,3.0,0.0)],[Key: 4, Location: (4.0,4.0,0.0)])",edge.toString());
   }

}
