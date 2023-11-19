package com.institution.school.services;


import com.institution.school.dtos.TeacherDTO;
import com.institution.school.models.Room;

public interface RoomService {
    Room addTeacherToRoom(Long roomId, TeacherDTO teacherDTO);
    Room removeTeacherFromRoom(Long roomId, Long teacherId);
}
