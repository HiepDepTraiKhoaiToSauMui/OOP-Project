package Main;

import javax.swing.*;

public class main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Gấu Anh");

        GamePanel panel = new GamePanel();
        window.add(panel);
        window.pack();

        window.setLocationRelativeTo(null);
        //the window will appear at the center of the screen

        window.setVisible(true);
        panel.setupGame();
        panel.startGameThread();
    }
}
