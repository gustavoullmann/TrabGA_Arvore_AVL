
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

            updateHeigh(root);
            updateBalanceFactor(root);
        
        }
        return node;
    }

    public Nodo removeNode (Integer data) {

        Nodo node = searchNode(data);
        Boolean isRootNode = (root == node);                                //TODO: caso o nó removido seja ROOT é preciso fazer tree.setRoot()

        if(node.getData() == null) {
            System.out.println("\n" + "ATENÇÃO: o valor '" + data + "' não existe na árvore!");
        }
        else {
            Nodo parent = node.getParent();
            Integer rightSonData = node.getRightSon().getData();
            Integer leftSonData = node.getLeftSon().getData();

            if(rightSonData == null && leftSonData == null) {               //nó folha
                node.setData(null);
                node.setRightSon(null);
                node.setLeftSon(null);
                node.setBalanceFactor(-1);
                node.setNodeHeight(0);

                updateHeigh(root);
                updateBalanceFactor(root);
            }
            else if(rightSonData == null && leftSonData != null) {          //filhos a esquerda               
                
            }
            else if(rightSonData != null && leftSonData == null) {          //filhos a direita
                
            }
            else {                                                          //filhos a esquerda e direita
                
            }
        }
        System.out.println("\n" + printHeader());
        printTree(root, 0);
        
        System.out.println("\n\t" + "\033[32m" + "ATENÇÃO: o nó '" + data + "' foi removido da árvore!" + "\033[0m");

        Menu.menu();
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

    public void updateHeigh(Nodo rootNode) {                        //TODO:testar no caso de exclusão!!!

        if(rootNode.getData() == null) {
            rootNode.setNodeHeight(-1);
        }
        else {
            updateHeigh(rootNode.getLeftSon());
            updateHeigh(rootNode.getRightSon());

            Nodo.calculateNodeHeight(rootNode);
        }
    }

    public void updateBalanceFactor(Nodo rootNode) {                //TODO:testar no caso de exclusão!!!
       
        if(rootNode.getData() == null) {
            rootNode.setBalanceFactor(0);
        }
        else {
            updateBalanceFactor(rootNode.getLeftSon());
            updateBalanceFactor(rootNode.getRightSon());

            Nodo.calculateBalanceFactor(rootNode);
        }
    }

    public Nodo checkTreeUnbalance_FROM_TOP(Nodo rootNode) {        //TODO:talvez esse método seja desnecessário

        checkTreeUnbalance_FROM_TOP(rootNode.getLeftSon());
        checkTreeUnbalance_FROM_TOP(rootNode.getRightSon());

        Nodo unbalancedNode = null;
        int balanceFactor = rootNode.getBalanceFactor();

        if(balanceFactor < -1 || balanceFactor > 1) {
            unbalancedNode = rootNode;
        }
        return unbalancedNode;
    }

    public Nodo checkTreeUnbalanceFromLeaf(Nodo leaf) {

        Nodo unbalancedNode = null;

        Nodo currentNode = leaf;
        Nodo parent = currentNode.getParent();
        int balanceFactor = currentNode.getBalanceFactor();

        if(balanceFactor < -1 || balanceFactor > 1) {
            unbalancedNode = currentNode;
            rebalanceNode(unbalancedNode);
        }
        else if(parent == null) {
            return unbalancedNode;
        } 
        else {
            checkTreeUnbalanceFromLeaf(parent);
        }
        return unbalancedNode;
    }

    public void rebalanceNode(Nodo unbalancedNode) {

        int bf = unbalancedNode.getBalanceFactor();
        int leftSonBf = unbalancedNode.getLeftSon().getBalanceFactor();
        int rightSonBf = unbalancedNode.getRightSon().getBalanceFactor();

        if((bf == -2 && rightSonBf == -1) || (bf == -2 && rightSonBf == 0)) {
            leftRotation(unbalancedNode);
        }   
        else if((bf == 2 && leftSonBf == 0) || (bf == 2 && leftSonBf == 1)) {    
            rightRotation(unbalancedNode);
        }
        else if(bf == -2 && rightSonBf == 1) {                       
            rightLeftRotation(unbalancedNode);
        }
        else if(bf == 2 && leftSonBf == -1) {                                                      
            leftRightRotation(unbalancedNode);
        }
        else {
            return;
        }
    }

    public void rightRotation(Nodo unbalancedNode) {

        Nodo unbalancedNodeParent = unbalancedNode.getParent();
        Nodo unbalancedNodeLeftSon = unbalancedNode.getLeftSon();
        Nodo unbalancedNodeLeftSonsRightSon = unbalancedNodeLeftSon.getRightSon();

        unbalancedNode.setLeftSon(unbalancedNodeLeftSonsRightSon);
        unbalancedNodeLeftSonsRightSon.setParent(unbalancedNode);

        unbalancedNodeLeftSon.setRightSon(unbalancedNode);
        unbalancedNode.setParent(unbalancedNodeLeftSon);

        if(unbalancedNodeParent == null) {                              //TODO: revisar se faltou fazer o setLeftSon
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

        if(unbalancedNodeParent == null) {                                  //TODO: revisar se faltou fazer o setLeftSon
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

        updateHeigh(root);                                                      //talvez seja desnecassário 
        updateBalanceFactor(root);                                              //talvez seja desnecassário 
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

        updateHeigh(root);                                                      //talvez seja desnecassário 
        updateBalanceFactor(root);                                              //talvez seja desnecassário 
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

    public void printSearchNodePath (Integer data) {

        Nodo currentNode = root; 
        Integer currentNodeData = currentNode.getData();
        String nodePath = "\n" + "Relação de nós visitados: ";

        while(currentNodeData != data && currentNodeData != null) {

            if(data < currentNodeData) {
                nodePath += currentNodeData + " ";
                currentNode = currentNode.getLeftSon();
                currentNodeData = currentNode.getData();
            }
            else {
                nodePath += currentNodeData + " ";
                currentNode = currentNode.getRightSon();
                currentNodeData = currentNode.getData();
            }
        }
        System.out.println(nodePath);
    }

    public void preOrderTraversal(Nodo node) {
        
        if(node.getData() != null) {
            System.out.print(node.getData() + "\t");

            preOrderTraversal(node.getLeftSon());
            preOrderTraversal(node.getRightSon());
        }
    }

    public void inOrderTraversal(Nodo node) {

        if(node.getData() != null) {
            inOrderTraversal(node.getLeftSon());

            System.out.print(node.getData() + "\t");

            inOrderTraversal(node.getRightSon());
        }
    }

    public void postOrderTraversal(Nodo node) {

        if(node.getData() != null) {
            postOrderTraversal(node.getLeftSon());
            postOrderTraversal(node.getRightSon());

            System.out.print(node.getData() + "\t");
        }
    }

/*
REMOÇÃO (fazer exclusão por cópia)                          //TODO:fazer exclusão por cópia 

Caso parecido com as inclusões;
- No entanto, nem sempre se consegue solucionar com uma única rotação;
- Remover elemento e retornar do pai do nó removido até a raiz (recursivamente), 
verificando se cada nó do caminho precisa ser balanceado.
*/  
}
