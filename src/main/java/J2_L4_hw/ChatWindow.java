package J2_L4_hw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatWindow extends JFrame {
    public ChatWindow() {
        setTitle("Сетевой чат");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(50, 50, 400, 600);

        setLayout(new BorderLayout());

        JPanel chat = new JPanel();
        JPanel input = new JPanel();

        JTextArea jta = new JTextArea();
        jta.setEditable(false);
        JScrollPane jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JTextField jtf = new JTextField();
        jtf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChatWindow.this.jb(jtf, jta); // комментарий внизу кода
            }
        });
        JButton jb = new JButton("Отправить");
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChatWindow.this.jb(jtf, jta); // комментарий внизу кода
            }
        });

        chat.setLayout(new BoxLayout(chat, BoxLayout.X_AXIS));
        chat.add(jtf);
        chat.add(jb);

        input.setLayout(new BoxLayout(input, BoxLayout.X_AXIS));
        input.add(jsp);

        getContentPane().add(chat, BorderLayout.SOUTH);
        getContentPane().add(input, BorderLayout.CENTER);

        setVisible(true);
    }

    // это взял из интернета, по другому не смог реализовать передачу текста из input(jtf) в chat(jta)
    private void jb(JTextField jtf, JTextArea jta) {
        if (jtf.getText().equals("")) {
            return;
        }

        jta.append("\n" + jtf.getText());
        jtf.setText("");
    }
}
