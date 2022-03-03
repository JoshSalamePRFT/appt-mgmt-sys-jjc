package com.jjcperf.msg.msg.user;

import com.jjcperf.msg.enums.CriteriaTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserGetByEmailMessage {
    static final long serialVersionUID = -4454698975132L;

    private String emailAddress;

    private CriteriaTypeEnum criteriaType;
    private String message;
}
