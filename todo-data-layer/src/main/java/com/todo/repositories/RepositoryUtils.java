package com.todo.repositories;

import org.slf4j.Logger;

import java.util.UUID;

public interface RepositoryUtils {
  default int checkLimit(int limit, int value, Logger logger) {
    if (value > limit) {
      limit = value;
      logger.warn("Limit exceeded. Set to default value {}.", limit);
    }
    return limit;
  }

  default UUID checkId(UUID id) {
    if (id == null) {
      id = UUID.randomUUID();
    }
    return id;
  }
}
