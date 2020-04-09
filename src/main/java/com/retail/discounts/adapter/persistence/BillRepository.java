package com.retail.discounts.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface BillRepository extends JpaRepository<BillEntity, String> {

}
