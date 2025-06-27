package JavaNotesApp;

import java.io.*;
import java.util.*;

/**
 * Notes Application with file persistence
 * Features:
 * - Create/view/delete/search notes
 * - Auto-saves to file after changes
 * - Handles multi-line content
 */
public class MainApp {
    // Configuration
    private static final String NOTES_FILE = "notes.txt";
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Note> notes = new ArrayList<>();

    public static void main(String[] args) {
        loadNotes(); // Load existing notes
        showMainMenu(); // Start interface
    }

    /**
     * Displays the main menu and handles user input
     */
    private static void showMainMenu() {
        System.out.println("===== WELCOME TO NOTES APP =====");
        while (true) {
            System.out.println("\nMAIN MENU:");
            System.out.println("1. ADD NOTE");
            System.out.println("2. VIEW NOTES");
            System.out.println("3. DELETE NOTE");
            System.out.println("4. SEARCH NOTES");
            System.out.println("5. EXIT");
            System.out.print("SELECT OPTION: ");
            
            String choice = scanner.nextLine().trim();
            System.out.println(); // Blank line for spacing
            
            switch (choice) {
                case "1" -> addNote();
                case "2" -> viewNotes();
                case "3" -> deleteNote();
                case "4" -> searchNotes();
                case "5" -> { 
                    System.out.println(" GOODBYE...! THANKS FOR USING NOTES APP"); 
                    return; // Exit program
                }
                default -> System.out.println(" Invalid option. Please try again.");
            }
        }
    }

    /**
     * Loads notes from file at startup
     */
    private static void loadNotes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(NOTES_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Note note = Note.fromFileString(line);
                if (note != null) notes.add(note);
            }
            System.out.println("Loaded " + notes.size() + " notes");
        } catch (FileNotFoundException e) {
            System.out.println(" No existing notes file found. Starting fresh.");
        } catch (IOException e) {
            System.out.println(" Error loading notes: " + e.getMessage());
        }
    }

    /**
     * Saves all notes to file
     */
    private static void saveNotes() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOTES_FILE))) {
            for (Note note : notes) {
                writer.write(note.toFileString() + "\n");
            }
        } catch (IOException e) {
            System.out.println(" Failed to save notes: " + e.getMessage());
        }
    }

    /**
     * Creates and saves a new note
     */
    private static void addNote() {
        System.out.println("=== CREATE NEW NOTE ===");
        System.out.print("ENTER TITLE: ");
        String title = scanner.nextLine();
        
        System.out.println("ENTER CONTENT (type 'END' on empty line to finish):");
        StringBuilder content = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).equalsIgnoreCase("END")) {
            content.append(line).append("\n");
        }
        
        if (title.trim().isEmpty() || content.toString().trim().isEmpty()) {
            System.out.println(" Note not saved - title and content required!");
            return;
        }
        
        notes.add(new Note(title, content.toString().trim()));
        saveNotes();
        System.out.println("NOTE SAVED!");
    }

    /**
     * Displays list of notes and allows viewing details
     */
    private static void viewNotes() {
        if (notes.isEmpty()) {
            System.out.println("NO NOTES FOUND");
            return;
        }
        
        System.out.println("=== YOUR NOTES ===");
        for (int i = 0; i < notes.size(); i++) {
            System.out.printf("%d. %s (%s)\n", 
                i + 1, 
                notes.get(i).getTitle(), 
                notes.get(i).getTimestamp());
        }
        
        System.out.print("\nENTER NOTE NUMBER TO VIEW (0 to go back): ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 0) return;
            if (choice < 1 || choice > notes.size()) {
                System.out.println(" Invalid note number");
                return;
            }
            
            Note note = notes.get(choice - 1);
            System.out.println("\n=== " + note.getTitle() + " ===");
            System.out.println("Created: " + note.getTimestamp());
            System.out.println("\n" + note.getContent() + "\n");
            
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number");
        }
    }

    /**
     * Deletes a selected note
     */
    private static void deleteNote() {
        if (notes.isEmpty()) {
            System.out.println(" NO NOTES TO DELETE");
            return;
        }
        
        System.out.println("=== DELETE NOTE ===");
        for (int i = 0; i < notes.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, notes.get(i).getTitle());
        }
        
        System.out.print("\nENTER NOTE NUMBER TO DELETE: ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice < 1 || choice > notes.size()) {
                System.out.println(" Invalid note number");
                return;
            }
            
            notes.remove(choice - 1);
            saveNotes();
            System.out.println(" NOTE DELETED!");
            
        } catch (NumberFormatException e) {
            System.out.println(" Please enter a valid number");
        }
    }

    /**
     * Searches notes by title or content
     */
    private static void searchNotes() {
        System.out.println("=== SEARCH NOTES ===");
        System.out.print("ENTER SEARCH TERM: ");
        String term = scanner.nextLine().toLowerCase();
        
        List<Note> results = new ArrayList<>();
        for (Note note : notes) {
            if (note.getTitle().toLowerCase().contains(term) || 
                note.getContent().toLowerCase().contains(term)) {
                results.add(note);
            }
        }
        
        if (results.isEmpty()) {
            System.out.println("NO MATCHING NOTES FOUND");
            return;
        }
        
        System.out.println("\n=== SEARCH RESULTS ===");
        for (Note note : results) {
            System.out.println( note.getTitle() + " (" + note.getTimestamp() + ")");
            System.out.println(note.getContent());
            System.out.println("----------------------");
        }
    }
}
