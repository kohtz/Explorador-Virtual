import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do explorador:");
        String nome = scanner.nextLine();
        System.out.println("Digite a nacionalidade do explorador:");
        String nacionalidade= scanner.nextLine();

        Explorador explorador = new Explorador(nome, nacionalidade);

        while (explorador.estado_vida) {
            explorador.Informacoes();
            System.out.println("Escolha uma ação: 1. Explorar 2. Coletar Recursos 3. Treinar 4. Pesquisar Local Visitado 5. Sair");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Escolha uma categoria: 1. Planeta 2. Estrela 3. Estação Espacial");
                    int categoryChoice = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.println("Digite o nome do local:");
                    String location = scanner.nextLine();
                    explorador.Explorar(categoryChoice, location);
                    break;
                case 2:
                    explorador.ColetarRecursos();
                    break;
                case 3:
                    explorador.Treinar();
                    break;
                case 4:
                    System.out.println("Digite o nome do local que deseja pesquisar:");
                    String searchLocation = scanner.nextLine();
                    boolean found = explorador.searchVisitedLocation(searchLocation);
                    if (found) {
                        System.out.println("O explorador visitou " + searchLocation + ".");
                    } else {
                        System.out.println("O explorador não visitou " + searchLocation + ".");
                    }
                    break;
                case 5:
                    System.out.println("Exploração encerrada.");
                    explorador.estado_vida = false;
                    break;

                default:
                    System.out.println("Escolha inválida.");
                    break;
            }
        }
        scanner.close();
    }
}