package com.framework.batch.item.file;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.batch.item.support.AbstractItemCountingItemStreamItemReader;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.ObjectUtils;

import com.framework.batch.item.RowCallbackHandler;
import com.framework.batch.item.file.excel.Sheet;

/**
 * <p>EXCEL文件的读接口。</p>
 *
 * @author xia_xiaojie
 * @date 2016/11/08
 * @version 1.0.0
 */
public abstract class ExcelFileItemReader<I> extends AbstractItemCountingItemStreamItemReader<I> implements ResourceAwareItemReaderItemStream<I>, InitializingBean {
	private static final Logger logger = LoggerFactory.getLogger(ExcelFileItemReader.class);
	
	private Resource resource;
	private int currentSheet = 0;
	private int currentRow = 0;
	private int linesToSkip = 0;
	
	private LineMapper<I> lineMapper;
	private RowCallbackHandler skippedRowsCallback;
	
	private boolean noInput = false;
	private boolean strict = true;

	public ExcelFileItemReader() {
		super.setName(ClassUtils.getShortName(ExcelFileItemReader.class));
	}

	@Override
	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public void setLinesToSkip(int linesToSkip) {
		this.linesToSkip = linesToSkip;
	}

	public void setLineMapper(LineMapper<I> lineMapper) {
		this.lineMapper = lineMapper;
	}

	public void setSkippedRowsCallback(RowCallbackHandler skippedRowsCallback) {
		this.skippedRowsCallback = skippedRowsCallback;
	}

	public void setStrict(boolean strict) {
		this.strict = strict;
	}

	public void afterPropertiesSet() throws Exception {
		Assert.notNull(this.resource, "Resource must be set");
		Assert.notNull(this.lineMapper, "LineMapper must be set");
	}

	@Override
	protected I doRead() throws Exception {
		if (this.noInput) {
			return null;
		}
		final Sheet sheet = this.getSheet(this.currentSheet);
		final String[] cellValues = this.readRow(sheet);
		if (ObjectUtils.isEmpty(cellValues)) {
			this.currentSheet++;
			if (this.currentSheet >= this.getNumberOfSheets()) {
				if (logger.isDebugEnabled()) {
					logger.debug("No more sheets in '" + this.resource.getDescription() + "'.");
				}
				return null;
			}
			else {
				this.currentRow = 0;
				this.openSheet();
				return this.doRead();
			}
		}
		else {
			try {
				String paramString = this.join(cellValues);
				return this.lineMapper.mapLine(paramString, this.currentRow);
			}
			catch (Exception e) {
				throw new ParseException("Parsing error=[" + e.toString() + "] at line=[" + this.currentRow + "] in resource=[" + this.resource.getDescription() + "], sheet=[" + sheet.getName() + "].");
			}
		}
	}
	
	private String join(String[] strs) {
		int length = strs.length;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; ++i) {
			if (i < length - 1) {
				sb.append(strs[i]).append(",");
			}
			else {
				sb.append(strs[i]);
			}
		}
		return sb.toString();
	}

	@Override
	protected void doOpen() throws Exception {
		Assert.notNull(this.resource, "Input resource must be set");
		this.noInput = true;
		if (!this.resource.exists()) {
			if (this.strict) {
				throw new IllegalStateException("Input resource must exist (reader is in 'strict' mode): " + this.resource);
			}
			logger.warn("Input resource does not exist '" + this.resource.getDescription() + "'.");
			return;
		}

		if (!this.resource.isReadable()) {
			if (this.strict) {
				throw new IllegalStateException("Input resource must be readable (reader is in 'strict' mode): " + this.resource);
			}
			logger.warn("Input resource is not readable '" + this.resource.getDescription() + "'.");
			return;
		}

		this.noInput = false;
		this.openExcelFile(this.resource);
		this.openSheet();
		if (logger.isDebugEnabled()) {
			logger.debug("Opened workbook [" + this.resource.getFilename() + "] with " + this.getNumberOfSheets() + " sheets.");
		}
	}

	private String[] readRow(Sheet sheet) {
		if (sheet != null && this.currentRow < sheet.getNumberOfRows()) {
			String[] cellValues = sheet.getCellValues(this.currentRow);
			this.currentRow++;
			return cellValues;
		}
		return null;
	}

	private void openSheet() {
		final Sheet sheet = this.getSheet(this.currentSheet);
		if (logger.isDebugEnabled()) {
			logger.debug("Opening sheet " + sheet.getName() + ".");
		}
		for (int i = 0; i < this.linesToSkip; i++) {
			final String[] cellValues = this.readRow(sheet);
			if (this.skippedRowsCallback != null) {
				this.skippedRowsCallback.handleRow(sheet, cellValues);
			}
		}
		if (logger.isDebugEnabled()) {
			logger.debug("Openend sheet " + sheet.getName() + ", with " + sheet.getNumberOfRows() + " rows.");
		}
	}

	@Override
	protected final void doClose() throws Exception {
		doCloseWorkbook();
		if (this.resource != null) {
			try {
				InputStream is = this.resource.getInputStream();
				is.close();
			}
			catch (IOException e) {
				logger.warn("Exception whilst obtaining or closing the inputstream.", e);
			}
		}
	}

	protected abstract void doCloseWorkbook() throws Exception;
	protected abstract void openExcelFile(Resource resource) throws Exception;
	protected abstract int getNumberOfSheets();
	protected abstract Sheet getSheet(int sheetNum);

}
