# Task 1 - Online Reservation System

**Internship Program:** AICTE OASIS Infobyte Java Programming Internship  
**Task:** Online Reservation System  
**Language:** Java  

---

## Objective

To build a console-based Online Reservation System in Java using four classes following clean OOP design. The system authenticates a user via a login form, allows them to make train reservations by filling in passenger and journey details, view existing reservations by PNR, and cancel reservations after confirmation.

---

## Steps Performed

1. **Designed the class structure** — split responsibilities across four classes for clean OOP design.
2. **Implemented `User.java`:**
   - Holds login credentials and user name.
   - Provides an `authenticate()` method to verify login ID and password.
3. **Implemented `Ticket.java`:**
   - Stores all reservation details — PNR, passenger name, train number, train name, class type, date of journey, source, and destination.
   - Provides a formatted `display()` method to print ticket details.
4. **Implemented `ReservationSystem.java`:**
   - Manages all reservations using a `HashMap` with PNR as the key.
   - Handles reservation form — auto-fills train name from train number and generates a unique PNR.
   - Handles cancellation form — fetches ticket by PNR, displays details, and confirms before cancelling.
   - Handles view reservation by PNR lookup.
5. **Implemented `ReservationMain.java`:**
   - Entry point with login flow and 3-attempt lockout.
   - Main menu with options for reservation, cancellation, view, and logout.
6. **Tested the program** for login validation, PNR generation, reservation storage, and cancellation flow.

---

## Tools Used

| Tool | Purpose |
|------|---------|
| Java (JDK) | Core programming language |
| `java.util.Scanner` | Reading console input from the user |
| `java.util.HashMap` | Storing reservations with PNR as key |
| `java.util.Random` | Generating unique PNR numbers |
| VS Code / IntelliJ IDEA | Code editor / IDE |
| Terminal / Command Prompt | Compiling and running the program |

---

## Project Structure

```
OnlineReservation/
│
├── User.java               # Login credentials and authentication
├── Ticket.java             # Reservation record with display method
├── ReservationSystem.java  # Reservation, cancellation, and view logic
└── ReservationMain.java    # Entry point — login flow and main menu
```

---

## How to Run

```bash
# Step 1: Compile all files
javac User.java Ticket.java ReservationSystem.java ReservationMain.java

# Step 2: Run
java ReservationMain
```

**Demo Credentials:**
- Login ID: `admin`
- Password: `admin123`

**Available Train Numbers:**
| Train Number | Train Name |
|---|---|
| 12345 | Rajdhani Express |
| 22221 | Duronto Express |
| 11001 | Shatabdi Express |
| 16001 | Kerala Express |
| 12001 | Gatimaan Express |

---

## Outcome

A fully functional console-based Online Reservation System was successfully built in Java using four classes. The system authenticates users with a 3-attempt login lockout, allows passengers to book train tickets by entering journey details with auto-filled train names, and generates a unique PNR for every booking stored in a HashMap. Users can view any reservation by PNR and cancel it after a confirmation step. The project demonstrates core Java concepts including OOP, HashMap, Random, input validation, and control flow.

---

*Submitted as part of AICTE OASIS Infobyte Java Programming Internship — Task 1*
