
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

        Nodo node = findEmptyNode(data);

        node.setData(data);

        Nodo leftSonNode = new Nodo();
        Nodo rightSonNode = new Nodo();

        node.setLeftSon(leftSonNode);
        node.setRightSon(rightSonNode);

        leftSonNode.setParent(node);
        rightSonNode.setParent(node);

        Nodo.calculateBalanceFactor(node);
        Nodo.calculateNodeHeight(node);

        return node;
                                                            //TODO: criar método (e chamá-lo aqui dentro) recorrente para atualizar altura e fator de balanceamento até a raiz
    }

    public Nodo findEmptyNode(Integer data) {

        Nodo currentNode = root;
        
        Integer currentNodeData = currentNode.getData();

        while(currentNodeData != null) {

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

    //método insere
    //método remove
    //método rotação simples à direita
    //método rotação simples à esquerda
    //método rotação dupla à direita
    //método rotação dupla à esquerda
    //método cálculo fator de balanceamento
    //método cálculo altura do nó

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
