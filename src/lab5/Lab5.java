package lab5;
import java.sql.*;
import java.util.Scanner;
public class Lab5 {
    String Values[]  = new String[100];   
public Lab5(){
}
public String[] Select(String Entity,String attribute,String Stipulation) throws SQLException{
       Connection c = null;     
try {       
	Class.forName("org.sqlite.JDBC");       
	c = DriverManager.getConnection("jdbc:sqlite:wb.db");     
    } 
catch ( Exception e ) 	{      
	 System.err.println("Problem Encountered");     
    }     
Statement stmt = null;
stmt = c.createStatement();
String test = "Select " + attribute + " FROM " + Entity + " WHERE " + Stipulation + ";";
//System.out.println( test );

ResultSet rs = stmt.executeQuery( test );
int i = 0;
while ( rs.next() ) {
Values[i] =  ( rs.getString(attribute) );
System.out.println(Values[i]);

i = i+1;
}
return Values;        
}
public void CreateTable(String Command){
Connection c = null;
try {       
	Class.forName("org.sqlite.JDBC");       
	c = DriverManager.getConnection("jdbc:sqlite:wb3.db");     
    } 
catch ( Exception e ) 	{      
	 System.err.println("Problem Encountered");     
    }    
Statement stmt = null;
    try {
      stmt = c.createStatement();
      String sql = Command; 
      stmt.executeUpdate(sql);
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Table created successfully");
}
public void Insert(String Entity,String attribute, String updatedval){
           Connection c = null;     
try {       
	Class.forName("org.sqlite.JDBC");       
	c = DriverManager.getConnection("jdbc:sqlite:wb.db");     
    } 
catch ( Exception e ) 	{      
	 System.err.println("Problem Encountered");     
    }     
Statement stmt = null;
    try {
      
      stmt = c.createStatement();
      String sql = "INSERT INTO "+Entity + " " + "("+ attribute + ")" + " VALUES " +  "('" + updatedval + "');"  ; 
      c.setAutoCommit(false);
      stmt.executeUpdate(sql);
      stmt.close();
      c.commit();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Inserted successfully");

}
public void Delete(String Entity,String attribute, String delval){
    Connection c = null;     
        try {       
            Class.forName("org.sqlite.JDBC");       
            c = DriverManager.getConnection("jdbc:sqlite:wb.db");     
        } 
        catch ( Exception e ) 	{      
            System.err.println("Problem Encountered");     
        }    
    Statement stmt = null;
    try {
      stmt = c.createStatement();
      String sql = "DELETE FROM "+Entity + " WHERE " + attribute + " = " +  "'" + delval + "'" ;
      c.setAutoCommit(false);
      stmt.executeUpdate(sql);
      c.commit();     
      stmt.close();
      c.close();
    } catch ( SQLException e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Delete successfully");
}
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws SQLException {
 Lab5 Jamal;     
 Jamal = new Lab5() ;

 int runner =1;
 while (runner != 0){
 System.out.println("\nWelcome to the World Billionaires DB");
 System.out.println("Please select one of the folowing options");
 System.out.println("1: Query 2: Insert 3: Delete 4: Create Table 5: Exit");

 Scanner s = new Scanner(System.in);
 int i = s.nextInt();
if (i == 1){
        System.out.println("Please enter the entity for which you wish to Query");
        Scanner s2 = new Scanner(System.in);
        String ent1 = s2.next();
        System.out.println("Please enter the attribute for which you wish to Query");
        Scanner s3 = new Scanner(System.in);
        String attr1 = s2.next();
        System.out.println("Please enter the stipulatoin for which you wish to Query");
        Scanner s4 = new Scanner(System.in);
        String stiper = s2.next();
        stiper+= s2.nextLine();
        String[] answer = (Jamal.Select(ent1, attr1,stiper) ) ;
        int i2 = 0;
        String returner = null;
        for (i2 =0 ; i2<100; i2++){
            if (answer[i] != null){
                returner = " " + returner + answer[i];
            }
        }
    
}

if (i == 2){
    System.out.println("Please enter the entity for which you wish to insert into");
    Scanner s2 = new Scanner(System.in);
    String ent2 = s2.next();
    
    System.out.println("Please enter the attribute for which you wish to insert into");
    Scanner s3 = new Scanner(System.in);
    String attr2 = s3.next();
    
    System.out.println("Please enter the value you wish to instert into " + attr2);
    Scanner s4 = new Scanner(System.in);
    String val = s4.next();
    Jamal.Insert(ent2,attr2,val);

}
if (i == 3){
    System.out.println("Please enter the entity of where you wish to delete ");
    Scanner s2 = new Scanner(System.in);
    String ent3 = s2.next();
    
    System.out.println("Please enter the attribute of where you wish to delete");
    Scanner s3 = new Scanner(System.in);
    String attr3 = s3.next();
    
    System.out.println("Please enter the value you wish to Delete in " + attr3);
    Scanner s4 = new Scanner(System.in);
    String val = s4.next();
    Jamal.Delete(ent3,attr3,val);
}
if (i ==4){
    System.out.println("Please enter the Name of the table you wish to create and all the attibutes and keys" );
    Scanner s2 = new Scanner(System.in);
    String table = s2.next();
    Jamal.CreateTable( table);
}
    
    if (i ==5){
    runner = 0;
}}}}

