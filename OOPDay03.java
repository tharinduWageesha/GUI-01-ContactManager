import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.io.File;
import javax.swing.border.EmptyBorder;

class OOPDay03 extends JFrame {
	private static JButton btnADD;
    private static JButton btnDEL;
    private static JButton btnSCH;
    private static JButton btnLST;
    private static JButton btnUPD;
	private static JButton btnExit;
	
	
    public static ContactList contactList = new ContactList();

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
         // ADD Home Image
        JFrame frame = new JFrame("iFriend Contact Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 1000);

        JPanel panel = new JPanel(new BorderLayout());

        ImageIcon originalIcon = new ImageIcon("D:/ICET PROJECTS/IFRIEND/Capture.PNG");

        int newWidth = 600;
        int newHeight = 1000;
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        JLabel label = new JLabel(resizedIcon);

        panel.add(label, BorderLayout.WEST);

        // ADD BUTTONS
        JPanel btnzone = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Home Page");
        titleLabel.setFont(new Font("", Font.BOLD, 50));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        btnzone.add(titleLabel, BorderLayout.NORTH);

        // Add btnzone to the main panel
        panel.add(btnzone, BorderLayout.CENTER);
        btnzone.setBackground(new Color(173, 216, 230));
        frame.add(panel);

        frame.setVisible(true);

        // Controls
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.Y_AXIS));
        btnPanel.setBackground(new Color(173, 216, 230));
        btnPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

         btnADD = new JButton("Add Contact");
        btnADD.setFont(new Font("", Font.BOLD, 20));
        btnADD.setMaximumSize(new Dimension(500, 50));
        btnADD.setBorder(new EmptyBorder(10, 10, 10, 10));
        btnADD.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnADD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ADD.addContacts(); 
                System.out.println("Add Contact button clicked");
            }
        });
        btnPanel.add(btnADD);

        btnDEL = new JButton("Delete Contact");
        btnDEL.setFont(new Font("", Font.BOLD, 20));
        btnDEL.setMaximumSize(new Dimension(500, 50));
        btnDEL.setBorder(new EmptyBorder(10, 10, 10, 10));
        btnDEL.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDEL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Delete.deleteContacts(); 
                System.out.println("Delete Contact button clicked");
            }
        });
        btnPanel.add(btnDEL);

        btnSCH = new JButton("Search Contact");
        btnSCH.setFont(new Font("", Font.BOLD, 20));
        btnSCH.setMaximumSize(new Dimension(500, 50));
        btnSCH.setBorder(new EmptyBorder(10, 10, 10, 10));
        btnSCH.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSCH.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Search.searchContacts();
                System.out.println("Search Contact button clicked");
            }
        });
        btnPanel.add(btnSCH);

        btnLST = new JButton("List Contacts");
        btnLST.setFont(new Font("", Font.BOLD, 20));
        btnLST.setMaximumSize(new Dimension(500, 50));
        btnLST.setBorder(new EmptyBorder(10, 10, 10, 10));
        btnLST.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLST.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                List.listContacts();
                System.out.println("List Contacts button clicked");
            }
        });
        btnPanel.add(btnLST);

        btnUPD = new JButton("Update Contact");
        btnUPD.setFont(new Font("", Font.BOLD, 20));
        btnUPD.setMaximumSize(new Dimension(500, 50));
        btnUPD.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnUPD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Update.updateContacts();
                System.out.println("Update Contact button clicked");
            }
        });
        btnPanel.add(btnUPD);

       
        btnPanel.add(Box.createVerticalStrut(10));
        btnzone.add(btnPanel, BorderLayout.CENTER);
        
        JFrame frame1 = new JFrame("Padding Example");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(300, 200);
        
        btnExit = new JButton(" Exit ");
        btnExit.setFont(new Font("", Font.BOLD, 20));
        btnExit.setMaximumSize(new Dimension(500, 50));
        btnExit.setBorder(new EmptyBorder(10, 10, 10, 10));
        btnExit.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Action to exit the application
                System.exit(0);
            }
        });
        btnPanel.add(btnExit);
        
        
		frame.setVisible(true);
		// homepage();
    }

    public static String generateId() {
        if (contactList.getSize() == 0) {
            return "C0001";
        } else {
            String lastId = contactList.get(contactList.getSize() - 1).getId();
            int lastNo = Integer.parseInt(lastId.substring(1));
            return String.format("C%04d", lastNo + 1);
        }
    }

    public static void homepage() {
        Scanner input = new Scanner(System.in);
        System.out.println("=======================iFRIEND CONTACT ORGANIZER============================");
        System.out.println("\n[01] Add Contacts");
        System.out.println("\n[02] Update Contacts");
        System.out.println("\n[03] Delete Contacts");
        System.out.println("\n[04] Search Contacts");
        System.out.println("\n[05] List Contacts");
        System.out.println("\n[06] Exit");
        System.out.print("\nEnter option to continue: ");
        int option = input.nextInt();
        clearConsole();
        switch (option) {
            case 1:
                ADD.addContacts();
                break;
            case 2:
                Update.updateContacts();
                break;
            case 3:
                Delete.deleteContacts();
                break;
            case 4:
                //Search.searchContacts();
                break;
            case 5:
                //listContacts();
                break;
            case 6:
                exit();
                break;
            default:
                System.out.println("Invalid option...");
                break;
        }
    }

    

    public static void printDetails(int index) {
        Contact contact = contactList.get(index);
        System.out.println("Contact Id : " + contact.getId());
        System.out.println("Name : " + contact.getName());
        System.out.println("Phone Number : " + contact.getPhoneNumber());
        System.out.println("Company Name : " + contact.getCompanyName());
        System.out.println("Salary : " + contact.getSalary());
        System.out.println("Birthday : " + contact.getBirthday());
    }

    

   

    

    

    public static void exit() {
        clearConsole();
        System.out.println("\n\n==================THANK YOU FOR USING iFRIEND CONTACT ORGANIZER=====================");
        System.exit(0);
    }
}

class Contact {
    private String id;
    private String name;
    private String phoneNumber;
    private String companyName;
    private String birthday;
    private double salary;

    public Contact(String id, String name, String phoneNumber, String companyName, String birthday, double salary) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.companyName = companyName;
        this.birthday = birthday;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getBirthday() {
        return birthday;
    }

    public double getSalary() {
        return salary;
    }
}

class ContactList {
    private Node head;

    private static class Node {
        private Contact contact;
        private Node next;

        public Node(Contact contact) {
            this.contact = contact;
        }
    }

    public void add(Contact contact) {
        Node newNode = new Node(contact);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public int getSize() {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public Contact get(int index) {
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.contact;
            }
            count++;
            current = current.next;
        }
        return null;
    }

    public void update(int index, Contact contact) {
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                current.contact = contact;
                return;
            }
            count++;
            current = current.next;
        }
    }

    public void delete(int index) {
        if (head == null) return;
        if (index == 0) {
            head = head.next;
            return;
        }
        Node current = head;
        for (int i = 0; current != null && i < index - 1; i++) {
            current = current.next;
        }
        if (current == null || current.next == null) return;
        current.next = current.next.next;
    }

    public int searchByNameOrPhoneNumber(String nameOrPhoneNumber) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.contact.getName().equals(nameOrPhoneNumber) || current.contact.getPhoneNumber().equals(nameOrPhoneNumber)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }
}
