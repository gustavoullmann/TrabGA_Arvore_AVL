import java.util.Scanner;

public class Menu {

    public static void menu() {

        Scanner input = new Scanner(System.in);

        System.out.println("\n" + "Escolha uma opção no menu abaixo:" + "\n");

        System.out.println("\t" + "'i' - Para inserir um nodo;");
        System.out.println("\t" + "'b' - Para buscar um nodo;");
        System.out.println("\t" + "'r' - Para remover um nodo;");

        System.out.print("\n" + "Qual a opção desejada? ");
        
        try {
            String option = input.nextLine();

            switch(option.toLowerCase()) {

                case "i":
            
                    try {
                        System.out.print("\n\t" + "ATENÇÃO: Digite qualquer tecla não numérica para sair e voltar ao Menu principal! " + "\n");
                        
                        boolean aux = true;

                        while(aux) {
                            System.out.print("\n" + "Digite um valor inteiro para inserir na árvore: ");
                        
                            int key = input.nextInt();
    
                            Main.AVL_TREE.insertNode(key);
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
                        System.out.println("\n\t" + "ATENÇÃO: digite apenas números inteiros!");
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
                        System.out.println("\n\t" + "ATENÇÃO: digite apenas números inteiros!");
                        menu();            
                    }
                    break;
                
                default:
                    System.out.println("\n\t" + "A opção digitada não consta no menu!");
                    System.out.println("\t" + "Digite apenas as letras 'i', 'b' ou 'r'!" + "\n");
                    menu();
                    break;
            }
        }
        catch (Exception e) {
            System.out.println("\n\t" + "A opção digitada não consta no menu!");
            System.out.println("\t" + "Digite apenas as letras 'i', 'b' ou 'r'!" + "\n");
        }
        input.close();
    }
}

    //Todos os comandos têm um parâmetro que é um número inteiro.
    
    //TODO: Método BUSCA
        //comando "b"
        //chamar método de saída
        /*Para o comando de busca, a saída deve também 
        indicar se o número procurado,está ou não na árvore, 
        e apresentar a lista de nós/nodos consultados.*/

    //TODO: Método INSERÇÃO
        //comando "i"
        //chamar método de saída

    //TODO: Método REMOÇÃO    
        //comando r
        //chamar método de saída
