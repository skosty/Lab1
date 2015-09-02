/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package security1;

/**
 *
 * 
 */
public class SecuritySubject {
  
  String name = null;
  private int TEMP; 
  
  public SecuritySubject(String _name){
    this.name = _name;
  }
  
  public String getName(){
    return name; 
  }
  
  public int getTEMP(){
    return TEMP; 
  }
 
  public void setTEMP(int _TEMP){
    this.TEMP = _TEMP;
  }
  
}
