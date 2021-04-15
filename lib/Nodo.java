
public class Nodo {

    private int data;
    private Nodo parent;
    private Nodo rightSon;
    private Nodo leftSon;
    private int nodeHeight;
    private int balanceFactor;

    public Nodo (int data) {
        this.data = data;
        this.parent = null;
        this.rightSon = null;
        this.leftSon = null;
        this.nodeHeight = -1;			//nodeHeight = -1 ao criar nó vazio, facilita a implementação do cálculo da altura do nó pai
        this.balanceFactor = 0;
    }

    public Nodo() {            //construtor vazio para montar uma árvore vazia; 
    }

    public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Nodo getParent() {
		return parent;
	}

	public void setParent(Nodo parent) {
		this.parent = parent;
	}

	public Nodo getRightSon() {
		return rightSon;
	}

	public void setRightSon(Nodo rightSon) {
		this.rightSon = rightSon;
	}

	public Nodo getLeftSon() {
		return leftSon;
	}

	public void setLeftSon(Nodo leftSon) {
		this.leftSon = leftSon;
	}

	public int getHight() {
		return nodeHeight;
	}

	public void setHight(int hight) {
		this.nodeHeight = hight;
	}

	public int getBalanceFactor() {
		return balanceFactor;
	}

	public void setBalanceFactor(int balanceFactor) {
		this.balanceFactor = balanceFactor;
	}

	public int calculateBalanceFactor(Nodo node) {

		int heightLeftSon = node.getLeftSon().getHight();
		int heightRightSon = node.getRightSon().getHight();

		int balanceFactor = heightLeftSon - heightRightSon;

		return balanceFactor;
	}

	public int calculateNodeHeight(Nodo node) {

		int heightLeftSon = node.getLeftSon().getHight();
		int heightRightSon = node.getRightSon().getHight();

		int maxSonHeight = Math.max(heightLeftSon, heightRightSon);

		int nodeHeight = maxSonHeight + 1;
		return nodeHeight;
	}
	
	//public static void simpleRightRotation {}

		//Toda vez que uma sub-árvore fica com um fator:
		//positivo e sua sub-árvore da esquerda também tem um fator positivo
	
	//public static void simpleLeftRotation {}

		//Toda vez que uma sub-árvore fica com um fator:
		//negativo e sua sub-árvore da direita também tem um fator negativo

	//public static void doubleRightRotation {}

		//Toda vez que uma sub-árvore fica com um fator:
		//positivo e sua sub-árvore da esquerda tem um fator negativo


	//public static void doubleLeftRotation {}

		//Toda vez que uma sub-árvore fica com um fator:
		//negativo e sua sub-árvore da direita tem um fator positivo




    @Override
    public String toString() {
        return  "Nodo data: " + data +"\n" +
                "Pai: " + parent + "\n" +
                "Filho à direita: " + rightSon + "\n" + 
                "Filho à esquerda: " + leftSon + "\n" +
                "Altura do nodo: " + nodeHeight + "\n" +
                "Fator de balanceamento: " + balanceFactor + "\n";

    
    }    
}
