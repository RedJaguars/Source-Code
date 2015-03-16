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
public class ModelItem {
    private String name;
    private boolean isMandatory;
    private DataType type;
    private Object value;
    private long length;
    private boolean isPrimaryKey;
    
    public ModelItem(String name, boolean isMandatory, DataType type, long length) {
        this.name = name;
        this.isMandatory = isMandatory;
        this.type = type;
        this.length = length;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean getIsMandatory() {
        return isMandatory;
    }
    
    public long getLength() {
        return length;
    }
    
    public DataType getType() {
        return type;
    }
    
    public Object getValue() {
        return value;
    }
    
    public void setValue(Object value) {
        this.value = value;
    }
    
    public boolean getIsPrimaryKey() {
        return isPrimaryKey;
    }
    
    public void setIsPrimaryKey(boolean isPrimaryKey) {
        this.isPrimaryKey = isPrimaryKey;
    }
}
