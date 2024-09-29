
import Pro.Ending;
import Pro.Level;
import Pro.Operators;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class CurlCup {
    private JTextField finalCount;
    private JButton stop;
    private JLabel labelforCount;
    private JPanel panelforAll;
    private JPanel panelforCount;
    private JScrollPane logs;
    private JPanel event;
    private JTextArea Alllogs;
    private JTextField textField1;
    private JLabel TimeCount;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JPanel panelforOP;
    private JPanel panelforLevel;
    private JPanel panelforTemp;
    private JButton buttonforTemOp;
    private JTextField textField5;
    private JLabel labelforTemOp;
    private JTextField textField6;
    private JLabel labelforLevel;
    private JLabel labelforLogs;
    private JLabel labelforOp;
    private JLabel labelforTemp;
    private JLabel labelforEvent;
    private JLabel labelforEnding;
    private JTextField textField7;
    private JButton buttonforEvent;
    private JTextField textField8;
    private JButton buttonforEnd;
    private JCheckBox LWCheckBox;
    private JCheckBox WLCheckBox;
    private JCheckBox wyzl;
    private JCheckBox tszz;
    private JCheckBox sdzh;
    private JCheckBox kjsp;
    private JCheckBox sd;
    private JCheckBox hhcd;
    private JTextField a0TextField3;
    private JTextField a0TextField1;
    private JTextField a0TextField;
    private JTextField a0TextField4;
    private JTextField a0TextField5;
    private JCheckBox ycboss;
    private JCheckBox wrqq;
    private JCheckBox zyszp;
    private JTextField a0TextField2;
    private JCheckBox zysz;
    private JCheckBox ylzz;
    private JButton clear;
    private Double Tempcount = 0.0;//临时修正分
    private Double Levelcount = 0.0;//关卡分
    private int Mopcount = 0;//绝对限制干员数
    private int opcount = 0;//相对限制干员数
    private int fopcount_6 = 0;//非限制干员数6星
    private int fopcount_5 = 0;//5星
    private int fopcount_4 = 0;//4星

    public static void main(String[] args) {
        UIManager.put("Label.font", new FontUIResource(new Font("TextPane.font", Font.PLAIN, 12)));
        UIManager.put("TextField.font", new FontUIResource(new Font("TextPane.font", Font.PLAIN, 12)));
        UIManager.put("CheckBox.font", new FontUIResource(new Font("TextPane.font", Font.PLAIN, 12)));
        UIManager.put("Button.font", new FontUIResource(new Font("TextPane.font", Font.PLAIN, 12)));
        JFrame frame = new JFrame("CurlCup");
        frame.setContentPane(new CurlCup().panelforAll);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public CurlCup() {

        try {
            $$$setupUI$$$();

//            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("ruler/ruler.xlsx"));
//            int sheetCount = wb.getNumberOfSheets();//获取sheet的个数
//            System.out.println(sheetCount);
//            for (int i = 0; i <sheetCount; i++) {
//                System.out.println("读取第"+(i+1)+"个sheet");
//                XSSFSheet sheet = wb.getSheetAt(i);
//                int rowCount = sheet.getLastRowNum();
//                for (int j = 0; j <=rowCount; j++) {
//                    int colCount = sheet.getRow(j).getLastCellNum();
//                    System.out.println("第"+(j+1)+"行数据如下");
//                    for (int k = 0; k < colCount; k++) {
//                        System.out.println(sheet.getRow(j).getCell(k)+"  ");
//                    }
//                }
//            }
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("ruler/ruler.xlsx"));
//            int sheetCount = workbook.getNumberOfSheets();//获取sheet 的个数
            //遍历sheet1，获取干员数据
            XSSFSheet sheet = workbook.getSheetAt(0);//第0个sheet 干员sheet
            int rowNum = sheet.getLastRowNum();//获取总行数
            ArrayList<Operators> operatorsList = new ArrayList<>();
            for (int i = 1; i <= rowNum; i++) {
                XSSFRow row = sheet.getRow(i);//获取每一行
                Operators operators = new Operators();
                int columns = 0;
                if (1 == i) {
                    columns = row.getLastCellNum() - 1;
                } else {
                    columns = row.getLastCellNum();
                }
                for (int j = 0; j <= columns; j++) {
                    Cell cell = row.getCell(j);
                    switch (j) {
                        case 0:
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            String cellValue = cell.getStringCellValue();
                            operators.setOperatorName(cellValue);
                            break;
                        case 1:
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            String cellValue2 = cell.getStringCellValue();
                            operators.setLevel(cellValue2);
                            break;
                        case 2:
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            String cellValue3 = cell.getStringCellValue();
                            operators.setLimit(cellValue3);
                            break;
                        case 3:
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            String cellValue4 = cell.getStringCellValue();
                            operators.setOperatorCount(cellValue4);
                            break;
                    }
                }
                operatorsList.add(operators);
            }
//            for (int i = 0; i < operatorsList.size(); i++) {
//                System.out.println(operatorsList.get(i).getOperatorName());
//                System.out.println(operatorsList.get(i).getLevel());
//                System.out.println(operatorsList.get(i).getLimit());
//                System.out.println(operatorsList.get(i).getOperatorCount());
//            }
            //遍历sheet2，获取关卡相关数据
            XSSFSheet sheet1 = workbook.getSheetAt(1);
            int rowNum1 = sheet1.getLastRowNum();
            ArrayList<Level> levelsList = new ArrayList<>();
            for (int i = 1; i <= rowNum1; i++) {
                XSSFRow row1 = sheet1.getRow(i);
                Level level = new Level();
                int columns = 0;
                if (1 == i) {
                    columns = row1.getLastCellNum() - 1;
                } else {
                    columns = row1.getLastCellNum();
                }
                for (int j = 0; j <= columns; j++) {
                    Cell cell1 = row1.getCell(j);
                    switch (j) {
                        case 0:
                            cell1.setCellType(Cell.CELL_TYPE_STRING);
                            String cellValue1 = cell1.getStringCellValue();
                            level.setLevelName(cellValue1);
                            break;
                        case 1:
                            cell1.setCellType(Cell.CELL_TYPE_STRING);
                            String cellValue2 = cell1.getStringCellValue();
                            level.setCount(cellValue2);
                    }
                }
                levelsList.add(level);
            }
            //遍历sheet3获取结局列表
            XSSFSheet sheet2 = workbook.getSheetAt(2);
            int rowNum2 = sheet2.getLastRowNum();
            ArrayList<Ending> endingsList = new ArrayList<>();
            for (int i = 1; i <= rowNum2; i++) {
                XSSFRow row2 = sheet2.getRow(i);
                Ending ending = new Ending();
                int columns = 0;
                if (1 == i) {
                    columns = row2.getLastCellNum() - 1;
                } else {
                    columns = row2.getLastCellNum();
                }
                for (int j = 0; j <= columns; j++) {
                    Cell cell2 = row2.getCell(j);
                    switch (j) {
                        case 0:
                            cell2.setCellType(Cell.CELL_TYPE_STRING);
                            String cellValue2 = cell2.getStringCellValue();
                            ending.setName(cellValue2);
                        case 1:
                            cell2.setCellType(Cell.CELL_TYPE_STRING);
                            String cellValue3 = cell2.getStringCellValue();
                            ending.setCount(cellValue3);
                    }
                }
                endingsList.add(ending);
            }

            buttonforTemOp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String oPname = textField6.getText();
                    String count = textField5.getText();
//                    System.out.println(count);
                    int number = Integer.valueOf(count);
//                    System.out.println("招募次数" + number);
                    int id = 0;
                    if (!oPname.isEmpty()) {
                        for (int i = 0; i < operatorsList.size(); i++) {
                            if (operatorsList.get(i).getOperatorName().contains(oPname)) {
//                                System.out.println(operatorsList.get(i).getOperatorName().contains(oPname));
//                                System.out.println(i);
                                id = i;
                                number = number + 1;
                            }
                        }

                        Operators op = new Operators(
                                operatorsList.get(id).getOperatorName(),
                                operatorsList.get(id).getLevel(),
                                operatorsList.get(id).getOperatorCount(),
                                operatorsList.get(id).getLimit()
                        );
                        //记得添加分数记录与分数修正
                        if (op.getLimit().equals("0")) {
                            Mopcount++;//绝对限制
                        } else if (op.getLimit().equals("1")) {
                            opcount++;
                        } else if (op.getLimit().equals("2")) {
                            switch (op.getLevel()) {
                                case "4":
                                    fopcount_4++;
                                    break;
                                case "5":
                                    fopcount_5++;
                                    break;
                                case "6":
                                    fopcount_6++;
                                    break;
                            }
                        }

//                        System.out.println(fopcount_4 + " " + fopcount_5 + " " + fopcount_6 + " " + Mopcount + " " + opcount);

                        textField5.setText(String.valueOf(number));
                        String logs = "临时招募! 获得" + op.getLevel() + "星干员：" + op.getOperatorName() + "\n";
                        Alllogs.append(logs);
                        Alllogs.paintImmediately(Alllogs.getBounds());
                        textField6.setText("");
                    } else {
                        String logs = "请输入干员名称\n";
                        Alllogs.append(logs);
                        Alllogs.paintImmediately(Alllogs.getBounds());
                    }
                }
            });
            buttonforEvent.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String eventsname = textField7.getText();
                    double count = 0.0;
                    double lwcount = 0.0;//记录分数
                    double wlcount = 0.0;
                    int id = 0;
                    if (!eventsname.isEmpty()) {
                        for (int i = 0; i < levelsList.size(); i++) {
                            if (levelsList.get(i).getLevelName().contains(eventsname)) {
                                id = i;
                                break;
                            }
                        }
                        Level level = new Level(
                                levelsList.get(id).getLevelName(),
                                levelsList.get(id).getCount()
                        );
                        //记得添加分数记录与分数修正
                        if (id == 0) {//冰海凝影 id为0
                            if (wrqq.isSelected()) {//判断污染躯壳
                                level.setCount(String.valueOf(Double.valueOf(level.getCount()) + 10));
                                wrqq.setSelected(false);//计算结束后取消选中
                                wrqq.setEnabled(false);
                            }
                        }
                        if (id == 3) {//人造物狂欢 id为3
                            level.setCount(String.valueOf(Double.valueOf(level.getCount()) +
                                    10 * Double.valueOf(a0TextField.getText())));
                            a0TextField.setText("");
                        }
                        if (id == 4) {//乐理之灾 id为4
                            if (ylzz.isSelected()) {
                                level.setCount(String.valueOf(Double.valueOf(level.getCount()) + 10));
                                ylzz.setSelected(false);
                            }
                        }
                        if (LWCheckBox.isSelected() && id != 11 && id != 12) {
                            lwcount = Double.valueOf(level.getCount()) * 0.2;
                        }
                        if (WLCheckBox.isSelected()) {
                            wlcount = Double.valueOf(level.getCount()) * 0.2;
                        }
                        count = Double.valueOf(level.getCount()) + lwcount + wlcount;
                        Levelcount += count;
                        textField3.setText(String.valueOf(Levelcount));
                        String logs = "通过 紧急 " + level.getLevelName() + "获得" + count + "分 \n";
                        Alllogs.append(logs);
                        Alllogs.paintImmediately(Alllogs.getBounds());
                        textField7.setText("");
                    } else {
                        String logs = "请输入关卡\n";
                        Alllogs.append(logs);
                        Alllogs.paintImmediately(Alllogs.getBounds());
                    }
                }
            });

            buttonforEnd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String endname = textField8.getText();
                    double count = 0.0;
                    int id = 0;
                    if (!endname.isEmpty()) {
                        for (int i = 0; i < endingsList.size(); i++) {
                            if (endingsList.get(i).getName().contains(endname)) {
                                id = i;
                            }
                        }
                        Ending ending = new Ending(
                                endingsList.get(id).getName(),
                                endingsList.get(id).getCount()
                        );
                        //记得添加分数修正
                        count = Double.valueOf(ending.getCount());
                        Levelcount += count;
                        textField3.setText(String.valueOf(Levelcount));
                        String logs = "完成 最终关卡:" + ending.getName() + "\n";
                        Alllogs.append(logs);
                        Alllogs.paintImmediately(Alllogs.getBounds());
                        textField8.setText("");
                    } else {
                        String logs = "请输入结局\n";
                        Alllogs.append(logs);
                        Alllogs.paintImmediately(Alllogs.getBounds());
                    }
                }
            });

            stop.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Double finalcount = 0.0;//最终得分

                    Tempcount = Mopcount * 100.0 + opcount * 60.0 + fopcount_4 * 10.0 + fopcount_5 * 20.0 + fopcount_6 * 30.0;//临时招募干员修正分
                    Tempcount = Tempcount + 10 * Double.valueOf(a0TextField4.getText()) + 5 * Double.valueOf(a0TextField5.getText());//藏品与密文板修正分
                    Tempcount = Tempcount + Double.valueOf(a0TextField3.getText()) * 20;//鸭、狗、熊击杀数
                    if (wyzl.isSelected()) {
                        Tempcount = Tempcount + 20;
                        wyzl.setEnabled(false);
                    }
                    if (tszz.isSelected()) {
                        Tempcount = Tempcount + 20;
                        tszz.setEnabled(false);
                    }
                    if (sdzh.isSelected()) {
                        Tempcount = Tempcount + 20;
                        sdzh.setEnabled(false);
                    }
                    if (kjsp.isSelected()) {
                        Tempcount = Tempcount + 30;
                        kjsp.setEnabled(false);
                    }
                    if (hhcd.isSelected()) {
                        Tempcount = Tempcount + 40;
                        hhcd.setEnabled(false);
                    }
                    if (zyszp.isSelected()) {
                        if (zysz.isSelected()) {
                            Tempcount = Tempcount + 80 + Double.valueOf(a0TextField2.getText()) * 40;
                            zyszp.setSelected(false);
                            zysz.setSelected(false);
                        } else {
                            Tempcount = Tempcount + 30 + Double.valueOf(a0TextField2.getText()) * 50;
                            zyszp.setSelected(true);
                            zysz.setSelected(false);
                        }
                    }
                    if (a0TextField1.getText().equals("6")) {
                        Tempcount = Tempcount + 120;
                    } else {
                        Tempcount = Tempcount + 15 * Double.valueOf(a0TextField1.getText());
                    }
                    if (sdzh.isSelected()) {
                        Tempcount = Tempcount + 200;
                    }
                    if (textField5.getText().equals("0")) {
                        Tempcount = Tempcount + 200;
                    }
                    if (ycboss.isSelected()) {
                        Tempcount = Tempcount + 40;
                    }
                    textField4.setText(String.valueOf(Tempcount));

                    finalcount = Tempcount + Levelcount + Double.valueOf(textField2.getText());

                    finalCount.setText(String.valueOf(finalcount));
                    String logs = "最终得分" + finalcount + "!";
                    Alllogs.append(logs);
                    Alllogs.paintImmediately(Alllogs.getBounds());

                    clear.setEnabled(true);

                    BufferedWriter bw = null;
                    try {
                        OutputStream os = new FileOutputStream("logs.txt");
                        bw = new BufferedWriter(new OutputStreamWriter(os, "utf-8"));
                        for (String value : Alllogs.getText().split("\n")) {
                            bw.write(value);
                            bw.newLine();//换行
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } finally {
                        if (bw != null) {
                            try {
                                bw.close();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                }
            });

            clear.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField1.setText("");
                    textField2.setText("");
                    textField3.setText("");
                    textField4.setText("");
                    textField5.setText("0");
                    textField6.setText("");
                    textField7.setText("");
                    textField8.setText("");
                    LWCheckBox.setSelected(false);
                    WLCheckBox.setSelected(false);
                    wyzl.setSelected(false);
                    tszz.setSelected(false);
                    sdzh.setSelected(false);
                    kjsp.setSelected(false);
                    sd.setSelected(false);
                    wrqq.setSelected(false);
                    ycboss.setSelected(false);
                    hhcd.setSelected(false);
                    zysz.setSelected(false);
                    zyszp.setSelected(false);
                    ylzz.setSelected(false);
                    wyzl.setEnabled(true);
                    tszz.setEnabled(true);
                    sdzh.setEnabled(true);
                    kjsp.setEnabled(true);
                    sd.setEnabled(true);
                    wrqq.setEnabled(true);
                    ycboss.setEnabled(true);
                    hhcd.setEnabled(true);
                    zysz.setEnabled(true);
                    zyszp.setEnabled(true);
                    ylzz.setEnabled(true);
                    a0TextField.setText("0");
                    a0TextField.setEditable(true);
                    a0TextField1.setText("0");
                    a0TextField2.setText("0");
                    a0TextField3.setText("0");
                    a0TextField4.setText("0");
                    a0TextField5.setText("0");
                    Alllogs.setText("");
                    finalCount.setText("");
                    Tempcount = 0.0;
                    Levelcount = 0.0;
                    Mopcount = 0;
                    opcount = 0;
                    fopcount_6 = 0;
                    fopcount_4 = 0;
                    fopcount_5 = 0;
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panelforAll = new JPanel();
        panelforAll.setLayout(new FormLayout("fill:d:grow,left:280dlu:noGrow,fill:d:grow,left:4dlu:noGrow", "top:10dlu:noGrow,center:535px:noGrow,center:36px:noGrow"));
        panelforCount = new JPanel();
        panelforCount.setLayout(new GridLayoutManager(1, 13, new Insets(0, 0, 0, 0), -1, -1));
        CellConstraints cc = new CellConstraints();
        panelforAll.add(panelforCount, cc.xyw(1, 3, 4));
        stop = new JButton();
        stop.setText("得分结算");
        panelforCount.add(stop, new GridConstraints(0, 11, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        labelforCount = new JLabel();
        labelforCount.setText("最终得分");
        panelforCount.add(labelforCount, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textField2 = new JTextField();
        panelforCount.add(textField2, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textField3 = new JTextField();
        textField3.setEditable(false);
        panelforCount.add(textField3, new GridConstraints(0, 7, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textField4 = new JTextField();
        textField4.setEditable(false);
        textField4.setText("");
        panelforCount.add(textField4, new GridConstraints(0, 10, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("+");
        panelforCount.add(label1, new GridConstraints(0, 8, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("+");
        panelforCount.add(label2, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("修正分数");
        panelforCount.add(label3, new GridConstraints(0, 9, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("关卡与结局分数");
        panelforCount.add(label4, new GridConstraints(0, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("结算得分");
        panelforCount.add(label5, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        finalCount = new JTextField();
        finalCount.setEditable(false);
        panelforCount.add(finalCount, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("=");
        panelforCount.add(label6, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        clear = new JButton();
        clear.setEnabled(false);
        clear.setText("清空");
        panelforCount.add(clear, new GridConstraints(0, 12, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        event = new JPanel();
        event.setLayout(new FormLayout("fill:d:grow", "center:d:noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:70px:noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:94px:noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:238px:noGrow"));
        panelforAll.add(event, cc.xywh(1, 1, 2, 2, CellConstraints.FILL, CellConstraints.FILL));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        event.add(panel1, cc.xy(1, 1));
        TimeCount = new JLabel();
        TimeCount.setText("实时分数");
        panel1.add(TimeCount, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_VERTICAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(48, 46), null, 0, false));
        textField1 = new JTextField();
        panel1.add(textField1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_NORTHWEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 46), null, 0, false));
        panelforOP = new JPanel();
        panelforOP.setLayout(new FormLayout("fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:d:grow,left:4dlu:noGrow,fill:max(d;4px):noGrow", "center:d:grow"));
        event.add(panelforOP, cc.xy(1, 5, CellConstraints.FILL, CellConstraints.TOP));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        panelforOP.add(panel2, cc.xy(5, 1, CellConstraints.DEFAULT, CellConstraints.CENTER));
        buttonforTemOp = new JButton();
        buttonforTemOp.setText("临时招募");
        panel2.add(buttonforTemOp, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        labelforTemOp = new JLabel();
        Font labelforTemOpFont = UIManager.getFont("TextPane.font");
        if (labelforTemOpFont != null) labelforTemOp.setFont(labelforTemOpFont);
        labelforTemOp.setText("临时招募次数");
        panel2.add(labelforTemOp, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textField5 = new JTextField();
        textField5.setEditable(false);
        textField5.setText("0");
        panel2.add(textField5, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textField6 = new JTextField();
        panelforOP.add(textField6, cc.xy(3, 1, CellConstraints.FILL, CellConstraints.FILL));
        labelforOp = new JLabel();
        labelforOp.setText("干员名称");
        panelforOP.add(labelforOp, cc.xy(1, 1));
        panelforLevel = new JPanel();
        panelforLevel.setLayout(new FormLayout("fill:d:grow", "center:d:grow"));
        event.add(panelforLevel, cc.xy(1, 9, CellConstraints.DEFAULT, CellConstraints.TOP));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(3, 5, new Insets(0, 0, 0, 0), -1, -1));
        panelforLevel.add(panel3, cc.xy(1, 1, CellConstraints.DEFAULT, CellConstraints.TOP));
        labelforEvent = new JLabel();
        labelforEvent.setText("紧急关卡");
        panel3.add(labelforEvent, new GridConstraints(0, 0, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textField7 = new JTextField();
        panel3.add(textField7, new GridConstraints(0, 1, 2, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        labelforLevel = new JLabel();
        labelforLevel.setText("结局/事件记录");
        panel3.add(labelforLevel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textField8 = new JTextField();
        panel3.add(textField8, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        buttonforEnd = new JButton();
        buttonforEnd.setText("确认");
        panel3.add(buttonforEnd, new GridConstraints(2, 2, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        LWCheckBox = new JCheckBox();
        LWCheckBox.setText("路网");
        panel3.add(LWCheckBox, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buttonforEvent = new JButton();
        buttonforEvent.setText("确认");
        panel3.add(buttonforEvent, new GridConstraints(1, 2, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        WLCheckBox = new JCheckBox();
        WLCheckBox.setText("无漏");
        panel3.add(WLCheckBox, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel3.add(spacer1, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, 1, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setHorizontalAlignment(0);
        label7.setText("干员招募");
        event.add(label7, cc.xy(1, 3));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        event.add(panel4, cc.xy(1, 7, CellConstraints.CENTER, CellConstraints.DEFAULT));
        labelforEnding = new JLabel();
        labelforEnding.setText(" 关卡与事件");
        panel4.add(labelforEnding, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(59, 17), null, 0, false));
        labelforTemp = new JLabel();
        labelforTemp.setText("分数修正");
        event.add(labelforTemp, cc.xy(1, 11, CellConstraints.CENTER, CellConstraints.DEFAULT));
        panelforTemp = new JPanel();
        panelforTemp.setLayout(new GridLayoutManager(6, 4, new Insets(0, 0, 0, 0), -1, -1));
        event.add(panelforTemp, cc.xy(1, 13, CellConstraints.DEFAULT, CellConstraints.FILL));
        wyzl = new JCheckBox();
        wyzl.setText("无垠赠礼");
        panelforTemp.add(wyzl, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tszz = new JCheckBox();
        tszz.setText("坍缩之种");
        panelforTemp.add(tszz, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        sdzh = new JCheckBox();
        sdzh.setText("深度灼痕");
        panelforTemp.add(sdzh, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        kjsp = new JCheckBox();
        kjsp.setText("空间碎片");
        panelforTemp.add(kjsp, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("英雄无名击杀数");
        panelforTemp.add(label8, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setText("R-11突击动力甲个数");
        panelforTemp.add(label9, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        a0TextField = new JTextField();
        a0TextField.setText("0");
        panelforTemp.add(a0TextField, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        hhcd = new JCheckBox();
        hhcd.setText("豪华车队无漏");
        panelforTemp.add(hhcd, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        sd = new JCheckBox();
        sd.setText("未进入树洞");
        panelforTemp.add(sd, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ycboss = new JCheckBox();
        ycboss.setText("第三层隐藏boss");
        panelforTemp.add(ycboss, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        wrqq = new JCheckBox();
        wrqq.setText("冰海凝影污染躯壳");
        panelforTemp.add(wrqq, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        zysz = new JCheckBox();
        zysz.setText("正义使者无漏");
        panelforTemp.add(zysz, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        zyszp = new JCheckBox();
        zyszp.setText("正义使者通关");
        panelforTemp.add(zyszp, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label10 = new JLabel();
        label10.setText("正义使者鸭/狗/熊击杀数");
        panelforTemp.add(label10, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        a0TextField2 = new JTextField();
        a0TextField2.setText("0");
        panelforTemp.add(a0TextField2, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label11 = new JLabel();
        label11.setText("隐藏击杀鸭/狗/熊数量");
        panelforTemp.add(label11, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        a0TextField3 = new JTextField();
        a0TextField3.setText("0");
        panelforTemp.add(a0TextField3, new GridConstraints(3, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label12 = new JLabel();
        label12.setText("密文版个数");
        panelforTemp.add(label12, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        a0TextField5 = new JTextField();
        a0TextField5.setText("0");
        panelforTemp.add(a0TextField5, new GridConstraints(5, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label13 = new JLabel();
        label13.setText("藏品个数");
        panelforTemp.add(label13, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        a0TextField4 = new JTextField();
        a0TextField4.setText("0");
        panelforTemp.add(a0TextField4, new GridConstraints(4, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        ylzz = new JCheckBox();
        ylzz.setText("乐理之灾首席小提琴");
        panelforTemp.add(ylzz, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        a0TextField1 = new JTextField();
        a0TextField1.setText("0");
        panelforTemp.add(a0TextField1, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        logs = new JScrollPane();
        panelforAll.add(logs, cc.xy(3, 2, CellConstraints.FILL, CellConstraints.FILL));
        Alllogs = new JTextArea();
        logs.setViewportView(Alllogs);
        labelforLogs = new JLabel();
        labelforLogs.setText("全流程事件日志");
        panelforAll.add(labelforLogs, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelforAll;
    }

}

