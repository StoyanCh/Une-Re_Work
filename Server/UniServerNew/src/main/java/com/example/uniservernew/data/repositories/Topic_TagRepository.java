package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.Topic_Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Topic_TagRepository extends JpaRepository<Topic_Tag, Integer> {

    Optional<Topic_Tag> findByTopicTagName(String topicTagName);

    List<Topic_Tag> findAllByOrderByTopicTagNameAsc();

    List<Topic_Tag> findAllByOrderByTopicTagNameDesc();
}
