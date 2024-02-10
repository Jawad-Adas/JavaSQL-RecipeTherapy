package recipetherapy;

import java.sql.ResultSet;
import java.util.*;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class HomePage extends javax.swing.JFrame {

    
    myDBCon dbCon;
    ResultSet rs;
    List<Integer> idList = new ArrayList<>();
    int user_id;

    public HomePage(int user_id, int UserType) {
        initComponents();
        this.setLocationRelativeTo(null);
        dbCon = new myDBCon();
        this.user_id = user_id;
        
        if(UserType == 0){
            jMenuBar1.add(adminControl);
        }
        
        try{
        UpdateList(favoriteCb.isSelected());
        }
        catch(SQLException e){
            javax.swing.JLabel label = new javax.swing.JLabel("SQL ErroR." + e.getMessage());
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        OrderByBox = new javax.swing.JComboBox<>();
        CategoryBox = new javax.swing.JComboBox<>();
        searchBtn = new javax.swing.JButton();
        viewButton = new javax.swing.JButton();
        favoriteCb = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        adminControl = new javax.swing.JMenu();
        fileMenu = new javax.swing.JMenu();
        logoutItem = new javax.swing.JMenuItem();
        createrecipeMenuItem = new javax.swing.JMenuItem();
        myrecipesMenuItem = new javax.swing.JMenuItem();
        addUser = new javax.swing.JMenuItem();
        editUser = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(222, 232, 250));

        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel1.setText("Order by");

        jLabel2.setText("Category");

        jLabel3.setText("Search:");

        OrderByBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Recipe_Name", "Chef", "Cook_Time", "Rating" }));
        OrderByBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderByBoxActionPerformed(evt);
            }
        });

        CategoryBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Breakfast", "Lunch", "Dinner", "Main Dish", "Appetizer" }));
        CategoryBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoryBoxActionPerformed(evt);
            }
        });

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        viewButton.setText("View");
        viewButton.setName("viewButton"); // NOI18N
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        favoriteCb.setText("Favorites");
        favoriteCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                favoriteCbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(OrderByBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(CategoryBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 11, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(searchBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(favoriteCb))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(viewButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OrderByBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CategoryBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBtn)
                    .addComponent(favoriteCb))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(viewButton)
                .addGap(24, 24, 24))
        );

        OrderByBox.getAccessibleContext().setAccessibleName("");

        jMenu2.setText("Recipe");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        
        
        fileMenu.setText("File");
        fileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });
        
        
        logoutItem.setText("Logout");
        logoutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutItemAction(evt);
            }
        });
        
        fileMenu.add(logoutItem);
        
        
        adminControl.setText("Edit Users");
        adminControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });
        
        addUser.setText("Add User");
        addUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserActionPerformed(evt);
            }
        });
        
        editUser.setText("Update/Delete User");
        editUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDeleteActionPerformed(evt);
            }
        });
        
        adminControl.add(addUser);
        adminControl.add(editUser);
        
        createrecipeMenuItem.setText("Create New");
        createrecipeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createrecipeMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(createrecipeMenuItem);

        myrecipesMenuItem.setText("My Recipes");
        myrecipesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myrecipesMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(myrecipesMenuItem);
        
        jMenuBar1.add(fileMenu);
        jMenuBar1.add(jMenu2);
        

        setJMenuBar(jMenuBar1);

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

    private void CategoryBoxActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        try{
        UpdateList(favoriteCb.isSelected());
        }
        catch(SQLException e){
             javax.swing.JLabel label = new javax.swing.JLabel("SQL ErroR." + e.getMessage());
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }                                           

    private void OrderByBoxActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        try{
            UpdateList(favoriteCb.isSelected());
        }
        catch(SQLException e){
            javax.swing.JLabel label = new javax.swing.JLabel("SQL ErroR." + e.getMessage());
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }                                          

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try{
            UpdateList(favoriteCb.isSelected());
        }
        catch(SQLException e){
             javax.swing.JLabel label = new javax.swing.JLabel("SQL ErroR." + e.getMessage());
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }                                         

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {                                    
        // TODO add your handling code here:
    }                                   

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
       if (jList1.getSelectedIndex() != -1){//if list item is selected
           int id = idList.get(jList1.getSelectedIndex());
           
           new RecipeView(id, user_id/*pass the user_id*/).show();
       }
       else{//if no list item is selected
           javax.swing.JLabel label = new javax.swing.JLabel("No Recipe Selected");
           label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
           JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
       }
           
    }                                          

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
       
    }                                      

    private void createrecipeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
         new AddRecipeView(user_id).setVisible(true);
    }         
    
    
    private void addUserActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
         new SignUpForm(0).setVisible(true);
    }  
    
    private void updateDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
        new UpdateDeleteUser().setVisible(true);
         
    }  
   

    private void favoriteCbActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        try{
        UpdateList(favoriteCb.isSelected());
        }
        catch(SQLException e){
            javax.swing.JLabel label = new javax.swing.JLabel("SQL ErroR." + e.getMessage());
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }                                          

    private void myrecipesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
        new MyRecipesView(user_id).setVisible(true);
    }     
    
    
    private void logoutItemAction(java.awt.event.ActionEvent evt) {                                                  
        (new LoginForm()).setVisible(true);
        this.dispose();
        
    }    

    //mehtod to update the JList for Recipes
    void UpdateList(boolean isFav) throws SQLException{
        String orderby = OrderByBox.getSelectedItem().toString();
        String category = CategoryBox.getSelectedItem().toString();
        String search = searchField.getText();
        String query;  
        if (!isFav){//if not fav, get all recipes   

            if (category.isBlank()){ //query without category
                query = "SELECT R.id id, R.recipe_name name, R.category, R.cook_time, C.country_name cname, U.name AS chef, AVG(RR.rating) rating" +
                    " FROM recipe R" +
                    " JOIN country C ON C.id = R.country_id" +
                    " JOIN \"User\" U ON U.id = R.user_id" +
                    " LEFT JOIN recipe_rates RR ON RR.recipe_id = R.id" +
                    " WHERE R.recipe_name LIKE '%" + search + "%' " +
                    " GROUP BY R.id, R.recipe_name, R.category, R.cook_time, C.country_name, U.name\n" +
                    " ORDER BY " + orderby;  
            }
            else{//query with category
               
                query = "SELECT R.id id, R.recipe_name name, R.category, R.cook_time, C.country_name cname, U.name AS chef, AVG(RR.rating) rating" +
                    " FROM recipe R" +
                    " JOIN country C ON C.id = R.country_id" +
                    " JOIN \"User\" U ON U.id = R.user_id" +
                    " LEFT JOIN recipe_rates RR ON RR.recipe_id = R.id" +
                    " WHERE R.recipe_name LIKE '%" + search + "%' " +
                    " AND R.category = '" + category +                                              
                    "' GROUP BY R.id, R.recipe_name, R.category, R.cook_time, C.country_name, U.name\n" +
                    " ORDER BY " + orderby;
                
            }
        }
        else{//isFav
            if (category.isBlank()){//query without category
            query = "SELECT R.id id, R.recipe_name name, R.category, R.cook_time, C.country_name cname, U.name AS chef, AVG(RR.rating) rating" +
                    " FROM recipe R" +
                    " JOIN country C ON C.id = R.country_id" +
                    " JOIN user_fav_recipe F ON F.recipe_id = R.id" +
                    " JOIN \"User\" U ON U.id = R.user_id" +
                    " LEFT JOIN recipe_rates RR ON RR.recipe_id = R.id" +
                    " WHERE F.user_id = 5" +
                    " AND R.recipe_name LIKE '%" + search + "%' "    +
                    " GROUP BY R.id, R.recipe_name, R.category, R.cook_time, C.country_name, U.name\n" +
                    " ORDER BY " + orderby; 
            }
            else{//query with category
                query =  
                "SELECT R.id AS id, R.recipe_name name, R.category, R.cook_time, C.country_name cname, U.name AS chef, AVG(RR.rating) rating" +
                    " FROM recipe R" +
                    " JOIN country C ON C.id = R.country_id" +
                    " JOIN user_fav_recipe F ON F.recipe_id = R.id" +
                    " JOIN \"User\" U ON U.id = R.user_id" +
                    " LEFT JOIN recipe_rates RR ON RR.recipe_id = R.id" +
                    " WHERE F.user_id = 5" +
                    " AND R.recipe_name LIKE '%" + search + "%' " +
                    " AND R.category = '" + category +                      
                    "' GROUP BY R.id, R.recipe_name, R.category, R.cook_time, C.country_name, U.name\n" +
                    " ORDER BY " + orderby; 
            }
            
        }
            
        rs = dbCon.executeStatement(query);
        idList = new ArrayList<>();

        Vector<String> recipeList = new Vector<>();
        while(rs.next()){
            
            //create recipe using resultset
            //public Recipe(int recipe_id, String chef_name, String name, String category, String country, String cook_time) {
            Recipe recipe = new Recipe(rs.getInt("id"), rs.getString("chef"), rs.getString("name"), rs.getString("category"),rs.getString("cname"), rs.getInt("cook_time"), rs.getFloat("rating"));    
             recipeList.add(recipe.toString());
            //add recipe_id to list of integers. 
            //Each id in this list corresponds to the recipe in the String Vector of recipes
            
            idList.add(recipe.getRecipe_id());
        }
        //use the vector of String recipe data to set list data
        jList1.setListData(recipeList);
        
    }
    
    // Variables declaration - do not modify                     
    private javax.swing.JComboBox<String> CategoryBox;
    private javax.swing.JComboBox<String> OrderByBox;
    private javax.swing.JMenuItem createrecipeMenuItem;
    private javax.swing.JCheckBox favoriteCb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu adminControl;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem myrecipesMenuItem;
    private javax.swing.JMenuItem logoutItem;
    private javax.swing.JMenuItem addUser;
    private javax.swing.JMenuItem editUser;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton viewButton;
    // End of variables declaration                   
}
