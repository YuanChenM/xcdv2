package com.bms.issue.validator;

import java.io.Serializable;
import java.util.Date;

import com.bms.issue.constant.ValidatorConst;
import com.bms.issue.constant.enumeration.AccessoryType;
import com.bms.issue.constant.enumeration.HandlingResult;
import com.bms.issue.constant.enumeration.HandlingType;
import com.bms.issue.constant.enumeration.InitiatorType;
import com.bms.issue.constant.enumeration.IssueStatus;
import com.bms.issue.constant.enumeration.OrderType;
import com.bms.issue.constant.enumeration.QuestionCatagory1;
import com.bms.issue.constant.i18n.FieldCode;
import com.bms.issue.constant.i18n.ValidatorCode;
import com.framework.exception.bean.ValidatorExceptionMessage;
import com.framework.validator.DefaultCustomValidator;
import com.framework.validator.utils.NumberValidator;

public abstract class IssueValidatorGenerated<T extends Serializable> extends DefaultCustomValidator<T> {

    /**
     * 验证问题订单ID
     * 
     * @param issueId
     *            问题订单ID
     */
    protected void validateIssueId(Long issueId, boolean required) {
        validatorLong(FieldCode.ISSUE_ID, issueId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证问题订单编号
     * 
     * @param issueCode
     *            问题订单编号
     */
    protected void validateIssueCode(String issueCode, boolean required) {
        this.validatorMaxLength(FieldCode.ISSUE_CODE, issueCode, required, ValidatorConst.MAX_LENGTH_ISSUE_CODE);
    }

    /**
     * 验证原始订单ID
     * 
     * @param orderId
     *            原始订单ID
     */
    protected void validateOrderId(Long orderId, boolean required) {
        validatorLong(FieldCode.ORDER_ID, orderId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证原始订单编号
     * 
     * @param orderCode
     *            原始订单编号
     */
    protected void validateOrderCode(String orderCode, boolean required) {
        this.validatorMaxLength(FieldCode.ORDER_CODE, orderCode, required, ValidatorConst.MAX_LENGTH_ORDER_CODE);
    }

    /**
     * 验证原始订单类型
     * 
     * @param orderType
     *            原始订单类型
     */
    protected void validateOrderType(String orderType, boolean required) {
        OrderType type = OrderType.getInstance(orderType);
        if (required)
            validatorRequired(FieldCode.ORDER_TYPE, orderType);
        if (orderType != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.ORDER_TYPE, FieldCode.ORDER_TYPE, orderType));
        }
    }

    /**
     * 验证区域：物流区编码
     * 
     * @param logisticsZoneCode
     *            区域：物流区编码
     */
    protected void validateLogisticsZoneCode(String logisticsZoneCode, boolean required) {
        this.validatorMaxLength(FieldCode.LOGISTICS_ZONE_CODE, logisticsZoneCode, required,
                ValidatorConst.MAX_LENGTH_LOGISTICS_ZONE_CODE);
    }

    /**
     * 验证区域：物流区名称
     * 
     * @param logisticsZoneName
     *            区域：物流区名称
     */
    protected void validateLogisticsZoneName(String logisticsZoneName, boolean required) {
        this.validatorMaxLength(FieldCode.LOGISTICS_ZONE_NAME, logisticsZoneName, required,
                ValidatorConst.MAX_LENGTH_LOGISTICS_ZONE_NAME);
    }

    /**
     * 验证区域：物流区ID
     * 
     * @param logisticsZoneId
     *            区域：物流区ID
     */
    protected void validateLogisticsZoneId(Long logisticsZoneId, boolean required) {
        validatorLong(FieldCode.LOGISTICS_ZONE_ID, logisticsZoneId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证买家：买家ID
     * 
     * @param buyerId
     *            买家：买家ID
     */
    protected void validateBuyerId(String buyerId, boolean required) {
        this.validatorMaxLength(FieldCode.BUYER_ID, buyerId, required, ValidatorConst.MAX_LENGTH_BUYER_ID);
    }

    /**
     * 验证买家：买家编码
     * 
     * @param buyerCode
     *            买家：买家编码
     */
    protected void validateBuyerCode(String buyerCode, boolean required) {
        this.validatorMaxLength(FieldCode.BUYER_CODE, buyerCode, required, ValidatorConst.MAX_LENGTH_BUYER_CODE);
    }

    /**
     * 验证买家：买家名称
     * 
     * @param buyerName
     *            买家：买家名称
     */
    protected void validateBuyerName(String buyerName, boolean required) {
        this.validatorMaxLength(FieldCode.BUYER_NAME, buyerName, required, ValidatorConst.MAX_LENGTH_BUYER_NAME);
    }

    /**
     * 验证发起人类型
     * 
     * @param initiatorType
     *            发起人类型
     */
    protected void validateInitiatorType(String initiatorType, boolean required) {
        InitiatorType type = InitiatorType.getInstance(initiatorType);
        if (required)
            validatorRequired(FieldCode.INITIATOR_TYPE, initiatorType);
        if (initiatorType != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.INITIATOR_TYPE, FieldCode.INITIATOR_TYPE, initiatorType));
        }
    }

    /**
     * 验证发起人ID
     * 
     * @param initiatorId
     *            发起人ID
     */
    protected void validateInitiatorId(String initiatorId, boolean required) {
        this.validatorMaxLength(FieldCode.INITIATOR_ID, initiatorId, required, ValidatorConst.MAX_LENGTH_INITIATOR_ID);
    }

    /**
     * 验证发起人名称
     * 
     * @param initiatorName
     *            发起人名称
     */
    protected void validateInitiatorName(String initiatorName, boolean required) {
        this.validatorMaxLength(FieldCode.INITIATOR_NAME, initiatorName, required,
                ValidatorConst.MAX_LENGTH_INITIATOR_NAME);
    }

    /**
     * 验证发起时间
     * 
     * @param initiateTime
     *            发起时间
     */
    protected void validateInitiateTime(Date initiateTime, boolean required) {
        validatorDate(FieldCode.INITIATE_TIME, initiateTime, required);
    }

    /**
     * 验证发起时间
     * 
     * @param initiateTime
     *            发起时间
     */
    protected void validateInitiateTime(String initiateTime, boolean required) {
        validatorStrDate(FieldCode.INITIATE_TIME, initiateTime, required, ValidatorConst.FORMAT_INITIATE_TIME);
    }

    /**
     * 验证发起开始时间
     *
     * @param initiateTime
     *            发起时间
     */
    protected void validateInitiateTimeFrom(String initiateTime, boolean required) {
        validatorStrDate(FieldCode.INITIATE_TIME, initiateTime, required, ValidatorConst.FORMAT_TIME_FROM);
    }

    /**
     * 验证发起结束时间
     *
     * @param initiateTime
     *            发起时间
     */
    protected void validateInitiateTimeTo(String initiateTime, boolean required) {
        validatorStrDate(FieldCode.INITIATE_TIME, initiateTime, required, ValidatorConst.FORMAT_TIME_TO);
    }

    /**
     * 验证问题概述
     * 
     * @param issueDesc
     *            问题概述
     */
    protected void validateIssueDesc(String issueDesc, boolean required) {
        this.validatorMaxLength(FieldCode.ISSUE_DESC, issueDesc, required, ValidatorConst.MAX_LENGTH_ISSUE_DESC);
    }

    /**
     * 验证问题订单处理结果
     * 
     * @param issueResult
     *            问题订单处理结果
     */
    protected void validateIssueResult(String issueResult, boolean required) {
        this.validatorMaxLength(FieldCode.ISSUE_RESULT, issueResult, required, ValidatorConst.MAX_LENGTH_ISSUE_RESULT);
    }

    /**
     * 验证问题订单处理结论
     * 
     * @param issueDecision
     *            问题订单处理结论
     */
    protected void validateIssueDecision(String issueDecision, boolean required) {
        this.validatorMaxLength(FieldCode.ISSUE_DECISION, issueDecision, required,
                ValidatorConst.MAX_LENGTH_ISSUE_DECISION);
    }

    /**
     * 验证结案人ID
     * 
     * @param closeUid
     *            结案人ID
     */
    protected void validateCloseUid(String closeUid, boolean required) {
        this.validatorMaxLength(FieldCode.CLOSE_UID, closeUid, required, ValidatorConst.MAX_LENGTH_CLOSE_UID);
    }

    /**
     * 验证结案人名称
     * 
     * @param closeUname
     *            结案人名称
     */
    protected void validateCloseUname(String closeUname, boolean required) {
        this.validatorMaxLength(FieldCode.CLOSE_UNAME, closeUname, required, ValidatorConst.MAX_LENGTH_CLOSE_UNAME);
    }

    /**
     * 验证结案时间
     * 
     * @param closeTime
     *            结案时间
     */
    protected void validateCloseTime(Date closeTime, boolean required) {
        validatorDate(FieldCode.CLOSE_TIME, closeTime, required);
    }

    /**
     * 验证结案时间
     * 
     * @param closeTime
     *            结案时间
     */
    protected void validateCloseTime(String closeTime, boolean required) {
        validatorStrDate(FieldCode.CLOSE_TIME, closeTime, required, ValidatorConst.FORMAT_CLOSE_TIME);
    }

    /**
     * 验证结案开始时间
     *
     * @param closeTime
     *            结案时间
     */
    protected void validateCloseTimeFrom(String closeTime, boolean required) {
        validatorStrDate(FieldCode.CLOSE_TIME, closeTime, required, ValidatorConst.FORMAT_TIME_FROM);
    }

    /**
     * 验证结案结束时间
     *
     * @param closeTime
     *            结案时间
     */
    protected void validateCloseTimeTo(String closeTime, boolean required) {
        validatorStrDate(FieldCode.CLOSE_TIME, closeTime, required, ValidatorConst.FORMAT_TIME_TO);
    }

    /**
     * 验证问题订单状态
     * 
     * @param issueStatus
     *            问题订单状态
     */
    protected void validateIssueStatus(String issueStatus, boolean required) {
        IssueStatus type = IssueStatus.getInstance(issueStatus);
        if (required)
            validatorRequired(FieldCode.ISSUE_STATUS, issueStatus);
        if (issueStatus != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.ISSUE_STATUS, FieldCode.ISSUE_STATUS, issueStatus));
        }
    }

    /**
     * 验证共通：删除标志
     * 
     * @param delFlg
     *            共通：删除标志
     */
    protected void validateDelFlg(Boolean delFlg, boolean required) {
        if (required)
            validatorRequired(FieldCode.DEL_FLG, delFlg);
    }

    /**
     * 验证共通：创建者ID
     * 
     * @param crtId
     *            共通：创建者ID
     */
    protected void validateCrtId(String crtId, boolean required) {
        this.validatorMaxLength(FieldCode.CRT_ID, crtId, required, ValidatorConst.MAX_LENGTH_CRT_ID);
    }

    /**
     * 验证共通：创建日时
     * 
     * @param crtTime
     *            共通：创建日时
     */
    protected void validateCrtTime(Date crtTime, boolean required) {
        validatorDate(FieldCode.CRT_TIME, crtTime, required);
    }

    /**
     * 验证共通：创建日时
     * 
     * @param crtTime
     *            共通：创建日时
     */
    protected void validateCrtTime(String crtTime, boolean required) {
        validatorStrDate(FieldCode.CRT_TIME, crtTime, required, ValidatorConst.FORMAT_CRT_TIME);
    }

    /**
     * 验证共通：更新者ID
     * 
     * @param updId
     *            共通：更新者ID
     */
    protected void validateUpdId(String updId, boolean required) {
        this.validatorMaxLength(FieldCode.UPD_ID, updId, required, ValidatorConst.MAX_LENGTH_UPD_ID);
    }

    /**
     * 验证共通：更新日时
     * 
     * @param updTime
     *            共通：更新日时
     */
    protected void validateUpdTime(Date updTime, boolean required) {
        validatorDate(FieldCode.UPD_TIME, updTime, required);
    }

    /**
     * 验证共通：更新日时
     * 
     * @param updTime
     *            共通：更新日时
     */
    protected void validateUpdTime(String updTime, boolean required) {
        validatorStrDate(FieldCode.UPD_TIME, updTime, required, ValidatorConst.FORMAT_UPD_TIME);
    }

    /**
     * 验证共通：版本号
     * 
     * @param version
     *            共通：版本号
     */
    protected void validateVersion(Integer version, boolean required) {
        validatorInteger(FieldCode.VERSION, version, required, ValidatorConst.MAX_VALUE_VERSION,
                ValidatorConst.MIN_VALUE_VERSION, NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证问题ID
     * 
     * @param questionId
     *            问题ID
     */
    protected void validateQuestionId(Long questionId, boolean required) {
        validatorLong(FieldCode.QUESTION_ID, questionId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证问题处理单编号
     * 
     * @param questionCode
     *            问题处理单编号
     */
    protected void validateQuestionCode(String questionCode, boolean required) {
        this.validatorMaxLength(FieldCode.QUESTION_CODE, questionCode, required,
                ValidatorConst.MAX_LENGTH_QUESTION_CODE);
    }

    /**
     * 验证订单明细ID
     * 
     * @param orderDetailId
     *            订单明细ID
     */
    protected void validateOrderDetailId(Long orderDetailId, boolean required) {
        validatorLong(FieldCode.ORDER_DETAIL_ID, orderDetailId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证问题一级分类
     * 
     * @param questionCatagory1
     *            问题一级分类
     */
    protected void validateQuestionCatagory1(String questionCatagory1, boolean required) {
        QuestionCatagory1 type = QuestionCatagory1.getInstance(questionCatagory1);
        if (required)
            validatorRequired(FieldCode.QUESTION_CATAGORY_1, questionCatagory1);
        if (questionCatagory1 != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.QUESTION_CATAGORY_1, FieldCode.QUESTION_CATAGORY_1, questionCatagory1));
        }
    }

    /**
     * 验证问题二级分类
     * 
     * @param questionCatagory2
     *            问题二级分类
     */
    protected void validateQuestionCatagory2(String questionCatagory2, boolean required) {
        // QuestionCatagory2 type = QuestionCatagory2.getInstance(questionCatagory2);
        // if (required)
        // validatorRequired(FieldCode.QUESTION_CATAGORY_2, questionCatagory2);
        // if (questionCatagory2 != null && type == null) {
        // getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
        // null, FieldCode.QUESTION_CATAGORY_2, FieldCode.QUESTION_CATAGORY_2, questionCatagory2));
        // }
    }

    /**
     * 验证问题三级分类
     * 
     * @param questionCatagory3
     *            问题三级分类
     */
    protected void validateQuestionCatagory3(String questionCatagory3, boolean required) {
        // QuestionCatagory3 type = QuestionCatagory3.getInstance(questionCatagory3);
        // if (required)
        // validatorRequired(FieldCode.QUESTION_CATAGORY_3, questionCatagory3);
        // if (questionCatagory3 != null && type == null) {
        // getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
        // null, FieldCode.QUESTION_CATAGORY_3, FieldCode.QUESTION_CATAGORY_3, questionCatagory3));
        // }
    }

    /**
     * 验证问题关键词
     * 
     * @param questionKeyword
     *            问题关键词
     */
    protected void validateQuestionKeyword(String questionKeyword, boolean required) {
        this.validatorMaxLength(FieldCode.QUESTION_KEYWORD, questionKeyword, required,
                ValidatorConst.MAX_LENGTH_QUESTION_KEYWORD);
    }

    /**
     * 验证问题描述
     * 
     * @param questionDesc
     *            问题描述
     */
    protected void validateQuestionDesc(String questionDesc, boolean required) {
        this.validatorMaxLength(FieldCode.QUESTION_DESC, questionDesc, required,
                ValidatorConst.MAX_LENGTH_QUESTION_DESC);
    }

    /**
     * 验证问题管理立项时间
     * 
     * @param questionStartTime
     *            问题管理立项时间
     */
    protected void validateQuestionStartTime(Date questionStartTime, boolean required) {
        validatorDate(FieldCode.QUESTION_START_TIME, questionStartTime, required);
    }

    /**
     * 验证问题管理立项时间
     * 
     * @param questionStartTime
     *            问题管理立项时间
     */
    protected void validateQuestionStartTime(String questionStartTime, boolean required) {
        validatorStrDate(FieldCode.QUESTION_START_TIME, questionStartTime, required,
                ValidatorConst.FORMAT_QUESTION_START_TIME);
    }

    /**
     * 验证问题管理立项開始时间
     *
     * @param questionStartTime
     *            结案时间
     */
    protected void validateQuestionStartTimeFrom(String questionStartTime, boolean required) {
        validatorStrDate(FieldCode.QUESTION_START_TIME, questionStartTime, required, ValidatorConst.FORMAT_TIME_FROM);
    }

    /**
     * 验证问题管理立项結束时间
     *
     * @param questionStartTime
     *            结案时间
     */
    protected void validateQuestionStartTimeTo(String questionStartTime, boolean required) {
        validatorStrDate(FieldCode.QUESTION_START_TIME, questionStartTime, required, ValidatorConst.FORMAT_TIME_TO);
    }

    /**
     * 验证问题管理立项人ID
     * 
     * @param questionStartUid
     *            问题管理立项人ID
     */
    protected void validateQuestionStartUid(String questionStartUid, boolean required) {
        this.validatorMaxLength(FieldCode.QUESTION_START_UID, questionStartUid, required,
                ValidatorConst.MAX_LENGTH_QUESTION_START_UID);
    }

    /**
     * 验证问题管理立项人名称
     * 
     * @param questionStartUname
     *            问题管理立项人名称
     */
    protected void validateQuestionStartUname(String questionStartUname, boolean required) {
        this.validatorMaxLength(FieldCode.QUESTION_START_UNAME, questionStartUname, required,
                ValidatorConst.MAX_LENGTH_QUESTION_START_UNAME);
    }

    /**
     * 验证问题管理是否结案
     * 
     * @param questionIsClose
     *            问题管理是否结案
     */
    protected void validateQuestionIsClose(Boolean questionIsClose, boolean required) {
        if (required)
            validatorRequired(FieldCode.QUESTION_IS_CLOSE, questionIsClose);
    }

    /**
     * 验证问题管理结案时间
     * 
     * @param questionCloseTime
     *            问题管理结案时间
     */
    protected void validateQuestionCloseTime(Date questionCloseTime, boolean required) {
        validatorDate(FieldCode.QUESTION_CLOSE_TIME, questionCloseTime, required);
    }

    /**
     * 验证问题管理结案时间
     * 
     * @param questionCloseTime
     *            问题管理结案时间
     */
    protected void validateQuestionCloseTime(String questionCloseTime, boolean required) {
        validatorStrDate(FieldCode.QUESTION_CLOSE_TIME, questionCloseTime, required,
                ValidatorConst.FORMAT_QUESTION_CLOSE_TIME);
    }

    /**
     * 验证问题管理结案開始时间
     *
     * @param questionCloseTime
     *            问题管理结案时间
     */
    protected void validateQuestionCloseTimeFrom(String questionCloseTime, boolean required) {
        validatorStrDate(FieldCode.QUESTION_CLOSE_TIME, questionCloseTime, required,
                ValidatorConst.FORMAT_TIME_FROM);
    }


    /**
     * 验证问题管理结案開始时间
     *
     * @param questionCloseTime
     *            问题管理结案时间
     */
    protected void validateQuestionCloseTimeTo(String questionCloseTime, boolean required) {
        validatorStrDate(FieldCode.QUESTION_CLOSE_TIME, questionCloseTime, required,
                ValidatorConst.FORMAT_TIME_TO);
    }

    /**
     * 验证问题管理结案人
     * 
     * @param questionCloseUid
     *            问题管理结案人
     */
    protected void validateQuestionCloseUid(String questionCloseUid, boolean required) {
        this.validatorMaxLength(FieldCode.QUESTION_CLOSE_UID, questionCloseUid, required,
                ValidatorConst.MAX_LENGTH_QUESTION_CLOSE_UID);
    }

    /**
     * 验证问题管理结案人名称
     * 
     * @param questionCloseUname
     *            问题管理结案人名称
     */
    protected void validateQuestionCloseUname(String questionCloseUname, boolean required) {
        this.validatorMaxLength(FieldCode.QUESTION_CLOSE_UNAME, questionCloseUname, required,
                ValidatorConst.MAX_LENGTH_QUESTION_CLOSE_UNAME);
    }

    /**
     * 验证问题附件ID
     * 
     * @param accessoryId
     *            问题附件ID
     */
    protected void validateAccessoryId(Long accessoryId, boolean required) {
        validatorLong(FieldCode.ACCESSORY_ID, accessoryId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证附件所属主体类型
     * 
     * @param accessoryType
     *            附件所属主体类型
     */
    protected void validateAccessoryType(String accessoryType, boolean required) {
        AccessoryType type = AccessoryType.getInstance(accessoryType);
        if (required)
            validatorRequired(FieldCode.ACCESSORY_TYPE, accessoryType);
        if (accessoryType != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.ACCESSORY_TYPE, FieldCode.ACCESSORY_TYPE, accessoryType));
        }
    }

    /**
     * 验证问题点ID
     * 
     * @param itemId
     *            问题点ID
     */
    protected void validateItemId(Long itemId, boolean required) {
        validatorLong(FieldCode.ITEM_ID, itemId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证附件文件
     * 
     * @param fileId
     *            附件文件
     */
    protected void validateFileId(String fileId, boolean required) {
        this.validatorMaxLength(FieldCode.FILE_ID, fileId, required, ValidatorConst.MAX_LENGTH_FILE_ID);
    }

    /**
     * 验证附件名称
     * 
     * @param fileName
     *            附件名称
     */
    protected void validateFileName(String fileName, boolean required) {
        this.validatorMaxLength(FieldCode.FILE_NAME, fileName, required, ValidatorConst.MAX_LENGTH_FILE_NAME);
    }

    /**
     * 验证附件类型
     * 
     * @param fileType
     *            附件类型
     */
    protected void validateFileType(String fileType, boolean required) {
        this.validatorMaxLength(FieldCode.FILE_TYPE, fileType, required, ValidatorConst.MAX_LENGTH_FILE_TYPE);
    }

    /**
     * 验证问题点描述
     * 
     * @param itemDesc
     *            问题点描述
     */
    protected void validateItemDesc(String itemDesc, boolean required) {
        this.validatorMaxLength(FieldCode.ITEM_DESC, itemDesc, required, ValidatorConst.MAX_LENGTH_ITEM_DESC);
    }

    /**
     * 验证问题点执行方案
     * 
     * @param itemSolution
     *            问题点执行方案
     */
    protected void validateItemSolution(String itemSolution, boolean required) {
        this.validatorMaxLength(FieldCode.ITEM_SOLUTION, itemSolution, required,
                ValidatorConst.MAX_LENGTH_ITEM_SOLUTION);
    }

    /**
     * 验证问题点方案执行人
     * 
     * @param itemExcutor
     *            问题点方案执行人
     */
    protected void validateItemExcutor(String itemExcutor, boolean required) {
        this.validatorMaxLength(FieldCode.ITEM_EXCUTOR, itemExcutor, required, ValidatorConst.MAX_LENGTH_ITEM_EXCUTOR);
    }

    /**
     * 验证问题点方案执行时间
     * 
     * @param itemStartTime
     *            问题点方案执行时间
     */
    protected void validateItemStartTime(Date itemStartTime, boolean required) {
        validatorDate(FieldCode.ITEM_START_TIME, itemStartTime, required);
    }

    /**
     * 验证问题点方案执行时间
     * 
     * @param itemStartTime
     *            问题点方案执行时间
     */
    protected void validateItemStartTime(String itemStartTime, boolean required) {
        validatorStrDate(FieldCode.ITEM_START_TIME, itemStartTime, required, ValidatorConst.FORMAT_ITEM_START_TIME);
    }

    /**
     * 验证问题点方案执行開始时间
     *
     * @param itemStartTime
     *            问题点方案执行时间
     */
    protected void validateItemStartTimeFrom(String itemStartTime, boolean required) {
        validatorStrDate(FieldCode.ITEM_START_TIME, itemStartTime, required,
                ValidatorConst.FORMAT_TIME_FROM);
    }

    /**
     * 验证问题点方案执行結束时间
     *
     * @param itemStartTime
     *            问题点方案执行时间
     */
    protected void validateItemStartTimeTo(String itemStartTime, boolean required) {
        validatorStrDate(FieldCode.ITEM_START_TIME, itemStartTime, required,
                ValidatorConst.FORMAT_TIME_TO);
    }

    /**
     * 验证问题点处理完成时间
     * 
     * @param itemEndTime
     *            问题点处理完成时间
     */
    protected void validateItemEndTime(Date itemEndTime, boolean required) {
        validatorDate(FieldCode.ITEM_END_TIME, itemEndTime, required);
    }

    /**
     * 验证问题点处理完成时间
     * 
     * @param itemEndTime
     *            问题点处理完成时间
     */
    protected void validateItemEndTime(String itemEndTime, boolean required) {
        validatorStrDate(FieldCode.ITEM_END_TIME, itemEndTime, required, ValidatorConst.FORMAT_ITEM_END_TIME);
    }

    /**
     * 验证问题点处理完成開開始时间
     *
     * @param itemEndTime
     *            问题点处理完成时间
     */
    protected void validateItemEndTimeFrom(String itemEndTime, boolean required) {
        validatorStrDate(FieldCode.ITEM_END_TIME, itemEndTime, required,
                ValidatorConst.FORMAT_TIME_FROM);
    }

    /**
     * 验证问题点处理完成開結束时间
     *
     * @param itemEndTime
     *            问题点处理完成时间
     */
    protected void validateItemEndTimeTo(String itemEndTime, boolean required) {
        validatorStrDate(FieldCode.ITEM_END_TIME, itemEndTime, required,
                ValidatorConst.FORMAT_TIME_TO);
    }

    /**
     * 验证问题点处理结果
     * 
     * @param itemResult
     *            问题点处理结果
     */
    protected void validateItemResult(String itemResult, boolean required) {
        this.validatorMaxLength(FieldCode.ITEM_RESULT, itemResult, required, ValidatorConst.MAX_LENGTH_ITEM_RESULT);
    }

    /**
     * 验证当事人意见
     * 
     * @param itemFeedback
     *            当事人意见
     */
    protected void validateItemFeedback(String itemFeedback, boolean required) {
        this.validatorMaxLength(FieldCode.ITEM_FEEDBACK, itemFeedback, required,
                ValidatorConst.MAX_LENGTH_ITEM_FEEDBACK);
    }

    /**
     * 验证问题点结案人
     * 
     * @param itemCloser
     *            问题点结案人
     */
    protected void validateItemCloser(String itemCloser, boolean required) {
        this.validatorMaxLength(FieldCode.ITEM_CLOSER, itemCloser, required, ValidatorConst.MAX_LENGTH_ITEM_CLOSER);
    }

    /**
     * 验证问题点结案时间
     * 
     * @param itemCloseTime
     *            问题点结案时间
     */
    protected void validateItemCloseTime(Date itemCloseTime, boolean required) {
        validatorDate(FieldCode.ITEM_CLOSE_TIME, itemCloseTime, required);
    }

    /**
     * 验证问题点结案时间
     * 
     * @param itemCloseTime
     *            问题点结案时间
     */
    protected void validateItemCloseTime(String itemCloseTime, boolean required) {
        validatorStrDate(FieldCode.ITEM_CLOSE_TIME, itemCloseTime, required, ValidatorConst.FORMAT_ITEM_CLOSE_TIME);
    }

    /**
     * 验证问题点结案開始时间
     *
     * @param itemCloseTime
     *            问题点结案时间
     */
    protected void validateItemCloseTimeFrom(String itemCloseTime, boolean required) {
        validatorStrDate(FieldCode.ITEM_CLOSE_TIME, itemCloseTime, required,
                ValidatorConst.FORMAT_TIME_FROM);
    }

    /**
     * 验证问题点结案結束时间
     *
     * @param itemCloseTime
     *            问题点结案时间
     */
    protected void validateItemCloseTimeTo(String itemCloseTime, boolean required) {
        validatorStrDate(FieldCode.ITEM_CLOSE_TIME, itemCloseTime, required,
                ValidatorConst.FORMAT_TIME_TO);
    }

    /**
     * 验证问题管理ID
     * 
     * @param handlingId
     *            问题管理ID
     */
    protected void validateHandlingId(Long handlingId, boolean required) {
        validatorLong(FieldCode.HANDLING_ID, handlingId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证问题管理类型
     * 
     * @param handlingType
     *            问题管理类型
     */
    protected void validateHandlingType(String handlingType, boolean required) {
        HandlingType type = HandlingType.getInstance(handlingType);
        if (required)
            validatorRequired(FieldCode.HANDLING_TYPE, handlingType);
        if (handlingType != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.HANDLING_TYPE, FieldCode.HANDLING_TYPE, handlingType));
        }
    }

    /**
     * 验证申请或建议的内容
     * 
     * @param handlingContent
     *            申请或建议的内容
     */
    protected void validateHandlingContent(String handlingContent, boolean required) {
        this.validatorMaxLength(FieldCode.HANDLING_CONTENT, handlingContent, required,
                ValidatorConst.MAX_LENGTH_HANDLING_CONTENT);
    }

    /**
     * 验证提交申请或建议的时间
     * 
     * @param handlingTime
     *            提交申请或建议的时间
     */
    protected void validateHandlingTime(Date handlingTime, boolean required) {
        validatorDate(FieldCode.HANDLING_TIME, handlingTime, required);
    }

    /**
     * 验证提交申请或建议的时间
     * 
     * @param handlingTime
     *            提交申请或建议的时间
     */
    protected void validateHandlingTime(String handlingTime, boolean required) {
        validatorStrDate(FieldCode.HANDLING_TIME, handlingTime, required, ValidatorConst.FORMAT_HANDLING_TIME);
    }

    /**
     * 验证提交申请或建议的開始时间
     *
     * @param handlingTime
     *            提交申请或建议的时间
     */
    protected void validateHandlingTimeFrom(String handlingTime, boolean required) {
        validatorStrDate(FieldCode.HANDLING_TIME, handlingTime, required,
                ValidatorConst.FORMAT_TIME_FROM);
    }

    /**
     * 验证提交申请或建议的開始时间
     *
     * @param handlingTime
     *            提交申请或建议的时间
     */
    protected void validateHandlingTimeTo(String handlingTime, boolean required) {
        validatorStrDate(FieldCode.HANDLING_TIME, handlingTime, required,
                ValidatorConst.FORMAT_TIME_TO);
    }

    /**
     * 验证提交申请或建议的人员ID
     * 
     * @param handlingUid
     *            提交申请或建议的人员ID
     */
    protected void validateHandlingUid(String handlingUid, boolean required) {
        this.validatorMaxLength(FieldCode.HANDLING_UID, handlingUid, required, ValidatorConst.MAX_LENGTH_HANDLING_UID);
    }

    /**
     * 验证提交申请或建议的人员名称
     * 
     * @param handlingUname
     *            提交申请或建议的人员名称
     */
    protected void validateHandlingUname(String handlingUname, boolean required) {
        this.validatorMaxLength(FieldCode.HANDLING_UNAME, handlingUname, required,
                ValidatorConst.MAX_LENGTH_HANDLING_UNAME);
    }

    /**
     * 验证问题结案结论
     * 
     * @param handlingResult
     *            问题结案结论
     */
    protected void validateHandlingResult(String handlingResult, boolean required) {
        HandlingResult type = HandlingResult.getInstance(handlingResult);
        if (required)
            validatorRequired(FieldCode.HANDLING_RESULT, handlingResult);
        if (handlingResult != null && type == null) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.HANDLING_RESULT, FieldCode.HANDLING_RESULT, handlingResult));
        }
    }

    /**
     * 验证申请或建议结论的原因
     * 
     * @param handlingResultReason
     *            申请或建议结论的原因
     */
    protected void validateHandlingResultReason(String handlingResultReason, boolean required) {
        this.validatorMaxLength(FieldCode.HANDLING_RESULT_REASON, handlingResultReason, required,
                ValidatorConst.MAX_LENGTH_HANDLING_RESULT_REASON);
    }

}
