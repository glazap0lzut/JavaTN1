package com.example.tn.service;

import com.example.tn.DTO.EventDTO;
import com.example.tn.Entity.Event;
import com.example.tn.Entity.Users;
import com.example.tn.repository.EventRepository;
import com.example.tn.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public EventService(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

//    @PostMapping("/tasks")
    public ResponseEntity<Event> createEvent(@RequestBody EventDTO eventDto) {
        // Находим пользователя по ID
        Users user = userRepository.findById(eventDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Создаем новый объект Event
        Event event = new Event();

        // Устанавливаем значения из DTO
        event.setTitle(eventDto.getTitle());
        event.setLocation(eventDto.getLocation());
        event.setApplicant(eventDto.getApplicant());
        event.setComment(eventDto.getComment());
        event.setOnline(eventDto.isOnline());
        event.setStartDate(eventDto.getStartDate());
        event.setEndDate(eventDto.getEndDate());
        event.setOutlook(eventDto.isOutlook());
        event.setUser(user);  // Связываем событие с пользователем

        // Сохраняем событие в базе данных
        Event savedEvent = eventRepository.save(event);

        // Возвращаем ответ с кодом 201 Created и объектом сохраненного события
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEvent);
    }




//    @GetMapping("/tasks")
    public ResponseEntity<List<Event>> getAllEvents() {
        System.out.println(eventRepository.findAll());
        List<Event> events = eventRepository.findAll();
        return ResponseEntity.ok(events);
    }

//    @GetMapping("/tasks/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        return ResponseEntity.ok(event);
    }

//    @PutMapping("/tasks/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody EventDTO eventDto) {
        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        // Обновляем данные события
        existingEvent.setTitle(eventDto.getTitle());
        existingEvent.setLocation(eventDto.getLocation());
        existingEvent.setApplicant(eventDto.getApplicant());
        existingEvent.setComment(eventDto.getComment());
        existingEvent.setOnline(eventDto.isOnline());
        existingEvent.setStartDate(eventDto.getStartDate());
        existingEvent.setEndDate(eventDto.getEndDate());
        existingEvent.setOutlook(eventDto.isOutlook());

        // Сохраняем обновленное событие
        Event updatedEvent = eventRepository.save(existingEvent);
        return ResponseEntity.ok(updatedEvent);
    }


//    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        eventRepository.delete(event);
        return ResponseEntity.noContent().build();
    }

}
