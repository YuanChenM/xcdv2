package com.framework.tag;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by zhu_kai1 on 2016/11/28.
 */
public class PagingTag extends TagSupport {

    private static Logger logger = LoggerFactory.getLogger(PagingTag.class);
    /**分页总数**/
    private int pageCount;
    /**分页页码**/
    private int page;
    /**每页展示数**/
    private int pageSize;
    public PagingTag() {
        super();
        this.init();
    }

    private void init(){
        this.pageCount = 0;
        this.page = 1;
        this.pageSize = 0;
    }

    @Override
    public void release() {
        super.release();
        this.init();
    }

    @Override
    public int doStartTag() throws JspException{
        logger.info("data-count:{},data-page:{}",this.pageCount,this.page);
        StringBuffer pagingHtml = new StringBuffer();
        JspWriter out = this.pageContext.getOut();
        pagingHtml.append("<div class='hdatatable' data-toggle='hdatatable' data-count='"+this.pageCount+"' data-page='"+this.page+"' ");
        if(pageSize > 0){
            pagingHtml.append("  data-pagesize='"+this.pageSize+"'");
        }
        pagingHtml.append(">");
        pagingHtml.append("<div class='htable-responsive'>");
        try {
            out.write(pagingHtml.toString());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException{
        StringBuffer pagingHtml = new StringBuffer();
        JspWriter out = this.pageContext.getOut();
        pagingHtml.append("</div>");
        pagingHtml.append("</div>");
        try {
            out.write(pagingHtml.toString());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return EVAL_PAGE;
    }


    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
