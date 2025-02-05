# NotesApp Backend

A Java-based backend for the NotesApp application using Spring Boot and an H2 database with Postgres configuration.

---

## Table of Contents

- [Features](#features)
- [API Endpoints](#api-endpoints)
- [Usage Steps](#usage-steps)
- [Running the Application](#running-the-application)
- [Testing](#testing)

---

## Features

- **Add Notes:** Users can add new notes to the database.
- **Retrieve Notes:** Fetch all saved notes.
- **Update Notes:** Modify existing notes by their ID.
- **Delete Notes:** Remove a note from the database.
- **Cross-Origin Support:** CORS enabled for `http://localhost:3000`.
- **Local Services:** PostgreSQL runs locally.

---

## API Endpoints

### 1. Add a Note

- **Endpoint:** `POST /notes/addNote`
- **Description:** Adds a new note.
- **Request Body:**
  
  ```json
  "This is my new note."
  ```

- **Response:**
  
  ```json
  "Note added successfully"
  ```

### 2. Retrieve Notes

- **Endpoint:** `GET /notes/getNotes`
- **Description:** Fetches all saved notes.
- **Response:**
  
  ```json
  [
    { "id": 1, "note": "First note" },
    { "id": 2, "note": "Second note" }
  ]
  ```

### 3. Update a Note

- **Endpoint:** `PUT /notes/{id}`
- **Description:** Updates an existing note by ID.
- **Request Body:**
  
  ```json
  "Updated note content"
  ```

- **Response:**
  
  ```json
  "Note updated successfully"
  ```

### 4. Delete a Note

- **Endpoint:** `DELETE /notes/{id}`
- **Description:** Deletes a note by ID.
- **Response:**
  
  ```json
  "Note deleted successfully"
  ```

---

## Usage Steps

1. **Add a Note:**
   - Send a `POST` request to `/notes/addNote` with the note content in the request body.

2. **Retrieve Notes:**
   - Send a `GET` request to `/notes/getNotes` to fetch all notes.

3. **Update a Note:**
   - Send a `PUT` request to `/notes/{id}` with updated note content.

4. **Delete a Note:**
   - Send a `DELETE` request to `/notes/{id}` to remove a note.

