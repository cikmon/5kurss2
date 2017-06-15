package sample;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Controller123 {
    public TextField namesform;
    public TextField widthform;
    public TextField haightform;
    public ComboBox<String> combobox1;
    public ComboBox<String> combobox2;
    public ComboBox<String> combobox3;
    public ComboBox<String> combobox4;
    public TextField coordYform;
    public TextField coordXform;
    public TextField angleform;

    private int WrazmerKorpusa = 0;
    private int HrazmerKorpusa = 0;
    private int LrazmerKorpusa = 0;
    private int ThicknessRrazmerKorpusa = 0;

    private Bd[] bd;
    private Ploskosti[] osnovnoi;
    private Ploskosti[] ryadom;
    private Ploskosti[] ostalnie;


    private int kolvosnaclonom = 0;

    int n = 0;
    int nustnovl = 0;
    int ploskostpostr = 0;


    private JFXPanel primaryStage;
    private ObservableList<String> list = FXCollections.observableArrayList("Cоздание обьекта №1");
    private ObservableList<String> list2 = FXCollections.observableArrayList("свободное размещение");
    private ObservableList<String> list3 = FXCollections.observableArrayList("Передняя", "Задняя", "Слева", "Справа", "Нижняя", "Верхняя");

    @FXML
    private void handleExit() {
        System.exit(0);
    }

    @FXML

    private void handleOpen() throws IOException {
        //String fileName = "/Users/prologistic/source.txt";
        // readUsingFiles(fileName);
        String[] open1 = new String[10000];
        String[][] openrazb = new String[10000][15];
        int rrr = 0;
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();
            FileReader fr = new FileReader(file);

            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                open1[rrr] = line;
                // считываем остальные строки в цикле
                line = reader.readLine();

                rrr++;
            }
            fr.close();
        }


        for (int i = 0; i < rrr; i++) openrazb[i] = (open1[i]).split(";");

        WrazmerKorpusa = Integer.parseInt(openrazb[1][0]);
        HrazmerKorpusa = Integer.parseInt(openrazb[1][1]);
        LrazmerKorpusa = Integer.parseInt(openrazb[1][2]);
        ThicknessRrazmerKorpusa = Integer.parseInt(openrazb[1][3]);

        n = rrr - 3;
        bd = new Bd[n];
        osnovnoi = new Ploskosti[n];
        for (int i = 3; i < rrr; i++) {
            int mmm[] = new int[7];
            if (openrazb[i][4].trim().length() == 0) mmm[0] = -1000;
            else mmm[0] = Integer.parseInt(openrazb[i][4]);
            if (openrazb[i][5].trim().length() == 0) mmm[1] = -1000;
            else mmm[1] = Integer.parseInt(openrazb[i][5]);
            if (openrazb[i][6].trim().length() == 0) mmm[2] = -1000;
            else mmm[2] = Integer.parseInt(openrazb[i][6]);
            if (openrazb[i][7].trim().length() == 0) mmm[3] = -1000;
            else mmm[3] = Integer.parseInt(openrazb[i][7]);
            if (openrazb[i][8].trim().length() == 0) mmm[4] = 0;
            else mmm[4] = Integer.parseInt(openrazb[i][8]);
            if (openrazb[i][9].trim().length() == 0) mmm[5] = 0;
            else mmm[5] = Integer.parseInt(openrazb[i][9]);
            if (openrazb[i][10].trim().length() == 0) mmm[6] = 0;
            else mmm[6] = Integer.parseInt(openrazb[i][10]);

            try {
                bd[i - 3] = new Bd("№" + (i - 2) + " " + openrazb[i][0], Integer.parseInt(openrazb[i][1]),
                        Integer.parseInt(openrazb[i][2]), Integer.parseInt(openrazb[i][3]), mmm[0],
                        mmm[1], mmm[2], mmm[3], mmm[4], mmm[5], mmm[6]);
            } catch (NumberFormatException e) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText("Неверный формат строк!");
                alert.showAndWait();
            }
        }

        combobox4.setItems(list3);
        combobox4.getSelectionModel().select(ploskostpostr);


        System.out.println(n);


        combobox4.getSelectionModel().selectedIndexProperty().
                addListener((ObservableValue<? extends Number> ov4, Number old_val4, Number new_val4) -> {
                    ploskostpostr = new_val4.intValue();
                });


        for (int i = 0; i < bd.length; i++)
            System.out.println(bd[i].names() + " " + bd[i].width() + " " + bd[i].haight() + " " + bd[i].length() + " " + bd[i].coordX() + " " +
                    bd[i].coordY() + " " + bd[i].coordZ() + " " + bd[i].ryadom() + " " + bd[i].angleX() + " " + bd[i].angleY());


        System.out.println("ok");

    }

    @FXML
    private void handleAbout() {
        Alert alert = new Alert(AlertType.INFORMATION);
        //alert.setTitle("AddressApp");
        // alert.setHeaderText("About");
        // alert.setContentText("Author: Marco Jakob\nWebsite: http://code.makery.ch");
        alert.showAndWait();
    }

    @FXML
    private void handleSave() {
    }


    @FXML
    private void handleLocaterazmesh() throws IOException {
        //  metodrazmesh(); metodproverka();
        //  metodrazmeshryadom();
        //  metodrazmeshostaln();
        //metodrazmeshangletochki();
        //metodrazmeshanglepixels();
        //metodproverkaustanovl();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText("Расчеты завершились.");
        alert.showAndWait();

        System.out.println("t1 X=" + osnovnoi[0].poluchtochka1(0) + " Y" + osnovnoi[0].poluchtochka1(1) + " Z" + osnovnoi[0].poluchtochka1(2));
        System.out.println("t2 X=" + osnovnoi[0].poluchtochka2(0) + " Y" + osnovnoi[0].poluchtochka2(1) + " Z" + osnovnoi[0].poluchtochka2(2));
        System.out.println("t3 X=" + osnovnoi[0].poluchtochka3(0) + " Y" + osnovnoi[0].poluchtochka3(1) + " Z" + osnovnoi[0].poluchtochka3(2));
        System.out.println("t4 X=" + osnovnoi[0].poluchtochka4(0) + " Y" + osnovnoi[0].poluchtochka4(1) + " Z" + osnovnoi[0].poluchtochka4(2));
        System.out.println("t5 X=" + osnovnoi[0].poluchtochka5(0) + " Y" + osnovnoi[0].poluchtochka5(1) + " Z" + osnovnoi[0].poluchtochka5(2));
        System.out.println("t6 X=" + osnovnoi[0].poluchtochka6(0) + " Y" + osnovnoi[0].poluchtochka6(1) + " Z" + osnovnoi[0].poluchtochka6(2));
        System.out.println("t7 X=" + osnovnoi[0].poluchtochka7(0) + " Y" + osnovnoi[0].poluchtochka7(1) + " Z" + osnovnoi[0].poluchtochka7(2));
        System.out.println("t8 X=" + osnovnoi[0].poluchtochka8(0) + " Y" + osnovnoi[0].poluchtochka8(1) + " Z" + osnovnoi[0].poluchtochka8(2));


        osnovnoi[0].lengthpix();
        metodotobrathpix();
        System.out.println("leng1  " + osnovnoi[0].lengthpix() + ";leng2 " + osnovnoi[0].lengthpix2() + ";leng3 " + osnovnoi[0].lengthpix3()
                + ";leng4 " + osnovnoi[0].lengthpix4() + ";leng5 " + osnovnoi[0].lengthpix5() + ";leng6 " + osnovnoi[0].lengthpix6());
        //System.out.println(" 1p"+osnovnoi[0].lengthpix2()+" 6p"+osnovnoi[0].lengthpix3());
        System.out.println("ok");
    }


    public void metodrazmeshangletochki() {
        for (int i = 0; i < bd.length; i++) {
            if (bd[i].angleX() != 0 || bd[i].angleY() != 0 || bd[i].angleZ() != 0) {
                double t1[] = new double[3], t2[] = new double[3], t3[] = new double[3], t4[] = new double[3],
                        t5[] = new double[3], t6[] = new double[3], t7[] = new double[3], t8[] = new double[3];
                kolvosnaclonom++;
                nustnovl++;
                osnovnoi[i] = new Ploskosti(bd[i].names(), bd[i].width(), bd[i].haight(), bd[i].length(), bd[i].coordX(), bd[i].coordY(), bd[i].coordZ(),
                        bd[i].angleX(), bd[i].angleY(), bd[i].angleZ());
                if (bd[i].angleX() != 0) {


                    double ddd = Math.sqrt(Math.pow(osnovnoi[i].width(), 2) + Math.pow(osnovnoi[i].haight(), 2));
                    double ugol = Math.toDegrees(Math.asin(osnovnoi[i].width() / ddd)) - osnovnoi[i].angleX();
                    t1[0] = osnovnoi[i].coordX();
                    t1[1] = osnovnoi[i].coordY();
                    t1[2] = osnovnoi[i].coordZ();
                    t2[0] = t1[0] - osnovnoi[i].haight() * Math.cos(Math.toRadians(90 - osnovnoi[i].angleX()));
                    t2[1] = t1[1] + osnovnoi[i].haight() * Math.sin(Math.toRadians(90 - osnovnoi[i].angleX()));
                    t2[2] = t1[2];
                    t3[0] = t1[0] + osnovnoi[i].width() * Math.cos(Math.toRadians(osnovnoi[i].angleX()));
                    t3[1] = t1[1] + osnovnoi[i].width() * Math.sin(Math.toRadians(osnovnoi[i].angleX()));
                    t3[2] = t1[2];
                    if (ugol > 0) {
                        t4[0] = t1[0] + osnovnoi[i].haight() * Math.cos(Math.toRadians(90 - osnovnoi[i].angleY()));
                        t4[1] = t1[1] + osnovnoi[i].haight() * Math.sin(Math.toRadians(90 - osnovnoi[i].angleY()));
                        t4[2] = t1[2];
                    } else {
                        t4[0] = t1[0] - osnovnoi[i].haight() * Math.cos(Math.toRadians(90 - osnovnoi[i].angleX()));
                        t4[1] = t1[1] + osnovnoi[i].haight() * Math.sin(Math.toRadians(90 - osnovnoi[i].angleX()));
                        t4[2] = t1[2];
                    }
                    t4[0] = t3[0] - osnovnoi[i].haight() * Math.cos(Math.toRadians(90 - osnovnoi[i].angleX()));
                    t4[1] = t3[1] + osnovnoi[i].haight() * Math.sin(Math.toRadians(90 - osnovnoi[i].angleX()));
                    t4[2] = t1[2];
                    t5[0] = t1[0];
                    t5[1] = t1[1];
                    t5[2] = t1[2] + osnovnoi[i].lenght();
                    t6[0] = t2[0];
                    t6[1] = t2[1];
                    t6[2] = t2[2] + osnovnoi[i].lenght();
                    t7[0] = t3[0];
                    t7[1] = t3[1];
                    t7[2] = t3[2] + osnovnoi[i].lenght();
                    t8[0] = t4[0];
                    t8[1] = t4[1];
                    t8[2] = t4[2] + osnovnoi[i].lenght();
                } else if (osnovnoi[i].angleY() != 0) {
                    double ddd = Math.sqrt(Math.pow(osnovnoi[i].lenght(), 2) + Math.pow(osnovnoi[i].haight(), 2));
                    double ugol = 90 - Math.toDegrees(Math.asin(osnovnoi[i].haight() / ddd)) - osnovnoi[i].angleY();

                    t1[0] = osnovnoi[i].coordX();
                    t1[1] = osnovnoi[i].coordY();
                    t1[2] = osnovnoi[i].coordZ();
                    t2[0] = t1[0];
                    t2[1] = t1[1] + osnovnoi[i].haight() * Math.sin(Math.toRadians(90 - osnovnoi[i].angleY()));
                    t2[2] = t1[2] - osnovnoi[i].haight() * Math.cos(Math.toRadians(90 - osnovnoi[i].angleY()));
                    t3[0] = t1[0] + osnovnoi[i].width();
                    t3[1] = t1[1];
                    t3[2] = t1[2];
                    t4[0] = t3[0];
                    t4[1] = t2[1];
                    t4[2] = t2[2];
                    t5[0] = t1[0];
                    t5[1] = t1[1] + osnovnoi[i].lenght() * Math.sin(Math.toRadians(osnovnoi[i].angleY()));
                    t5[2] = t1[2] + osnovnoi[i].lenght() * Math.cos(Math.toRadians(osnovnoi[i].angleY()));
                    if (ugol > 0) {
                        t6[0] = t1[0];
                        t6[1] = t1[1] + ddd * Math.sin(Math.toRadians(Math.toDegrees(Math.asin(osnovnoi[i].haight() / ddd)) + osnovnoi[i].angleY()));
                        t6[2] = t1[2] + ddd * Math.cos(Math.toRadians(Math.toDegrees(Math.asin(osnovnoi[i].haight() / ddd)) + osnovnoi[i].angleY()));
                    } else {
                        t6[0] = t1[0];
                        t6[1] = t1[1] + ddd * Math.sin(Math.toRadians(Math.toDegrees(Math.asin(osnovnoi[i].haight() / ddd)) + osnovnoi[i].angleY()));
                        t6[2] = t1[2] + ddd * Math.cos(Math.toRadians(Math.toDegrees(Math.asin(osnovnoi[i].haight() / ddd)) + osnovnoi[i].angleY()));
                    }
                    t7[0] = t3[0];
                    t7[1] = t3[1] + osnovnoi[i].lenght() * Math.sin(Math.toRadians(osnovnoi[i].angleY()));
                    t7[2] = t1[2] + osnovnoi[i].lenght() * Math.cos(Math.toRadians(osnovnoi[i].angleY()));
                    t8[0] = t3[0];
                    t8[1] = t6[1];
                    t8[2] = t6[2];

                } else if (osnovnoi[i].angleZ() != 0) {
                    t1[0] = osnovnoi[i].coordX();
                    t1[1] = osnovnoi[i].coordY();
                    t1[2] = osnovnoi[i].coordZ();
                    double ddd = Math.sqrt(Math.pow(osnovnoi[i].lenght(), 2) + Math.pow(osnovnoi[i].width(), 2));
                    double ugol = 90 - Math.toDegrees(Math.asin(osnovnoi[i].width() / ddd)) - osnovnoi[i].angleZ();
                    t2[0] = t1[0];
                    t2[1] = t1[1] + osnovnoi[i].haight();
                    t2[2] = t1[2];
                    t3[0] = t1[0] + osnovnoi[i].width() * Math.sin(Math.toRadians(osnovnoi[i].angleZ()));
                    t3[1] = t1[1];
                    t3[2] = t1[2] + osnovnoi[i].width() * Math.cos(Math.toRadians(osnovnoi[i].angleZ()));
                    t4[0] = t3[0];
                    t4[1] = t2[1];
                    t4[2] = t3[2];
                    t5[0] = t1[0] - osnovnoi[i].lenght() * Math.sin(Math.toRadians(osnovnoi[i].angleZ()));
                    t5[1] = t1[1];
                    t5[2] = t1[2] + osnovnoi[i].lenght() * Math.cos(Math.toRadians(osnovnoi[i].angleZ()));
                    t6[0] = t5[0];
                    t6[1] = t2[1];
                    t6[2] = t5[2];

                    if (ugol > 0) {
                        t7[0] = t1[0] + ddd * Math.cos(Math.toRadians(Math.toDegrees(Math.asin(osnovnoi[i].lenght() / ddd)) + osnovnoi[i].angleZ()));
                        t7[1] = t1[1];
                        t7[2] = t1[2] + ddd * Math.sin(Math.toRadians(Math.toDegrees(Math.asin(osnovnoi[i].lenght() / ddd)) + osnovnoi[i].angleZ()));
                    } else {
                        t7[0] = t1[0] + ddd * Math.cos(Math.toRadians(Math.toDegrees(Math.asin(osnovnoi[i].lenght() / ddd)) + osnovnoi[i].angleZ()));
                        t7[1] = t1[1];
                        t7[2] = t1[2] + ddd * Math.sin(Math.toRadians(Math.toDegrees(Math.asin(osnovnoi[i].lenght() / ddd)) + osnovnoi[i].angleZ()));
                    }
                    t8[0] = t7[0];
                    t8[1] = t2[1];
                    t8[2] = t7[2];

                }
                osnovnoi[i].osntochkidobavl(t1, t2, t3, t4, t5, t6, t7, t8);
            }
        }

    }

    private void metodrazmeshanglepixels() {
        for (int i = 0; i < kolvosnaclonom; i++) {
            int t1[] = new int[3];
            int t3[] = new int[3];
            int t2[] = new int[3];
            int t4[] = new int[3];
            int t7[] = new int[3];
            int t5[] = new int[3];
            int t6[] = new int[3];
            int t8[] = new int[3];
            t1[0] = (int) Math.round(osnovnoi[i].poluchtochka1(0));
            t1[1] = (int) Math.round(osnovnoi[i].poluchtochka1(1));
            t1[2] = (int) Math.round(osnovnoi[i].poluchtochka1(2));
            t2[0] = (int) Math.round(osnovnoi[i].poluchtochka2(0));
            t2[1] = (int) Math.round(osnovnoi[i].poluchtochka2(1));
            t2[2] = (int) Math.round(osnovnoi[i].poluchtochka2(2));
            t3[0] = (int) Math.round(osnovnoi[i].poluchtochka3(0));
            t3[1] = (int) Math.round(osnovnoi[i].poluchtochka3(1));
            t3[2] = (int) Math.round(osnovnoi[i].poluchtochka3(2));
            t4[0] = (int) Math.round(osnovnoi[i].poluchtochka4(0));
            t4[1] = (int) Math.round(osnovnoi[i].poluchtochka4(1));
            t4[2] = (int) Math.round(osnovnoi[i].poluchtochka4(2));
            t5[0] = (int) Math.round(osnovnoi[i].poluchtochka5(0));
            t5[1] = (int) Math.round(osnovnoi[i].poluchtochka5(1));
            t5[2] = (int) Math.round(osnovnoi[i].poluchtochka5(2));
            t7[0] = (int) Math.round(osnovnoi[i].poluchtochka7(0));
            t7[1] = (int) Math.round(osnovnoi[i].poluchtochka7(1));
            t7[2] = (int) Math.round(osnovnoi[i].poluchtochka7(2));
            t6[0] = (int) Math.round(osnovnoi[i].poluchtochka6(0));
            t6[1] = (int) Math.round(osnovnoi[i].poluchtochka6(1));
            t6[2] = (int) Math.round(osnovnoi[i].poluchtochka6(2));
            t8[0] = (int) Math.round(osnovnoi[i].poluchtochka8(0));
            t8[1] = (int) Math.round(osnovnoi[i].poluchtochka8(1));
            t8[2] = (int) Math.round(osnovnoi[i].poluchtochka8(2));
            if (osnovnoi[i].angleX() != 0) {
///первая плоскость

                if (Math.pow((t3[0] - t1[0]), 2) >= Math.pow((t3[1] - t1[1]), 2)) {

//по х+
                    for (int j = t1[0]; j <= t3[0]; ) {


                        int tn[] = new int[3];
                        int tk[] = new int[3];
                        double rt = t2[0];
                        double rr = t1[0];
                        tn[0] = j;
                        tn[2] = t1[2];
                        tn[1] = (int) ((tn[0] - rr) / (t3[0] - rr) * (t3[1] - t1[1]) + t1[1]);

                        tk[0] = t2[0] - t1[0] + tn[0];
                        tk[2] = t1[2];
                        tk[1] = (int) Math.round((tk[0] - rt) / (t4[0] - rt) * (t4[1] - t2[1]) + t2[1]);
                        //по у

                        for (int k = tn[1]; k <= tk[1]; ) {
                            short x, y, z = (short) tn[2];
                            y = (short) k;
                            x = (short) ((k - tn[1]) / (tk[1] - tn[1]) * (tk[0] - tn[0]) + tn[0]);

                            osnovnoi[i].dobavlpixels(x, y, z);

                            int r = k + (int) (Math.random() * 6);
                            k = r < tk[1] ? r : k == tk[1] ? k + 1 : tk[1];
                        }

                        int r = j + (int) (Math.random() * 6);
                        j = r < t3[0] ? r : j == t3[0] ? j + 1 : t3[0];
                    }

                } else {
                    for (int j = t1[1]; j <= t3[1]; ) {

                        int tt1[] = new int[3];
                        int tt2[] = new int[3];
                        double rt = t2[1];
                        double rr = t1[1];
                        tt1[1] = j;
                        tt1[2] = t1[2];
                        tt1[0] = (int) ((tt1[1] - rr) / (t3[1] - rr) * (t3[0] - t1[0]) + t1[0]);

                        tt2[1] = t2[1] - t1[1] + tt1[1];
                        tt2[2] = t1[2];
                        tt2[0] = (int) ((tt2[1] - rt) / (t4[1] - rt) * (t4[0] - t2[0]) + t2[0]);
                        //по x

                        for (int k = tt2[0]; k <= tt1[0]; ) {
                            short x, y, z = (short) tt1[2];
                            x = (short) k;
                            y = (short) ((k - tt1[0]) / (tt2[0] - tt1[0]) * (tt2[1] - tt1[1]) + tt1[1]);

                            osnovnoi[i].dobavlpixels(x, y, z);
                            int r = k + (int) (Math.random() * 6);

                            k = r < tt1[0] ? r : k == tt1[0] ? k + 1 : tt1[0];


                        }
                        int r = j + (int) (Math.random() * 6);
                        j = r < t3[1] ? r : j == t3[1] ? j + 1 : t3[1];

                    }


                }
                //sixth plane

                for (int i1 = 0; i1 < osnovnoi[i].lengthpix(); i1++) {
                    osnovnoi[i].dobavlpixels6(osnovnoi[i].pixels(0, i1), osnovnoi[i].pixels(1, i1),
                            (short) (osnovnoi[i].pixels(2, i1) + osnovnoi[i].lenght()));
                }

                //третья плоскость+

                for (int j = t3[2]; j <= t7[2]; ) {
                    double[] tn = new double[3];
                    int[] tk = new int[3];
                    tn[0] = t4[0];
                    tn[1] = t4[1];
                    tn[2] = j;
                    tk[0] = t3[0];
                    tk[1] = t3[1];
                    tk[2] = j;
                    if (Math.pow((t4[0]) - t3[0], 2) > Math.pow((t4[1] - t3[1]), 2)) {

                        for (int k = t4[0]; k <= t3[0]; ) {
                            short x, y, z;
                            x = (short) k;
                            y = (short) ((k - tn[0]) / (tk[0] - tn[0]) * (tk[1] - tn[1]) + tn[1]);
                            z = (short) j;
                            osnovnoi[i].dobavlpixels3(x, y, z);

                            int r = k + (int) (Math.random() * 6);
                            k = r < t3[0] ? r : k == t3[0] ? k + 1 : t3[0];
                        }


                    } else {
                        for (int k = t3[1]; k <= t4[1]; ) {
                            short x, y, z;
                            x = (short) ((k - tn[1]) / (tk[1] - tn[1]) * (tk[0] - tn[0]) + tn[0]);
                            y = (short) k;
                            z = (short) j;

                            osnovnoi[i].dobavlpixels3(x, y, z);
                            int r = k + (int) (Math.random() * 6);
                            k = r < t4[1] ? r : k == t4[1] ? k + 1 : t4[1];

                        }
                    }
                    int r = j + (int) (Math.random() * 6);
                    j = r < t7[2] ? r : j == t7[2] ? j + 1 : t7[2];
                }

                // вторая плоскость+
                for (int j = t3[2]; j <= t7[2]; ) {
                    double[] tn = new double[3];
                    int[] tk = new int[3];
                    tn[0] = t1[0];
                    tn[1] = t1[1];
                    tn[2] = j;
                    tk[0] = t2[0];
                    tk[1] = t2[1];
                    tk[2] = j;
                    if (Math.pow((t4[0]) - t3[0], 2) > Math.pow((t4[1] - t3[1]), 2)) {
                        for (int k = t2[0]; k <= t1[0]; k++) {
                            short x, y, z;
                            x = (short) k;
                            y = (short) ((k - tn[0]) / (tk[0] - tn[0]) * (tk[1] - tn[1]) + tn[1]);
                            z = (short) j;
                            osnovnoi[i].dobavlpixels2(x, y, z);
                            int r = k + (int) (Math.random() * 6);
                            k = r < t1[0] ? r : k == t1[0] ? k + 1 : t1[0];
                        }
                    } else {
                        for (int k = t1[1]; k <= t2[1]; ) {
                            short x, y, z;
                            x = (short) ((k - tn[1]) / (tk[1] - tn[1]) * (tk[0] - tn[0]) + tn[0]);
                            y = (short) k;
                            z = (short) j;

                            osnovnoi[i].dobavlpixels2(x, y, z);
                            int r = k + (int) (Math.random() * 6);
                            k = r < t2[1] ? r : k == t2[1] ? k + 1 : t2[1];
                        }
                    }
                    int r = j + (int) (Math.random() * 6);
                    j = r < t7[2] ? r : j == t7[2] ? j + 1 : t7[2];
                }
                //fourth plane+
                for (int j = t3[2]; j <= t7[2]; ) {
                    double[] tn = new double[3];
                    int[] tk = new int[3];
                    tn[0] = t2[0];
                    tn[1] = t2[1];
                    tn[2] = j;
                    tk[0] = t4[0];
                    tk[1] = t4[1];
                    tk[2] = j;
                    if (Math.pow((t4[0]) - t2[0], 2) >= Math.pow((t4[1] - t2[1]), 2)) {
                        for (int k = t2[0]; k <= t4[0]; ) {
                            short x, y, z;
                            x = (short) k;
                            y = (short) ((k - tn[0]) / (tk[0] - tn[0]) * (tk[1] - tn[1]) + tn[1]);
                            z = (short) j;
                            osnovnoi[i].dobavlpixels4(x, y, z);
                            int r = k + (int) (Math.random() * 6);
                            k = r < t4[0] ? r : k == t4[0] ? k + 1 : t4[0];
                        }
                    } else {
                        for (int k = t2[1]; k <= t4[1]; ) {
                            short x, y, z;
                            x = (short) ((k - tn[1]) / (tk[1] - tn[1]) * (tk[0] - tn[0]) + tn[0]);
                            y = (short) k;
                            z = (short) j;

                            osnovnoi[i].dobavlpixels4(x, y, z);
                            int r = k + (int) (Math.random() * 6);
                            k = r < t4[1] ? r : k == t4[1] ? k + 1 : t4[1];

                        }
                    }
                    int r = j + (int) (Math.random() * 6);
                    j = r < t7[2] ? r : j == t7[2] ? j + 1 : t7[2];
                }
                //fifth plane+
                for (int j = t3[2]; j <= t7[2]; ) {
                    double[] tn = new double[3];
                    int[] tk = new int[3];
                    tn[0] = t1[0];
                    tn[1] = t1[1];
                    tn[2] = j;
                    tk[0] = t3[0];
                    tk[1] = t3[1];
                    tk[2] = j;
                    if (Math.pow((t4[0]) - t2[0], 2) > Math.pow((t4[1] - t2[1]), 2)) {
                        for (int k = t1[0]; k <= t3[0]; ) {
                            short x, y, z;
                            x = (short) k;
                            y = (short) ((k - tn[0]) / (tk[0] - tn[0]) * (tk[1] - tn[1]) + tn[1]);
                            z = (short) j;
                            osnovnoi[i].dobavlpixels5(x, y, z);
                            int r = k + (int) (Math.random() * 6);
                            k = r < t3[0] ? r : k == t3[0] ? k + 1 : t3[0];
                        }
                    } else {
                        for (int k = t1[1]; k <= t3[1]; ) {
                            short x, y, z;
                            x = (short) ((k - tn[1]) / (tk[1] - tn[1]) * (tk[0] - tn[0]) + tn[0]);
                            y = (short) k;
                            z = (short) j;

                            osnovnoi[i].dobavlpixels5(x, y, z);
                            int r = k + (int) (Math.random() * 6);
                            k = r < t3[1] ? r : k == t3[1] ? k + 1 : t3[1];

                        }
                    }
                    int r = j + (int) (Math.random() * 6);
                    j = r < t7[2] ? r : j == t7[2] ? j + 1 : t7[2];
                }


            } else if (osnovnoi[i].angleY() != 0) {

                // first plane
                for (int j = t1[0]; j <= t3[0]; ) {
                    double[] tn = new double[3];
                    int[] tk = new int[3];
                    tn[0] = j;
                    tn[1] = t1[1];
                    tn[2] = t1[2];
                    tk[0] = j;
                    tk[1] = t2[1];
                    tk[2] = t2[2];
                    if (Math.pow((t1[2]) - t2[2], 2) < Math.pow((t1[1] - t2[1]), 2)) {
                        for (int k = t1[1]; k <= t2[1]; ) {
                            short x, y, z;
                            x = (short) j;
                            y = (short) k;
                            z = (short) ((k - tn[1]) / (tk[1] - tn[1]) * (tk[0] - tn[0]) + tn[0]);
                            osnovnoi[i].dobavlpixels(x, y, z);
                            int r = k + (int) (Math.random() * 6);
                            k = r < t2[1] ? r : k == t2[1] ? k + 1 : t2[1];
                        }
                    } else {
                        for (int k = t2[2]; k <= t1[2]; ) {
                            short x, y, z;
                            x = (short) j;
                            y = (short) ((k - tn[2]) / (tk[2] - tn[2]) * (tk[1] - tn[1]) + tn[1]);
                            z = (short) k;

                            osnovnoi[i].dobavlpixels(x, y, z);
                            int r = k + (int) (Math.random() * 6);
                            k = r < t1[2] ? r : k == t1[2] ? k + 1 : t1[2];

                        }
                    }
                    int r = j + (int) (Math.random() * 6);
                    j = r < t3[0] ? r : j == t3[0] ? j + 1 : t3[0];
                }

                // sixth plane
                for (int j = t1[0]; j <= t3[0]; ) {
                    double[] tn = new double[3];
                    int[] tk = new int[3];
                    tn[0] = j;
                    tn[1] = t5[1];
                    tn[2] = t5[2];
                    tk[0] = j;
                    tk[1] = t6[1];
                    tk[2] = t6[2];
                    if (Math.pow((t6[2]) - t5[2], 2) < Math.pow((t6[1] - t5[1]), 2)) {
                        for (int k = t5[1]; k <= t6[1]; ) {
                            short x, y, z;
                            x = (short) j;
                            y = (short) k;
                            z = (short) ((k - tn[1]) / (tk[1] - tn[1]) * (tk[0] - tn[0]) + tn[0]);
                            osnovnoi[i].dobavlpixels6(x, y, z);
                            int r = k + (int) (Math.random() * 6);
                            k = r < t6[1] ? r : k == t6[1] ? k + 1 : t6[1];
                        }
                    } else {
                        for (int k = t6[2]; k <= t5[2]; ) {
                            short x, y, z;
                            x = (short) j;
                            y = (short) ((k - tn[2]) / (tk[2] - tn[2]) * (tk[1] - tn[1]) + tn[1]);
                            z = (short) k;

                            osnovnoi[i].dobavlpixels6(x, y, z);
                            int r = k + (int) (Math.random() * 6);
                            k = r < t5[2] ? r : k == t5[2] ? k + 1 : t5[2];

                        }
                    }
                    int r = j + (int) (Math.random() * 6);
                    j = r < t3[0] ? r : j == t3[0] ? j + 1 : t3[0];
                }
                ////// second and third plane++

                if (Math.pow((t1[1]) - t2[1], 2) >= Math.pow((t1[2] - t2[2]), 2)) {
                    for (int j = t1[1]; j <= t2[1]; ) {
                        int[] tn = new int[3];
                        double t11 = t1[1];
                        double t51 = t5[1];
                        int[] tk = new int[3];
                        tn[0] = t1[0];
                        tn[1] = j;
                        tn[2] = (int) ((j - t11) / (t2[1] - t11) * (t2[2] - t1[2]) + t1[2]);
                        tk[0] = t1[0];
                        tk[1] = (t5[1] - t1[1] + j);
                        tk[2] = (int) ((tk[1] - t51) / (t6[1] - t51) * (t6[2] - t5[2]) + t5[2]);
                        for (int k = tn[2]; k <= tk[2]; ) {
                            short x, y, z;
                            double tn2 = tn[2];
                            x = (short) t1[0];
                            y = (short) ((k - tn2) / (tk[2] - tn2) * (tk[1] - tn[1]) + tn[1]);
                            z = (short) k;
                            osnovnoi[i].dobavlpixels2(x, y, z);
                            osnovnoi[i].dobavlpixels3((short) (x + osnovnoi[i].width()), y, z);
                            int r = k + (int) (Math.random() * 6);
                            k = r < tk[2] ? r : k == tk[2] ? k + 1 : tk[2];
                        }
                        int r = j + (int) (Math.random() * 6);
                        j = r < t2[1] ? r : j == t2[1] ? j + 1 : t2[1];
                    }
                } else {
                    for (int j = t1[2]; j <= t5[2]; ) {
                        int[] tn = new int[3];
                        int[] tk = new int[3];
                        double t22 = t2[2];
                        double t12 = t1[2];
                        tn[0] = t1[0];
                        tn[1] = (short) ((j - t12) / (t5[2] - t12) * (t5[1] - t1[1]) + t1[1]);
                        tn[2] = j;
                        tk[0] = t1[0];
                        tk[2] = t2[2] - t1[2] + j;
                        tk[1] = (int) ((tk[2] - t22) / (t6[2] - t22) * (t6[1] - t2[1]) + t2[1]);

                        for (int k = tn[1]; k <= tk[1]; ) {
                            short x, y, z;
                            x = (short) t1[0];
                            y = (short) k;
                            double rn = tn[1];
                            z = (short) ((k - rn) / (tk[1] - rn) * (tk[2] - tn[2]) + tn[2]);

                            osnovnoi[i].dobavlpixels2(x, y, z);
                            osnovnoi[i].dobavlpixels3((short) (x + osnovnoi[i].width()), y, z);
                            int r = k + (int) (Math.random() * 6);
                            k = r < tk[1] ? r : k == tk[1] ? k + 1 : tk[1];
                        }
                        int r = j + (int) (Math.random() * 6);
                        j = r < t5[2] ? r : j == t5[2] ? j + 1 : t5[2];
                    }
                }


                //fourth++

                for (int j = t1[0]; j <= t3[0]; ) {
                    double[] tn = new double[3];
                    int[] tk = new int[3];
                    double t31 = t3[1];
                    double t32 = t3[2];
                    tn[0] = t1[0];
                    tn[1] = t1[1];
                    tn[2] = j;
                    tk[0] = t3[0];
                    tk[1] = t3[1];
                    //tk[2]=j;
                    if (Math.pow((t4[0]) - t3[0], 2) >= Math.pow((t4[1] - t3[1]), 2)) {

                        for (int k = t1[2]; k <= t5[2]; ) {
                            short x, y, z;

                            x = (short) j;
                            y = (short) ((k - t32) / (t7[2] - t32) * (t7[1] - t3[1]) + t3[1]);
                            z = (short) k;
                            osnovnoi[i].dobavlpixels4(x, y, z);
                            int r = k + (int) (Math.random() * 6);
                            k = r < t5[2] ? r : k == t5[2] ? k + 1 : t5[2];


                        }

                    } else {
                        for (int k = t3[1]; k <= t7[1]; k++) {
                            short x, y, z;
                            x = (short) j;
                            y = (short) k;
                            z = (short) ((k - t31) / (t8[1] - t31) * (t7[2] - t3[2]) + t3[2]);

                            osnovnoi[i].dobavlpixels4(x, y, z);
                            int r = k + (int) (Math.random() * 6);
                            k = r < t7[1] ? r : k == t7[1] ? k + 1 : t7[1];

                        }
                    }
                    int r = j + (int) (Math.random() * 6);
                    j = r < t3[0] ? r : j == t3[0] ? j + 1 : t3[0];
                }

                // fihth
                for (int j = t1[0]; j <= t3[0]; ) {
                    double[] tn = new double[3];
                    int[] tk = new int[3];
                    double t31 = t3[1];
                    double t32 = t4[2];
                    tn[0] = t1[0];
                    tn[1] = t1[1];
                    tn[2] = j;
                    tk[0] = t3[0];
                    tk[1] = t3[1];
                    //tk[2]=j;

                    if (Math.pow((t4[0]) - t3[0], 2) >= Math.pow((t4[1] - t3[1]), 2)) {

                        for (int k = t2[2]; k <= t6[2]; ) {
                            short x, y, z;

                            x = (short) j;
                            y = (short) ((k - t32) / (t8[2] - t32) * (t8[1] - t4[1]) + t4[1]);
                            z = (short) k;
                            osnovnoi[i].dobavlpixels5(x, y, z);
                            int r = k + (int) (Math.random() * 6);
                            k = r < t6[2] ? r : k == t6[2] ? k + 1 : t6[2];


                        }
                    } else {
                        for (int k = t4[1]; k <= t8[1]; ) {
                            short x, y, z;
                            x = (short) j;
                            y = (short) k;
                            z = (short) ((k - t31) / (t8[1] - t31) * (t8[2] - t4[2]) + t4[2]);

                            osnovnoi[i].dobavlpixels5(x, y, z);
                            int r = k + (int) (Math.random() * 6);
                            k = r < t8[1] ? r : k == t8[1] ? k + 1 : t8[1];

                        }
                    }
                    int r = j + (int) (Math.random() * 6);
                    j = r < t3[0] ? r : j == t3[0] ? j + 1 : t3[0];
                }


///z
            } else if (osnovnoi[i].angleZ() != 0) {

                // first plane
                for (int j = t1[1]; j <= t2[1]; ) {
                    double[] tn = new double[3];
                    int[] tk = new int[3];
                    tn[1] = j;
                    tn[0] = t1[0];
                    tn[2] = t1[2];
                    tk[1] = j;
                    tk[0] = t3[0];
                    tk[2] = t3[2];
                    if (Math.pow((t1[0]) - t3[0], 2) >= Math.pow((t1[2] - t3[2]), 2)) {
                        for (int k = t1[0]; k <= t3[0]; ) {
                            short x, y, z;
                            x = (short) k;
                            y = (short) j;
                            z = (short) ((k - tn[0]) / (tk[0] - tn[0]) * (tk[2] - tn[2]) + tn[2]);
                            osnovnoi[i].dobavlpixels(x, y, z);
                            int r = k + (int) (Math.random() * 6);
                            k = r < t3[0] ? r : k == t3[0] ? k + 1 : t3[0];
                        }
                    } else {
                        for (int k = t1[2]; k <= t3[2]; ) {
                            short x, y, z;
                            x = (short) j;
                            y = (short) ((k - tn[2]) / (tk[2] - tn[2]) * (tk[1] - tn[1]) + tn[1]);
                            z = (short) k;

                            osnovnoi[i].dobavlpixels(x, y, z);
                            int r = k + (int) (Math.random() * 6);
                            k = r < t3[2] ? r : k == t3[2] ? k + 1 : t3[2];

                        }
                    }
                    int r = j + (int) (Math.random() * 6);
                    j = r < t2[1] ? r : j == t2[1] ? j + 1 : t2[1];
                }

                // sixth plane
                for (int j = t5[1]; j <= t6[1]; ) {
                    double[] tn = new double[3];
                    int[] tk = new int[3];
                    tn[1] = j;
                    tn[0] = t5[0];
                    tn[2] = t5[2];
                    tk[1] = j;
                    tk[0] = t7[0];
                    tk[2] = t7[2];
                    if (Math.pow((t5[0]) - t7[0], 2) >= Math.pow((t5[1] - t7[1]), 2)) {
                        for (int k = t5[0]; k <= t7[0]; ) {
                            short x, y, z;
                            x = (short) k;
                            y = (short) j;
                            z = (short) ((k - tn[0]) / (tk[0] - tn[0]) * (tk[2] - tn[2]) + tn[2]);
                            osnovnoi[i].dobavlpixels6(x, y, z);
                            int r = k + (int) (Math.random() * 6);
                            k = r < t7[0] ? r : k == t7[0] ? k + 1 : t7[0];
                        }
                    } else {
                        for (int k = t5[2]; k <= t7[2]; ) {
                            short x, y, z;
                            x = (short) j;
                            y = (short) ((k - tn[2]) / (tk[2] - tn[2]) * (tk[1] - tn[1]) + tn[1]);
                            z = (short) k;

                            osnovnoi[i].dobavlpixels6(x, y, z);
                            int r = k + (int) (Math.random() * 6);
                            k = r < t7[2] ? r : k == t7[2] ? k + 1 : t7[2];

                        }
                    }
                    int r = j + (int) (Math.random() * 6);
                    j = r < t6[1] ? r : j == t6[1] ? j + 1 : t6[1];
                }
                ////// fourth and firth plane

                if (Math.pow((t1[0]) - t3[0], 2) >= Math.pow((t1[2] - t3[2]), 2)) {
                    for (int j = t1[0]; j <= t3[0]; ) {
                        int[] tn = new int[3];
                        double t10 = t1[0];
                        double t50 = t5[0];
                        int[] tk = new int[3];
                        tn[0] = j;
                        tn[1] = t1[1];
                        tn[2] = (int) ((j - t10) / (t3[1] - t10) * (t3[2] - t1[2]) + t1[2]);
                        tk[0] = (t5[0] - t1[0] + j);
                        tk[1] = t1[1];
                        tk[2] = (int) ((tk[0] - t50) / (t7[0] - t50) * (t7[2] - t5[2]) + t5[2]);
                        for (int k = tn[2]; k <= tk[2]; ) {
                            short x, y, z;
                            double tn2 = tn[2];
                            x = (short) ((k - tn2) / (tk[2] - tn2) * (tk[0] - tn[0]) + tn[0]);
                            y = (short) t1[1];
                            z = (short) k;
                            osnovnoi[i].dobavlpixels5(x, y, z);
                            osnovnoi[i].dobavlpixels4(x, (short) (y + osnovnoi[i].haight()), z);
                            int r = k + (int) (Math.random() * 6);
                            k = r < tk[2] ? r : k == tk[2] ? k + 1 : tk[2];
                        }
                        int r = j + (int) (Math.random() * 6);
                        j = r < t3[0] ? r : j == t3[0] ? j + 1 : t3[0];
                    }
                } else {
                    for (int j = t1[2]; j <= t3[2]; ) {
                        int[] tn = new int[3];
                        int[] tk = new int[3];
                        double t52 = t5[2];
                        double t12 = t1[2];
                        tn[0] = (short) ((j - t12) / (t3[2] - t12) * (t3[1] - t1[1]) + t1[1]);
                        tn[1] = t1[1];
                        tn[2] = j;
                        tk[0] = (short) ((j - t52) / (t7[2] - t52) * (t7[0] - t5[0]) + t5[0]);
                        tk[2] = t5[2] - t1[2] + j;
                        tk[1] = t1[0];

                        for (int k = tn[0]; k <= tk[0]; ) {
                            short x, y, z;
                            x = (short) k;
                            y = (short) t1[0];
                            double rn = tn[0];
                            z = (short) ((k - rn) / (tk[0] - rn) * (tk[2] - tn[2]) + tn[2]);

                            osnovnoi[i].dobavlpixels5(x, y, z);
                            osnovnoi[i].dobavlpixels4(x, (short) (y + osnovnoi[i].haight()), z);
                            int r = k + (int) (Math.random() * 6);
                            k = r < tk[0] ? r : k == tk[0] ? k + 1 : tk[0];
                        }
                        int r = j + (int) (Math.random() * 6);
                        j = r < t3[2] ? r : j == t3[2] ? j + 1 : t3[2];
                    }
                }


                //second

                for (int j = t1[1]; j <= t2[1]; ) {
                    double[] tn = new double[3];
                    int[] tk = new int[3];
                    double t10 = t1[0];
                    double t12 = t1[2];
                    tn[0] = t1[0];
                    tn[1] = j;
                    tn[2] = t1[2];
                    tk[0] = t5[0];
                    tk[1] = j;
                    tk[2] = t5[2];
                    if (Math.pow((t1[2]) - t5[2], 2) >= Math.pow((t1[0] - t5[0]), 2)) {

                        for (int k = t1[2]; k <= t5[2]; ) {
                            short x, y, z;

                            x = (short) ((k - t12) / (t5[2] - t12) * (t5[0] - t1[0]) + t1[0]);
                            y = (short) j;
                            z = (short) k;
                            osnovnoi[i].dobavlpixels2(x, y, z);
                            int r = k + (int) (Math.random() * 6);
                            k = r < t5[2] ? r : k == t5[2] ? k + 1 : t5[2];


                        }
                    } else {
                        for (int k = t1[0]; k <= t5[0]; ) {
                            short x, y, z;
                            x = (short) k;
                            y = (short) j;
                            z = (short) ((k - t10) / (t5[0] - t10) * (t5[2] - t1[2]) + t1[2]);

                            osnovnoi[i].dobavlpixels2(x, y, z);
                            int r = k + (int) (Math.random() * 6);
                            k = r < t5[0] ? r : k == t5[0] ? k + 1 : t5[0];

                        }
                    }
                    int r = j + (int) (Math.random() * 6);
                    j = r < t2[1] ? r : j == t2[1] ? j + 1 : t2[1];
                }

                // third
                for (int j = t3[1]; j <= t4[1]; ) {
                    double[] tn = new double[3];
                    int[] tk = new int[3];
                    double t30 = t3[0];
                    double t32 = t3[2];
                    tn[0] = t3[0];
                    tn[1] = j;
                    tn[2] = t3[2];
                    tk[0] = t7[0];
                    tk[1] = j;
                    tk[2] = t7[2];
                    if (Math.pow((t3[2]) - t7[2], 2) >= Math.pow((t3[0] - t7[0]), 2)) {

                        for (int k = t3[2]; k <= t7[2]; ) {
                            short x, y, z;

                            x = (short) ((k - t32) / (t7[2] - t32) * (t7[0] - t3[0]) + t3[0]);
                            y = (short) j;
                            z = (short) k;
                            osnovnoi[i].dobavlpixels3(x, y, z);
                            int r = k + (int) (Math.random() * 6);
                            k = r < t7[2] ? r : k == t7[2] ? k + 1 : t7[2];


                        }
                    } else {
                        for (int k = t3[0]; k <= t7[0]; ) {
                            short x, y, z;
                            x = (short) k;
                            y = (short) j;
                            z = (short) ((k - t30) / (t7[0] - t30) * (t7[2] - t3[2]) + t3[2]);

                            osnovnoi[i].dobavlpixels3(x, y, z);
                            int r = k + (int) (Math.random() * 6);
                            k = r < t7[0] ? r : k == t7[0] ? k + 1 : t7[0];

                        }
                    }
                    int r = j + (int) (Math.random() * 6);
                    j = r < t4[1] ? r : j == t4[1] ? j + 1 : t4[1];
                }

            }


        }


    }

    public void metodotobrathpix() {

        for (int i = 0; i < osnovnoi[0].lengthpix(); i++) {
            System.out.print(" x" + osnovnoi[0].pixels(0, i) + ";");
        }
        System.out.println();
        for (int i = 0; i < osnovnoi[0].lengthpix(); i++) {
            System.out.print(" y" + osnovnoi[0].pixels(1, i) + ";");
        }
        System.out.println();
        for (int i = 0; i < osnovnoi[0].lengthpix(); i++) {
            System.out.print(" z" + osnovnoi[0].pixels(2, i) + ";");
        }
        System.out.println();


    }

    public void metodproverkaustanovl() {
        wihod:
        for (int i = 0; i < kolvosnaclonom; i++) {
            if (osnovnoi[i].angleX() > 0) {
                //p1 p6
                for (int j = i + 1; j < kolvosnaclonom; j++) {
                    if (osnovnoi[j].angleX() != 0) {
                        //p1 p6
                        for (int i1 = 0; i1 < osnovnoi[i].lengthpix(); i1++) {
                            for (int j1 = 0; j1 < osnovnoi[j].lengthpix(); j1++) {

                                int proverka = (osnovnoi[i].pixels6(0, i1) - osnovnoi[i].pixels(0, i1)) * (osnovnoi[j].pixels(1, j1) - osnovnoi[i].pixels(1, i1)) *
                                        (osnovnoi[j].pixels6(2, j1) - osnovnoi[i].pixels(2, i1)) +
                                        (osnovnoi[i].pixels6(1, i1) - osnovnoi[i].pixels(1, j1)) * (osnovnoi[j].pixels(2, j1) - osnovnoi[i].pixels(2, i1)) *
                                                (osnovnoi[j].pixels6(0, j1) - osnovnoi[i].pixels(0, i1)) +
                                        (osnovnoi[i].pixels6(2, i1) - osnovnoi[i].pixels(2, i1)) * (osnovnoi[j].pixels(0, j1) - osnovnoi[i].pixels(0, i1)) *
                                                (osnovnoi[j].pixels4(1, j1) - osnovnoi[i].pixels6(1, i1)) -
                                        (osnovnoi[i].pixels6(2, i1) - osnovnoi[i].pixels(2, i1)) * (osnovnoi[j].pixels(1, j1) - osnovnoi[i].pixels(1, i1)) *
                                                (osnovnoi[j].pixels6(0, j1) - osnovnoi[i].pixels(0, i1)) -
                                        (osnovnoi[i].pixels6(1, i1) - osnovnoi[i].pixels(1, i1)) * (osnovnoi[j].pixels(0, j1) - osnovnoi[i].pixels(0, i1)) *
                                                (osnovnoi[j].pixels6(2, j1) - osnovnoi[i].pixels6(2, i1)) -
                                        (osnovnoi[i].pixels6(0, i1) - osnovnoi[i].pixels(0, i1)) * (osnovnoi[j].pixels(2, j1) - osnovnoi[i].pixels(2, i1)) *
                                                (osnovnoi[j].pixels6(1, j1) - osnovnoi[i].pixels(1, i1));


                                if (proverka == 0) {

                                    double uznamxy = (osnovnoi[i].pixels(0, i1) - osnovnoi[i].pixels6(0, i1)) * (osnovnoi[j].pixels6(1, j1) - osnovnoi[j].pixels(1, j1)) -
                                            (osnovnoi[j].pixels6(0, j1) - osnovnoi[j].pixels(0, j1)) * (osnovnoi[i].pixels(1, i1) - osnovnoi[i].pixels6(1, i1));
                                    double uznamxz = (osnovnoi[i].pixels(0, i1) - osnovnoi[i].pixels6(0, i1)) * (osnovnoi[j].pixels6(2, j1) - osnovnoi[j].pixels(2, j1)) -
                                            (osnovnoi[j].pixels6(0, j1) - osnovnoi[j].pixels(0, j1)) * (osnovnoi[i].pixels(2, i1) - osnovnoi[i].pixels6(2, i1));
                                    double uznamyz = (osnovnoi[i].pixels(2, i1) - osnovnoi[i].pixels6(2, i1)) * (osnovnoi[j].pixels6(1, j1) - osnovnoi[j].pixels(1, j1)) -
                                            (osnovnoi[j].pixels6(2, j1) - osnovnoi[j].pixels(2, j1)) * (osnovnoi[i].pixels(1, i1) - osnovnoi[i].pixels6(1, i1));
                                    System.out.print(" xy" + uznamxy + " xz" + uznamxz + " yz" + uznamyz);
                                    if (uznamxy != 0) {

                                        double uchisl = ((osnovnoi[j].pixels6(0, j1) - osnovnoi[i].pixels6(0, i1)) * (osnovnoi[j].pixels6(1, j1) - osnovnoi[j].pixels(1, j1)) -
                                                (osnovnoi[j].pixels6(0, j1) - osnovnoi[j].pixels(0, j1)) * (osnovnoi[j].pixels6(1, j1) - osnovnoi[i].pixels6(1, i1))) / uznamxy;

                                        double vchisl = ((osnovnoi[i].pixels(0, i1) - osnovnoi[i].pixels6(0, i1)) * (osnovnoi[j].pixels6(1, j1) - osnovnoi[i].pixels(1, i1)) -
                                                (osnovnoi[j].pixels6(0, j1) - osnovnoi[i].pixels6(0, i1)) * (osnovnoi[i].pixels(1, i1) - osnovnoi[i].pixels6(1, i1))) / uznamxy;

                                        if (uchisl >= 0 && uchisl <= 1 && vchisl >= 0 && vchisl <= 1) {
                                            Alert alert = new Alert(AlertType.INFORMATION);
                                            alert.setHeaderText("деталь №" + i + " пересекается с деталью №" + j);
                                            alert.showAndWait();
                                            System.out.println("t1 " + osnovnoi[i].pixels(0, i1) + " " + osnovnoi[i].pixels(1, i1) + " " + osnovnoi[i].pixels(2, i1));
                                            System.out.println("t2 " + osnovnoi[i].pixels6(0, i1) + " " + osnovnoi[i].pixels6(1, i1) + " " + osnovnoi[i].pixels6(2, i1));
                                            System.out.println("t3 " + osnovnoi[j].pixels(0, j1) + " " + osnovnoi[j].pixels(1, j1) + " " + osnovnoi[j].pixels(2, j1));
                                            System.out.println("t4 " + osnovnoi[j].pixels6(0, j1) + " " + osnovnoi[j].pixels6(1, j1) + " " + osnovnoi[j].pixels6(2, j1));
                                            break wihod;
                                        }
                                    } else if (uznamxz != 0) {

                                        double uchisl = ((osnovnoi[j].pixels6(0, j1) - osnovnoi[i].pixels6(0, i1)) * (osnovnoi[j].pixels6(2, j1) - osnovnoi[j].pixels(2, j1)) -
                                                (osnovnoi[j].pixels6(0, j1) - osnovnoi[j].pixels(0, j1)) * (osnovnoi[j].pixels6(2, j1) - osnovnoi[i].pixels6(2, i1))) / uznamxz;

                                        double vchisl = ((osnovnoi[i].pixels(0, i1) - osnovnoi[i].pixels6(0, i1)) * (osnovnoi[j].pixels6(2, j1) - osnovnoi[i].pixels(2, i1)) -
                                                (osnovnoi[j].pixels6(0, j1) - osnovnoi[i].pixels6(0, i1)) * (osnovnoi[i].pixels(2, i1) - osnovnoi[i].pixels6(2, i1))) / uznamxz;

                                        if (uchisl >= 0 && uchisl <= 1 && vchisl >= 0 && vchisl <= 1) {
                                            Alert alert = new Alert(AlertType.INFORMATION);
                                            alert.setHeaderText("деталь №" + i + " пересекается с деталью №" + j);
                                            alert.showAndWait();
                                            System.out.println("t1 " + osnovnoi[i].pixels(0, i1) + " " + osnovnoi[i].pixels(1, i1) + " " + osnovnoi[i].pixels(2, i1));
                                            System.out.println("t2 " + osnovnoi[i].pixels6(0, i1) + " " + osnovnoi[i].pixels6(1, i1) + " " + osnovnoi[i].pixels6(2, i1));
                                            System.out.println("t3 " + osnovnoi[j].pixels(0, j1) + " " + osnovnoi[j].pixels(1, j1) + " " + osnovnoi[j].pixels(2, j1));
                                            System.out.println("t4 " + osnovnoi[j].pixels6(0, j1) + " " + osnovnoi[j].pixels6(1, j1) + " " + osnovnoi[j].pixels6(2, j1));
                                            break wihod;
                                        }

                                    } else if (uznamyz != 0) {

                                        double uchisl = ((osnovnoi[j].pixels6(1, j1) - osnovnoi[i].pixels6(1, i1)) * (osnovnoi[j].pixels6(2, j1) - osnovnoi[j].pixels(2, j1)) -
                                                (osnovnoi[j].pixels6(1, j1) - osnovnoi[j].pixels(1, j1)) * (osnovnoi[j].pixels6(2, j1) - osnovnoi[i].pixels6(2, i1))) / uznamyz;

                                        double vchisl = ((osnovnoi[i].pixels(1, i1) - osnovnoi[i].pixels6(1, i1)) * (osnovnoi[j].pixels6(2, j1) - osnovnoi[i].pixels(2, i1)) -
                                                (osnovnoi[j].pixels6(1, j1) - osnovnoi[i].pixels6(1, i1)) * (osnovnoi[i].pixels(2, i1) - osnovnoi[i].pixels6(2, i1))) / uznamyz;

                                        if (uchisl >= 0 && uchisl <= 1 && vchisl >= 0 && vchisl <= 1) {
                                            Alert alert = new Alert(AlertType.INFORMATION);
                                            alert.setHeaderText("деталь №" + i + " пересекается с деталью №" + j);
                                            alert.showAndWait();
                                            System.out.println("t1 " + osnovnoi[i].pixels(0, i1) + " " + osnovnoi[i].pixels(1, i1) + " " + osnovnoi[i].pixels(2, i1));
                                            System.out.println("t2 " + osnovnoi[i].pixels6(0, i1) + " " + osnovnoi[i].pixels6(1, i1) + " " + osnovnoi[i].pixels6(2, i1));
                                            System.out.println("t3 " + osnovnoi[j].pixels(0, j1) + " " + osnovnoi[j].pixels(1, j1) + " " + osnovnoi[j].pixels(2, j1));
                                            System.out.println("t4 " + osnovnoi[j].pixels6(0, j1) + " " + osnovnoi[j].pixels6(1, j1) + " " + osnovnoi[j].pixels6(2, j1));
                                            break wihod;
                                        }

                                    }


                                }

                            }


                        }
                    }
                }

            }

        }

    }

    public boolean proverkaa(double x, double y, double z, int width, int height, int length) {
        boolean r = true;
        for (int i = 0; i < nustnovl; i++) {
            if (osnovnoi[i].coordX() > x && osnovnoi[i].coordX() < x + width &&
                    osnovnoi[i].coordX() + osnovnoi[i].width() > x && osnovnoi[i].coordX() + osnovnoi[i].width() < x + width &&

                    osnovnoi[i].coordY() > y && osnovnoi[i].coordY() < y + height &&
                    osnovnoi[i].coordY() + osnovnoi[i].haight() > y && osnovnoi[i].coordY() + osnovnoi[i].haight() < y + height &&

                    osnovnoi[i].coordZ() > z && osnovnoi[i].coordZ() < z + length &&
                    osnovnoi[i].coordZ() + osnovnoi[i].lenght() > z && osnovnoi[i].coordZ() + osnovnoi[i].lenght() < z + length &&
                    x >= ThicknessRrazmerKorpusa && x + width <= WrazmerKorpusa*ThicknessRrazmerKorpusa &&
                    y >= ThicknessRrazmerKorpusa && y + height <= HrazmerKorpusa *ThicknessRrazmerKorpusa&&
                    z >= ThicknessRrazmerKorpusa && z + length <= LrazmerKorpusa-ThicknessRrazmerKorpusa) {
                r = false;
            }
        }

        return r;
    }

    public void metodInstallingBeside() {
        for (int i = 0; i < bd.length; i++) {
            if (bd[i].ryadom() != -1000) {
                for (int j = 0; j < nustnovl; j++) {
                    String str = osnovnoi[j].names();
                    String wsw = String.valueOf(str.charAt(1));
                    if (str.charAt(2) > 47 & str.charAt(2) < 58) {
                        wsw = wsw + String.valueOf(str.charAt(2));
                        if (str.charAt(3) > 47 & str.charAt(3) < 58) {
                            wsw = wsw + String.valueOf(str.charAt(3));
                        }
                    }
                    if (bd[i].ryadom() == Integer.parseInt(wsw)) {

                        exit:
                        for (int kz = 1; kz < 300; kz = kz + 15) {
                            for (int ky = 1; ky < 300; ky = ky + 15) {
                                for (int kx = 1; kx < 300; kx = kx + 15) {

                                    //справа
                                    if (proverkaa(osnovnoi[j].coordX() + osnovnoi[j].width() + kx, osnovnoi[j].coordY() + ky, osnovnoi[j].coordZ() + kz, bd[i].width(), bd[i].haight(), bd[i].length())) {
                                        osnovnoi[nustnovl] = new Ploskosti(bd[i].names(), bd[i].width(), bd[i].haight(), bd[i].length(),
                                                osnovnoi[j].coordX() + osnovnoi[j].width() + kx, osnovnoi[j].coordY() + ky, osnovnoi[j].coordZ() + kz,
                                                bd[i].angleX(), bd[i].angleY(), bd[i].angleZ());
                                        nustnovl++;
                                        break exit;
                                    }
                                    //слева
                                    if (proverkaa(osnovnoi[j].coordX() - bd[i].width() - kx, osnovnoi[j].coordY() + ky, osnovnoi[j].coordZ() + kz, bd[i].width(), bd[i].haight(), bd[i].length())) {
                                        osnovnoi[nustnovl] = new Ploskosti(bd[i].names(), bd[i].width(), bd[i].haight(), bd[i].length(),
                                                osnovnoi[j].coordX() - bd[i].width() - kx, osnovnoi[j].coordY() + ky, osnovnoi[j].coordZ() + kz,
                                                bd[i].angleX(), bd[i].angleY(), bd[i].angleZ());
                                        nustnovl++;
                                        break exit;
                                    }
                                    //сверху
                                    if (proverkaa(osnovnoi[j].coordX() + kx, osnovnoi[j].coordY() + osnovnoi[j].haight() + ky, osnovnoi[j].coordZ() + kz, bd[i].width(), bd[i].haight(), bd[i].length())) {
                                        osnovnoi[nustnovl] = new Ploskosti(bd[i].names(), bd[i].width(), bd[i].haight(), bd[i].length(),
                                                osnovnoi[j].coordX() + kx, osnovnoi[j].coordY() + osnovnoi[j].haight() + ky, osnovnoi[j].coordZ() + kz,
                                                bd[i].angleX(), bd[i].angleY(), bd[i].angleZ());
                                        nustnovl++;
                                        break exit;
                                    }
                                    //снизу
                                    if (proverkaa(osnovnoi[j].coordX() + kx, osnovnoi[j].coordY() - bd[i].haight() - ky, osnovnoi[j].coordZ() + kz, bd[i].width(), bd[i].haight(), bd[i].length())) {
                                        osnovnoi[nustnovl] = new Ploskosti(bd[i].names(), bd[i].width(), bd[i].haight(), bd[i].length(),
                                                osnovnoi[j].coordX() + kx, osnovnoi[j].coordY() - bd[i].haight() - ky, osnovnoi[j].coordZ() + kz,
                                                bd[i].angleX(), bd[i].angleY(), bd[i].angleZ());
                                        nustnovl++;
                                        break exit;
                                    }
                                    //сзади
                                    if (proverkaa(osnovnoi[j].coordX() + kx, osnovnoi[j].coordY() + ky, osnovnoi[j].coordZ() + bd[i].length() + kz, bd[i].width(), bd[i].haight(), bd[i].length())) {
                                        osnovnoi[nustnovl] = new Ploskosti(bd[i].names(), bd[i].width(), bd[i].haight(), bd[i].length(),
                                                osnovnoi[j].coordX() + kx, osnovnoi[j].coordY() + ky, osnovnoi[j].coordZ() + bd[i].length() + kz,
                                                bd[i].angleX(), bd[i].angleY(), bd[i].angleZ());
                                        nustnovl++;
                                        break exit;
                                    }
                                    //спереди
                                    if (proverkaa(osnovnoi[j].coordX() + kx, osnovnoi[j].coordY() + ky, osnovnoi[j].coordZ() - bd[j].length() - kz, bd[i].width(), bd[i].haight(), bd[i].length())) {
                                        osnovnoi[nustnovl] = new Ploskosti(bd[i].names(), bd[i].width(), bd[i].haight(), bd[i].length(),
                                                osnovnoi[j].coordX() + kx, osnovnoi[j].coordY() + ky, osnovnoi[j].coordZ() - bd[j].length() - kz,
                                                bd[i].angleX(), bd[i].angleY(), bd[i].angleZ());
                                        nustnovl++;
                                        break exit;
                                    }


                                }
                            }


                        }


                    }

                }
            }


        }

    }

    public void metodInstalOthers() {

        for (int i = 0; i < 0; i++) {
            if(bd[i].coordX()==-1000&&bd[i].coordY()==-1000&&bd[i].coordZ()==-1000&&bd[i].ryadom()==-1000) {
                exit:
                for (int kz = 1; kz < LrazmerKorpusa; kz = kz + 30) {
                    for (int ky = 1; ky < HrazmerKorpusa; ky = ky + 30) {
                        for (int kx = 1; kx < WrazmerKorpusa; kx = kx + 30) {

                            if (proverkaa(kx, ky, kz, bd[i].width(), bd[i].haight(), bd[i].length())) {
                                osnovnoi[nustnovl] = new Ploskosti(bd[i].names(), bd[i].width(), bd[i].haight(), bd[i].length(),
                                        kx, ky, kz,
                                        bd[i].angleX(), bd[i].angleY(), bd[i].angleZ());
                                nustnovl++;
                                break exit;
                            }

                        }
                    }

                }
            }


        }
    }
}