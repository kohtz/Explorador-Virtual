class TreeNode {
    String locationName; // Nome do local explorado
    TreeNode left, right; // Filhos esquerdo e direito

    public TreeNode(String locationName) {
        this.locationName = locationName;
        this.left = this.right = null;
    }
}
