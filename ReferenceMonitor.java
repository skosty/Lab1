/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package security1;


import java.util.HashMap;
import java.util.Map;


/**
 *
 * 
 */
public class ReferenceMonitor {

  static Map<SecuritySubject, SecurityLevel> Sub = new HashMap<SecuritySubject, SecurityLevel>();
  static Map<SecurityObject, SecurityLevel> Obj = new HashMap<SecurityObject, SecurityLevel>();

  public ReferenceMonitor(){
    
  }
  
  // Determine allowed operations 
//    - handle bad instruction
//    - determine allowed operations
//    - call object manager 
  public int performInstruction(Instruction i){
    
    i.print();
    
    if(i == Instruction.BadInstruction) return 0;
    
    // Perform Operation 
    if(i.type.equalsIgnoreCase("write")){
      return executeWrite(i);
    } else if(i.type.equalsIgnoreCase("read") ) {
      return executeRead(i);
    } 
   
    return 0;
  } // end PerformOperation method 
    
  
  private int executeRead(Instruction i){
    if(SecurityLevel.dominates(Obj.get(i.obj), Sub.get(i.sub))){
      System.out.println("Operation not permitted."); return 0;
    } else return ObjectManager.read(i.obj);
  }
  
  private int executeWrite(Instruction i){
    if(SecurityLevel.dominates(Sub.get(i.sub), Obj.get(i.obj))){
      System.out.println("Operation not permitted."); return 0;
    } else return ObjectManager.write(i.obj, i.parameter);
  }
  
    // ObjectManager Class 
     static class ObjectManager {
 
      public static int read(SecurityObject o){
        return o.getVal();
      } // end read 
  
      public static int write(SecurityObject o, int _val){
        o.setVal(_val);
        return 0; 
      } // end write 
  
     } // end ObjectManager class
  
}

