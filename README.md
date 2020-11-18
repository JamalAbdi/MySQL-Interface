# MySQL-Interface
This program relies on a .db file which contains 25 attributes for the top 10 billionaires in the world today. The program is in Java and uses the Java SQL
library to interface the database and make SQL quiries. 

I have listed a few possible quiries and how to input them on the programs interface:  

How tall is Warren Buffet? 
Program: Enter: (1, Country_of_Origin, Country = 'USA')  
SQL: SELECT Height FROM Demographic WHERE Name = 'Warren Buffett'; 

How Much does the richest person have in billions? 
SQL: Select NetWorth FROM Wealth WHERE Rank = 1; Answer: 111 Billions USD 
Program: Enter: (1, Wealth, NetWorth, Rank = ‘1’    

What are the heights of all the men over 180cm ? 
SQL: SELECT Height FROM Demographic WHERE Height > 180; 
Program: Enter: (1, Demographic, Height, Height > 180) 

How Many Billionaires are Latin American? 
SQL: SELECT Ethnicity From Country_of_Origin WHERE Ethnicity = 'Latin American' ; 
Program: Enter: (1, Country_of_Origin, Ethnicity, Ethnicity = ‘Latin America’)  

Which Billionaires are under 50? 
SQL: SELECT Name From Demographic WHERE AGE < 50; 
Program: Enter: (1, Demographic, Name, AGE<50)

What is Bill Gates’ Social Insurance Number? 
SQL: SELECT SIN FROM Demographic WHERE Name = 'Bill Gates’ 
Program: Enter: (1, Demographic, SIN, Name = ‘Bill Gates’)

Which Billionaires live in a country with an average income less than 20k? 
SQL: SELECT NAME FROM Demographic WHERE Average_Income < 20000; Answer: Carlos Slim Helu 
Program: Enter: (1, Demographic, Name, Average_Income < 20000

What is the wealth of the Billionaires that have a net worth over 80 Billion? 
SQL: SELECT NetWorth FROM Wealth WHERE NetWorth>80; 
Program: Enter: (1, Wealth, NetWorth, NetWorth >  80; 
