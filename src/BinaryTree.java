class BinaryTree {
    private TreeNode root; // Raiz da árvore

        public BinaryTree() {
        root = null; // Inicialmente, a árvore está vazia
    }

    // Método para inserir um novo nó na árvore
    public void insert(String category, String locationName) {
        root = insertRec(root, category);
        insertLocation(root, category, locationName);
    }

    // Método recursivo para inserir um novo nó na árvore
    private TreeNode insertRec(TreeNode root, String category) {
        if (root == null) { // Se a posição está vazia, insere o novo nó aqui
            root = new TreeNode(category);
            return root;
        }
        if (category.compareTo(root.locationName) < 0) {
            root.left = insertRec(root.left, category);
        } else if (category.compareTo(root.locationName) > 0) {
            root.right = insertRec(root.right, category);
        }
        return root;
    }

     // Método recursivo para inserir o local específico na categoria correta
     private void insertLocation(TreeNode root, String category, String locationName) {
        if (root != null && root.locationName.equals(category)) {
            root.left = insertLocationRec(root.left, locationName);
        } else if (root != null) {
            if (category.compareTo(root.locationName) < 0) {
                insertLocation(root.left, category, locationName);
            } else {
                insertLocation(root.right, category, locationName);
            }
        }
    }


    // Método recursivo para inserir o local específico na subárvore correta
    private TreeNode insertLocationRec(TreeNode root, String locationName) {
        if (root == null) {
            root = new TreeNode(locationName);
            return root;
        }
        if (locationName.compareTo(root.locationName) < 0) {
            root.left = insertLocationRec(root.left, locationName);
        } else if (locationName.compareTo(root.locationName) > 0) {
            root.right = insertLocationRec(root.right, locationName);
        }
        return root;
    }

    // Método para buscar um nó na árvore
    public boolean search(String locationName) {
        return searchRec(root, locationName) != null;
    }

    // Método recursivo para buscar um nó na árvore
    private TreeNode searchRec(TreeNode root, String locationName) {
        if (root == null || root.locationName.equals(locationName)) {
            return root; // Retorna o nó encontrado ou null se não encontrado
        }
        if (root.locationName.compareTo(locationName) > 0) {
            return searchRec(root.left, locationName);
        }
        return searchRec(root.right, locationName);
    }

    // Método para exibir a árvore
    public void display() {
        displayRec(root, 0);
    }

    // Método recursivo para exibir a árvore
    private void displayRec(TreeNode root, int level) {
        if (root != null) {
            displayRec(root.right, level + 1); // Exibe o subárvore da direita
            for (int i = 0; i < level; i++) {
                System.out.print("   "); // Indenta os nós conforme o nível
            }
            System.out.println(root.locationName); // Exibe o nó atual
            displayRec(root.left, level + 1); // Exibe o subárvore da esquerda
        }
    }
}