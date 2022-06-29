package net.yorksolutions.jsontestremake;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CacheRepository extends CrudRepository<Cache, Long> {
	Optional<Cache> findByMd5Input(String md5Input);
}
