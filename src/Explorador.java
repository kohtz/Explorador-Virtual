public class Explorador {
    String nome;
    String nacionalidade;
    int energia;
    int saude;
    boolean estado_vida;
    BinaryTree visitedLocations; // Árvore binária dos locais visitados
    String [] categories; // Lista as categorias

    //Construtor da classe Explorador
    public Explorador(String nome, String nacionalidade){
        this.nome = nome;
        this. nacionalidade = nacionalidade;
        this.energia = 100; //Explorador começa com 100 de energia
        this.saude = 100; //Explorador começa com 100 de saúde
        this.estado_vida = true; //Explorador começa vivo
        this.visitedLocations = new BinaryTree(); // Inicializa a árvore dos locais visitados
        initializeCategories();//Incializa as categorias de locais
    }

    private void initializeCategories(){
        categories = new String[]{"Planeta", "Estrela", "Estação Espacial"};
    }

    //Método para o explorador morrer
    public void Morrer(){
        this.saude = 0;
        this.estado_vida = false;
        System.err.println("O explorador morreu.");
    }

    //Método para o explorador explorar novos lugares
    public void Explorar(int categoryChoice, String location) {
        if (categoryChoice >= 1 && categoryChoice <= categories.length && this.estado_vida && this.energia >= 10 && this.saude >= 5) {
            String category = categories[categoryChoice - 1];
            this.energia -= 10;
            this.saude -= 5;
            visitedLocations.insert(category, location);
            System.out.println("O explorador explorou " + location + " na categoria " + category + ".");
        } else {
            System.out.println("O explorador não tem energia ou saúde suficiente para explorar ou categoria inválida.");
        }
    }

    //Método para coletar recursos
    public void ColetarRecursos(){
        if (this.estado_vida && this.saude >= 10) {
            this.energia += 20;
            this.saude -= 10;
            System.out.println("O explorador coletou recursos no espaço.");
        } else {
            System.out.println("O explorador não tem saúde suficiente para coletar recursos.");
        }
    }

  // Método para o explorador treinar
  public void Treinar() {
    if (this.estado_vida && this.energia >= 10) {
        this.saude += 15;
        this.energia -= 10;
        System.out.println("O explorador treinou e melhorou sua saúde.");
    } else {
        System.out.println("O explorador não tem energia suficiente para treinar.");
    }
    }

    // Método para exibir informações sobre o explorador
    public void Informacoes() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Nacionalidade: " + this.nacionalidade);
        System.out.println("Energia: " + this.energia);
        System.out.println("Saúde: " + this.saude);
        System.out.println("Estado de vida: " + (this.estado_vida ? "Vivo" : "Morto"));
        System.out.println("Locais explorados:");
        visitedLocations.display();
    }


    //Método para procurar locais visitados
    public boolean searchVisitedLocation(String location) {
        return visitedLocations.search(location);
    }

}

