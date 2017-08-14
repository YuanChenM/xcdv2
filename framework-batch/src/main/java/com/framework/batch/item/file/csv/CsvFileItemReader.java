package com.framework.batch.item.file.csv;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.PathResource;
import org.springframework.util.Assert;

import com.framework.batch.item.file.FlatFileItemReader;

/**
 * <p>CSV文件的读接口。</p>
 *
 * @author xia_xiaojie
 * @date 2016/11/08
 * @version 1.0.0
 */
public class CsvFileItemReader<I> extends FlatFileItemReader<I> {
	private String filePath;
	private String[] fieldNames;
	private Class<I> itemClass;
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void setFieldNames(String[] fieldNames) {
		this.fieldNames = fieldNames;
	}

	public void setItemClass(Class<I> itemClass) {
		this.itemClass = itemClass;
	}

	/**
	 * <p>构建CsvFileItemReader对象。</p>
	 * 
	 * @return CsvFileItemReader对象
	 */
	public FlatFileItemReader<I> ready() {
		Assert.notNull(filePath);
		super.setResource(new PathResource(filePath));
		
		Assert.notEmpty(fieldNames);
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames(fieldNames);
		
		Assert.notNull(itemClass);
		BeanWrapperFieldSetMapper<I> fieldSetMapper = new BeanWrapperFieldSetMapper<I>();
		fieldSetMapper.setTargetType(itemClass);
		
		DefaultLineMapper<I> lineMapper = new DefaultLineMapper<I>();
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		
		super.setLineMapper(lineMapper);
		return this;
	}
	
}
