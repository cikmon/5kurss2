/*
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

public class Controller111 {
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

    private int WrazmerKorpusa=0;
    private int HrazmerKorpusa=0;
    private int LrazmerKorpusa=0;
    private int ThicknessRrazmerKorpusa=0;

    private Bd [] bd;
    private Ploskosti[] osnovnoi;
    private Ploskosti[] ryadom;
    private Ploskosti[] ostalnie;


    private int kolvosnaclonom=0;

    int n=0;int n12=0;
    int ploskost=0;
    int ploskostpostr=0;


    private JFXPanel primaryStage;
    private   ObservableList<String> list= FXCollections.observableArrayList("Cоздание обьекта №1");
    private   ObservableList<String> list2= FXCollections.observableArrayList("свободное размещение");
    private   ObservableList<String> list3= FXCollections.observableArrayList("Передняя","Задняя","Слева","Справа","Нижняя","Верхняя");

    // private Main mainApp;
   // public void setMainApp(Main mainApp) {
     //   this.mainApp = mainApp;
   // }
    @FXML
    private void handleExit() {System.exit(0);}
    @FXML

    private void handleOpen() throws IOException {
        //String fileName = "/Users/prologistic/source.txt";
        // readUsingFiles(fileName);
        String[] open1 = new String[10000];
        String[][] openrazb = new String[10000][20];
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
        LrazmerKorpusa = Integer.parseInt(openrazb[1][0]);
        ThicknessRrazmerKorpusa = Integer.parseInt(openrazb[1][1]);

        n = rrr - 3;
        bd=new Bd[n];
        for (int i = 3; i < rrr; i++) {
            int mmm[]=new int[7];
            if(openrazb[i][4].trim().length()==0)mmm[0]=-1000;else mmm[0]=Integer.parseInt(openrazb[i][4]);
            if(openrazb[i][5].trim().length()==0)mmm[1]=-1000;else mmm[1]=Integer.parseInt(openrazb[i][5]);
            if(openrazb[i][6].trim().length()==0)mmm[2]=-1000;else mmm[2]=Integer.parseInt(openrazb[i][6]);
            if(openrazb[i][7].trim().length()==0)mmm[3]=-1000;else mmm[3]=Integer.parseInt(openrazb[i][7]);
            if(openrazb[i][8].trim().length()==0)mmm[4]=0;else mmm[4]=Integer.parseInt(openrazb[i][8]);
            if(openrazb[i][9].trim().length()==0)mmm[5]=0;else mmm[5]=Integer.parseInt(openrazb[i][9]);
            if(openrazb[i][10].trim().length()==0)mmm[6]=0;else mmm[6]=Integer.parseInt(openrazb[i][10]);
            try {
                bd[i - 3] = new Bd("№" +(i-2)+" "+ openrazb[i][0], Integer.parseInt(openrazb[i][1]),
                        Integer.parseInt(openrazb[i][2]), Integer.parseInt(openrazb[i][3]), mmm[0],
                        mmm[1], mmm[2], mmm[3], mmm[4], mmm[5],1);
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

        Ploskosti[] sssd = new Ploskosti[1000];

        sssd[0]=new Ploskosti("sads",(short)(Math.random()*333),(short)1,(short)1,(short)1,(short)1,(short)1,(short)1,(short)15000,
                35000001,4000001,(short)35000001,(short)35000001,(short)35000001,(short)35000001);
            sssd[0].dobavlpixels((short)3,(short)3,(short)3000,35000000);


        for(int j=0;j<100;j++) {
            sssd[j]=new Ploskosti("sads",(short)(Math.random()*333),(short)1,(short)1,(short)1,(short)15000,
                35000001,35000001,35000001,35000001,35000001,35000001);
            for (int i = 0; i < 3000000; i++) {
                sssd[j].dobavlpixels((short)1000, (short)1000,(short) 1000, i);
                sssd[j].dobavlpixels2((short)1000, (short)1000,(short) 1000, i);
                sssd[j].dobavlpixels3((short)1000, (short)1000,(short) 1000, i);
                sssd[j].dobavlpixels4((short)1000, (short)1000,(short) 1000, i);
                sssd[j].dobavlpixels5((short)1000, (short)1000,(short) 1000, i);
                sssd[j].dobavlpixels6((short)1000, (short)1000,(short) 1000, i);
            }
        }


    for(int i=0;i<bd.length;i++)
        System.out.println(bd[i].names()+" "+bd[i].width()+" "+bd[i].haight()+" "+bd[i].length()+" "+bd[i].coordX()+" "+
                bd[i].coordY()+" "+bd[i].coordZ()+" "+bd[i].ryadom()+" "+bd[i].angleX()+" "+bd[i].angleY());



        System.out.println("ok");
//System.out.println("  dfs"+ sssd[188].pixels(0,199999)+" "+sssd[188].pixels(1,199999)+" "+sssd[188].pixels(2,199999));





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
    private void handleSave(){

        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.TXT","*.*");
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(filter);
        if ( fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION ) {
            try ( FileWriter fw = new FileWriter(fc.getSelectedFile()) ) {
                fw.write("Widht Ploskost №1;Haight Ploskost №1;Widht Ploskost №2;Haight Ploskost №2;Widht Ploskost №3;Haight Ploskost №3;" +
                        "Widht Ploskost №4;Haight Ploskost №4;Widht Ploskost №5;Haight Ploskost №5;Widht Ploskost №6;Haight Ploskost №6 \r\n");
                fw.write(WrazmerPloskost1+";"+HrazmerPloskost1+";"+WrazmerPloskost1+";"+ HrazmerPloskost2+";"+ WrazmerPloskost3+";"+ HrazmerPloskost3+";"+
                        WrazmerPloskost4+";"+HrazmerPloskost4+";"+WrazmerPloskost5+";"+ HrazmerPloskost5+";"+ WrazmerPloskost6+";"+ HrazmerPloskost6+";"
                        + "\r\n");

                fw.write("Name;Width;Haight;Coord X;Coord Y;Ploskost;Ryadom;Angle;;;;\r\n");


                for(int i=0;i<ipl1;i++) {

                    String str = ploskost1[i].names();
                    String wsw = String.valueOf(str.charAt(1));
                    if (str.charAt(2) > 47 & str.charAt(2) < 58) {
                        wsw = wsw + String.valueOf(str.charAt(2));
                        if (str.charAt(3) > 47 & str.charAt(3) < 58) {
                            wsw = wsw + String.valueOf(str.charAt(3));
                        }
                    }
                    fw.write(wsw + ";" + ploskost1[i].width() + ";" + ploskost1[i].haight() + ";" + ploskost1[i].coordX() + ";" + ploskost1[i].coordY() + ";"
                            + 0 + ";" + 0 + ";" + ploskost1[i].angle() + "\r\n");
                }

                for(int i=0;i<ipl2;i++) {
                    String str = ploskost2[i].names();
                    String wsw = String.valueOf(str.charAt(1));
                    if (str.charAt(2) > 47 & str.charAt(2) < 58) {
                        wsw = wsw + String.valueOf(str.charAt(2));
                        if (str.charAt(3) > 47 & str.charAt(3) < 58) {
                            wsw = wsw + String.valueOf(str.charAt(3));
                        }
                    }
                    fw.write(wsw + ";" + ploskost2[i].width() + ";" + ploskost2[i].haight() + ";" + ploskost2[i].coordX() + ";" + ploskost2[i].coordY() + ";"
                            + 1 + ";" + 0 + ";" + ploskost2[i].angle() + "\r\n");
                }
                for(int i=0;i<ipl3;i++) {
                    String str = ploskost3[i].names();
                    String wsw = String.valueOf(str.charAt(1));
                    if (str.charAt(2) > 47 & str.charAt(2) < 58) {
                        wsw = wsw + String.valueOf(str.charAt(2));
                        if (str.charAt(3) > 47 & str.charAt(3) < 58) {
                            wsw = wsw + String.valueOf(str.charAt(3));
                        }
                    }
                    fw.write(wsw + ";" + ploskost3[i].width() + ";" + ploskost3[i].haight() + ";" + ploskost3[i].coordX() + ";" + ploskost3[i].coordY() + ";"
                            + 2 + ";" + 0 + ";" + ploskost3[i].angle() + "\r\n");
                }

                for(int i=0;i<ipl4;i++) {
                    String str = ploskost4[i].names();
                    String wsw = String.valueOf(str.charAt(1));
                    if (str.charAt(2) > 47 & str.charAt(2) < 58) {
                        wsw = wsw + String.valueOf(str.charAt(2));
                        if (str.charAt(3) > 47 & str.charAt(3) < 58) {
                            wsw = wsw + String.valueOf(str.charAt(3));
                        }
                    }
                    fw.write(wsw + ";" + ploskost4[i].width() + ";" + ploskost4[i].haight() + ";" + ploskost4[i].coordX() + ";" + ploskost4[i].coordY() + ";"
                            + 3 + ";" + 0 + ";" + ploskost4[i].angle() + "\r\n");
                }

                for(int i=0;i<ipl5;i++) {
                    String str = ploskost5[i].names();
                    String wsw = String.valueOf(str.charAt(1));
                    if (str.charAt(2) > 47 & str.charAt(2) < 58) {
                        wsw = wsw + String.valueOf(str.charAt(2));
                        if (str.charAt(3) > 47 & str.charAt(3) < 58) {
                            wsw = wsw + String.valueOf(str.charAt(3));
                        }
                    }
                    fw.write(wsw + ";" + ploskost5[i].width() + ";" + ploskost5[i].haight() + ";" + ploskost5[i].coordX() + ";" + ploskost5[i].coordY() + ";"
                            + 4 + ";" + 0 + ";" + ploskost5[i].angle() + "\r\n");
                }

                for(int i=0;i<ipl6;i++) {
                    String str = ploskost6[i].names();
                    String wsw = String.valueOf(str.charAt(1));
                    if (str.charAt(2) > 47 & str.charAt(2) < 58) {
                        wsw = wsw + String.valueOf(str.charAt(2));
                        if (str.charAt(3) > 47 & str.charAt(3) < 58) {
                            wsw = wsw + String.valueOf(str.charAt(3));
                        }
                    }
                    fw.write(wsw + ";" + ploskost6[i].width() + ";" + ploskost6[i].haight() + ";" + ploskost6[i].coordX() + ";" + ploskost6[i].coordY() + ";"
                            + 5 + ";" + 0 + ";" + ploskost6[i].angle() + "\r\n");
                }

            }
            catch ( IOException e ) {
            }
        }


    }





    @FXML
    private void handleCreate() {
        String bx1= coordXform.getText(); int bx2=0;
        if(coordXform.getText().trim().length() ==0) bx2=-1000; else bx2=Integer.parseInt(bx1);
        String by1= coordYform.getText(); int by2=0;
        if(coordYform.getText().trim().length() ==0) by2=-1000; else by2=Integer.parseInt(by1);
        String ba1= angleform.getText(); int ba2=0;
        if(angleform.getText().trim().length() ==0) ba2=0; else ba2=Integer.parseInt(ba1);





        try {reactangle[n]= new Bd("№"+(n+1)+" "+namesform.getText(),Integer.parseInt(widthform.getText()),
                Integer.parseInt(haightform.getText()),
                bx2,by2,ploskost,ryadom,ba2);
        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("Неверный формат строк!");
            alert.showAndWait();
        }

        Bd giv=reactangle[n];
        list.remove(n);
        String er=giv.names() ;
        list.add(er);
        list.add("Cоздание обьекта №"+(n+2));
        combobox1.setItems(list);
        combobox1.getSelectionModel().select(n+1);

        list2.add(er);
        combobox2.setItems(list2);


        combobox3.setItems(list3);
        combobox3.getSelectionModel().select(ploskost);

        combobox4.setItems(list3);
        combobox4.getSelectionModel().select(ploskostpostr);

        combobox2.getSelectionModel().selectedIndexProperty().
                addListener((ObservableValue<? extends Number> ov2, Number old_val2, Number new_val2)->{
                    ryadom=new_val2.intValue();
                });

        combobox3.getSelectionModel().selectedIndexProperty().
                addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val)->{
       ploskost=new_val.intValue();
        });

        combobox4.getSelectionModel().selectedIndexProperty().
                addListener((ObservableValue<? extends Number> ov4, Number old_val4, Number new_val4)->{
                    ploskostpostr=new_val4.intValue();
                });


        n++;n12++;
        namesform.clear();
        combobox2.getSelectionModel().select(0);

    }

    @FXML
    private void handleLocaterazmesh() throws IOException {
      //  metodrazmesh(); metodproverka();
      //  metodrazmeshryadom();
      //  metodrazmeshostaln();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText("Расчеты завершились.");
        alert.showAndWait();

        System.out.println("ok");}

    @FXML
    private void handleLocate() throws IOException {
       // if(ploskostpostr==0){

        //}
        Pane load = new Pane();
        Stage stage = new Stage();
        stage.setTitle("Ploskost №"+(ploskostpostr+1));
        Rectangle[] rectangle1 = new Rectangle[300];
        Text[] text = new Text[300];
        int nn=ploskostpostr==0?ipl1:ploskostpostr==1?ipl2:ploskostpostr==2?ipl3:ploskostpostr==3?ipl4:ploskostpostr==4?ipl5:ipl6;

        for(int i=0;i<=nn-1;i++) {
            Ploskosti razmeshenie=ploskost1[i];
            if(ploskostpostr==0)razmeshenie=ploskost1[i];else if(ploskostpostr==1)razmeshenie=ploskost2[i];
            else if(ploskostpostr==2)razmeshenie=ploskost3[i];else if(ploskostpostr==3)razmeshenie=ploskost4[i];
            else if(ploskostpostr==4)razmeshenie=ploskost5[i];else if(ploskostpostr==5)razmeshenie=ploskost6[i];

            rectangle1[i] = new Rectangle(razmeshenie.width(), razmeshenie.haight(), Color.rgb((int) (Math.random() * 254), (int) (Math.random() * 254), (int) (Math.random() * 254)));
            rectangle1[i].setTranslateX(razmeshenie.coordX());
            rectangle1[i].setTranslateY(razmeshenie.coordY());
            rectangle1[i].getTransforms().add(new Rotate(razmeshenie.angle(),0,0));

            String wsw = String.valueOf(razmeshenie.names().charAt(1));
            if (razmeshenie.names().charAt(2) > 47 & razmeshenie.names().charAt(2) < 58) {
                wsw = wsw + String.valueOf(razmeshenie.names().charAt(2));
                if (razmeshenie.names().charAt(3) > 47 & razmeshenie.names().charAt(3) < 58) {
                    wsw = wsw + String.valueOf(razmeshenie.names().charAt(3));
                }
            }


            text[i] = new Text("№"+wsw);
            text[i].setX(razmeshenie.coordX()+5);
            text[i].setY(razmeshenie.coordY()+15);
            text[i].setFont(new Font(10));
            text[i].getTransforms().add(new Rotate(razmeshenie.angle(), razmeshenie.coordX(), razmeshenie.coordY()));
            load.getChildren().addAll(rectangle1[i],text[i]);
            System.out.println("name "+razmeshenie.names()+" width "+razmeshenie.width()+" haight "+razmeshenie.haight()+
                    " coordX "+razmeshenie.coordX()+" coordY "+razmeshenie.coordY()
                    +" angle "+razmeshenie.angle());

        }

        ///
        int qqqW1 = ploskostpostr == 0 ? WrazmerPloskost1 : ploskostpostr == 1 ? WrazmerPloskost2 : ploskostpostr == 2 ? WrazmerPloskost3 : ploskostpostr == 3 ? WrazmerPloskost4 : ploskostpostr == 4 ? WrazmerPloskost5 : WrazmerPloskost6;
        int qqqH1 = ploskostpostr == 0 ? HrazmerPloskost1 : ploskostpostr == 1 ? HrazmerPloskost2 : ploskostpostr == 2 ? HrazmerPloskost3 : ploskostpostr == 3 ? HrazmerPloskost4 : ploskostpostr == 4 ? HrazmerPloskost5 : HrazmerPloskost6;
        Scene scene = new Scene(load,qqqW1,qqqH1);
        stage.setScene(scene);
        stage.show();
        System.out.println(ploskostpostr+"  "+nn);
    }


    /*
    private void metodrazmesh(){
       // int[][] qwertyy =new int[2][3000000];
        ipl1=0;ipl2=0;ipl3=0;ipl4=0;ipl5=0;ipl6=0;
        //создали цикл для размещения фигур с заданными координатами


        for(int i=0;i<n;i++) {
           // Ploskosti razmeshenie1=ploskost1[i];
            Bd razmeshenie1=reactangle[i];
            int verhnyaatochka1X=0;
            int verhnyaatochka1Y=0;
            int Pravayatochka2X=0;
            int Pravayatochka2Y=0;
            int levayatochka3X=0;
            int levayatochka3Y=0;
            double ddd=0;
            double ugol=0;
            int nizyaatochka4X=0;
            int nizyaatochka4Y=0;
            int srednyaatochka5X=0;
            int srednyaatochka5Y=0;
            //проверяем на заданность координат
            if (razmeshenie1.coordX() != -1000) {
                if(razmeshenie1.ryadom()==0) {
                    //координаты ключевых точек
                    verhnyaatochka1X = razmeshenie1.coordX();
                    verhnyaatochka1Y = razmeshenie1.coordY();
                    Pravayatochka2X = razmeshenie1.coordX() + (int) Math.ceil(razmeshenie1.width() * Math.sin(Math.toRadians(90 - razmeshenie1.angle())));
                    Pravayatochka2Y = razmeshenie1.coordY() + (int) Math.ceil(razmeshenie1.width() * Math.cos(Math.toRadians(90 - razmeshenie1.angle())));
                    levayatochka3X = razmeshenie1.coordX() - (int) Math.ceil(razmeshenie1.haight() * Math.sin(Math.toRadians(razmeshenie1.angle())));
                    levayatochka3Y = razmeshenie1.coordY() + (int) Math.ceil(razmeshenie1.haight() * Math.cos(Math.toRadians(razmeshenie1.angle())));

                    ddd = Math.sqrt(Math.pow(razmeshenie1.width(), 2) + Math.pow(razmeshenie1.haight(), 2));
                    ugol = Math.toDegrees(Math.asin(razmeshenie1.width() / ddd)) - razmeshenie1.angle();
                    if (ugol > 0) {
                        nizyaatochka4X = razmeshenie1.coordX() + (int) Math.ceil(ddd * Math.sin(Math.toRadians(ugol)));
                        nizyaatochka4Y = razmeshenie1.coordY() + (int) Math.ceil(ddd * Math.cos(Math.toRadians(ugol)));
                    } else {
                        nizyaatochka4X = razmeshenie1.coordX() - (int) Math.ceil(ddd * Math.sin(Math.toRadians(Math.abs(ugol))));
                        nizyaatochka4Y = razmeshenie1.coordY() + (int) Math.ceil(ddd * Math.cos(Math.toRadians(Math.abs(ugol))));
                    }
                    srednyaatochka5X = razmeshenie1.coordX();
                    if (nizyaatochka4X >= verhnyaatochka1X) {
                        srednyaatochka5Y = (razmeshenie1.coordX() - levayatochka3X) * (nizyaatochka4Y - levayatochka3Y) / (nizyaatochka4X - levayatochka3X) + levayatochka3Y;
                    } else {
                        srednyaatochka5Y = (razmeshenie1.coordX() - Pravayatochka2X) * (nizyaatochka4Y - Pravayatochka2Y) / (nizyaatochka4X - Pravayatochka2X) + Pravayatochka2Y;
                    }
                    int iii = 0;
                    //Заполняем первую плоскость
                    if (razmeshenie1.ploskost() == 0) {
                        ploskost1[ipl1] = new Ploskosti(
                                //0, 0, iii, iii,
                                razmeshenie1.names(),
                                razmeshenie1.coordX(), razmeshenie1.coordY(), razmeshenie1.angle(),
                                razmeshenie1.width(), razmeshenie1.haight());
                        if (razmeshenie1.angle() != 0) {
                            //пиксели первого треугольника
                            for (int Y = verhnyaatochka1Y; Y <= Pravayatochka2Y; Y++) {
                                int X1 = (Y - verhnyaatochka1Y) * (Pravayatochka2X - verhnyaatochka1X) / (Pravayatochka2Y - verhnyaatochka1Y) + verhnyaatochka1X;
                                for (int X = verhnyaatochka1X; X < X1; X++) {
                                    ploskost1[ipl1].dobavlpixels(X, Y, iii, iii);
                                    iii++;
                                }
                            }
                            //пиксели второго треугольника
                            for (int Y = verhnyaatochka1Y; Y <= levayatochka3Y; Y++) {
                                int X1 = (Y - verhnyaatochka1Y) * (levayatochka3X - verhnyaatochka1X) / (levayatochka3Y - verhnyaatochka1Y) + verhnyaatochka1X;
                                for (int X = verhnyaatochka1X; X > X1; X--) {
                                    ploskost1[ipl1].dobavlpixels(X, Y, iii, iii);
                                    iii++;
                                }
                            }
                            //пиклеси третего треугольника
                            for (int Y = levayatochka3Y; Y <= srednyaatochka5Y; Y++) {
                                int X1 = (Y - levayatochka3Y) * (nizyaatochka4X - levayatochka3X) / (nizyaatochka4Y - levayatochka3Y) + levayatochka3X;
                                for (int X = verhnyaatochka1X; X >= X1; X--) {
                                    ploskost1[ipl1].dobavlpixels(X, Y, iii, iii);
                                    iii++;
                                }
                            }
                            //пиксели четвертого треугольника
                            for (int Y = Pravayatochka2Y; Y <= srednyaatochka5Y; Y++) {
                                int X1 = (Y - Pravayatochka2Y) * (nizyaatochka4X - Pravayatochka2X) / (nizyaatochka4Y - Pravayatochka2Y) + Pravayatochka2X;
                                for (int X = verhnyaatochka1X; X <= X1; X++) {
                                    ploskost1[ipl1].dobavlpixels(X, Y, iii, iii);
                                    iii++;
                                }
                            }
                            //пиксели пятого треугольника
                            for (int Y = srednyaatochka5Y; Y <= nizyaatochka4Y; Y++) {
                                int X1 = (Y - Pravayatochka2Y) * (nizyaatochka4X - Pravayatochka2X) / (nizyaatochka4Y - Pravayatochka2Y) + Pravayatochka2X;
                                for (int X = (Y - levayatochka3Y) * (nizyaatochka4X - levayatochka3X) / (nizyaatochka4Y - levayatochka3Y) + levayatochka3X; X <= X1; X++) {
                                    ploskost1[ipl1].dobavlpixels(X, Y, iii, iii);
                                    iii++;

                                }
                            }
                        } else {
                            //пиксели при 0 градусах
                            for (int Y = verhnyaatochka1Y; Y <= verhnyaatochka1Y + razmeshenie1.haight(); Y++) {
                                for (int X = verhnyaatochka1X; X <= verhnyaatochka1X + razmeshenie1.width(); X++) {
                                    ploskost1[ipl1].dobavlpixels(X, Y, iii, iii);
                                    iii++;

                                }
                            }
                        }

                        Ploskosti qaz = ploskost1[ipl1];
                        System.out.println(qaz.length1());
                        System.out.println(reactangle[1].ryadom());
                        ipl1++;
                    }else
                    //Заполнем вторую плоскость
                    if (razmeshenie1.ploskost() == 1) {
                        ploskost2[ipl2] = new Ploskosti(
                               // 0, 0, iii, iii,
                                razmeshenie1.names(),
                                razmeshenie1.coordX(), razmeshenie1.coordY(), razmeshenie1.angle(),
                                razmeshenie1.width(), razmeshenie1.haight());
                        if (razmeshenie1.angle() != 0) {
                            //пиксели первого треугольника
                            for (int Y = verhnyaatochka1Y; Y <= Pravayatochka2Y; Y++) {
                                int X1 = (Y - verhnyaatochka1Y) * (Pravayatochka2X - verhnyaatochka1X) / (Pravayatochka2Y - verhnyaatochka1Y) + verhnyaatochka1X;
                                for (int X = verhnyaatochka1X; X < X1; X++) {
                                    ploskost2[ipl2].dobavlpixels(X, Y, iii, iii);
                                    iii++;
                                }
                            }
                            //пиксели второго треугольника
                            for (int Y = verhnyaatochka1Y; Y <= levayatochka3Y; Y++) {
                                int X1 = (Y - verhnyaatochka1Y) * (levayatochka3X - verhnyaatochka1X) / (levayatochka3Y - verhnyaatochka1Y) + verhnyaatochka1X;
                                for (int X = verhnyaatochka1X; X > X1; X--) {
                                    ploskost2[ipl2].dobavlpixels(X, Y, iii, iii);
                                    iii++;
                                }
                            }
                            //пиклеси третего треугольника
                            for (int Y = levayatochka3Y; Y <= srednyaatochka5Y; Y++) {
                                int X1 = (Y - levayatochka3Y) * (nizyaatochka4X - levayatochka3X) / (nizyaatochka4Y - levayatochka3Y) + levayatochka3X;
                                for (int X = verhnyaatochka1X; X >= X1; X--) {
                                    ploskost2[ipl2].dobavlpixels(X, Y, iii, iii);
                                    iii++;
                                }
                            }
                            //пиксели четвертого треугольника
                            for (int Y = Pravayatochka2Y; Y <= srednyaatochka5Y; Y++) {
                                int X1 = (Y - Pravayatochka2Y) * (nizyaatochka4X - Pravayatochka2X) / (nizyaatochka4Y - Pravayatochka2Y) + Pravayatochka2X;
                                for (int X = verhnyaatochka1X; X <= X1; X++) {
                                    ploskost2[ipl2].dobavlpixels(X, Y, iii, iii);
                                    iii++;
                                }
                            }
                            //пиксели пятого треугольника
                            for (int Y = srednyaatochka5Y; Y <= nizyaatochka4Y; Y++) {
                                int X1 = (Y - Pravayatochka2Y) * (nizyaatochka4X - Pravayatochka2X) / (nizyaatochka4Y - Pravayatochka2Y) + Pravayatochka2X;
                                for (int X = (Y - levayatochka3Y) * (nizyaatochka4X - levayatochka3X) / (nizyaatochka4Y - levayatochka3Y) + levayatochka3X; X <= X1; X++) {
                                    ploskost2[ipl2].dobavlpixels(X, Y, iii, iii);
                                    iii++;
                                }
                            }
                        } else {
                            //пиксели при 0 градусах
                            for (int Y = verhnyaatochka1Y; Y <= verhnyaatochka1Y + razmeshenie1.haight(); Y++) {
                                for (int X = verhnyaatochka1X; X <= verhnyaatochka1X + razmeshenie1.width(); X++) {
                                    ploskost2[ipl2].dobavlpixels(X, Y, iii, iii);
                                    iii++;
                                }
                            }
                        }

                        Ploskosti qaz = ploskost2[ipl2];
                        System.out.println(qaz.length1());
                        System.out.println(reactangle[1].ryadom());
                        ipl2++;
                    }else
                    //Заполнем третью плоскость
                        if (razmeshenie1.ploskost() == 2) {
                            ploskost3[ipl3] = new Ploskosti(
                                    //0, 0, iii, iii,
                                    razmeshenie1.names(),
                                    razmeshenie1.coordX(), razmeshenie1.coordY(), razmeshenie1.angle(),
                                    razmeshenie1.width(), razmeshenie1.haight());
                            if (razmeshenie1.angle() != 0) {
                                //пиксели первого треугольника
                                for (int Y = verhnyaatochka1Y; Y <= Pravayatochka2Y; Y++) {
                                    int X1 = (Y - verhnyaatochka1Y) * (Pravayatochka2X - verhnyaatochka1X) / (Pravayatochka2Y - verhnyaatochka1Y) + verhnyaatochka1X;
                                    for (int X = verhnyaatochka1X; X < X1; X++) {
                                        ploskost3[ipl3].dobavlpixels(X, Y, iii, iii);
                                        iii++;
                                    }
                                }
                                //пиксели второго треугольника
                                for (int Y = verhnyaatochka1Y; Y <= levayatochka3Y; Y++) {
                                    int X1 = (Y - verhnyaatochka1Y) * (levayatochka3X - verhnyaatochka1X) / (levayatochka3Y - verhnyaatochka1Y) + verhnyaatochka1X;
                                    for (int X = verhnyaatochka1X; X > X1; X--) {
                                        ploskost3[ipl3].dobavlpixels(X, Y, iii, iii);
                                        iii++;
                                    }
                                }
                                //пиклеси третего треугольника
                                for (int Y = levayatochka3Y; Y <= srednyaatochka5Y; Y++) {
                                    int X1 = (Y - levayatochka3Y) * (nizyaatochka4X - levayatochka3X) / (nizyaatochka4Y - levayatochka3Y) + levayatochka3X;
                                    for (int X = verhnyaatochka1X; X >= X1; X--) {
                                        ploskost3[ipl3].dobavlpixels(X, Y, iii, iii);
                                        iii++;
                                    }
                                }
                                //пиксели четвертого треугольника
                                for (int Y = Pravayatochka2Y; Y <= srednyaatochka5Y; Y++) {
                                    int X1 = (Y - Pravayatochka2Y) * (nizyaatochka4X - Pravayatochka2X) / (nizyaatochka4Y - Pravayatochka2Y) + Pravayatochka2X;
                                    for (int X = verhnyaatochka1X; X <= X1; X++) {
                                        ploskost3[ipl3].dobavlpixels(X, Y, iii, iii);
                                        iii++;
                                    }
                                }
                                //пиксели пятого треугольника
                                for (int Y = srednyaatochka5Y; Y <= nizyaatochka4Y; Y++) {
                                    int X1 = (Y - Pravayatochka2Y) * (nizyaatochka4X - Pravayatochka2X) / (nizyaatochka4Y - Pravayatochka2Y) + Pravayatochka2X;
                                    for (int X = (Y - levayatochka3Y) * (nizyaatochka4X - levayatochka3X) / (nizyaatochka4Y - levayatochka3Y) + levayatochka3X; X <= X1; X++) {
                                        ploskost3[ipl3].dobavlpixels(X, Y, iii, iii);
                                        iii++;
                                    }
                                }
                            } else {
                                //пиксели при 0 градусах
                                for (int Y = verhnyaatochka1Y; Y <= verhnyaatochka1Y + razmeshenie1.haight(); Y++) {
                                    for (int X = verhnyaatochka1X; X <= verhnyaatochka1X + razmeshenie1.width(); X++) {
                                        ploskost3[ipl3].dobavlpixels(X, Y, iii, iii);
                                        iii++;
                                    }
                                }
                            }

                            Ploskosti qaz = ploskost3[ipl3];
                            System.out.println(qaz.length1());
                            System.out.println(reactangle[1].ryadom());
                            ipl3++;
                        }else
                    //заполныем четвертую плоскость
                            if (razmeshenie1.ploskost() == 3) {
                                ploskost4[ipl4] = new Ploskosti(
                                        //0, 0, iii, iii,
                                        razmeshenie1.names(),
                                        razmeshenie1.coordX(), razmeshenie1.coordY(), razmeshenie1.angle(),
                                        razmeshenie1.width(), razmeshenie1.haight());
                                if (razmeshenie1.angle() != 0) {
                                    //пиксели первого треугольника
                                    for (int Y = verhnyaatochka1Y; Y <= Pravayatochka2Y; Y++) {
                                        int X1 = (Y - verhnyaatochka1Y) * (Pravayatochka2X - verhnyaatochka1X) / (Pravayatochka2Y - verhnyaatochka1Y) + verhnyaatochka1X;
                                        for (int X = verhnyaatochka1X; X < X1; X++) {
                                            ploskost4[ipl4].dobavlpixels(X, Y, iii, iii);
                                            iii++;
                                        }
                                    }
                                    //пиксели второго треугольника
                                    for (int Y = verhnyaatochka1Y; Y <= levayatochka3Y; Y++) {
                                        int X1 = (Y - verhnyaatochka1Y) * (levayatochka3X - verhnyaatochka1X) / (levayatochka3Y - verhnyaatochka1Y) + verhnyaatochka1X;
                                        for (int X = verhnyaatochka1X; X > X1; X--) {
                                            ploskost4[ipl4].dobavlpixels(X, Y, iii, iii);
                                            iii++;
                                        }
                                    }
                                    //пиклеси третего треугольника
                                    for (int Y = levayatochka3Y; Y <= srednyaatochka5Y; Y++) {
                                        int X1 = (Y - levayatochka3Y) * (nizyaatochka4X - levayatochka3X) / (nizyaatochka4Y - levayatochka3Y) + levayatochka3X;
                                        for (int X = verhnyaatochka1X; X >= X1; X--) {
                                            ploskost4[ipl4].dobavlpixels(X, Y, iii, iii);
                                            iii++;
                                        }
                                    }
                                    //пиксели четвертого треугольника
                                    for (int Y = Pravayatochka2Y; Y <= srednyaatochka5Y; Y++) {
                                        int X1 = (Y - Pravayatochka2Y) * (nizyaatochka4X - Pravayatochka2X) / (nizyaatochka4Y - Pravayatochka2Y) + Pravayatochka2X;
                                        for (int X = verhnyaatochka1X; X <= X1; X++) {
                                            ploskost4[ipl4].dobavlpixels(X, Y, iii, iii);
                                            iii++;
                                        }
                                    }
                                    //пиксели пятого треугольника
                                    for (int Y = srednyaatochka5Y; Y <= nizyaatochka4Y; Y++) {
                                        int X1 = (Y - Pravayatochka2Y) * (nizyaatochka4X - Pravayatochka2X) / (nizyaatochka4Y - Pravayatochka2Y) + Pravayatochka2X;
                                        for (int X = (Y - levayatochka3Y) * (nizyaatochka4X - levayatochka3X) / (nizyaatochka4Y - levayatochka3Y) + levayatochka3X; X <= X1; X++) {
                                            ploskost4[ipl4].dobavlpixels(X, Y, iii, iii);
                                            iii++;
                                        }
                                    }
                                } else {
                                    //пиксели при 0 градусах
                                    for (int Y = verhnyaatochka1Y; Y <= verhnyaatochka1Y + razmeshenie1.haight(); Y++) {
                                        for (int X = verhnyaatochka1X; X <= verhnyaatochka1X + razmeshenie1.width(); X++) {
                                            ploskost4[ipl4].dobavlpixels(X, Y, iii, iii);
                                            iii++;
                                        }
                                    }
                                }

                                Ploskosti qaz = ploskost4[ipl4];
                                System.out.println(qaz.length1());
                                System.out.println(reactangle[1].ryadom());
                                ipl4++;
                            }else
                            //Заполнем пятую плоскость
                    if (razmeshenie1.ploskost() == 4) {
                        ploskost5[ipl5] = new Ploskosti(
                                //0, 0, iii, iii,
                                razmeshenie1.names(),
                                razmeshenie1.coordX(), razmeshenie1.coordY(), razmeshenie1.angle(),
                                razmeshenie1.width(), razmeshenie1.haight());
                        if (razmeshenie1.angle() != 0) {
                            //пиксели первого треугольника
                            for (int Y = verhnyaatochka1Y; Y <= Pravayatochka2Y; Y++) {
                                int X1 = (Y - verhnyaatochka1Y) * (Pravayatochka2X - verhnyaatochka1X) / (Pravayatochka2Y - verhnyaatochka1Y) + verhnyaatochka1X;
                                for (int X = verhnyaatochka1X; X < X1; X++) {
                                    ploskost5[ipl5].dobavlpixels(X, Y, iii, iii);
                                    iii++;
                                }
                            }
                            //пиксели второго треугольника
                            for (int Y = verhnyaatochka1Y; Y <= levayatochka3Y; Y++) {
                                int X1 = (Y - verhnyaatochka1Y) * (levayatochka3X - verhnyaatochka1X) / (levayatochka3Y - verhnyaatochka1Y) + verhnyaatochka1X;
                                for (int X = verhnyaatochka1X; X > X1; X--) {
                                    ploskost5[ipl5].dobavlpixels(X, Y, iii, iii);
                                    iii++;
                                }
                            }
                            //пиклеси третего треугольника
                            for (int Y = levayatochka3Y; Y <= srednyaatochka5Y; Y++) {
                                int X1 = (Y - levayatochka3Y) * (nizyaatochka4X - levayatochka3X) / (nizyaatochka4Y - levayatochka3Y) + levayatochka3X;
                                for (int X = verhnyaatochka1X; X >= X1; X--) {
                                    ploskost5[ipl5].dobavlpixels(X, Y, iii, iii);
                                    iii++;

                                }
                            }
                            //пиксели четвертого треугольника
                            for (int Y = Pravayatochka2Y; Y <= srednyaatochka5Y; Y++) {
                                int X1 = (Y - Pravayatochka2Y) * (nizyaatochka4X - Pravayatochka2X) / (nizyaatochka4Y - Pravayatochka2Y) + Pravayatochka2X;
                                for (int X = verhnyaatochka1X; X <= X1; X++) {
                                    ploskost5[ipl5].dobavlpixels(X, Y, iii, iii);
                                    iii++;

                                }
                            }
                            //пиксели пятого треугольника
                            for (int Y = srednyaatochka5Y; Y <= nizyaatochka4Y; Y++) {
                                int X1 = (Y - Pravayatochka2Y) * (nizyaatochka4X - Pravayatochka2X) / (nizyaatochka4Y - Pravayatochka2Y) + Pravayatochka2X;
                                for (int X = (Y - levayatochka3Y) * (nizyaatochka4X - levayatochka3X) / (nizyaatochka4Y - levayatochka3Y) + levayatochka3X; X <= X1; X++) {
                                    ploskost5[ipl5].dobavlpixels(X, Y, iii, iii);
                                    iii++;

                                }
                            }
                        } else {
                            //пиксели при 0 градусах
                            for (int Y = verhnyaatochka1Y; Y <= verhnyaatochka1Y + razmeshenie1.haight(); Y++) {
                                for (int X = verhnyaatochka1X; X <= verhnyaatochka1X + razmeshenie1.width(); X++) {
                                    ploskost5[ipl5].dobavlpixels(X, Y, iii, iii);
                                    iii++;

                                }
                            }
                        }

                        Ploskosti qaz = ploskost5[ipl5];
                        System.out.println(qaz.length1());
                        System.out.println(reactangle[1].ryadom());
                        ipl5++;
                    }else
                        //Заполняем шестую плоскость
                        if (razmeshenie1.ploskost() == 5) {
                            ploskost6[ipl6] = new Ploskosti(
                                    //0, 0, iii, iii,
                                     razmeshenie1.names(),
                                    razmeshenie1.coordX(), razmeshenie1.coordY(), razmeshenie1.angle(),
                                    razmeshenie1.width(), razmeshenie1.haight());
                            if (razmeshenie1.angle() != 0) {
                                //пиксели первого треугольника
                                for (int Y = verhnyaatochka1Y; Y <= Pravayatochka2Y; Y++) {
                                    int X1 = (Y - verhnyaatochka1Y) * (Pravayatochka2X - verhnyaatochka1X) / (Pravayatochka2Y - verhnyaatochka1Y) + verhnyaatochka1X;
                                    for (int X = verhnyaatochka1X; X < X1; X++) {
                                        ploskost6[ipl6].dobavlpixels(X, Y, iii, iii);
                                        iii++;

                                    }
                                }
                                //пиксели второго треугольника
                                for (int Y = verhnyaatochka1Y; Y <= levayatochka3Y; Y++) {
                                    int X1 = (Y - verhnyaatochka1Y) * (levayatochka3X - verhnyaatochka1X) / (levayatochka3Y - verhnyaatochka1Y) + verhnyaatochka1X;
                                    for (int X = verhnyaatochka1X; X > X1; X--) {
                                        ploskost6[ipl6].dobavlpixels(X, Y, iii, iii);
                                        iii++;

                                    }
                                }
                                //пиклеси третего треугольника
                                for (int Y = levayatochka3Y; Y <= srednyaatochka5Y; Y++) {
                                    int X1 = (Y - levayatochka3Y) * (nizyaatochka4X - levayatochka3X) / (nizyaatochka4Y - levayatochka3Y) + levayatochka3X;
                                    for (int X = verhnyaatochka1X; X >= X1; X--) {
                                        ploskost6[ipl6].dobavlpixels(X, Y, iii, iii);
                                        iii++;

                                    }
                                }
                                //пиксели четвертого треугольника
                                for (int Y = Pravayatochka2Y; Y <= srednyaatochka5Y; Y++) {
                                    int X1 = (Y - Pravayatochka2Y) * (nizyaatochka4X - Pravayatochka2X) / (nizyaatochka4Y - Pravayatochka2Y) + Pravayatochka2X;
                                    for (int X = verhnyaatochka1X; X <= X1; X++) {
                                        ploskost6[ipl6].dobavlpixels(X, Y, iii, iii);
                                        iii++;

                                    }
                                }
                                //пиксели пятого треугольника
                                for (int Y = srednyaatochka5Y; Y <= nizyaatochka4Y; Y++) {
                                    int X1 = (Y - Pravayatochka2Y) * (nizyaatochka4X - Pravayatochka2X) / (nizyaatochka4Y - Pravayatochka2Y) + Pravayatochka2X;
                                    for (int X = (Y - levayatochka3Y) * (nizyaatochka4X - levayatochka3X) / (nizyaatochka4Y - levayatochka3Y) + levayatochka3X; X <= X1; X++) {
                                        ploskost6[ipl6].dobavlpixels(X, Y, iii, iii);
                                        iii++;

                                    }
                                }
                            } else {
                                //пиксели при 0 градусах
                                for (int Y = verhnyaatochka1Y; Y <= verhnyaatochka1Y + razmeshenie1.haight(); Y++) {
                                    for (int X = verhnyaatochka1X; X <= verhnyaatochka1X + razmeshenie1.width(); X++) {
                                        ploskost6[ipl6].dobavlpixels(X, Y, iii, iii);
                                        iii++;

                                    }
                                }
                            }

                            Ploskosti qaz = ploskost6[ipl6];
                            System.out.println(qaz.length1());
                            System.out.println(reactangle[1].ryadom());
                            ipl6++;
                        }
                }
            }
        }

    }
    //проверяем не налазят ли обьекты друг нa друга
    private void metodproverka(){label1:
        for(int i=0;i<ipl1;i++) {
            Ploskosti nachalnii = ploskost1[i];
            for (int j = 1+i ; j < ipl1; j++) {
                Ploskosti konechnij = ploskost1[j];
                for (int ii = 0;ii<nachalnii.length1()-1;ii++) {
                    for (int jj = 0;jj<konechnij.length1()-1;jj++) {

                        if (nachalnii.pixels(0, ii) == konechnij.pixels(0, jj) & nachalnii.pixels(1, ii) == konechnij.pixels(1, jj)) {
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setHeaderText("Объекты плоскости 1 " + i + " и " + j + " налазят друг на друга");
                            alert.setContentText("x1="+nachalnii.pixels(0, ii)+" x2="+konechnij.pixels(0, jj)+";  y1="+nachalnii.pixels(1, ii)+" y2="+konechnij.pixels(1, jj) );
                            alert.showAndWait(); break label1;
                        }
                    }
                }
            }
        }label11:
        for(int i=0;i<ipl2;i++) {
            Ploskosti nachalnii = ploskost2[i];
            for (int j = 1+i ; j < ipl2; j++) {
                Ploskosti konechnij = ploskost2[j];
                for (int ii = 0;ii<nachalnii.length1()-1;ii++) {
                    for (int jj = 0; jj < konechnij.length1() - 1; jj++) {
                        if (nachalnii.pixels(0, ii) == konechnij.pixels(0, jj) & nachalnii.pixels(1, ii) == konechnij.pixels(1, jj)) {
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setHeaderText("Объекты плоскости 2 " + i + " и " + j + " налазят друг на друга");
                            alert.setContentText("x1=" + nachalnii.pixels(0, ii) + " x2=" + konechnij.pixels(0, jj) + ";  y1=" + nachalnii.pixels(1, ii) + " y2=" + konechnij.pixels(1, jj));
                            alert.showAndWait();
                            break label11;
                        }
                    }
                }
            }
        }label11:
        for(int i=0;i<ipl3;i++) {
            Ploskosti nachalnii = ploskost3[i];
            for (int j = 1+i ; j < ipl3; j++) {
                Ploskosti konechnij = ploskost3[j];
                for (int ii = 0;ii<nachalnii.length1()-1;ii++) {
                    for (int jj = 0; jj < konechnij.length1() - 1; jj++) {

                        if (nachalnii.pixels(0, ii) == konechnij.pixels(0, jj) & nachalnii.pixels(1, ii) == konechnij.pixels(1, jj)) {
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setHeaderText("Объекты плоскости 3 " + i + " и " + j + " налазят друг на друга");
                            alert.setContentText("x1=" + nachalnii.pixels(0, ii) + " x2=" + konechnij.pixels(0, jj) + ";  y1=" + nachalnii.pixels(1, ii) + " y2=" + konechnij.pixels(1, jj));
                            alert.showAndWait();
                            break label11;
                        }
                    }
                }
            }
        }label11:
        for(int i=0;i<ipl4;i++) {
            Ploskosti nachalnii = ploskost4[i];
            for (int j = 1 + i; j < ipl4; j++) {
                Ploskosti konechnij = ploskost4[j];
                for (int ii = 0; ii < nachalnii.length1() - 1; ii++) {
                    for (int jj = 0; jj < konechnij.length1() - 1; jj++) {

                        if (nachalnii.pixels(0, ii) == konechnij.pixels(0, jj) & nachalnii.pixels(1, ii) == konechnij.pixels(1, jj)) {
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setHeaderText("Объекты плоскости 3 " + i + " и " + j + " налазят друг на друга");
                            alert.setContentText("x1=" + nachalnii.pixels(0, ii) + " x2=" + konechnij.pixels(0, jj) + ";  y1=" + nachalnii.pixels(1, ii) + " y2=" + konechnij.pixels(1, jj));
                            alert.showAndWait();
                            break label11;
                        }
                    }
                }
            }
        }label11:
        for(int i=0;i<ipl5;i++) {
            Ploskosti nachalnii = ploskost5[i];
            for (int j = 1 + i; j < ipl5; j++) {
                Ploskosti konechnij = ploskost5[j];
                for (int ii = 0; ii < nachalnii.length1() - 1; ii++) {
                    for (int jj = 0; jj < konechnij.length1() - 1; jj++) {

                        if (nachalnii.pixels(0, ii) == konechnij.pixels(0, jj) & nachalnii.pixels(1, ii) == konechnij.pixels(1, jj)) {
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setHeaderText("Объекты плоскости 3 " + i + " и " + j + " налазят друг на друга");
                            alert.setContentText("x1=" + nachalnii.pixels(0, ii) + " x2=" + konechnij.pixels(0, jj) + ";  y1=" + nachalnii.pixels(1, ii) + " y2=" + konechnij.pixels(1, jj));
                            alert.showAndWait();
                            break label11;
                        }
                    }
                }
            }
        }label11:
        for(int i=0;i<ipl6;i++) {
            Ploskosti nachalnii = ploskost6[i];
            for (int j = 1 + i; j < ipl6; j++) {
                Ploskosti konechnij = ploskost6[j];
                for (int ii = 0; ii < nachalnii.length1() - 1; ii++) {
                    for (int jj = 0; jj < konechnij.length1() - 1; jj++) {

                        if (nachalnii.pixels(0, ii) == konechnij.pixels(0, jj) & nachalnii.pixels(1, ii) == konechnij.pixels(1, jj)) {
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setHeaderText("Объекты плоскости 6 " + i + " и " + j + " налазят друг на друга");
                            alert.setContentText("x1=" + nachalnii.pixels(0, ii) + " x2=" + konechnij.pixels(0, jj) + ";  y1=" + nachalnii.pixels(1, ii) + " y2=" + konechnij.pixels(1, jj));
                            alert.showAndWait();
                            break label11;
                        }
                    }
                }
            }
        }label11:
        for(int qwq=0;qwq<6;qwq++) {
            int wwwq = qwq == 0 ? ipl1 : qwq == 1 ? ipl2 : qwq == 2 ? ipl3 : qwq == 3 ? ipl4 : qwq == 4 ? ipl5 : ipl6;
            int qqqW = qwq == 0 ? WrazmerPloskost1 : qwq == 1 ? WrazmerPloskost2 : qwq == 2 ? WrazmerPloskost3 : qwq == 3 ? WrazmerPloskost4 : qwq == 4 ? WrazmerPloskost5 : WrazmerPloskost6;
            int qqqH = qwq == 0 ? HrazmerPloskost1 : qwq == 1 ? HrazmerPloskost2 : qwq == 2 ? HrazmerPloskost3 : qwq == 3 ? HrazmerPloskost4 : qwq == 4 ? HrazmerPloskost5 : HrazmerPloskost6;
            for (int i = 0; i < wwwq; i++) {
                Ploskosti nachalnii = qwq == 0 ? ploskost1[i] : qwq == 1 ? ploskost2[i] : qwq == 2 ? ploskost3[i] : qwq == 3 ? ploskost4[i] : qwq == 4 ? ploskost5[i] : ploskost6[i];
                for (int ii=0;ii<nachalnii.length1() - 1;ii++) {
                    if ((nachalnii.pixels(0, ii) < 0) | (nachalnii.pixels(0, ii) > qqqW)) {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setHeaderText("Объект " + nachalnii.names() + " выступает за границы плоскости "+(qwq+1)+" по координате Х");
                        alert.showAndWait(); break label11;
                    }
                    if ((nachalnii.pixels(1, ii) < 0) | (nachalnii.pixels(1, ii) > qqqH)) {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setHeaderText("Объект " + i + " выступает за границы плоскости "+(qwq+1)+" по координате Y");
                        alert.showAndWait();break label11;
                    }
                }
            }
        }


    }


    private void metodrazmeshryadom() {

        for (int i = 0; i < n; i++) {//переборка всего массива
            Bd razmeshenie1 = reactangle[i];
            if (razmeshenie1.coordX() == -1000 & razmeshenie1.ryadom() > 0) { //ищем с кем должна быть рядом
                int qwq = razmeshenie1.ploskost();
                int wwwq = qwq == 0 ? ipl1 : qwq == 1 ? ipl2 : qwq == 2 ? ipl3 : qwq == 3 ? ipl4 : qwq == 4 ? ipl5 : ipl6;
                int qqqW = qwq == 0 ? WrazmerPloskost1 : qwq == 1 ? WrazmerPloskost2 : qwq == 2 ? WrazmerPloskost3 : qwq == 3 ? WrazmerPloskost4 : qwq == 4 ? WrazmerPloskost5 : WrazmerPloskost6;
                int qqqH = qwq == 0 ? HrazmerPloskost1 : qwq == 1 ? HrazmerPloskost2 : qwq == 2 ? HrazmerPloskost3 : qwq == 3 ? HrazmerPloskost4 : qwq == 4 ? HrazmerPloskost5 : HrazmerPloskost6;

                for (int qwi = 0; qwi < wwwq; qwi++) {
                    Ploskosti nachalnii = qwq == 0 ? ploskost1[qwi] : qwq == 1 ? ploskost2[qwi] : qwq == 2 ? ploskost3[qwi] : qwq == 3 ? ploskost4[qwi] : qwq == 4 ? ploskost5[qwi] : ploskost6[qwi];

                    String str = nachalnii.names();
                    String wsw = String.valueOf(str.charAt(1));
                    if (str.charAt(2) > 47 & str.charAt(2) < 58) {
                        wsw = wsw + String.valueOf(str.charAt(2));
                        if (str.charAt(3) > 47 & str.charAt(3) < 58) {
                            wsw = wsw + String.valueOf(str.charAt(3));
                        }
                    }
                    if (razmeshenie1.ryadom() == Integer.parseInt(wsw)) {

                        ///
                        int rast = 15;
                        int ind = 0;
                        for (int ss = 0; ss < 10; ss++) {
                            //установка справа
                            Ploskosti Radom12 = new Ploskosti(
                                    //0, 0, 0, 0,
                                    razmeshenie1.names(), nachalnii.coordX() + razmeshenie1.width() + rast,
                                    nachalnii.coordY(), 0, razmeshenie1.width(), razmeshenie1.haight());
                            //пиксели при 0 градусах
                            int iii1 = 0;
                            for (int Y = Radom12.coordY(); Y <= Radom12.coordY() + Radom12.haight(); Y++) {
                                for (int X = Radom12.coordX(); X <= Radom12.coordX() + Radom12.width(); X++) {
                                    Radom12.dobavlpixels(X, Y, iii1, iii1);
                                    iii1++;

                                }
                            }
                            //проверка
                            label12:
                            if (ind == 0) {
                                if(Radom12.coordX() + Radom12.width() + rast>qqqW|Radom12.coordY() + Radom12.haight() >qqqH)break label12;
                                for (int i12 = 0; i12 < wwwq; i12++) {
                                    Ploskosti konechnij = qwq == 0 ? ploskost1[i12] : qwq == 1 ? ploskost2[i12] :
                                            qwq == 2 ? ploskost3[i12] : qwq == 3 ? ploskost4[i12] : qwq == 4 ? ploskost5[i12] : ploskost6[i12];

                                    for (int ii = 0; ii < Radom12.length1() - 1; ii++) {
                                        for (int jj = 0; jj < konechnij.length1() - 1; jj++) {
                                            if (Radom12.pixels(0, ii) == konechnij.pixels(0, jj) & Radom12.pixels(1, ii) == konechnij.pixels(1, jj)) {
                                                System.out.println("angle0эqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
                                                break label12;

                                            }
                                        }
                                    }
                                }
                                ind = 1;
                                    if(qwq==0){ploskost1[ipl1]=Radom12;ipl1++;}else if(qwq==1){ploskost2[ipl2]=Radom12;ipl2++;}else
                                        if(qwq==2){ploskost3[ipl3]=Radom12;ipl3++;}else if(qwq==3){ploskost4[ipl4]=Radom12;ipl4++;}else
                                            if(qwq==4){ploskost5[ipl5]=Radom12;ipl5++;}else{ploskost6[ipl6]=Radom12;ipl6++;}
                            }
                            //слева

                             Radom12 = new Ploskosti(
                                     //0, 0, 0, 0,
                                      razmeshenie1.names(), nachalnii.coordX() - razmeshenie1.width() - rast,
                                    nachalnii.coordY(), 0, razmeshenie1.width(), razmeshenie1.haight());
                            //пиксели при 0 градусах
                            iii1 = 0;
                            for (int Y = Radom12.coordY(); Y <= Radom12.coordY() + Radom12.haight(); Y++) {
                                for (int X = Radom12.coordX(); X <= Radom12.coordX() + Radom12.width(); X++) {
                                    Radom12.dobavlpixels(X, Y, iii1, iii1);
                                    iii1++;

                                }
                            }
                            //проверка
                            label12:
                            if (ind == 0) {
                                if(Radom12.coordX() <0|Radom12.coordY() + razmeshenie1.haight() >qqqH)break label12;
                                for (int i12 = 0; i12 < wwwq; i12++) {
                                    Ploskosti konechnij = qwq == 0 ? ploskost1[i12] : qwq == 1 ? ploskost2[i12] :
                                            qwq == 2 ? ploskost3[i12] : qwq == 3 ? ploskost4[i12] : qwq == 4 ? ploskost5[i12] : ploskost6[i12];
                                    for (int ii = 0; ii < Radom12.length1() - 1; ii++) {

                                        for (int jj = 0; jj < konechnij.length1() - 1; jj++) {

                                            if (Radom12.pixels(0, ii) == konechnij.pixels(0, jj) & Radom12.pixels(1, ii) == konechnij.pixels(1, jj)) {
                                                System.out.println("angle0эqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
                                                System.out.println(Radom12.coordX()+" "+Radom12.coordY()+" "+ konechnij.coordX()+" "+konechnij.coordY()+" "+konechnij.names());
                                                break label12;

                                            } //else{if(Radom12.coordX() <0|Radom12.coordY() + razmeshenie1.haight() >qqqH)break label12;}
                                        }
                                    }
                                }
                                ind = 1;
                                if(qwq==0){ploskost1[ipl1]=Radom12;ipl1++;}else if(qwq==1){ploskost2[ipl2]=Radom12;ipl2++;}else
                                if(qwq==2){ploskost3[ipl3]=Radom12;ipl3++;}else if(qwq==3){ploskost4[ipl4]=Radom12;ipl4++;}else
                                if(qwq==4){ploskost5[ipl5]=Radom12;ipl5++;}else{ploskost6[ipl6]=Radom12;ipl6++;}
                            }
                            //снизу

                            Radom12 = new Ploskosti(
                                    //0, 0, 0, 0,
                                    razmeshenie1.names(), nachalnii.coordX(),
                                    nachalnii.coordY()+razmeshenie1.haight()+rast, 0, razmeshenie1.width(), razmeshenie1.haight());
                            //пиксели при 0 градусах
                            iii1 = 0;
                            for (int Y = Radom12.coordY(); Y <= Radom12.coordY() + Radom12.haight(); Y++) {
                                for (int X = Radom12.coordX(); X <= Radom12.coordX() + Radom12.width(); X++) {
                                    Radom12.dobavlpixels(X, Y, iii1, iii1);
                                    iii1++;
                                }
                            }
                            //проверка
                            label12:
                            if (ind == 0) {
                                if(Radom12.coordX()+Radom12.width() >qqqW|Radom12.coordY() + Radom12.haight()+rast >qqqH)break label12;
                                for (int i12 = 0; i12 < wwwq; i12++) {
                                    Ploskosti konechnij = qwq == 0 ? ploskost1[i12] : qwq == 1 ? ploskost2[i12] :
                                            qwq == 2 ? ploskost3[i12] : qwq == 3 ? ploskost4[i12] : qwq == 4 ? ploskost5[i12] : ploskost6[i12];
                                    for (int ii = 0; ii < Radom12.length1() - 1; ii++) {
                                        for (int jj = 0; jj < konechnij.length1() - 1; jj++) {

                                            if (Radom12.pixels(0, ii) == konechnij.pixels(0, jj) & Radom12.pixels(1, ii) == konechnij.pixels(1, jj)) {
                                                System.out.println("angle0эqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
                                                System.out.println(Radom12.coordX()+" "+Radom12.coordY()+" "+ konechnij.coordX()+" "+konechnij.coordY());
                                                break label12;

                                            } //else{if(Radom12.coordX()+Radom12.width() >qqqW|Radom12.coordY() + razmeshenie1.haight() >qqqH)break label12;}
                                        }
                                    }
                                }
                                ind = 1;
                                if(qwq==0){ploskost1[ipl1]=Radom12;ipl1++;}else if(qwq==1){ploskost2[ipl2]=Radom12;ipl2++;}else
                                if(qwq==2){ploskost3[ipl3]=Radom12;ipl3++;}else if(qwq==3){ploskost4[ipl4]=Radom12;ipl4++;}else
                                if(qwq==4){ploskost5[ipl5]=Radom12;ipl5++;}else{ploskost6[ipl6]=Radom12;ipl6++;}
                            }
                            //сверху

                            Radom12 = new Ploskosti(
                                    //0, 0, 0, 0,
                                     razmeshenie1.names(), nachalnii.coordX() ,
                                    nachalnii.coordY()-razmeshenie1.haight()-rast, 0, razmeshenie1.width(), razmeshenie1.haight());
                            //пиксели при 0 градусах
                            iii1 = 0;
                            for (int Y = Radom12.coordY(); Y <= Radom12.coordY() + Radom12.haight(); Y++) {
                                for (int X = Radom12.coordX(); X <= Radom12.coordX() + Radom12.width(); X++) {
                                    Radom12.dobavlpixels(X, Y, iii1, iii1);
                                    iii1++;

                                }
                            }
                            //проверка
                            label12:
                            if (ind == 0) {
                                for (int i12 = 0; i12 < wwwq; i12++) {
                                   if( Radom12.coordX()+Radom12.width() >qqqW|Radom12.coordY() -rast <0)break label12;
                                    Ploskosti konechnij = qwq == 0 ? ploskost1[i12] : qwq == 1 ? ploskost2[i12] :
                                            qwq == 2 ? ploskost3[i12] : qwq == 3 ? ploskost4[i12] : qwq == 4 ? ploskost5[i12] : ploskost6[i12];
                                    for (int ii = 0; ii < Radom12.length1() - 1; ii++) {
                                        for (int jj = 0; jj < konechnij.length1() - 1; jj++) {

                                            if (Radom12.pixels(0, ii) == konechnij.pixels(0, jj) & Radom12.pixels(1, ii) == konechnij.pixels(1, jj)) {

                                                System.out.println(Radom12.coordX()+" "+Radom12.coordY()+" "+ konechnij.coordX()+" "+konechnij.coordY());
                                                break label12;

                                            } //else{if(Radom12.coordX()+Radom12.width() >qqqW|Radom12.coordY() - razmeshenie1.haight() <0)break label12;}
                                        }
                                    }
                                }
                                ind = 1;
                                if(qwq==0){ploskost1[ipl1]=Radom12;ipl1++;}else if(qwq==1){ploskost2[ipl2]=Radom12;ipl2++;}else
                                if(qwq==2){ploskost3[ipl3]=Radom12;ipl3++;}else if(qwq==3){ploskost4[ipl4]=Radom12;ipl4++;}else
                                if(qwq==4){ploskost5[ipl5]=Radom12;ipl5++;}else{ploskost6[ipl6]=Radom12;ipl6++;}
                            }
                            rast=rast+15;
                        }
                    }
                }

            }

        }

    }


    private void metodrazmeshostaln() {
        //переборка всего массива
        for (int i = 0; i < n; i++) {
            Bd razmeshenie1 = reactangle[i];
            System.out.print(" "+i);
            if (razmeshenie1.coordX() == -1000 & razmeshenie1.ryadom() == 0) {
                int qwq = razmeshenie1.ploskost();
                // присваиваем переменный значения в зависимости от того какая плоскость у полученного объекта
                int wwwq = qwq == 0 ? ipl1 : qwq == 1 ? ipl2 : qwq == 2 ? ipl3 : qwq == 3 ? ipl4 : qwq == 4 ? ipl5 : ipl6;
                int qqqW = qwq == 0 ? WrazmerPloskost1 : qwq == 1 ? WrazmerPloskost2 : qwq == 2 ? WrazmerPloskost3 : qwq == 3 ? WrazmerPloskost4 : qwq == 4 ? WrazmerPloskost5 : WrazmerPloskost6;
                int qqqH = qwq == 0 ? HrazmerPloskost1 : qwq == 1 ? HrazmerPloskost2 : qwq == 2 ? HrazmerPloskost3 : qwq == 3 ? HrazmerPloskost4 : qwq == 4 ? HrazmerPloskost5 : HrazmerPloskost6;

                //ind индикатор того что обьект можно устанавливать и не нужно дальше перемещать его
                int ind = 0;
                if (ind == 0) {
                    for (int rastY = 10; rastY < qqqH - razmeshenie1.haight(); rastY = rastY + 25) {
                        for (int rastX = 0; rastX < qqqW - razmeshenie1.width(); rastX = rastX + 25) {

                            Ploskosti Radom12 = new Ploskosti(
                                    //0, 0, 0, 0,
                                    razmeshenie1.names(), 15 + rastX,
                                    15 + rastY, 0, razmeshenie1.width(), razmeshenie1.haight());

                            int iii1 = 0;
                            for (int Y = Radom12.coordY(); Y <= Radom12.coordY() + Radom12.haight()+2; Y+=2) {

                                for (int X = Radom12.coordX(); X <= Radom12.coordX() + Radom12.width()+2; X+=2) {
                                    int vvvx=(int) (Math.random() * 2+X-1);
                                    int vvvy=(int) (Math.random() * 2+Y-1);
                                    Radom12.dobavlpixels(vvvx, vvvy, iii1, iii1);
                                    iii1++;
                                }
                            }
                            //проверка
                            label12:
                            if (ind == 0) {
                                //
                                for (int i12 = 0; i12 < wwwq; i12++) {
                                    Ploskosti konechnij = qwq == 0 ? ploskost1[i12] : qwq == 1 ? ploskost2[i12] :
                                            qwq == 2 ? ploskost3[i12] : qwq == 3 ? ploskost4[i12] : qwq == 4 ? ploskost5[i12] : ploskost6[i12];
                                    int coord1x=0;int coord2x=0;int coord1y=0;int coord2y=0;
                                    if(konechnij.angle()==0){
                                    //координаты граничных точек
                                     coord1x=konechnij.coordX()+konechnij.width()+7; coord2x=konechnij.coordX()-7;
                                     coord1y=konechnij.coordY()-7; coord2y=konechnij.coordY()+konechnij.haight()+7;}else{
                                         coord1x=konechnij.coordX() + (int) Math.ceil(konechnij.width() * Math.sin(Math.toRadians(90 - konechnij.angle())));
                                        coord2x=konechnij.coordX() - (int) Math.ceil(konechnij.width() * Math.sin(Math.toRadians(konechnij.angle())));
                                         coord1y=konechnij.coordY()-1;
                                       double ddd = Math.sqrt(Math.pow(konechnij.width(), 2) + Math.pow(konechnij.haight(), 2));
                                       double  ugol = Math.toDegrees(Math.asin(konechnij.width() / ddd)) - konechnij.angle();
                                         coord2y=konechnij.coordY() + (int) Math.ceil(ddd * Math.cos(Math.toRadians(ugol)));
                                        }

                                    //проверка на попадание в зону
                                     if((Radom12.coordX()>=coord2x & Radom12.coordX()<coord1x)|(Radom12.coordX()+Radom12.width()+2>=coord2x & Radom12.coordX()+Radom12.width()+2<=coord1x)|
                                             (coord2x<=Radom12.coordX()+Radom12.width()&coord2x>=Radom12.coordX())|(coord1x<=Radom12.coordX()+Radom12.width()&coord1x>=Radom12.coordX())   ){
                                        if((Radom12.coordY()>=coord1y & Radom12.coordY()<=coord2y)|(Radom12.coordY()+Radom12.haight()>=coord1y& Radom12.coordY()+Radom12.haight()<=coord2y)|
                                                (coord1y>=Radom12.coordY() & coord1y<=Radom12.coordY()+Radom12.haight())| (coord2y>=Radom12.coordY() & coord2y<=Radom12.coordY()+Radom12.haight())){

                                            for (int ii = 0; ii < Radom12.length1() - 1; ii++) {
                                                for (int jj = 0; jj < konechnij.length1() - 1; jj++) {
                                                    if (Radom12.pixels(0, ii) == konechnij.pixels(0, jj) & Radom12.pixels(1, ii) == konechnij.pixels(1, jj)) {
                                                        break label12;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                                    ind = 1;
                                //в зависомости от плоскости добавляем в нужный массив объектов полученный объект
                                    if (qwq == 0) {
                                        ploskost1[ipl1] = Radom12;
                                        ipl1++;
                                    } else if (qwq == 1) {
                                        ploskost2[ipl2] = Radom12;
                                        ipl2++;
                                    } else if (qwq == 2) {
                                        ploskost3[ipl3] = Radom12;
                                        ipl3++;
                                    } else if (qwq == 3) {
                                        ploskost4[ipl4] = Radom12;
                                        ipl4++;
                                    } else if (qwq == 4) {
                                        ploskost5[ipl5] = Radom12;
                                        ipl5++;
                                    } else {
                                        ploskost6[ipl6] = Radom12;
                                        ipl6++;
                                    }

                            }
                        }

                    }

                }
            }
        }

    }



    private void metodrazmeshangle() {
        for(int i=0;i<bd.length;i++){

        }




    }




}
*/