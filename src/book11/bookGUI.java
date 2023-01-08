package book11;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.print.Book;
import java.util.Collections;  
import java.util.ArrayList;
public class bookGUI extends JFrame implements ActionListener {
    private JLabel searchBooKJlabel, borrowBooKJlabel, updateBookJlabel, n4, newBooKJlabel, m, isbnlabel, titlelabel, Authorlabel, Editionlabel, PublishedYearlabel, Borrowedlabel;
    private JTextField t1, t2, t3, t4, t5, t6,t7,t8,t9;
    private JButton b1, b2, b3, b4, b5, b6,b7;
    private JPanel searchPanel, p1, textAreaPanel, borrowBookPanel, p4, southPannel, p6, findBookPannel, updatePanel, headerPanel, centerPanel;
    private JRadioButton r1, r2, r3, r4, r5, r6, r7, r8;
    private JTextArea textArea,findedBookTextArea;
    private JComboBox comboBox;
    private static final String [] s= {"Title","Author","Edition","Published Year"};
    private ButtonGroup rad;;
    
    private ArrayList<book> bookList = new ArrayList<book>();
    
    ButtonGroup radioButtongroup = new ButtonGroup();
    String isbn = String.format("%-20s", "ISBN");
    String title = String.format("%-30s", "Title");
    String author = String.format("%-24s", "Author");
    String edition = String.format("%-23s", "Edition");
    String year = String.format("%-23s", "Year");
    String isBorrowed = String.format("%-14s", "Available");
    String textAreaHeader = isbn +"\t"+title +"\t"  +  edition + author+year + isBorrowed +"\n";
    book tempBook = null;
    int index = -1;
    
    
        public bookGUI() {
        super("library System");
       
        bookList.add(new book("0134448237", "C++ How to Program", "Paul Deitel", 10, 2017, true));
        bookList.add(new book("0134743356", "Java How to Program", "Paul Deitel", 11, 2017, false));
        
        this.setLayout(new BorderLayout());
        this.setMinimumSize(new Dimension(850, 600));
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(850  ,600));
        
        isbnlabel = new JLabel("ISBN");
        titlelabel = new JLabel("Title");
        Authorlabel = new JLabel("Author");
        Editionlabel = new JLabel("Edition");
        PublishedYearlabel = new JLabel("Published Year");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        t4 = new JTextField(10);
        t5 = new JTextField(10);
        headerPanel = new JPanel(new BorderLayout());
        JPanel newBook = new JPanel(new FlowLayout(FlowLayout.LEFT));
        newBooKJlabel = new JLabel("NEW BOOK");
        newBooKJlabel.setForeground(Color.RED);
        newBooKJlabel.setFont(new Font("Serif", Font.BOLD, 15));
        newBook.add(newBooKJlabel);
        headerPanel.add(newBook, BorderLayout.NORTH);
        p1 = new JPanel(new GridLayout(2, 5));
        p1.add(isbnlabel);
        p1.add(titlelabel);
        p1.add(Authorlabel);
        p1.add(Editionlabel);
        p1.add(PublishedYearlabel);
        p1.add(t1);
        p1.add(t2);
        p1.add(t3);
        p1.add(t4);
        p1.add(t5);

        headerPanel.add(p1, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new BorderLayout());
        JPanel buttonLayout = new JPanel(new FlowLayout(FlowLayout.CENTER));
        b1 = new JButton("insert");
        b1.addActionListener(this);
        b2 = new JButton("clear");
        b2.addActionListener(this);
        buttonLayout.add(b1);
        buttonLayout.add(b2);
        bottom.add(buttonLayout, BorderLayout.CENTER);

        JSeparator p = new JSeparator();
        bottom.add(p, BorderLayout.SOUTH);
        headerPanel.add(bottom, BorderLayout.SOUTH);

        this.add(headerPanel, BorderLayout.NORTH);
        //Center (text Area)

        centerPanel = new JPanel(new BorderLayout());
        searchPanel = new JPanel(new BorderLayout());
        JPanel searchBook = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchBooKJlabel = new JLabel("SEARCH BY");
        searchBooKJlabel.setForeground(Color.RED);
        searchBooKJlabel.setFont(new Font("Serif", Font.BOLD, 15));
        searchBook.add(searchBooKJlabel);
        searchPanel.add(searchBook, BorderLayout.NORTH);

        p4 = new JPanel(new GridLayout(1, 4));
        r1 = new JRadioButton("ISBN",false);
        r1.addActionListener(this);
        p4.add(r1);
        r2 = new JRadioButton("Title",false);
        r2.addActionListener(this);
        p4.add(r2);
        r3 = new JRadioButton("Author",false);
        r3.addActionListener(this);
        p4.add(r3);
        r4 = new JRadioButton("Published Year",false);
        r4.addActionListener(this);
        p4.add(r4);
        rad=new ButtonGroup();
        rad.add(r1);
        rad.add(r2);
        rad.add(r3);
        rad.add(r4);


        searchPanel.add(p4, BorderLayout.CENTER);


        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));


        b3 = new JButton("Find");
        b3.addActionListener(this);
        t8 = new JTextField(20);
        p6 = new JPanel();
        p6.add(b3);
        p6.add(t8);
        southPanel.add(p6);
        searchPanel.add(southPanel, BorderLayout.SOUTH);

        centerPanel.add(searchPanel, BorderLayout.NORTH);
        textAreaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        textAreaPanel.setSize(new Dimension(850,160));
        textArea = new JTextArea(11, 80);
        textArea.append(textAreaHeader);
        textAreaPanel.add(textArea);

        JPanel areaPannel = new JPanel(new BorderLayout());
        areaPannel.add(textAreaPanel,BorderLayout.CENTER);
        areaPannel.add(new JSeparator(),BorderLayout.SOUTH);
        centerPanel.add(areaPannel, BorderLayout.CENTER);


        southPannel = new JPanel(new BorderLayout());

        borrowBookPanel = new JPanel(new BorderLayout());
        JPanel borrowBook = new JPanel(new FlowLayout(FlowLayout.LEFT));
        borrowBooKJlabel = new JLabel("BORROW BOOK");
        borrowBooKJlabel.setForeground(Color.RED);
        borrowBooKJlabel.setFont(new Font("Serif", Font.BOLD, 15));
        borrowBook.add(borrowBooKJlabel);
        borrowBookPanel.add(borrowBook, BorderLayout.NORTH);


        centerPanel.add(borrowBookPanel, BorderLayout.SOUTH);
        findBookPannel = new JPanel(new BorderLayout());
        JPanel findButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel findLabel = new JLabel("ISBN");
        findButtonPanel.add(findLabel);
        b4 = new JButton("Find");
        b4.addActionListener(this);

        t9 = new JTextField(20);
        findButtonPanel.add(t9);
        findButtonPanel.add(b4);
        findBookPannel.add(findButtonPanel,BorderLayout.NORTH);
        findedBookTextArea = new JTextArea(1, 50);
        findBookPannel.add(findedBookTextArea,BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        b5 = new JButton("Borrow");
        b5.addActionListener(this);
        b6 = new JButton("Return");
        b6.addActionListener(this);
        buttonsPanel.add(b5);
        buttonsPanel.add(b6);
        findBookPannel.add(buttonsPanel,BorderLayout.SOUTH);
        borrowBookPanel.add(findBookPannel,BorderLayout.CENTER);

        borrowBookPanel.add(new JSeparator(),BorderLayout.SOUTH);

        this.add(centerPanel, BorderLayout.CENTER);

        //Update Panel
        updatePanel = new JPanel(new BorderLayout());
        JPanel updateBook = new JPanel(new FlowLayout(FlowLayout.LEFT));
        updateBookJlabel = new JLabel("UPDATE BOOK");
        updateBookJlabel.setForeground(Color.RED);
        updateBookJlabel.setFont(new Font("Serif", Font.BOLD, 15));
        updatePanel.add(updateBookJlabel,BorderLayout.NORTH);

        JPanel updateCompnent = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel findLabel2 = new JLabel("ISBN");
        updateCompnent.add(findLabel2);


        t6 = new JTextField(20);
        updateCompnent.add(t6);
        
        comboBox = new JComboBox(s);
        comboBox.setMaximumRowCount(4);
        updateCompnent.add(comboBox);
        JLabel findLabel3 = new JLabel("New Value:");
        updateCompnent.add(findLabel3);
        t7 = new JTextField(20);
        updateCompnent.add(t7);
        b7 = new JButton("UPDATE");
        b7.addActionListener(this);
        updateCompnent.add(b7);

        updatePanel.add(updateCompnent,BorderLayout.CENTER);
        this.add(updatePanel, BorderLayout.SOUTH);
      


      }

        @Override
       public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    	if (e.getSource() == b1) {
            int edition = 0;
            int year = 0;
            boolean isValid = true;
  
            
            try {
                int isbnNumber = Integer.parseInt(t1.getText().trim());
                if (t1.getText().trim().length()!= 10){
                	JOptionPane.showMessageDialog(new JFrame(), "Isbn not valid", "Error",
                            JOptionPane.ERROR_MESSAGE);
                	isValid = false;
                	
                }
          
                
            }catch (Exception es){
                JOptionPane.showMessageDialog(new JFrame(), "Isbn  must be 10 digit", "Error",
                        JOptionPane.ERROR_MESSAGE);
                isValid = false;
                
            }
            
            int isbnNumbe = Integer.parseInt(t1.getText().trim());
            if ( t1.getText().trim().length() == 10){
                for (int i = 0; i < bookList.size(); i++) {
                    if (bookList.get(i).isISBNEqual(t1.getText().trim())) {
                    	
                    	JOptionPane.showMessageDialog(new JFrame(), "Sorry there is anthor book with this isbn", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        isValid = false;
                        break;
                    }
                }
                }
          
                edition = Integer.parseInt(t4.getText().trim());
                if (edition==0){
                	 JOptionPane.showMessageDialog(new JFrame(), "edition number not valid", "Error",
                             JOptionPane.ERROR_MESSAGE);
                     isValid = false;
                }
            
            
            
           
                year = Integer.parseInt(t5.getText().trim());
                if (year >2021 || year <0) {
                	 JOptionPane.showMessageDialog(new JFrame(), "Published Year  not valid", "Error",
                             JOptionPane.ERROR_MESSAGE);
                     isValid = false;
                }
                	
           
            //create new book
            if (isValid) {
                book newBook = new book(t1.getText().trim(), t2.getText().trim(), t3.getText().trim(), edition, year, false);
                bookList.add(newBook);
                JOptionPane.showMessageDialog(new JFrame(), "book " + newBook.gettitle() + " Inserted Successfully", "Ok",
                        JOptionPane.INFORMATION_MESSAGE);
                System.out.println(newBook);
            }


        }

        if (e.getSource() == b2) {
            //clear TextFields
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
        }

        if (e.getSource() == b3) {
            String findedBook = "";

            if (r1.isSelected()) {
            	
              
            	  for (int i = 0; i < bookList.size(); i++) {
                 if (bookList.get(i).isISBNEqual(t8.getText().trim()) ) {
                    	 findedBook += bookList.get(i) + "\n"; break;
                    	
                } 
            }
            	  }
            
            else if (r2.isSelected()) {
                for (int i = 0; i < bookList.size(); i++) {
                    if (bookList.get(i).isTitleEqual(t8.getText().trim())) {
                        findedBook += bookList.get(i) + "\n";
                    }
                }
            } else if (r3.isSelected()) {
                for (int i = 0; i < bookList.size(); i++) {
                    if (bookList.get(i).isAuthorEqual(t8.getText().trim())) {
                        findedBook += bookList.get(i) + "\n";
                    }
                }
            } else if (r4.isSelected()) {
                for (int i = 0; i < bookList.size(); i++) {
                    if (bookList.get(i).isYearEqual(Integer.parseInt(t8.getText().trim()))) {
                        findedBook += bookList.get(i) + "\n";
                    }
                }
            }


            textArea.setText(textAreaHeader + findedBook);
        }
     

        if (e.getSource() == b4) {


            for (int i = 0; i < bookList.size(); i++) {
                if (bookList.get(i).isISBNEqual(t9.getText().trim())) {
                    tempBook = bookList.get(i);
                    index = i;
                    break;
                }
                findedBookTextArea.setText(textAreaHeader + tempBook);
            }
            //book exists
            if (tempBook != null) {
            	findedBookTextArea.setText(String.valueOf(tempBook));
                if (tempBook.isBorrowed) {
                    b5.setEnabled(false);
                   b6.setEnabled(true);

                } else {

                    b5.setEnabled(true);
                   b6.setEnabled(false);


                }

            }
            //book dose not exists
            else {
                JOptionPane.showMessageDialog(new JFrame(), "Book is not exists", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

      if (e.getSource() == b5) {
            if (index > -1) {
                System.out.println("borrow");
                bookList.get(index).isBorrowed = true;
                findedBookTextArea.setText(String.valueOf(bookList.get(index)));
               JOptionPane.showMessageDialog(new JFrame(), "Book " + bookList.get(index).gettitle() + " Borrowed Successfully", "Ok",
                        JOptionPane.INFORMATION_MESSAGE);
                b5.setEnabled(false);
               b6.setEnabled(true);
            }

        }//
      
        if (e.getSource() == b6) {
            System.out.printf("Return");
           if (index > -1) {
                bookList.get(index).isBorrowed = false;
                findedBookTextArea.setText(String.valueOf(bookList.get(index)));
               JOptionPane.showMessageDialog(new JFrame(), "Book " + bookList.get(index).gettitle() + " Returned Successfully", "Ok",
                        JOptionPane.INFORMATION_MESSAGE);
               b5.setEnabled(true);
               b6.setEnabled(false);
            }
       }
    
        if (e.getSource() == b7) {
        	
           tempBook = null;
            index = -1;
            for (int i = 0; i < bookList.size(); i++) {
                if (bookList.get(i).isISBNEqual(t6.getText().trim())) {
                    tempBook = bookList.get(i);
                   index = i;
                    break;
               }
            }
            if (tempBook != null) {
                boolean edited =false;
                switch (comboBox.getSelectedIndex()) {
                    case 0:
                        bookList.get(index).settitle(t7.getText().trim()); 
                        edited =true;
                    
                       break;
                   case 1:
                        bookList.get(index).setauthor(t7.getText().trim());
                        edited =true;
                        break;
                    case 2:
                        bookList.get(index).setedition(Integer.parseInt(t7.getText().trim()));
                        edited =true;
                        break;
                    case 3:
                    	 int year = 0;
                    	 year = Integer.parseInt(t7.getText().trim());
                    	  if (year >2021 || year <0) {
                       	 JOptionPane.showMessageDialog(new JFrame(), "Published Year  not valid", "Error",JOptionPane.ERROR_MESSAGE);}
                       	 else {
                       bookList.get(index).setpublishedYear( Integer.parseInt(t7.getText().trim())); 
                       edited =true;}
                    	
                    	 break;
                       
                    default:
                        JOptionPane.showMessageDialog(new JFrame(), "Unknown Error", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        break;

                }
                if (edited==true){
                    JOptionPane.showMessageDialog(null, "Book " + bookList.get(index).getisbn() + " Edited Successfully", "Ok",
                           JOptionPane.INFORMATION_MESSAGE);
                }
                
            }
        }//
  }

}
