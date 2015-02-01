/*
 * 
 * Countries of the World App 1.0
 * DemoMain
 * Waleed Gudah
 * 
 */

public class bstNode {

	private String key;
	private String name;
	private String continent;
	private int area;
	private int pop;
	private float lifeExpectancy;
	private int Lpointer;
	private int rPointer;

	bstNode(String key, String name, String continent, int area,
			int pop, float lifeExpectancy) {

		this.key = key;
		this.continent = continent;
		this.name = name;
		this.area = area;
		this.pop = pop;
		this.lifeExpectancy = lifeExpectancy;
		Lpointer = -1;
		rPointer = -1;

	}
	public String getName() {
		return name;
	}
	public String getKey() {
		return key;
	}
	public String getContinent() {
		return continent;
	}
	public int getArea() {
		if (area == 0.0) {
			return -1;
		}
		return area;
	}
	public int getPopulation() {
		if (pop == 0.0) {
			return -1;
		}
		return pop;
	}
	public float getLifeExpectancy() {
		if (lifeExpectancy == 0.0) {
			return -1;
		}
		return lifeExpectancy;
	}
	public int getLeft() {
		return Lpointer;
	}
	public int getRight() {
		return rPointer;
	}

	public void setLeft(int Lpointer) {
		this.Lpointer = Lpointer;
	}


	public void setRight(int rPointer) {
		this.rPointer = rPointer;
	}

	public void makeTomb() {

		// blank out this node, Tombstone style
		name = "";
		key = "XXX";
		continent = "";
		area = 0;
		pop = 0;
		lifeExpectancy = 0;

	}


}
