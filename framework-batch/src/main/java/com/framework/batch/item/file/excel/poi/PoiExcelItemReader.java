package com.framework.batch.item.file.excel.poi;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

import com.framework.batch.item.file.ExcelFileItemReader;

/**
 * <p>EXCEL文件的读接口，使用Apache POI库。</p>
 *
 * @author xia_xiaojie
 * @date 2016/11/08
 * @version 1.0.0
 */
public class PoiExcelItemReader<I> extends ExcelFileItemReader<I> {
	private Workbook workbook;
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

	@Override
	protected void openExcelFile(final Resource resource) throws Exception {
		this.workbook = WorkbookFactory.create(resource.getInputStream());
	}
	
	@Override
	protected PoiSheet getSheet(int sheetNum) {
		return new PoiSheet(this.workbook.getSheetAt(sheetNum));
	}

	@Override
	protected int getNumberOfSheets() {
		return this.workbook.getNumberOfSheets();
	}
	
	@Override
	protected void doCloseWorkbook() throws Exception {
		if (this.workbook != null) {
			this.workbook.close();
		}
	}

	/**
	 * <p>构建ExcelFileItemReader对象。</p>
	 * 
	 * @return ExcelFileItemReader对象
	 */
	public ExcelFileItemReader<I> ready() {
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
