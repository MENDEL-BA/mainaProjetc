package com.institution.school.models;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testRoomCreation() {
        // Arrange
        Room room = new Room();
        room.setName("Room 101");

        // Act

        // Assert
        assertEquals("Room 101", room.getName());
        assertNotNull(room.getTeachers());
        assertTrue(room.getTeachers().isEmpty());
        assertNotNull(room.getSessions());
        assertTrue(room.getSessions().isEmpty());

        // Validate annotations
        assertEquals(0, validator.validate(room).size());
    }

    @Test
    void testAddTeacherToRoom() {
        // Arrange
        Room room = new Room();
        Teacher teacher = new Teacher();
        teacher.setName("John Doe");

        // Act
        room.getTeachers().add(teacher);

        // Assert
        assertEquals(1, room.getTeachers().size());
        assertTrue(room.getTeachers().contains(teacher));

        // Validate annotations
        assertNotEquals(0, validator.validate(room).size());
    }

    @Test
    void testAddSessionToRoom() {
        // Arrange
        Room room = new Room();
        Session session = new Session();
        session.setCode("Math Session");

        // Act
        room.getSessions().add(session);

        // Assert
        assertEquals(1, room.getSessions().size());
        assertTrue(room.getSessions().contains(session));

        // Validate annotations
        assertNotEquals(0, validator.validate(room).size());
    }

    @Test
    void testRoomNameNotBlank() {
        // Arrange
        Room room = new Room();

        // Act

        // Assert
        Set<String> violations = new HashSet<>();
        validator.validate(room).forEach(violation -> violations.add(violation.getPropertyPath() + " " + violation.getMessage()));
        assertFalse(violations.contains("NotBlank"));
    }
}
