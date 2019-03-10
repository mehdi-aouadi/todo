package com.todo.repositories;

import com.mongodb.client.result.DeleteResult;
import com.todo.model.Program;

import java.util.List;
import java.util.UUID;

public interface ProgramRepository {

  Program saveProgram(Program program);

  Program findProgramById(UUID programId);

  List<Program> findProgramsByTitle(String programName, int skip, int limit);

  List<Program> findProgramsByRange(int skip, int limit);

  DeleteResult deleteProgramById(UUID programId);

}
