/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Camille
 */
import exception.ModelItemMandatoryException;
import exception.NoRecordFoundException;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class Model {
    private String tableName;
    List<ModelItem> items;
    List<String> updateFields;
    List<String> insertFields;
    
    public Model() {
        items = new ArrayList<ModelItem>();
        updateFields = new ArrayList<String>();
        insertFields = new ArrayList<String>();
        init();
    }
    
    //initialize model items here
    public abstract void init();
    
    public void retrieve(Connection con) throws Exception {
        String query = "SELECT " + getItemNames() + " FROM " + getTableName() +
                getPrimaryKeyWhereClause();
        System.out.println(query);
        PreparedStatement statement = con.prepareStatement(query);
        bindAttributesToQuery(statement, getPrimaryKeys());
        ResultSet rs = statement.executeQuery();
        try {
            boolean hasRecord = false;
            while (rs.next()) {
                hasRecord = true;
                int index = 1;
                for(ModelItem item: items) {
                    item.setValue(rs.getString(index));
                    index++;
                }
            }
            if(!hasRecord) {
                throw new NoRecordFoundException();
            }
        } finally {
            rs.close();
        }
    }
    
    public List<ModelItem> getPrimaryKeys() {
        List<ModelItem> list = new ArrayList<ModelItem>();
        for(ModelItem item: items) {
            if(item.getIsPrimaryKey()) {
                list.add(item);
            }
        }
        return list;
    }
    
    public String getPrimaryKeyWhereClause() {
        String names = " WHERE ";
        for(ModelItem item: getPrimaryKeys()) {
            names += item.getName() + " = ? AND "; 
        }
        names = names.substring(0, names.length() - 5) ;
        return names;
    }
    
    public void insert(Connection con) throws Exception {
        String query = "INSERT INTO " + getTableName() + " (" + getInsertItemNames() +
                ") VALUES(" + getInsertValuesStatement() + ");";
        System.out.println(query);
        PreparedStatement statement = con.prepareStatement(query);
        bindAttributesToQuery(statement, getInsertFields());
        statement.execute();
    }
    
    public void update(Connection con) throws Exception {
        String query = "UPDATE " + getTableName() + getUpdateSetClause() +
                getPrimaryKeyWhereClause();
        System.out.println(query);
        PreparedStatement statement = con.prepareStatement(query);
        List<ModelItem> params = getUpdateFields();
        params.addAll(getPrimaryKeys());
        bindAttributesToQuery(statement, params);
        statement.execute();
    }
    
    // Variable arguments parameter.
    public void setUpdateFields(String... fieldNames) {
        updateFields = new ArrayList<String>(Arrays.asList(fieldNames));
    }
    
    public List<ModelItem> getUpdateFields() {
        List<ModelItem> list = new ArrayList<ModelItem>();
        for(ModelItem item : items) {
            if(updateFields.contains(item.getName())) {
                list.add(item);
            }
        }
        return list;
    }
    
    public String getUpdateSetClause() {
        String names = " SET ";
        for(String item : updateFields) {
            names += item + " = ?, "; 
        }
        names = names.substring(0, names.length() - 2) ;
        return names;
    }
    
    public void setInsertFields(String... fieldNames) {
        insertFields = new ArrayList<String>(Arrays.asList(fieldNames));
    }
    
    public List<ModelItem> getInsertFields() {
        List<ModelItem> list = new ArrayList<ModelItem>();
        for(ModelItem item : items) {
            if(insertFields.contains(item.getName())) {
                list.add(item);
            }
        }
        return list;
    }
    
    public String getInsertItemNames() {
        String names = "";
        for(ModelItem item: getInsertFields()) {
            names += item.getName() + ", "; 
        }
        names = names.substring(0, names.length() - 2) ;
        return names;
    }
            
    private void bindAttributesToQuery(PreparedStatement statement, List<ModelItem> items) throws Exception {
        int index = 1;
        for(ModelItem item: items) {
            DataType type = item.getType();
            String value = null;
            if(item.getIsMandatory()) {
                if(item.getValue() == null) {
                    throw new ModelItemMandatoryException();
                }
                
                value = item.getValue().toString();
            }
            if(type == DataType.STRING) {
                statement.setString(index, value);
            } else if (type == DataType.LONG) {
                Long finalValue = value == null ? null : Long.parseLong(value);
                statement.setLong(index, finalValue);
            } else if (type == DataType.INT) {
                Integer finalValue = value == null ? null : Integer.parseInt(value);
                statement.setInt(index, finalValue);
            } else if (type == DataType.DOUBLE) {
                Double finalValue = value == null ? null : Double.parseDouble(value);
                statement.setDouble(index, finalValue);
            } /*else if (type == DataType.DATE) {
                statement.setDate(index, Long.parseLong(item.getValue().toString()));
            }*/
            index++;
        }
    }
    
    private String getItemNames() {
        String names = "";
        for(ModelItem item: items) {
            names += item.getName() + ", "; 
        }
        names = names.substring(0, names.length() - 2) ;
        return names;
    }
    
    private String getInsertValuesStatement() {
        String values = "";
        for(ModelItem item: getInsertFields()) {
            values += "?, "; 
        }
        values = values.substring(0, values.length() - 2) ;
        return values;
    }
    
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    
    public String getTableName() {
        return tableName;
    }
    
    public ModelItem addItem(String name, boolean isMandatory, DataType type, long length) {
        ModelItem item = new ModelItem(name, isMandatory, type, length);
        items.add(item);
        return item;
    }
    
    public ModelItem getItem(String name) {
        for(ModelItem item: items) {
            if(item.getName().equals(name))
                return item;
        }
        return null;
    }
}
