import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoList {
    private JFrame frame;
    private JList<String> list;
    private DefaultListModel<String> model;

    public ToDoList() {
        final int[] taskCount = {0};
        frame = new JFrame("To-Do-List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        model = new DefaultListModel<>();
        list = new JList<>(model);
        JScrollPane scrollPane = new JScrollPane(list);

        JTextField taskInput = new JTextField(15);
        String[] times = {"00:00", "00:30", "01:00", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00", "23:30"};
        JComboBox<String> timeInput = new JComboBox<>(times);
        JButton addTaskButton = new JButton("Adicionar anotação");

        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskInput.getText();
                String time = (String) timeInput.getSelectedItem();
                model.addElement(taskCount[0] + " - " + task + " | " + time);
                taskCount[0]++;
                taskInput.setText("");
                timeInput.setSelectedIndex(0);
            }
        });
        JButton removeTaskButton = new JButton("Remover anotação");
        removeTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();
                if (selectedIndex != -1) {
                    model.remove(selectedIndex);
                }
            }
        });
        JPanel inputPanel = new JPanel();
        inputPanel.setBorder(BorderFactory.createTitledBorder("Adicionar tarefa:"));
        taskInput.setFont(new Font("Arial", Font.PLAIN, 12));
        taskInput.setForeground(Color.BLACK);
        taskInput.setPreferredSize(new Dimension(200, 30));
        timeInput.setFont(new Font("Arial", Font.PLAIN, 12));
        timeInput.setForeground(Color.black);
        timeInput.setPreferredSize(new Dimension(50,30));
        addTaskButton.setPreferredSize(new Dimension(150, 30));
        removeTaskButton.setPreferredSize(new Dimension(150, 30));
        frame.setSize(500, 400);
        frame.setLocation(500,300);
        ImageIcon icon = new ImageIcon("vitury.png");
        frame.setIconImage(icon.getImage());
        inputPanel.add(taskInput);
        inputPanel.add(timeInput);
        inputPanel.add(addTaskButton);
        inputPanel.add(removeTaskButton);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        ToDoList ToDoList = new ToDoList();
        ToDoList.frame.pack();
        ToDoList.frame.setVisible(true);
    }
}
