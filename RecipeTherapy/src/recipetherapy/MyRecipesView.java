
package recipetherapy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

public class MyRecipesView extends javax.swing.JFrame {

    
    myDBCon dbCon;
    ResultSet rs;
    int user_id;
    List<Integer> idList = new ArrayList<>();
    
    public MyRecipesView(int user_id) {
        initComponents();
        this.setLocationRelativeTo(null);  
        dbCon = new myDBCon();
        this.user_id = user_id;
        try{
            UpdateList(jCheckBox1.isSelected());
        }
        catch(SQLException e){
            javax.swing.JLabel label = new javax.swing.JLabel("SQL ErroR." + e.getMessage());
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);            
            
        }    }

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
        jCheckBox1 = new javax.swing.JCheckBox();
        recipenameLabel1 = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

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

        jCheckBox1.setText("Favorites");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        recipenameLabel1.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        recipenameLabel1.setForeground(new java.awt.Color(0, 0, 51));
        recipenameLabel1.setText("My Recipies");

        deleteButton.setText("Delete");
        deleteButton.setName("viewButton"); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
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
                                .addGap(0, 33, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(searchBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox1))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(viewButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteButton)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(recipenameLabel1)
                .addGap(192, 192, 192))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(recipenameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
                    .addComponent(jCheckBox1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewButton)
                    .addComponent(deleteButton))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {                                    
        // TODO add your handling code here:
    }                                   

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void OrderByBoxActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        try{
            UpdateList(jCheckBox1.isSelected());
        }
        catch(SQLException e){
            javax.swing.JLabel label = new javax.swing.JLabel("SQL ErroR." + e.getMessage());
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
        }        
    }                                          

    private void CategoryBoxActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        try{
            UpdateList(jCheckBox1.isSelected());
        }
        catch(SQLException e){
            javax.swing.JLabel label = new javax.swing.JLabel("SQL ErroR." + e.getMessage());
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
        }        
    }                                           

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:

        try{
            UpdateList(jCheckBox1.isSelected());
        }
        catch(SQLException e){
            javax.swing.JLabel label = new javax.swing.JLabel("SQL ErroR." + e.getMessage());
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }                                         

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        if (jList1.getSelectedIndex() != -1){
            int id = idList.get(jList1.getSelectedIndex());
            new RecipeView(id, user_id/*pass the user_id*/).show();
        }
        else{
            javax.swing.JLabel label = new javax.swing.JLabel("No Recipe Selected");
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }                                          

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:

        try{
            UpdateList(jCheckBox1.isSelected());
        }
        catch(SQLException e){
            javax.swing.JLabel label = new javax.swing.JLabel("SQL ErroR." + e.getMessage());
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }                                          

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        try{
        if (jList1.getSelectedIndex() != -1){
            int id = idList.get(jList1.getSelectedIndex());
            dbCon.executeStatement("delete from user_fav_recipe where recipe_id = " + id);                        
            dbCon.executeStatement("delete from recipe_rates where recipe_id = " + id);            
            dbCon.executeStatement("delete from recipe_ingredient where recipe_id = " + id);
            dbCon.executeStatement("delete from recipe where id = " + id);            
            
        }
        else{
            javax.swing.JLabel label = new javax.swing.JLabel("No Recipe Selected");
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        }
        catch(SQLException e){
            javax.swing.JLabel label = new javax.swing.JLabel("SQL ErroR." + e.getMessage());
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        try{
            UpdateList(jCheckBox1.isSelected());
        }
        catch(SQLException e){
            javax.swing.JLabel label = new javax.swing.JLabel("SQL ErroR." + e.getMessage());
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
        }               
        
    }                                            

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
                    " AND R.user_id = " + user_id +    
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
                    "' AND R.user_id = " + user_id +                        
                    " GROUP BY R.id, R.recipe_name, R.category, R.cook_time, C.country_name, U.name\n" +
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
                    " WHERE F.user_id = " + user_id +
                    " AND R.recipe_name LIKE '%" + search + "%' " +
                    " AND R.user_id = " + user_id +                     
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
                    " WHERE F.user_id = "+ user_id +
                    " AND R.recipe_name LIKE '%" + search + "%' " +
                    " AND R.user_id = " + user_id +                         
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
            Recipe recipe = new Recipe(rs.getInt("id"), rs.getString("chef"),
                    rs.getString("name"), rs.getString("category"),rs.getString("cname"),
                    rs.getInt("cook_time"), rs.getFloat("rating"));    
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
    private javax.swing.JButton deleteButton;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel recipenameLabel1;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton viewButton;
    // End of variables declaration                   
}
