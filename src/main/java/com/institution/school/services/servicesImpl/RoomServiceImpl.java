package com.institution.school.services.servicesImpl;

import com.institution.school.models.Room;
import com.institution.school.models.Teacher;
import com.institution.school.repositories.RoomRepository;
import com.institution.school.services.RoomService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public void addTeacher(Room room, Teacher teacher) {
        room.getTeachers().add(teacher);
        teacher.getRooms().add(room);
    }

    public void removeTeacher(Room room, Teacher teacher) {
        room.getTeachers().remove(teacher);
        teacher.getRooms().remove(room);
    }

    @Override
    public Room addTeacherToRoom(Long roomId, Teacher teacher) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new EntityNotFoundException("Room not found"));

        addTeacher(room, teacher);
        return roomRepository.save(room);
    }
    @Override
    public Room removeTeacherFromRoom(Long roomId, Teacher teacher) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new EntityNotFoundException("Room not found"));

        removeTeacher(room, teacher);
        return roomRepository.save(room);
    }
}
