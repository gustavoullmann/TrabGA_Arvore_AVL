
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
        this.nodeHeight = 0;
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
