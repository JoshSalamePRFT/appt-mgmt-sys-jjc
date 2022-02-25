package com.jjcperf.msg.msg.user;

import com.jjcperf.msg.enums.CriteriaTypeEnum;
import com.jjcperf.userservice.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPutMessage implements Serializable {
    static final long serialVersionUID = -4454698975132L;

    private long id;
    private User user;
    private CriteriaTypeEnum criteriaType;
    private String message;
}
