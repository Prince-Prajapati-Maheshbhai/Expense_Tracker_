# 💰 Expense Tracker

**Expense Tracker** is an Android application developed using **Kotlin** and **Android Studio**. The application allows users to record, manage, edit, delete, and track their daily expenses in a simple and user-friendly interface.

The project is designed to demonstrate basic Android application development concepts such as user interface design, activities, layouts, RecyclerView, database operations, CRUD operations, and data handling.

## 📱 Features

* ➕ **Add New Expenses**

  * Add a new expense to the application.
  * Enter the expense title and amount.
  * Select an appropriate expense category.
  * Store the expense date.

* 📋 **Expense History**

  * View all previously added expenses.
  * Display expense information in an organized list.
  * Easily keep track of daily spending.

* ✏️ **Edit Expenses**

  * Select an existing expense.
  * Update the expense title, amount, category, or date.
  * Save the updated expense information.

* 🗑️ **Delete Expenses**

  * Delete unwanted expenses from the expense list.
  * Keep the expense records clean and organized.

* 💰 **Total Expenses**

  * View the total amount of recorded expenses.
  * Helps users keep track of their overall spending.

* 📂 **Expense Categories**

  * Assign categories to expenses.
  * Makes it easier to organize and identify different types of spending.

* 📊 **Expense Tracking**

  * Maintain a record of expenses.
  * Helps users monitor their daily spending.

* 📱 **Simple User Interface**

  * Clean and simple Android interface.
  * Easy navigation and expense management.
  * Designed for convenient use on Android devices.

## 🛠️ Technologies Used

| Technology                     | Usage                            |
| ------------------------------ | -------------------------------- |
| **Kotlin**                     | Application programming language |
| **Android Studio**             | Development environment          |
| **XML**                        | User interface layouts           |
| **SQLite / Room Database**     | Local expense data storage       |
| **Android Jetpack Components** | Android application development  |
| **RecyclerView**               | Displaying expense records       |
| **Material Design**            | UI components and styling        |

## 📂 Project Structure

```text
ExpenseTracker/
│
├── app/
│   └── src/
│       ├── main/
│       │   ├── java/
│       │   │   └── ...
│       │   │
│       │   ├── res/
│       │   │   ├── drawable/
│       │   │   ├── layout/
│       │   │   ├── mipmap/
│       │   │   └── values/
│       │   │
│       │   └── AndroidManifest.xml
│       │
│       └── test/
│
├── gradle/
├── build.gradle
├── settings.gradle
└── README.md
```

## 🔑 Login Details

The current project contains the following login credentials:

| Username  | Password      |
| --------- | ------------- |
| `prince`  | `prince123`   |
| `Prince1` | `Prince1@123` |
| `admin`   | `admin123`    |

> **Note:** These credentials are provided for demonstration/academic purposes. The login system is not intended for production use.

## 🚀 How to Run the Project

### 1. Clone the Repository

```bash
git clone <YOUR-GITHUB-REPOSITORY-URL>
```

### 2. Open in Android Studio

Open the cloned **ExpenseTracker** folder in **Android Studio**.

### 3. Sync Gradle

Allow Android Studio to sync the Gradle files and download the required dependencies.

### 4. Select an Android Device

You can use either:

* Android Emulator
* Physical Android device

### 5. Run the Application

Click the **Run ▶** button in Android Studio and select your Android device.

The application will be installed and launched on the selected device.

## 📖 Application Flow

```text
Start Application
       ↓
   Login Screen
       ↓
   Valid Login
       ↓
   Expense Tracker
       ↓
 ┌─────┴─────────────┐
 ↓                   ↓
Add Expense       View Expenses
 ↓                   ↓
Enter Details        ↓
 ↓                Select Expense
Category             ↓
 ↓                Edit / Delete
Date                  ↓
 ↓
Save Expense
       ↓
Expense Added
       ↓
Total Expenses Updated
```

## 💵 Adding an Expense

To add a new expense:

1. Log in to the application.
2. Open the **Expense Tracker** screen.
3. Select the option to add a new expense.
4. Enter the expense title.
5. Enter the expense amount.
6. Select the expense category.
7. Select or enter the expense date.
8. Save the expense.
9. The new expense will appear in the expense history.

## ✏️ Managing Expenses

The application provides options to manage existing expense records.

Users can:

* View saved expenses.
* Edit existing expenses.
* Update expense information.
* Delete unwanted expenses.
* View the updated total expense amount.

These operations make it easier to maintain accurate expense records.

## 🔄 CRUD Operations

The application supports the basic **CRUD** operations:

| Operation  | Description              |
| ---------- | ------------------------ |
| **Create** | Add a new expense        |
| **Read**   | View saved expenses      |
| **Update** | Edit an existing expense |
| **Delete** | Remove an expense        |

CRUD operations demonstrate how application data can be created, displayed, modified, and removed.

## 💾 Data Management

Expense information is stored locally using the application's database system.

The application manages information such as:

* Expense title
* Expense amount
* Expense category
* Expense date

The stored data is used to display the expense history and calculate the overall expense amount.

## 🎨 User Interface

The application provides a simple and user-friendly Android interface with:

* Clean expense management screens
* Material Design components
* Expense input forms
* Category selection
* Expense list
* Edit and delete functionality
* Total expense information
* RecyclerView-based expense display

The main screens include:

### Login Screen

Allows the user to enter their username and password before accessing the application.

### Expense Tracker Screen

Displays the user's expense records and overall spending information.

### Add Expense Screen

Provides a form for entering the expense title, amount, category, and date.

### Expense List

Displays all saved expenses in an organized list.

### Edit Expense Screen

Allows users to modify the details of an existing expense.

## 🎯 Purpose

The main purpose of this project is to develop a simple Android application for personal expense management while demonstrating important Android development concepts such as:

* User interface design
* Activities and layouts
* RecyclerView
* Database operations
* CRUD operations
* Data handling
* User input
* Android application navigation
* Local data storage

## 📸 Screenshots

The following screenshots demonstrate the main screens and functionality of the **Expense Tracker** application.

### 🔐 Login Screen

<img width="350" height="778" alt="Login Screen" src="https://github.com/user-attachments/assets/24c2e8f6-b553-4a9c-9c42-5b6483b9fe38" />

### 🏠 Home / Expense Tracker Screen

<img width="350" height="778" alt="Home Screen" src="https://github.com/user-attachments/assets/c7d21712-3587-4af4-92fb-b2a92d53fe48" />

### ➕ Add Expense Screen

<img width="350" height="778" alt="Add Expense Screen" src="https://github.com/user-attachments/assets/e2d7fc64-36b4-4114-bb0d-e10e1356e4ab" />

### 📋 Expense List

<img width="350" height="778" alt="Expense List" src="https://github.com/user-attachments/assets/17bf8e2d-b063-47d1-a9d0-9b3b97cc6a6a" />

### ✏️ Edit Expense Screen

<img width="350" height="778" alt="Edit Expense" src="https://github.com/user-attachments/assets/b78ed2fe-2302-4a40-a29c-fc6ae6873b86" />

### 💰 Expense Summary

<img width="350" height="778" alt="Expense Summary" src="https://github.com/user-attachments/assets/ba391da1-db68-483e-860b-1a96472ff07d" />

### ❌ Delete Expense 

<img width="350" height="778" alt="image" src="https://github.com/user-attachments/assets/e0f50b1d-ce35-4755-b1ed-97c5bcc02cd4" />

### 💰 Expense Summary

<img width="1080" height="2400" alt="image" src="https://github.com/user-attachments/assets/c3bc4cb6-107c-444c-ae72-af818367f8fa" />

## 📁 Screenshot Folder Structure

The screenshots can also be organized in the following folder structure:

```text
screenshots/
│
├── login.png
├── home.png
├── add-expense.png
├── expense-list.png
├── edit-expense.png
├── expense-summary.png
├── delete-expense.png
└── expense-summary.png
```

## 🔮 Future Improvements

The project can be further improved by adding:

* 📊 Expense charts and statistics
* 🔍 Search and filter expenses
* 📅 Monthly and yearly expense reports
* 💳 Multiple payment methods
* 📤 Export expenses
* ☁️ Cloud backup
* 🔔 Budget notifications
* 🎯 Monthly spending limits
* 📈 Spending analysis
* 🌙 Dark mode
* 🔐 More secure authentication
* 👤 User registration

## 👨‍💻 Developer

**Prince Prajapati Maheshbhai**

**Enrollment Number:** 25172022054

## 📄 Project Information

**Project Name:** Expense Tracker
**Platform:** Android
**Language:** Kotlin
**IDE:** Android Studio
**UI:** XML
**Database:** SQLite / Room Database
**Version:** 1.0
