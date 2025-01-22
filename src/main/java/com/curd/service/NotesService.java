package com.curd.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curd.model.entity.Notes;
import com.curd.model.entity.Users;
import com.curd.model.request.NotesRequest;
import com.curd.model.response.NotesDto;
import com.curd.repository.NotesRepository;
import com.curd.repository.UserRepository;
import com.curd.util.NotesDtoMapper;

@Service
public class NotesService {

	@Autowired
	private NotesRepository notesRepository;

	@Autowired
	private UserRepository userRepository;

	public NotesDto createNotes(Integer userId, NotesRequest request) {

		Users user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not exist"));

		Notes notes = toEntity(user, request);

		return NotesDtoMapper.toResponseDto(notesRepository.save(notes));
	}

	private Notes toEntity(Users user, NotesRequest request) {

		return Notes.builder().title(request.getTitle()).description(request.getDescription())
				.addedDate(LocalDate.now()).updatedDate(LocalDate.now())
				.user(user)
				.build();

	}

	public List<NotesDto> getAllNotes() {

		return notesRepository.findAll().stream().map(NotesDtoMapper::toResponseDto).toList();
	}

	public NotesDto getNotesById(Integer id) {

		Notes notes = notesRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Notes Not found of Id" + id));

		return NotesDtoMapper.toResponseDto(notes);
	}

	public NotesDto updateNotes(Integer id, NotesRequest request) {

		Notes notes = notesRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Notes not exist for id" + id));

		Notes updatedNotes = updateWithBuilder(notes, request);

		return NotesDtoMapper.toResponseDto(notesRepository.save(updatedNotes));
	}

	private Notes updateWithBuilder(Notes notes, NotesRequest request) {

		return notes.toBuilder().title(request.getTitle()).description(request.getDescription())
				.updatedDate(LocalDate.now()).build();

	}

	public NotesDto deleteById(Integer id) {

		Notes notes = notesRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Notes not found for id " + id));

		notesRepository.delete(notes);

		return NotesDtoMapper.toResponseDto(notes);
	}
	

    public List<NotesDto> getNotesByUserEmail(Integer id) {
        return notesRepository.findByUserId(id);
    }
}
