package com.institution.school.services.servicesImpl;

import com.institution.school.dtos.TeacherDTO;
import com.institution.school.models.Room;
import com.institution.school.models.Teacher;
import com.institution.school.repositories.RoomRepository;
import com.institution.school.repositories.TeacherRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RoomServiceImplTest {

    @Mock
    private RoomRepository roomRepository;

    @Mock
    private TeacherRepository teacherRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private RoomServiceImpl roomService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddTeacherToRoom() {
        // Arrange
        Long roomId = 1L;
        TeacherDTO teacherDTO = new TeacherDTO();
        Room room = new Room();

        // Mock the behavior of modelMapper.map to return a non-null Teacher
        when(modelMapper.map(eq(teacherDTO), eq(Teacher.class))).thenReturn(new Teacher());

        // Mock the behavior of the repositories
        when(roomRepository.findById(roomId)).thenReturn(Optional.of(room));
        when(teacherRepository.save(any(Teacher.class))).thenReturn(new Teacher());

        // Act
        Room resultRoom = roomService.addTeacherToRoom(roomId, teacherDTO);

        // Assert
        assertNull(resultRoom);
        verify(roomRepository, times(1)).save(room);
    }

    @Test
    void testRemoveTeacherFromRoom() {
        // Arrange
        Long roomId = 1L;
        Long teacherId = 2L;
        Room room = new Room();
        Teacher teacher = new Teacher();
        room.getTeachers().add(teacher);

        when(roomRepository.findById(roomId)).thenReturn(Optional.of(room));
        when(teacherRepository.findById(teacherId)).thenReturn(Optional.of(teacher));

        // Act
        Room resultRoom = roomService.removeTeacherFromRoom(roomId, teacherId);

        // Assert
        assertNull(resultRoom);
        verify(roomRepository, times(1)).save(room);
    }

    @Test
    void testRemoveTeacherFromRoomTeacherNotFound() {
        // Arrange
        Long roomId = 1L;
        Long teacherId = 2L;
        Room room = new Room();
        Teacher teacher = new Teacher();

        when(roomRepository.findById(roomId)).thenReturn(Optional.of(room));
        when(teacherRepository.findById(teacherId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> roomService.removeTeacherFromRoom(roomId, teacherId));
        verify(roomRepository, never()).save(room);
    }
}
