package com.institution.school.services.servicesImpl;

import com.institution.school.dtos.TeacherDTO;
import com.institution.school.models.Room;
import com.institution.school.models.Teacher;
import com.institution.school.repositories.RoomRepository;
import com.institution.school.repositories.TeacherRepository;
import com.institution.school.services.RoomService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Room addTeacherToRoom(Long roomId, TeacherDTO teacherDTO) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new EntityNotFoundException("Room not found"));
        if (teacherDTO != null) {
            Teacher teacher = modelMapper.map(teacherDTO, Teacher.class);

            // Vérifiez si le mapping a réussi et que teacher n'est pas null
            if (teacher != null) {
                teacher = teacherRepository.save(teacher);
                room.getTeachers().add(teacher);
                teacher.getRooms().add(room);

                return roomRepository.save(room);
            } else {
                throw new IllegalArgumentException("Mapping from TeacherDTO to Teacher resulted in null");
            }
        } else {
            throw new IllegalArgumentException("TeacherDTO cannot be null");
        }
    }
    @Override
    public Room removeTeacherFromRoom(Long roomId, Long teacherId) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new EntityNotFoundException("Room not found"));
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found"));
        if (teacher != null) {
            Set<Teacher> teachers = room.getTeachers();

            if (teachers != null && !teachers.isEmpty() && teachers.contains(teacher)) {
                room.getTeachers().remove(teacher);
                teacher.getRooms().remove(room);
                return roomRepository.save(room);
            } else {
                throw new IllegalArgumentException("Teacher not found in the room or the teachers set is empty.");
            }
        } else {
            throw new EntityNotFoundException("Teacher not found");
        }
    }
}
