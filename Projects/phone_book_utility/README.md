# Phonebook Utility Application

This is a simple Phonebook Utility Application built to manage a list of contacts.

## Features

1. **Manage Contacts**: Add, edit, and delete contacts.
2. **Contact Fields**: Each contact includes a name, phone number, and address.
3. **Display Contacts**: View all contacts in a list format.
4. **Search Functionality**: Search for contacts by name or phone number. Multiple search hits are displayed in a list.

## Technologies Used

- **Java 17**
- **Spring Boot**
- **Gradle**
- **Thymeleaf**
- **H2 Database**

## Getting Started

### Prerequisites

- Java 17
- Gradle

### Installation

1. Build the project:
    ```bash
    ./gradlew build
    ```

2. Run the application:
    ```bash
    ./gradlew bootRun
    ```

3. Open your browser and navigate to `http://localhost:8080`.

## Usage

### Home Page

The home page displays a list of all contacts. You can add a new contact by clicking the "Add Contact" button.

### Add Contact

To add a new contact, fill in the name (accepts only letters and space), phone number (accepts only number), and address
fields and click "Add Contact". If all the three values in the field already exists, system will throw a message as
contact already exist.

### Edit Contact

To edit an existing contact, click the "Edit" link next to the contact you want to modify. Update name (accepts only
letters and space) or phone number (accepts only number), or address
fields and click "Update Contact". If all the three values in the field already exists, system will throw a message as
contact already exist.

### Delete Contact

To delete a contact, click the "Delete" link next to the contact you want to remove.

### Search Contacts

Use the search bar to find contacts by name or phone number. The search results will be displayed in a list. To search
the contact, fill in the search text (accepts either letters with space or numbers) and click "Search". The matching
contacts for the given text will be shown in a list
fields
and click "Add Contact"

## Database

The application uses an H2 in-memory database. The database schema is automatically created at runtime. You can access
the H2 console at `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:testdb`, username: `sa`, password: ``).
