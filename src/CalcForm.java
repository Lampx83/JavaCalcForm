import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcForm extends JFrame implements ActionListener {

    private JTextField txtResult;

    private JButton btnEqual;

    private JButton btnAdd;
    private JButton btnSub;
    private JButton btnMul;
    private JButton btnDiv;

    private JButton btn0;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;

    private JPanel jpnMain;


    public CalcForm() {

        btn0.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btnAdd.addActionListener(this);
        btnSub.addActionListener(this);
        btnMul.addActionListener(this);
        btnDiv.addActionListener(this);
        btnEqual.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("=")) {

            try {

                ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
                txtResult.setText(engine.eval(txtResult.getText()).toString());

            } catch (ScriptException ex) {
                ex.printStackTrace();
            }

        } else {
            String strCommand = e.getActionCommand();  // Nút người dùng bấm
            String strResult = txtResult.getText();  //Đoạn text hiện tại trên textResult
            if (strResult.equals("0"))   //Kiểm tra bằng 0 thì bỏ số 0 đi
                strResult = "";
            strResult = strResult + strCommand;  //Ghép thêm số hoặc phép tính trên nút bấm vào
            txtResult.setText(strResult);   //Hiển thị ra textField trên cùng
        }

    }


    public static void main(String[] args) {

        CalcForm frmCalc = new CalcForm();

        frmCalc.setContentPane(frmCalc.jpnMain);

        frmCalc.setSize(400, 500);
        frmCalc.setVisible(true);


    }

}
