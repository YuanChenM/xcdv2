<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//ibatis.apache.org//DTD Mapper 3.0//EN" "http://ibatis.apache.org/dtd/ibatis-3-mapper.dtd">
<mapper namespace="${daoPackage}.${entityName}Dao">
    <!-- 查询字段 -->
	<sql id="selectColumns">
${selectColumns}
	</sql>
	
	<insert id="save" parameterType="${entityPackage}.${entityName}">
		INSERT INTO ${tableName} (
${insertColumns}			
		)
		VALUES (
${insertValues}
		)
	</insert>
	
	<update id="modify" parameterType="${entityPackage}.${entityName}">
		UPDATE ${tableName} 
		SET 
${updateColumns}
		WHERE
${updateCondtions}		
	</update>
	
	<select id="findOne" parameterType="long" resultType="${entityPackage}.${entityName}">
		SELECT 
			<include refid="selectColumns" />
		FROM 
			${tableName}
		WHERE	
${updateCondtions}	
	</select>
	
	<select id="findAll" parameterType="com.framework.base.bean.param.rest.BaseRestParam" resultType="${entityPackage}.${entityName}">
		SELECT 
			<include refid="selectColumns" />
		FROM 
			${tableName}
		WHERE	
${selectConditions}		
	</select>
	
	<select id="countAll" parameterType="com.framework.base.bean.param.rest.BaseRestParam" resultType="int">
		SELECT 
			count(1)
		FROM 
			${tableName}
		WHERE	
${selectConditions}				
	</select>
	
	<#if isValid>
		<select id="findValidList" parameterType="int" resultType="${entityPackage}.${entityName}">
   			SELECT 
    			<include refid="selectColumns" />
   			FROM 
   				${tableName}
   			WHERE 
   				ISVALID = ${aaa}
  		</select>
	</#if> 
</mapper>
