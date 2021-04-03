
public class Nodo {

    int data;
    Nodo parent;
    Nodo rightSon;
    Nodo leftSon;
    int balanceFactor;

    public Nodo (int data) {
        this.data = data;
        this.parent = null;
        this.rightSon = null;
        this.leftSon = null;
        this.balanceFactor = 0;

    }

    public Nodo() {            //construtor vazio para montar uma árvore vazia; 

    }

    @Override
    public String toString() {
        return  "Nodo data: " + data +"\n" +
                "Pai: " + parent + "\n" +
                "Filho à direita: " + rightSon + "\n" + 
                "Filho à esquerda: " + leftSon + "\n";
    
    }

    //nodo nodoPai
    //nodo nodoFilhoDireita
    //nodo nodoFilhoEsquerda
    //int fatorBalanceamento
    
}
