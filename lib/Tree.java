
public class Tree {

    private Nodo root;

    public Tree() {
        this.root = new Nodo();                             //TODO: revisar se é uma boa prática chamar um construtor dentro de outro
    }

    public Nodo getRoot() {
        return root;
    }

    public void setRoot(Nodo node) {
        root = node;
    }

    public Nodo insertNode(Integer data) {                  

        Nodo node = searchNode(data);

        if(node.getData() == data) {
            System.out.println("\n" + "ATENÇÃO: o valor '" + data + "' já está existe na árvore!");
        }
        else {
            node.setData(data);

            Nodo leftSonNode = new Nodo();
            Nodo rightSonNode = new Nodo();
    
            node.setLeftSon(leftSonNode);
            node.setRightSon(rightSonNode);
    
            leftSonNode.setParent(node);
            rightSonNode.setParent(node);
    
            Nodo.calculateBalanceFactor(node);
            Nodo.calculateNodeHeight(node);
    
            //updateHeigh(node);
            //updateBalanceFactor(node);

            updateHeigh(root);
            updateBalanceFactor(root);
        
        }
        return node;
    }

    public Nodo searchNode(Integer data) {

        Nodo currentNode = root; 
        Integer currentNodeData = currentNode.getData();

        while(currentNodeData != data && currentNodeData != null) {

            if(data < currentNodeData) {
                currentNode = currentNode.getLeftSon();
                currentNodeData = currentNode.getData();
            }
            else {
                currentNode = currentNode.getRightSon();
                currentNodeData = currentNode.getData();
            }
        }
        return currentNode;        
    }

    public void updateHeigh(Nodo rootNode) {                        //testar no caso de exclusão!!!

        if(rootNode.getData() == null) {
            rootNode.setNodeHeight(-1);
        }
        else {
            updateHeigh(rootNode.getLeftSon());
            updateHeigh(rootNode.getRightSon());

            Nodo.calculateNodeHeight(rootNode);
        }
    }

    public void updateBalanceFactor(Nodo rootNode) {                //testar no caso de exclusão!!!
       
        if(rootNode.getData() == null) {
            rootNode.setBalanceFactor(0);
        }
        else {
            updateBalanceFactor(rootNode.getLeftSon());
            updateBalanceFactor(rootNode.getRightSon());

            Nodo.calculateBalanceFactor(rootNode);
        }
    }

    public void printTree(Nodo rootNode, int level) {

        int tabulationRepetition = level;
        String tabulation = "\t".repeat(tabulationRepetition);

        if(rootNode.getLeftSon() == null || rootNode.getRightSon() == null) {
            System.out.println(tabulation + "*");
        } 
        else {
            String nodeData = String.valueOf(rootNode.getData());
            String nodeStatistics = "[" + rootNode.balanceFactorLabel(rootNode) + "]"; 

            System.out.println(tabulation + nodeData + nodeStatistics);
            tabulationRepetition++;

            printTree(rootNode.getRightSon(), tabulationRepetition);
            printTree(rootNode.getLeftSon(), tabulationRepetition);
        }        
    }

    public String printHeader() {

        String header = "\033[1;34m" + "Root" + "\033[0m";
        int totalLevels = root.getNodeHeight() + 1;
        for(int i = 2; i <= totalLevels ; i++) {
            String currentLevel = "\t" + "\033[0;34m" + "level-" + i + "\033[0m";
            header += currentLevel;
        }
        return header;
    }

    public void rightRotation(Nodo unbalancedNode) {

        Nodo unbalancedNodeParent = unbalancedNode.getParent();
        Nodo unbalancedNodeLeftSon = unbalancedNode.getLeftSon();
        Nodo unbalancedNodeLeftSonsRightSon = unbalancedNodeLeftSon.getRightSon();

        unbalancedNode.setLeftSon(unbalancedNodeLeftSonsRightSon);
        unbalancedNodeLeftSonsRightSon.setParent(unbalancedNode);

        unbalancedNodeLeftSon.setRightSon(unbalancedNode);
        unbalancedNode.setParent(unbalancedNodeLeftSon);

        if(unbalancedNodeParent == null) {
            unbalancedNodeLeftSon.setParent(unbalancedNodeParent);
            root = unbalancedNodeLeftSon;
        }
        else {
            unbalancedNodeLeftSon.setParent(unbalancedNodeParent);
            unbalancedNodeParent.setLeftSon(unbalancedNodeLeftSon);
        }
        updateHeigh(root);
        updateBalanceFactor(root);

    }

    public void leftRotation(Nodo unbalancedNode) {

        Nodo unbalancedNodeParent = unbalancedNode.getParent();
        Nodo unbalancedNodeRightSon = unbalancedNode.getRightSon();
        Nodo unbalancedNodeRightSonsLeftSon = unbalancedNodeRightSon.getLeftSon();

        unbalancedNode.setRightSon(unbalancedNodeRightSonsLeftSon);
        unbalancedNodeRightSonsLeftSon.printNodeAttributes();
        unbalancedNodeRightSonsLeftSon.setParent(unbalancedNode);

        unbalancedNodeRightSon.setLeftSon(unbalancedNode);
        unbalancedNode.setParent(unbalancedNodeRightSon);

        if(unbalancedNodeParent == null) {
            unbalancedNodeRightSon.setParent(unbalancedNodeParent);
            root = unbalancedNodeRightSon;
        }
        else {
            unbalancedNodeRightSon.setParent(unbalancedNodeParent);
            unbalancedNodeParent.setRightSon(unbalancedNodeRightSon);
        }
        updateHeigh(root);
        updateBalanceFactor(root);
    }

    public void leftRightRotation(Nodo unbalancedNode) {

        Nodo unbalancedNodeLeftSon = unbalancedNode.getLeftSon();
        Nodo unbalancedNodeLeftSonsRightSon = unbalancedNodeLeftSon.getRightSon();
        Nodo unbalancedNodeLeftSonsRightSonsLeftSon = unbalancedNodeLeftSonsRightSon.getLeftSon();

        unbalancedNodeLeftSon.setRightSon(unbalancedNodeLeftSonsRightSonsLeftSon);
        unbalancedNodeLeftSonsRightSonsLeftSon.setParent(unbalancedNodeLeftSon);
        
        unbalancedNodeLeftSonsRightSon.setLeftSon(unbalancedNodeLeftSon);
        unbalancedNodeLeftSon.setParent(unbalancedNodeLeftSonsRightSon);

        unbalancedNode.setLeftSon(unbalancedNodeLeftSonsRightSon);
        unbalancedNodeLeftSonsRightSon.setParent(unbalancedNode);

        rightRotation(unbalancedNode);

        updateHeigh(root);
        updateBalanceFactor(root);
    }

    public void rightLeftRotation(Nodo unbalancedNode) {

        Nodo unbalancedNodeRightSon = unbalancedNode.getRightSon();
        Nodo unbalancedNodeRightSonsLeftSon = unbalancedNodeRightSon.getLeftSon();
        Nodo unbalancedNodeRightSonsLeftSonsRightSon = unbalancedNodeRightSonsLeftSon.getRightSon();

        unbalancedNodeRightSon.setLeftSon(unbalancedNodeRightSonsLeftSonsRightSon);
        unbalancedNodeRightSonsLeftSonsRightSon.setParent(unbalancedNodeRightSon);

        unbalancedNodeRightSonsLeftSon.setRightSon(unbalancedNodeRightSon);
        unbalancedNodeRightSon.setParent(unbalancedNodeRightSonsLeftSon);

        unbalancedNode.setRightSon(unbalancedNodeRightSonsLeftSon);
        unbalancedNodeRightSonsLeftSon.setParent(unbalancedNode);

        leftRotation(unbalancedNode);

        updateHeigh(root);
        updateBalanceFactor(root);
    }

    //método remove
	
	//public static void rightRotation {}

		//Toda vez que uma sub-árvore fica com um fator:
		//positivo e sua sub-árvore da esquerda também tem um fator positivo
	
	//public static void leftRotation {}

		//Toda vez que uma sub-árvore fica com um fator:
		//negativo e sua sub-árvore da direita também tem um fator negativo

	//public static void LeftRightRotation {}

		//Toda vez que uma sub-árvore fica com um fator:
		//positivo e sua sub-árvore da esquerda tem um fator negativo

	//public static void RightLeftRotation {}

		//Toda vez que uma sub-árvore fica com um fator:
		//negativo e sua sub-árvore da direita tem um fator positivo

/*
INSERÇÃO

Percorre-se a árvore verificando se a chave já existe ou não
- Em caso positivo, encerra a tentativa de inserção
- Caso contrário, a busca encontra o local correto de inserção do novo nó

Verifica-se se a inclusão tornará a árvore desbalanceada
- Em caso negativo, o processo termina
- Caso contrário, deve-se efetuar o balanceamento da árvore
- Descobre-se qual a operação de rotação a ser executada
- Executa-se a rotação

REMOÇÃO

Caso parecido com as inclusões;
- No entanto, nem sempre se consegue solucionar com uma única rotação;
- Remover elemento e retornar do pai do nó removido até a raiz (recursivamente), 
verificando se cada nó do caminho precisa ser balanceado.
*/  
}
