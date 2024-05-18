package com.stores.car.repository;

import com.stores.car.dto.OwnerPostDTO;
import com.stores.car.entity.CarPostEntity;
import com.stores.car.entity.OwnerPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerPostRepository extends JpaRepository<OwnerPostEntity, Long> {
}
