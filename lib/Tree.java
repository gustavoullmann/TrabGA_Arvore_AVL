
public class Tree {

    private Nodo root;

    public Tree(Nodo nodo) {
        this.root = nodo;
    }

    public Nodo getRoot() {
        return root;
    }

    public void setRoot(Nodo nodo) {
        root = nodo;
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
