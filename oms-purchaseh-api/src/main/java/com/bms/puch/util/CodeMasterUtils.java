package com.bms.puch.util;

import com.alibaba.fastjson.TypeReference;
import com.bms.common.entity.DictLeafNodeBean;
import com.bms.common.entity.DictNodeBean;
import com.bms.common.param.FindNodeParam;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 数据字典工具类
 */
@Component
public class CodeMasterUtils {

	@Autowired
	private RestApiClientFactory restApiClientFactory;

	/**
	 * 获取常量
	 */
	public List<DictNodeBean> getCodeMasters(String node) {
		Object obj = LocalCacheUtils.get(node);
		List<DictNodeBean> tempList = null;
		if (obj != null && obj instanceof List) {
			List list = (List) obj;
			if (CollectionUtils.isNotEmpty(list)) {
				tempList = BeanUtils.toList(list, DictNodeBean.class);
				this.sort(tempList);
				return tempList;
			}
		}
		else {
			tempList = this.getDictNodes(node, "CodeMaster");
			if (CollectionUtils.isNotEmpty(tempList)) {
				this.sort(tempList);
				LocalCacheUtils.put(node, tempList, 14400L);
				return tempList;
			}
		}
		return new ArrayList<>();
	}

	/**
	 * 常量排序
	 */
	private void sort(List<DictNodeBean> tempList) {
		Collections.sort(tempList, new Comparator<DictNodeBean>() {
			public int compare(DictNodeBean o1, DictNodeBean o2) {
				return o1.getDataValue().compareTo(o2.getDataValue());
			}
		});
	}

	/**
	 * 从数据库中获得常量
	 */
	private List<DictNodeBean> getDictNodes(String key, String rootCode) {
		FindNodeParam param = new FindNodeParam();
		param.setDictCode(key);
		param.setRootCode(rootCode);
		param.setDetail(true);

		String url = ConfigServerUtils.getAPIUrl("base-dictionary", "api/dict/catalog/_find");
		TypeReference<DictLeafNodeBean> ref = new TypeReference<DictLeafNodeBean>() {};
		DictLeafNodeBean node = this.restApiClientFactory.newApiRestClient().post(url, param, ref);

		List<DictNodeBean> tempList = new LinkedList<>();
		if(node != null) {
			tempList.addAll(node.getValues());
		}
		return tempList;
	}

	/**
	 * 获取常量
	 */
	public Map<String, String> getCodeMaster(String node) {
		Map<String, String> codeMasterMap = new TreeMap<>();
		List<DictNodeBean> dictNodeBeans = this.getCodeMasters(node);
		for (DictNodeBean dictNodeBean : dictNodeBeans) {
			codeMasterMap.put(dictNodeBean.getDataValue(), dictNodeBean.getDataCN());
		}
		return codeMasterMap;
	}

}
