//BUS RESERVATION SYSTEM USING JAVA SWING AND MYSQL DATABASE

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.sql.*;
import java.util.Calendar;
import java.util.Date;

class front_end
{
    protected Font titlefont,lblfont,txtfont,subtitlefont,subfont,datefont;
    protected JFrame homepg,traveldet,loginform,registerform,busselect,passengerdet,payment,confirmation;
    protected JButton clickbtn,loginbtn,signup,signupbtn,login,search,proceed,book,pay;
    protected JTextField txtUserName,regtxtUserName,regtxtmobile,txtcn,txtnm,txtnf,txtpname,txtpdage;
    protected JPasswordField txtPW,regtxtPW,cvv;
    protected JLabel lblspname,lblsfrom,lblsto,lblsdate,lblsticket;
    protected JDateChooser date,validt;
    protected JComboBox bname,btype,bss,txtfrom,txtto,cgender,bid,bpm,cbank,cupi;
    protected JTable bustable;

    public void font()
    {
        titlefont = new Font("times new roman", Font.BOLD, 80);
        lblfont = new Font("times new roman", Font.PLAIN, 50);
        txtfont = new Font("times new roman", Font.PLAIN, 45);
        subtitlefont = new Font("times new roman", Font.BOLD, 60);
        subfont = new Font("times new roman", Font.PLAIN, 20);
        datefont = new Font("times new roman",Font.BOLD,19);
    }

    public void login_registration_form()
    {
        //HOME PAGE

        JLabel lbltitle,q1,q2,click;
        JLabel lbltitle1, lbltitle2, lblUserName, lblPW, lblsignup;
        JLabel lblregister, lbltitle3,regUserName,regPW,regmobile;

        homepg = new JFrame("Home Page");
        homepg.setSize(1600, 1080);
        homepg.setLayout(null);
        homepg.setVisible(true);
        homepg.getContentPane().setBackground(new Color(53, 46, 99));
        homepg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homepg.setExtendedState(JFrame.MAXIMIZED_BOTH);

        lbltitle = new JLabel("Welcome to XYZ Travels");
        lbltitle.setBounds(350, 50, 1000, 90);
        lbltitle.setFont(titlefont);
        lbltitle.setForeground(Color.YELLOW);
        homepg.add(lbltitle);

        q1 = new JLabel("'The road may be long, but with a bus");
        q1.setBounds(460, 170, 1000, 90);
        q1.setFont(new Font("times new roman",Font.PLAIN,40));
        q1.setForeground(Color.GREEN);
        homepg.add(q1);
        q2 = new JLabel("by your side, the destination is always worth it !'");
        q2.setBounds(390, 220, 1000, 90);
        q2.setFont(new Font("times new roman",Font.PLAIN,40));
        q2.setForeground(Color.GREEN);
        homepg.add(q2);

        click = new JLabel("Click to book your seats");
        click.setBounds(490, 320, 1000, 90);
        click.setFont(new Font("courier new",Font.BOLD,40));
        click.setForeground(Color.CYAN);
        homepg.add(click);

        clickbtn = new JButton("Click Here");
        clickbtn.setBounds(575,420,350,50);
        clickbtn.setFont(new Font("courier new",Font.BOLD,40));
        clickbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        homepg.add(clickbtn);

        clickbtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                homepg.setVisible(false);
                loginform.setVisible(true);
            }
        });

        //LOGIN FORM

        loginform = new JFrame("Login Form");
        loginform.setSize(1600, 1080);
        loginform.setLayout(null);
        loginform.getContentPane().setBackground(new Color(53, 46, 99));
        loginform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginform.setExtendedState(JFrame.MAXIMIZED_BOTH);

        lbltitle1 = new JLabel("Bus Reservation System");
        lbltitle1.setBounds(400, 50, 1000, 90);
        lbltitle1.setFont(titlefont);
        lbltitle1.setForeground(Color.YELLOW);
        loginform.add(lbltitle1);

        lbltitle2 = new JLabel("Login Form");
        lbltitle2.setBounds(630, 150, 800, 70);
        lbltitle2.setFont(subtitlefont);
        lbltitle2.setForeground(Color.CYAN);
        loginform.add(lbltitle2);

        lblUserName = new JLabel("Username");
        lblUserName.setBounds(450, 280, 250, 50);
        lblUserName.setFont(lblfont);
        lblUserName.setForeground(Color.WHITE);
        loginform.add(lblUserName);

        txtUserName = new JTextField();
        txtUserName.setBounds(750, 280, 400, 45);
        txtUserName.setFont(txtfont);
        loginform.add(txtUserName);

        lblPW = new JLabel("Password");
        lblPW.setBounds(450, 350, 250, 50);
        lblPW.setFont(lblfont);
        lblPW.setForeground(Color.WHITE);
        loginform.add(lblPW);

        txtPW = new JPasswordField();
        txtPW.setBounds(750, 350, 400, 45);
        txtPW.setFont(txtfont);
        loginform.add(txtPW);

        loginbtn = new JButton("Login");
        loginbtn.setBounds(650, 450, 200, 60);
        loginbtn.setFont(lblfont);
        loginbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginform.add(loginbtn);

        lblsignup = new JLabel("Not an User ?");
        lblsignup.setBounds(900, 460, 120, 40);
        lblsignup.setForeground(Color.WHITE);
        lblsignup.setFont(subfont);
        loginform.add(lblsignup);

        signup = new JButton("Sign Up");
        signup.setBounds(1000, 460, 120, 40);
        signup.setFont(subfont);
        signup.setOpaque(false);
        signup.setContentAreaFilled(false);
        signup.setBorderPainted(false);
        signup.setForeground(Color.WHITE);
        signup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginform.add(signup);

        //REGISTRATION FORM

        registerform = new JFrame("Registration Form");
        registerform.setSize(1600, 1080);
        registerform.setLayout(null);
        registerform.setExtendedState(JFrame.MAXIMIZED_BOTH);
        registerform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerform.getContentPane().setBackground(new Color(53, 46, 99));

        lbltitle3 = new JLabel("Registration Form");
        lbltitle3.setBounds(550, 50, 1000, 90);
        lbltitle3.setFont(subtitlefont);
        lbltitle3.setForeground(Color.cyan);
        registerform.add(lbltitle3);

        regUserName = new JLabel("Username");
        regUserName.setBounds(450, 180, 250, 50);
        regUserName.setFont(lblfont);
        regUserName.setForeground(Color.WHITE);
        registerform.add(regUserName);

        regtxtUserName = new JTextField();
        regtxtUserName.setBounds(750, 180, 400, 45);
        regtxtUserName.setFont(txtfont);
        registerform.add(regtxtUserName);

        regPW = new JLabel("Password");
        regPW.setBounds(450, 250, 250, 50);
        regPW.setFont(lblfont);
        regPW.setForeground(Color.WHITE);
        registerform.add(regPW);

        regtxtPW = new JPasswordField();
        regtxtPW.setBounds(750, 250, 400, 45);
        regtxtPW.setFont(txtfont);
        registerform.add(regtxtPW);

        regmobile = new JLabel("Mobile");
        regmobile.setBounds(450, 320, 250, 50);
        regmobile.setFont(lblfont);
        regmobile.setForeground(Color.WHITE);
        registerform.add(regmobile);

        regtxtmobile = new JTextField(10);
        regtxtmobile.setBounds(750, 320, 400, 45);
        regtxtmobile.setFont(txtfont);
        registerform.add(regtxtmobile);

        signupbtn = new JButton("Sign Up");
        signupbtn.setBounds(550, 450, 250, 60);
        signupbtn.setFont(lblfont);
        signupbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerform.add(signupbtn);

        lblregister = new JLabel("Already an User ?");
        lblregister.setBounds(850, 460, 150, 40);
        lblregister.setForeground(Color.WHITE);
        lblregister.setFont(subfont);
        registerform.add(lblregister);

        login = new JButton("Login");
        login.setBounds(1000, 460, 120, 40);
        login.setFont(subfont);
        login.setOpaque(false);
        login.setContentAreaFilled(false);
        login.setBorderPainted(false);
        login.setForeground(Color.WHITE);
        login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerform.add(login);

        signup.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                registerform.setVisible(true);
                loginform.setVisible(false);
                txtUserName.setText("");
                txtPW.setText("");
                regtxtUserName.setText("");
                regtxtmobile.setText("");
                regtxtPW.setText("");
            }
        });

        login.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                registerform.setVisible(false);
                loginform.setVisible(true);
                regtxtUserName.setText("");
                regtxtmobile.setText("");
                regtxtPW.setText("");
            }
        });

        signupbtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int mn = regtxtmobile.getText().length();
                String strmob = regtxtmobile.getText();
                char[] cmob = strmob.toCharArray();
                try
                {
                    if (regtxtUserName.getText().isEmpty() || regtxtPW.getText().isEmpty() || regtxtmobile.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(registerform, "All fields are required");
                    }
                    else if (!strmob.isEmpty())
                    {
                        int f = 0;
                        for (int i = 0; i < cmob.length; i++) {
                            if (cmob[i] >= 'A' && cmob[i] <= 'Z') {
                                f++;
                            } else if (cmob[i] >= 'a' && cmob[i] <= 'z') {
                                f++;
                            }
                        }
                        if (f > 0 || mn != 10)
                        {
                            JOptionPane.showMessageDialog(registerform, "Invalid Mobile Number");
                        }
                    }
                    else
                    {
                        registerform.setVisible(false);
                        loginform.setVisible(true);
                    }
                }
                catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(registerform,"Invalid Mobile Number");
                }
            }
        });
    }

    public void travel_details()
    {
        //TRAVEL DETAILS

        JLabel tWel,lblfrom,lblto,lbldate,lblnm,lblnf;
        JButton tback;

        traveldet = new JFrame("Travel Details");
        traveldet.setSize(1600,1080);
        traveldet.setLayout(null);
        traveldet.getContentPane().setBackground(new Color(53,46,99));
        traveldet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        traveldet.setExtendedState(JFrame.MAXIMIZED_BOTH);

        tWel = new JLabel("Welcome to Bus Reservation");
        tWel.setBounds(300,50,1000,60);
        tWel.setForeground(Color.YELLOW);
        tWel.setFont(titlefont);
        traveldet.add(tWel);

        lblfrom = new JLabel("From Place");
        lblfrom.setBounds(400,180,250,50);
        lblfrom.setFont(lblfont);
        lblfrom.setForeground(Color.WHITE);
        traveldet.add(lblfrom);

        String[] strfrom = {"Chennai","Madurai","Trichy","Tanjore"};
        txtfrom = new JComboBox(strfrom);
        txtfrom.setBounds(900,180,300,45);
        txtfrom.setFont(txtfont);
        traveldet.add(txtfrom);

        lblto = new JLabel("To Place");
        lblto.setBounds(400,260,250,50);
        lblto.setFont(lblfont);
        lblto.setForeground(Color.WHITE);
        traveldet.add(lblto);

        String[] strto = {"Chennai","Madurai","Trichy","Tanjore"};
        txtto  = new JComboBox(strto);
        txtto.setBounds(900,260,300,45);
        txtto.setFont(txtfont);
        traveldet.add(txtto);

        lblnm = new JLabel("No. of Male(s)");
        lblnm.setBounds(400,340,300,50);
        lblnm.setFont(lblfont);
        lblnm.setForeground(Color.WHITE);
        traveldet.add(lblnm);

        txtnm = new JTextField(10);
        txtnm.setBounds(900, 340, 300, 45);
        txtnm.setFont(txtfont);
        traveldet.add(txtnm);

        lblnf = new JLabel("No. of Female(s)");
        lblnf.setBounds(400,420,350,50);
        lblnf.setFont(lblfont);
        lblnf.setForeground(Color.WHITE);
        traveldet.add(lblnf);

        txtnf = new JTextField(10);
        txtnf.setBounds(900, 420, 300, 45);
        txtnf.setFont(txtfont);
        traveldet.add(txtnf);

        lbldate = new JLabel("Date of Journey");
        lbldate.setBounds(400,500,350,50);
        lbldate.setFont(lblfont);
        lbldate.setForeground(Color.WHITE);
        traveldet.add(lbldate);

        date = new JDateChooser();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH,2);
        date.setMaxSelectableDate(cal.getTime());
        date.setMinSelectableDate(new java.util.Date());
        date.setBounds(900,500,300,45);
        date.setFont(datefont);
        date.setDateFormatString("yyyy-MM-dd");
        traveldet.add(date);

        search = new JButton("Search");
        search.setBounds(700,600,200,60);
        search.setFont(lblfont);
        search.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        traveldet.add(search);

        tback = new JButton("Back");
        tback.setBounds(5, 20, 200, 40);
        tback.setFont(subfont);
        tback.setOpaque(false);
        tback.setContentAreaFilled(false);
        tback.setBorderPainted(false);
        tback.setForeground(Color.WHITE);
        tback.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        traveldet.add(tback);

        tback.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                traveldet.setVisible(false);
                loginform.setVisible(true);
            }
        });

        search.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String snm = txtnm.getText();
                    String snf = txtnf.getText();
                    char[] cnm = snf.toCharArray();
                    char[] cnf = snm.toCharArray();
                    int inm = Integer.parseInt(snm);
                    int inf = Integer.parseInt(snf);

                    if (txtfrom.getSelectedItem() == null || txtto.getSelectedItem() == null || txtnm.getText().isEmpty() || txtnf.getText().isEmpty() || date.getDate() == null)
                    {
                        JOptionPane.showMessageDialog(traveldet, "All the fields are required! If only male or female, mark the other as zero!");
                    }
                    else if (txtfrom.getSelectedItem().equals(txtto.getSelectedItem()))
                    {
                        JOptionPane.showMessageDialog(traveldet, "Source and Destination cannot be same");
                    }
                    else if ((inm + inf) > 10)
                    {
                        JOptionPane.showMessageDialog(traveldet, "Sorry! You can book only up to 10 seats at a time");
                    }
                    else
                    {
                        traveldet.setVisible(false);
                        busselect.setVisible(true);
                    }
                }
                catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(traveldet, "Please enter valid numbers for male and female counts");
                }
            }
        });
    }

    public void bus_details()
    {
        //BUS DETAILS

        JLabel lblbus,lblid;
        JButton bback;

        busselect = new JFrame("Bus Selection");
        busselect.setSize(1600,1080);
        busselect.setLayout(null);
        busselect.getContentPane().setBackground(new Color(53,46,99));
        busselect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        busselect.setExtendedState(JFrame.MAXIMIZED_BOTH);

        lblbus = new JLabel("Select Your Preferred Bus");
        lblbus.setBounds(350,50,1000,60);
        lblbus.setForeground(Color.YELLOW);
        lblbus.setFont(titlefont);
        busselect.add(lblbus);

        bustable = new JTable();
        bustable.setFont(new Font("times new roman",Font.PLAIN,15));
        bustable.setForeground(Color.BLACK);
        bustable.setRowHeight(35);
        bustable.setBackground(Color.GREEN);
        JScrollPane sp = new JScrollPane(bustable);
        sp.setBounds(20,160,1500,175);
        busselect.add(sp);

        lblid = new JLabel("Bus ID");
        lblid.setBounds(400,430,350,50);
        lblid.setFont(lblfont);
        lblid.setForeground(Color.WHITE);
        busselect.add(lblid);

        Integer[] bn= {1,2,3,4};
        bname = new JComboBox(bn);
        bname.setBounds(800,430,350,45);
        bname.setFont(txtfont);
        busselect.add(bname);

        proceed = new JButton("Proceed");
        proceed.setBounds(640,530,200,60);
        proceed.setFont(lblfont);
        proceed.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        busselect.add(proceed);

        bback = new JButton("Back");
        bback.setBounds(5, 20, 200, 40);
        bback.setFont(subfont);
        bback.setOpaque(false);
        bback.setContentAreaFilled(false);
        bback.setBorderPainted(false);
        bback.setForeground(Color.WHITE);
        bback.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        busselect.add(bback);

        bback.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                busselect.setVisible(false);
                traveldet.setVisible(true);
            }
        });
    }

    public void passenger_details()
    {
        //PASENGER DETAILS

        JLabel lblpdtitle,lblpname,lblpdage,lblpdgender,lblid,lblmsg1,lblmsg2;
        JButton pback;

        passengerdet = new JFrame("Passenger Details");
        passengerdet.setSize(1600,1080);
        passengerdet.setLayout(null);
        passengerdet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        passengerdet.setExtendedState(JFrame.MAXIMIZED_BOTH);
        passengerdet.getContentPane().setBackground(new Color(53,46,99));

        lblpdtitle = new JLabel("Passenger Details");
        lblpdtitle.setBounds(500,50,650,85);
        lblpdtitle.setFont(titlefont);
        lblpdtitle.setForeground(Color.CYAN);
        passengerdet.add(lblpdtitle);

        lblpname = new JLabel("Passenger Name");
        lblpname.setFont(lblfont);
        lblpname.setForeground(Color.WHITE);
        lblpname.setBounds(350,170,350,50);
        passengerdet.add(lblpname);

        txtpname = new JTextField();
        txtpname.setFont(txtfont);
        txtpname.setBounds(850,170,350,45);
        passengerdet.add(txtpname);

        lblpdgender = new JLabel("Passenger Gender");
        lblpdgender.setBounds(350,310,370,50);
        lblpdgender.setFont(lblfont);
        lblpdgender.setForeground(Color.WHITE);
        passengerdet.add(lblpdgender);

        String[] gen = {"Male","Female"};
        cgender = new JComboBox(gen);
        cgender.setBounds(850,310,350,45);
        cgender.setFont(txtfont);
        passengerdet.add(cgender);

        lblpdage = new JLabel("Passenger Age");
        lblpdage.setFont(lblfont);
        lblpdage.setForeground(Color.WHITE);
        lblpdage.setBounds(350,240,350,50);
        passengerdet.add(lblpdage);

        txtpdage = new JTextField();
        txtpdage.setFont(txtfont);
        txtpdage.setBounds(850,240,350,45);
        passengerdet.add(txtpdage);

        lblid = new JLabel("ID Proof");
        lblid.setBounds(350,380,350,50);
        lblid.setForeground(Color.WHITE);
        lblid.setFont(lblfont);
        passengerdet.add(lblid);

        String[] id = {"Aadhar Card","Voter ID","Driving License","Educational ID","Professional ID"};
        bid = new JComboBox(id);
        bid.setBounds(850,380,350,45);
        bid.setFont(txtfont);
        passengerdet.add(bid);

        lblmsg1 = new JLabel("Dear Passenger! You are requested to carry the ");
        lblmsg2 = new JLabel("selected ID Proof during your journey!");
        lblmsg1.setBounds(440,480,700,60);
        lblmsg1.setFont(new Font("times new roman",Font.PLAIN,35));
        lblmsg1.setForeground(Color.YELLOW);
        lblmsg2.setBounds(490,530,600,60);
        lblmsg2.setFont(new Font("times new roman",Font.PLAIN,35));
        lblmsg2.setForeground(Color.YELLOW);
        passengerdet.add(lblmsg1);
        passengerdet.add(lblmsg2);

        book = new JButton("Book");
        book.setBounds(650,630,200,60);
        book.setFont(lblfont);
        book.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        passengerdet.add(book);

        pback = new JButton("Back");
        pback.setBounds(5, 20, 200, 40);
        pback.setFont(subfont);
        pback.setOpaque(false);
        pback.setContentAreaFilled(false);
        pback.setBorderPainted(false);
        pback.setForeground(Color.WHITE);
        pback.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        passengerdet.add(pback);

        pback.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                passengerdet.setVisible(false);
                busselect.setVisible(true);
            }
        });

        book.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String age = txtpdage.getText();
                    int iage = Integer.parseInt(age);
                    if (txtpname.getText().isEmpty() || txtpdage.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(passengerdet, "All fields are required");
                    }
                    else if (iage > 99)
                    {
                        JOptionPane.showMessageDialog(passengerdet, "Invalid Age");
                    }
                    else
                    {
                        passengerdet.setVisible(false);
                        payment.setVisible(true);
                    }
                }
                catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(passengerdet, "Invalid Age");
                }
            }
        });
    }

    public void payment_details()
    {
        //PAYMENT DETAILS

        JLabel lblptitle,lblpm,lblcn,lblvt,lblcvv,lblbank,lblupi;
        JButton payback;

        payment = new JFrame("Payment");
        payment.setSize(1600,1080);
        payment.setLayout(null);
        payment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        payment.setExtendedState(JFrame.MAXIMIZED_BOTH);
        payment.getContentPane().setBackground(new Color(53,46,99));

        lblptitle = new JLabel("Payment");
        lblptitle.setBounds(650,50,650,85);
        lblptitle.setFont(titlefont);
        lblptitle.setForeground(Color.CYAN);
        payment.add(lblptitle);

        lblpm = new JLabel("Payment Mode");
        lblpm.setBounds(500,180,310,50);
        lblpm.setFont(lblfont);
        lblpm.setForeground(Color.WHITE);
        payment.add(lblpm);

        String[] spm = {"Select","Credit/Debit Card","Net Banking","UPI Payment"};
        bpm = new JComboBox(spm);
        bpm.setBounds(840,180,350,45);
        bpm.setFont(txtfont);
        payment.add(bpm);

        lblcn = new JLabel("Card Number");
        lblcn.setBounds(500,260,310,50);
        lblcn.setForeground(Color.WHITE);
        lblcn.setFont(lblfont);
        payment.add(lblcn);

        txtcn = new JTextField();
        txtcn.setBounds(840,260,350,45);
        txtcn.setFont(txtfont);
        payment.add(txtcn);

        lblvt = new JLabel("Valid Through");
        lblvt.setBounds(500,340,310,50);
        lblvt.setFont(lblfont);
        lblvt.setForeground(Color.WHITE);
        payment.add(lblvt);

        validt = new JDateChooser();
        validt.setBounds(840,340,350,45);
        validt.setFont(datefont);
        validt.setDateFormatString("MM/yy");
        payment.add(validt);

        lblcvv = new JLabel("CVV");
        lblcvv.setBounds(500,420,310,50);
        lblcvv.setFont(lblfont);
        lblcvv.setForeground(Color.WHITE);
        payment.add(lblcvv);

        cvv = new JPasswordField();
        cvv.setBounds(840,420,350,45);
        cvv.setFont(txtfont);
        payment.add(cvv);

        lblbank = new JLabel("Bank");
        lblbank.setBounds(500,500,310,50);
        lblbank.setForeground(Color.WHITE);
        lblbank.setFont(lblfont);
        payment.add(lblbank);

        String[] bnk={"Select","HDFC","SBI","IOB","CUB","ICICI","Axis","Kotak"};
        cbank = new JComboBox(bnk);
        cbank.setBounds(840,500,350,45);
        cbank.setFont(txtfont);
        payment.add(cbank);

        lblupi = new JLabel("UPI");
        lblupi.setBounds(500,580,310,50);
        lblupi.setFont(lblfont);
        lblupi.setForeground(Color.WHITE);
        payment.add(lblupi);

        String[] strupi = {"Select","Google Pay","Paytm","PhonePe","Amazon Pay","iMobile Pay"};
        cupi = new JComboBox(strupi);
        cupi.setBounds(840,580,350,45);
        cupi.setFont(txtfont);
        payment.add(cupi);

        pay = new JButton("Pay Now");
        pay.setBounds(675,680,250,60);
        pay.setFont(lblfont);
        pay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        payment.add(pay);

        payback = new JButton("Back");
        payback.setBounds(5, 20, 200, 40);
        payback.setFont(subfont);
        payback.setOpaque(false);
        payback.setContentAreaFilled(false);
        payback.setBorderPainted(false);
        payback.setForeground(Color.WHITE);
        payback.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        payment.add(payback);

        payback.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                payment.setVisible(false);
                passengerdet.setVisible(true);
            }
        });

        pay.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (bpm.getSelectedItem().equals("UPI Payment") && (!txtcn.getText().isEmpty() || cupi.getSelectedItem().equals("Select") || !cbank.getSelectedItem().equals("Select")))
                {
                    JOptionPane.showMessageDialog(payment, "You have selected UPI Payment. You should select the UPI Method, you should not enter the card and bank details");
                }
                else if (bpm.getSelectedItem().equals("Net Banking") && (!txtcn.getText().isEmpty() || cbank.getSelectedItem().equals("Select") || !cupi.getSelectedItem().equals("Select")))
                {
                    JOptionPane.showMessageDialog(payment, "You have selected Net Banking. You should select the appropriate bank, you should not enter card and UPI details");
                }
                else if (bpm.getSelectedItem().equals("Credit/Debit Card") && (txtcn.getText().isEmpty() || !cbank.getSelectedItem().equals("Select") || !cupi.getSelectedItem().equals("Select")))
                {
                    JOptionPane.showMessageDialog(payment, "You have selected Credit/Debit Card. You should enter all the card details, you should not enter bank and UPI details");
                }
                else if (bpm.getSelectedItem().equals("Credit/Debit Card") && txtcn.getText().length()!=12)
                {
                    JOptionPane.showMessageDialog(payment,"Invalid Card Number");
                }
                else if (bpm.getSelectedItem().equals("Credit/Debit Card") && cvv.getText().length()!=3)
                {
                    JOptionPane.showMessageDialog(payment,"Invalid CVV");
                }
                else if (bpm.getSelectedItem().equals("Select"))
                {
                    JOptionPane.showMessageDialog(payment,"Select any payment mode");
                }
                else
                {
                    payment.setVisible(false);
                    confirmation.setVisible(true);
                }
            }
        });
    }

    public void confirmation_details()
    {
        //CONFIRMATION DETAILS

        JLabel lblconfm,lblsuccpay,lblsty1,lblsty2;

        confirmation = new JFrame("Confirmation Page");
        confirmation.getContentPane().setBackground(new Color(53,46,99));
        confirmation.setSize(1600,1080);
        confirmation.setLayout(null);
        confirmation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        confirmation.setExtendedState(JFrame.MAXIMIZED_BOTH);

        lblconfm = new JLabel("Confirmation Status");
        lblconfm.setFont(titlefont);
        lblconfm.setForeground(Color.YELLOW);
        lblconfm.setBounds(450,60,700,60);
        confirmation.add(lblconfm);

        lblsuccpay = new JLabel("Success! Your payment has been confirmed!!");
        lblsuccpay.setBounds(225,150,1150,70);
        lblsuccpay.setForeground(Color.CYAN);
        lblsuccpay.setFont(subtitlefont);
        confirmation.add(lblsuccpay);

        lblspname = new JLabel("Passenger Name        -    ");
        lblspname.setBounds(450,250,1000,60);
        lblspname.setForeground(Color.WHITE);
        lblspname.setFont(txtfont);
        confirmation.add(lblspname);

        lblsfrom = new JLabel("Source                      -    ");
        lblsfrom.setBounds(450,330,1000,60);
        lblsfrom.setForeground(Color.WHITE);
        lblsfrom.setFont(txtfont);
        confirmation.add(lblsfrom);

        lblsto = new JLabel("Destination               -    ");
        lblsto.setBounds(450,410,1000,60);
        lblsto.setForeground(Color.WHITE);
        lblsto.setFont(txtfont);
        confirmation.add(lblsto);

        lblsdate = new JLabel("Journey Date             -    ");
        lblsdate.setBounds(450,490,1000,60);
        lblsdate.setForeground(Color.WHITE);
        lblsdate.setFont(txtfont);
        confirmation.add(lblsdate);

        lblsticket = new JLabel("Total no. of tickets    -    ");
        lblsticket.setBounds(450,570,1000,60);
        lblsticket.setForeground(Color.WHITE);
        lblsticket.setFont(txtfont);
        confirmation.add(lblsticket);

        lblsty1 = new JLabel("Dear Passenger! Kindly take a screenshot of this page");
        lblsty1.setBounds(400,670,1000,60);
        lblsty1.setFont(new Font("times new roman",Font.PLAIN,35));
        lblsty1.setForeground(Color.YELLOW);
        confirmation.add(lblsty1);

        lblsty2 = new JLabel("Thank You for choosing us! Have a Happy and Safe Jouney!!");
        lblsty2.setBounds(340,730,1000,60);
        lblsty2.setFont(new Font("times new roman",Font.PLAIN,35));
        lblsty2.setForeground(Color.YELLOW);
        confirmation.add(lblsty2);
    }
}

class back_end extends front_end
{
    protected String url = "jdbc:mysql://localhost:3306/brs";
    protected String un = "root";
    protected String pw = "!Sairam@123";

    public void login_register_sql()
    {
        signupbtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String username = regtxtUserName.getText();
                String password = new String(regtxtPW.getPassword());
                String mobile = regtxtmobile.getText();
                int mn = mobile.length();

                if (!username.isEmpty() && !password.isEmpty() && !mobile.isEmpty() && !regtxtmobile.getText().contains("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz~!@#$%^&*()_+-`") && mn==10)
                {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection(url, un, pw);
                        String qry1 = "insert into register (username,password,mobile) values (?,?,?)";
                        PreparedStatement pstmt = con.prepareStatement(qry1);
                        pstmt.setString(1, username);
                        pstmt.setString(2, password);
                        pstmt.setString(3, mobile);
                        int c1 = pstmt.executeUpdate();
                        con.close();
                        registerform.setVisible(false);
                        loginform.setVisible(true);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    public void check_sql()
    {
        loginbtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                String loginun = txtUserName.getText();
                String loginpw = new String(txtPW.getPassword());
                try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url,un,pw);
                    Statement stmt = con.createStatement();
                    String qry2 = "select * from register where username = '"+loginun+"' and password = '"+loginpw+"'";
                    ResultSet rs = stmt.executeQuery(qry2);
                    if (rs.next())
                    {
                        JOptionPane.showMessageDialog(loginform,"Login Successful!");
                        loginform.setVisible(false);
                        traveldet.setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(loginform,"Incorrect Username or Password!");
                    }
                    con.close();
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });
    }

    public void search_sql()
    {
        search.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String loginun = txtUserName.getText();
                String sfrom = txtfrom.getSelectedItem().toString();
                String sto = txtto.getSelectedItem().toString();
                Date sdate = date.getDate();
                int inm=0,inf=0;
                try
                {
                    String snm = txtnm.getText();
                    String snf = txtnf.getText();
                    inm = Integer.parseInt(snm);
                    inf = Integer.parseInt(snf);
                }
                catch (NumberFormatException ex)
                {
                    ex.printStackTrace();
                }
                if (txtfrom.getSelectedItem()!=txtto.getSelectedItem())
                {
                    try
                    {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection(url, un, pw);
                        String qry3 = "insert into travel_details (username,tfrom,tto,date,male,female) values (?,?,?,?,?,?)";
                        PreparedStatement pstmt = con.prepareStatement(qry3);
                        pstmt.setString(1, loginun);
                        pstmt.setString(2, sfrom);
                        pstmt.setString(3, sto);
                        pstmt.setDate(4, new java.sql.Date(sdate.getTime()));
                        pstmt.setInt(5, inm);
                        pstmt.setInt(6, inf);
                        int c2 = pstmt.executeUpdate();

                        String qry4 = "select count(*) from bus_schedule where date = ? and source=? and destination=?";
                        PreparedStatement pstmt3 = con.prepareStatement(qry4);
                        pstmt3.setDate(1,new java.sql.Date(sdate.getTime()));
                        pstmt3.setString(2,sfrom);
                        pstmt3.setString(3,sto);
                        ResultSet rs1 = pstmt3.executeQuery();
                        rs1.next();
                        if (rs1.getInt(1)>0)
                        {
                            String qry5 = "select bus_details.BUS_ID, BUS_NAME,BUS_TYPE,SEATER_SLEEPER,BUS_TIME,PRICE,DATE,AVAILABLE_SEATS from bus_details,bus_schedule where bus_details.bus_id = bus_schedule.bus_id and date = ? and source=? and destination=?";
                            PreparedStatement pstmt2 = con.prepareStatement(qry5);
                            pstmt2.setDate(1, new java.sql.Date(sdate.getTime()));
                            pstmt2.setString(2, sfrom);
                            pstmt2.setString(3, sto);
                            ResultSet rs = pstmt2.executeQuery();
                            ResultSetMetaData rsmd = rs.getMetaData();
                            DefaultTableModel model = (DefaultTableModel) bustable.getModel();
                            model.setRowCount(0);
                            int cols = rsmd.getColumnCount();
                            String[] colname = new String[cols];
                            for (int i = 0; i < cols; i++)
                            {
                                colname[i] = rsmd.getColumnName(i + 1);
                            }
                            model.setColumnIdentifiers(colname);
                            while (rs.next())
                            {
                                Object[] row = new Object[cols];
                                for (int i = 0; i < cols; i++)
                                {
                                    row[i] = rs.getObject(i + 1);
                                }
                                model.addRow(row);
                            }
                            bustable.setModel(model);
                        }
                        else
                        {
                            for (int i = 1; i <= 4; i++)
                            {
                                String qry6 = "insert into bus_schedule (bus_id,date,available_seats,source,destination) values (?,?,?,?,?)";
                                PreparedStatement pstmt4 = con.prepareStatement(qry6);
                                pstmt4.setInt(1,i);
                                pstmt4.setDate(2,new java.sql.Date(sdate.getTime()));
                                pstmt4.setString(4,sfrom);
                                pstmt4.setString(5,sto);
                                if (i%2==0)
                                {
                                    pstmt4.setInt(3,30);
                                }
                                else
                                {
                                    pstmt4.setInt(3,60);
                                }
                                pstmt4.executeUpdate();
                            }
                            String qry7 = "select bus_details.BUS_ID, BUS_NAME,BUS_TYPE,SEATER_SLEEPER,BUS_TIME,PRICE,DATE,AVAILABLE_SEATS from bus_details,bus_schedule where bus_details.bus_id = bus_schedule.bus_id and date = ? and source=? and destination=?";
                            PreparedStatement pstmt2 = con.prepareStatement(qry7);
                            pstmt2.setDate(1, new java.sql.Date(sdate.getTime()));
                            pstmt2.setString(2, sfrom);
                            pstmt2.setString(3, sto);
                            ResultSet rs = pstmt2.executeQuery();
                            ResultSetMetaData rsmd = rs.getMetaData();
                            DefaultTableModel model = (DefaultTableModel) bustable.getModel();
                            model.setRowCount(0);
                            int cols = rsmd.getColumnCount();
                            String[] colname = new String[cols];
                            for (int i = 0; i < cols; i++)
                            {
                                colname[i] = rsmd.getColumnName(i + 1);
                            }
                            model.setColumnIdentifiers(colname);
                            while (rs.next())
                            {
                                Object[] row = new Object[cols];
                                for (int i = 0; i < cols; i++)
                                {
                                    row[i] = rs.getObject(i + 1);
                                }
                                model.addRow(row);
                            }
                            bustable.setModel(model);
                        }
                        con.close();
                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    public void proceed_sql()
    {
        proceed.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int bid = (Integer)bname.getSelectedItem();
                Date prdate = date.getDate();
                String prfrom = txtfrom.getSelectedItem().toString();
                String prto = txtto.getSelectedItem().toString();
                String snm = txtnm.getText();
                String snf = txtnf.getText();
                int inm = Integer.parseInt(snm);
                int inf = Integer.parseInt(snf);
                try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url,un,pw);
                    String qry8 = "select available_seats from bus_schedule where bus_id = ? and DATE = ? and source = ? and destination = ?";
                    PreparedStatement pstmt = con.prepareStatement(qry8);
                    pstmt.setInt(1,bid);
                    pstmt.setDate(2,new java.sql.Date(prdate.getTime()));
                    pstmt.setString(3,prfrom);
                    pstmt.setString(4,prto);
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next())
                    {
                        int as = rs.getInt("available_seats");
                        if (as==0)
                        {
                            JOptionPane.showMessageDialog(busselect,"Bus is Full! Try another Bus or Date");
                        }
                        else
                        {
                            busselect.setVisible(false);
                            passengerdet.setVisible(true);
                        }
                    }
                    else
                    {
                        busselect.setVisible(false);
                        passengerdet.setVisible(true);
                    }
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });
    }

    public void pay_sql()
    {
        pay.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String loginun = txtUserName.getText();
                String pfrom = txtfrom.getSelectedItem().toString();
                String pto = txtto.getSelectedItem().toString();
                Date pdate = date.getDate();
                String snm = txtnm.getText();
                String snf = txtnf.getText();
                int bid = (Integer) bname.getSelectedItem();
                int inm = Integer.parseInt(snm);
                int inf = Integer.parseInt(snf);

                lblspname.setText("Passenger Name        -    "+txtpname.getText());
                lblsfrom.setText("Source                       -    "+txtfrom.getSelectedItem());
                lblsto.setText("Destination                -    "+txtto.getSelectedItem());
                lblsdate.setText("Journey Date             -    "+new java.sql.Date(pdate.getTime()));
                lblsticket.setText("Total no. of tickets    -    "+(inm+inf));

                try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url,un,pw);
                    String qry9 = "insert into ticket (username,tfrom,tto,date,male,female) values (?,?,?,?,?,?)";
                    PreparedStatement pstmt = con.prepareStatement(qry9);
                    pstmt.setString(1,loginun);
                    pstmt.setString(2,pfrom);
                    pstmt.setString(3,pto);
                    pstmt.setDate(4,new java.sql.Date(pdate.getTime()));
                    pstmt.setInt(5,inm);
                    pstmt.setInt(6,inf);
                    int c3 = pstmt.executeUpdate();

                    String qry13 = "select distinct * from ticket";
                    PreparedStatement pstmt5 = con.prepareStatement(qry13);
                    ResultSet rs = pstmt5.executeQuery();
                    rs.next();
                    String loginun1 = rs.getString("username");
                    String pfrom1 = rs.getString("tfrom");
                    String pto1 = rs.getString("tto");
                    Date pdate1 = rs.getDate("date");
                    int inm1 = rs.getInt("male");
                    int inf1 = rs.getInt("female");

                    String qry10 = "insert into trip (username,tfrom,tto,date,male,female) values (?,?,?,?,?,?)";
                    PreparedStatement pstmt1 = con.prepareStatement(qry10);
                    pstmt1.setString(1,loginun1);
                    pstmt1.setString(2,pfrom1);
                    pstmt1.setString(3,pto1);
                    pstmt1.setDate(4,new java.sql.Date(pdate1.getTime()));
                    pstmt1.setInt(5,inm1);
                    pstmt1.setInt(6,inf1);
                    int c4 = pstmt1.executeUpdate();

                    String qry11 = "update bus_schedule set AVAILABLE_SEATS = AVAILABLE_SEATS - (SELECT SUM(male + female) FROM ticket where date = bus_schedule.date and tfrom = bus_schedule.source and tto = bus_schedule.destination) WHERE date = ? AND BUS_ID=? and source = ? and destination = ?";
                    PreparedStatement pstmt3 = con.prepareStatement(qry11);
                    pstmt3.setDate(1,new java.sql.Date(pdate.getTime()));
                    pstmt3.setInt(2,bid);
                    pstmt3.setString(3,pfrom);
                    pstmt3.setString(4,pto);
                    int c5=pstmt3.executeUpdate();

                    String qry12 = "delete from ticket";
                    PreparedStatement pstmt4 = con.prepareStatement(qry12);
                    int c6=pstmt4.executeUpdate();

                    con.close();
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });
    }

}

public class bus_reservaton_system
{
    public static void main(String args[])
    {
        back_end be = new back_end();

        be.font();
        be.login_registration_form();
        be.travel_details();
        be.bus_details();
        be.passenger_details();
        be.payment_details();
        be.confirmation_details();

        be.login_register_sql();
        be.check_sql();
        be.search_sql();
        be.proceed_sql();
        be.pay_sql();
    }
}

