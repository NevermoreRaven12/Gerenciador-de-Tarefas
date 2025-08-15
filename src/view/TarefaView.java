package view;

import javax.swing.*;

import java.awt.*;


public class TarefaView extends JFrame {
    public TarefaView(){
        setTitle("Gerenciador de Tarefas");
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT,0,0));

// Painel para Nome e Descrição
        JPanel textoTarefa = new JPanel();
        textoTarefa.setLayout(new BoxLayout(textoTarefa,BoxLayout.Y_AXIS));



        JLabel nomeDaTarefa = new JLabel("Nome da Tarefa");
        nomeDaTarefa.setFont(new Font("Arial", Font.PLAIN, 20));
        textoTarefa.add(nomeDaTarefa);

        JTextField campoNome = new JTextField();
        campoNome.setPreferredSize(new Dimension(500, 30));
        campoNome.setMaximumSize(campoNome.getPreferredSize());
        textoTarefa.add(campoNome);

        // Espaçamento
        textoTarefa.add(Box.createRigidArea(new Dimension(0,60)));


        JLabel descricao = new JLabel("Descrição da Tarefa");
        descricao.setFont(new Font("Arial", Font.PLAIN ,20));
        textoTarefa.add(descricao);

        JTextField campoDescricao = new JTextField();
        campoDescricao.setPreferredSize(new Dimension(700,200));
        campoDescricao.setMaximumSize(campoDescricao.getPreferredSize());
        textoTarefa.add(campoDescricao);

        // Espaçamento
        textoTarefa.add(Box.createRigidArea(new Dimension(0,60)));



        JButton adicionar = new JButton("Adicionar Tarefa");
        adicionar.setMaximumSize(new Dimension(200,70));
        adicionar.setPreferredSize(new Dimension(200,70));
        adicionar.setBorder(BorderFactory.createLineBorder(Color.black));

        textoTarefa.add(adicionar);


        // Painel das Tarefas

        JPanel tarefas = new JPanel();
        tarefas.setLayout(new BoxLayout(tarefas, BoxLayout.Y_AXIS));
        tarefas.setBackground(Color.WHITE);

        // Painel por Tarefa
        JPanel tarefaPanel = new JPanel();
        tarefaPanel.setLayout(new BoxLayout(tarefaPanel,BoxLayout.X_AXIS));
        tarefaPanel.setBackground(Color.WHITE);

        JCheckBox tarefa = new JCheckBox("Teste tarefa", false);
        tarefa.setFont(new Font("Arial", Font.BOLD,26));
        tarefa.add(Box.createRigidArea(new Dimension(350,50)));
        tarefa.setBackground(Color.WHITE);

        tarefaPanel.add(tarefa);

        JButton removerTarefa = new JButton("Remover");
        removerTarefa.setPreferredSize(new Dimension(20,20));

        tarefaPanel.add(removerTarefa);

        tarefas.add(tarefaPanel);

        JScrollPane scrollTarefas = new JScrollPane(tarefas);
        scrollTarefas.setPreferredSize(new Dimension(480,600));

        scrollTarefas.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);




// Adiciona no frame
        add(textoTarefa);
        add(scrollTarefas);


    }

    public void mostrarErro(String msg) {
        System.out.println("Erro: " + msg);
    }

}
