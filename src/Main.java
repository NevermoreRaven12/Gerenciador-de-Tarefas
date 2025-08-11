import control.TarefaController;

public class Main {
    public static void main(String[] args){
        TarefaController controller = new TarefaController(null);
        controller.adicionarTarefa("teste1", "descrição da tarefa1");
        controller.adicionarTarefa("teste", "");
        System.out.println(controller.verDescricao(1));
        System.out.println(controller.verDescricao(2));

        if (controller.removerTarefa(2)){
            System.out.println("Tarefa removida!");
        } else {
            System.out.println("Operação falhou");
        }

        if (controller.completarTarefa(1)) {
            System.out.println("Tarefa completa");
        } else {
            System.out.println("Operação falhou");
        }

        System.out.println(controller.getTarefas());
    }
}
