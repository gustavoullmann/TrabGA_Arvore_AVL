import java.util.Scanner;

public class Menu {

    public static void menu() {

        Scanner input = new Scanner(System.in);

        System.out.println("Escolha uma opção no menu abaixo:" + "\n");

        System.out.println("\t" + "'i' - Para inserir um nodo;");
        System.out.println("\t" + "'b' - Para buscar um nodo;");
        System.out.println("\t" + "'r' - Para remover um nodo;");

        System.out.print("\n" + "Qual a opção desejada? ");

        try {
            String option = input.nextLine();

            switch(option.toLowerCase()) {

                case "i":
                    System.out.println("teste de inserção");
                    break;

                case "b":
                    System.out.println("teste de busca");
                    break;

                case "r":
                    System.out.println("teste de remoção");
                    break;
                
                default:
                    System.out.println("A opção digitada não consta no menu!");
                    System.out.println("Digite apenas as letras 'i', 'b' ou 'r'!");
                    menu();
                    break;

            }
        }
        catch (Exception e) {
            System.out.println("A opção digitada não consta no menu!");
            System.out.println("Digite apenas as letras 'i', 'b' ou 'r'!");
        }
        input.close();
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

}
