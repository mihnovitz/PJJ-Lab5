package org.example;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShapeRepository extends JpaRepository<Shape, Long> {
}