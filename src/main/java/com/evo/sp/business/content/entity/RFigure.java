package com.evo.sp.business.content.entity;

import java.time.LocalDateTime;
import com.evo.sp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 人物表
 * </p>
 *
 * @author sgt
 * @since 2019-05-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class RFigure extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 创建时间
     */
    private String id;

    /**
     * 中文名
     */
    private String cnName;

    /**
     * 英文名
     */
    private String enName;

    /**
     * 血型
     */
    private String bloodType;

    /**
     * 身高
     */
    private Integer height;

    /**
     * 体重
     */
    private String weight;

    /**
     * 出生地
     */
    private String placeBirth;

    /**
     * 生日
     */
    private LocalDateTime birthday;

    /**
     * 职业
     */
    private String professional;

    /**
     * 毕业院校
     */
    private String graduateSchool;

    /**
     * 代表作
     */
    private String magnumOpus;

    /**
     * 成就
     */
    private String achievement;

}
