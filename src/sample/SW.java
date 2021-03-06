package sample;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by cik on 05.06.2017.
 */
public class SW {
    private int WrazmerKorpusa ;
    private int HrazmerKorpusa ;
    private int LrazmerKorpusa ;
    private int ThicknessRrazmerKorpusa ;
    private ArrayList<String> macros;
    private Ploskosti[] osnovnoi;
    int n;
    public SW(Ploskosti[] osnovnoi,int n, int WrazmerKorpusa,int HrazmerKorpusa,int LrazmerKorpusa,int ThicknessRrazmerKorpusa){
        this.osnovnoi=osnovnoi;
        this.n=n;
        this.WrazmerKorpusa=WrazmerKorpusa;
        this.HrazmerKorpusa=HrazmerKorpusa;
        this.LrazmerKorpusa=LrazmerKorpusa;
        this.ThicknessRrazmerKorpusa=ThicknessRrazmerKorpusa;

    }

    public void save(){

        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.TXT","*.*");
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(filter);
        if ( fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION ) {
            try ( FileWriter fw = new FileWriter(fc.getSelectedFile()) ) {
//korpus

                fw.write("' ******************************************************************************\n" +
                        "' C:\\Users\\cik\\AppData\\Local\\Temp\\swx7936\\Macro1.swb - macro recorded on 06/10/17 by cik\n" +
                        "' ******************************************************************************\n" +
                        "Dim swApp As Object\n" +
                        "\n" +
                        "Dim Part As Object\n" +
                        "Dim boolstatus As Boolean\n" +
                        "Dim longstatus As Long, longwarnings As Long\n" +
                        "\n" +
                        "Sub main()\n" +
                        "\n" +
                        "Set swApp = Application.SldWorks\n" +
                        "\n" +
                        "\n" +
                        "' New Document\n" +
                        "Dim swSheetWidth As Double\n" +
                        "swSheetWidth = 0\n" +
                        "Dim swSheetHeight As Double\n" +
                        "swSheetHeight = 0\n" +
                        "Set Part = swApp.NewDocument(\"C:\\ProgramData\\SolidWorks\\SOLIDWORKS 2017\\templates\\Part.prtdot\", 0, swSheetWidth, swSheetHeight)\n" +
                        "Dim swPart As PartDoc\n" +
                        "Set swPart = Part\n" +
                        "swApp.ActivateDoc2 \"Part1\", False, longstatus\n" +
                        "Set Part = swApp.ActiveDoc\n" +
                        "Dim myModelView As Object\n" +
                        "Set myModelView = Part.ActiveView\n" +
                        "myModelView.FrameState = swWindowState_e.swWindowMaximized\n" +
                        "Part.ClearSelection2 True\n" +
                        "boolstatus = Part.Extension.SetUserPreferenceToggle(swUserPreferenceToggle_e.swSketchAddConstToRectEntity, swUserPreferenceOption_e.swDetailingNoOptionSpecified, False)\n" +
                        "boolstatus = Part.Extension.SetUserPreferenceToggle(swUserPreferenceToggle_e.swSketchAddConstLineDiagonalType, swUserPreferenceOption_e.swDetailingNoOptionSpecified, True)\n" +
                        "Dim vSkLines As Variant\n" +
                        "vSkLines = Part.SketchManager.CreateCornerRectangle(0, 0, 0, "+ ((double)WrazmerKorpusa/1000)+", "+((double)HrazmerKorpusa/1000)+", 0)\n" +
                        "Dim myFeature As Object\n" +
                        "Set myFeature = Part.FeatureManager.FeatureExtrusion2(True, False, False, 0, 0, "+LrazmerKorpusa/1000+", 0.01, False, False, False, False, 1.74532925199433E-02, 1.74532925199433E-02, False, False, False, False, True, True, True, 0, 0, False)\n" +
                        "Part.SelectionManager.EnableContourSelection = False\n" +
                        "Part.ClearSelection2 True\n" +
                        "boolstatus = Part.Extension.SelectByID2(\"Boss-Extrude1\", \"BODYFEATURE\", 0, 0, 0, False, 0, Nothing, 0)\n" +
                        "Part.InsertFeatureShell "+(double)ThicknessRrazmerKorpusa/1000+", False\n" +
                        "\n" +
                        "' Save As\n" +
                        "longstatus = Part.SaveAs3(\"E:\\swproject\\swp\\korpus.SLDPRT\", 0, 2)\n" +
                        "Part.ClearSelection2 True\n" +
                        "\n" +
                        "' Close Document\n" +
                        "Set swPart = Nothing\n" +
                        "Set Part = Nothing\n" +
                        "swApp.CloseDoc \"Part1\"\n");


///


             for(int i=0;i<n;i++){



                 fw.write("Set Part = swApp.NewDocument(\"C:\\ProgramData\\SolidWorks\\SOLIDWORKS 2017\\templates\\Part.prtdot\", 0, swSheetWidth, swSheetHeight)\n" +
                         "\n" +
                         "swApp.ActivateDoc2 \"Part"+(i+2)+"\", False, longstatus\n" +
                         "Set Part = swApp.ActiveDoc\n" +
                         "Part.ClearSelection2 True\n" +
                         "boolstatus = Part.Extension.SetUserPreferenceToggle(swUserPreferenceToggle_e.swSketchAddConstToRectEntity, swUserPreferenceOption_e.swDetailingNoOptionSpecified, False)\n" +
                         "boolstatus = Part.Extension.SetUserPreferenceToggle(swUserPreferenceToggle_e.swSketchAddConstLineDiagonalType, swUserPreferenceOption_e.swDetailingNoOptionSpecified, True)\n" +
                         "\n" +
                         "vSkLines = Part.SketchManager.CreateCornerRectangle(0, 0, 0, "+(double)osnovnoi[i].width()/1000+", "+(double)osnovnoi[i].haight()/1000+", 0)\n" +
                         "Set myFeature = Part.FeatureManager.FeatureExtrusion2(True, False, False, 0, 0, "+(double)osnovnoi[i].lenght()/1000+", 0.01, False, False, False, False, 1.74532925199433E-02, 1.74532925199433E-02, False, False, False, False, True, True, True, 0, 0, False)\n" +
                         "Part.SelectionManager.EnableContourSelection = False\n" +
                         "\n" +
                         "' Save As\n" +
                         "longstatus = Part.SaveAs3(\"E:\\swproject\\swp\\Part"+(i+2)+".SLDPRT\", 0, 2)\n" +
                         "Part.ClearSelection2 True\n" +
                         "\n" +
                         "' Close Document\n" +
                         "Set swPart = Nothing\n" +
                         "Set Part = Nothing\n" +
                         "swApp.CloseDoc \"Part"+(i+2)+"\"\n");




















               /*  fw.write("Set Part = swApp.NewDocument(\"C:\\ProgramData\\SolidWorks\\SolidWorks 2014\\templates\\gost-part.prtdot\", 0, 0, 0)\n" +
                         "swApp.ActivateDoc2 \"Äåòàëü"+(i+2)+"\", False, longstatus\n"+
                 "vSkLines = Part.SketchManager.CreateCornerRectangle(0, 0, 0, "+(double)osnovnoi[i].width()/1000+", "+(double)osnovnoi[i].haight()/1000+", 0)\n" +
                         "Part.ClearSelection2 True\n" +
                         "boolstatus = Part.Extension.SelectByID2(\"Line2\", \"SKETCHSEGMENT\", 0, 0, 0, False, 0, Nothing, 0)\n" +
                         "boolstatus = Part.Extension.SelectByID2(\"Line1\", \"SKETCHSEGMENT\", 0, 0, 0, True, 0, Nothing, 0)\n" +
                         "boolstatus = Part.Extension.SelectByID2(\"Line4\", \"SKETCHSEGMENT\", 0, 0, 0, True, 0, Nothing, 0)\n" +
                         "boolstatus = Part.Extension.SelectByID2(\"Line3\", \"SKETCHSEGMENT\", 0, 0, 0, True, 0, Nothing, 0)\n"+
                 "Set myFeature = Part.FeatureManager.FeatureExtrusion2(True, False, False, 0, 0, "+(double)osnovnoi[i].lenght()/1000+", 0.01, False, False, False, False, 1.74532925199433E-02, 1.74532925199433E-02, False, False, False, False, True, True, True, 0, 0, False)\n" +
                         "Part.SelectionManager.EnableContourSelection = False\n" +
                         "Part.ShowNamedView2 \"*Èçîìåòðèÿ\", 7\n" +
                         "Part.ShowNamedView2 \"*Èçîìåòðèÿ\", 7\n" +
                         "longstatus = Part.SaveAs3(\"E:\\swproject\\swp\\detal"+(i+1)+".SLDPRT\", 0, 2)\n" +
                         "Part.ClearSelection2 True\n" +
                         "Set Part = Nothing\n" +
                         "swApp.CloseDoc \"Äåòàëü"+(i+2)+"\"\n");
*/
             }

                fw.write("' New Document\n" +
                        "\n" +
                        "swSheetWidth = 0\n" +
                        "swSheetHeight = 0\n" +
                        "Set Part = swApp.NewDocument(\"C:\\ProgramData\\SolidWorks\\SOLIDWORKS 2017\\templates\\Assembly.asmdot\", 0, swSheetWidth, swSheetHeight)\n" +
                        "Dim swAssembly As AssemblyDoc\n" +
                        "Set swAssembly = Part\n" +
                        "swApp.ActivateDoc2 \"Assem1\", False, longstatus\n" +
                        "Set Part = swApp.ActiveDoc\n" +
                        "Set myModelView = Part.ActiveView\n" +
                        "myModelView.FrameState = swWindowState_e.swWindowMaximized\n" +
                        "\n" +
                        "' Take Snapshot\n" +
                        "Dim swSnapShot As SnapShot\n" +
                        "Set swSnapShot = Part.ModelViewManager.AddSnapShot(\"Home\")\n" +
                        "\n" +
                        "' Insert Component\n" +
                        "Dim AssemblyTitle As String\n" +
                        "AssemblyTitle = Part.GetTitle\n" +
                        "Dim tmpObj As ModelDoc2\n" +
                        "Dim errors As Long\n" +
                        "Set tmpObj = swApp.OpenDoc6(\"E:\\swproject\\swp\\korpus.SLDPRT\", 1, 32, \"\", errors, longwarnings)\n" +
                        "Set Part = swApp.ActivateDoc3(AssemblyTitle, True, 0, errors)\n" +
                        "Dim swInsertedComponent As Component2\n" +
                        "Set swInsertedComponent = Part.AddComponent5(\"E:\\swproject\\swp\\korpus.SLDPRT\", 0, \"\", False, \"\", 0.312116114111953, 0.522597743581912, 0.79935250635167)\n" +
                        "swApp.CloseDoc \"E:\\swproject\\swp\\korpus.SLDPRT\"\n" +
                        "Dim TransformData() As Double\n" +
                        "ReDim TransformData(0 To 15) As Double\n" +
                        "TransformData(0) = 1\n" +
                        "TransformData(1) = 0\n" +
                        "TransformData(2) = 0\n" +
                        "TransformData(3) = 0\n" +
                        "TransformData(4) = 1\n" +
                        "TransformData(5) = 0\n" +
                        "TransformData(6) = 0\n" +
                        "TransformData(7) = 0\n" +
                        "TransformData(8) = 1\n" +
                        "TransformData(9) = 0\n" +
                        "TransformData(10) = 0\n" +
                        "TransformData(11) = 0\n" +
                        "TransformData(12) = 1\n" +
                        "TransformData(13) = 0\n" +
                        "TransformData(14) = 0\n" +
                        "TransformData(15) = 0\n" +
                        "Dim TransformDataVariant As Variant\n" +
                        "TransformDataVariant = TransformData\n" +
                        "Dim swMathUtil As Object\n" +
                        "Set swMathUtil = swApp.GetMathUtility()\n" +
                        "Dim swTransform As Object\n" +
                        "Set swTransform = swMathUtil.CreateTransform((TransformDataVariant))\n" +
                        "boolstatus = swInsertedComponent.SetTransformAndSolve2(swTransform)\n"+
                        "boolstatus = Part.Extension.SelectByID2(\"korpus-1@Assem1\", \"COMPONENT\", 0, 0, 0, False, 0, Nothing, 0)\n" +
                        "boolstatus = Part.SetComponentTransparent(True)\n");


                        for(int i=0;i<n;i++){
                            fw.write("' Insert Component\n" +
                                    "AssemblyTitle = Part.GetTitle\n" +
                                    "Set tmpObj = swApp.OpenDoc6(\"E:\\swproject\\swp\\Part"+(i+2)+".SLDPRT\", 1, 32, \"\", errors, longwarnings)\n" +
                                    "Set Part = swApp.ActivateDoc3(AssemblyTitle, True, 0, errors)\n" +
                                    "Set swInsertedComponent = Part.AddComponent5(\"E:\\swproject\\swp\\Part"+(i+2)+".SLDPRT\", 0, \"\", False, \"\", 0, 0, 0)\n" +
                                    "swApp.CloseDoc \"E:\\swproject\\swp\\Part"+(i+1)+".SLDPRT\"\n" +
                                    "ReDim TransformData(0 To 15) As Double\n" +
                                    "TransformData(0) = 1\n" +
                                    "TransformData(1) = 0\n" +
                                    "TransformData(2) = 0\n" +
                                    "TransformData(3) = 0\n" +
                                    "TransformData(4) = 1\n" +
                                    "TransformData(5) = 0\n" +
                                    "TransformData(6) = 0\n" +
                                    "TransformData(7) = 0\n" +
                                    "TransformData(8) = 1\n" +
                                    "TransformData(9) = "+((double)osnovnoi[i].coordX()/1000)+"\n" +
                                    "TransformData(10) = "+((double)osnovnoi[i].coordY()/1000)+"\n" +
                                    "TransformData(11) = "+((double)osnovnoi[i].coordZ()/1000)+"\n" +
                                    "TransformData(12) = 1\n" +
                                    "TransformData(13) = 0\n" +
                                    "TransformData(14) = 0\n" +
                                    "TransformData(15) = 0\n" +
                                    "TransformDataVariant = TransformData\n" +
                                    "Set swMathUtil = swApp.GetMathUtility()\n" +
                                    "Set swTransform = swMathUtil.CreateTransform((TransformDataVariant))\n" +
                                    "boolstatus = swInsertedComponent.SetTransformAndSolve2(swTransform)\n");


                        }




             fw.write("' Save As\n" +
                     "longstatus = Part.SaveAs3(\"E:\\swproject\\swp\\Assem1.SLDASM\", 0, 2)\n"  +
                     "\n" +
                     "' Close Document\n" +
                     "Set swAssembly = Nothing\n" +
                     "Set Part = Nothing\n" +
                     "swApp.CloseDoc \"Assem1\"\n"  );

                fw.write("End Sub");
                fw.close();

                for(Ploskosti e:osnovnoi){
                    System.out.println(e.coordX()+" y="+e.coordY()+" z="+e.coordZ()+" w="+e.width()+" h="+e.haight()+" l="+e.lenght());

                }



               /* fw.write("Widht Ploskost №1;Haight Ploskost №1;Widht Ploskost №2;Haight Ploskost №2;Widht Ploskost №3;Haight Ploskost №3;" +
                        "Widht Ploskost №4;Haight Ploskost №4;Widht Ploskost №5;Haight Ploskost №5;Widht Ploskost №6;Haight Ploskost №6 \r\n");
                fw.write(WrazmerPloskost1+";"+HrazmerPloskost1+";"+WrazmerPloskost1+";"+ HrazmerPloskost2+";"+ WrazmerPloskost3+";"+ HrazmerPloskost3+";"+
                        WrazmerPloskost4+";"+HrazmerPloskost4+";"+WrazmerPloskost5+";"+ HrazmerPloskost5+";"+ WrazmerPloskost6+";"+ HrazmerPloskost6+";"
                        + "\r\n");

                fw.write("Name;Width;Haight;Coord X;Coord Y;Ploskost;Ryadom;Angle;;;;\r\n");

              ///
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
*/
            }
            catch ( IOException e ) {
            }
        }







}

}
