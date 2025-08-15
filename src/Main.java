import control.TarefaController;
import view.TarefaView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TarefaView view = new TarefaView();
            view.setVisible(true);
        });
    }
}
