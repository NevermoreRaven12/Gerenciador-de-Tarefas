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

    public void adicionarTarefa(String nome, String descricao) {
        try {
            Tarefa novaTarefa;
            if (descricao == null || descricao.trim().isEmpty()) {
                novaTarefa = new Tarefa(nome);
            } else {
                novaTarefa = new Tarefa(nome,descricao);
            }
            tarefas.add(novaTarefa);

        } catch (IllegalArgumentException e) {
            view.mostrarErro(e.getMessage());
        }
    }

    public String verDescricao(int id) {
        Tarefa tarefa = buscarTarefaId(id);
        if (tarefa == null) return "Tarefa não encontrada";

        String desc = tarefa.getDescricao();
        if (desc == null || desc.trim().isEmpty())
            return "Tarefa não possui descrição";
        else
            return desc;
    }




    public boolean removerTarefa(int id) {
        Tarefa tarefa = buscarTarefaId(id);
        if (tarefa != null) {
            tarefas.remove(tarefa);
            return true;
        }

        return false;
    }

    public boolean completarTarefa(int id) {
        Tarefa tarefa = buscarTarefaId(id);
        if (tarefa != null) {
            tarefa.toggleCompleta();
            return true;
        }
        return false;
    }

    public Tarefa buscarTarefaId(int id) {
            for (Tarefa tarefa : getTarefas()) {
                if (tarefa.getId() == id) {
                    return tarefa;
                }
        }
        return null;
    }


}
