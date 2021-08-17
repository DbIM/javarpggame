package Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CastleFrame {
    private static JFrame frame;
    private static JPanel panel;
    JLabel eyeView;

    public CastleFrame() throws IOException {
        frame = new JFrame("Inside the Castle");
        frame.setSize(960, 536);
        frame.setUndecorated(true);
        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        eyeView = new JLabel(new ImageIcon("src/Game/img/ladyScroll1.png"));
        eyeView.setBounds(0, 0, 960, 536);


        JLabel escapeButton = new JLabel(new ImageIcon("src/Game/img/escapeScrollButton.png"));
        escapeButton.setBounds(840, 380, 86, 110);
        escapeButton.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                try {
                    frame.dispose();
                    ClassicRPGGame game = new ClassicRPGGame();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        panel.add(escapeButton);
        panel.add(eyeView);

        frame.setVisible(true);
    }
}
