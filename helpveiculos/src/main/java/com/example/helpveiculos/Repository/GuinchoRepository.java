package com.example.helpveiculos.Repository;

import com.example.helpveiculos.Modal.GuinchoModal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuinchoRepository extends JpaRepository<GuinchoModal,Integer > {
}
