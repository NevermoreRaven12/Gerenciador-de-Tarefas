package control;

import model.Tarefa;
import view.TarefaView;

import java.util.ArrayList;
import java.util.List;

public class TarefaController {
    private List<Tarefa> tarefas;
    private TarefaView view;

    public TarefaController(TarefaView view){
        this.tarefas = new ArrayList<>();
        this.view = view;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public String verDescricao(int id){
        return Tarefa.Object.getId();
    }

    public boolean removerTarefa(int id) {
        return true;
    }

    public boolean completarTarefa(int id) {
        return true;
    }

    public Tarefa buscarId(int id) {
        return Tarefa.Object;
    }

    public void adicionarTarefa(String nome, String descricao) {

    }
}
