
public class Main {

    static Tree AVL_TREE = new Tree();                              //Cria uma nova Tree em cada execução do código
    public static void main(String[] args) {

        AVL_TREE.insertNode(12);
        AVL_TREE.insertNode(6);
        AVL_TREE.insertNode(18);
        AVL_TREE.insertNode(2);
        AVL_TREE.insertNode(9);
        AVL_TREE.insertNode(15);
        AVL_TREE.insertNode(20);

        Menu.menu();

        //      ABAIXO DESTA LINHA ESTÃO APENAS TESTES DIVERSOS 


        //Menu.menu();

        //TODAS AS LINHAS ABAIXO SÃO APENAS PARA TESTE "BRUTO" DA LÓGICA IMPLEMENTADA ATÉ O MOMENTO. Aparentemente tudo funciona como deveria
        //Descomentar a linha '7' e comentar todas as linhas entre '12' e '54' para testar o programa pelo menu de usuário

        // AVL_TREE.insertNode(10);
        
        // System.out.println("ROOT:...................." + Main.AVL_TREE.getRoot().toString());
        // System.out.println(Main.AVL_TREE.getRoot().printNodeAttributes());
        // System.out.println("LEFTSON:................." + Main.AVL_TREE.getRoot().getLeftSon().toString());
        // System.out.println(Main.AVL_TREE.getRoot().getLeftSon().printNodeAttributes());
        // System.out.println("RIGHTSON:................." + Main.AVL_TREE.getRoot().getRightSon().toString());
        // System.out.println(Main.AVL_TREE.getRoot().getRightSon().printNodeAttributes());

        // System.out.println("=====================================================================");

        // AVL_TREE.insertNode(5);

        // System.out.println("ROOT:...................." + Main.AVL_TREE.getRoot().toString());
        // System.out.println(Main.AVL_TREE.getRoot().printNodeAttributes());
        // System.out.println("LEFTSON:................." + Main.AVL_TREE.getRoot().getLeftSon().toString());
        // System.out.println(Main.AVL_TREE.getRoot().getLeftSon().printNodeAttributes());
        // System.out.println("RIGHTSON:................." + Main.AVL_TREE.getRoot().getRightSon().toString());
        // System.out.println(Main.AVL_TREE.getRoot().getRightSon().printNodeAttributes());

        // System.out.println("=====================================================================");

        // AVL_TREE.insertNode(15);

        // System.out.println("ROOT:...................." + Main.AVL_TREE.getRoot().toString());
        // System.out.println(Main.AVL_TREE.getRoot().printNodeAttributes());
        // System.out.println("LEFTSON:................." + Main.AVL_TREE.getRoot().getLeftSon().toString());
        // System.out.println(Main.AVL_TREE.getRoot().getLeftSon().printNodeAttributes());
        // System.out.println("RIGHTSON:................." + Main.AVL_TREE.getRoot().getRightSon().toString());
        // System.out.println(Main.AVL_TREE.getRoot().getRightSon().printNodeAttributes());

        // System.out.println("=====================================================================");

        // AVL_TREE.insertNode(1);

        // System.out.println("ROOT:...................." + Main.AVL_TREE.getRoot().toString());
        // System.out.println(Main.AVL_TREE.getRoot().printNodeAttributes());
        // System.out.println("LEFTSON:................." + Main.AVL_TREE.getRoot().getLeftSon().toString());
        // System.out.println(Main.AVL_TREE.getRoot().getLeftSon().printNodeAttributes());
        // System.out.println("LEFTneto:................." + Main.AVL_TREE.getRoot().getLeftSon().getLeftSon().toString());
        // System.out.println(Main.AVL_TREE.getRoot().getLeftSon().getLeftSon().printNodeAttributes());
        // System.out.println("RIGHTSON:................." + Main.AVL_TREE.getRoot().getRightSon().toString());
        // System.out.println(Main.AVL_TREE.getRoot().getRightSon().printNodeAttributes());  

    }
}
