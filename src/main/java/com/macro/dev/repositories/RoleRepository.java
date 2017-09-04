package com.macro.dev.repositories;

import com.macro.dev.models.LutCmmOrganization;
import com.macro.dev.models.LutRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * LutUser repository for CRUD operations.
 */
public interface RoleRepository extends JpaRepository<LutRole,Long> {

}
