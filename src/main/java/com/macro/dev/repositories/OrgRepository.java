package com.macro.dev.repositories;

import com.macro.dev.models.LutCmmOrganization;
import com.macro.dev.models.LutUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * LutUser repository for CRUD operations.
 */
public interface OrgRepository extends JpaRepository<LutCmmOrganization,Long> {

}
