import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //new instance
        UserRepo userRepo = new UserRepo();
        ArticleRepo articleRepo = new ArticleRepo();
        User user = new User();

        //get console
        user.setUsername(scanner.nextLine());
        user.setPassword(scanner.nextLine());

        // creat menu with jFrame
        JFrame frame = new JFrame("menu");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JButton jButton1 = new JButton("ورود");
        JButton jButton2 = new JButton("ثبت نام");
        JButton jButton3 = new JButton("دیدن مقاله");
        JButton jButton4 = new JButton("خروج");
        panel.add(jButton1);
        panel.add(jButton2);
        panel.add(jButton3);
        panel.add(jButton4);
        frame.add(panel);
        frame.setSize(200, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    if (userRepo.findByUserName(user)) {
                        JButton jButton1 = new JButton("دیدن مقالها");
                        JButton jButton2 = new JButton("ویرایش مقاله");
                        JButton jButton3 = new JButton("مقاله جدید");
                        panel.add(jButton1);
                        panel.add(jButton2);
                        panel.add(jButton3);
                        frame.add(panel);
                        frame.setSize(200, 300);
                        frame.setLocationRelativeTo(null);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setVisible(true);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    userRepo.userInsert(user);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    articleRepo.getAllArticle();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);

            }
        });

    }
}

