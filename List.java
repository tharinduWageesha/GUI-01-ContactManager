import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.EmptyBorder;

class List extends JFrame {
    private JButton btnLN;
    private JButton btnLS;
    private JButton btnLB;
    private JButton btnExit;

    public List() {
        // Making window
        setTitle("List Contacts");
        setSize(500, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Heading------------------------
        JPanel title = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("List Contacts");
        titleLabel.setFont(new Font("", Font.BOLD, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        title.setBackground(new Color(173, 216, 230));
        title.add(titleLabel, BorderLayout.NORTH);
        add(title, BorderLayout.NORTH);

        // Btn Panel--------------------------
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.Y_AXIS));
        btnPanel.setBackground(new Color(173, 216, 230));
        btnPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        btnLN = new JButton("List by Name");
        btnLN.setFont(new Font("", Font.BOLD, 20));
        btnLN.setMaximumSize(new Dimension(240, 50));
        btnLN.setBorder(new EmptyBorder(10, 10, 10, 10));
        btnLN.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ListByNames.listNames();
            }
        });
        btnPanel.add(btnLN);

        btnLS = new JButton("List by Salary");
        btnLS.setFont(new Font("", Font.BOLD, 20));
        btnLS.setMaximumSize(new Dimension(240, 50));
        btnLS.setBorder(new EmptyBorder(10, 10, 10, 10));
        btnLS.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ListBySals.listSals();
            }
        });
        btnPanel.add(btnLS);

        btnLB = new JButton("List by Birthday");
        btnLB.setFont(new Font("", Font.BOLD, 20));
        btnLB.setMaximumSize(new Dimension(240, 50));
        btnLB.setBorder(new EmptyBorder(10, 10, 10, 10));
        btnLB.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ListByBDs.listBDs();
            }
        });
        btnPanel.add(btnLB);

        add(btnPanel, BorderLayout.CENTER);

        // Exit panel---------------
        JPanel exitArea = new JPanel();
        exitArea.setLayout(new BoxLayout(exitArea, BoxLayout.Y_AXIS));
        exitArea.setBackground(new Color(173, 216, 230));
        exitArea.setAlignmentX(Component.RIGHT_ALIGNMENT);

        btnExit = new JButton("Exit");
        btnExit.setFont(new Font("", Font.BOLD, 20));
        btnExit.setMaximumSize(new Dimension(240, 50));
        btnExit.setBorder(new EmptyBorder(10, 10, 10, 10));
        btnExit.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Action to dispose the window
                dispose();
            }
        });
        exitArea.add(btnExit);

        add(exitArea, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void listContacts() {
        new List();
    }

    public static void main(String[] args) {
        listContacts();
    }
}

class ListByNames extends JFrame {
    public ListByNames() {
        // Making window
        setTitle("List Contacts by Name");
        setSize(1000, 800);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Heading------------------------
        JPanel title = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Contacts Listed by Name");
        titleLabel.setFont(new Font("", Font.BOLD, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        title.setBackground(new Color(173, 216, 230));
        title.add(titleLabel, BorderLayout.NORTH);
        add(title, BorderLayout.NORTH);

        // Table--------------------------
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        model.addColumn("Contact Id");
        model.addColumn("Name");
        model.addColumn("Phone Number");
        model.addColumn("Company Name");
        model.addColumn("Salary");
        model.addColumn("Birthday");

       /* for (Contact contact : OOPDay03.contactList) {
            model.addRow(new Object[]{
                contact.getId(),
                contact.getName(),
                contact.getPhoneNumber(),
                contact.getCompanyName(),
                contact.getSalary(),
                contact.getBirthday()
            });
        }*/

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void listNames() {
        new ListByNames();
    }
}

class ListBySals extends JFrame {
    public ListBySals() {
        // Making window
        setTitle("List Contacts by Salary");
        setSize(1000, 800);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Heading------------------------
        JPanel title = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Contacts Listed by Salary");
        titleLabel.setFont(new Font("", Font.BOLD, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        title.setBackground(new Color(173, 216, 230));
        title.add(titleLabel, BorderLayout.NORTH);
        add(title, BorderLayout.NORTH);

        // Table--------------------------
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        model.addColumn("Contact Id");
        model.addColumn("Name");
        model.addColumn("Phone Number");
        model.addColumn("Company Name");
        model.addColumn("Salary");
        model.addColumn("Birthday");

        // Add data to table (sorted by salary)

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void listSals() {
        new ListBySals();
    }
}

class ListByBDs extends JFrame {
    public ListByBDs() {
        // Making window
        setTitle("List Contacts by Birthday");
       setSize(1000, 800);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Heading------------------------
        JPanel title = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Contacts Listed by Birthday");
        titleLabel.setFont(new Font("", Font.BOLD, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        title.setBackground(new Color(173, 216, 230));
        title.add(titleLabel, BorderLayout.NORTH);
        add(title, BorderLayout.NORTH);

        // Table--------------------------
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        model.addColumn("Contact Id");
        model.addColumn("Name");
        model.addColumn("Phone Number");
        model.addColumn("Company Name");
        model.addColumn("Salary");
        model.addColumn("Birthday");

        // Add data to table (sorted by birthday)

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void listBDs() {
        new ListByBDs();
    }
}
