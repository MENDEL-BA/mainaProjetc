package com.institution.school.controllers;

import com.institution.school.dtos.TeacherDTO;
import com.institution.school.models.Room;
import com.institution.school.services.RoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RoomControllerTest {

    @Mock
    private RoomService roomService;

    @InjectMocks
    private RoomController roomController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddTeacherToRoom_Success() {
        // Arrange
        Long roomId = 1L;
        TeacherDTO teacherDTO = new TeacherDTO(); // You need to initialize this with appropriate data

        Room mockedRoom = new Room(); // You need to initialize this with appropriate data
        when(roomService.addTeacherToRoom(roomId, teacherDTO)).thenReturn(mockedRoom);

        // Act
        ResponseEntity<String> response = roomController.addTeacherToRoom(teacherDTO, roomId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Ajout reussi", response.getBody());
        verify(roomService, times(1)).addTeacherToRoom(roomId, teacherDTO);
    }

    @Test
    void testAddTeacherToRoom_Failure() {
        // Arrange
        Long roomId = 1L;
        TeacherDTO teacherDTO = new TeacherDTO(); // You need to initialize this with appropriate data

        when(roomService.addTeacherToRoom(roomId, teacherDTO)).thenReturn(null);

        // Act
        ResponseEntity<String> response = roomController.addTeacherToRoom(teacherDTO, roomId);

        // Assert
        assertEquals(HttpStatus.EXPECTATION_FAILED, response.getStatusCode());
        verify(roomService, times(1)).addTeacherToRoom(roomId, teacherDTO);
    }

    @Test
    void testRemoveTeacherFromRoom_Success() {
        // Arrange
        Long roomId = 1L;
        Long teacherId = 2L;

        Room mockedRoom = new Room(); // You need to initialize this with appropriate data
        when(roomService.removeTeacherFromRoom(roomId, teacherId)).thenReturn(mockedRoom);

        // Act
        ResponseEntity<String> response = roomController.removeTeacherFromRoom(roomId, teacherId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Suppression reussie", response.getBody());
        verify(roomService, times(1)).removeTeacherFromRoom(roomId, teacherId);
    }

    @Test
    void testRemoveTeacherFromRoom_Failure() {
        // Arrange
        Long roomId = 1L;
        Long teacherId = 2L;

        when(roomService.removeTeacherFromRoom(roomId, teacherId)).thenReturn(null);

        // Act
        ResponseEntity<String> response = roomController.removeTeacherFromRoom(roomId, teacherId);

        // Assert
        assertEquals(HttpStatus.EXPECTATION_FAILED, response.getStatusCode());
        verify(roomService, times(1)).removeTeacherFromRoom(roomId, teacherId);
    }
}
