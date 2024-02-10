
package recipetherapy;

import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import javax.swing.JFileChooser;
import java.sql.PreparedStatement;




public class AddRecipeView extends javax.swing.JFrame {

    /**
     * Creates new form AddRecipeView
     */
    
    
    myDBCon dbCon;
    ResultSet rs;
    int UserId;
    File selectedFile;
    List<Integer> countryIds;
    List<Integer> ingredientIds;
    List<Integer> addedingredientIds;    
    List<AddedIngredient> addedIngredients;
    Vector<String> addedingredientNames;
    List<String> IngredientTypes;
    

    
    

    
    
    public class AddedIngredient{
        int id;
        int quantity;
        String name;
        String type;

        @Override
        public String toString() {
            return  name + ": " + quantity + " " + type;
        }
        
        AddedIngredient(int id, String name, int quantity, String type){
            this.id = id;
            this.quantity = quantity;
            this.name = name;
            this.type = type;
        }
        
        String getname(){
            return this.name;
        }
        String gettype(){
            return this.type;
        }
        int getquantity(){
            return this.quantity;
        }
        int getid(){
            return this.id;
        }

    }

    
    public AddRecipeView(int UserId) {
        initComponents();
        dbCon = new myDBCon();
        this.setLocationRelativeTo(null);  
        this.UserId = UserId;
        addedingredientNames = new Vector<>();
        addedIngredients =  new ArrayList<>();
        addedingredientIds = new ArrayList<>();
        setCountries();
        populateData();
    }
    
    void populateData(){
        try {
            String prepstmt = "SELECT ingredient_name, id, UNIT_OF_MEASURE FROM ingredient";
            rs = dbCon.executeStatement(prepstmt);
            ingredientIds = new ArrayList<>();
            IngredientTypes = new ArrayList<>();
            while(rs.next()){
                cmbIngredient.addItem(rs.getString("ingredient_name"));
                ingredientIds.add(rs.getInt("id"));
                IngredientTypes.add(rs.getString("UNIT_OF_MEASURE"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AddRecipeView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cooktimeLabel1 = new javax.swing.JLabel();
        countryLabel = new javax.swing.JLabel();
        caloriesLabel = new javax.swing.JLabel();
        proteinLabel = new javax.swing.JLabel();
        carbsLabel = new javax.swing.JLabel();
        FatsLabel = new javax.swing.JLabel();
        recipenameLabel = new javax.swing.JLabel();
        cooktimeLabel2 = new javax.swing.JLabel();
        txtRecipeName = new javax.swing.JTextField();
        cmbCountry = new javax.swing.JComboBox<>();
        cmbIngredient = new javax.swing.JComboBox<>();
        cooktimeLabel3 = new javax.swing.JLabel();
        spinnerQuantity = new javax.swing.JSpinner();
        cooktimeLabel4 = new javax.swing.JLabel();
        btnAddRecipe = new javax.swing.JButton();
        btnAddIngredient = new javax.swing.JButton();
        cmbCategory = new javax.swing.JComboBox<>();
        countryLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInstructions = new javax.swing.JTextArea();
        countryLabel2 = new javax.swing.JLabel();
        uploadButton = new javax.swing.JButton();
        imageLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        IngredientsList = new javax.swing.JList<>();
        cooktimeSpinner = new javax.swing.JSpinner();
        caloriesSpinner = new javax.swing.JSpinner();
        proteinSpinner = new javax.swing.JSpinner();
        carbsSpinner = new javax.swing.JSpinner();
        fatsSpinner = new javax.swing.JSpinner();
        removeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(222, 232, 250));

        cooktimeLabel1.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        cooktimeLabel1.setForeground(new java.awt.Color(0, 0, 0));
        cooktimeLabel1.setText("Cook Time: ");

        countryLabel.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        countryLabel.setForeground(new java.awt.Color(0, 0, 0));
        countryLabel.setText("Country: ");

        caloriesLabel.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        caloriesLabel.setForeground(new java.awt.Color(0, 0, 0));
        caloriesLabel.setText("Calories: ");

        proteinLabel.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        proteinLabel.setForeground(new java.awt.Color(0, 0, 0));
        proteinLabel.setText("Protein: ");

        carbsLabel.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        carbsLabel.setForeground(new java.awt.Color(0, 0, 0));
        carbsLabel.setText("Carbohydrates: ");

        FatsLabel.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        FatsLabel.setForeground(new java.awt.Color(0, 0, 0));
        FatsLabel.setText("Fats: ");

        recipenameLabel.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        recipenameLabel.setForeground(new java.awt.Color(0, 0, 51));
        recipenameLabel.setText("Create Recipe");

        cooktimeLabel2.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        cooktimeLabel2.setForeground(new java.awt.Color(0, 0, 0));
        cooktimeLabel2.setText("Recipe Name:");

        txtRecipeName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRecipeNameActionPerformed(evt);
            }
        });

        cmbCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCountryActionPerformed(evt);
            }
        });

        cmbIngredient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIngredientActionPerformed(evt);
            }
        });

        cooktimeLabel3.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        cooktimeLabel3.setForeground(new java.awt.Color(0, 0, 0));
        cooktimeLabel3.setText("Ingredient:");

        cooktimeLabel4.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        cooktimeLabel4.setForeground(new java.awt.Color(0, 0, 0));
        cooktimeLabel4.setText("Quantity:");

        btnAddRecipe.setText("Add Recipe");
        btnAddRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRecipeActionPerformed(evt);
            }
        });

        btnAddIngredient.setText("Add Ingredient");
        btnAddIngredient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddIngredientActionPerformed(evt);
            }
        });

        cmbCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Breakfast", "Lunch", "Dinner", "Dessert", "Appetizer", "Main Dish" }));
        cmbCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoryActionPerformed(evt);
            }
        });

        countryLabel1.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        countryLabel1.setForeground(new java.awt.Color(0, 0, 0));
        countryLabel1.setText("Category:");

        txtInstructions.setColumns(20);
        txtInstructions.setRows(5);
        jScrollPane1.setViewportView(txtInstructions);

        countryLabel2.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        countryLabel2.setForeground(new java.awt.Color(0, 0, 0));
        countryLabel2.setText("Instructions:");

        uploadButton.setText("Upload Image");
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });

        imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recipetherapy/image_1.jpg"))); // NOI18N

        jScrollPane2.setViewportView(IngredientsList);

        cooktimeSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        caloriesSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        proteinSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        carbsSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        fatsSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        removeBtn.setText("Remove Ingredient");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnAddRecipe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(uploadButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(caloriesLabel)
                                        .addComponent(carbsLabel)
                                        .addComponent(proteinLabel)
                                        .addComponent(FatsLabel)
                                        .addComponent(countryLabel)
                                        .addComponent(countryLabel1))
                                    .addGap(29, 29, 29)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cmbCountry, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(fatsSpinner)
                                            .addComponent(carbsSpinner, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(proteinSpinner))
                                        .addComponent(caloriesSpinner)))
                                .addComponent(imageLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cooktimeLabel1)
                                    .addComponent(cooktimeLabel2))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtRecipeName, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(cooktimeSpinner))))))
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(btnAddIngredient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(removeBtn))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(countryLabel2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cooktimeLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cooktimeLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbIngredient, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(spinnerQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(51, 51, 51))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 88, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(recipenameLabel)
                .addGap(242, 242, 242))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(recipenameLabel)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cooktimeLabel2)
                            .addComponent(txtRecipeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbIngredient, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cooktimeLabel3))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spinnerQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cooktimeLabel4))
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cooktimeLabel1)
                            .addComponent(cooktimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddIngredient, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(caloriesLabel)
                            .addComponent(caloriesSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(proteinLabel)
                            .addComponent(proteinSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(carbsLabel)
                            .addComponent(carbsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FatsLabel)
                            .addComponent(fatsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(countryLabel)
                            .addComponent(cmbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(countryLabel1))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddRecipe)
                            .addComponent(uploadButton)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(countryLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void txtRecipeNameActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void cmbCountryActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void cmbIngredientActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void btnAddRecipeActionPerformed(java.awt.event.ActionEvent evt) {                                             
        
        if(txtRecipeName.getText().isBlank()){
            javax.swing.JLabel label = new javax.swing.JLabel("Error Adding the Recipe: Recipe Name is empty");
            label.setFont(new java.awt.Font("Ariel", java.awt.Font.BOLD,18));
            JOptionPane.showMessageDialog(null, label, "Success", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if(txtInstructions.getText().isBlank()){
            javax.swing.JLabel label = new javax.swing.JLabel("Error Adding the Recipe " + txtRecipeName.getText().trim() +". Instructions empty");
            label.setFont(new java.awt.Font("Ariel", java.awt.Font.BOLD,18));
            JOptionPane.showMessageDialog(null, label, "Success", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        int result=0;
        try {                                             
            
            
            int CountryID = countryIds.get(cmbCountry.getSelectedIndex());
                      
            
            String pstmt = "INSERT INTO recipe(recipe_name, cook_time, category, instruction, calories, protein, fats, carbs, country_id, user_id, image) VALUES('"
                    + txtRecipeName.getText().trim() + "', "
                    + cooktimeSpinner.getValue() + ", '"
                    + cmbCategory.getSelectedItem() +"', '"
                    + txtInstructions.getText().trim() + "', "
                    + caloriesSpinner.getValue() + ", "
                    + proteinSpinner.getValue() + ", "
                    + fatsSpinner.getValue() + ", "
                    + carbsSpinner.getValue() + ", "
                    + CountryID + ", "
                    + UserId + ", ?)";
            PreparedStatement prepstmt = dbCon.con.prepareStatement(pstmt);
                        
                if (selectedFile != null){//if file is selected
                    try(InputStream inputStream = new FileInputStream(selectedFile)){
                        prepstmt.setBlob(1, inputStream);
                        result = prepstmt.executeUpdate();
                        
                        if(result>0){
                            javax.swing.JLabel label = new javax.swing.JLabel("Recipe '" + txtRecipeName.getText().trim() + "' Added Succesfully");
                            label.setFont(new java.awt.Font("Ariel", java.awt.Font.BOLD,18));
                            JOptionPane.showMessageDialog(null, label, "Success", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            javax.swing.JLabel label = new javax.swing.JLabel("Error Adding the Recipe " + txtRecipeName.getText().trim() +". Check fields");
                            label.setFont(new java.awt.Font("Ariel", java.awt.Font.BOLD,18));
                            JOptionPane.showMessageDialog(null, label, "Success", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }catch (Exception e){}

                    

                }
                else // if file is not selected
                {
                    PreparedStatement prepStatement = dbCon.con.prepareStatement("INSERT INTO recipe(recipe_name, cook_time, category, instruction, calories, protein, fats, carbs, country_id, user_id) VALUES('"
                    + txtRecipeName.getText().trim() + "', "
                    + cooktimeSpinner.getValue() + ", '"
                    + cmbCategory.getSelectedItem() +"', '"
                    + txtInstructions.getText().trim() + "', "
                    + caloriesSpinner.getValue() + ", "
                    + proteinSpinner.getValue() + ", "
                    + fatsSpinner.getValue() + ", "
                    + carbsSpinner.getValue() + ", "
                    + CountryID + ", "
                    + UserId + ")");

                    result = prepStatement.executeUpdate();                    
                    
                    if(result>0){
                            javax.swing.JLabel label = new javax.swing.JLabel("Recipe '" + txtRecipeName.getText().trim() + "' Added Succesfully");
                            label.setFont(new java.awt.Font("Ariel", java.awt.Font.BOLD,18));
                            JOptionPane.showMessageDialog(null, label, "Success", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            javax.swing.JLabel label = new javax.swing.JLabel("Error Adding the Recipe " + txtRecipeName.getText().trim() +". Check fields");
                            label.setFont(new java.awt.Font("Ariel", java.awt.Font.BOLD,18));
                            JOptionPane.showMessageDialog(null, label, "Success", JOptionPane.INFORMATION_MESSAGE);
                        }
                }
                
                if (result>0){//recipe insertion success, insert ingredients
                    
                    String query = "Select id from recipe "
                            + "where recipe_name = '" + txtRecipeName.getText().trim() 
                            +"' and user_id = " + UserId;
                    
                    rs = dbCon.executeStatement(query);
                    
                    if (rs.next())                                           
                    for(int i=0;i<addedIngredients.size();i++){
                        query = "INSERT INTO recipe_ingredient(recipe_id, ingredient_id, quantity) VALUES("
                        + rs.getInt(1) + ", "
                        + addedIngredients.get(i).getid() + ","
                        + addedIngredients.get(i).getquantity()+")";                       
                        dbCon.executeStatement(query);
                        
                    }
                    
                    
                }
               
        

                           
           
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AddRecipeView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }                                            

    private void cmbCategoryActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void btnAddIngredientActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        
//        try {
//            int UserId = 5;       
//            String prepstmt = "Select id FROM recipe WHERE user_id =" + UserId + " AND recipe_name = '"+ txtRecipeName.getText().trim() +"'";
//            rs1 = dbCon.executeStatement(prepstmt);
//            rs1.first();
//            String recipeId = rs1.getString("id");
//            
//            
            int IngredientId = ingredientIds.get(cmbIngredient.getSelectedIndex());
            String IngredientName = cmbIngredient.getSelectedItem().toString();
            String Type = IngredientTypes.get(cmbIngredient.getSelectedIndex());
            if(!addedingredientIds.contains(IngredientId)){
                AddedIngredient ingredient = new AddedIngredient(IngredientId,IngredientName,(int)spinnerQuantity.getValue(),Type);
                addedingredientNames.add(ingredient.toString());
                addedingredientIds.add(IngredientId);
                addedIngredients.add(ingredient);
                IngredientsList.setListData(addedingredientNames);
            }
            else{
                javax.swing.JLabel label = new javax.swing.JLabel(IngredientName + " is already added");
                label.setFont(new java.awt.Font("Ariel", java.awt.Font.BOLD,18));
                JOptionPane.showMessageDialog(null, label, "Success", JOptionPane.INFORMATION_MESSAGE);
                                        
            }
            
//            prepstmt = "INSERT INTO recipe_ingredient(recipe_id, ingredient_id, quantity) VALUES("
//                    + recipeId + ", "
//                    + IngredientId + ","
//                    +spinnerQuantity.getValue() + ")";
//            
//            result = dbCon.executePrepared(prepstmt);
//            
//            if (result>0){
//                javax.swing.JLabel label = new javax.swing.JLabel("Ingredient '" + cmbIngredient.getSelectedItem() + "' Added Succesfully to " + txtRecipeName.getText().trim());
//                label.setFont(new java.awt.Font("Ariel", java.awt.Font.BOLD,14));
//                JOptionPane.showMessageDialog(null, label, "Success", JOptionPane.INFORMATION_MESSAGE);
//                
//            }else{
//                javax.swing.JLabel label = new javax.swing.JLabel("Failed to add Ingredient '" + cmbIngredient.getSelectedItem() + " to " + txtRecipeName.getText().trim());
//                label.setFont(new java.awt.Font("Ariel", java.awt.Font.BOLD,14));
//                JOptionPane.showMessageDialog(null, label, "Success", JOptionPane.INFORMATION_MESSAGE);
//                
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(AddRecipeView.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }                                                

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);

        // Get selected file
        selectedFile = fileChooser.getSelectedFile();
        try{
             InputStream inputStream = new FileInputStream(selectedFile);
             BufferedImage image = ImageIO.read(inputStream);
             Icon icon = new ImageIcon(image.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(),4));
             imageLabel.setIcon(icon);

        }
        catch (Exception e){
            javax.swing.JLabel label = new javax.swing.JLabel("Failed to upload Image");
            label.setFont(new java.awt.Font("Ariel", java.awt.Font.BOLD,14));
            JOptionPane.showMessageDialog(null, label, "Error", JOptionPane.INFORMATION_MESSAGE);     
        }
        
    }                                            

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        
        if (IngredientsList.getSelectedIndex()!=-1){
            addedingredientNames.remove(IngredientsList.getSelectedIndex());
            addedingredientIds.remove(IngredientsList.getSelectedIndex());
            addedIngredients.remove(IngredientsList.getSelectedIndex());
            IngredientsList.setListData(addedingredientNames);
        }

        
    }                                         

  
    
    void setCountries(){
        countryIds = new ArrayList<>();
        try{
            rs = dbCon.executeStatement("select * from country");
            
            while(rs.next()){

                cmbCountry.addItem(rs.getString("country_name"));
                countryIds.add(rs.getInt("id"));
                
            }
            
        }
        catch (SQLException e){
             javax.swing.JLabel label = new javax.swing.JLabel("SQL ErroR." + e.getMessage());
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE); 
        }
            
   
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel FatsLabel;
    private javax.swing.JList<String> IngredientsList;
    private javax.swing.JButton btnAddIngredient;
    private javax.swing.JButton btnAddRecipe;
    private javax.swing.JLabel caloriesLabel;
    private javax.swing.JSpinner caloriesSpinner;
    private javax.swing.JLabel carbsLabel;
    private javax.swing.JSpinner carbsSpinner;
    private javax.swing.JComboBox<String> cmbCategory;
    private javax.swing.JComboBox<String> cmbCountry;
    private javax.swing.JComboBox<String> cmbIngredient;
    private javax.swing.JLabel cooktimeLabel1;
    private javax.swing.JLabel cooktimeLabel2;
    private javax.swing.JLabel cooktimeLabel3;
    private javax.swing.JLabel cooktimeLabel4;
    private javax.swing.JSpinner cooktimeSpinner;
    private javax.swing.JLabel countryLabel;
    private javax.swing.JLabel countryLabel1;
    private javax.swing.JLabel countryLabel2;
    private javax.swing.JSpinner fatsSpinner;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel proteinLabel;
    private javax.swing.JSpinner proteinSpinner;
    private javax.swing.JLabel recipenameLabel;
    private javax.swing.JButton removeBtn;
    private javax.swing.JSpinner spinnerQuantity;
    private javax.swing.JTextArea txtInstructions;
    private javax.swing.JTextField txtRecipeName;
    private javax.swing.JButton uploadButton;
    // End of variables declaration                   
}