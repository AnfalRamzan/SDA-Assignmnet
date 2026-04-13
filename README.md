SOLID Refactoring  Library Management System
Project Overview

This project demonstrates refactoring of a Java-based Library Management System by applying SOLID principles. The original codebase contained tightly coupled classes, mixed responsibilities, and poor extensibility. The refactored version improves maintainability, flexibility, and scalability using proper object-oriented design.

Before (Original Repo):
Library Management System with multiple SOLID violations

After (Refactored Repo):
Refactored system applying SRP, OCP, LSP, ISP, and DIP

🔷 SOLID Principles Applied
1. Single Responsibility Principle (SRP)

Each class should have only one responsibility.

Applied In:

Libraary
Borroweer
Boook

Improvement:
Responsibilities were separated so each class handles only its specific task, making the code easier to maintain.

2. Open/Closed Principle (OCP)

Software should be open for extension but closed for modification.

Applied In:

HoldRequestOperations
Hold request abstraction

Improvement:
New hold request behaviors can be added without modifying existing classes.

3. Liskov Substitution Principle (LSP)

Subclasses should be replaceable with base classes without breaking functionality.

Applied In:

Boook
ReferenceBook
User
Borrower
Librarian
Admin

Improvement:
Each subclass follows its own rules without violating parent behavior.

4. Interface Segregation Principle (ISP)

Classes should not be forced to implement unused methods.

Applied In:

BorrowerActions
ClerkActions
LibrarianActions
Clerk
Librarian
Borrower

Improvement:
Small role-based interfaces removed unnecessary dependencies.

5. Dependency Inversion Principle (DIP)

High-level modules should depend on abstractions, not concrete classes.

Applied In:

Libraary
Boook
Borroweer
HoldRequestOperations
Clerk
Librarian

Improvement:
Dependencies injected via interfaces, reducing tight coupling.