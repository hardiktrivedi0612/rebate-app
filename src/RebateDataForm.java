
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Hardik
 */

/*
 *   This is the Class where the User Interface of the Application is defined
 */
public class RebateDataForm extends javax.swing.JFrame {

    private boolean isFirstNameErrorVisible;
    private boolean isLastNameErrorVisible;
    private boolean isMiddleNameErrorVisible;
    private boolean isAddressLine1ErrorVisible;
    private boolean isAddressLine2ErrorVisible;
    private boolean isCityErrorVisible;
    private boolean isStateErrorVisible;
    private boolean isZipCodeErrorVisible;
    private boolean isPhoneNumberErrorVisible;
    private boolean isEmailAddressErrorVisible;

    /**
     * Creates new form RebateDataForm
     */
    public RebateDataForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        customerListJPanel = new javax.swing.JPanel();
        customerListJScrollPane = new javax.swing.JScrollPane();
        customerDetailsJTable = new javax.swing.JTable();
        newCustomerDetailsJPanel = new javax.swing.JPanel();
        compulsoryNoteJLabel = new javax.swing.JLabel();
        personalInfoJPanel = new javax.swing.JPanel();
        firstNameJlabel = new javax.swing.JLabel();
        firstNameJText = new javax.swing.JTextField();
        firstNameErrorJLabel = new javax.swing.JLabel();
        lastNameJLabel = new javax.swing.JLabel();
        lastNameJText = new javax.swing.JTextField();
        lastNameErrorJLabel = new javax.swing.JLabel();
        middleNameJLabel = new javax.swing.JLabel();
        middleNameJText = new javax.swing.JTextField();
        middleNameErrorJLabel = new javax.swing.JLabel();
        addressInfoJPanel = new javax.swing.JPanel();
        addressLine1JLabel = new javax.swing.JLabel();
        addressLine1JText = new javax.swing.JTextField();
        addressLine1ErrorJLabel = new javax.swing.JLabel();
        addressLine2JLabel = new javax.swing.JLabel();
        addressLine2JText = new javax.swing.JTextField();
        addressLine2ErrorJLabel = new javax.swing.JLabel();
        cityJLabel = new javax.swing.JLabel();
        cityJText = new javax.swing.JTextField();
        cityErrorJLabel = new javax.swing.JLabel();
        stateJLabel = new javax.swing.JLabel();
        stateJText = new javax.swing.JTextField();
        stateErrorJLabel = new javax.swing.JLabel();
        zipCodeJLabel = new javax.swing.JLabel();
        zipCodeJText = new javax.swing.JTextField();
        zipCodeErrorJLabel = new javax.swing.JLabel();
        contactInfoJPanel = new javax.swing.JPanel();
        phoneNumberJLabel = new javax.swing.JLabel();
        phoneNumberJText = new javax.swing.JTextField();
        phoneNumberErrorJLabel = new javax.swing.JLabel();
        emailAddressJLabel = new javax.swing.JLabel();
        emailAddressJText = new javax.swing.JTextField();
        emailAddressErrorJLabel = new javax.swing.JLabel();
        proofOfPurchaseJCheckbox = new javax.swing.JCheckBox();
        dateJLabel = new javax.swing.JLabel();
        monthJComboBox = new javax.swing.JComboBox();
        days30JComboBox = new javax.swing.JComboBox();
        days31JComboBox = new javax.swing.JComboBox();
        days28JComboBox = new javax.swing.JComboBox();
        days29JComboBox = new javax.swing.JComboBox();
        yearJComboBox = new javax.swing.JComboBox();
        dateTextJLabel = new javax.swing.JLabel();
        dateTextErrorJLabel = new javax.swing.JLabel();
        saveAndNewJButton = new javax.swing.JButton();
        saveAndExitJButton = new javax.swing.JButton();
        clearJButton = new javax.swing.JButton();
        deleteRecordJText = new javax.swing.JButton();
        statusJLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rebate Data - Form FIll Application");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        customerListJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "List of Customers", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        customerListJPanel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        customerListJPanel.setName("List of Customers"); // NOI18N

        customerDetailsJTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        customerDetailsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Name", "Phone Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customerDetailsJTable.setFocusable(false);
        customerDetailsJTable.setName("Customer List"); // NOI18N
        customerDetailsJTable.setRowHeight(25);
        customerListJScrollPane.setViewportView(customerDetailsJTable);
        customerDetailsJTable.setAutoCreateRowSorter(true);
        customerDetailsJTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                if(customerDetailsJTable.getSelectedRow()==-1)
                return;

                String name = (String) customerDetailsJTable.getValueAt(customerDetailsJTable.getSelectedRow(), 0);
                String phoneNumber = (String) customerDetailsJTable.getValueAt(customerDetailsJTable.getSelectedRow(), 1);
                String[] mainName = name.split(", ");
                String lastName = mainName[0];
                String[] names = mainName[1].split(" ");
                String firstName = names[0];
                String middleName;
                if(names.length==1)
                middleName = "";
                else
                middleName = names[1];

                for (int i = 0; i < CustomerDataHandler.list.size(); i++) {
                    CustomerDetailsBean bean = CustomerDataHandler.list.get(i);
                    if (bean.getFirstName().equalsIgnoreCase(firstName) && bean.getMiddleName().equalsIgnoreCase(middleName) && bean.getLastName().equalsIgnoreCase(lastName) && bean.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                        firstNameJText.setText(bean.getFirstName());
                        lastNameJText.setText(bean.getLastName());
                        middleNameJText.setText(bean.getMiddleName());
                        addressLine1JText.setText(bean.getAddressLine1());
                        addressLine2JText.setText(bean.getAddressLine2());
                        cityJText.setText(bean.getCity());
                        stateJText.setText(bean.getState());
                        zipCodeJText.setText(bean.getZipCode());
                        phoneNumberJText.setText(bean.getPhoneNumber());
                        emailAddressJText.setText(bean.getEmailAddress());
                        proofOfPurchaseJCheckbox.setSelected(Boolean.parseBoolean(bean.getProofAttached()));
                        parseAndSetDate(bean.getDate());
                        return ;
                    }
                }
            }
        });

        javax.swing.GroupLayout customerListJPanelLayout = new javax.swing.GroupLayout(customerListJPanel);
        customerListJPanel.setLayout(customerListJPanelLayout);
        customerListJPanelLayout.setHorizontalGroup(
            customerListJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerListJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customerListJScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addContainerGap())
        );
        customerListJPanelLayout.setVerticalGroup(
            customerListJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerListJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customerListJScrollPane)
                .addContainerGap())
        );

        newCustomerDetailsJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "New Customer Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        compulsoryNoteJLabel.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        compulsoryNoteJLabel.setText("Fields marked * are compulsory ");

        personalInfoJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Personal Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 15))); // NOI18N

        firstNameJlabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        firstNameJlabel.setText("*First Name:");
        firstNameJlabel.setFocusable(false);

        firstNameJText.setDocument(new JTextFieldLimit(Constants.FIRST_NAME_MAX_LENGTH));
        firstNameJText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(firstNameJText.getText().toString().length()>Constants.FIRST_NAME_MAX_LENGTH){
                    firstNameErrorJLabel.setText(Constants.FIRST_NAME_MAX_LENGTH_TEXT);
                    isFirstNameErrorVisible=true;
                }
                else{
                    firstNameErrorJLabel.setText("");
                    isFirstNameErrorVisible=false;
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(firstNameJText.getText().toString().length()>Constants.FIRST_NAME_MAX_LENGTH){
                    firstNameErrorJLabel.setText(Constants.FIRST_NAME_MAX_LENGTH_TEXT);
                    isFirstNameErrorVisible=true;
                }
                else{
                    firstNameErrorJLabel.setText("");
                    isFirstNameErrorVisible=false;
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        firstNameJText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        firstNameJText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                firstNameJTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                firstNameJTextFocusLost(evt);
            }
        });
        firstNameJText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                firstNameJTextKeyPressed(evt);
            }
        });

        firstNameErrorJLabel.setForeground(new java.awt.Color(255, 51, 51));

        lastNameJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lastNameJLabel.setText("*Last Name:");

        lastNameJText.setDocument(new JTextFieldLimit(Constants.LAST_NAME_MAX_LENGTH));
        lastNameJText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(lastNameJText.getText().toString().length()>Constants.LAST_NAME_MAX_LENGTH){
                    lastNameErrorJLabel.setText(Constants.LAST_NAME_MAX_LENGTH_TEXT);
                    isLastNameErrorVisible=true;
                }
                else{
                    lastNameErrorJLabel.setText("");
                    isLastNameErrorVisible=false;
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                if(lastNameJText.getText().toString().length()>Constants.LAST_NAME_MAX_LENGTH){
                    lastNameErrorJLabel.setText(Constants.LAST_NAME_MAX_LENGTH_TEXT);
                    isLastNameErrorVisible=true;
                }
                else{
                    lastNameErrorJLabel.setText("");
                    isLastNameErrorVisible=false;
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        lastNameJText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lastNameJText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lastNameJTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lastNameJTextFocusLost(evt);
            }
        });
        lastNameJText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lastNameJTextKeyPressed(evt);
            }
        });

        lastNameErrorJLabel.setForeground(new java.awt.Color(255, 51, 51));

        middleNameJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        middleNameJLabel.setText("Middle Name:");

        middleNameJText.setDocument(new JTextFieldLimit(Constants.MIDDLE_NAME_MAX_LENGTH));
        middleNameJText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(middleNameJText.getText().toString().length()>Constants.MIDDLE_NAME_MAX_LENGTH){
                    middleNameErrorJLabel.setText(Constants.MIDDLE_NAME_MAX_LENGTH_TEXT);
                    isMiddleNameErrorVisible=true;
                }
                else{
                    middleNameErrorJLabel.setText("");
                    isMiddleNameErrorVisible=false;
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                if(middleNameJText.getText().toString().length()>Constants.MIDDLE_NAME_MAX_LENGTH){
                    middleNameErrorJLabel.setText(Constants.MIDDLE_NAME_MAX_LENGTH_TEXT);
                    isMiddleNameErrorVisible=true;
                }
                else{
                    middleNameErrorJLabel.setText("");
                    isMiddleNameErrorVisible=false;
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        middleNameJText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        middleNameJText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                middleNameJTextFocusLost(evt);
            }
        });
        middleNameJText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                middleNameJTextKeyPressed(evt);
            }
        });

        middleNameErrorJLabel.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout personalInfoJPanelLayout = new javax.swing.GroupLayout(personalInfoJPanel);
        personalInfoJPanel.setLayout(personalInfoJPanelLayout);
        personalInfoJPanelLayout.setHorizontalGroup(
            personalInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalInfoJPanelLayout.createSequentialGroup()
                .addGroup(personalInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(personalInfoJPanelLayout.createSequentialGroup()
                        .addComponent(middleNameJLabel)
                        .addGap(18, 18, 18)
                        .addComponent(middleNameJText, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(personalInfoJPanelLayout.createSequentialGroup()
                        .addGroup(personalInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(personalInfoJPanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(firstNameJlabel))
                            .addComponent(lastNameJLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(personalInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lastNameJText)
                            .addComponent(firstNameJText, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))))
                .addGroup(personalInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(personalInfoJPanelLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(firstNameErrorJLabel))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, personalInfoJPanelLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(lastNameErrorJLabel)))
                    .addGroup(personalInfoJPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(middleNameErrorJLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        personalInfoJPanelLayout.setVerticalGroup(
            personalInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalInfoJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(personalInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(personalInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(firstNameJlabel)
                        .addComponent(firstNameJText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(firstNameErrorJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(personalInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(personalInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lastNameJLabel)
                        .addComponent(lastNameJText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lastNameErrorJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(personalInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(middleNameJLabel)
                    .addComponent(middleNameJText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(middleNameErrorJLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        addressInfoJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Address Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 15))); // NOI18N

        addressLine1JLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addressLine1JLabel.setText("*Address Line 1:");
        addressLine1JLabel.setRequestFocusEnabled(false);

        addressLine1JText.setDocument(new JTextFieldLimit(Constants.ADDRESS_LINE_MAX_LENGTH));
        addressLine1JText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(addressLine1JText.getText().toString().length()>Constants.ADDRESS_LINE_MAX_LENGTH){
                    addressLine1ErrorJLabel.setText(Constants.ADDRESS_LINE_MAX_LENGTH_TEXT);
                    isAddressLine1ErrorVisible=true;
                }
                else{
                    addressLine1ErrorJLabel.setText("");
                    isAddressLine1ErrorVisible=false;
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(addressLine1JText.getText().toString().length()>Constants.ADDRESS_LINE_MAX_LENGTH){
                    addressLine1ErrorJLabel.setText(Constants.ADDRESS_LINE_MAX_LENGTH_TEXT);
                    isAddressLine1ErrorVisible=true;
                }
                else{
                    addressLine1ErrorJLabel.setText("");
                    isAddressLine1ErrorVisible=false;
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        addressLine1JText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addressLine1JText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                addressLine1JTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                addressLine1JTextFocusLost(evt);
            }
        });
        addressLine1JText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addressLine1JTextKeyPressed(evt);
            }
        });

        addressLine1ErrorJLabel.setForeground(new java.awt.Color(255, 51, 51));

        addressLine2JLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addressLine2JLabel.setText("Address Line 2:");

        addressLine2JText.setDocument(new JTextFieldLimit(Constants.ADDRESS_LINE_MAX_LENGTH));
        addressLine2JText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(addressLine2JText.getText().toString().length()>Constants.ADDRESS_LINE_MAX_LENGTH){
                    addressLine2ErrorJLabel.setText(Constants.ADDRESS_LINE_MAX_LENGTH_TEXT);
                    isAddressLine2ErrorVisible=true;
                }
                else{
                    addressLine2ErrorJLabel.setText("");
                    isAddressLine2ErrorVisible=false;
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(addressLine2JText.getText().toString().length()>Constants.ADDRESS_LINE_MAX_LENGTH){
                    addressLine2ErrorJLabel.setText(Constants.ADDRESS_LINE_MAX_LENGTH_TEXT);
                    isAddressLine2ErrorVisible=true;
                }
                else{
                    addressLine2ErrorJLabel.setText("");
                    isAddressLine2ErrorVisible=false;
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        addressLine2JText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addressLine2JText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                addressLine2JTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                addressLine2JTextFocusLost(evt);
            }
        });
        addressLine2JText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addressLine2JTextKeyPressed(evt);
            }
        });

        addressLine2ErrorJLabel.setForeground(new java.awt.Color(255, 51, 51));

        cityJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cityJLabel.setText("*City:");

        cityJText.setDocument(new JTextFieldLimit(Constants.CITY_MAX_LENGTH));
        cityJText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(cityJText.getText().toString().length()>Constants.CITY_MAX_LENGTH){
                    cityErrorJLabel.setText(Constants.CITY_MAX_LENGTH_TEXT);
                    isCityErrorVisible=true;
                }
                else{
                    cityErrorJLabel.setText("");
                    isCityErrorVisible=false;
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(cityJText.getText().toString().length()>Constants.CITY_MAX_LENGTH){
                    cityErrorJLabel.setText(Constants.CITY_MAX_LENGTH_TEXT);
                    isCityErrorVisible=true;
                }
                else{
                    cityErrorJLabel.setText("");
                    isCityErrorVisible=false;
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        cityJText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cityJText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cityJTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cityJTextFocusLost(evt);
            }
        });
        cityJText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cityJTextKeyPressed(evt);
            }
        });

        cityErrorJLabel.setForeground(new java.awt.Color(255, 51, 51));

        stateJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stateJLabel.setText("*State:");

        stateJText.setDocument(new JTextFieldLimit(Constants.STATE_MAX_LENGTH));
        stateJText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(stateJText.getText().toString().length()>Constants.STATE_MAX_LENGTH){
                    stateErrorJLabel.setText(Constants.STATE_MAX_LENGTH_TEXT);
                    isStateErrorVisible=true;
                }
                else{
                    stateErrorJLabel.setText("");
                    isStateErrorVisible=false;
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(stateJText.getText().toString().length()>Constants.STATE_MAX_LENGTH){
                    stateErrorJLabel.setText(Constants.STATE_MAX_LENGTH_TEXT);
                    isStateErrorVisible=true;
                }
                else{
                    stateErrorJLabel.setText("");
                    isStateErrorVisible=false;
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        stateJText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stateJText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                stateJTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                stateJTextFocusLost(evt);
            }
        });
        stateJText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                stateJTextKeyPressed(evt);
            }
        });

        stateErrorJLabel.setForeground(new java.awt.Color(255, 51, 51));

        zipCodeJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        zipCodeJLabel.setText("*Zip code:");

        ((PlainDocument)zipCodeJText.getDocument()).setDocumentFilter(new MyZipCodeFilter(zipCodeErrorJLabel));
        zipCodeJText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        zipCodeJText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                zipCodeJTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                zipCodeJTextFocusLost(evt);
            }
        });
        zipCodeJText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                zipCodeJTextKeyPressed(evt);
            }
        });

        zipCodeErrorJLabel.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout addressInfoJPanelLayout = new javax.swing.GroupLayout(addressInfoJPanel);
        addressInfoJPanel.setLayout(addressInfoJPanelLayout);
        addressInfoJPanelLayout.setHorizontalGroup(
            addressInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addressInfoJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addressInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addressInfoJPanelLayout.createSequentialGroup()
                        .addGroup(addressInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addressLine2JLabel)
                            .addComponent(cityJLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(stateJLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(addressInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stateErrorJLabel)
                            .addGroup(addressInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(addressLine2ErrorJLabel)
                                .addGroup(addressInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addressInfoJPanelLayout.createSequentialGroup()
                                        .addGap(239, 239, 239)
                                        .addComponent(cityErrorJLabel))
                                    .addComponent(addressLine2JText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(addressInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(zipCodeErrorJLabel)
                                .addGroup(addressInfoJPanelLayout.createSequentialGroup()
                                    .addComponent(stateJText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(150, 150, 150)
                                    .addComponent(zipCodeJLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(zipCodeJText, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cityJText, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(addressInfoJPanelLayout.createSequentialGroup()
                        .addGroup(addressInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addressLine1ErrorJLabel)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addressInfoJPanelLayout.createSequentialGroup()
                                .addComponent(addressLine1JLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addressLine1JText, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        addressInfoJPanelLayout.setVerticalGroup(
            addressInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addressInfoJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addressInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLine1JLabel)
                    .addComponent(addressLine1JText))
                .addGap(3, 3, 3)
                .addComponent(addressLine1ErrorJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(addressInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLine2JText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressLine2JLabel))
                .addGap(3, 3, 3)
                .addComponent(addressLine2ErrorJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(addressInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityJLabel)
                    .addComponent(cityErrorJLabel)
                    .addComponent(cityJText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addressInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stateJLabel)
                    .addComponent(stateJText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zipCodeJLabel)
                    .addComponent(zipCodeJText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addressInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stateErrorJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zipCodeErrorJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        contactInfoJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Contact Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 15))); // NOI18N

        phoneNumberJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        phoneNumberJLabel.setText("*Phone Number:");

        ((PlainDocument)phoneNumberJText.getDocument()).setDocumentFilter(new MyPhoneNumberFilter(phoneNumberErrorJLabel));
        phoneNumberJText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        phoneNumberJText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                phoneNumberJTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                phoneNumberJTextFocusLost(evt);
            }
        });
        phoneNumberJText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phoneNumberJTextKeyPressed(evt);
            }
        });

        phoneNumberErrorJLabel.setForeground(new java.awt.Color(255, 51, 51));

        emailAddressJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emailAddressJLabel.setText("*Email Address:");

        emailAddressJText.setDocument(new JTextFieldLimit(Constants.EMAIL_ADDRESS_MAX_LENGTH));
        emailAddressJText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(emailAddressJText.getText().toString().length()>Constants.EMAIL_ADDRESS_MAX_LENGTH){
                    emailAddressJLabel.setText(Constants.EMAIL_ADDRESS_MAX_LENGTH_TEXT);
                    isEmailAddressErrorVisible=true;
                }
                else{
                    emailAddressErrorJLabel.setText("");
                    isEmailAddressErrorVisible=false;
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(emailAddressJText.getText().toString().length()>Constants.EMAIL_ADDRESS_MAX_LENGTH){
                    emailAddressJLabel.setText(Constants.EMAIL_ADDRESS_MAX_LENGTH_TEXT);
                    isEmailAddressErrorVisible=true;
                }
                else{
                    emailAddressErrorJLabel.setText("");
                    isEmailAddressErrorVisible=false;
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        emailAddressJText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emailAddressJText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailAddressJTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailAddressJTextFocusLost(evt);
            }
        });

        emailAddressErrorJLabel.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout contactInfoJPanelLayout = new javax.swing.GroupLayout(contactInfoJPanel);
        contactInfoJPanel.setLayout(contactInfoJPanelLayout);
        contactInfoJPanelLayout.setHorizontalGroup(
            contactInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactInfoJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contactInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(emailAddressErrorJLabel)
                    .addGroup(contactInfoJPanelLayout.createSequentialGroup()
                        .addGroup(contactInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(emailAddressJLabel)
                            .addComponent(phoneNumberJLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contactInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contactInfoJPanelLayout.createSequentialGroup()
                                .addComponent(phoneNumberJText, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(phoneNumberErrorJLabel))
                            .addComponent(emailAddressJText, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contactInfoJPanelLayout.setVerticalGroup(
            contactInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactInfoJPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(contactInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumberJLabel)
                    .addComponent(phoneNumberJText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneNumberErrorJLabel))
                .addGap(18, 18, 18)
                .addGroup(contactInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailAddressJLabel)
                    .addComponent(emailAddressJText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailAddressErrorJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        proofOfPurchaseJCheckbox.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        proofOfPurchaseJCheckbox.setSelected(true);
        proofOfPurchaseJCheckbox.setText("Proof of purchase attached");

        dateJLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        dateJLabel.setText("Date:");

        monthJComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        monthJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        monthJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthJComboBoxActionPerformed(evt);
            }
        });

        days30JComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        days30JComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
        days30JComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                days30JComboBoxActionPerformed(evt);
            }
        });

        days31JComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        days31JComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        days31JComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                days31JComboBoxActionPerformed(evt);
            }
        });

        days28JComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        days28JComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28" }));
        days28JComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                days28JComboBoxActionPerformed(evt);
            }
        });

        days29JComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        days29JComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29" }));
        days29JComboBox.setName(""); // NOI18N
        days29JComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                days29JComboBoxActionPerformed(evt);
            }
        });

        yearJComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        yearJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));
        yearJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearJComboBoxActionPerformed(evt);
            }
        });

        dateTextJLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        dateTextErrorJLabel.setForeground(new java.awt.Color(255, 51, 51));

        saveAndNewJButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveAndNewJButton.setText("Save & New");
        saveAndNewJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveAndNewJButtonMouseClicked(evt);
            }
        });

        saveAndExitJButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveAndExitJButton.setText("Save & Exit");
        saveAndExitJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveAndExitJButtonMouseClicked(evt);
            }
        });

        clearJButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        clearJButton.setText("Clear");
        clearJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearJButtonMouseClicked(evt);
            }
        });

        deleteRecordJText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteRecordJText.setText("Delete Record");
        deleteRecordJText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteRecordJTextMouseClicked(evt);
            }
        });

        statusJLabel.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout newCustomerDetailsJPanelLayout = new javax.swing.GroupLayout(newCustomerDetailsJPanel);
        newCustomerDetailsJPanel.setLayout(newCustomerDetailsJPanelLayout);
        newCustomerDetailsJPanelLayout.setHorizontalGroup(
            newCustomerDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newCustomerDetailsJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(newCustomerDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(compulsoryNoteJLabel)
                    .addGroup(newCustomerDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(contactInfoJPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addressInfoJPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(personalInfoJPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, newCustomerDetailsJPanelLayout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addComponent(dateJLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(monthJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(days30JComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(days31JComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(days28JComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(days29JComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(yearJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(newCustomerDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(dateTextErrorJLabel)
                                .addComponent(dateTextJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, newCustomerDetailsJPanelLayout.createSequentialGroup()
                            .addGap(248, 248, 248)
                            .addComponent(proofOfPurchaseJCheckbox))
                        .addGroup(newCustomerDetailsJPanelLayout.createSequentialGroup()
                            .addComponent(saveAndNewJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(50, 50, 50)
                            .addComponent(saveAndExitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(50, 50, 50)
                            .addComponent(clearJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(50, 50, 50)
                            .addComponent(deleteRecordJText)
                            .addGap(28, 28, 28))))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(newCustomerDetailsJPanelLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(statusJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        newCustomerDetailsJPanelLayout.setVerticalGroup(
            newCustomerDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newCustomerDetailsJPanelLayout.createSequentialGroup()
                .addComponent(compulsoryNoteJLabel)
                .addGap(14, 14, 14)
                .addComponent(personalInfoJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addressInfoJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(contactInfoJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(proofOfPurchaseJCheckbox)
                .addGap(18, 18, 18)
                .addGroup(newCustomerDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateTextJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(newCustomerDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dateJLabel)
                        .addComponent(monthJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(days30JComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(days31JComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(yearJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(days28JComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(days29JComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateTextErrorJLabel)
                .addGap(8, 8, 8)
                .addComponent(statusJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newCustomerDetailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveAndNewJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveAndExitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteRecordJText, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        setUpDate();
        CustomerDataHandler.initializeData(customerDetailsJTable);
        Runtime.getRuntime().addShutdownHook(new Thread()
            {
                @Override
                public void run()
                {
                    CustomerDataHandler.wrapUp();
                }
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerListJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(newCustomerDetailsJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(newCustomerDetailsJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(customerListJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents


    /*
     This method is defined to handle the events performed on the Year Combo Box.
     Depending upon the year selected, the number of days combo box has to be changed.
     If the selected year is a leap year, the the number of days has to be changed accordingly if the month selected is february.
     */
    private void yearJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearJComboBoxActionPerformed
        statusJLabel.setText("");
        int position = yearJComboBox.getSelectedIndex();
        if (monthJComboBox.getSelectedIndex() == 1) {
            if (position % 4 == 0) {                                            //it is a leap year
                int index = days29JComboBox.getSelectedIndex();
                if (days30JComboBox.isVisible()) {
                    index = days30JComboBox.getSelectedIndex();
                    if (index + 1 > 29) {
                        index = 28;
                    }
                    days30JComboBox.setVisible(false);
                } else if (days31JComboBox.isVisible()) {
                    index = days31JComboBox.getSelectedIndex();
                    if (index + 1 > 29) {
                        index = 28;
                    }
                    days31JComboBox.setVisible(false);
                } else if (days28JComboBox.isVisible()) {
                    index = days28JComboBox.getSelectedIndex();
                    days28JComboBox.setVisible(false);
                }
                days29JComboBox.setSelectedIndex(index);
                days29JComboBox.setVisible(true);
            } else {                                                            //not a leap year
                int index = days28JComboBox.getSelectedIndex();
                if (days30JComboBox.isVisible()) {
                    index = days30JComboBox.getSelectedIndex();
                    if (index + 1 > 28) {
                        index = 27;
                    }
                    days30JComboBox.setVisible(false);
                } else if (days31JComboBox.isVisible()) {
                    index = days31JComboBox.getSelectedIndex();
                    if (index + 1 > 28) {
                        index = 27;
                    }
                    days31JComboBox.setVisible(false);
                } else if (days29JComboBox.isVisible()) {
                    index = days29JComboBox.getSelectedIndex();
                    if (index + 1 > 28) {
                        index = 27;
                    }
                    days29JComboBox.setVisible(false);
                }
                days28JComboBox.setSelectedIndex(index);
                days28JComboBox.setVisible(true);
            }
        }
        updateDate();
    }//GEN-LAST:event_yearJComboBoxActionPerformed

    /*
     This method is defined to handle the events performed on the Month Combo Box.
     Depending upon the selection of the month combo box, the date has to be changed. 
     Along with the change in the date, thes selected month can have 31/30/29/28 days.
     This method handles these changes.
     */
    private void monthJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthJComboBoxActionPerformed
        int position = monthJComboBox.getSelectedIndex() + 1;

        if (position == 1 || position == 3 || position == 5 || position == 7 || position == 8 || position == 10 || position == 12) {        //if the month has 31 days
            int index = days31JComboBox.getSelectedIndex();
            if (days30JComboBox.isVisible()) {
                index = days30JComboBox.getSelectedIndex();
                days30JComboBox.setVisible(false);
            } else if (days28JComboBox.isVisible()) {
                index = days28JComboBox.getSelectedIndex();
                days28JComboBox.setVisible(false);
            } else if (days29JComboBox.isVisible()) {
                index = days29JComboBox.getSelectedIndex();
                days29JComboBox.setVisible(false);
            }
            days31JComboBox.setSelectedIndex(index);
            days31JComboBox.setVisible(true);
        } else if (position == 2) {                                                                                                           //if the selected month is february
            if (Integer.parseInt((String) yearJComboBox.getSelectedItem()) % 4 == 0) {                                                        //if it is a leap year
                int index = days29JComboBox.getSelectedIndex();
                if (days30JComboBox.isVisible()) {
                    index = days30JComboBox.getSelectedIndex();
                    if (index + 1 > 29) {
                        index = 28;
                    }
                    days30JComboBox.setVisible(false);
                } else if (days31JComboBox.isVisible()) {
                    index = days31JComboBox.getSelectedIndex();
                    if (index + 1 > 29) {
                        index = 28;
                    }
                    days31JComboBox.setVisible(false);
                } else if (days28JComboBox.isVisible()) {
                    index = days28JComboBox.getSelectedIndex();
                    days28JComboBox.setVisible(false);
                }
                days29JComboBox.setSelectedIndex(index);
                days29JComboBox.setVisible(true);
            } else {                                                                                                                            //not a leap year
                int index = days28JComboBox.getSelectedIndex();
                if (days30JComboBox.isVisible()) {
                    index = days30JComboBox.getSelectedIndex();
                    if (index + 1 > 28) {
                        index = 27;
                    }
                    days30JComboBox.setVisible(false);
                } else if (days31JComboBox.isVisible()) {
                    index = days31JComboBox.getSelectedIndex();
                    if (index + 1 > 28) {
                        index = 27;
                    }
                    days31JComboBox.setVisible(false);
                } else if (days29JComboBox.isVisible()) {
                    index = days29JComboBox.getSelectedIndex();
                    if (index + 1 > 28) {
                        index = 27;
                    }
                    days29JComboBox.setVisible(false);
                }
                days28JComboBox.setSelectedIndex(index);
                days28JComboBox.setVisible(true);
            }
        } else {                                                                                                                                //else month has 30 days
            int index = days30JComboBox.getSelectedIndex();
            if (days31JComboBox.isVisible()) {
                index = days31JComboBox.getSelectedIndex();
                if (index + 1 == 31) {
                    index--;
                }
                days31JComboBox.setVisible(false);
            } else if (days28JComboBox.isVisible()) {
                index = days28JComboBox.getSelectedIndex();
                days28JComboBox.setVisible(false);
            } else if (days29JComboBox.isVisible()) {
                index = days29JComboBox.getSelectedIndex();
                days29JComboBox.setVisible(false);
            }
            days30JComboBox.setSelectedIndex(index);
            days30JComboBox.setVisible(true);
        }
        updateDate();
    }//GEN-LAST:event_monthJComboBoxActionPerformed

    /*
     This method handles the Keypress event on the City JText field. It will display the errors according to the input performed.
     */
    private void cityJTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cityJTextKeyPressed
        if (cityJText.getText().toString().length() == Constants.CITY_MAX_LENGTH) {
            cityErrorJLabel.setText(Constants.CITY_MAX_LENGTH_TEXT);
            isCityErrorVisible = true;
        }
    }//GEN-LAST:event_cityJTextKeyPressed

    /*
     This method handles the FocusLost event on the City JText field. It will display the errors according to the input performed.
     */
    private void cityJTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cityJTextFocusLost
        if (cityJText.getText().length() == 0) {
            cityErrorJLabel.setText(Constants.CITY_MISSING);
            return;
        }
        if (isCityErrorVisible) {
            cityErrorJLabel.setText("");
            isCityErrorVisible = false;
        }
    }//GEN-LAST:event_cityJTextFocusLost

    /*
     This method handles the FocusGained event on the City JText field. It will display the errors according to the input performed.
     */
    private void cityJTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cityJTextFocusGained
        statusJLabel.setText("");
        if (cityJText.getText().toString().length() > Constants.CITY_MAX_LENGTH) {
            cityErrorJLabel.setText(Constants.CITY_MAX_LENGTH_TEXT);
            isCityErrorVisible = true;
        }
    }//GEN-LAST:event_cityJTextFocusGained

    /*
     This method handles the Keypress event on the Address Line 2 JText field. It will display the errors according to the input performed.
     */
    private void addressLine2JTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addressLine2JTextKeyPressed
        if (addressLine2JText.getText().toString().length() == Constants.ADDRESS_LINE_MAX_LENGTH) {
            addressLine2ErrorJLabel.setText(Constants.ADDRESS_LINE_MAX_LENGTH_TEXT);
            isAddressLine2ErrorVisible = true;
        }
    }//GEN-LAST:event_addressLine2JTextKeyPressed

    /*
     This method handles the FocusLost event on the Address Line 2 JText field. It will display the errors according to the input performed.
     */
    private void addressLine2JTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addressLine2JTextFocusLost
        if (isAddressLine2ErrorVisible) {
            addressLine2ErrorJLabel.setText("");
            isAddressLine2ErrorVisible = false;
        }
    }//GEN-LAST:event_addressLine2JTextFocusLost

    /*
     This method handles the FocusGained event on the Address Line 2 JText field. It will display the errors according to the input performed.
     */
    private void addressLine2JTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addressLine2JTextFocusGained
        statusJLabel.setText("");
        if (addressLine2JText.getText().toString().length() > Constants.ADDRESS_LINE_MAX_LENGTH) {
            addressLine2ErrorJLabel.setText(Constants.ADDRESS_LINE_MAX_LENGTH_TEXT);
            isAddressLine2ErrorVisible = true;
        }
    }//GEN-LAST:event_addressLine2JTextFocusGained

    /*
     This method handles the Keypress event on the Address Line 1 JText field. It will display the errors according to the input performed.
     */
    private void addressLine1JTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addressLine1JTextKeyPressed
        if (addressLine1JText.getText().toString().length() == Constants.ADDRESS_LINE_MAX_LENGTH) {
            addressLine1ErrorJLabel.setText(Constants.ADDRESS_LINE_MAX_LENGTH_TEXT);
            isAddressLine1ErrorVisible = true;
        }
    }//GEN-LAST:event_addressLine1JTextKeyPressed

    /*
     This method handles the FocusLost event on the Address Line 1 JText field. It will display the errors according to the input performed.
     */
    private void addressLine1JTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addressLine1JTextFocusLost
        if (addressLine1JText.getText().length() == 0) {
            addressLine1ErrorJLabel.setText(Constants.ADDRESS_LINE_1_MISSING);
            return;
        }
        if (isAddressLine1ErrorVisible) {
            addressLine1ErrorJLabel.setText("");
            isAddressLine1ErrorVisible = false;
        }
    }//GEN-LAST:event_addressLine1JTextFocusLost

    /*
     This method handles the FocusGained event on the Address Line 1 JText field. It will display the errors according to the input performed.
     */
    private void addressLine1JTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addressLine1JTextFocusGained
        if (addressLine1JText.getText().toString().length() > Constants.ADDRESS_LINE_MAX_LENGTH) {
            addressLine1ErrorJLabel.setText(Constants.ADDRESS_LINE_MAX_LENGTH_TEXT);
            isAddressLine1ErrorVisible = true;
        }
    }//GEN-LAST:event_addressLine1JTextFocusGained

    /*
     This method handles the Keypress event on the Middle Name JText field. It will display the errors according to the input performed.
     */
    private void middleNameJTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_middleNameJTextKeyPressed
        if (middleNameJText.getText().toString().length() == Constants.MIDDLE_NAME_MAX_LENGTH) {
            middleNameErrorJLabel.setText(Constants.MIDDLE_NAME_MAX_LENGTH_TEXT);
            isMiddleNameErrorVisible = true;
        }
    }//GEN-LAST:event_middleNameJTextKeyPressed

    /*
     This method handles the FocusLost event on the Middle Name JText field. It will display the errors according to the input performed.
     */
    private void middleNameJTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_middleNameJTextFocusLost
        if (isMiddleNameErrorVisible) {
            middleNameErrorJLabel.setText("");
            isMiddleNameErrorVisible = false;
        }
    }//GEN-LAST:event_middleNameJTextFocusLost

    /*
     This method handles the Keypress event on the Last Name JText field. It will display the errors according to the input performed.
     */
    private void lastNameJTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastNameJTextKeyPressed
        if (lastNameJText.getText().toString().length() == Constants.LAST_NAME_MAX_LENGTH) {
            lastNameErrorJLabel.setText(Constants.LAST_NAME_MAX_LENGTH_TEXT);
            isLastNameErrorVisible = true;
        }
    }//GEN-LAST:event_lastNameJTextKeyPressed

    /*
     This method handles the FocusLost event on the Last Name JText field. It will display the errors according to the input performed.
     */
    private void lastNameJTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastNameJTextFocusLost
        if (lastNameJText.getText().length() == 0) {
            lastNameErrorJLabel.setText(Constants.LAST_NAME_MISSING);
            return;
        }
        if (isLastNameErrorVisible) {
            lastNameErrorJLabel.setText("");
            isLastNameErrorVisible = false;
        }
    }//GEN-LAST:event_lastNameJTextFocusLost

    /*
     This method handles the FocusGained event on the Last Name JText field. It will display the errors according to the input performed.
     */
    private void lastNameJTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastNameJTextFocusGained
        statusJLabel.setText("");
        if (lastNameJText.getText().toString().length() > Constants.LAST_NAME_MAX_LENGTH) {
            lastNameErrorJLabel.setText(Constants.LAST_NAME_MAX_LENGTH_TEXT);
            isLastNameErrorVisible = true;
        }
    }//GEN-LAST:event_lastNameJTextFocusGained

    /*
     This method handles the Keypress event on the First Name JText field. It will display the errors according to the input performed.
     */
    private void firstNameJTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstNameJTextKeyPressed
        if (firstNameJText.getText().toString().length() == Constants.FIRST_NAME_MAX_LENGTH) {
            firstNameErrorJLabel.setText(Constants.FIRST_NAME_MAX_LENGTH_TEXT);
            isFirstNameErrorVisible = true;
        }
    }//GEN-LAST:event_firstNameJTextKeyPressed

    /*
     This method handles the FocusLost event on the First Name JText field. It will display the errors according to the input performed.
     */
    private void firstNameJTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstNameJTextFocusLost
        if (firstNameJText.getText().length() == 0) {
            firstNameErrorJLabel.setText(Constants.FIRST_NAME_MISSING);
            return;
        }
        if (isFirstNameErrorVisible) {
            firstNameErrorJLabel.setText("");
            isFirstNameErrorVisible = false;
        }
    }//GEN-LAST:event_firstNameJTextFocusLost

    /*
     This method handles the FocusGained event on the First Name JText field. It will display the errors according to the input performed.
     */
    private void firstNameJTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstNameJTextFocusGained
        statusJLabel.setText("");
        if (firstNameJText.getText().toString().length() > Constants.FIRST_NAME_MAX_LENGTH) {
            firstNameErrorJLabel.setText(Constants.FIRST_NAME_MAX_LENGTH_TEXT);
            isFirstNameErrorVisible = true;
        }
    }//GEN-LAST:event_firstNameJTextFocusGained

    /*
     This method handles the FocusGained event on the State JText field. It will display the errors according to the input performed.
     */
    private void stateJTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stateJTextFocusGained
        statusJLabel.setText("");
        if (stateJText.getText().toString().length() > Constants.STATE_MAX_LENGTH) {
            stateErrorJLabel.setText(Constants.STATE_MAX_LENGTH_TEXT);
            isStateErrorVisible = true;
        }
    }//GEN-LAST:event_stateJTextFocusGained

    /*
     This method handles the FocusLost event on the State JText field. It will display the errors according to the input performed.
     */
    private void stateJTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stateJTextFocusLost
        if (stateJText.getText().length() == 0) {
            stateErrorJLabel.setText(Constants.STATE_MISSING);
            return;
        }
        if (isStateErrorVisible) {
            stateErrorJLabel.setText("");
            isStateErrorVisible = false;
        }
    }//GEN-LAST:event_stateJTextFocusLost

    /*
     This method handles the Keypress event on the State JText field. It will display the errors according to the input performed.
     */
    private void stateJTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stateJTextKeyPressed
        if (stateJText.getText().toString().length() == Constants.STATE_MAX_LENGTH) {
            stateErrorJLabel.setText(Constants.STATE_MAX_LENGTH_TEXT);
            isStateErrorVisible = true;
        }
    }//GEN-LAST:event_stateJTextKeyPressed

    /*
     This method handles the FocusGained event on the Zipcode JText field. It will display the errors according to the input performed.
     */
    private void zipCodeJTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_zipCodeJTextFocusGained
        statusJLabel.setText("");
        if (zipCodeJText.getText().toString().length() > Constants.ZIP_CODE_MAX_LENGTH) {
            zipCodeErrorJLabel.setText(Constants.ZIP_CODE_MAX_LENGTH_TEXT);
            isZipCodeErrorVisible = true;
        }
    }//GEN-LAST:event_zipCodeJTextFocusGained

    /*
     This method handles the FocusLost event on the Zipcode JText field. It will display the errors according to the input performed.
     */
    private void zipCodeJTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_zipCodeJTextFocusLost
        if (zipCodeJText.getText().length() == 0) {
            zipCodeErrorJLabel.setText(Constants.ZIP_CODE_MISSING);
            return;
        }
        if (isZipCodeErrorVisible) {
            zipCodeErrorJLabel.setText("");
            isZipCodeErrorVisible = false;
        }
    }//GEN-LAST:event_zipCodeJTextFocusLost

    /*
     This method handles the Keypress event on the Zipcode field. It will display the errors according to the input performed.
     */
    private void zipCodeJTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_zipCodeJTextKeyPressed
        if (zipCodeJText.getText().toString().length() == Constants.ZIP_CODE_MAX_LENGTH) {
            zipCodeErrorJLabel.setText(Constants.ZIP_CODE_MAX_LENGTH_TEXT);
            isZipCodeErrorVisible = true;
        } else {
            zipCodeErrorJLabel.setText("");
            isZipCodeErrorVisible = false;
        }
    }//GEN-LAST:event_zipCodeJTextKeyPressed

    /*
     This method handles the FocusGained event on the Phone number JText field. It will display the errors according to the input performed.
     */
    private void phoneNumberJTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phoneNumberJTextFocusGained
        statusJLabel.setText("");
        if (phoneNumberJText.getText().toString().length() > Constants.PHONE_NUMBER_MAX_LENGTH) {
            phoneNumberErrorJLabel.setText(Constants.PHONE_NUMBER_MAX_LENGTH_TEXT);
            isPhoneNumberErrorVisible = true;
        }
    }//GEN-LAST:event_phoneNumberJTextFocusGained

    /*
     This method handles the FocusLost event on the Phone number JText field. It will display the errors according to the input performed.
     */
    private void phoneNumberJTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phoneNumberJTextFocusLost
        if (phoneNumberJText.getText().length() == 0) {
            phoneNumberErrorJLabel.setText(Constants.PHONE_NUMBER_MISSING);
            return;
        }
        if (isPhoneNumberErrorVisible) {
            phoneNumberErrorJLabel.setText("");
            isPhoneNumberErrorVisible = false;
        }
    }//GEN-LAST:event_phoneNumberJTextFocusLost

    /*
     This method handles the Keypress event on the Phone number field. It will display the errors according to the input performed.
     */
    private void phoneNumberJTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNumberJTextKeyPressed
        if (phoneNumberJText.getText().toString().length() == Constants.PHONE_NUMBER_MAX_LENGTH) {
            phoneNumberErrorJLabel.setText(Constants.PHONE_NUMBER_MAX_LENGTH_TEXT);
            isPhoneNumberErrorVisible = true;
        }
    }//GEN-LAST:event_phoneNumberJTextKeyPressed

    /*
     This method handles the FocusGained event on the Email Address JText field. It will display the errors according to the input performed.
     */
    private void emailAddressJTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailAddressJTextFocusGained
        statusJLabel.setText("");
        if (emailAddressJText.getText().length() == 0) {
            return;
        }
        if (emailAddressJText.getText().toString().length() > Constants.EMAIL_ADDRESS_MAX_LENGTH) {
            emailAddressErrorJLabel.setText(Constants.EMAIL_ADDRESS_MAX_LENGTH_TEXT);
            isEmailAddressErrorVisible = true;
        } else if (!isEmailAddressValid(emailAddressJText.getText())) {
            emailAddressErrorJLabel.setText(Constants.EMAIL_ADDRESS_INVALID);
            isEmailAddressErrorVisible = true;
        }
    }//GEN-LAST:event_emailAddressJTextFocusGained

    /*
     This method handles the FocusLost event on the Email Address JText field. It will display the errors according to the input performed.
     */
    private void emailAddressJTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailAddressJTextFocusLost
        if (emailAddressJText.getText().length() == 0) {
            emailAddressErrorJLabel.setText(Constants.EMAIL_ADDRESS_MISSING);
            isEmailAddressErrorVisible = true;
            return;
        }
        if (emailAddressJText.getText().length() <= Constants.EMAIL_ADDRESS_MAX_LENGTH) {
            if (!isEmailAddressValid(emailAddressJText.getText())) {
                emailAddressErrorJLabel.setText(Constants.EMAIL_ADDRESS_INVALID);
                isEmailAddressErrorVisible = true;
                return;
            } else if (isEmailAddressErrorVisible) {
                emailAddressErrorJLabel.setText("");
                isEmailAddressErrorVisible = false;
            }
        }
    }//GEN-LAST:event_emailAddressJTextFocusLost

    /*
     This method is defined to handle the events performed on the 30 Days Combo Box
     */
    private void days30JComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_days30JComboBoxActionPerformed
        statusJLabel.setText("");
        updateDate();
    }//GEN-LAST:event_days30JComboBoxActionPerformed

    /*
     This method is defined to handle the events performed on the 31 Days Combo Box
     */
    private void days31JComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_days31JComboBoxActionPerformed
        statusJLabel.setText("");
        updateDate();
    }//GEN-LAST:event_days31JComboBoxActionPerformed

    /*
     This method is defined to handle the events performed on the 28 Days Combo Box
     */
    private void days28JComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_days28JComboBoxActionPerformed
        statusJLabel.setText("");
        updateDate();
    }//GEN-LAST:event_days28JComboBoxActionPerformed

    /*
     This method is defined to handle the events performed on the 29 Days Combo Box
     */
    private void days29JComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_days29JComboBoxActionPerformed
        statusJLabel.setText("");
        updateDate();
    }//GEN-LAST:event_days29JComboBoxActionPerformed

    /*
     This method is defined to handle the events performed on the Save & New JButon
     */
    private void saveAndNewJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveAndNewJButtonMouseClicked
        statusJLabel.setText("");
        if (isDataValid()) {                                                                                                                        //Checking if data is valid
            if (customerDetailsJTable.getSelectedRow() == -1) {                                                                                     //if no rows are selected then insert
                int result = CustomerDataHandler.insertData(customerDetailsJTable, replaceCharacters(firstNameJText.getText()).replace(' ', '-'),
                        replaceCharacters(lastNameJText.getText().trim()).replace(' ', '-'),
                        replaceCharacters(middleNameJText.getText()),
                        replaceCharacters(addressLine1JText.getText()), replaceCharacters(addressLine2JText.getText()),
                        replaceCharacters(cityJText.getText()), replaceCharacters(stateJText.getText()), replaceCharacters(zipCodeJText.getText()),
                        replaceCharacters(phoneNumberJText.getText()), replaceCharacters(emailAddressJText.getText()),
                        Boolean.toString(proofOfPurchaseJCheckbox.isSelected()), dateTextJLabel.getText());
                if (result == 0) {
                    statusJLabel.setText(Constants.RECORD_SAVED);
                    clearFormData();
                } else {
                    statusJLabel.setText(Constants.RECORD_EXISTS);
                    firstNameJText.requestFocus();
                }
            } else {                                                                                                                                // else update
                int result = CustomerDataHandler.updateData(customerDetailsJTable, replaceCharacters(firstNameJText.getText()).replace(' ', '-'),
                        replaceCharacters(lastNameJText.getText().trim()).replace(' ', '-'),
                        replaceCharacters(middleNameJText.getText()),
                        replaceCharacters(addressLine1JText.getText()), replaceCharacters(addressLine2JText.getText()),
                        replaceCharacters(cityJText.getText()), replaceCharacters(stateJText.getText()), replaceCharacters(zipCodeJText.getText()),
                        replaceCharacters(phoneNumberJText.getText()), replaceCharacters(emailAddressJText.getText()),
                        Boolean.toString(proofOfPurchaseJCheckbox.isSelected()), dateTextJLabel.getText());
                if (result == 0) {
                    statusJLabel.setText(Constants.RECORD_SAVED);
                    clearFormData();
                } else if (result == -1) {
                    statusJLabel.setText(Constants.NO_RECORDS);
                    firstNameJText.requestFocus();
                } else if (result == -2) {
                    statusJLabel.setText(Constants.RECORD_NOT_FOUND);
                    firstNameJText.requestFocus();
                } else {
                    statusJLabel.setText(Constants.RECORD_EXISTS);
                    firstNameJText.requestFocus();
                }
            }

        }
    }//GEN-LAST:event_saveAndNewJButtonMouseClicked

    /*
     This method is defined to handle the events performed on the Save & Exit JButon
     */
    private void saveAndExitJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveAndExitJButtonMouseClicked
        statusJLabel.setText("");
        if (isDataValid()) {                                                                                                                            //check if any rows are selected
            if (customerDetailsJTable.getSelectedRow() == -1) {                                                                                         //if selected then insert
                int result = CustomerDataHandler.insertData(customerDetailsJTable, replaceCharacters(firstNameJText.getText()).replace(' ', '-'),
                        replaceCharacters(lastNameJText.getText().trim()).replace(' ', '-'),
                        replaceCharacters(middleNameJText.getText()),
                        replaceCharacters(addressLine1JText.getText()), replaceCharacters(addressLine2JText.getText()),
                        replaceCharacters(cityJText.getText()), replaceCharacters(stateJText.getText()), replaceCharacters(zipCodeJText.getText()),
                        replaceCharacters(phoneNumberJText.getText()), replaceCharacters(emailAddressJText.getText()),
                        Boolean.toString(proofOfPurchaseJCheckbox.isSelected()), dateTextJLabel.getText());
                if (result == 0) {
                    CustomerDataHandler.wrapUp();
                    System.exit(0);

                } else {
                    statusJLabel.setText(Constants.RECORD_EXISTS);
                    firstNameJText.requestFocus();
                }
            } else {                                                                                                                                    //else update
                int result = CustomerDataHandler.updateData(customerDetailsJTable, replaceCharacters(firstNameJText.getText()).replace(' ', '-'),
                        replaceCharacters(lastNameJText.getText().trim()).replace(' ', '-'),
                        replaceCharacters(middleNameJText.getText()),
                        replaceCharacters(addressLine1JText.getText()), replaceCharacters(addressLine2JText.getText()),
                        replaceCharacters(cityJText.getText()), replaceCharacters(stateJText.getText()), replaceCharacters(zipCodeJText.getText()),
                        replaceCharacters(phoneNumberJText.getText()), replaceCharacters(emailAddressJText.getText()),
                        Boolean.toString(proofOfPurchaseJCheckbox.isSelected()), dateTextJLabel.getText());
                if (result == 0) {
                    CustomerDataHandler.wrapUp();
                    System.exit(0);
                } else if (result == -1) {
                    statusJLabel.setText(Constants.NO_RECORDS);
                    firstNameJText.requestFocus();
                } else if (result == -2) {
                    statusJLabel.setText(Constants.RECORD_NOT_FOUND);
                    firstNameJText.requestFocus();
                } else {
                    statusJLabel.setText(Constants.RECORD_EXISTS);
                    firstNameJText.requestFocus();
                }
            }

        }
    }//GEN-LAST:event_saveAndExitJButtonMouseClicked

    /*
     This method will handle the event of clicking Clear button. 
     */
    private void clearJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearJButtonMouseClicked
        statusJLabel.setText("");
        clearFormData();
    }//GEN-LAST:event_clearJButtonMouseClicked

    /*
     This method will handle the event of clicking the Delete Record button.
     */
    private void deleteRecordJTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteRecordJTextMouseClicked
        statusJLabel.setText("");
        if (customerDetailsJTable.getSelectedRow() != -1) {                                         //check if something is selected
            int result = CustomerDataHandler.deleteData(customerDetailsJTable);
            if (result == 0) {
                clearFormData();
                statusJLabel.setText(Constants.RECORD_DELETED);
                firstNameJText.requestFocus();
            } else if (result == -1) {
                statusJLabel.setText(Constants.NO_RECORDS);
                firstNameJText.requestFocus();
            } else {
                statusJLabel.setText(Constants.RECORD_NOT_FOUND);
                firstNameJText.requestFocus();
            }
        } else {
            statusJLabel.setText(Constants.NOTHING_SELECTED);
            firstNameJText.requestFocus();
        }

    }//GEN-LAST:event_deleteRecordJTextMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        CustomerDataHandler.wrapUp();
    }//GEN-LAST:event_formWindowClosed

    /*
     This method is written so as to help with updating the Date JLabel with the date that is on the combo box selections.
     */
    private void updateDate() {
        int day = 0, month = 0, year = 0;
        if (days31JComboBox.isVisible()) {
            day = days31JComboBox.getSelectedIndex() + 1;
        } else if (days30JComboBox.isVisible()) {
            day = days30JComboBox.getSelectedIndex() + 1;
        } else if (days29JComboBox.isVisible()) {
            day = days29JComboBox.getSelectedIndex() + 1;
        } else {
            day = days28JComboBox.getSelectedIndex() + 1;
        }
        month = monthJComboBox.getSelectedIndex() + 1;
        year = yearJComboBox.getSelectedIndex() + 2000;
        dateTextJLabel.setText(month + "-" + day + "-" + year);
    }

    /*
     This method is defined so as to help with the setting up the current date in the combo boxes and date jlabel during the initialization of the form.
     */
    private void setUpDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        Date date = new Date();
        String currentDate = dateFormat.format(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        yearJComboBox.setSelectedIndex(year % 2000);
        int month = cal.get(Calendar.MONTH);
        monthJComboBox.setSelectedIndex(month);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int position = month + 1;
        if (position == 1 || position == 3 || position == 5 || position == 7 || position == 8 || position == 10 || position == 12) {//number of days is 31
            days31JComboBox.setVisible(true);
            days30JComboBox.setVisible(false);
            days29JComboBox.setVisible(false);
            days28JComboBox.setVisible(false);
            days31JComboBox.setSelectedIndex(day - 1);
        } else if (position == 2) {
            if (year % 4 == 0) { //number of days is 29
                days31JComboBox.setVisible(false);
                days30JComboBox.setVisible(false);
                days29JComboBox.setVisible(true);
                days28JComboBox.setVisible(false);

                days29JComboBox.setSelectedIndex(day - 1);
            } else// number of days 28
            {
                days31JComboBox.setVisible(false);
                days30JComboBox.setVisible(false);
                days29JComboBox.setVisible(false);
                days28JComboBox.setVisible(true);

                days28JComboBox.setSelectedIndex(day - 1);
            }
        } else {// number of days is 30
            days31JComboBox.setVisible(false);
            days30JComboBox.setVisible(true);
            days29JComboBox.setVisible(false);
            days28JComboBox.setVisible(false);

            days30JComboBox.setSelectedIndex(day - 1);
        }
        dateTextJLabel.setText(currentDate);
    }

    /*
     This method validates the Email Address
     */
    private boolean isEmailAddressValid(String emailId) {
        Pattern pattern = Pattern.compile(Constants.EMAIL_MATCHING_PATTERN);
        Matcher matcher = pattern.matcher(emailId);
        return matcher.matches();
    }

    /*
     This method is defined so that whenever it is called, it validates all the data from the form and displays error message according to the error in tj=he corresponding field in the form.
     It return true if all the data is valid anf false if there are errors in the form.
     */
    private boolean isDataValid() {
        boolean isValid = true;
        Pattern pattern;
        Matcher matcher;

        if (firstNameJText.getText().length() == 0) {                                                                       //checking first name
            firstNameErrorJLabel.setText(Constants.FIRST_NAME_MISSING);
            isValid = false;
        }
        if (firstNameJText.getText().toString().length() > Constants.FIRST_NAME_MAX_LENGTH) {
            firstNameErrorJLabel.setText(Constants.FIRST_NAME_MAX_LENGTH_TEXT);
            isValid = false;
        }
        pattern = Pattern.compile(Constants.FIRST_NAME_PATTERN);
        matcher = pattern.matcher(firstNameJText.getText());
        if (!matcher.matches()) {
            firstNameErrorJLabel.setText(Constants.INVALID_CHARS);
            isValid = false;
        }

        if (lastNameJText.getText().length() == 0) {                                                                        //checking last name
            lastNameErrorJLabel.setText(Constants.LAST_NAME_MISSING);
            isValid = false;
        }
        if (lastNameJText.getText().toString().length() > Constants.LAST_NAME_MAX_LENGTH) {
            lastNameErrorJLabel.setText(Constants.LAST_NAME_MAX_LENGTH_TEXT);
            isValid = false;
        }
        pattern = Pattern.compile(Constants.LAST_NAME_PATTERN);
        matcher = pattern.matcher(lastNameJText.getText());
        if (!matcher.matches()) {
            lastNameErrorJLabel.setText(Constants.INVALID_CHARS);
            isValid = false;
        }

        if (middleNameJText.getText().toString().length() > Constants.MIDDLE_NAME_MAX_LENGTH) {                             //checking middle name
            middleNameErrorJLabel.setText(Constants.MIDDLE_NAME_MAX_LENGTH_TEXT);
            isValid = false;
        }
        pattern = Pattern.compile(Constants.MIDDLE_NAME_PATTERN);
        matcher = pattern.matcher(middleNameJText.getText());
        if (!matcher.matches()) {
            middleNameErrorJLabel.setText(Constants.INVALID_CHARS);
            isValid = false;
        }

        if (addressLine1JText.getText().length() == 0) {                                                                    //checking address line 1
            addressLine1ErrorJLabel.setText(Constants.ADDRESS_LINE_1_MISSING);
            isValid = false;
        }
        if (addressLine1JText.getText().toString().length() > Constants.ADDRESS_LINE_MAX_LENGTH) {
            addressLine1ErrorJLabel.setText(Constants.ADDRESS_LINE_MAX_LENGTH_TEXT);
            isValid = false;
        }
        for (int i = 0; i < addressLine1JText.getText().length(); i++) {
            char c = addressLine1JText.getText().charAt(i);
            switch (c) {
                case '!':
                case '`':
                case '~':
                case '#':
                case '$':
                case '%':
                case '^':
                case '*':
                case '?':
                case '{':
                case '}':
                case '<':
                case '>':
                case ';':
                case '\'':
                case '\"':
                    addressLine1ErrorJLabel.setText(Constants.INVALID_CHARS);
                    isValid = false;
            }
        }

        if (addressLine2JText.getText().toString().length() > Constants.ADDRESS_LINE_MAX_LENGTH) {                          //checking address line 2
            addressLine2ErrorJLabel.setText(Constants.ADDRESS_LINE_MAX_LENGTH_TEXT);
            isValid = false;
        }
        for (int i = 0; i < addressLine2JText.getText().length(); i++) {
            char c = addressLine2JText.getText().charAt(i);
            switch (c) {
                case '!':
                case '`':
                case '~':
                case '#':
                case '$':
                case '%':
                case '^':
                case '*':
                case '?':
                case '{':
                case '}':
                case '<':
                case '>':
                case ';':
                case '\'':
                case '\"':
                    addressLine2ErrorJLabel.setText(Constants.INVALID_CHARS);
                    isValid = false;
            }
        }

        if (cityJText.getText().length() == 0) {                                                                            //checking city
            cityErrorJLabel.setText(Constants.CITY_MISSING);
            isValid = false;
        }
        if (cityJText.getText().toString().length() > Constants.CITY_MAX_LENGTH) {
            cityErrorJLabel.setText(Constants.CITY_MAX_LENGTH_TEXT);
            isValid = false;
        }
        pattern = Pattern.compile(Constants.CITY_PATERN);
        matcher = pattern.matcher(cityJText.getText());
        if (!matcher.matches()) {
            cityErrorJLabel.setText(Constants.INVALID_CHARS);
            isValid = false;
        }

        if (stateJText.getText().length() == 0) {                                                                           //checking state
            stateErrorJLabel.setText(Constants.STATE_MISSING);
            isValid = false;
        }
        if (stateJText.getText().toString().length() > Constants.STATE_MAX_LENGTH) {
            stateErrorJLabel.setText(Constants.STATE_MAX_LENGTH_TEXT);
            isValid = false;
        }
        pattern = Pattern.compile(Constants.STATE_PATTERN);
        matcher = pattern.matcher(stateJText.getText());
        if (!matcher.matches()) {
            stateErrorJLabel.setText(Constants.INVALID_CHARS);
            isValid = false;
        }

        if (zipCodeJText.getText().length() == 0) {                                                                         //checking the zipcode
            zipCodeErrorJLabel.setText(Constants.ZIP_CODE_MISSING);
            isValid = false;
        }
        if (zipCodeJText.getText().toString().length() > Constants.ZIP_CODE_MAX_LENGTH) {
            zipCodeErrorJLabel.setText(Constants.ZIP_CODE_MAX_LENGTH_TEXT);
            isValid = false;
        }

        if (phoneNumberJText.getText().length() == 0) {                                                                     //checking the phone number
            phoneNumberErrorJLabel.setText(Constants.PHONE_NUMBER_MISSING);
            isValid = false;
        }
        if (phoneNumberJText.getText().toString().length() > Constants.PHONE_NUMBER_MAX_LENGTH) {
            phoneNumberErrorJLabel.setText(Constants.PHONE_NUMBER_MAX_LENGTH_TEXT);
            isValid = false;
        }

        if (emailAddressJText.getText().length() == 0) {                                                                    //checking the email address
            emailAddressErrorJLabel.setText(Constants.EMAIL_ADDRESS_MISSING);
            isValid = false;
        }
        if (emailAddressJText.getText().length() <= Constants.EMAIL_ADDRESS_MAX_LENGTH) {
            if (!isEmailAddressValid(emailAddressJText.getText())) {
                emailAddressErrorJLabel.setText(Constants.EMAIL_ADDRESS_INVALID);
                isValid = false;
            }
        }
        return isValid;
    }

    private CustomerDetailsBean createBean() {
        CustomerDetailsBean bean = new CustomerDetailsBean(
                replaceCharacters(firstNameJText.getText()).replace(' ', '-'),
                replaceCharacters(lastNameJText.getText().trim()).replace(' ', '-'),
                replaceCharacters(middleNameJText.getText()),
                replaceCharacters(addressLine1JText.getText()), replaceCharacters(addressLine2JText.getText()),
                replaceCharacters(cityJText.getText()), replaceCharacters(stateJText.getText()), replaceCharacters(zipCodeJText.getText()),
                replaceCharacters(phoneNumberJText.getText()), replaceCharacters(emailAddressJText.getText()),
                Boolean.toString(proofOfPurchaseJCheckbox.isSelected()), dateTextJLabel.getText());
        return bean;
    }

    /*
     This method is defined so as to format the data before entering it into the table/file.
     */
    private String replaceCharacters(String string) {
        return string.trim().replace("'", " ");
    }

    /*
     This method helps in parsing the string date that has been passed to it and seting the values into the month, day and year combo boxes accordingly.
     */
    private void parseAndSetDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

        try {
            Date dateToSet = dateFormat.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(dateToSet);
            int year = cal.get(Calendar.YEAR);
            yearJComboBox.setSelectedIndex(year % 2000);
            int month = cal.get(Calendar.MONTH);
            monthJComboBox.setSelectedIndex(month);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int position = month + 1;
            if (position == 1 || position == 3 || position == 5 || position == 7 || position == 8 || position == 10 || position == 12) {//number of days is 31
                days31JComboBox.setVisible(true);
                days30JComboBox.setVisible(false);
                days29JComboBox.setVisible(false);
                days28JComboBox.setVisible(false);
                days31JComboBox.setSelectedIndex(day - 1);
            } else if (position == 2) {
                if (year % 4 == 0) { //number of days is 29
                    days31JComboBox.setVisible(false);
                    days30JComboBox.setVisible(false);
                    days29JComboBox.setVisible(true);
                    days28JComboBox.setVisible(false);

                    days29JComboBox.setSelectedIndex(day - 1);
                } else// number of days 28
                {
                    days31JComboBox.setVisible(false);
                    days30JComboBox.setVisible(false);
                    days29JComboBox.setVisible(false);
                    days28JComboBox.setVisible(true);

                    days28JComboBox.setSelectedIndex(day - 1);
                }
            } else {// number of days is 30
                days31JComboBox.setVisible(false);
                days30JComboBox.setVisible(true);
                days29JComboBox.setVisible(false);
                days28JComboBox.setVisible(false);

                days30JComboBox.setSelectedIndex(day - 1);
            }
            dateTextJLabel.setText(date);
        } catch (Exception e) {
            setUpDate();
        }
    }

    /*
     This method clears all the form data.
     */
    private void clearFormData() {
        firstNameJText.setText("");
        firstNameErrorJLabel.setText("");
        lastNameJText.setText("");
        lastNameErrorJLabel.setText("");
        middleNameJText.setText("");
        middleNameErrorJLabel.setText("");
        addressLine1JText.setText("");
        addressLine2ErrorJLabel.setText("");
        addressLine2JText.setText("");
        addressLine2ErrorJLabel.setText("");
        cityJText.setText("");
        cityErrorJLabel.setText("");
        stateJText.setText("");
        stateErrorJLabel.setText("");
        zipCodeJText.setText("");
        zipCodeErrorJLabel.setText("");
        phoneNumberJText.setText("");
        phoneNumberErrorJLabel.setText("");
        emailAddressJText.setText("");
        emailAddressErrorJLabel.setText("");
        if (!proofOfPurchaseJCheckbox.isSelected()) {
            proofOfPurchaseJCheckbox.setSelected(true);
        }
        setUpDate();
        customerDetailsJTable.getSelectionModel().clearSelection();
        statusJLabel.setText("");
        firstNameJText.requestFocus();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RebateDataForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RebateDataForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RebateDataForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RebateDataForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RebateDataForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addressInfoJPanel;
    private javax.swing.JLabel addressLine1ErrorJLabel;
    private javax.swing.JLabel addressLine1JLabel;
    private javax.swing.JTextField addressLine1JText;
    private javax.swing.JLabel addressLine2ErrorJLabel;
    private javax.swing.JLabel addressLine2JLabel;
    private javax.swing.JTextField addressLine2JText;
    private javax.swing.JLabel cityErrorJLabel;
    private javax.swing.JLabel cityJLabel;
    private javax.swing.JTextField cityJText;
    private javax.swing.JButton clearJButton;
    private javax.swing.JLabel compulsoryNoteJLabel;
    private javax.swing.JPanel contactInfoJPanel;
    private javax.swing.JTable customerDetailsJTable;
    private javax.swing.JPanel customerListJPanel;
    private javax.swing.JScrollPane customerListJScrollPane;
    private javax.swing.JLabel dateJLabel;
    private javax.swing.JLabel dateTextErrorJLabel;
    private javax.swing.JLabel dateTextJLabel;
    private javax.swing.JComboBox days28JComboBox;
    private javax.swing.JComboBox days29JComboBox;
    private javax.swing.JComboBox days30JComboBox;
    private javax.swing.JComboBox days31JComboBox;
    private javax.swing.JButton deleteRecordJText;
    private javax.swing.JLabel emailAddressErrorJLabel;
    private javax.swing.JLabel emailAddressJLabel;
    private javax.swing.JTextField emailAddressJText;
    private javax.swing.JLabel firstNameErrorJLabel;
    private javax.swing.JTextField firstNameJText;
    private javax.swing.JLabel firstNameJlabel;
    private javax.swing.JLabel lastNameErrorJLabel;
    private javax.swing.JLabel lastNameJLabel;
    private javax.swing.JTextField lastNameJText;
    private javax.swing.JLabel middleNameErrorJLabel;
    private javax.swing.JLabel middleNameJLabel;
    private javax.swing.JTextField middleNameJText;
    private javax.swing.JComboBox monthJComboBox;
    private javax.swing.JPanel newCustomerDetailsJPanel;
    private javax.swing.JPanel personalInfoJPanel;
    private javax.swing.JLabel phoneNumberErrorJLabel;
    private javax.swing.JLabel phoneNumberJLabel;
    private javax.swing.JTextField phoneNumberJText;
    private javax.swing.JCheckBox proofOfPurchaseJCheckbox;
    private javax.swing.JButton saveAndExitJButton;
    private javax.swing.JButton saveAndNewJButton;
    private javax.swing.JLabel stateErrorJLabel;
    private javax.swing.JLabel stateJLabel;
    private javax.swing.JTextField stateJText;
    private javax.swing.JLabel statusJLabel;
    private javax.swing.JComboBox yearJComboBox;
    private javax.swing.JLabel zipCodeErrorJLabel;
    private javax.swing.JLabel zipCodeJLabel;
    private javax.swing.JTextField zipCodeJText;
    // End of variables declaration//GEN-END:variables
}


/*
 This custom class helps in limiting the input to a number of characters that has been passed to it.
 */
class JTextFieldLimit extends PlainDocument {

    private int limit;

    JTextFieldLimit(int limit) {
        super();
        this.limit = limit;
    }

    JTextFieldLimit(int limit, boolean upper) {
        super();
        this.limit = limit;
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        }
        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}

/*
 This custom class helps in filtering the input to the zipcode jtext field.
 It ensures that only integers are written into the Zipcode field and also that the number of characters do not exceed the limit.
 */
class MyZipCodeFilter extends DocumentFilter {

    private JLabel myErrorLabel;

    public MyZipCodeFilter(JLabel myErrorLabel) {
        this.myErrorLabel = myErrorLabel;
    }

    private boolean isValid(String testText) {
        if (testText.length() > Constants.ZIP_CODE_MAX_LENGTH) {
            myErrorLabel.setText(Constants.ZIP_CODE_MAX_LENGTH_TEXT);
            return false;
        }
        if (testText.isEmpty()) {
            myErrorLabel.setText("");
            return true;
        }
        int intValue = 0;
        try {
            intValue = Integer.parseInt(testText.trim());
        } catch (NumberFormatException e) {
            myErrorLabel.setText(Constants.ZIP_CODE_NUM_ONLY);
            return false;
        }
        myErrorLabel.setText("");
        return true;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String text,
            AttributeSet attr) throws BadLocationException {
        StringBuilder sb = new StringBuilder();
        sb.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
        sb.insert(offset, text);
        if (isValid(sb.toString())) {
            super.insertString(fb, offset, text, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length,
            String text, AttributeSet attrs) throws BadLocationException {
        StringBuilder sb = new StringBuilder();
        sb.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
        int end = offset + length;
        sb.replace(offset, end, text);
        if (isValid(sb.toString())) {
            super.replace(fb, offset, length, text, attrs);
        }
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length)
            throws BadLocationException {
        StringBuilder sb = new StringBuilder();
        sb.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
        int end = offset + length;
        sb.delete(offset, end);
        if (isValid(sb.toString())) {
            super.remove(fb, offset, length);
        }
    }
}


/*
 This custom class helps in filtering the input to the phone number jtext field.
 It ensures that only integers are written into the phone number field and also that the number of characters do not exceed the limit.
 */
class MyPhoneNumberFilter extends DocumentFilter {

    private JLabel myErrorLabel;

    public MyPhoneNumberFilter(JLabel myErrorLabel) {
        this.myErrorLabel = myErrorLabel;
    }

    private boolean isValid(String allText, int offset) {
        try {
            char newChar = allText.charAt(offset);
            if (Character.isDigit(newChar)) {
                if (allText.length() > Constants.PHONE_NUMBER_MAX_LENGTH) {
                    myErrorLabel.setText(Constants.PHONE_NUMBER_MAX_LENGTH_TEXT);
                    return false;
                }
                if (allText.isEmpty()) {
                    myErrorLabel.setText("");
                    return true;
                }
                myErrorLabel.setText("");
                return true;
            } else {
                myErrorLabel.setText(Constants.PHONE_NUMBER_NUM_ONLY);
                return false;
            }
        } catch (Exception e) {
            myErrorLabel.setText("");
            return true;
        }
    }

    @Override
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String text,
            AttributeSet attr) throws BadLocationException {
        StringBuilder sb = new StringBuilder();
        sb.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
        sb.insert(offset, text);
        if (isValid(sb.toString(), offset)) {
            super.insertString(fb, offset, text, attr);
        }
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length,
            String text, AttributeSet attrs) throws BadLocationException {
        StringBuilder sb = new StringBuilder();
        sb.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
        int end = offset + length;
        sb.replace(offset, end, text);
        if (isValid(sb.toString(), offset)) {
            super.replace(fb, offset, length, text, attrs);
        }
    }

    @Override
    public void remove(DocumentFilter.FilterBypass fb, int offset, int length)
            throws BadLocationException {
        StringBuilder sb = new StringBuilder();
        sb.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
        int end = offset + length;
        sb.delete(offset, end);
        if (isValid(sb.toString(), offset)) {
            super.remove(fb, offset, length);
        }
    }
}


/*
 This is a static class that is used to define all the constants that are used in the application.
 This class ensures that constants are defined at one place only, so that changing one of them will not make us go through the whole code again.
 */
class Constants {

    public static final String INVALID_CHARS = "Field contains some invalid characters";

    public static final int FIRST_NAME_MAX_LENGTH = 20;
    public static final String FIRST_NAME_MAX_LENGTH_TEXT = "Max limit of " + FIRST_NAME_MAX_LENGTH + " characters reached";
    public static final String FIRST_NAME_MISSING = "Please enter the first name";
    public static final String FIRST_NAME_PATTERN = "[a-zA-Z]*";

    public static final int LAST_NAME_MAX_LENGTH = 20;
    public static final String LAST_NAME_MAX_LENGTH_TEXT = "Max limit of " + LAST_NAME_MAX_LENGTH + " characters reached";
    public static final String LAST_NAME_MISSING = "Please enter the last name";
    public static final String LAST_NAME_PATTERN = "[a-zA-z]+([ '-][a-zA-Z]+)*";

    public static final int MIDDLE_NAME_MAX_LENGTH = 1;
    public static final String MIDDLE_NAME_MAX_LENGTH_TEXT = "More than " + MIDDLE_NAME_MAX_LENGTH + " character cannot be entered";
    public static final String MIDDLE_NAME_PATTERN = "[a-zA-Z]*";

    public static final int ADDRESS_LINE_MAX_LENGTH = 65;
    public static final String ADDRESS_LINE_MAX_LENGTH_TEXT = "More than " + ADDRESS_LINE_MAX_LENGTH + " characters cannot be entered";
    public static final String ADDRESS_LINE_1_MISSING = "Please enter the address";

    public static final int CITY_MAX_LENGTH = 25;
    public static final String CITY_MAX_LENGTH_TEXT = "Max " + CITY_MAX_LENGTH + " characters can be entered";
    public static final String CITY_MISSING = "Please enter the city";
    public static final String CITY_PATERN = "([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)";

    public static final int STATE_MAX_LENGTH = 2;
    public static final String STATE_MAX_LENGTH_TEXT = "Max " + STATE_MAX_LENGTH + " characters";
    public static final String STATE_MISSING = "Please enter the state";
    public static final String STATE_PATTERN = "([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)";

    public static final int ZIP_CODE_MAX_LENGTH = 9;
    public static final String ZIP_CODE_MAX_LENGTH_TEXT = "Max " + ZIP_CODE_MAX_LENGTH + " numbers";
    public static final String ZIP_CODE_MISSING = "Please enter the zip code";
    public static final String ZIP_CODE_INVALID = "Please enter a valid zip code";
    public static final String ZIP_CODE_NUM_ONLY = "Please enter numbers only";

    public static final int PHONE_NUMBER_MAX_LENGTH = 21;
    public static final String PHONE_NUMBER_MAX_LENGTH_TEXT = "Max " + PHONE_NUMBER_MAX_LENGTH + " digits allowed";
    public static final String PHONE_NUMBER_MISSING = "Please enter the phone number";
    public static final String PHONE_NUMBER_INVALID = "Please enter a valid phone number";
    public static final String PHONE_NUMBER_NUM_ONLY = "Please enter numbers only";

    public static final int EMAIL_ADDRESS_MAX_LENGTH = 60;
    public static final String EMAIL_ADDRESS_MAX_LENGTH_TEXT = "Max " + EMAIL_ADDRESS_MAX_LENGTH + " characters";
    public static final String EMAIL_ADDRESS_INVALID = "Email address contains invalid characters";
    public static final String EMAIL_ADDRESS_MISSING = "Please enter the email address";
    public static final String EMAIL_MATCHING_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static final String DATE_RECEIVED_MISSING = "Please enter date";
    public static final String DATE_RECEIVED_INVALID = "Invalid date";

    public static final String FILE_NAME = "hpt150030.txt";

    public static final String RECORD_SAVED = "Record saved successfully";
    public static final String RECORD_EXISTS = "Customer with that name already exists. Could not save record";
    public static final String NO_RECORDS = "No customer records found";
    public static final String RECORD_NOT_FOUND = "Record with that name not found";
    public static final String RECORD_DELETED = "Record deleted successfully";
    public static final String NOTHING_SELECTED = "No record selected for deleting";
}

/*
 This class is the Object representation of the Customer details that are entered into the form.
 One object of this class represents the details of one customer.
 */
class CustomerDetailsBean {

    public CustomerDetailsBean(String firstName, String lastName, String middleName, String addressLine1, String addressLine2, String city, String state, String zipCode, String phoneNumber, String emailAddress, String proofAttached, String date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.proofAttached = proofAttached;
        this.date = date;
    }

    @Override
    public String toString() {
        return firstName + "\t" + lastName + "\t" + middleName + "\t" + addressLine1 + "\t" + addressLine2 + "\t" + city + "\t" + state + "\t" + zipCode + "\t" + phoneNumber + "\t" + emailAddress + "\t" + proofAttached + "\t" + date;
    }
    private String firstName;
    private String lastName;
    private String middleName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String emailAddress;
    private String proofAttached;
    private String date;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getProofAttached() {
        return proofAttached;
    }

    public void setProofAttached(String proofAttached) {
        this.proofAttached = proofAttached;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

/*
 This class will handle all the operations related to data initialization, insertion, deletion and updation.
 This class is static so that there is only one instance of the data members throughout the run time of the application.
 Having static helps access to data, application wise, suring anytime of the application run time.
 */
class CustomerDataHandler {

    public static ArrayList<CustomerDetailsBean> list;
    private static File file;
    private static FileReader fileReader;
    private static BufferedReader bufferedReader;
    private static FileWriter fileWriter;
    private static BufferedWriter bufferedWriter;
    private static PrintWriter printWriter;
    private static DefaultTableModel model;

    /*
     This method has been defined so as to read the data from the file whenever the Application starts.
     Using the read data, this method will initialize the JTable and our ArrayList.
     */
    public static void initializeData(JTable table) {
        list = new ArrayList<>();
        model = (DefaultTableModel) table.getModel();
        //Searching for the txt file which will be in the same working directory as the java file
        String currentDirectory = System.getProperty("user.dir");
        file = new File(currentDirectory + "/" + Constants.FILE_NAME);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String s = bufferedReader.readLine();

            if (s == null) {
                //No initialization of table is required
            } else {
                //Populating the arraylist
                while (s != null) {
                    String record = s;
                    String[] data = s.split("\t");
                    CustomerDetailsBean bean = new CustomerDetailsBean(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9], data[10], data[11]);
                    list.add(bean);
                    model.addRow(new Object[]{data[1] + ", " + data[0] + " " + data[2], data[8]});
                    s = bufferedReader.readLine();
                }
            }

        } catch (IOException e) {
        }

    }

    /*
     This method will return the following codes depending upon the data to be inserted
     This method has been defined to handle the Insertion of data operation
     0: Data has been inserted successfully
     -1: Data is already present in the database
     */
    public static int insertData(JTable table, String firstName, String lastName, String middleName, String addressLine1, String addressLine2, String city, String state, String zipCode, String phoneNumber, String emailAddress, String proofAttached, String date) {
        if (list.isEmpty()) {
            CustomerDetailsBean bean = new CustomerDetailsBean(firstName, lastName, middleName, addressLine1, addressLine2, city, state, zipCode, phoneNumber, emailAddress, proofAttached, date);
            list.add(bean);
            model.addRow(new Object[]{lastName + ", " + firstName + " " + middleName, phoneNumber});
            return 0;
        }

        for (CustomerDetailsBean bean : list) {
            if (bean.getFirstName().equalsIgnoreCase(firstName) && bean.getMiddleName().equalsIgnoreCase(middleName) && bean.getLastName().equalsIgnoreCase(lastName)) {
                return -1;
            }
        }

        CustomerDetailsBean bean = new CustomerDetailsBean(firstName, lastName, middleName, addressLine1, addressLine2, city, state, zipCode, phoneNumber, emailAddress, proofAttached, date);
        list.add(bean);
        model.addRow(new Object[]{lastName + ", " + firstName + " " + middleName, phoneNumber});
        return 0;
    }

    /*
     This method is defined to handle the Delete operation
     This method will return the following codes depending upon the result of the operation performed
     0: Success
     -1: No Records found
     -2: Data not found in our list
     */
    public static int deleteData(JTable table) {
        if (list.isEmpty()) {
            return -1;
        }

        String name = (String) model.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 0);
        String phoneNumber = (String) model.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 1);
        String[] mainName = name.split(", ");
        String lastName = mainName[0];
        String[] names = mainName[1].split(" ");
        String firstName = names[0];
        String middleName;
        if (names.length == 1) {
            middleName = "";
        } else {
            middleName = names[1];
        }

        for (int i = 0; i < list.size(); i++) {
            CustomerDetailsBean bean = list.get(i);
            if (bean.getFirstName().equalsIgnoreCase(firstName) && bean.getMiddleName().equalsIgnoreCase(middleName) && bean.getLastName().equalsIgnoreCase(lastName) && bean.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                list.remove(i);
                int j = table.convertRowIndexToModel(table.getSelectedRow());
                model.removeRow(j);
                return 0;
            }
        }
        return -2;
    }
    /*
     This method is used to handle operation of Updating the data
     This method will return codes depending upon the result of the operation performed
     0: Success
     -1: No records found
     -2: Data not found in the list
     -3: Same record already exists
     */

    public static int updateData(JTable table, String firstName, String lastName, String middleName, String addressLine1, String addressLine2, String city, String state, String zipCode, String phoneNumber, String emailAddress, String proofAttached, String date) {
        if (list.isEmpty()) {
            return -1;
        }

        String name = (String) model.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 0);
        String recordPhoneNumber = (String) model.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 1);
        String[] mainName = name.split(", ");
        String recordLastName = mainName[0];
        String[] names = mainName[1].split(" ");
        String recordFirstName = names[0];
        String recordMiddleName;
        if (names.length == 1) {
            recordMiddleName = "";
        } else {
            recordMiddleName = names[1];
        }

        for (int i = 0; i < list.size(); i++) {
            CustomerDetailsBean bean = list.get(i);
            if (bean.getFirstName().equalsIgnoreCase(recordFirstName) && bean.getMiddleName().equalsIgnoreCase(recordMiddleName) && bean.getLastName().equalsIgnoreCase(recordLastName) && bean.getPhoneNumber().equalsIgnoreCase(recordPhoneNumber)) {

                CustomerDetailsBean data = new CustomerDetailsBean(firstName, lastName, middleName, addressLine1, addressLine2, city, state, zipCode, phoneNumber, emailAddress, proofAttached, date);

                list.remove(bean);
                list.add(data);

                model.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
                model.addRow(new Object[]{lastName + ", " + firstName + " " + middleName, phoneNumber});

                table.getSelectionModel().clearSelection();
                return 0;
            }
        }

        return -2;
    }

    /*
     This method is defined so write back the data to the file when the Application is to be closed.
     This method will return codes based on the result of the operation performed.
     0: Success
     -1: Error initializing the writer for the file (Data might be lost)
     */
    public static int wrapUp() {

        try {
            fileWriter = new FileWriter(file);//True parameter not included as we have to replace the contents
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter, true);
        } catch (Exception e) {
            return -1;
        }

        for (int i = 0; i < list.size(); i++) {
            CustomerDetailsBean bean = list.get(i);
            printWriter.println(bean.toString());
        }

        return 0;
    }
}
