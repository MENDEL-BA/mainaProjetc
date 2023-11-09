package com.institution.school.controllers;

import com.institution.school.dtos.RoomDTO;
import com.institution.school.dtos.TeacherDTO;
import com.institution.school.models.Room;
import com.institution.school.models.Teacher;
import com.institution.school.services.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/rooms")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/addTeacher/{id}")
    public ResponseEntity<Room> addTeacherToRoom(@RequestBody Teacher teacher, @PathVariable Long roomId) {
        Room room = this.roomService.addTeacherToRoom(roomId, teacher);
        if (room == null)
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        return ResponseEntity.ok(room);
    }

    @DeleteMapping("/deleteTeacher/{id}")
    public ResponseEntity<Room> removeTeacherFromRoom(@RequestBody Teacher teacher, @PathVariable Long roomId) {
        Room room = this.roomService.removeTeacherFromRoom(roomId, teacher);
        if (room == null)
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        return ResponseEntity.ok(room);
    }
}
