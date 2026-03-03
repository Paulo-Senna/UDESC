public enum FaixaEtaria {
    CRIANCA("crianças"),
    ADOLESCENTE("adolescentes"),
    JOVEM("jovens"),
    ADULTO("adultos"),
    IDOSO("idosos");

    private final String descricao;

    FaixaEtaria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
