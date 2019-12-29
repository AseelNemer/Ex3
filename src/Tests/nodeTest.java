package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dataStructure.node;
import utils.Point3D;

class nodeTest {
	node node=null;
 @BeforeEach
 void init() {
	node=new node();
 }
 


	@Test
	void testGetKey() {
		Point3D p=new Point3D(3,3);
		node =new node(2,p);
		assertEquals(node.getKey(),2);
	}

	@Test
	void testGetLocation() {
		Point3D p=new Point3D(3,3);
		node =new node(2,p);
		assertEquals(node.getLocation(),p);
	}

	@Test
	void testSetLocation() {
		Point3D p=new Point3D(3,3);
		node.setLocation(p);
		assertEquals(node.getLocation(),p);
	}

	@Test
	void testGetWeight() {
		Point3D p=new Point3D(3,3);
		node=new node(2,p,4.05,0);
		assertEquals(node.getWeight(),4.05);
	}

	@Test
	void testSetWeight() {
		node.setWeight(5);
		assertEquals(node.getWeight(),5);
	}

	@Test
	void testGetInfo() {
		String s="new node has been created";
		node.setInfo(s);
		assertEquals(node.getInfo(),s);
	}

	@Test
	void testSetInfo() {
		String s="new node has been created";
		node.setInfo(s);
		assertEquals(node.getInfo(),s);
		}

	@Test
	void testGetTag() {
		int tag =0;
		node.setTag(tag);
		assertEquals(node.getTag(),tag);
	}



	@Test
	void testToString() {
		Point3D p=new Point3D(2,3);
		node=new node(3,p);
		assertEquals(node.toString(),"[Key: 3, Location: (2.0,3.0,0.0)]");
	}

}
