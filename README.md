# iFriend CLI - Contact Management System

## Overview
iFriend CLI is a command-line based contact management system that allows users to efficiently store, organize, and manage contact information. Built in Java, this application provides a straightforward text-based interface for contact management operations.

## Features
- **Add Contacts**: Store new contacts with details including name, phone number, company, salary information, and birthdate
- **Update Contacts**: Modify details of existing contacts 
- **Delete Contacts**: Remove contacts from the system
- **Search Functionality**: Find contacts by name or phone number
- **List & Sort Contacts**: View contacts sorted by different criteria (name, salary, or birthday)
- **Input Validation**: Comprehensive validation for all data entry fields

## System Requirements
- Java Runtime Environment (JRE) 16 or higher
- Terminal/Command Prompt with support for ANSI escape sequences for optimal display

## How to Run
1. Compile the Java file:
   ```
   javac iFriend.java
   ```
2. Run the compiled program:
   ```
   java iFriend
   ```

## Usage Guide

### Main Menu Options
The application presents the following options:
- **[01] ADD Contacts**: Add new contacts to the system
- **[02] UPDATE Contacts**: Modify existing contact information
- **[03] DELETE Contacts**: Remove contacts from the system 
- **[04] SEARCH Contacts**: Find specific contacts
- **[05] LIST Contacts**: View contacts with sorting options
- **[06] Exit**: Close the application

### Contact Details
For each contact, the system stores:
- Unique Contact ID (automatically generated)
- Name
- Phone Number (must be 10 digits and start with '0')
- Company Name
- Salary (must be greater than 0)
- Birthday (in YYYY-MM-DD format with validation)

### Sorting Options
- Sort by Name (alphabetical order)
- Sort by Salary (ascending order)
- Sort by Birthday (chronological order)

## Data Storage
Contact information is stored in memory during program execution. Data persistence across program restarts is not implemented in the current version.

## Future Enhancements
- Data persistence through file storage
- Advanced search capabilities
- Contact grouping and categorization
- Export functionality for contacts
- User authentication system

## License
Copyright © 2025 ICET iFriend Project

---

*This application was developed as a project for ICET.*