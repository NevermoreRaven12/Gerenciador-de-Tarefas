package model;

public class Tarefa {
    private static int contador = 0;
    private final int id;
    private String nome;
    private String descricao;
    private boolean isCompleta;

    public Tarefa(String nome, String descricao){
        contador++;
        id = contador;
        setNome(nome);
        setDescricao(descricao);
        isCompleta = false;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("O nome da tarefa não pode estar vazio");
        } else {
            this.nome = nome;
        }

    }

    public void setDescricao(String descricao) {
        if (descricao == null) {
            this.descricao = "";

        } else {
            this.descricao = descricao;
        }
    }

    public void toggleCompleta() {
        this.isCompleta = !this.isCompleta;
    }

    public boolean isCompleta() {
        return isCompleta;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

}
