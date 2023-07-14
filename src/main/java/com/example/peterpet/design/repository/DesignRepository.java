package com.example.peterpet.design.repository;

import com.example.peterpet.domain.Design;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface DesignRepository extends JpaRepository<Design, Long> {


    List<Design> findAllByDesignTitleLike(String designTitle);

    List<Design> findAllByDesignCategoryLike(String designCategory);

    void deleteByDesignCode(Long designCode);

   List<Design> findByDesignPriceBetween(int designPriceLower, int designPriceUpper);
}
