import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {
    private static final int WIDTH = 230;
    private static final int HEIGHT = 350;
    private static String currentWinValue="Установленная длина: ";
    private static String currentFieldValue="Установленный размер поля: ";
    private final GameWindow GameWindow;
    JRadioButton human;
    JRadioButton AI;
    ButtonGroup buttonGroup;
    public JLabel choiceHA;
    JButton btnStart;
    JPanel mainPanel;
    JLabel fieldSize;
    JLabel currentSize;
    JSlider sliderFieldSize;
    JLabel winSize;
    JLabel currentWinSize;
    JSlider sliderWinSize;
    final int minSize = 3;

    SettingWindow(GameWindow gameWindow){
        this.GameWindow = gameWindow;

        sliderFieldSize = new JSlider(minSize,10,minSize);
        sliderWinSize = new JSlider(minSize,10,minSize);

        sliderFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                currentSize.setText(currentFieldValue + sliderFieldSize.getValue());
            }
        });
        sliderWinSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                currentWinSize.setText(currentFieldValue + sliderWinSize.getValue());
            }
        });

        human = new JRadioButton("Человек против Человека");
        AI = new JRadioButton("Человек против Компьютера");
        buttonGroup = new ButtonGroup();
        buttonGroup.add(human);
        buttonGroup.add(AI);

        mainPanel = new JPanel(new GridLayout(7,1));
        choiceHA = new JLabel("Выберите режим игры");
        fieldSize = new JLabel("Выберите размер поля");
        currentSize = new JLabel(currentFieldValue);
        winSize = new JLabel("Выберите длину для победы");
        currentWinSize = new JLabel(currentWinValue + minSize);

        btnStart = new JButton("Start new game");
        setLocationRelativeTo(gameWindow);
        setSize(WIDTH, HEIGHT);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                gameWindow.startNewGame(0, 3, 3, 3);
            }
        });

        mainPanel.add(choiceHA);
        mainPanel.add(AI);
        AI.setSelected(true);
        mainPanel.add(human);
        mainPanel.add(fieldSize);
        mainPanel.add(currentSize);
        mainPanel.add(sliderFieldSize);
        mainPanel.add(currentSize);
        mainPanel.add(winSize);
        mainPanel.add(currentWinSize);
        mainPanel.add(sliderWinSize);
        add(mainPanel);

        add(btnStart, BorderLayout.SOUTH);
    }
}
