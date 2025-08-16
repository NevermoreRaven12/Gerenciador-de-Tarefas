package view;

import control.TarefaController;
import model.Tarefa;
import java.util.List;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TarefaView extends JFrame {
    public TarefaController control = new TarefaController(this);
    private JPanel tarefas;
    public TarefaView() {
        setTitle("Gerenciador de Tarefas");
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

// Painel para Nome e Descrição
        JPanel textoTarefa = new JPanel();
        textoTarefa.setLayout(new BoxLayout(textoTarefa, BoxLayout.Y_AXIS));


        JLabel nomeDaTarefa = new JLabel("Nome da Tarefa");
        nomeDaTarefa.setFont(new Font("Arial", Font.PLAIN, 20));
        textoTarefa.add(nomeDaTarefa);

        JTextField campoNome = new JTextField();
        campoNome.setPreferredSize(new Dimension(500, 30));
        campoNome.setMaximumSize(campoNome.getPreferredSize());
        textoTarefa.add(campoNome);

        // Espaçamento
        textoTarefa.add(Box.createRigidArea(new Dimension(0, 60)));


        JLabel descricao = new JLabel("Descrição da Tarefa");
        descricao.setFont(new Font("Arial", Font.PLAIN, 20));
        textoTarefa.add(descricao);

        JTextField campoDescricao = new JTextField();
        campoDescricao.setPreferredSize(new Dimension(700, 200));
        campoDescricao.setMaximumSize(campoDescricao.getPreferredSize());
        textoTarefa.add(campoDescricao);

        // Espaçamento
        textoTarefa.add(Box.createRigidArea(new Dimension(0, 60)));


        JButton adicionar = new JButton("Adicionar Tarefa");
        adicionar.setMaximumSize(new Dimension(200, 70));
        adicionar.setPreferredSize(new Dimension(200, 70));
        adicionar.setBorder(BorderFactory.createLineBorder(Color.black));
        adicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String nomeTarefa = campoNome.getText().trim();
                String descricaoTarefa = campoDescricao.getText().trim();
                control.adicionarTarefa(nomeTarefa, descricaoTarefa);
                campoNome.setText("");
                campoDescricao.setText("");
            }
        });

        textoTarefa.add(adicionar);


        // Painel das Tarefas

        tarefas = new JPanel();
        tarefas.setLayout(new BoxLayout(tarefas, BoxLayout.Y_AXIS));
        tarefas.setBackground(Color.WHITE);


        // Painel de Scroll
        JScrollPane scrollTarefas = new JScrollPane(tarefas);
        scrollTarefas.setPreferredSize(new Dimension(540, 700));

        scrollTarefas.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


        // Adiciona no frame
        add(textoTarefa);
        add(scrollTarefas);

    }

    public void exibirTarefas(List<Tarefa> listaTarefas) {
        // Limpa o painel antes de renderizar
        tarefas.removeAll();

        for (Tarefa t : listaTarefas) {
            // Painel por tarefa
            JPanel tarefaPanel = new JPanel();
            tarefaPanel.setLayout(new BoxLayout(tarefaPanel, BoxLayout.X_AXIS));
            tarefaPanel.setBackground(Color.WHITE);

            JCheckBox tarefaCheck = new JCheckBox(t.getNome());
            tarefaCheck.setSelected(t.isCompleta());
            tarefaCheck.setFont(new Font("Arial", Font.BOLD, 26));
            tarefaCheck.setBorderPainted(false);
            tarefaCheck.setBackground(Color.WHITE);

            tarefaPanel.add(tarefaCheck);

            JButton descrip = new JButton("Descrição");
            descrip.setPreferredSize(new Dimension(100, 30));
            descrip.addActionListener(e ->
                    JOptionPane.showMessageDialog(descrip, t.getDescricao())
            );
            tarefaPanel.add(Box.createRigidArea(new Dimension(10, 0)));
            tarefaPanel.add(descrip);

            JButton remover = new JButton("Remover");
            remover.setPreferredSize(new Dimension(100, 30));
            remover.addActionListener(e -> {
                control.removerTarefa(t.getId());
                exibirTarefas(control.getTarefas()); // re-renderiza a lista
            });
            tarefaPanel.add(Box.createRigidArea(new Dimension(10, 0)));
            tarefaPanel.add(remover);

            tarefas.add(tarefaPanel);
            tarefas.add(Box.createRigidArea(new Dimension(0, 10))); // espaço entre tarefas
        }

        tarefas.revalidate();
        tarefas.repaint();
    }


    public void mostrarErro(String msg) {
        System.out.println("Erro: " + msg);
    }

}
