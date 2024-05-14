package com.example.ms1.note.note.tag.tag;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    public Tag getTag(Long tagId) {
        return tagRepository.findById(tagId).orElseThrow();
    }

    public Tag create(String name) {
        Tag tag = new Tag();
        tag.setName(name);
        return tagRepository.save(tag);
    }
}
