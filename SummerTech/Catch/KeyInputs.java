package Catch;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

public class KeyInputs extends JFrame implements KeyListener {
    JTextArea Display;
    JTextField Typing;
    KeyDefinition definition;
    public static void Start(String title, KeyDefinition definition) {
        javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI(title, definition));
    }

    public KeyInputs(String title, KeyDefinition definition) {
        super(title);
        this.definition = definition;
    }

    private static void createAndShowGUI(String title, KeyDefinition definition) {
        KeyInputs frame = new KeyInputs(title, definition);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addComponents();
        frame.pack();
        frame.setBounds(0, 0, 950,1000);
        frame.setVisible(true);
        definition.KeyDefine(0, frame.Display);
    }

    private void addComponents() {
        Typing = new JTextField();
        Typing.addKeyListener(this);
        Display = new JTextArea();
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts\\unifont.ttf")).deriveFont(30f);//font size
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            Display.setFont(customFont);
        }
        catch(Exception E){}
        Display.setForeground(Color.black);
        Display.setEditable(false);
        Display.setFocusable(false);
        JScrollPane scrollPane = new JScrollPane(Display);
        scrollPane.setPreferredSize(new Dimension(150, 150));
        getContentPane().add(Typing, BorderLayout.PAGE_START);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

    }

    public void keyTyped(KeyEvent e) {}

    public void keyReleased(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        keyPress(e);
    }

    private void keyPress(KeyEvent e) {
        Typing.setText("");
        definition.KeyDefine(e.getKeyCode(), Display);
    }
}