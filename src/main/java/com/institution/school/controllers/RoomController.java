package com.institution.school.controllers;

import com.institution.school.dtos.TeacherDTO;
import com.institution.school.models.Room;
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
    public ResponseEntity<String> addTeacherToRoom(@RequestBody TeacherDTO teacherDTO, @PathVariable Long id) {
        Room room = this.roomService.addTeacherToRoom(id, teacherDTO);
        if (room == null)
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        return ResponseEntity.ok("Ajout reussi");
    }

    @DeleteMapping("/deleteTeacher/{roomId}/{teacherId}")
    public ResponseEntity<String> removeTeacherFromRoom(@PathVariable Long roomId, @PathVariable Long teacherId) {
        Room room = this.roomService.removeTeacherFromRoom(roomId, teacherId);
        if (room == null)
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        return ResponseEntity.ok("Suppression reussie");
    }
}
