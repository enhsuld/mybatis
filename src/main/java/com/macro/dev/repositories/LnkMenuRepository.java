/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.macro.dev.repositories;

import com.macro.dev.models.LnkMenurole;
import com.macro.dev.models.LutUser;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface LnkMenuRepository extends CrudRepository<LnkMenurole, Long> {

	List<LutUser> findAll(PageRequest request);
	
	@Query("SELECT t FROM LnkMenurole t where t.roleid = ?1")
	List<LnkMenurole> findById(long appid);
	
}
