package sample;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.Arrays;

public class Controller {
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
            if (openrazb[i][4].trim().length() == 0|Integer.parseInt(openrazb[i][4])==0) mmm[0] = -1000;
            else mmm[0] = Integer.parseInt(openrazb[i][4]);
            if (openrazb[i][5].trim().length() == 0|Integer.parseInt(openrazb[i][5])==0) mmm[1] = -1000;
            else mmm[1] = Integer.parseInt(openrazb[i][5]);
            if (openrazb[i][6].trim().length() == 0|Integer.parseInt(openrazb[i][6])==0) mmm[2] = -1000;
            else mmm[2] = Integer.parseInt(openrazb[i][6]);
            if (openrazb[i][7].trim().length() == 0|Integer.parseInt(openrazb[i][7])==0) mmm[3] = -1000;
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
        SW sw=new SW(osnovnoi,n,WrazmerKorpusa,HrazmerKorpusa,LrazmerKorpusa,ThicknessRrazmerKorpusa);
        sw.save();
    }


    @FXML
    private void handleLocaterazmesh() throws IOException {
        //  metodrazmesh(); metodproverka();
        //  metodrazmeshryadom();
        //  metodrazmeshostaln();
        //metodrazmeshangletochki();
        //metodrazmeshanglepixels();
        //metodproverkaustanovl();
        metodInstalKoord();
       // metodrazmeshangletochki();
        metodInstallingBeside();
        metodInstalOthers();
      //  metodproverkaustanovl();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText("Расчеты завершились.");
        alert.showAndWait();
/*
        System.out.println("t1 X=" + osnovnoi[0].poluchtochka1(0) + " Y" + osnovnoi[0].poluchtochka1(1) + " Z" + osnovnoi[0].poluchtochka1(2));
        System.out.println("t2 X=" + osnovnoi[0].poluchtochka2(0) + " Y" + osnovnoi[0].poluchtochka2(1) + " Z" + osnovnoi[0].poluchtochka2(2));
        System.out.println("t3 X=" + osnovnoi[0].poluchtochka3(0) + " Y" + osnovnoi[0].poluchtochka3(1) + " Z" + osnovnoi[0].poluchtochka3(2));
        System.out.println("t4 X=" + osnovnoi[0].poluchtochka4(0) + " Y" + osnovnoi[0].poluchtochka4(1) + " Z" + osnovnoi[0].poluchtochka4(2));
        System.out.println("t5 X=" + osnovnoi[0].poluchtochka5(0) + " Y" + osnovnoi[0].poluchtochka5(1) + " Z" + osnovnoi[0].poluchtochka5(2));
        System.out.println("t6 X=" + osnovnoi[0].poluchtochka6(0) + " Y" + osnovnoi[0].poluchtochka6(1) + " Z" + osnovnoi[0].poluchtochka6(2));
        System.out.println("t7 X=" + osnovnoi[0].poluchtochka7(0) + " Y" + osnovnoi[0].poluchtochka7(1) + " Z" + osnovnoi[0].poluchtochka7(2));
        System.out.println("t8 X=" + osnovnoi[0].poluchtochka8(0) + " Y" + osnovnoi[0].poluchtochka8(1) + " Z" + osnovnoi[0].poluchtochka8(2));
*/

       // osnovnoi[0].lengthpix();
       // metodotobrathpix();
      //  System.out.println("leng1  " + osnovnoi[0].lengthpix() + ";leng2 " + osnovnoi[0].lengthpix2() + ";leng3 " + osnovnoi[0].lengthpix3()
       //         + ";leng4 " + osnovnoi[0].lengthpix4() + ";leng5 " + osnovnoi[0].lengthpix5() + ";leng6 " + osnovnoi[0].lengthpix6());
        //System.out.println(" 1p"+osnovnoi[0].lengthpix2()+" 6p"+osnovnoi[0].lengthpix3());
        System.out.println("ok");
    }


    public void metodrazmeshangletochki() {


    }

    private void metodrazmeshanglepixels() {


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
        for(int i=0;i<bd.length;i++){
            System.out.println(bd[i].names()+";"+bd[i].width()+";"+bd[i].haight()+";"+bd[i].length()+";"+bd[i].coordX()+";"+bd[i].coordY()+";"+
                    bd[i].coordZ()+";"+bd[i].ryadom()+";"+bd[i].angleX()+";"+bd[i].angleY()+";"+bd[i].angleZ());
        }

    }

    public boolean proverkaa(double x, double y, double z, int width, int height, int length) {
        boolean r = true;
        exit:
        for (int i = 0; i < nustnovl; i++) {
            if (osnovnoi[i].coordX() >= x & osnovnoi[i].coordX() <= x + width &
                    osnovnoi[i].coordY()<= y & osnovnoi[i].coordY()+osnovnoi[i].haight()>= y &
                    osnovnoi[i].coordZ()<=z& osnovnoi[i].coordZ()+osnovnoi[i].lenght()>=z|

                    osnovnoi[i].coordX() >= x & osnovnoi[i].coordX() <= x + width &
                            osnovnoi[i].coordY()>= y &osnovnoi[i].coordY()<= y+height &
                            osnovnoi[i].coordZ()<=z&osnovnoi[i].coordZ()+osnovnoi[i].lenght()>=z|

                    osnovnoi[i].coordX() <= x & osnovnoi[i].coordX()+osnovnoi[i].width()  >= x  &
                            osnovnoi[i].coordY()>= y &osnovnoi[i].coordY()<= y+height &
                            osnovnoi[i].coordZ()<=z&osnovnoi[i].coordZ()+osnovnoi[i].lenght()>=z|

                    osnovnoi[i].coordX() <= x & osnovnoi[i].coordX() +osnovnoi[i].width() >= x  &
                            osnovnoi[i].coordY()<= y &osnovnoi[i].coordY()+osnovnoi[i].haight()>= y &
                            osnovnoi[i].coordZ()<=z&osnovnoi[i].coordZ()+osnovnoi[i].lenght()>=z|

                   ///////////////////////////////
                    osnovnoi[i].coordX() >= x & osnovnoi[i].coordX() <= x + width &
                            osnovnoi[i].coordY()<= y &osnovnoi[i].coordY()+osnovnoi[i].haight()>= y &
                            osnovnoi[i].coordZ()>=z&osnovnoi[i].coordZ()<=z+length|

                    osnovnoi[i].coordX() >= x & osnovnoi[i].coordX() <= x + width &
                            osnovnoi[i].coordY()>= y &osnovnoi[i].coordY()<= y+height &
                            osnovnoi[i].coordZ()>=z&osnovnoi[i].coordZ()<=z+length|

                    osnovnoi[i].coordX() <= x & osnovnoi[i].coordX()+osnovnoi[i].width()  <= x  &
                            osnovnoi[i].coordY()>= y &osnovnoi[i].coordY()<= y+height &
                            osnovnoi[i].coordZ()>=z&osnovnoi[i].coordZ()<=z+length|

                    osnovnoi[i].coordX() <= x & osnovnoi[i].coordX() +osnovnoi[i].width() >= x  &
                            osnovnoi[i].coordY()<= y &osnovnoi[i].coordY()+osnovnoi[i].haight()>= y &
                            osnovnoi[i].coordZ()>=z&osnovnoi[i].coordZ()<=z+length|



                    x <= ThicknessRrazmerKorpusa | x + width >= WrazmerKorpusa-ThicknessRrazmerKorpusa |
                    y <= ThicknessRrazmerKorpusa |y + height >= HrazmerKorpusa -ThicknessRrazmerKorpusa|
                    z <= ThicknessRrazmerKorpusa | z + length >= LrazmerKorpusa-ThicknessRrazmerKorpusa) {

/*
                System.out.println(z+" y="+y+" z="+z);
                System.out.println(width+" "+height+" "+length);
                System.out.println(WrazmerKorpusa+" "+HrazmerKorpusa+" "+LrazmerKorpusa);
                System.out.println(osnovnoi[i].coordX()+" jsn y="+osnovnoi[i].coordY()+" "+osnovnoi[i].coordZ());
                System.out.println(osnovnoi[i].width()+" "+osnovnoi[i].haight()+" "+osnovnoi[i].lenght());
*/
                r = false;
              /*  Alert alert = new Alert(AlertType.INFORMATION);
                alert.setContentText("Деталь №"+i+" налазит на другие детали");
                alert.showAndWait();*/
               // System.out.println("hhhhhhhhhhhhhhhhhhhhhh");
                break exit;
            }

        }


        return r;
    }

    public void metodInstalKoord(){
        System.out.println(nustnovl);
        for (int i = 0; i < bd.length; i++) {
            if (bd[i].coordX() != -1000) {

                if(i>0) {
                    if (proverkaa(bd[i].coordX(),bd[i].coordY(),bd[i].coordZ(), bd[i].width(),bd[i].haight(),bd[i].length())) {
                        System.out.println(i);
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setContentText("Деталь  №" + (i + 1) + " c заданными координатами налазит на другие детали");
                        alert.showAndWait();
                    }
                }


            osnovnoi[i]=new Ploskosti(bd[i].names(),bd[i].width(),bd[i].haight(),bd[i].length(),bd[i].coordX(),bd[i].coordY(),bd[i].coordZ(),
                    bd[i].angleX(),bd[i].angleY(),bd[i].angleZ());
                System.out.println(bd[i].coordX()+" ");
            nustnovl++;


            }
        }

        System.out.println(nustnovl);
       /* for(int i=1;i<nustnovl;i++){
            if(proverkaa(osnovnoi[i].coordX(),osnovnoi[i].coordY(),osnovnoi[i].coordZ(),osnovnoi[i].width(),osnovnoi[i].haight(),osnovnoi[i].lenght()))
            {System.out.println(i);} else{

                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setContentText("Деталь  №"+(i+1)+" c заданными координатами налазит на другие детали");
                    alert.showAndWait();

            }
        }*/
    }

    public void metodInstallingBeside() {
        System.out.println(nustnovl+"  nustanovl");
        for (int i = 0; i < bd.length; i++) {
            if (bd[i].ryadom() != -1000&bd[i].coordX()==-1000) {
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

                                    //справа n
                                    if (proverkaa(osnovnoi[j].coordX() + osnovnoi[j].width() + kx, osnovnoi[j].coordY() + ky, osnovnoi[j].coordZ() + kz, bd[i].width(), bd[i].haight(), bd[i].length())) {
                                        osnovnoi[nustnovl] = new Ploskosti(bd[i].names(), bd[i].width(), bd[i].haight(), bd[i].length(),
                                                osnovnoi[j].coordX() + osnovnoi[j].width() + kx, osnovnoi[j].coordY() + ky, osnovnoi[j].coordZ() + kz,
                                                bd[i].angleX(), bd[i].angleY(), bd[i].angleZ());
                                        nustnovl++;
                                        break exit;
                                    }else
                                    //слева
                                    if (proverkaa(osnovnoi[j].coordX() - bd[i].width() - kx, osnovnoi[j].coordY() + ky, osnovnoi[j].coordZ() + kz, bd[i].width(), bd[i].haight(), bd[i].length())) {
                                        osnovnoi[nustnovl] = new Ploskosti(bd[i].names(), bd[i].width(), bd[i].haight(), bd[i].length(),
                                                osnovnoi[j].coordX() - bd[i].width() - kx, osnovnoi[j].coordY() + ky, osnovnoi[j].coordZ() + kz,
                                                bd[i].angleX(), bd[i].angleY(), bd[i].angleZ());
                                        nustnovl++;
                                        break exit;
                                    }else
                                    //сверху
                                    if (proverkaa(osnovnoi[j].coordX() + kx, osnovnoi[j].coordY() + osnovnoi[j].haight() + ky, osnovnoi[j].coordZ() + kz, bd[i].width(), bd[i].haight(), bd[i].length())) {
                                        osnovnoi[nustnovl] = new Ploskosti(bd[i].names(), bd[i].width(), bd[i].haight(), bd[i].length(),
                                                osnovnoi[j].coordX() + kx, osnovnoi[j].coordY() + osnovnoi[j].haight() + ky, osnovnoi[j].coordZ() + kz,
                                                bd[i].angleX(), bd[i].angleY(), bd[i].angleZ());
                                        nustnovl++;
                                        break exit;
                                    }else
                                    //снизу
                                    if (proverkaa(osnovnoi[j].coordX() + kx, osnovnoi[j].coordY() - bd[i].haight() - ky, osnovnoi[j].coordZ() + kz, bd[i].width(), bd[i].haight(), bd[i].length())) {
                                        osnovnoi[nustnovl] = new Ploskosti(bd[i].names(), bd[i].width(), bd[i].haight(), bd[i].length(),
                                                osnovnoi[j].coordX() + kx, osnovnoi[j].coordY() - bd[i].haight() - ky, osnovnoi[j].coordZ() + kz,
                                                bd[i].angleX(), bd[i].angleY(), bd[i].angleZ());
                                        nustnovl++;
                                        break exit;
                                    }else
                                    //сзади
                                    if (proverkaa(osnovnoi[j].coordX() + kx, osnovnoi[j].coordY() + ky, osnovnoi[j].coordZ() + bd[i].length() + kz, bd[i].width(), bd[i].haight(), bd[i].length())) {
                                        osnovnoi[nustnovl] = new Ploskosti(bd[i].names(), bd[i].width(), bd[i].haight(), bd[i].length(),
                                                osnovnoi[j].coordX() + kx, osnovnoi[j].coordY() + ky, osnovnoi[j].coordZ() + bd[i].length() + kz,
                                                bd[i].angleX(), bd[i].angleY(), bd[i].angleZ());
                                        nustnovl++;
                                        break exit;
                                    }else
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
        System.out.println(nustnovl+"  nustanovl");

    }

    public void metodInstalOthers() {
        System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        for (int i = 0; i < bd.length; i++) {
            if(bd[i].coordX()==-1000&&bd[i].coordY()==-1000&&bd[i].coordZ()==-1000&&bd[i].ryadom()==-1000) {
                exit:
                for (int kz = ThicknessRrazmerKorpusa+5; kz < LrazmerKorpusa-ThicknessRrazmerKorpusa-5; kz = kz + 30) {
                    for (int ky = ThicknessRrazmerKorpusa+5; ky < HrazmerKorpusa-ThicknessRrazmerKorpusa-5; ky = ky + 30) {
                        for (int kx = ThicknessRrazmerKorpusa-5; kx < WrazmerKorpusa-ThicknessRrazmerKorpusa-5; kx = kx + 30) {

                            System.out.println("do prov nustanovl="+nustnovl+" i="+i+" kz="+kz+" ky="+ky+" kx="+kx);
                            if (proverkaa(kx, ky, kz, bd[i].width(), bd[i].haight(), bd[i].length())) {
                                osnovnoi[nustnovl] = new Ploskosti(bd[i].names(), bd[i].width(), bd[i].haight(), bd[i].length(),
                                        kx, ky, kz, bd[i].angleX(), bd[i].angleY(), bd[i].angleZ());
                                nustnovl++;
                                break exit;
                            }
                            System.out.println("nustanovl="+nustnovl+" i="+i+" kz="+kz+" ky="+ky+" kx="+kx);

                        }
                    }

                }
            }


        }
    }
}