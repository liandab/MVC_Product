
# MVC_Product_1

## Overview

MVC_Product_1 is a Java dynamic web application built using the Model-View-Controller (MVC) architectural pattern. It provides a simple interface for managing products in an e-commerce context, allowing users to perform operations such as inserting, updating, deleting, and viewing products. The application uses JSP for the view layer and Servlets for the controller layer.




## Features

- **Insert Products:** Users can add new products by entering their ID and name.
- **Update Products:** Users can update the details of existing products.
- **Delete Products:** Users can delete products by specifying their ID.Fullscreen mode
- **View Products:** Users can view the list of all products in a structured format.


# Technology Stack

- **Java:** Programming language used for backend logic.

- **JSP:** JavaServer Pages used for rendering the user interface.

- **Servlets:** Used as the controller to handle user requests and business logic.

- **MySQL:** Database used for storing product data.

- **Bootstrap:** CSS framework used for styling the web pages.


## Project Structure

MVC_Product_1/

    │
    ├── src/
    │   ├── controller/              # Contains servlet classes
    │   ├── model/                   # Contains model classes (POJOs)
    │   ├── operations/              # Contains interfaces and implementation for data operations
    │   └── db/                      # Contains database connection classes
    │
    ├── WebContent/                  # Contains web resources
    │   ├── WEB-INF/
    │   │   └── resources/           # Contains configuration and SQL query files
    │   ├── Home.jsp                 # Main interface for product management
    │   ├── showProducts.jsp         # Displays the list of products
    │   ├── result.jsp               # Displays the result of operations
    │   └── (other JSP files)        # Any additional JSP files
    │
    └── web.xml                      # Configuration file for the web application
## Setup and Installation

1. Prerequisites:

- Java Development Kit (JDK) 11 or higher
- Apache Tomcat or any other servlet container
- MySQL Database Server
- Database Setup:

2. Database Setup:
- Create a new database named `ecom`.
- Execute the following SQL script to create a `products` table

    ``` 
    CREATE TABLE products (
      pid INT PRIMARY KEY,
      pname VARCHAR(255)
    ); 

3. Configuration:
- Update the `WEB-INF/resources/config.properties` file with your database credentials.
- Make sure the database URL, username, and password are correct.

4. Run the Application:
- Deploy the project in your servlet container (e.g., Tomcat).
-  Access the application through your web browser at `http://localhost:8080/MVC_Product_1/Home.jsp.`



     
## Usage

- Upon accessing the application, users will see a form to manage products.
- Users can enter product details and perform insert, update, delete, or view operations.
- The results of each operation will be displayed on a separate page, along with the option to return to the home page.


## Contributing

Contributions to this project are welcome. Feel free to fork the repository, make your changes, and submit a pull request.


## License

[MIT](https://choosealicense.com/licenses/mit/)


## Acknowledgements
 - [Bootstrap](https://getbootstrap.com/) for the CSS framework.
 - [MySQL](https://www.mysql.com/) for the database.
 
