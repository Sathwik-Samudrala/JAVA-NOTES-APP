# JAVA-NOTES-APP
A simple console-based Notes Manager built in Java. This app allows users to create, view, delete, and search notes, all stored using file I/O operations.

## 📌 Features
➕ Add and save notes with a title and multi-line content

📋 View all notes with timestamps

🗑️ Delete selected notes

🔍 Search notes by title or content

💾 Notes are stored in a notes.txt file using BufferedReader and BufferedWriter

## 🛠️ Technologies Used
Java 17+

Console (Terminal / Command Prompt)

File I/O: BufferedReader, BufferedWriter, FileReader, FileWriter

Exception Handling


### 🔑 Key Highlights:
- 📁 File-based storage (`notes.txt`) using `BufferedReader` and `BufferedWriter`
- 🧱 Modular code with separation of concerns across multiple classes
- 👨‍💻 Beginner-friendly console interface
- 🔎 Search functionality across both title and content


## ▶️ How to Run

Compile the code:

javac src/*.java

Run the program:

java -cp src MainApp

🔁 The program will auto-create notes.txt when saving notes.

# 📸 Application Outcomes

<div align="center">

## Main Interface Flows

| Screenshot | Description |
|------------|-------------|
| <img src="NOTES-SS-1.png" width="300"> | **Main Menu**<br><br>- First screen users encounter<br>- Clean numbered options (1-5)<br>- Handles invalid inputs<br>- Clear exit option |
| <img src="NOTES-SS-2.png" width="300"> | **Successful Note Creation**<br><br>- Multi-line input support<br>- 'END' command terminates input<br>- Auto-generates timestamp<br>- Success confirmation message |

## Validation & Error Handling

| Screenshot | Description |
|------------|-------------|
| <img src="NOTES-SS-5.png" width="300"> | **Input Validation**<br><br>- Rejects empty titles/content<br>- Clear error message<br>- Returns to main menu<br>- Preserves other notes |
| <img src="NOTES-SS-6.png" width="300"> | **Delete Protection**<br><br>- Prevents invalid note selection<br>- Maintains data integrity<br>- Clear error feedback<br>- Numbered list remains stable |

## Core Features

| Screenshot | Description |
|------------|-------------|
| <img src="NOTES-SS-3.png" width="300"> | **Note Management**<br><br>- Lists all notes with IDs<br>- Shows creation timestamps<br>- Detailed content view<br>- '0' to go back |
| <img src="NOTES-SS-4.png" width="300"> | **Search Functionality**<br><br>- Case-insensitive search<br>- Highlights matches<br>- Full-note display<br>- Clear section divider |

</div>

---


## ✅ Learning Outcomes
📁 Working with Java file I/O

📚 Exception handling and input validation

🧠 Structuring a Java application with multiple classes

🎯 Organizing files and folders for real-world projects


## Description

## 📝 Java Notes App – File I/O Project

The **Java Notes App** is a console-based application that allows users to **create**, **view**, **delete**, and **search** personal notes. Each note consists of a title, timestamp, and multi-line content. All notes are stored persistently in a `notes.txt` file using **Java File I/O** (`BufferedReader`, `BufferedWriter`, `FileReader`, `FileWriter`).

It simulates real-world text-based note-taking and serves as a great introduction to working with files in Java, especially for beginners exploring object-oriented programming and persistent storage techniques.

---


