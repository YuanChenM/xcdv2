package com.framework.batch.item.file.csv;

import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.PathResource;
import org.springframework.util.Assert;

import com.framework.batch.item.file.FlatFileItemWriter;

/**
 * <p>CSV文件的写接口。</p>
 *
 * @author xia_xiaojie
 * @date 2016/11/08
 * @version 1.0.0
 */
public class CsvFileItemWriter<O> extends FlatFileItemWriter<O> {
	private String filePath;
	private String[] fieldNames;
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void setFieldNames(String[] fieldNames) {
		this.fieldNames = fieldNames;
	}

	/**
	 * <p>构建CsvFileItemWriter对象。</p>
	 * 
	 * @return CsvFileItemWriter对象
	 */
	public FlatFileItemWriter<O> ready() {
		Assert.notNull(filePath);
		super.setResource(new PathResource(filePath));
		
		Assert.notEmpty(fieldNames);
		BeanWrapperFieldExtractor<O> fieldExtractor = new BeanWrapperFieldExtractor<O>();
		fieldExtractor.setNames(fieldNames);
		
		DelimitedLineAggregator<O> lineAggregator = new DelimitedLineAggregator<O>();
		lineAggregator.setFieldExtractor(fieldExtractor);
		
		super.setLineAggregator(lineAggregator);
		return this;
	}
	
}
