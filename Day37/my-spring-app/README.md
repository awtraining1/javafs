## Spring JDBC

* Lets you do database operations with less SQL statements
* Handles exceptions which we would otherwise write try catch blocks
* Transactions are easy to code

## Steps
* Create a DataSource Bean in your @configuration file
* For every domain/bean class that has an associated table in the DB,
  Create a RowMapper class.
* Create a DAO interface that lists methods/operation that we want to do
  with the table/domain class objects. Like list all rows, inserting a new row, etc. 
* Implement the above DAO interface.
* Finally, Use the DAO implementation class to do your desired operations.