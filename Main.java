package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String months[] = {        //Create 12 months
                "Jan",
                "Feb",
                "Mar",
                "Apr",
                "May",
                "Jun",
                "Jul",
                "Aug",
                "Sep",
                "Oct",
                "Nov",
                "Dec"
        };
        Calendar calendar = Calendar.getInstance();

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("            *** * Welcome to Westminster Skin Consultation Manager * ***");
        System.out.println("--------------------------------------------------------------------------------");

        //Calculate date,mouths & year
        System.out.print("Date: " + months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.YEAR));
        //calculate hour,minutes & seconds
        System.out.println("\t\t\t\t\t\tTime: " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));

        Scanner input = new Scanner(System.in);
        ArrayList<Doctor> doc = new ArrayList<>();
        ArrayList<Consultation> consultations = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            String pass;
            System.out.println("\nEnter Password :");
            pass = input.nextLine();      // Login password
            while ("IIT".equals(pass)) {    // Verify password (IIT)

                System.out.println("\n                             MAIN MENU");
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println("\nA: Add New Doctor");
                System.out.println("B: Delete Doctor");
                System.out.println("C: Print The lList of The Doctors");
                System.out.println("D: Save In File");
                System.out.println("E: Open GUI ");

                System.out.print("\nYour Choice :\n");  //  User input
                String choice = input.nextLine();

                if (choice.equals("A")) {
                    doc = Add_Doctor(doc); // Add Doctors
                }
                if (choice.equals("B")) {
                    doc = Del_Doctor(doc); // Remove Doctors
                }

                if (choice.equals("C")) {
                    doc = Print_Doctor(doc); // view Doctors
                }

                if (choice.equals("D")) {
                    doc = Save_data(doc); // Data Save in File
                }

                if (choice.equals("E")) {
                    Open_Gui(doc, consultations); // Open GUI Part
                }
            }
            System.out.println("Wrong Password..\n Try again.."); // Catch the Wrong Password
        }
    }

    public static ArrayList<Doctor> Add_Doctor(ArrayList<Doctor> Doc) {
        Scanner input = new Scanner(System.in);

                                                          // Doctors Information
            System.out.println("\nYour name here :");
            String name = input.nextLine();

            System.out.print("Your sure name here :");
            String sureName = input.nextLine();

            System.out.print("Date Of Birth:");
            String birthday = input.nextLine();

            System.out.print("Mobile Number :");
            String mobile = input.nextLine();

            System.out.print("Medical Licence Number :");
            String medId = input.nextLine();

            System.out.print("Specialisation :");
            String specialisation = input.nextLine();

            Doctor d = new Doctor();
                                                           // Connecting with Doctor Class
            d.setName(name);
            d.setSurName(sureName);
            d.setDob(birthday);
            d.setMblNumber((mobile));
            d.setMedId(medId);
            d.setSpecialisation(specialisation);
            Doc.add(d);

            System.out.println(Doc);                       //Exit or continue the Program
            System.out.print("\nif you want to continue press Y and press  any key exit :");
            String yes = input.nextLine();
                                                               // Continue the Program
            if (yes.equals("y")) {


            } else {                                            // Exit the Program
                System.out.println("Thanks for joining us...");
                System.out.println("See you again..");
                System.exit(0);
            }

        return Doc;
    }

    public static ArrayList<Doctor> Del_Doctor (ArrayList<Doctor> Doc) {    // Remove Doctor
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the doctor's license number to strike it out : ");    // User input
        String enterId = input.nextLine();

        Doctor doctor = null;
        for (Doctor d : Doc) {                              // Comparison of Doctor license number and user input
            if (d.getMedId().equals(enterId)) {
                doctor = d;
                break;
            }
        }
        if (doctor == null) {                                   // Notification of error if incorrect license number
            System.out.println("The requested license number for a doctor could not be located..");
            System.out.println("Please Enter Correct license Number..");

        }else {
            Doc.remove(doctor);                           // If equal,the doctor will be Removed
            System.out.println("The name of the " + doctor.getName() + " " + doctor.getSurName() + "doctor and  " + doctor.getMedId() + "license number  has been removed.");
            System.out.println("The centre now has " + Doc.size() + " doctors.");

        }


        return Doc;
    }


    public static ArrayList<Doctor> Print_Doctor (ArrayList<Doctor> Doc) {       // View All Doctors Information
        Doc.sort(new Comparator<Doctor>() {                     // Used to order the objects of a user-defined class
            @Override
            public int compare(Doctor o1, Doctor o2) {return o1.getSurName().compareTo(o2.getSurName());}

        });
        System.out.println("Current doctors are..");
        for (Doctor doctor : Doc) {                            // Doctors information
            System.out.println("Doctor name: " + doctor.getName() + " " + doctor.getSurName());
            System.out.println("Medical license number: " + doctor.getMedId());
            System.out.println("Specialization: " + doctor.getSpecialisation());
            System.out.println("-----------------------------");
            System.out.println();
        }

        return Doc;
    }


    public static ArrayList<Doctor> Save_data (ArrayList <Doctor> Doc) throws IOException{   // Data save in File

        File file = new File("C:\\cabinTask_2.txt");        // Saving file name
        FileWriter saveArray = new FileWriter(file);                    // File writer
        saveArray.write(String.valueOf(Doc.size()));
        saveArray.write("\n");
        for (Doctor doctor : Doc) {
            saveArray.write(doctor.getName());
            saveArray.write("\n");
            saveArray.write(doctor.getSurName());
            saveArray.write("\n");
            saveArray.write(doctor.getMedId());
            saveArray.write("\n");
            saveArray.write(doctor.getSpecialisation());
            saveArray.write("\n");
                                                          // Write other doctor information as needed

        }


        return Doc;
    }


    private static ArrayList<Consultation> Add_Consultation (ArrayList<Consultation> consultations) {

        return consultations;
    }


    private static void Open_Gui(ArrayList<Doctor> Doc ,ArrayList <Consultation> consultations) {  // Open GUI Part
        JFrame main = new JFrame();
        JPanel panel = new JPanel();
        main.getContentPane();
        main.setTitle("Westminster Skin Consultation Manager");  // Add title in
        // Add Icon in project
        ImageIcon image = new ImageIcon("C:\\Users\\ASUS\\IdeaProjects\\oop cw ni\\src\\com\\company\\logo.png");
        main.setIconImage(image.getImage());


        JButton alld = new JButton("All Doctors");
        alld.setPreferredSize(new Dimension(200, 50));
        alld.addActionListener(e ->
                {
                    viewDoctor(Doc);
                }
        );
        Dimension size1 = alld.getPreferredSize();
        alld.setBounds(100, 80, size1.width, size1.height);
        panel.setLayout(null);
        panel.add(alld);

        JButton cha = new JButton("chanel a doctor");
        cha.setPreferredSize(new Dimension(200, 50));
        cha.addActionListener(e ->
                {
                    bookDoctor(Doc,consultations);
                }
        );


        Dimension size2 = cha.getPreferredSize();
        cha.setBounds(350, 80, size2.width, size2.height);
        panel.setLayout(null);
        panel.add(cha);


        JButton allc = new JButton("view all chanel");
        allc.setPreferredSize(new Dimension(200, 50));
        allc.addActionListener(e ->
                {
                    viewChannel(Doc,consultations);
                }
        );


        Dimension sizeViewChnl = allc.getPreferredSize();
        allc.setBounds(225, 170, sizeViewChnl.width, sizeViewChnl.height);
        panel.setLayout(null);
        panel.add(allc);

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.add(panel);
        main.setLocation(500,400);
        main.setSize(650, 350);
        main.setVisible(true);
        panel.setBackground(new Color(0x0E5FC7));
    }

    private static void viewChannel(ArrayList<Doctor> doctors, ArrayList<Consultation> consultations) {

        JFrame vcf = new JFrame();
        JPanel panel = new JPanel();
        vcf.getContentPane();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        vcf.add(panel);
        vcf.setSize(1000, 300);
        vcf.setVisible(true);
        panel.setBackground(new Color(0xD2B0F8));

        JLabel  eyn = new JLabel("Enter Your Name:");
        eyn.setFont(new Font("Arial", Font.PLAIN, 20));
        Dimension size1entrName = eyn.getPreferredSize();
        eyn.setBounds(50, 75, size1entrName.width, size1entrName.height);
        panel.setLayout(null);
        panel.add(eyn);

        JTextField eynt = new JTextField();
        eynt.setSize(150,20);
        eynt.setLocation(220, 75);
        panel.add(eynt);

        JLabel  eys = new JLabel("Enter Your SurName:");
        eys.setFont(new Font("Arial", Font.PLAIN, 20));
        Dimension size1entrSurName = eys.getPreferredSize();
        eys.setBounds(500, 75, size1entrSurName.width, size1entrSurName.height);
        panel.setLayout(null);
        panel.add(eys);

        JTextField eyst = new JTextField();
        eyst.setSize(150,20);
        eyst.setLocation(700, 75);
        panel.add(eyst);

        JButton btn = new JButton("Submit");
        btn.setPreferredSize(new Dimension(200, 50));
        Dimension sizeSubmit = btn.getPreferredSize();
        btn.setBounds(350, 150, sizeSubmit.width, sizeSubmit.height);

        btn.addActionListener(e ->
                {
                    JFrame onlyTable = new JFrame();
                    JPanel panelOnly = new JPanel();
                    onlyTable.getContentPane();
                    panelOnly.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                    onlyTable.add(panelOnly);
                    onlyTable.setSize(1300, 800);
                    onlyTable.setVisible(true);

                    String[] cols = { "date", "dctrName", "Start Time", "End Time","Cost","Notes" };
                    DefaultTableModel tableM = new DefaultTableModel(cols, 0);
                    JTable table = new JTable(tableM);
                    JScrollPane sp = new JScrollPane(table);
                    onlyTable.add(sp);

                    ArrayList<Consultation> c1=new ArrayList<>();
                    for (Consultation consultation:consultations) {

                        if (consultation.getPtntName().equals(eynt.getText())){

                            if (consultation.getPtnSurName().equals(eyst.getText())){

                                c1.add(consultation);
                            }else{
                                JOptionPane.showMessageDialog(null, "No old consultation  your");
                            }
                        }else {
                            JOptionPane.showMessageDialog(null, "No old consultation  your");
                        }

                    }
                    for (Consultation consultation:c1) {

                        String date = consultation.getDate();
                        String dctrName = consultation.getDctrName();
                        String Start_Time = consultation.getStartTime();
                        String End_Time = consultation.getEndTime();
                        int Cost = consultation.getCost();
                        String Notes = consultation.getNotes();

                        Object[] data = {date, dctrName, Start_Time, End_Time, Cost, Notes};

                        tableM.addRow(data);


                    }
                }
        );
        panel.add(btn);



    }

    private static void bookDoctor(ArrayList<Doctor> doctors, ArrayList<Consultation> consultations) {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.getContentPane();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(panel);
        frame.setSize(700, 900);
        frame.setVisible(true);
        panel.setBackground(new Color(0xD2B0F8));

        JLabel title = new JLabel("Patient Information");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(200, 40);
        panel.add(title);

        //Name
        JLabel   pn= new JLabel("Patient Name:");
        pn.setFont(new Font("Arial", Font.PLAIN, 20));
        Dimension size1 = pn.getPreferredSize();
        pn.setBounds(100, 100, size1.width, size1.height);
        panel.setLayout(null);
        panel.add(pn);

        JTextField pnt = new JTextField();
        pnt.setSize(150,20);
        pnt.setLocation(325, 100);
        panel.add(pnt);

        //surName
        JLabel  ps = new JLabel("Patient Sur_Name:");
        ps.setFont(new Font("Arial", Font.PLAIN, 20));
        Dimension size5 = ps.getPreferredSize();
        ps.setBounds(100, 150, size5.width, size5.height);
        panel.setLayout(null);
        panel.add(ps);

        JTextField pst = new JTextField();
        pst.setSize(150,20);
        pst.setLocation(325, 150);
        panel.add(pst);

        //datepicker
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Arial", Font.PLAIN, 20));
        Dimension sizedate = dob.getPreferredSize();
        dob.setBounds(100, 200, sizedate.width, sizedate.height);
        panel.setLayout(null);
        panel.add(dob);

        JTextField dobt = new JTextField(20);
        dobt.setSize(150,20);
        dobt.setLocation(325, 200);
        panel.add(dobt);

        JButton pop1 = new JButton("popup");
        Dimension sizePopup = pop1.getPreferredSize();
        pop1.setBounds(500, 200, sizePopup.width, sizePopup.height);
        panel.add(pop1);
        pop1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dobt.setText(new DatePicker(frame).setPickedDate());
            }
        });


        JLabel  tp = new JLabel("Telephone No:");
        tp.setFont(new Font("Arial", Font.PLAIN, 20));
        Dimension size7 = tp.getPreferredSize();
        tp.setBounds(100, 250, size7.width, size7.height);
        panel.setLayout(null);
        panel.add(tp);

        JTextField tpt = new JTextField();
        tpt.setSize(150,20);
        tpt.setLocation(325, 250);
        panel.add(tpt);

        JLabel ci = new JLabel("Consult Information");
        ci.setFont(new Font("Arial", Font.PLAIN, 30));
        ci.setSize(300, 30);
        ci.setLocation(150, 290);
        panel.add(ci);


        JLabel d = new JLabel("Date:");
        d.setFont(new Font("Arial", Font.PLAIN, 20));
        Dimension sizeDob = d.getPreferredSize();
        d.setBounds(100, 350, sizeDob.width, sizeDob.height);
        panel.setLayout(null);
        panel.add(d);

        JTextField dt = new JTextField(20);
        dt.setSize(150,20);
        dt.setLocation(325, 350);
        panel.add(dt);

        JButton pop2 = new JButton("popup");
        Dimension size = pop2.getPreferredSize();
        pop2.setBounds(500, 350, size.width, size.height);
        panel.add(pop2);
        pop2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dt.setText(new DatePicker(frame).setPickedDate());
            }
        });

        JLabel  st = new JLabel("Start Time:");
        st.setFont(new Font("Arial", Font.PLAIN, 20));
        Dimension size9 = st.getPreferredSize();
        st.setBounds(100, 400, size9.width, size9.height);
        panel.setLayout(null);
        panel.add(st);



        String []startTimearray=new String[18];
        for (int i = 6; i < 18; i++) {
            startTimearray[i]= String.valueOf(i);
        }
        JComboBox stt=new JComboBox(startTimearray);
        stt.setSize(150,20);
        stt.setLocation(325, 400);
        panel.add(stt);


        String []h=new String[100];
        for (int i = 0; i <12; i++) {
            h[i]= String.valueOf(i+1);

        }

        JLabel  ho = new JLabel("Hours");
        ho.setFont(new Font("Arial", Font.PLAIN, 20));
        Dimension sizehrs = ho.getPreferredSize();
        ho.setBounds(100, 450, sizehrs.width, sizehrs.height);
        panel.setLayout(null);
        panel.add(ho);


        JComboBox cmb=new JComboBox(h);
        cmb.setSize(150,20);
        cmb.setLocation(325, 450);
        panel.add(cmb);

        JLabel  et = new JLabel("End Time:");
        et.setFont(new Font("Arial", Font.PLAIN, 20));
        Dimension size10 = et.getPreferredSize();
        et.setBounds(100, 500, size10.width, size10.height);
        panel.setLayout(null);
        panel.add(et);

        JTextField ett = new JTextField();
        ett.setSize(150,20);
        ett.setLocation(325, 500);
        panel.add(ett);

        cmb.addActionListener(e ->{
            int getStartTime= Integer.parseInt(stt.getSelectedItem().toString());

            int howMnyHurs= Integer.parseInt(cmb.getSelectedItem().toString());
            int endManualfinalTime=getStartTime+howMnyHurs;
            ett.setText(String.valueOf(endManualfinalTime));
        } );



        String []dctrName=new String[10];
        for (int i = 0; i < doctors.size(); i++) {
            dctrName[i]=doctors.get(i).getName();
        }


        JLabel  dn = new JLabel("Doctor Name:");
        dn.setFont(new Font("Arial", Font.PLAIN, 20));
        Dimension size11 = dn.getPreferredSize();
        dn.setBounds(100, 550, size11.width, size11.height);
        panel.setLayout(null);
        panel.add(dn);

        JComboBox dnt=new JComboBox(dctrName);
        dnt.setSize(150,20);
        dnt.setLocation(325, 550);
        panel.add(dnt);

        JLabel  des = new JLabel("Description");
        des.setFont(new Font("Arial", Font.PLAIN, 20));
        Dimension size12 = des.getPreferredSize();
        des.setBounds(100, 600, size12.width, size12.height);
        panel.setLayout(null);
        panel.add(des);

        JTextField dest = new JTextField();
        dest.setSize(150,20);
        dest.setLocation(325, 600);
        panel.add(dest);

        JLabel  fcd = new JLabel("Is This your first consult this doctor:");
        fcd.setFont(new Font("Arial", Font.PLAIN, 20));
        Dimension sizeCalCost = fcd.getPreferredSize();
        fcd.setBounds(100, 650, sizeCalCost.width, sizeCalCost.height);
        panel.setLayout(null);
        panel.add(fcd);

        JButton yes = new JButton("Yes");
        Dimension sizeYes = yes.getPreferredSize();
        yes.setBounds(500, 650, sizeYes.width, sizeYes.height);
        panel.add(yes);


        JButton no = new JButton("No");
        Dimension sizeNo = no.getPreferredSize();
        no.setBounds(550, 650, sizeNo.width, sizeNo.height);
        panel.add(no);


        JLabel  cost = new JLabel("Cost :");
        cost.setFont(new Font("Arial", Font.PLAIN, 20));
        Dimension sizecost = cost.getPreferredSize();
        cost.setBounds(100, 700, sizecost.width, sizecost.height);
        panel.setLayout(null);
        panel.add(cost);

        JTextField tcost = new JTextField();
        tcost.setSize(150,20);
        tcost.setLocation(325, 700);
        panel.add(tcost);

        yes.addActionListener(e ->{

            int hourscal= Integer.parseInt(cmb.getSelectedItem().toString());
            int finalCost=hourscal*15;
            tcost.setText(String.valueOf(finalCost));

        });
        no.addActionListener(e ->{
            int hourscalNo= Integer.parseInt(cmb.getSelectedItem().toString());
            int finalCost=hourscalNo*25;
            tcost.setText(String.valueOf(finalCost));

        });

        //book dctr button
        JButton button = new JButton("Book Doctor");
        button.setPreferredSize(new Dimension(200, 50));
        Dimension sizebook = button.getPreferredSize();
        button.setBounds(250, 750, sizebook.width, sizebook.height);
        panel.add(button);
        button.addActionListener(e ->
        {
            System.out.println("book doctor start");

            Consultation consultation1 = new Consultation();
            consultation1.setDctrName(dnt.getSelectedItem().toString());
            consultation1.setDate(dt.getText());
            consultation1.setStartTime(stt.getSelectedItem().toString());
            consultation1.setNotes(dest.getText());
            consultation1.setEndTime(ett.getText());
            consultation1.setPtntName(pnt.getText());
            consultation1.setCost(Integer.parseInt(tcost.getText()));
            consultation1.setPtnDOB(dobt.getText());
            consultation1.setPtnTel(tpt.getText());
            consultation1.setPtnSurName(pst.getText());

            if (consultations.isEmpty()){
                consultations.add(consultation1);
            }else {
                for (Consultation consultation:consultations) {
                    if (consultation.getDctrName().equals(consultation1.getDctrName())){
                        if (consultation.getDate().equals(consultation1.getDate())){
                            int c1= Integer.parseInt(consultation.getStartTime());
                            int c2= Integer.parseInt(consultation.getEndTime());
                            int d1= Integer.parseInt(consultation1.getEndTime());
                            int d2= Integer.parseInt(consultation1.getStartTime());
                            if (c1>d1 || c2<d2){
                                consultations.add(consultation1);
                            }else{
                                System.out.println("this doctr its book..");
                                JOptionPane.showMessageDialog(null, "booked");
                            }
                        }else{
                            consultations.add(consultation1);
                        }

                    }else {
                        consultations.add(consultation1);
                    }
                }
            }
        });
        System.out.println("end");

    }
    private static void viewDoctor(ArrayList<Doctor> doc){

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.getContentPane();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(panel);
        frame.setSize(500, 300);
        frame.setVisible(true);
        doc.sort(new Comparator<Doctor>() {


            @Override
            public int compare(Doctor d1, Doctor d2) {return d1.getSurName().compareTo(d2.getSurName());}

        });

        String[] Col = { "Name", "Sure Name", "Date of Birthday", "Mobile Num.","license Num.","Specialication" };
        DefaultTableModel tableM = new DefaultTableModel(Col, 0);
        JTable table = new JTable(tableM);
        JScrollPane sp = new JScrollPane(table);
        frame.add(sp);
        for (int i =0; i<doc.size();i++) {
            String Name = doc.get(i).getName();
            String surName = doc.get(i).getSurName();
            String Dob = doc.get(i).getDob();
            String mblNumber = doc.get(i).getMblNumber();
            String liceneNumber = doc.get(i).getMedId();
            String Specialication = doc.get(i).getSpecialisation();
            Object[] data = {Name, surName, Dob, mblNumber,liceneNumber,Specialication};
            tableM.addRow(data);
        }

    }



}

