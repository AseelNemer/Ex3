package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JFrame;
import dataStructure.DGraph;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node;
import dataStructure.node_data;
import utils.Point3D;

public class Graph_GUI extends JFrame implements ActionListener, MouseListener {
	graph K=new DGraph();
	
	LinkedList<node_data> point=new LinkedList<node_data>(K.getV());
	LinkedList<edge_data> edg=new LinkedList<edge_data>();
	
	public Graph_GUI() {
		initGUI();
	}
	
	public Graph_GUI(graph D){
		this.K=D;
		//this.K=D;
		//point=new LinkedList<node_data>(K.getV());
		initGUI();
	}
	
private void initGUI() {
	this.setSize(500,500);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	MenuBar menuBar = new MenuBar();
	
	Menu menu = new Menu("Menu");
	menuBar.add(menu);
	this.setMenuBar(menuBar);
	
	MenuItem item1 = new MenuItem("Item 1");
	item1.addActionListener(this);
	menu.add(item1);
	
	this.addMouseListener(this);
}

@Override
public void paint(Graphics g )
{
	super.paint(g);
	
	//Collection<node_data> node=K.getV();
	Iterator<node_data> nodes=this.K.getV().iterator();

		while(nodes.hasNext()) {
        node_data n=nodes.next();
		g.setColor(Color.BLUE);
		g.fillOval((int)n.getLocation().x(), (int)n.getLocation().y(), 10, 10);
			//Collection<edge_data> edg=K.getE(n.getKey());	
		Iterator<edge_data> itr=this.K.getE(n.getKey()).iterator();
		while(itr.hasNext()) {
			edge_data s=itr.next();
			
			Point3D p=n.getLocation();
			Point3D p2=K.getNode(s.getDest()).getLocation();
			
			g.setColor(Color.BLUE);
			g.fillOval(p2.ix(), p2.iy(), 10, 10);
		
			g.setColor(Color.RED);
			g.drawLine(p.ix(), p.iy(), p2.ix(), p2.iy());
			
			g.drawString(Double.toString(s.getWeight()), (int)((p.x()+(int)p2.x())/2),	(int)((p.y()+(int)p2.y())/2));
		
		
		}
		}
	
}
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	System.out.println("mouseClicked");
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	System.out.println("mouseEntered");	
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	System.out.println("mouseExited");
}
@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	/*
	int x = e.getX();
	int y = e.getY();
	Point3D p = new Point3D(x,y);
	node_data s=new node();
	s.setLocation(p);
	point.add(s);
	
	repaint();
	*/
	System.out.println("mousePressed");
}
@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	System.out.println("mouseReleased");
}
//@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	/**String str = e.getActionCommand();
	
	if(str.equals("Item 1"))
	{

		Point3D p1 = new Point3D(100,100);
		Point3D p2 = new Point3D(50,300);
		Point3D p3 = new Point3D(400,150);
		node_data s=new node(10,p1);
		node_data s2=new node(11,p2);
		node_data s3=new node(12,p3);
		point.add(s);
		point.add(s2);
		point.add(s3);
		
		repaint();
	}*/
}
private static graph nodesFactory() {
	/*graph d=new DGraph();
	d.addNode(new node(new Point3D(500, 500)));
	 return d;*/
	 return null;
}
}
