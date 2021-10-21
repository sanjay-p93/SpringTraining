package com.batch.BatchProject.batch;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.batch.BatchProject.model.Student;


@Component
public class Processor implements ItemProcessor<Student, Student> {

	private static final Logger log = LoggerFactory.getLogger(Processor.class);

    private static final Map<String, String> DEPT_NAMES =
            new HashMap<>();

    public Processor() {
		DEPT_NAMES.put("001", "CSE");
		DEPT_NAMES.put("002", "EEE");
		DEPT_NAMES.put("003", "EC");
		DEPT_NAMES.put("004", "Mech");
    }

    @Override
	public Student process(Student student) throws Exception {
		String deptCode = student.getBranch();
        String dept = DEPT_NAMES.get(deptCode);
		student.setBranch(dept);
		student.setTime(new Date());
		log.info("Converting (" + deptCode + ") into (" + dept + ")");
		return student;
    }
}
