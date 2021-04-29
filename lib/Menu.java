import java.util.Scanner;

public class Menu {

    public static void menu() {

        Scanner input = new Scanner(System.in);

        System.out.println("\n" + "Escolha uma opção no menu abaixo:" + "\n");

        System.out.println("\t" + "'i' - Para inserir um nodo;");
        System.out.println("\t" + "'b' - Para buscar um nodo;");
        System.out.println("\t" + "'r' - Para remover um nodo;");
        System.out.println("\t" + "'p' - Para imprimir a árvore em múltiplos percursos");

        System.out.print("\n" + "Qual a opção desejada? ");
        
        try {
            String option = input.nextLine();

            switch(option.toLowerCase()) {

                case "i":
            
                    try {
                        System.out.print("\n\t" + "ATENÇÃO: Digite qualquer tecla não numérica para sair e voltar ao Menu principal! " + "\n");
                        
                        boolean userIntegerInput = true;

                        while(userIntegerInput) {
                            System.out.print("\n" + "Digite um valor inteiro para inserir na árvore: ");
                        
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
                        System.out.println("\n\t" + "ATENÇÃO: você digitou uma tecla não numérica! Voltando para o Menu inicial...");
                        menu();
                    }
                    break;

                case "b":                                       
                   
                    System.out.print("\n" + "Digite um valor inteiro para buscar na árvore: ");
                        
                    try {
                        int key = input.nextInt();

                        Main.AVL_TREE.printSearchNodePath(key);

                        Nodo returnedNode = Main.AVL_TREE.searchNode(key);

                        if(returnedNode.getData() == null) {
                            System.out.println("\n" + "O valor digitado não foi encontrado na árvore!");
                            menu();
                        }
                        else {
                            System.out.println("\n" + "Abaixo as informações do nó '" + key + "'" + "\n");
                            System.out.println(returnedNode.printNodeAttributes());
                            menu();
                        }
                    } 
                    catch (Exception InputMismatchException) {
                        System.out.println("\n\t" + "ATENÇÃO: você digitou uma tecla não numérica! Voltando para o Menu inicial...");
                        menu();
                    }
                    break;

                case "r": 
                    
                    System.out.print("\n" + "Digite um valor inteiro positivo para remover da árvore: ");
                    
                    try {
                        int key = input.nextInt();
                        System.out.println("TESTE chave digitada: " + key);                             //TODO: remover esse teste                              
                    } 
                    catch (Exception InputMismatchException) {
                        System.out.println("\n\t" + "ATENÇÃO: você digitou uma tecla não numérica! Voltando para o Menu inicial...");
                        menu();            
                    }
                    break;

                case "p":

                    Nodo rootNode = Main.AVL_TREE.getRoot();
                    Tree tree = Main.AVL_TREE;

                    System.out.println("\n" + "Imprimir a árvore em múltiplos percursos: " + "\n");

                    System.out.print("\t" + "Pre ordem: " + "\t");
                    tree.preOrderTraversal(rootNode);
                    System.out.println();

                    System.out.print("\t" + "Em ordem: " + "\t");
                    tree.inOrderTraversal(rootNode);
                    System.out.println();

                    System.out.print("\t" + "Pós ordem: " + "\t");
                    tree.postOrderTraversal(rootNode);
                    System.out.print("\n");

                    menu();

                    break;
                
                default:
                    System.out.println("\n\t" + "A opção digitada não consta no menu!");
                    System.out.println("\t" + "Digite apenas as letras 'i', 'b', 'r' ou 'p'!" + "\n");
                    menu();
                    break;
            }
        }
        catch (Exception e) {
            System.out.println("\n\t" + "A opção digitada não consta no menu!");
            System.out.println("\t" + "Digite apenas as letras 'i', 'b', 'r' ou 'p'!" + "\n");
        }
        input.close();
    }
}

    //TODO: Método REMOÇÃO    
        //comando r
        //chamar método de saída

    //TODO: fazer menu para encerrar o programa
