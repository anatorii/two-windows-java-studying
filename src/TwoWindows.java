import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TwoWindows extends JFrame {
    static int width = 800;
    static int height = 600;
    static int clientWidth;
    static int clientHeight;
    public JPanel panel;

    public TwoWindows() {
        super("two windows");
        initGui();
    }

    private void initGui() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(TwoWindows.width, TwoWindows.height));
        this.setLocation(d.width / 2 - TwoWindows.width / 2, d.height / 2 - TwoWindows.height / 2);
        this.getContentPane().setBackground(Color.lightGray);
        this.setResizable(false);

        panel = new JPanel();
        panel.setBackground(Color.lightGray);
        panel.setFocusable(true);

        JButton button = new JButton("Диалоговое окно");

        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonActionPerformed(e);
            }
        });

        panel.add(button);

        this.getContentPane().add(panel);
    }

    private void buttonActionPerformed(ActionEvent e) {
        String input = JOptionPane.showInputDialog(
                TwoWindows.this,
                "Input your name",
                "Input dialog",
                JOptionPane.QUESTION_MESSAGE
        );
        if (input != null && input.length() != 0) {
            JOptionPane.showMessageDialog(
                    TwoWindows.this,
                    input,
                    "Your name",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    public void setVisible(boolean b) {
        super.setVisible(b);
        clientWidth = TwoWindows.width;
        clientHeight = TwoWindows.height;
        if (isResizable()) {
            clientWidth = getContentPane().getWidth();
            clientHeight = getContentPane().getHeight();
        }
    }

    public static void main(String[] args) {
        UIManager.put("OptionPane.yesButtonText"   , "Да"    );
        UIManager.put("OptionPane.noButtonText"    , "Нет"   );
        UIManager.put("OptionPane.cancelButtonText", "Отмена");
        UIManager.put("OptionPane.okButtonText"    , "OK");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TwoWindows frame = new TwoWindows();
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

}
