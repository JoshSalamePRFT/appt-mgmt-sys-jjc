package com.jjcperf.msg.msg.user;

import com.jjcperf.msg.enums.CriteriaTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserGetMessage implements Serializable  {
    static final long serialVersionUID = -4454698975132L;

    private long id;
    private CriteriaTypeEnum criteriaType;
    private String message;
}
