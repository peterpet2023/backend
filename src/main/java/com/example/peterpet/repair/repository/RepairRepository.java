package com.example.peterpet.repair.repository;

import com.example.peterpet.domain.Repair;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepairRepository extends JpaRepository<Repair, Long> {

    Repair findByRepairCode(Long repairCode);
}
