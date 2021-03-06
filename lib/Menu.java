import java.util.Scanner;

public class Menu {          

    public static void menu() {

        Scanner input = new Scanner(System.in);

        System.out.println("\n" + "\033[1;33m" + "Escolha uma opção no menu abaixo:"  + "\n");

        System.out.println("\t" + "'i' - Para inserir um nodo;");
        System.out.println("\t" + "'b' - Para buscar um nodo;");
        System.out.println("\t" + "'r' - Para remover um nodo;");
        System.out.println("\t" + "'p' - Para imprimir a árvore em múltiplos percursos");
        System.out.println("\t" + "'s' - Para sair do programa");

        System.out.print("\n" + "Qual a opção desejada? " + "\033[0m");
        
        try {
            String option = input.nextLine();

            switch(option.toLowerCase()) {

                case "i":
            
                    try {
                        System.out.print("\n\t" + "\033[31m" + "ATENÇÃO: Digite qualquer tecla não numérica para sair e voltar ao Menu principal! " + "\033[0m" + "\n");
                        
                        boolean userIntegerInput = true;

                        while(userIntegerInput) {
                            System.out.print("\n" + "\033[1;33m" + "Digite um valor inteiro para inserir na árvore: " + "\033[0m");
                        
                            int key = input.nextInt();
                            Nodo newNode = Main.AVL_TREE.insertNode(key);
                            Main.AVL_TREE.checkTreeUnbalanceFromLeaf(newNode);

                            System.out.println();
                            System.out.println(Main.AVL_TREE.printHeader());
                            Main.AVL_TREE.printTree(Main.AVL_TREE.getRoot(), 0);
                        }
                        menu();
                    } 
                    catch (Exception InputMismatchException) {
                        System.out.println("\n\t" + "\033[31m" + "ATENÇÃO: você digitou uma tecla não numérica! Voltando para o Menu inicial..." + "\033[0m");
                        menu();
                    }
                    break;

                case "b":                                       
                   
                    System.out.print("\n" + "\033[1;33m" + "Digite um valor inteiro para buscar na árvore: " + "\033[0m");
                        
                    try {
                        int key = input.nextInt();
                        Main.AVL_TREE.printSearchNodePath(key);
                        Nodo returnedNode = Main.AVL_TREE.searchNode(key);

                        if(returnedNode.getData() == null) {
                            System.out.println("\n" + "\033[31m" + "ATENÇÃO: o valor digitado não foi encontrado na árvore!" + "\033[0m");
                            menu();
                        }
                        else {
                            System.out.println("\n" + "\033[1;33m" + "Abaixo as informações do nó '" + key + "'" + "\033[0m" + "\n");
                            System.out.println(returnedNode.printNodeAttributes());
                            menu();
                        }
                    } 
                    catch (Exception InputMismatchException) {
                        System.out.println("\n\t" + "\033[31m" + "ATENÇÃO: você digitou uma tecla não numérica! Voltando para o Menu inicial..." + "\033[0m");
                        menu();
                    }
                    break;

                case "r": 
                    
                    System.out.print("\n" + "\033[1;33m" + "Digite um valor inteiro positivo para remover da árvore: " + "\033[0m");
                    
                    try {
                        int key = input.nextInt();
                        Main.AVL_TREE.removeNode(key); 

                        System.out.println();
                        System.out.println(Main.AVL_TREE.printHeader());
                        Main.AVL_TREE.printTree(Main.AVL_TREE.getRoot(), 0);
        
                        System.out.println("\n\t" + "\033[32m" + "ATENÇÃO: o nó '" + key + "' foi removido da árvore!" + "\033[0m");
                        menu();
                    } 
                    catch (Exception InputMismatchException) {
                        System.out.println("\n\t" + "\033[31m" + "ATENÇÃO: você digitou uma tecla não numérica! Voltando para o Menu inicial..." + "\033[0m");
                        menu();            
                    }
                    break;

                case "p":

                    Nodo rootNode = Main.AVL_TREE.getRoot();
                    Tree tree = Main.AVL_TREE;

                    System.out.println("\n" + "\033[1;33m" + "Imprimir a árvore em múltiplos percursos: " + "\033[0m" + "\n");

                    System.out.println(tree.printHeader());
                    tree.printTree(rootNode, 0);
                    System.out.println("\033[1;33m" + "Legenda: " + "\033[0m" + "nó[" + "\033[32m" + "fator balanceamento" + "\033[0m" + "]" + "\n");

                    System.out.print("\n" + "\033[1;33m" + "Pré ordem: " + "\033[0m" + "\t");
                    tree.preOrderTraversal(rootNode);
                    System.out.println();

                    System.out.print("\033[1;33m" + "Em ordem: " + "\033[0m" + "\t");
                    tree.inOrderTraversal(rootNode);
                    System.out.println();

                    System.out.print("\033[1;33m" + "Pós ordem: " + "\033[0m" + "\t");
                    tree.postOrderTraversal(rootNode);
                    System.out.print("\n");

                    menu();
                    break;
                
                case "s":

                    System.exit(0);

                default:
                    System.out.println("\n\t" + "\033[31m" + "ATENÇÃO: a opção digitada não consta no menu!" + "\033[0m");
                    System.out.println("\t" + "\033[31m" + "Digite apenas as letras 'i', 'b', 'r', 'p' ou 's'!" + "\033[0m" + "\n");
                    menu();
                    break;
            }
        }
        catch (Exception e) {
            System.out.println("\n\t" + "\033[31m" + "ATENÇÃO: a opção digitada não consta no menu!" + "\033[0m");
            System.out.println("\t" + "\033[31m" + "Digite apenas as letras 'i', 'b', 'r', 'p' ou 's'!" + "\033[0m" + "\n");
            menu();
        }
        input.close();
    }
}
