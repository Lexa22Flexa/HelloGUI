import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloFrame  extends JFrame{
    private JButton btStart;
    private JPanel panel1;
    private JTextField txtName;

    public HelloFrame() {
        initComponents();
        btStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(btStart, txtName.getText() + " , zdravím tě v GUI!");
            }
        });
        nastavOknoNaStred(this);
        nastavObrazek();
    }

    private void initComponents() {
        setContentPane(panel1); //přiřadit oknu panel s vytvořeným formulářem
        setTitle("Hello GUI"); //titulek okna (lišta nahoře)
        setDefaultCloseOperation(EXIT_ON_CLOSE); //co dělat při zmáčknutí křížku (zavřít)
        //pack();
        //setSize(x, y); => nastavit velikost okna - pack = tak aby se tam všechno vlezlo; setSize = pevně dané rozhraní
        setSize(400, 300);
        //btStart.addActionListener(e -> pozdrav());
        //setBounds(x, y, sirka, vyska); umístí okno na dané pozice a nastaví jeho velikost
    }

    private void pozdrav() {
        JOptionPane.showMessageDialog(this, "Hello GUI!");
    }

    private void nastavOknoNaStred(JFrame frame) {
        GraphicsConfiguration gc = frame.getGraphicsConfiguration();
        Rectangle bounds = gc.getBounds();
        Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(gc);
        Rectangle effectiveScreenArea = new Rectangle();

        effectiveScreenArea.x = bounds.x + screenInsets.left;
        effectiveScreenArea.y = bounds.y + screenInsets.top;
        effectiveScreenArea.height = bounds.height - screenInsets.top - screenInsets.bottom;
        effectiveScreenArea.width = bounds.width - screenInsets.left - screenInsets.right;

        int middleX = effectiveScreenArea.x + (effectiveScreenArea.width - frame.getWidth()) / 2;
        int middleY = effectiveScreenArea.y + (effectiveScreenArea.height - frame.getHeight()) / 2;
        frame.setLocation(middleX, middleY);
    }

    private void nastavObrazek() {
        ImageIcon obr;
        obr = new ImageIcon("resources/andy.jpg");
        btStart.setIcon(obr);
    }

    public void nastaveniTextField() {
        //v konstruktoru můžeme: txtName(int pocetZnaku)
        //txtName.getText(); //vrací text
        txtName.setText("haha nemůžeš nastavit L"); //nastavit text
        txtName.setEditable(false); //jestli do něho může uživatel psát
        txtName.setFont(new java.awt.Font("Lucida Sans", 0, 24)); //nastavit font
        txtName.setHorizontalAlignment(JTextField.CENTER); //zarovnání na střed
        //můžeme nastavit některé paramtry přes grafický nástroj
    }
}
