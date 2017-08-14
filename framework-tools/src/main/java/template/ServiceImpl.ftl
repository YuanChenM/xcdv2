/*
 * ${date} 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
 package ${package};
 import com.bms.sample.dao.UserDao;
 import com.bms.sample.service.${entityName}Service;
 import com.framework.base.dao.BaseDao;
 import com.framework.base.service.impl.BaseServiceImpl;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 /**
 * <p>${entityName}Service接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
 @Service
 public class ${entityName}ServiceImpl extends BaseServiceImpl implements ${entityName}Service{

    @Autowired
    private ${entityName}Dao ${entityName}Dao;

    @Override
    public BaseDao getBaseDao() {
      return ${entityName}Dao;
    }
 }