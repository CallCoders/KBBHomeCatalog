package ua.com.kbb;

import java.awt.Dimension;

public class LeafAluProduct {

	int width = 0;
	int height = 0;
	String color = "";
	
	public LeafAluProduct(){}
	public LeafAluProduct(int width, int height)
	{
		this.width = width;
		this.height = height;
		this.color = "Нет информации";
	}
	public LeafAluProduct(int width, int height, String color)
	{
		this.width = width;
		this.height = height;
		this.color = "RAL"+color;
	}
	
	public Dimension getLeafWH(int widthDoorWay, int heightDoorWay){
		int leafW = widthDoorWay/2+16;
		int leafH = heightDoorWay-3;
		Dimension leafWH = new Dimension(leafW, leafH);
		return leafWH;
	}
}
