package com.example.ms1.note.note.tag;

import com.example.ms1.note.note.Note;
import com.example.ms1.note.note.NoteService;
import com.example.ms1.note.note.tag.tag.Tag;
import com.example.ms1.note.note.tag.tag.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NoteTagService {
    private final NoteTagRepository noteTagRepository;
    private final NoteService noteService;
    private final TagService tagService;

    public NoteTag create(Long noteId, String name) {
        Note note = noteService.getNote(noteId);
        Tag tag = tagService.create(name);

        NoteTag noteTag = new NoteTag();
        noteTag.setNote(note);
        noteTag.setTag(tag);

        return noteTagRepository.save(noteTag);
    }

    public void delete(Long noteTagId) {
        noteTagRepository.deleteById(noteTagId);
    }

    public NoteTag getNoteTag(Long noteTagId) {
        return noteTagRepository.findById(noteTagId).orElseThrow();
    }
}
