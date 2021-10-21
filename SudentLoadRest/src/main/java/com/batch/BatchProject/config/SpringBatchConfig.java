package com.batch.BatchProject.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.batch.BatchProject.model.Student;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory,
                   StepBuilderFactory stepBuilderFactory,
			ItemReader<Student> itemReader, ItemProcessor<Student, Student> itemProcessor,
			ItemWriter<Student> itemWriter
    ) {
		// create step with name
		Step step = stepBuilderFactory.get("Student-detail-load").<Student, Student>chunk(10)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();

		// job with name load
		return jobBuilderFactory.get("Load-Student-File-DB")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }

    @Bean
	public FlatFileItemReader<Student> itemReader() {

		FlatFileItemReader<Student> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(new FileSystemResource("src/main/resources/student.csv"));
		flatFileItemReader.setName("File-Reader");
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setLineMapper(lineMapper());
        return flatFileItemReader;
    }

    @Bean
	public LineMapper<Student> lineMapper() {

		DefaultLineMapper<Student> defaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
		lineTokenizer.setNames("id", "name", "branch");

		BeanWrapperFieldSetMapper<Student> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Student.class);

        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);

        return defaultLineMapper;
    }

}
