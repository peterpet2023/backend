package com.example.peterpet.design.repository;

import com.example.peterpet.domain.Design;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignRepository extends JpaRepository<Design, Long> {

    Design findByDesignTitle(String designTitle);

    void deleteByDesignCode(Long designCode);
}
