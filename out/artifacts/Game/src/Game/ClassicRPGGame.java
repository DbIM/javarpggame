package Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ClassicRPGGame implements ActionListener {
    private static JFrame frame;
    private static JPanel panel;
    JLabel backgroundLabel;
    JLabel mapLabel;
    JLabel eyeView;
    BufferedImage playerArrowImage;
    BufferedImage whatUReallyC;
    JLabel playerArrowLabel;
    String wherePlayerLook = "";
    int mapX = 538;
    int mapY = -116;
    int playerXPosition = 9;
    int playerYPosition = 10;

    int counter = 0;
    MapLoader level = new MapLoader("src/Game/map.txt");

    public ClassicRPGGame() throws IOException {

        frame = new JFrame("Classic RPG");
        frame.setSize(1024, 640);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);

        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        ActionListener bowButtonActionListener = new bowButtonActionListener();
        ActionListener exitButtonActionListener = new exitButtonActionListener();
        ActionListener upLeftButtonActionListener = new upLeftButtonActionListener();
        ActionListener upRightButtonActionListener = new upRightButtonActionListener();
        ActionListener downButtonActionListener = new downButtonActionListener();
        ActionListener upButtonActionListener = new upButtonActionListener();
        ActionListener leftButtonActionListener = new leftButtonActionListener();
        ActionListener rightButtonActionListener = new rightButtonActionListener();

        BufferedImage bowButtonIcon = ImageIO.read(new File("src/Game/img/buttons/bowbutton.JPG"));
        JButton bowButton = new JButton(new ImageIcon(bowButtonIcon));
        bowButton.setBorder(BorderFactory.createEmptyBorder());
        bowButton.setFocusPainted(false);
        bowButton.setContentAreaFilled(false);
        bowButton.setBounds(740, 230, 97, 82);
        bowButton.addActionListener(bowButtonActionListener);
        panel.add(bowButton);

        BufferedImage exitButtonIcon = ImageIO.read(new File("src/Game/img/buttons/exit.JPG"));
        JButton exitButton = new JButton(new ImageIcon(exitButtonIcon));
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        exitButton.setFocusPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setBounds(826, 305, 86, 70);
        exitButton.addActionListener(exitButtonActionListener);
        panel.add(exitButton);

        BufferedImage upleftbuttonicon = ImageIO.read(new File("src/Game/img/buttons/upleft.JPG"));
        JButton upleftbutton = new JButton(new ImageIcon(upleftbuttonicon));
        upleftbutton.setBorder(BorderFactory.createEmptyBorder());
        upleftbutton.setFocusPainted(false);
        upleftbutton.setContentAreaFilled(false);
        upleftbutton.setBounds(750, 470, 79, 65);
        upleftbutton.addActionListener(upLeftButtonActionListener);
        panel.add(upleftbutton);

        BufferedImage upbuttonicon = ImageIO.read(new File("src/Game/img/buttons/up.JPG"));
        JButton upbutton = new JButton(new ImageIcon(upbuttonicon));
        upbutton.setBorder(BorderFactory.createEmptyBorder());
        upbutton.setFocusPainted(false);
        upbutton.setContentAreaFilled(false);
        upbutton.setBounds(825, 470, 88, 71);
        upbutton.addActionListener(upButtonActionListener);
        panel.add(upbutton);

        BufferedImage uprightbuttonicon = ImageIO.read(new File("src/Game/img/buttons/upright.JPG"));
        JButton uprightbutton = new JButton(new ImageIcon(uprightbuttonicon));
        uprightbutton.setBorder(BorderFactory.createEmptyBorder());
        uprightbutton.setFocusPainted(false);
        uprightbutton.setContentAreaFilled(false);
        uprightbutton.setBounds(910, 470, 82, 70);
        uprightbutton.addActionListener(upRightButtonActionListener);
        panel.add(uprightbutton);

        BufferedImage leftbuttonicon = ImageIO.read(new File("src/Game/img/buttons/left.JPG"));
        JButton leftbutton = new JButton(new ImageIcon(leftbuttonicon));
        leftbutton.setBorder(BorderFactory.createEmptyBorder());
        leftbutton.setFocusPainted(false);
        leftbutton.setContentAreaFilled(false);
        leftbutton.setBounds(746, 538, 83, 67);
        leftbutton.addActionListener(leftButtonActionListener);
        panel.add(leftbutton);

        BufferedImage downbuttonicon = ImageIO.read(new File("src/Game/img/buttons/down.JPG"));
        JButton downbutton = new JButton(new ImageIcon(downbuttonicon));
        downbutton.setBorder(BorderFactory.createEmptyBorder());
        downbutton.setFocusPainted(false);
        downbutton.setContentAreaFilled(false);
        downbutton.setBounds(828, 538, 82, 68);
        downbutton.addActionListener(downButtonActionListener);
        panel.add(downbutton);

        BufferedImage rightbuttonicon = ImageIO.read(new File("src/Game/img/buttons/right.JPG"));
        JButton rightbutton = new JButton(new ImageIcon(rightbuttonicon));
        rightbutton.setBorder(BorderFactory.createEmptyBorder());
        rightbutton.setFocusPainted(false);
        rightbutton.setContentAreaFilled(false);
        rightbutton.setBounds(910, 538, 82, 68);
        rightbutton.addActionListener(rightButtonActionListener);
        panel.add(rightbutton);

        playerArrowImage = ImageIO.read(new File("src/Game/img/playerArrow/playerArrow1.png"));
        wherePlayerLook = "south";
        playerArrowLabel = new JLabel(new ImageIcon(playerArrowImage));
        playerArrowLabel.setBounds(856, 112, 32, 28);
        panel.add(playerArrowLabel);

        BufferedImage backgroundImage = ImageIO.read(new File("src/Game/img/mainWindowBlanc.png"));
        backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        backgroundLabel.setBounds(0, 0, 1024, 640);
        panel.add(backgroundLabel);

        BufferedImage eyeViewImage = ImageIO.read(new File("src/Game/img/startScreen.png"));
        eyeView = new JLabel(new ImageIcon(eyeViewImage));
        eyeView.setBounds(1, 25, 720, 421);
        panel.add(eyeView);

        BufferedImage mapImage = ImageIO.read(new File("src/Game/img/map504.png"));
        mapLabel = new JLabel(new ImageIcon(mapImage));
        mapLabel.setBounds(mapX, mapY, 667, 532);
        panel.add(mapLabel);

        frame.setVisible(true);
    }

    public class upLeftButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (wherePlayerLook.equals("south")) {
                try {
                    panel.remove(playerArrowLabel);
                    panel.remove(backgroundLabel);
                    panel.remove(mapLabel);
                    panel.remove(eyeView);
                    playerArrowImage = ImageIO.read(new File("src/Game/img/playerArrow/playerArrow2.png"));
                    wherePlayerLook = "east";
                    playerArrowLabel = new JLabel(new ImageIcon(playerArrowImage));
                    playerArrowLabel.setBounds(856, 112, 32, 28);
                    panel.add(playerArrowLabel);
                    panel.add(backgroundLabel);

                    int nextY = playerYPosition + 1;
                    BufferedImage eyeViewImage = ImageIO.read(new File(level.blockPicture(playerXPosition, nextY)));
                    eyeView = new JLabel(new ImageIcon(eyeViewImage));
                    eyeView.setBounds(1, 25, 720, 421);

                    panel.add(eyeView);
                    panel.add(mapLabel);
                    panel.updateUI();

                    System.out.println("Player look: " + wherePlayerLook);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            } else if (wherePlayerLook.equals("east")) {
                try {
                    panel.remove(playerArrowLabel);
                    panel.remove(backgroundLabel);
                    panel.remove(mapLabel);
                    panel.remove(eyeView);
                    playerArrowImage = ImageIO.read(new File("src/Game/img/playerArrow/playerArrow3.png"));
                    playerArrowLabel = new JLabel(new ImageIcon(playerArrowImage));
                    playerArrowLabel.setBounds(856, 112, 32, 28);
                    panel.add(playerArrowLabel);
                    panel.add(backgroundLabel);

                    int nextX = playerXPosition - 1;
                    BufferedImage eyeViewImage = ImageIO.read(new File(level.blockPicture(nextX, playerYPosition)));
                    eyeView = new JLabel(new ImageIcon(eyeViewImage));
                    eyeView.setBounds(1, 25, 720, 421);

                    panel.add(eyeView);
                    panel.add(mapLabel);
                    panel.updateUI();
                    wherePlayerLook = "north";
                    System.out.println("Player look: " + wherePlayerLook);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            } else if (wherePlayerLook.equals("north")) {
                try {
                    panel.remove(playerArrowLabel);
                    panel.remove(backgroundLabel);
                    panel.remove(mapLabel);
                    panel.remove(eyeView);
                    panel.updateUI();
                    playerArrowImage = ImageIO.read(new File("src/Game/img/playerArrow/playerArrow4.png"));
                    wherePlayerLook = "west";
                    playerArrowLabel = new JLabel(new ImageIcon(playerArrowImage));
                    playerArrowLabel.setBounds(856, 112, 32, 28);
                    panel.add(playerArrowLabel);
                    panel.add(backgroundLabel);

                    int nextY = playerYPosition - 1;
                    BufferedImage eyeViewImage = ImageIO.read(new File(level.blockPicture(playerXPosition, nextY)));
                    eyeView = new JLabel(new ImageIcon(eyeViewImage));
                    eyeView.setBounds(1, 25, 720, 421);

                    panel.add(eyeView);
                    panel.add(mapLabel);
                    panel.updateUI();
                    System.out.println("Player look: " + wherePlayerLook);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            } else if (wherePlayerLook.equals("west")) {
                try {
                    panel.remove(playerArrowLabel);
                    panel.remove(backgroundLabel);
                    panel.remove(mapLabel);
                    panel.remove(eyeView);
                    panel.updateUI();
                    playerArrowImage = ImageIO.read(new File("src/Game/img/playerArrow/playerArrow1.png"));
                    playerArrowLabel = new JLabel(new ImageIcon(playerArrowImage));
                    playerArrowLabel.setBounds(856, 112, 32, 28);
                    panel.add(playerArrowLabel);
                    panel.add(backgroundLabel);

                    int nextX = playerXPosition + 1;
                    BufferedImage eyeViewImage = ImageIO.read(new File(level.blockPicture(nextX, playerYPosition)));
                    eyeView = new JLabel(new ImageIcon(eyeViewImage));
                    eyeView.setBounds(1, 25, 720, 421);

                    panel.add(eyeView);
                    panel.add(mapLabel);
                    panel.updateUI();
                    wherePlayerLook = "south";
                    System.out.println("Player look: " + wherePlayerLook);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }

    public class upRightButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (wherePlayerLook.equals("south")) {
                try {
                    panel.remove(playerArrowLabel);
                    panel.remove(backgroundLabel);
                    panel.remove(mapLabel);
                    panel.remove(eyeView);
                    playerArrowImage = ImageIO.read(new File("src/Game/img/playerArrow/playerArrow4.png"));
                    playerArrowLabel = new JLabel(new ImageIcon(playerArrowImage));
                    playerArrowLabel.setBounds(856, 112, 32, 28);
                    panel.add(playerArrowLabel);
                    panel.add(backgroundLabel);

                    int nextY = playerYPosition - 1;
                    BufferedImage eyeViewImage = ImageIO.read(new File(level.blockPicture(playerXPosition, nextY)));
                    eyeView = new JLabel(new ImageIcon(eyeViewImage));
                    eyeView.setBounds(1, 25, 720, 421);

                    panel.add(eyeView);
                    panel.add(mapLabel);
                    panel.updateUI();
                    wherePlayerLook = "west";
                    System.out.println("Player look: " + wherePlayerLook);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            } else if (wherePlayerLook.equals("west")) {
                try {
                    panel.remove(playerArrowLabel);
                    panel.remove(backgroundLabel);
                    panel.remove(mapLabel);
                    panel.remove(eyeView);
                    playerArrowImage = ImageIO.read(new File("src/Game/img/playerArrow/playerArrow3.png"));
                    playerArrowLabel = new JLabel(new ImageIcon(playerArrowImage));
                    playerArrowLabel.setBounds(856, 112, 32, 28);
                    panel.add(playerArrowLabel);
                    panel.add(backgroundLabel);
                    int nextX = playerXPosition - 1;

                    BufferedImage eyeViewImage = null;
                    int nextBlockX = playerXPosition - 1;
                    int lastBlockX = nextBlockX - 1;
                    char near = level.blockLetter(nextBlockX, playerYPosition);
                    char far = level.blockLetter(lastBlockX, playerYPosition);
                    if (near == 'R' && far == 'R'){
                        try {
                            whatUReallyC = ImageIO.read(new File(level.blockFarPicture(nextBlockX, playerYPosition)));
                            eyeView = new JLabel(new ImageIcon(whatUReallyC));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    else if (near == 'R' && far == 'C'){
                        try {
                            whatUReallyC = ImageIO.read(new File(level.blockFarPicture(lastBlockX, playerYPosition)));
                            eyeView = new JLabel(new ImageIcon(whatUReallyC));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    else if (near == 'R' && far == 'T'){
                        try {
                            whatUReallyC = ImageIO.read(new File(level.blockFarPicture(lastBlockX, playerYPosition)));
                            eyeView = new JLabel(new ImageIcon(whatUReallyC));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    else {
                        try {
                            eyeViewImage = ImageIO.read(new File(level.blockPicture(nextBlockX, playerYPosition)));
                            eyeView = new JLabel(new ImageIcon(eyeViewImage));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        eyeView = new JLabel(new ImageIcon(eyeViewImage));
                    }
                    eyeView.setBounds(1, 25, 720, 421);

                    panel.add(eyeView);
                    panel.add(mapLabel);
                    panel.updateUI();
                    wherePlayerLook = "north";
                    System.out.println("Player look: " + wherePlayerLook);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            } else if (wherePlayerLook.equals("north")) {
                try {
                    panel.remove(playerArrowLabel);
                    panel.remove(backgroundLabel);
                    panel.remove(mapLabel);
                    panel.remove(eyeView);
                    panel.updateUI();
                    playerArrowImage = ImageIO.read(new File("src/Game/img/playerArrow/playerArrow2.png"));
                    playerArrowLabel = new JLabel(new ImageIcon(playerArrowImage));
                    playerArrowLabel.setBounds(856, 112, 32, 28);
                    panel.add(playerArrowLabel);
                    panel.add(backgroundLabel);
                    int nextY = playerYPosition + 1;

                    BufferedImage eyeViewImage = ImageIO.read(new File(level.blockPicture(playerXPosition, nextY)));
                    eyeView = new JLabel(new ImageIcon(eyeViewImage));
                    eyeView.setBounds(1, 25, 720, 421);

                    panel.add(eyeView);
                    panel.add(mapLabel);
                    panel.updateUI();
                    wherePlayerLook = "east";
                    System.out.println("Player look: " + wherePlayerLook);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            } else if (wherePlayerLook.equals("east")) {
                try {
                    panel.remove(playerArrowLabel);
                    panel.remove(backgroundLabel);
                    panel.remove(mapLabel);
                    panel.remove(eyeView);
                    panel.updateUI();
                    playerArrowImage = ImageIO.read(new File("src/Game/img/playerArrow/playerArrow1.png"));
                    playerArrowLabel = new JLabel(new ImageIcon(playerArrowImage));
                    playerArrowLabel.setBounds(856, 112, 32, 28);
                    panel.add(playerArrowLabel);
                    panel.add(backgroundLabel);
                    int nextX = playerXPosition + 1;

                    BufferedImage eyeViewImage = null;
                    int nextBlockX = playerXPosition + 1;
                    int lastBlockX = nextBlockX + 1;
                    char near = level.blockLetter(nextBlockX, playerYPosition);
                    char far = level.blockLetter(lastBlockX, playerYPosition);
                    if (near == 'R' && far == 'R'){
                        try {
                            whatUReallyC = ImageIO.read(new File(level.blockPicture(nextBlockX, playerYPosition)));
                            eyeView = new JLabel(new ImageIcon(whatUReallyC));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    else if (near == 'R' && far == 'C'){
                        try {
                            whatUReallyC = ImageIO.read(new File(level.blockFarPicture(lastBlockX, playerYPosition)));
                            eyeView = new JLabel(new ImageIcon(whatUReallyC));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    else if (near == 'R' && far == 'T'){
                        try {
                            whatUReallyC = ImageIO.read(new File(level.blockFarPicture(lastBlockX, playerYPosition)));
                            eyeView = new JLabel(new ImageIcon(whatUReallyC));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    else {
                        try {
                            eyeViewImage = ImageIO.read(new File(level.blockPicture(nextBlockX, playerYPosition)));
                            eyeView = new JLabel(new ImageIcon(eyeViewImage));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    eyeView.setBounds(1, 25, 720, 421);

                    panel.add(eyeView);
                    panel.add(mapLabel);
                    panel.updateUI();
                    wherePlayerLook = "south";
                    System.out.println("Player look: " + wherePlayerLook);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }

    public class downButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int nextX = playerXPosition + 1;
            boolean nextBlockIsBlocked = level.blockIsBlocked(nextX, playerYPosition);
            if (!nextBlockIsBlocked) {
                panel.remove(backgroundLabel);
                panel.remove(mapLabel);
                panel.remove(eyeView);
                panel.updateUI();
                mapY = mapY - 24;
                playerXPosition++;
                mapLabel.setBounds(mapX, mapY, 667, 532);
                panel.add(backgroundLabel);

                int nextBlockX = 0;
                int nextBlockY = 0;
                int lastBlockX = 0;
                if (wherePlayerLook.equals("east")){
                    nextBlockY = playerYPosition + 1;
                    BufferedImage eyeViewImage = null;
                    try {
                        eyeViewImage = ImageIO.read(new File(level.blockPicture(playerXPosition, nextBlockY)));
                        eyeView = new JLabel(new ImageIcon(eyeViewImage));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    eyeView.setBounds(1, 25, 720, 421);
                }
                else if(wherePlayerLook.equals("west")){
                    nextBlockY = playerYPosition - 1;
                    BufferedImage eyeViewImage = null;
                    try {
                        eyeViewImage = ImageIO.read(new File(level.blockPicture(playerXPosition, nextBlockY)));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    eyeView = new JLabel(new ImageIcon(eyeViewImage));
                    eyeView.setBounds(1, 25, 720, 421);
                }
                else if(wherePlayerLook.equals("north")){
                    BufferedImage eyeViewImage = null;
                    nextBlockX = playerXPosition - 1;
                    lastBlockX = nextBlockX - 1;
                    char near = level.blockLetter(nextBlockX, playerYPosition);
                    char far = level.blockLetter(lastBlockX, playerYPosition);
                    if (near == 'R' && far == 'R'){
                        try {
                            whatUReallyC = ImageIO.read(new File(level.blockFarPicture(nextBlockX, playerYPosition)));
                            eyeView = new JLabel(new ImageIcon(whatUReallyC));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    else if (near == 'R' && far == 'C'){
                        try {
                            whatUReallyC = ImageIO.read(new File(level.blockFarPicture(lastBlockX, playerYPosition)));
                            eyeView = new JLabel(new ImageIcon(whatUReallyC));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    else if (near == 'R' && far == 'T'){
                        try {
                            whatUReallyC = ImageIO.read(new File(level.blockFarPicture(lastBlockX, playerYPosition)));
                            eyeView = new JLabel(new ImageIcon(whatUReallyC));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    else {
                        try {
                            eyeViewImage = ImageIO.read(new File(level.blockPicture(nextBlockX, playerYPosition)));
                            eyeView = new JLabel(new ImageIcon(eyeViewImage));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        eyeView = new JLabel(new ImageIcon(eyeViewImage));
                    }

                    eyeView.setBounds(1, 25, 720, 421);
                }

                else if(wherePlayerLook.equals("south")){
                    BufferedImage eyeViewImage = null;
                    nextBlockX = playerXPosition + 1;
                    lastBlockX = nextBlockX + 1;
                    char near = level.blockLetter(nextBlockX, playerYPosition);
                    char far = level.blockLetter(lastBlockX, playerYPosition);
                    if (near == 'R' && far == 'R'){
                        try {
                            whatUReallyC = ImageIO.read(new File(level.blockPicture(nextBlockX, playerYPosition)));
                            eyeView = new JLabel(new ImageIcon(whatUReallyC));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    else if (near == 'R' && far == 'C'){
                        try {
                            whatUReallyC = ImageIO.read(new File(level.blockFarPicture(lastBlockX, playerYPosition)));
                            eyeView = new JLabel(new ImageIcon(whatUReallyC));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    else if (near == 'R' && far == 'T'){
                        try {
                            whatUReallyC = ImageIO.read(new File(level.blockFarPicture(lastBlockX, playerYPosition)));
                            eyeView = new JLabel(new ImageIcon(whatUReallyC));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    else {
                        try {
                            eyeViewImage = ImageIO.read(new File(level.blockPicture(nextBlockX, playerYPosition)));
                            eyeView = new JLabel(new ImageIcon(eyeViewImage));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    eyeView.setBounds(1, 25, 720, 421);
                }

                panel.add(eyeView);
                panel.add(mapLabel);
                panel.updateUI();

                System.out.println("Player X position: " + playerXPosition + " Player Y position: " + playerYPosition);
                System.out.println("Player stand on a " + level.blockName(playerXPosition, playerYPosition));
                System.out.println("Next block on the east " + level.blockName(playerXPosition, playerYPosition + 1));
                System.out.println("Next block on the west " + level.blockName(playerXPosition, playerYPosition - 1));
                System.out.println("Next block on the south " + level.blockName(playerXPosition + 1, playerYPosition));
                System.out.println("Next block on the north " + level.blockName(playerXPosition - 1, playerYPosition));
            }
        }
    }

    public class upButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int nextX = playerXPosition - 1;
            boolean nextBlockIsBlocked = level.blockIsBlocked(nextX, playerYPosition);
            if (!nextBlockIsBlocked) {
                panel.remove(backgroundLabel);
                panel.remove(mapLabel);
                panel.remove(eyeView);
                panel.updateUI();
                mapY = mapY + 24;
                playerXPosition--;
                mapLabel.setBounds(mapX, mapY, 667, 532);
                panel.add(backgroundLabel);

                int nextBlockX = 0;
                int nextBlockY = 0;
                int lastBlockX = 0;
                if (wherePlayerLook.equals("east")){
                    nextBlockY = playerYPosition + 1;
                    BufferedImage eyeViewImage = null;
                    try {
                        eyeViewImage = ImageIO.read(new File(level.blockPicture(playerXPosition, nextBlockY)));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    eyeView = new JLabel(new ImageIcon(eyeViewImage));
                    eyeView.setBounds(1, 25, 720, 421);
                }
                else if(wherePlayerLook.equals("west")){
                    nextBlockY = playerYPosition - 1;
                    BufferedImage eyeViewImage = null;
                    try {
                        eyeViewImage = ImageIO.read(new File(level.blockPicture(playerXPosition, nextBlockY)));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    eyeView = new JLabel(new ImageIcon(eyeViewImage));
                    eyeView.setBounds(1, 25, 720, 421);
                }
                else if(wherePlayerLook.equals("north")){
                    BufferedImage eyeViewImage = null;
                    nextBlockX = playerXPosition - 1;
                    lastBlockX = nextBlockX - 1;
                    char near = level.blockLetter(nextBlockX, playerYPosition);
                    char far = level.blockLetter(lastBlockX, playerYPosition);
                    if (near == 'R' && far == 'R'){
                        try {
                            whatUReallyC = ImageIO.read(new File(level.blockPicture(nextBlockX, playerYPosition)));
                            eyeView = new JLabel(new ImageIcon(whatUReallyC));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    else if (near == 'R' && far == 'C'){
                        try {
                            whatUReallyC = ImageIO.read(new File(level.blockFarPicture(lastBlockX, playerYPosition)));
                            eyeView = new JLabel(new ImageIcon(whatUReallyC));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    else if (near == 'R' && far == 'T'){
                        try {
                            whatUReallyC = ImageIO.read(new File(level.blockFarPicture(lastBlockX, playerYPosition)));
                            eyeView = new JLabel(new ImageIcon(whatUReallyC));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    else {
                        try {
                            eyeViewImage = ImageIO.read(new File(level.blockPicture(nextBlockX, playerYPosition)));
                            eyeView = new JLabel(new ImageIcon(eyeViewImage));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                    }
                    eyeView.setBounds(1, 25, 720, 421);
                }
                else if(wherePlayerLook.equals("south")){
                    BufferedImage eyeViewImage = null;
                    nextBlockX = playerXPosition + 1;
                    lastBlockX = nextBlockX + 1;
                    char near = level.blockLetter(nextBlockX, playerYPosition);
                    char far = level.blockLetter(lastBlockX, playerYPosition);
                    if (near == 'R' && far == 'R'){
                        try {
                            whatUReallyC = ImageIO.read(new File(level.blockPicture(nextBlockX, playerYPosition)));
                            eyeView = new JLabel(new ImageIcon(whatUReallyC));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    else if (near == 'R' && far == 'C'){
                        try {
                            whatUReallyC = ImageIO.read(new File(level.blockFarPicture(lastBlockX, playerYPosition)));
                            eyeView = new JLabel(new ImageIcon(whatUReallyC));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    else if (near == 'R' && far == 'T'){
                        try {
                            whatUReallyC = ImageIO.read(new File(level.blockFarPicture(lastBlockX, playerYPosition)));
                            eyeView = new JLabel(new ImageIcon(whatUReallyC));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    else {
                        try {
                            eyeViewImage = ImageIO.read(new File(level.blockPicture(nextBlockX, playerYPosition)));
                            eyeView = new JLabel(new ImageIcon(eyeViewImage));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                    }
                    eyeView.setBounds(1, 25, 720, 421);
                }

                panel.add(eyeView);
                panel.add(mapLabel);
                panel.updateUI();

                System.out.println("Player X position: " + playerXPosition + " Player Y position: " + playerYPosition);
                System.out.println("Player stand on a " + level.blockName(playerXPosition, playerYPosition));
                System.out.println("Next block on the east " + level.blockName(playerXPosition, playerYPosition + 1));
                System.out.println("Next block on the west " + level.blockName(playerXPosition, playerYPosition - 1));
                System.out.println("Next block on the south " + level.blockName(playerXPosition + 1, playerYPosition));
                System.out.println("Next block on the north " + level.blockName(playerXPosition - 1, playerYPosition));
            }
        }
    }

    public class leftButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int nextY = playerYPosition - 1;
            boolean nextBlockIsBlocked = level.blockIsBlocked(playerXPosition, nextY);
            if (!nextBlockIsBlocked) {
                panel.remove(backgroundLabel);
                panel.remove(mapLabel);
                panel.remove(eyeView);
                panel.updateUI();
                mapX = mapX + 24;
                playerYPosition--;
                mapLabel.setBounds(mapX, mapY, 667, 532);
                panel.add(backgroundLabel);

                int nextBlockX = 0;
                int nextBlockY = 0;
                if (wherePlayerLook.equals("east")){
                    nextBlockY = playerYPosition + 1;
                    BufferedImage eyeViewImage = null;
                    try {
                        eyeViewImage = ImageIO.read(new File(level.blockPicture(playerXPosition, nextBlockY)));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    eyeView = new JLabel(new ImageIcon(eyeViewImage));
                    eyeView.setBounds(1, 25, 720, 421);
                }
                else if(wherePlayerLook.equals("west")){
                    nextBlockY = playerYPosition - 1;
                    BufferedImage eyeViewImage = null;
                    try {
                        eyeViewImage = ImageIO.read(new File(level.blockPicture(playerXPosition, nextBlockY)));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    eyeView = new JLabel(new ImageIcon(eyeViewImage));
                    eyeView.setBounds(1, 25, 720, 421);
                }
                else if(wherePlayerLook.equals("north")){
                    nextBlockX = playerXPosition - 1;
                    BufferedImage eyeViewImage = null;
                    try {
                        eyeViewImage = ImageIO.read(new File(level.blockPicture(nextBlockX, playerYPosition)));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    eyeView = new JLabel(new ImageIcon(eyeViewImage));
                    eyeView.setBounds(1, 25, 720, 421);
                }
                else if(wherePlayerLook.equals("south")){
                    nextBlockX = playerXPosition + 1;
                    BufferedImage eyeViewImage = null;
                    try {
                        eyeViewImage = ImageIO.read(new File(level.blockPicture(nextBlockX, playerYPosition)));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    eyeView = new JLabel(new ImageIcon(eyeViewImage));
                    eyeView.setBounds(1, 25, 720, 421);
                }

                panel.add(eyeView);
                panel.add(mapLabel);
                panel.updateUI();

                System.out.println("Player X position: " + playerXPosition + " Player Y position: " + playerYPosition);
                System.out.println("Player stand on a " + level.blockName(playerXPosition, playerYPosition));
                System.out.println("Next block on the east " + level.blockName(playerXPosition, playerYPosition + 1));
                System.out.println("Next block on the west " + level.blockName(playerXPosition, playerYPosition - 1));
                System.out.println("Next block on the south " + level.blockName(playerXPosition + 1, playerYPosition));
                System.out.println("Next block on the north " + level.blockName(playerXPosition - 1, playerYPosition));
            }
        }
    }

    public class rightButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int nextY = playerYPosition + 1;
            boolean nextBlockIsBlocked = level.blockIsBlocked(playerXPosition, nextY);
            if (!nextBlockIsBlocked) {
                panel.remove(backgroundLabel);
                panel.remove(mapLabel);
                panel.remove(eyeView);
                panel.updateUI();
                mapX = mapX - 24;
                playerYPosition++;
                mapLabel.setBounds(mapX, mapY, 667, 532);
                panel.add(backgroundLabel);

                int nextBlockX = 0;
                int nextBlockY = 0;
                if (wherePlayerLook.equals("east")){
                    nextBlockY = playerYPosition + 1;
                    BufferedImage eyeViewImage = null;
                    try {
                        eyeViewImage = ImageIO.read(new File(level.blockPicture(playerXPosition, nextBlockY)));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    eyeView = new JLabel(new ImageIcon(eyeViewImage));
                    eyeView.setBounds(1, 25, 720, 421);
                }
                else if(wherePlayerLook.equals("west")){
                    nextBlockY = playerYPosition - 1;
                    BufferedImage eyeViewImage = null;
                    try {
                        eyeViewImage = ImageIO.read(new File(level.blockPicture(playerXPosition, nextBlockY)));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    eyeView = new JLabel(new ImageIcon(eyeViewImage));
                    eyeView.setBounds(1, 25, 720, 421);
                }
                else if(wherePlayerLook.equals("north")){
                    nextBlockX = playerXPosition - 1;
                    BufferedImage eyeViewImage = null;
                    try {
                        eyeViewImage = ImageIO.read(new File(level.blockPicture(nextBlockX, playerYPosition)));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    eyeView = new JLabel(new ImageIcon(eyeViewImage));
                    eyeView.setBounds(1, 25, 720, 421);
                }
                else if(wherePlayerLook.equals("south")){
                    nextBlockX = playerXPosition + 1;
                    BufferedImage eyeViewImage = null;
                    try {
                        eyeViewImage = ImageIO.read(new File(level.blockPicture(nextBlockX, playerYPosition)));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    eyeView = new JLabel(new ImageIcon(eyeViewImage));
                    eyeView.setBounds(1, 25, 720, 421);
                }

                panel.add(eyeView);
                panel.add(mapLabel);
                panel.updateUI();

                System.out.println("Player X position: " + playerXPosition + " Player Y position: " + playerYPosition);
                System.out.println("Player stand on a " + level.blockName(playerXPosition, playerYPosition));
                System.out.println("Next block on the east " + level.blockName(playerXPosition, playerYPosition + 1));
                System.out.println("Next block on the west " + level.blockName(playerXPosition, playerYPosition - 1));
                System.out.println("Next block on the south " + level.blockName(playerXPosition + 1, playerYPosition));
                System.out.println("Next block on the north " + level.blockName(playerXPosition - 1, playerYPosition));
            }
        }
    }

    public class bowButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Bow button pressed");
        }
    }

    public class exitButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        counter++;
        System.out.println("Button clicked " + counter + " time");
    }
}