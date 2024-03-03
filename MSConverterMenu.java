import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class MSConverterMenu extends JFrame implements ActionListener, KeyListener{
    private JLabel lblChoose, lblValue, lblConvert;
    private JTextField txtValue;
    private JComboBox<String> cboChoose, cboConvert;
    private JTextArea txtAreaUp;
    private JButton btnConvert;
    private MSConverter msc;
    private DecimalFormat df;
    String hold="";

    MSConverterMenu(){
        msc=new MSConverter();
        df=new DecimalFormat("0.00");


        lblConvert=new JLabel("Convert");
        String convertMenu[]={"English => SI","SI => English"};
        lblChoose=new JLabel("Choose");
        String chooseMenu[]={"Distance (km/mi)","Weight (kg/lbs)","Temperature (C/F)"};
        

        cboConvert=new JComboBox<String>(convertMenu);
        cboChoose=new JComboBox<String>(chooseMenu);
        txtAreaUp=new JTextArea();
        btnConvert=new JButton("Convert");
        lblValue=new JLabel("Value");
        txtValue=new JTextField();
        setTitle("Metric System Converter");
        setSize(400, 250);
        getContentPane().setBackground(new Color(168,213,229));
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        txtAreaUp.setEditable(false);
        add(txtAreaUp).setBounds(20,20,340,60);
        add(lblConvert).setBounds(20,100,100,20);
        add(cboConvert).setBounds(80,100,150,20);
        add(lblChoose).setBounds(20,130,60,20);
        add(cboChoose).setBounds(80,130,150,20);
        add(lblValue).setBounds(20,160,100,20);
        add(txtValue).setBounds(80,160,150,20);
        add(btnConvert).setBounds(250,110,110,60);

        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btnConvert.addActionListener(this);
        txtValue.addKeyListener(this);
        btnConvert.setEnabled(false);
    }

    public static void main(String[] args){
        new MSConverterMenu();
    }

    public void actionPerformed(ActionEvent e){
        int i=cboConvert.getSelectedIndex();
        int j=cboChoose.getSelectedIndex();
        double value=Double.parseDouble(txtValue.getText());
        if(i==0){
            if(j==0){
                double result=msc.milesToKm(value);
                hold=value+" mi => "+df.format(result)+" km";
                txtAreaUp.setText(hold);
                txtValue.setText("");
            }else if(j==1){
                double result=msc.lbsToKg(value);
                hold=value+" lbs => "+df.format(result)+" kg";
                txtAreaUp.setText(hold);
                txtValue.setText("");
            }else if(j==2){
                double result=msc.fahrToCels(value);
                hold=value+" F => "+df.format(result)+" C";
                txtAreaUp.setText(hold);
                txtValue.setText("");
            }
        }else if(i==1){
            if(j==0){
                double result=msc.kmToMiles(value);
                hold=value+" km => "+df.format(result)+" mi";
                txtAreaUp.setText(hold);
                txtValue.setText("");
            }else if(j==1){
                double result=msc.kgToLbs(value);
                hold=value+" kg => "+df.format(result)+" lbs";
                txtAreaUp.setText(hold);
                txtValue.setText("");
            }else if(j==2){
                double result=msc.celsToFahr(value);
                hold=value+" C => "+df.format(result)+" F";
                txtAreaUp.setText(hold);
                txtValue.setText("");
            }
        }
        btnConvert.setEnabled(false);
    }

    public void keyPressed(KeyEvent arg0){ 

    }
    
    public void keyReleased(KeyEvent e){
        if(e.getSource().equals(txtValue)){
            if(txtValue.getText().isEmpty()){
                btnConvert.setEnabled(false);
            }else{
                btnConvert.setEnabled(true);
            }
        }
    }

    public void keyTyped(KeyEvent e){
        if(e.getSource().equals(txtValue)){
            if(Character.isLetter(e.getKeyChar())&&!e.isAltDown()){
                e.consume();
            }
        }
    }
}



    