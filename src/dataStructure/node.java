package dataStructure;

import utils.Point3D;

public class node implements node_data{
 private int key=0;
 private Point3D location;
 private double weight;
 private String info;
 private int tag;
 
 public node()
 {
	 this.key++;
	 setLocation(new Point3D((double)this.getKey(),(double)this.getKey()));
	 this.weight=(Double.MAX_VALUE);
	 this.info=null;
	 this.tag=0;
 }
 public node(node_data n)
 {
	 this.key=n.getKey();
     setWeight(n.getWeight());
     setTag(n.getTag());
     setInfo(n.getInfo());
     
 }
 public node(int key,Point3D location) {
		this.key = key;
		if(location != null)
			this.location = new Point3D(location);
		else
			this.location = null;
		this.weight = 0;
		this.info= "";
		this.tag = 0;
	}
 
 
 public node(int key,Point3D location,double weight,int tag) {
		this.key = key;
		if(location != null)
			this.location = new Point3D(location);
		else
			this.location = null;
	this.weight = weight;
	this.tag = tag;
	this.info = "";
}
	@Override
	public int getKey() {
		// TODO Auto-generated method stub
		return this.key;
	}

	@Override
	public Point3D getLocation() {
		// TODO Auto-generated method stub
		return this.location;
	}

	@Override
	public void setLocation(Point3D p) {
		// TODO Auto-generated method stub
		this.location=p;
	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return this.weight;
	}

	@Override
	public void setWeight(double w) {
		// TODO Auto-generated method stub
		this.weight=w;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return this.info;
	}

	@Override
	public void setInfo(String s) {
		// TODO Auto-generated method stub
		if (s==null)
			return;
		this.info=new String(s);
	}

	@Override
	public int getTag() {
		// TODO Auto-generated method stub
		return this.tag;
	}

	@Override
	public void setTag(int t) {
		// TODO Auto-generated method stub
		this.tag=t;
	}

}