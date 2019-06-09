package com.rvlstudio.nayla.persistence;


import java.util.Optional;

import com.rvlstudio.nayla.entity.Ouder;

public interface OuderDAO extends DAO<Ouder> {
	Optional<Ouder> findByUsername(String username);
}
