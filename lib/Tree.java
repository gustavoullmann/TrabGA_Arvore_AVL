
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

            updateHeighFrom_TOP(root);
            updateBalanceFactorFrom_TOP(root);
        
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

    public void updateHeighFrom_TOP(Nodo rootNode) {                        //testar no caso de exclusão!!!

        if(rootNode.getData() == null) {
            rootNode.setNodeHeight(-1);
        }
        else {
            updateHeighFrom_TOP(rootNode.getLeftSon());
            updateHeighFrom_TOP(rootNode.getRightSon());

            Nodo.calculateNodeHeight(rootNode);
        }
    }

    public void updateBalanceFactorFrom_TOP(Nodo rootNode) {                //testar no caso de exclusão!!!
       
        if(rootNode.getData() == null) {
            rootNode.setBalanceFactor(0);
        }
        else {
            updateBalanceFactorFrom_TOP(rootNode.getLeftSon());
            updateBalanceFactorFrom_TOP(rootNode.getRightSon());

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

    public void rightRotation(Nodo unbalancedNode_TRES) {

        Nodo unbalancedNodeParent_PARENT = unbalancedNode_TRES.getParent();
        Nodo unbalancedNodeLeftSon_DOIS = unbalancedNode_TRES.getLeftSon();
        Nodo unbalancedNodeLeftSonsRightSon_LARANJA = unbalancedNodeLeftSon_DOIS.getRightSon();

        unbalancedNode_TRES.setLeftSon(unbalancedNodeLeftSonsRightSon_LARANJA);
        unbalancedNodeLeftSonsRightSon_LARANJA.setParent(unbalancedNode_TRES);
        //Nodo.calculateBalanceFactor(unbalancedNodeLeftSonsRightSon_LARANJA);
        //Nodo.calculateNodeHeight(unbalancedNodeLeftSonsRightSon_LARANJA);

        unbalancedNodeLeftSon_DOIS.setRightSon(unbalancedNode_TRES);
        unbalancedNode_TRES.setParent(unbalancedNodeLeftSon_DOIS);
        //Nodo.calculateBalanceFactor(unbalancedNode_TRES);
        //Nodo.calculateNodeHeight(unbalancedNode_TRES);

        if(unbalancedNodeParent_PARENT == null) {
            unbalancedNodeLeftSon_DOIS.setParent(unbalancedNodeParent_PARENT);
            //Nodo.calculateBalanceFactor(unbalancedNodeLeftSon_DOIS);
            //Nodo.calculateNodeHeight(unbalancedNodeLeftSon_DOIS);
            root = unbalancedNodeLeftSon_DOIS;
        }
        else {
            unbalancedNodeLeftSon_DOIS.setParent(unbalancedNodeParent_PARENT);
            unbalancedNodeParent_PARENT.setLeftSon(unbalancedNodeLeftSon_DOIS);
            //Nodo.calculateBalanceFactor(unbalancedNodeLeftSon_DOIS);
            //Nodo.calculateNodeHeight(unbalancedNodeLeftSon_DOIS);
            //Nodo.calculateBalanceFactor(unbalancedNodeParent_PARENT);
            //Nodo.calculateNodeHeight(unbalancedNodeParent_PARENT);
        }
        updateHeighFrom_TOP(root);
        updateBalanceFactorFrom_TOP(root);

    }

    public void leftRotation(Nodo unbalancedNode_UM) {

        Nodo unbalancedNodeParent_PARENT = unbalancedNode_UM.getParent();
        Nodo unbalancedNodeRightSon_DOIS = unbalancedNode_UM.getRightSon();
        Nodo unbalancedNodeRightSonsLeftSon_VERDE = unbalancedNodeRightSon_DOIS.getLeftSon();

        unbalancedNode_UM.setRightSon(unbalancedNodeRightSonsLeftSon_VERDE);
        unbalancedNodeRightSonsLeftSon_VERDE.printNodeAttributes();
        unbalancedNodeRightSonsLeftSon_VERDE.setParent(unbalancedNode_UM);
        //Nodo.calculateBalanceFactor(unbalancedNodeRightSonsLeftSon_VERDE);
        //Nodo.calculateNodeHeight(unbalancedNodeRightSonsLeftSon_VERDE);

        unbalancedNodeRightSon_DOIS.setLeftSon(unbalancedNode_UM);
        unbalancedNode_UM.setParent(unbalancedNodeRightSon_DOIS);
        //Nodo.calculateBalanceFactor(unbalancedNode_UM);
        //Nodo.calculateNodeHeight(unbalancedNode_UM);

        if(unbalancedNodeParent_PARENT == null) {
            unbalancedNodeRightSon_DOIS.setParent(unbalancedNodeParent_PARENT);
            //Nodo.calculateBalanceFactor(unbalancedNodeRightSon_DOIS);
            //Nodo.calculateNodeHeight(unbalancedNodeRightSon_DOIS);
            root = unbalancedNodeRightSon_DOIS;
        }
        else {
            unbalancedNodeRightSon_DOIS.setParent(unbalancedNodeParent_PARENT);
            unbalancedNodeParent_PARENT.setRightSon(unbalancedNodeRightSon_DOIS);
            //Nodo.calculateBalanceFactor(unbalancedNodeRightSon_DOIS);
            //Nodo.calculateNodeHeight(unbalancedNodeRightSon_DOIS);
            //Nodo.calculateBalanceFactor(unbalancedNodeParent_PARENT);
            //Nodo.calculateNodeHeight(unbalancedNodeParent_PARENT);
        }
        updateHeighFrom_TOP(root);
        updateBalanceFactorFrom_TOP(root);
    }

    public void leftRightRotation(Nodo unbalancedNode_TRES) {

        Nodo unbalancedNodeLeftSon_UM = unbalancedNode_TRES.getLeftSon();
        Nodo unbalancedNodeLeftSonsRightSon_DOIS = unbalancedNodeLeftSon_UM.getRightSon();
        Nodo unbalancedNodeLeftSonsRightSonsLeftSon_VERDE = unbalancedNodeLeftSonsRightSon_DOIS.getLeftSon();

        unbalancedNodeLeftSon_UM.setRightSon(unbalancedNodeLeftSonsRightSonsLeftSon_VERDE);
        unbalancedNodeLeftSonsRightSonsLeftSon_VERDE.setParent(unbalancedNodeLeftSon_UM);
        
        unbalancedNodeLeftSonsRightSon_DOIS.setLeftSon(unbalancedNodeLeftSon_UM);
        unbalancedNodeLeftSon_UM.setParent(unbalancedNodeLeftSonsRightSon_DOIS);

        unbalancedNode_TRES.setLeftSon(unbalancedNodeLeftSonsRightSon_DOIS);
        unbalancedNodeLeftSonsRightSon_DOIS.setParent(unbalancedNode_TRES);

        rightRotation(unbalancedNode_TRES);

        updateHeighFrom_TOP(root);
        updateBalanceFactorFrom_TOP(root);
    }

    public void rightLeftRotation(Nodo unbalancedNode_TRES) {

        Nodo unbalancedNodeRightSon_CINCO = unbalancedNode_TRES.getRightSon();
        Nodo unbalancedNodeRightSonsLeftSon_QUATRO = unbalancedNodeRightSon_CINCO.getLeftSon();
        Nodo unbalancedNodeRightSonsLeftSonsRightSon_AZUL = unbalancedNodeRightSonsLeftSon_QUATRO.getRightSon();

        unbalancedNodeRightSon_CINCO.setLeftSon(unbalancedNodeRightSonsLeftSonsRightSon_AZUL);
        unbalancedNodeRightSonsLeftSonsRightSon_AZUL.setParent(unbalancedNodeRightSon_CINCO);

        unbalancedNodeRightSonsLeftSon_QUATRO.setRightSon(unbalancedNodeRightSon_CINCO);
        unbalancedNodeRightSon_CINCO.setParent(unbalancedNodeRightSonsLeftSon_QUATRO);

        unbalancedNode_TRES.setRightSon(unbalancedNodeRightSonsLeftSon_QUATRO);
        unbalancedNodeRightSonsLeftSon_QUATRO.setParent(unbalancedNode_TRES);

        leftRotation(unbalancedNode_TRES);

        updateHeighFrom_TOP(root);
        updateBalanceFactorFrom_TOP(root);
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
