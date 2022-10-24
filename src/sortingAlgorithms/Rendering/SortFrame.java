package sortingAlgorithms.Rendering;
import sortingAlgorithms.ISortingAlgorithm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

// Поверхность - наследует JPanel
class Surface extends JPanel implements ActionListener {

    public int[] numbers;
    private int surfaceWidth;
    private int surfaceHeight;
    private int index = 1;

    private Timer timer;

    public Surface(int surfaceWidth, int surfaceHeight)
    {
        this.surfaceWidth = surfaceWidth - 17;
        this.surfaceHeight = surfaceHeight - 38;

        randomizeNumbers(100);

        timer = new Timer(10, this);
        timer.start();
    }

    private void randomizeNumbers(int size)
    {
        numbers = new int[size];

        Random rand = new Random();

        int curNum = 1;
        while (curNum <= size)
        {
            int randIndex = rand.nextInt(0, size);

            if (numbers[randIndex] == 0)
            {
                numbers[randIndex] = curNum;
                curNum++;
            }
        }
    }


    // Отрисовка того, что мы хотим отрисовать
    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.clearRect(0, 0, surfaceWidth, surfaceHeight);

        g2d.setPaint(new Color(255, 232, 155));

        g2d.fillRect(0, 0, surfaceWidth, surfaceHeight);
        drawNumberColumns(g2d);
    }

    private void drawNumberColumns(Graphics2D g2d){
        int startX = 5;
        int endX = surfaceWidth - 5;
        int rectWidth = (endX - startX) / numbers.length;

        int startY = 5;
        int endY = surfaceHeight - 5;
        int rectHeight = endY - startY;
        int rectHeightInc = (int)(rectHeight / (double)numbers.length);

        for (int i = 0; i < numbers.length; i++)
        {
            double percentage = numbers[i] / (double)numbers.length;
            Color recColor = percentToRGB(percentage);

            g2d.setPaint(recColor);

            int startPosX = (i * rectWidth) + startX;
            int curRectHeight = (numbers[i]) * rectHeightInc;
            int startPosY = startY + rectHeight - curRectHeight;

            g2d.fillRect(startPosX, startPosY, rectWidth, curRectHeight);

        }
    }

    private Color percentToRGB(double percent) {
        percent *= 100;

        if (percent == 100) {
            percent = 99;
        }
        int r, g, b;

        if (percent < 50) {
            // green to yellow
            g = (int)Math.floor(255 * (percent / 50));
            r = 255;

        } else {
            // yellow to red
            g = 255;
            r = (int)Math.floor(255 * ((50 - percent % 50) / 50));
        }
        b = 0;

        return new Color(g,r,b);
    }


    private void sort()
    {
        boolean needIteration = true;
        while (needIteration) {
            // итерируем до тех пор, пока не решим что необходимо закончить
            needIteration = false;
            for (; index < numbers.length; index++) {
                // 1 < 1 для исключения массивв в 1 элемен
                if (numbers[index] < numbers[index - 1]) {
                    swap(numbers, index, index - 1);
                    return;
                }
            }
            index = 1;
        }
    }

    public void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }

    // стандартный метод JPanel - переопределяем на наш, где мы рисуем то, что хотим
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        sort();

        repaint();
    }
}

// Окно, в котором отображается сортировка
public class SortFrame extends JFrame {

    private Surface surface;

    private final int SURFACE_WIDTH = 683;
    private final int SURFACE_HEIGHT = 384;

    public SortFrame() {

        surface = new Surface(SURFACE_WIDTH, SURFACE_HEIGHT);
        initUI();
    }

    private void initUI() {

        add(surface);
        // Название окна
        setTitle("Simple Java 2D example");
        // Размер окна
        setSize(SURFACE_WIDTH, SURFACE_HEIGHT);
        setLocationRelativeTo(null);
        // Поведение на закрытии
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void render(int[] numbers)
    {
        surface.numbers = numbers;

        surface.revalidate();
        surface.repaint();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}